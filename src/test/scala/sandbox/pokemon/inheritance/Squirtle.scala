package sandbox.pokemon.inheritance

trait Squirtle extends Pokémon {
  def primaryType : Type = Water
  def secondaryType : Option[Type] = None

  override def moves: List[Move[_]] = List(WaterGun)
}
object Squirtle extends Squirtle