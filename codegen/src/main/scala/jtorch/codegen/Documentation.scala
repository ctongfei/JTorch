package jtorch.codegen

/**
 * @author Tongfei Chen
 */
object Documentation {

  def get(jniClassName: String, methodName: String) = methodName match {
    case "data" => "Returns the raw C array of the underlying storage."
    case _ => ""
  }

}
