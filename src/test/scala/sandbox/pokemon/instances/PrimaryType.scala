package sandbox.pokemon.instances
import simulacrum.typeclass

@typeclass sealed trait PrimaryType[P <: Pokémon] {
  def primaryType(p: P): Type
}
object PrimaryType {
  implicit val instances: PrimaryType[Pokémon] = new PrimaryType[Pokémon] {
    override def primaryType(p: Pokémon): Type = p match {
      case Squirtle  => Water
      case Wartortle => Water
      case Blastoise => Water
      case Pichu     => Thunder
      case Pikachu   => Thunder
      case Raichu    => Thunder
    }
  }
}
