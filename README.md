slf4j Transport
===================================

A slf4j Transport for [Ingredients Logging](https://github.com/buildo/ingredients-logging)

## Prerequisites
 
  - Scala 2.11
  - [Ingredients Logging](https://github.com/buildo/ingredients-logging)
  
## Install
Add the _buildo_ resolver and the dependency to your `build.sbt`

```scala
resolvers += "buildo" at "https://github.com/buildo/mvn/raw/master/releases"
libraryDependencies += "io.buildo" %% "ingredients-logging-slf4j-transport" % "0.1-SNAPSHOT"
```
