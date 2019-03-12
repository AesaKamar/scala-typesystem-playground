package sandbox.pokemon.inheritance

trait Blastoise extends Wartortle {
  override def moves: List[Move[_]] = super.moves ++ List(HydroPump)
}
object Blastoise extends Blastoise
