lazy val commonSettings = Seq(
  organization := "me.tongfei",
  isSnapshot := true,
  version := "0.4.0-SNAPSHOT",
  
  crossPaths := false,  // pure Java library
  autoScalaLibrary := false, // pure Java library

  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
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

lazy val jniutils = (project in file("jniutils")).settings(commonSettings: _*).settings(
  name := "jtorch-jniutils"
)

lazy val jni = (project in file("jni")).settings(commonSettings: _*).dependsOn(jniutils).settings(
  name := "jtorch-jni"
)

lazy val java = (project in file("java")).settings(commonSettings: _*).dependsOn(jni).settings(
  name := "jtorch-java"
)

lazy val codegen = (project in file("codegen")).settings(commonSettings: _*).settings(
  name := "jtorch-codegen",
  crossPaths := true,
  autoScalaLibrary := true,
  libraryDependencies += "com.lihaoyi" %% "fastparse" % "1.0.0"
)
