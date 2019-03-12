package sandbox.pokemon.inheritance

trait Raichu extends Pikachu {
  override def moves: List[Move[_]] = super.moves ++ List(ThunderStorm)
}
object Raichu extends Raichu

