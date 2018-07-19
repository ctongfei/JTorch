package jtorch.codegen

/**
 * @author Tongfei Chen
 */
trait TypeMap {
  def jniType: String
  def javaType: String
  def jniToJava(s: String): String
  def javaToJni(s: String): String
}

object TypeMap {

  val primitiveTypes = Seq("byte", "char", "short", "int", "long", "float", "double") map { t => new TypeMap {
    def jniType = t
    def javaType = t
    def jniToJava(s: String) = s
    def javaToJni(s: String) = s
  }}

  object BoolAsInt extends TypeMap {
    def jniType = "int"
    def javaType = "boolean"
    def jniToJava(s: String) = s"$s != 0"
    def javaToJni(s: String) = s"$s ? 1 : 0"
  }

  val torchNameToJava = Map(
    "Byte" -> "UByte",
    "Char" -> "Byte",
    "Short" -> "Short",
    "Int" -> "Int",
    "Long" -> "Long",
    //"Half" -> "Half",
    "Float" -> "Float",
    "Double" -> "Double"
  )

  val swigArrays = Map(
    "SWIGTYPE_p_byte" -> "CUInt8Array",
    "SWIGTYPE_p_short" -> "CInt16Array",
    "SWIGTYPE_p_int" -> "CInt32Array",
    "SWIGTYPE_p_long" -> "CInt64Array",
    "SWIGTYPE_p_float" -> "CFloatArray",
    "SWIGTYPE_p_double" -> "CDoubleArray"
  )

  val primitivePtrTypes = swigArrays map { case (swigType, wrapperType) => new TypeMap {
    def jniType = swigType
    def javaType = wrapperType
    def jniToJava(s: String) = s"$wrapperType.frompointer($s)"
    def javaToJni(s: String) = s"$s.cast()"
  }}

  val cpuStorageTypes = torchNameToJava.map { case (cType, jType) => new TypeMap {
    def jniType = s"TH${cType}Storage"
    def javaType = s"${jType}Storage"
    def jniToJava(s: String) = s"new ${jType}Storage($s)"
    def javaToJni(s: String) = s
  }}

  val cpuTensorTypes = torchNameToJava.map { case (cType, jType) => new TypeMap {
    def jniType = s"TH${cType}Tensor"
    def javaType = s"${jType}Tensor"
    def jniToJava(s: String) = s"new ${jType}Tensor($s)"
    def javaToJni(s: String) = s
  }}

  object DescBuff extends TypeMap {
    def jniType = "THDescBuff"
    def javaType = "DescBuff"
    def jniToJava(s: String) = s"new DescBuff($s)"
    def javaToJni(s: String) = s
  }

  val all: Map[String, TypeMap] = (
    primitiveTypes ++
    primitivePtrTypes ++
    cpuStorageTypes ++
    cpuTensorTypes :+
    DescBuff
  ).map { tm => tm.jniType -> tm }.toMap

  class Trivial(t: String) extends TypeMap {
    def jniType = t
    def javaType = t
    def jniToJava(s: String) = s
    def javaToJni(s: String) = s
  }

  def get(t: String) = all.getOrElse(t, new Trivial(t))

  def get(t: JArgument) = all.getOrElse(t.jType, new Trivial(t.jType))

}
