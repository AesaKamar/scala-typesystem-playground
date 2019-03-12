package sandbox.pokemon.inheritance

trait Wartortle extends Squirtle {
  override def moves: List[Move[_]] = super.moves ++ List(BubbleBeam)
}
object Wartortle extends Wartortle