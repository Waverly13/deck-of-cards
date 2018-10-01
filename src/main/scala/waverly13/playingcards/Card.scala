package waverly13.playingcards

/**
  * A single playing card, made up of its suit and face value
  * @param suit: [[waverly13.playingcards.Suit]] the suite of the card
  * @param face: [[waverly13.playingcards.Card]] the face value of the card
  */
case class Card(suit: Suit.Value, face: Face.Value) {

  override def toString: String = face + " of " + suit

}

/**
  * Enumeration of the possible suites in a deck of cards
  */
object Suit extends Enumeration {
  type Suit = Value
  val Hearts, Spades, Clubs, Diamonds = Value
}

/**
  * Enumeration of the possible face values in a deck of cards
  */
object Face extends Enumeration {
  type Face = Value
  val Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King = Value
}