name := "cats-sandbox"
version := "0.0.1-SNAPSHOT"

scalaVersion := "2.12.7"

scalacOptions ++= Seq(
  "-encoding", "UTF-8",   // source files are in UTF-8
  "-deprecation",         // warn about use of deprecated APIs
  "-unchecked",           // warn about unchecked type parameters
  "-feature",             // warn about misused language features
  "-language:higherKinds",// allow higher kinded types without `import scala.language.higherKinds`
  "-language:implicitConversions",
  "-Xlint",               // enable handy linter warnings
  "-Xlog-implicits",
  "-Ypartial-unification",// allow the compiler to unify type constructors of different arities
  "-nowarn"               // allow me to be lazy for the sake of examples
)

libraryDependencies += "org.typelevel" %% "cats-core" % "1.4.0"
libraryDependencies += "com.github.mpilquist" %% "simulacrum" % "0.14.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies +=   "org.scalaz" %% "deriving-macro" % "1.0.0"


addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3")
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
addCompilerPlugin("org.scalaz" %% "deriving-plugin" % "1.0.0")

