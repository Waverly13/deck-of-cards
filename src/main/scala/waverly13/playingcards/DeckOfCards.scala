package waverly13.playingcards

import org.apache.logging.log4j.scala.Logging

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
  * Holds the ordered list of cards that make up the deck
  */
class DeckOfCards() extends Logging {

  /**
    * The ordered list of cards
    */
  var deck: ArrayBuffer[Card] =
    Suit.values.flatMap(suit =>
      Face.values.map(face =>
        Card(suit, face)
      )
    ).to[ArrayBuffer]
  logger.debug("Created a DeckOfCards")

  /**
    * Randomly reorders the deck of cards by removing cards from the deck and placing them in a new deck
    */
  def shuffle(): Unit = {
    val random: Random = new scala.util.Random
    val newDeck: ArrayBuffer[Card] = ArrayBuffer()
    for (i <- deck.length until 0 by -1) {
      newDeck += deck.remove(random.nextInt(i))
    }
    deck = newDeck
    logger.debug(s"Deck shuffled: $deck")
  }

  /**
    * Returns the card from the top of the deck
    * @return Option[Card] either the top card or None if the deck is empty
    */
  def dealOneCard(): Option[Card] = {
    try {
      val card = Some(deck.remove(0))
      logger.debug(s"One card dealt, ${deck.length} remaining")
      card
    } catch {
      case e: IndexOutOfBoundsException =>
        // if there are no cards remaining in the deck log and return none
        // allowing the caller to determine next action
        logger.info("Tried to deal a card from an empty deck", e)
        None
    }
  }

  /**
    * Sort the deck of cards based on the comparator passed in
    * @param compare: (Card, Card) => Int the function that compare the two cards, will return 1 if the first card
    *               is greater than the second
    */
  def sort(compare: (Card, Card) => Int): Unit = quickSort(deck, 0, deck.length-1, compare)

  private def quickSort(array: ArrayBuffer[Card], left: Int, right: Int, compare: (Card, Card) => Int): ArrayBuffer[Card] = {

    def partition(partArray: ArrayBuffer[Card], left: Int, right: Int): Int = {
      val pivot = partArray(right)
      var i = left - 1

      for (j <- left until right) {
        if (compare(partArray(j), pivot) == 1) {
          // swap values around the pivot
          i += 1
          val temp = partArray(i)
          partArray(i) = partArray(j)
          partArray(j) = temp
        }
      }

      // swap the pivot
      val temp = partArray(i+1)
      partArray(i+1) = partArray(right)
      partArray(right) = temp

      i += 1
      i
    }

    if (left < right) {
      val part: Int = partition(array, left, right)
      quickSort(array, left, part-1, compare)
      quickSort(array, part+1, right, compare)
    }

    array

  }

}
