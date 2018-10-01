package waverly13.playingcards

import org.apache.logging.log4j.scala.Logging

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
  * Holds the ordered list of cards that make up the deck
  */
class DeckOfCards() extends Logging {

  /**
    * the ordered list of cards
    */
  var deck: ArrayBuffer[Card] = ArrayBuffer()

  Suit.values.foreach(suite =>
    Face.values.foreach(face =>
      deck += Card(suite, face)
    )
  )
  logger.debug("Created a DeckOfCards")

  /**
    * Randomly reorders the deck of cards
    */
  def shuffle(): Unit = {
    val random: Random = new scala.util.Random
    val newDeck: ArrayBuffer[Card] = ArrayBuffer()
    for (i <- deck.length until 0 by -1) {
      newDeck += deck.remove(random.nextInt(i))
    }
    logger.debug("Deck shuffled")
    deck = newDeck
  }

  /**
    * Returns the card from the top of the deck
    * @return Option[Card] either the top card or None if the deck is empty
    */
  def dealOneCard(): Option[Card] = {
    try {
      logger.debug(s"One card dealt, ${deck.length} remaining")
      Some(deck.remove(0))
    } catch {
      case e: IndexOutOfBoundsException =>
        logger.info("Tried to deal a card from an empty deck", e)
        None
    }
  }

}
