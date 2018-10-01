package waverly13.playingcards

import org.scalatest._

class DeckOfCardsTest extends FlatSpec with Matchers {

  "A deck" should "have 52 cards" in {
    val deckOfCards: DeckOfCards = new DeckOfCards()
    deckOfCards.deck.length shouldBe 52
  }

  it should "have the correct number of cards per suite" in {
    val deckOfCards: DeckOfCards = new DeckOfCards()

    var clubs: Int = 0
    var spades: Int = 0
    var hearts: Int = 0
    var diamonds: Int = 0

    for (card <- deckOfCards.deck) {
      card.suit match {
        case Suit.Clubs => clubs += 1
        case Suit.Spades => spades += 1
        case Suit.Hearts => hearts += 1
        case Suit.Diamonds => diamonds += 1
      }
    }

    clubs shouldBe 13
    spades shouldBe 13
    hearts shouldBe 13
    diamonds shouldBe 13
  }

  it should "be able to shuffle the deck" in {
    val deckOfCards: DeckOfCards = new DeckOfCards()
    val originalDeck = deckOfCards.deck.clone()
    deckOfCards.shuffle()
    val shuffledDeck = deckOfCards.deck.clone()
    originalDeck shouldNot be(shuffledDeck)
  }

  it should "result in two different shuffles when identical decks are shuffled" in {
    val deckOfCards1: DeckOfCards = new DeckOfCards()
    deckOfCards1.shuffle()
    val shuffledDeck1 = deckOfCards1.deck.clone()

    val deckOfCards2: DeckOfCards = new DeckOfCards()
    deckOfCards2.shuffle()
    val shuffledDeck2 = deckOfCards2.deck.clone()

    shuffledDeck1 shouldNot be(shuffledDeck2)
  }

  it should "be able to deal one card" in {
    val deckOfCards: DeckOfCards = new DeckOfCards()
    val card: Option[Card] = deckOfCards.dealOneCard()
    card.get.suit shouldBe Suit.Hearts
    card.get.face shouldBe Face.Ace
  }

  it should "return no card if the deck is empty" in {
    val deckOfCards: DeckOfCards = new DeckOfCards()
    for (i <- 0 to 52) {
      deckOfCards.dealOneCard()
    }
    val card = deckOfCards.dealOneCard()
    card.isEmpty shouldBe true
  }

}
