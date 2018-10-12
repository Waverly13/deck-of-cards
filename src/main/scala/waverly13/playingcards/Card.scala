package waverly13.playingcards

/**
  * A single playing card, made up of its suit and face value
  * @param suit: [[waverly13.playingcards.Suit]] the suit of the card
  * @param face: [[waverly13.playingcards.Face]] the face value of the card
  */
case class Card(suit: Suit.Value, face: Face.Value) {
  // card can not have a null suit or face value
  require(suit != null, "Suit can not be null")
  require(face != null, "Face can not be null")

  /**
    * String representation of a card
    * @return String
    */
  override def toString: String = face + " of " + suit

  /**
    * Check that this card has the same face and suit as that card
    * @param that: object to be compared
    * @return Boolean true if equal, false if not
    */
  override def equals(that: Any): Boolean = {
    that match {
      case card: Card =>  this.suit == card.suit && this.face == card.face
      case _ => false
    }
  }

}

/**
  * Companion object for card, contains comparison functions
  */
object Card {

  /**
    * Compare cards based on face value first and then suit
    * @param first: Card
    * @param second: Card
    * @return Int: 0 if equal, -1 is first is less than second, 1 if first is greater than second
    */
  def compareToFace(first: Card, second: Card): Int = {
    if (first.equals(second)) 0
    else {
      if (first.face == second.face) {
        if (first.suit > second.suit) 1
        else -1
      }
      else if (first.face > second.face) 1
      else -1
    }
  }

  /**
    * Compare cards based on suit value and then face
    * @param first: Card
    * @param second: Card
    * @return Int: 0 if equal, -1 is first is less than second, 1 if first is greater than second
    */
  def compareToSuit(first: Card, second: Card): Int = {
    if (first.equals(second)) 0
    else {
      if (first.suit == second.suit) {
        if (first.face > second.face) 1
        else -1
      }
      else if (first.suit > second.suit) 1
      else -1
    }
  }

}

/**
  * Enumeration of the possible suits in a deck of cards
  */
object Suit extends Enumeration {
  type Suit = Value
  val Clubs, Diamonds, Hearts, Spades = Value
}

/**
  * Enumeration of the possible face values in a deck of cards
  */
object Face extends Enumeration {
  type Face = Value
  val Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King = Value
}