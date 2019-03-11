package sandbox.pokemon.instances

trait EvolvesFrom[Evolved, Unevolved]

object EvolvesFrom {
  implicit object SquirtleEv extends
    (Squirtle.type EvolvesFrom Nothing)
  implicit object WartortleEv extends
    (Wartortle.type EvolvesFrom Squirtle.type)
  implicit object BlastoiseEv extends
    (Blastoise.type EvolvesFrom Wartortle.type)

  implicit lazy val pichuEv: EvolvesFrom[Pichu.type, Nothing] =
    new (Pichu.type EvolvesFrom Nothing) {}
  implicit lazy val pikachuEv: EvolvesFrom[Pichu.type, Pichu.type] =
    new (Pichu.type EvolvesFrom Pichu.type) {}
  implicit lazy val raichuEv: EvolvesFrom[Raichu.type, Pikachu.type] =
    new (Raichu.type EvolvesFrom Pikachu.type) {}

}
