package sandbox

object ExtendedGenericTypes {
  // Encoding for "A is not a subtype of B"
  trait <:!<[A, B]

  // Uses ambiguity to rule out the cases we're trying to exclude
  implicit def nsub[A, B]: A <:!< B = null
  implicit def nsubAmbig1[A, B >: A]: A <:!< B = null
  implicit def nsubAmbig2[A, B >: A]: A <:!< B = null

  // Type alias for context bound
  type |¬|[T] = {
    type λ[U] = U <:!< T
  }

}