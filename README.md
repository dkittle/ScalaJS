# ScalaJS Test

[![Build Status](https://travis-ci.org/dkittle/ScalaJS.svg?branch=master)](https://travis-ci.org/dkittle/ScalaJS)

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


### Release Notes

chapter 1
Single application
Basic page with welcome message
Table of employees/salaries
Button to regenerate table with randomized names/salaries

chapter 2
Add Selenium tests

chapter 3
Note size of app's js file
Separate into front-end/backend applications
Note new size of app's js file

chapter 4
Camera model
Featured items page

chapter 5
Store browsing
Menu generation from categories

chapter 6
Invetory management

chapter 7
Point of sale
