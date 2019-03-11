package sandbox.pokemon.instances

import simulacrum.typeclass

@typeclass sealed trait Moves[P <: Pokémon] {
  def moves(p: P): List[Move[_]]
}
object Moves {
  implicit val instances: Moves[Pokémon] = new Moves[Pokémon] {
    override def moves(p: Pokémon): List[Move[_]] = p match {
      case Squirtle  => WaterGun :: Nil
      case Wartortle => BubbleBeam :: moves(Squirtle)
      case Blastoise => HydroPump :: moves(Wartortle)
      case Pichu     => Nil
      case Pikachu   => ThunderBolt :: moves(Pichu)
      case Raichu    => ThunderStorm :: moves(Pikachu)
    }
  }
}
