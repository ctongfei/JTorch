package jtorch.codegen

/**
 * @author Tongfei Chen
 */
object CodeGenerator {

  def memoryRegistrationStatements(memMgr: String, objs: Seq[JArgument]): Seq[String] =
    objs map { a => s"$memMgr.INSTANCE.register(${a.name}, ${a.name}.size() * ${a.jType}.elementSize();" }

  def method(jni: JMethodSignature, thisPosition: Int = 0): JMethod = {
    val Array(jniClassName, methodName) = jni.name.split('_')
    assert(jni.args(thisPosition).jType == jniClassName, s"${jni.args(thisPosition).jType} != $jniClassName")

    val returnTm = TypeMap.get(jni.returnJType)
    val tms = jni.args.map(TypeMap.get)
    val thisArg = JArgument(
      jType = jni.args(thisPosition).jType,
      name = "this"
    )
    val jniArgs = (jni.args.take(thisPosition) :+ thisArg) ++ jni.args.drop(thisPosition + 1)
    val call = s"TH.${jni.name}(${(jniArgs zip tms) map { case (a, tm) => tm.javaToJni(a.name) } mkString ", "})"
    val javaArgs = ((0 until thisPosition) ++ ((thisPosition + 1) until jni.args.length)) map { i => JArgument(
      jType = tms(i).javaType,
      name = jni.args(i).name
    )}

    JMethod(
      JMethodSignature(
        isStatic = false,
        returnJType = returnTm.javaType,
        name = methodName,
        args = javaArgs
      ),
      doc = Documentation.get(jniClassName, methodName),
      body =
        if (returnTm.javaType == "void")
          s"$call;"
        else s"return ${returnTm.jniToJava(call)};"
    )
  }

  def staticMethod(jni: JMethodSignature): JMethod = {
    val Array(jniClassName, methodName) = if (jni.name.contains('_')) jni.name.split('_') else Array("Torch", jni.name)
    val returnTm = TypeMap.get(jni.returnJType)
    val tms = jni.args.map(TypeMap.get)
    val javaArgs = jni.args zip tms map { case (a, tm) => JArgument(
      jType = tm.javaType,
      name = a.name
    )}
    val call = s"TH.${jni.name}(${jni.args zip tms map { case (a, tm) => tm.javaToJni(a.name) } mkString ", "})"

    JMethod(
      JMethodSignature(
        isStatic = true,
        returnJType = returnTm.javaType,
        name = methodName,
        args = javaArgs
      ),
      doc = Documentation.get(jniClassName, methodName),
      body =
        if (returnTm.javaType == "void")
          s"$call;"
        else s"return ${returnTm.jniToJava(call)};"
    )
  }

  def constructorFromNew(jni: JMethodSignature, memMgr: String, objs: Seq[JArgument]): JMethod = {
    val Array(jniClassName, methodName) = jni.name.split('_')
    val tm = TypeMap.get(jniClassName)

    JMethod(
      signature = JMethodSignature(
        isStatic = false,
        returnJType = "",
        name = tm.javaType,
        args = Seq()
      ),
      doc = Documentation.get(jniClassName, "new"),
      body =
        s"""this(TH.${jniClassName}_new());
           |${memoryRegistrationStatements(memMgr, objs).mkString("\n")}
         """.stripMargin
    )
  }

  def protectedConstructor(tm: TypeMap, memMgr: String, objs: Seq[JArgument]): JMethod = JMethod(
    signature = JMethodSignature(
      isStatic = false,
      returnJType = "",
      name = tm.javaType,
      args = Seq(JArgument(tm.jniType, "underlying")),
      accessLevel = "protected"
    ),
    doc = Documentation.get(tm.jniType, "protected new"),
    body =
      s"""super(${tm.jniType}.getCPtr(underlying), true);
         |${memoryRegistrationStatements(memMgr, objs).mkString("\n")}
       """.stripMargin
  )

}
