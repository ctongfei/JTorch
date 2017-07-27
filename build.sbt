lazy val commonSettings = Seq(
  organization := "me.tongfei",
  isSnapshot := true,
  crossPaths := false,
  autoScalaLibrary := false,
  version := "0.1.0-SNAPSHOT",

  publishMavenStyle := true,
  publishArtifact in Test := false,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },

  pomExtra :=
    <url>http://github.com/ctongfei/JavaTorch</url>
      <licenses>
        <license>
          <name>MIT</name>
          <url>http://opensource.org/licenses/MIT</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:ctongfei/JavaTorch.git</url>
        <connection>scm:git:git@github.com:ctongfei/JavaTorch.git</connection>
      </scm>
      <developers>
        <developer>
          <id>ctongfei</id>
          <name>Tongfei Chen</name>
          <url>http://tongfei.me/</url>
        </developer>
      </developers>
)

lazy val getTorchSourceCodeTask = TaskKey[Unit]("getTorchSourceCodeTask", "Builds Torch C code.")
lazy val compileNativeTorchTask = TaskKey[Unit]("compileNativeTorch", "Compiles native Torch code.")

lazy val th = (project in file("th"))
  .settings(commonSettings: _*)
  .settings(
    name := "java-torch-th"
  )

lazy val thnn = (project in file("thnn"))
  .settings(commonSettings: _*)
  .settings(
    name := "java-torch-thnn"
  )

lazy val ths = (project in file("ths"))
  .settings(commonSettings: _*)
  .settings(
    name := "java-torch-ths"
  )

lazy val thc = (project in file("thc"))
  .settings(commonSettings: _*)
  .settings(
    name := "java-torch-thc"
  )

lazy val thcunn = (project in file("thcunn"))
  .settings(commonSettings: _*)
  .settings(
    name := "java-torch-thcunn"
  )

lazy val thcs = (project in file("thcs"))
  .settings(commonSettings: _*)
  .settings(
    name := "java-torch-thcs"
  )
