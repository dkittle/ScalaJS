# ScalaJS Test

## Starting SBT
For dev:
````
sbt ~fastOptJS
````

or for prod:
````
sbt ~fullOptJS
````

setup full in build.sbt with
````
set scalaJSStage in Global := FullOptStage
````

## Running the App

Open ```testing.html``` in a browser

