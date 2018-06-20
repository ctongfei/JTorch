package jtorch.codegen

import scala.io._

/**
 * Parses SWIG JNI output.
 * @author Tongfei Chen
 */
object ParseJNI extends App {

  val rxDef = "public static (\\w*) (\\w*)\\((.*)\\) \\{".r
  val rxArg = "([\\w\\.]*) (\\w*)".r

  def parse(s: String): Option[JStaticMethod] = s match {
    case rxDef(returnType, name, argsDef) => Some(JStaticMethod(
      returnType,
      name,
      argsDef split ", " filter { _ != "" } map {
        case rxArg(argType, argName) =>
          JArgument(argType, argName)
      }
    ))
    case _ => None
  }

  def defsFromJni(fn: String) = {
    val contents = Source.fromFile(fn).getLines()
    val funcDefs = contents.map(_.trim).filter(_.startsWith("public static")).toArray
    funcDefs flatMap parse
  }

  val defs = defsFromJni("jni/src/main/java/jtorch/jni/TH.java")

}
