enablePlugins(ScalaJSPlugin)

name := "ScalaJS"

version := "1.0"

scalaVersion := "2.11.7"

scalaJSUseRhino in Global := false

scalaJSStage in Global := FastOptStage

skip in packageJSDependencies := false

libraryDependencies ++= Seq(
  "be.doeraene" %%% "scalajs-jquery" % "0.8.1",
  "org.scalatest" % "scalatest_2.11" % "2.2.6" % "test",
  "org.seleniumhq.selenium" % "selenium-java" % "2.46.0" % "test",
  "com.codeborne" % "phantomjsdriver" % "1.2.1" % "test"
)

javaOptions += "-Dphantomjs.binary.path=/usr/local/bin/phantomjs -Dwebdriver.chrome.driver=drivers/chromedriver"
