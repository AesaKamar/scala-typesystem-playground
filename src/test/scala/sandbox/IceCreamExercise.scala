package sandbox
import org.scalatest.FreeSpec
import simulacrum.typeclass

import scala.concurrent.Future
import scala.concurrent.ExecutionContext

object IceCreamExercise extends FreeSpec {
  import ExecutionContext.Implicits.global

  /************************************************
    * ADT declarations
    **********************************************/
  trait IceCream
  object Mango extends IceCream
  object Chocolate extends IceCream
  object Pistachio extends IceCream
  object Vanilla extends IceCream
  object Strawberry extends IceCream

  trait Opinion
  object Good extends Opinion
  object Bad extends Opinion

  /************************************************
    * Typeclass declarations
    **********************************************/
  @typeclass trait Opinionated[A] {
    def opinion(a: A): Opinion
  }
  @typeclass trait Healthiness[A] {
    def calories(a: A): Int
  }

  /************************************************
    * Typeclass instances
    **********************************************/
  object IceCream
      extends Opinionated.ToOpinionatedOps
      with Healthiness.ToHealthinessOps {

    implicit val iceCreamOpinion: Opinionated[IceCream] = {
      case Mango      => Good
      case Chocolate  => Bad
      case Pistachio  => Good
      case Vanilla    => Good
      case Strawberry => Bad
    }

    implicit val iceCreamHealth: Healthiness[IceCream] = {
      case Mango      => 100
      case Chocolate  => 200
      case Pistachio  => 200
      case Vanilla    => 200
      case Strawberry => 100
    }
  }

  /************************************************
    * Functions with Typeclass Constraints
    **********************************************/
  def tellYourFriendsDesugared[A](
    a: A
  )(implicit evidenceAIsOpinionated: Opinionated[A]): Future[Unit] =
    Future(println(s"$a is ${evidenceAIsOpinionated.opinion(a)}"))

  import Opinionated.ops._
  def tellYourFriendsSugared[A: Opinionated](a: A): Future[Unit] =
    Future(println(s"$a is ${a.opinion}"))

  /************************************************
    * Usage sites
    **********************************************/
  "Icecream should be opinionated" in {

    (Mango: IceCream).opinion

    val cone: IceCream = Chocolate
    cone.calories
    cone.calories

    tellYourFriendsDesugared(Pistachio: IceCream)
    tellYourFriendsSugared(Pistachio: IceCream)
  }

}
