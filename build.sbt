lazy val commonSettings = Seq(

  organization := "me.tongfei",
  version := "0.2.0-SNAPSHOT",
  isSnapshot := true,
  publishMavenStyle := true,
  crossPaths := false,
  autoScalaLibrary := false

)

lazy val cpu = (project in file("cpu")).settings(commonSettings: _*).settings(
  name := "jtorch-cpu"
)

lazy val cuda = (project in file("cuda")).settings(commonSettings: _*).settings(
  name := "jtorch-cuda"
)
