package sandbox.pokemon.instances
import simulacrum.typeclass

@typeclass sealed trait SecondaryType[P <: Pokémon] {
  def secondaryType(p: P): Option[Type]
}
object SecondaryType {
  implicit val instances: SecondaryType[Pokémon] = new SecondaryType[Pokémon] {
    override def secondaryType(p: Pokémon): Option[Type] = p match {
      case Squirtle  => None
      case Wartortle => None
      case Blastoise => None
      case Pichu     => None
      case Pikachu   => None
      case Raichu    => None
    }
  }
}
