package jtorch.codegen

/**
 * Java method signatures.
 * @author Tongfei Chen
 */
case class JArgument(jType: String, name: String) {
  override def toString = s"$jType $name"
}
case class JStaticMethod(returnJType: String, name: String, args: Seq[JArgument]) {
  override def toString = s"public static $returnJType $name(${args mkString ", "})"
}
