name := "akka-http-template"

version := "0.1"

scalaVersion := "2.12.6"

resolvers += "AWS DynamoDB" at "https://s3-us-west-2.amazonaws.com/dynamodb-local/release"

libraryDependencies ++= {
  val akkaHttpVersion = "10.1.3"
  val akkaVersion = "2.5.13"
  Seq(
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe" % "config" % "1.3.2",
    "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test",
    "org.typelevel" %% "cats-core" % "1.0.0-MF",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
    "com.github.etaty" %% "rediscala" % "1.8.0",
    "org.scala-lang.modules" %% "scala-java8-compat" % "0.9.0"
  )
}