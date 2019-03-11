package sandbox.pokemon.instances

sealed trait Move[T <: Type]
case object WaterGun extends Move[Water.type]
case object BubbleBeam extends Move[Water.type]
case object HydroPump extends Move[Water.type]
case object ThunderBolt extends Move[Thunder.type]
case object ThunderStorm extends Move[Thunder.type]
