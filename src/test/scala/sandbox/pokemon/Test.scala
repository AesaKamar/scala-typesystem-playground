package sandbox.pokemon
import org.scalatest.FreeSpec

class Test extends FreeSpec {

  "Instanced Polymorphism" in {
    import instances._

    import PrimaryType.ops._
    import SecondaryType.ops._
    import Moves.ops._

    println(
      """========================
        ||| Instanced Polymorphism
        |========================
      """.stripMargin)

    println((Blastoise : Pokémon).primaryType)
    println((Raichu : Pokémon).primaryType)
    println((Raichu : Pokémon).secondaryType)
    println((Wartortle : Pokémon).moves)
    println((Blastoise : Pokémon).moves)
    println(implicitly[Blastoise.type EvolvesFrom Wartortle.type])
    succeed
  }

  "Inheritance Polymorphism" in {
    import inheritance._

    println(
      """========================
        ||| Inheritance Polymorphism
        |========================
      """.stripMargin)

    println((new Blastoise {}).primaryType)
    println((new Raichu {}).primaryType)
    println((new Raichu {}).secondaryType)
    println((new Wartortle {}).moves)
    println((new Blastoise {}).moves)
    println((new Blastoise {}).getClass.getSuperclass.getTypeName)
    succeed
  }
}

