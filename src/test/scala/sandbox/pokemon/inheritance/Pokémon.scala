package sandbox.pokemon.inheritance

trait Pokémon {
  def primaryType: Type
  def secondaryType: Option[Type]
  def moves: List[Move[_]]
}
