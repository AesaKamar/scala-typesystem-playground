package sandbox

import org.scalatest.FreeSpec
import simulacrum.{op, typeclass}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class Stuff {

  object TypeParameters {

    def printSomething[A](a: A): Unit = {
      val stringWithNewLine = a.toString + "\n"
      print(stringWithNewLine)
    }

    //  trait A
    sealed trait Something[A]

    sealed trait A
    sealed trait SubA extends A
    sealed trait B
    sealed trait SubB extends B

//    def ab2c[AB <: A with B](ab: AB): None.type

    trait X
    trait Y extends X
    trait Z[A]

    def f[A, B](ab: A => B): B = ???
    def g(implicit iy: Y): Y = ???

  }

  object ABCInstanced {

    sealed trait A
    sealed trait B
    sealed trait C

    sealed trait Json
    case class JsObject(kvps: (JsString, Json)*) extends Json
    case class JsString(s: String) extends Json
    case class JsNumber1[N <: Number](n: N) extends Json
    case class JsNumber2[N](n: N)(implicit numericEvidence: Numeric[N])
        extends Json
    case class JsBool(n: Boolean) extends Json

    @typeclass trait JsonEncode[A] {
      def toJson(a: A): Json
    }

    object JsonEncoderInstances {
      implicit val aJsonEncode: JsonEncode[A] = (_: A) =>
        JsObject(JsString("type") -> JsString("A"))
      implicit val bJsonEncode: JsonEncode[B] = (_: B) =>
        JsObject(JsString("type") -> JsString("B"))
      implicit val cJsonEncode: JsonEncode[C] = (_: C) =>
        JsObject(JsString("type") -> JsString("C"))
    }

    def assembleHttpRequest[T](t: T)(
      implicit evidenceACanBeJsonEncoded: JsonEncode[T]
    ): HttpRequest = ???

    type HttpRequest

    trait JsonWriteable {
      def toJson : Json
    }

  }

}

object Option {
  trait Option[A]
  object None extends Option[Nothing]
  class Some[A](a: A) extends Option[A]
}

