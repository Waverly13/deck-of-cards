package waverly13.playingcards

import org.scalatest._

class DeckOfCardsTest extends FlatSpec with Matchers {

  "A deck" should "have 52 cards" in {
    val deckOfCards: DeckOfCards = new DeckOfCards()
    deckOfCards.deck.length shouldBe 52
  }

  it should "have the correct number of cards per suit" in {
    val deckOfCards: DeckOfCards = new DeckOfCards()

    var clubs: Int = 0
    var spades: Int = 0
    var hearts: Int = 0
    var diamonds: Int = 0

    deckOfCards.deck.foreach(card => card.suit match {
      case Suit.Clubs => clubs += 1
      case Suit.Spades => spades += 1
      case Suit.Hearts => hearts += 1
      case Suit.Diamonds => diamonds += 1
    })

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
    shuffledDeck.length shouldBe 52
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
    card.isDefined shouldBe true
    deckOfCards.deck.length shouldBe 51
  }

  it should "return no card if the deck is empty" in {
    val deckOfCards: DeckOfCards = new DeckOfCards()
    (0 to 51).foreach(_ => deckOfCards.dealOneCard())
    val card: Option[Card] = deckOfCards.dealOneCard()
    card shouldBe None
  }

  it should "sort a deck of cards based on face value" in {
    val deckOfCards: DeckOfCards = new DeckOfCards()
    deckOfCards.sort(deckOfCards.compareToFace)
    deckOfCards.deck.length shouldBe 52
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Spades, Face.King)
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Hearts, Face.King)
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Diamonds, Face.King)
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Clubs, Face.King)
    (0 to 43).foreach(_ => deckOfCards.dealOneCard())
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Spades, Face.Ace)
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Hearts, Face.Ace)
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Diamonds, Face.Ace)
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Clubs, Face.Ace)
  }

  it should "sort a deck of cards based on suit value" in {
    val deckOfCards: DeckOfCards = new DeckOfCards()
    deckOfCards.sort(deckOfCards.compareToSuit)
    deckOfCards.deck.length shouldBe 52
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Spades, Face.King)
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Spades, Face.Queen)
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Spades, Face.Jack)
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Spades, Face.Ten)
    (0 to 43).foreach(_ => deckOfCards.dealOneCard())
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Clubs, Face.Four)
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Clubs, Face.Three)
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Clubs, Face.Two)
    deckOfCards.dealOneCard().get shouldBe Card(Suit.Clubs, Face.Ace)
  }

}
