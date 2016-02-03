enablePlugins(ScalaJSPlugin)

name := "ScalaJS"

version := "1.0"

scalaVersion := "2.11.7"

scalaJSStage in Global := FastOptStage

skip in packageJSDependencies := false

libraryDependencies ++= Seq(
  "be.doeraene" %%% "scalajs-jquery" % "0.8.1"
)
