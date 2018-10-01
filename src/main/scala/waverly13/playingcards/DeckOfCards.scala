package waverly13.playingcards

import org.apache.logging.log4j

import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
  * Holds the ordered list of cards that make up the deck
  * @param deck: ListBuffer[Card] the ordered list of cards
  */
class DeckOfCards(var deck: ListBuffer[Card] = ListBuffer()) {

  private val log = log4j.LogManager.getLogger(getClass.getName)

  for (suite <- Suit.values) {
    for (face <- Face.values) {
      val card = Card(suite, face)
      deck += card
    }
  }
  log.debug("Created a DeckOfCards")

  /**
    * Randomly reorders the deck of cards
    */
  def shuffle(): Unit = {
    val random: Random = new scala.util.Random
    val newDeck: ListBuffer[Card] = ListBuffer()
    for (i <- deck.length until 0 by -1) {
      newDeck += deck.remove(random.nextInt(i))
    }
    log.debug("Deck shuffled")
    deck = newDeck
  }

  /**
    * Returns the card from the top of the deck
    * @return Option[Card] either the top card or None if the deck is empty
    */
  def dealOneCard(): Option[Card] = {
    try {
      log.debug(s"One card dealt, ${deck.length} remaining")
      Some(deck.remove(0))
    } catch {
      case e: IndexOutOfBoundsException =>
        log.info("Tried to deal a card from an empty deck", e)
        None
    }
  }

}
