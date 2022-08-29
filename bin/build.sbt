
lazy val root = (project in file("."))
  .settings(
    organization := "io.example",
    name := "user-svc",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.13.2",
    mainClass := Some("MyApp")
  )
