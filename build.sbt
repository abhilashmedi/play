name := """Play-StudyGroup"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.12.2"

libraryDependencies += guice
libraryDependencies += "com.typesafe.play" %% "play-ebean" % "4.1.0"
libraryDependencies += "org.avaje.ebean" % "ebean" % "8.4.1" % "provided"
libraryDependencies += "org.avaje" % "ebean" % "2.8.1"
libraryDependencies += javaJdbc
libraryDependencies += "net.sourceforge.jtds" % "jtds" % "1.3.1"