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

  case class Primitive(javaType: String) extends TypeMap {
    def jniType = javaType
    def jniToJava(s: String) = s
    def javaToJni(s: String) = s
  }

}
