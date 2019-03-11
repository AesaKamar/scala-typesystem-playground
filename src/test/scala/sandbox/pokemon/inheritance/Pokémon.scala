package sandbox.pokemon.inheritance

sealed trait Pokémon {
  def primaryType: Type
  def secondaryType: Option[Type]
  def moves: List[Move[_]]
}

trait Squirtle extends Pokémon {
  def primaryType : Type = Water
  def secondaryType : Option[Type] = None

  override def moves: List[Move[_]] = List(WaterGun)
}
object Squirtle extends Squirtle

trait Wartortle extends Squirtle {
  override def moves: List[Move[_]] = super.moves ++ List(BubbleBeam)
}
object Wartortle extends Wartortle

trait Blastoise extends Wartortle {
  override def moves: List[Move[_]] = super.moves ++ List(HydroPump)
}
object Blastoise extends Blastoise

trait Pichu extends Pokémon {
  override def primaryType : Type = Thunder
  override def secondaryType : Option[Type] = None
  override def moves: List[Move[_]] = Nil
}
object Pichu extends Pichu

trait Pikachu extends Pichu {
  override def moves: List[Move[_]] = super.moves ++ List(ThunderBolt)
}
object Pikachu extends Pikachu

trait Raichu extends Pikachu {
  override def moves: List[Move[_]] = super.moves ++ List(ThunderStorm)
}
object Raichu extends Raichu

