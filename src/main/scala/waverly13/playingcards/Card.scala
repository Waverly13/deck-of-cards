package waverly13.playingcards

/**
  * A single playing card, made up of its suite and face value
  * @param suite the suite of the card
  * @param face the face value of the card
  */
case class Card(suite: Suite.Value, face: Face.Value) {

  override def toString: String = face + " of " + suite

}

/**
  * Enumeration of the possible suites in a deck of cards
  */
object Suite extends Enumeration {
  type Suite = Value
  val Hearts, Spades, Clubs, Diamonds = Value
}

/**
  * Enumeration of the possible face values in a deck of cards
  */
object Face extends Enumeration {
  type Face = Value
  val Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King = Value
}