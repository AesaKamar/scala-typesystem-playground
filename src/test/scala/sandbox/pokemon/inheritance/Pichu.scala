package sandbox.pokemon.inheritance

trait Pichu extends Pokémon {
  override def primaryType : Type = Thunder
  override def secondaryType : Option[Type] = None
  override def moves: List[Move[_]] = Nil
}
object Pichu extends Pichu