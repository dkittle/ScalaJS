name := "scalajs"

version := "0.3"

lazy val scalaV = "2.11.8"

lazy val server = (project in file("server"))
.settings(
    scalaVersion := scalaV,
    scalaJSProjects := Seq(client),
    pipelineStages in Assets := Seq(scalaJSPipeline),
    pipelineStages := Seq(digest, gzip),
    compile in Compile <<= (compile in Compile) dependsOn scalaJSPipeline,
    libraryDependencies ++= Seq(
      ws,
      "com.lihaoyi" %%% "upickle" % "0.4.3",
      "com.vmunier" %% "scalajs-scripts" % "1.0.0",
      "org.webjars" %% "webjars-play" % "2.5.0-3",
      "org.webjars" % "bootstrap" % "3.3.7-1",
      specs2 % Test
    )
  )
.enablePlugins(PlayScala)
.dependsOn(sharedJvm)

lazy val client = (project in file("client"))
  .settings(
    scalaVersion := scalaV,
    persistLauncher := true,
    persistLauncher in Test := false,
    jsDependencies +=
      "org.webjars" % "jquery" % "2.1.3" / "2.1.3/jquery.js",
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.1",
      "com.lihaoyi" % "scalatags_sjs0.6_2.11" % "0.6.2",
      "com.lihaoyi" %%% "upickle" % "0.4.3",
      "be.doeraene" %%% "scalajs-jquery" % "0.9.1"
    )
  )
  .enablePlugins(ScalaJSPlugin, ScalaJSWeb)
  .dependsOn(sharedJs)

lazy val shared = (crossProject.crossType(CrossType.Pure) in file("shared"))
  .settings(scalaVersion := scalaV)
  .jsConfigure(_ enablePlugins ScalaJSWeb)

lazy val sharedJvm = shared.jvm
lazy val sharedJs = shared.js

// loads the server project at sbt startup
onLoad in Global := (Command
  .process("project server", _: State)) compose (onLoad in Global).value
