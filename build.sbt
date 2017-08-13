
lazy val baseSettings = Seq(
  scalaVersion := "2.12.3",
  organization := "ikhoon",
  libraryDependencies ++= Seq(
    "com.twitter" %% "scrooge-core" % "4.18.0",
    "com.twitter" %% "finagle-thrift" % "6.45.0",
    "org.scalatest" %% "scalatest" % "3.0.1" % "test",
    "junit" % "junit" % "4.12" % "test"
  ),
  publishMavenStyle := true
)

lazy val root = (project in file("."))
  .settings(baseSettings: _*)
  .dependsOn(idl, client, server)
  .aggregate(idl, client, server)

lazy val idl = (project in file("idl"))
  .settings(baseSettings: _*)
  .settings(
    name := "idl",
    moduleName := "idl",
    scroogeLanguages in Compile := Seq("scala", "java")
  )

lazy val client = (project in file("client"))
  .settings(baseSettings: _*)
  .settings(
    name := "client",
    moduleName := "client"
  )
  .dependsOn(idl)


lazy val server = (project in file("server"))
  .settings(baseSettings: _*)
  .settings(
    name := "server",
    moduleName := "server"
  )
  .dependsOn(idl)
