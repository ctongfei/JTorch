lazy val commonSettings = Seq(
  organization := "me.tongfei",
  isSnapshot := true,
  version := "0.1-TH0.4-SNAPSHOT",
  
  crossPaths := false,  // pure Java library
  autoScalaLibrary := false, // pure Java library

  publishMavenStyle := true,
  publishTo := {
    val sonatype = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at sonatype + "content/repositories/snapshots")
    else
      Some("releases"  at sonatype + "service/local/staging/deploy/maven2")
  },

  pomExtra :=
    <url>http://github.com/ctongfei/jtorch</url>
      <licenses>
        <license>
          <name>MIT</name>
          <url>http://opensource.org/licenses/MIT</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:ctongfei/jtorch.git</url>
        <connection>scm:git:git@github.com:ctongfei/jtorch.git</connection>
      </scm>
      <developers>
        <developer>
          <id>ctongfei</id>
          <name>Tongfei Chen</name>
          <url>http://tongfei.me/</url>
        </developer>
      </developers>
)

lazy val jni = (project in file("jni")).settings(commonSettings: _*).settings(
  name := "jtorch-jni"
)

lazy val java = (project in file("java")).settings(commonSettings: _*).dependsOn(jni).settings(
  name := "jtorch-java"
)

lazy val javaCuda = (project in file("java-cuda")).settings(commonSettings: _*).dependsOn(java).settings(
  name := "jtorch-java-cuda"
)

lazy val codegen = (project in file("codegen")).settings(commonSettings: _*).settings(
  name := "jtorch-codegen",
  crossPaths := true,
  autoScalaLibrary := true,
  skip in publish := true  // Do not publish this!
)
