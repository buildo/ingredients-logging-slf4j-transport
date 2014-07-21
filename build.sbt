organization := "io.buildo"

name := "slf4j-ingredients-logging"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.0"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += "buildo" at "https://github.com/buildo/mvn/raw/master/releases"

libraryDependencies ++= Seq(
  "io.buildo" %% "ingredients-logging" % "0.2-SNAPSHOT",
  "ch.qos.logback" %  "logback-classic" % "1.1.2",
  "org.slf4j" % "slf4j-api" % "1.7.7"
)

publishTo := Some(Resolver.file("file", new File("releases")))
