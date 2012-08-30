import sbt._
import sbt.Keys._

object ProjectBuild extends Build {

  lazy val root = Project(
    id = "root",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "ssapi4s",
      organization := "me.hysa",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.9.1",
      libraryDependencies ++= Seq(
        // for HTTP
        "net.databinder" %% "dispatch-http" % "0.8.8",
        
        // test
        "org.specs2" %% "specs2" % "1.9" % "test",
        "junit" % "junit" % "4.8.1" % "test",
            
        //log
        "org.clapper" %% "grizzled-slf4j" % "0.6.8",
        "ch.qos.logback" % "logback-classic" % "1.0.1"
      )
      
      // add other settings here
    )
  )
}
