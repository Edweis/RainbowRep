name := """white"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)
lazy val myProject = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)
// https://mvnrepository.com/artifact/javax.persistence/persistence-api
libraryDependencies += "javax.persistence" % "persistence-api" % "1.0"
// https://mvnrepository.com/artifact/junit/junit
libraryDependencies += "junit" % "junit" % "4.4"
// https://mvnrepository.com/artifact/mysql/mysql-connector-java
libraryDependencies += "mysql" % "mysql-connector-java" % "6.0.5"
// https://mvnrepository.com/artifact/org.webjars/less-node
libraryDependencies += "org.webjars" % "less-node" % "2.5.0"
