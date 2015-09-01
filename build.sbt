organization := "com.thoughtworks"

name := "rest-rpc-sample"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.6.4" % "test")


scalaVersion := "2.11.6"

libraryDependencies += "com.qifun" %% "json-stream" % "0.2.3"

libraryDependencies += "com.qifun" %% "json-stream" % "0.2.3" % Provided

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

enablePlugins(PlayScala)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
//enablePlugins(RestRpc)
