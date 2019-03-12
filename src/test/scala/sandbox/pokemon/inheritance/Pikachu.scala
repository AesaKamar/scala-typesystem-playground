package sandbox.pokemon.inheritance

trait Pikachu extends Pichu {
  override def moves: List[Move[_]] = super.moves ++ List(ThunderBolt)
}
object Pikachu extends Pikachu