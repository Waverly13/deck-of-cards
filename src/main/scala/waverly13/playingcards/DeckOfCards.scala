package waverly13.playingcards

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class DeckOfCards(var deck: ArrayBuffer[Card] = ArrayBuffer()) {

  for (suite <- Suite.values) {
    for (face <- Face.values) {
      val card = Card(suite, face)
      deck += card
    }
  }

  def shuffle(): Unit = {
    val random: Random = new scala.util.Random
    val newDeck: ArrayBuffer[Card] = ArrayBuffer()
    for (i <- deck.length until 0 by -1) {
      newDeck += deck.remove(random.nextInt(i))
    }
    deck = newDeck
  }

  def dealOneCard(): Option[Card] = {
    try {
      Some(deck.remove(0))
    } catch {
      case e: IndexOutOfBoundsException => None
    }
  }

}
