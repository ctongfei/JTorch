package jtorch.codegen

import scala.collection._

/**
 * Java method signatures.
 *
 * @author Tongfei Chen
 */
case class JArgument(jType: String, name: String) {
  override def toString = s"$jType $name"
}

case class JMethodSignature(
                             isStatic: Boolean,
                             returnJType: String,
                             name: String,
                             args: Seq[JArgument],
                             accessLevel: String = "public"
                           ) {
  override def toString = s"$accessLevel${if (isStatic) " static" else ""} $returnJType $name(${args mkString ", "})"
}

case class JMethod(signature: JMethodSignature, doc: String, body: String) {
  override def toString =
    s"""
       |    /**
       |${doc.split("\n").map("     * " + _).mkString("\n")}
       |     */
       |    $signature {
       |${body.split('\n').map("        " + _).mkString("\n")}
       |    }""".stripMargin
}

object JClass {
  val header =
    """// Generated from `jtorch.codegen`.
      |// DO NOT EDIT.""".stripMargin
}

case class JClass(name: String, baseClass: String, interfaces: mutable.Seq[String], packageName: String, doc: String, methods: mutable.Seq[JMethod]) {
  override def toString =
    s"""
       |${JClass.header}
       |
       |package jtorch.$packageName;
       |
       |import jtorch.jni.*;
       |
       |/**
       |${doc.split("\n").map(" * " + _).mkString("\n")}
       | */
       |class $name ${if (baseClass != "") s"extends $baseClass implements ${interfaces.mkString(", ")}"} {
       |${methods.mkString("\n")}
       |}
       |""".stripMargin
}
