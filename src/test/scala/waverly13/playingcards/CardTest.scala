package waverly13.playingcards

import org.scalatest._

class CardTest extends FlatSpec with Matchers {

  "A card" should "print correctly" in {
    val card = Card(Suit.Clubs, Face.Ace)
    card.toString shouldEqual "Ace of Clubs"
  }

  it should "be able to have all 4 suits" in {
    Card(Suit.Spades, Face.Ace).suit shouldBe Suit.Spades
    Card(Suit.Clubs, Face.Ace).suit shouldBe Suit.Clubs
    Card(Suit.Hearts, Face.Ace).suit shouldBe Suit.Hearts
    Card(Suit.Diamonds, Face.Ace).suit shouldBe Suit.Diamonds
  }

  it should "have all possible faces" in {
    Card(Suit.Spades, Face.Ace).face shouldBe Face.Ace
    Card(Suit.Spades, Face.Two).face shouldBe Face.Two
    Card(Suit.Spades, Face.Three).face shouldBe Face.Three
    Card(Suit.Spades, Face.Four).face shouldBe Face.Four
    Card(Suit.Spades, Face.Five).face shouldBe Face.Five
    Card(Suit.Spades, Face.Six).face shouldBe Face.Six
    Card(Suit.Spades, Face.Seven).face shouldBe Face.Seven
    Card(Suit.Spades, Face.Eight).face shouldBe Face.Eight
    Card(Suit.Spades, Face.Nine).face shouldBe Face.Nine
    Card(Suit.Spades, Face.Ten).face shouldBe Face.Ten
    Card(Suit.Spades, Face.Jack).face shouldBe Face.Jack
    Card(Suit.Spades, Face.Queen).face shouldBe Face.Queen
    Card(Suit.Spades, Face.King).face shouldBe Face.King
  }

  it should "throw an IllegalArgumentException if null is passed in" in {
    assertThrows[IllegalArgumentException] {
      Card(null, Face.Ace)
    }
    assertThrows[IllegalArgumentException] {
      Card(Suit.Clubs, null)
    }
  }

  it should "have an accurate equality check" in {
    // unrelated types
    Card(Suit.Spades, Face.Ace).equals(1) shouldBe false
    // same card
    Card(Suit.Clubs, Face.Ace).equals(Card(Suit.Clubs, Face.Ace)) shouldBe true
    // same suit, different face
    Card(Suit.Hearts, Face.Ace).equals(Card(Suit.Hearts, Face.Jack)) shouldBe false
    // different suit, same face
    Card(Suit.Diamonds, Face.Ace).equals(Card(Suit.Clubs, Face.Ace)) shouldBe false
    // different suit and face
    Card(Suit.Diamonds, Face.Ace).equals(Card(Suit.Clubs, Face.Five)) shouldBe false
  }

  it should "be able to compare two cards based on face and then suit value" in {
    // this is greater than that with both suit and face
    Card.compareToFace(Card(Suit.Spades, Face.King), Card(Suit.Clubs, Face.Ace)) shouldBe 1
    // this is equal to that
    Card.compareToFace(Card(Suit.Hearts, Face.Seven), Card(Suit.Hearts, Face.Seven)) shouldBe 0
    // this is greater with same suit
    Card.compareToFace(Card(Suit.Diamonds, Face.Jack), Card(Suit.Diamonds, Face.Ten)) shouldBe 1
    // this is less than with same face
    Card.compareToFace(Card(Suit.Diamonds, Face.Four), Card(Suit.Hearts, Face.Four)) shouldBe -1
    // this is less than that with both suit and face
    Card.compareToFace(Card(Suit.Diamonds, Face.Three), Card(Suit.Hearts, Face.Nine)) shouldBe -1
    Card.compareToFace(Card(Suit.Hearts, Face.Three), Card(Suit.Diamonds, Face.Nine)) shouldBe -1
  }

  it should "be able to compare two cards based on suit and then face value" in {
    // this is greater than that with both suit and face
    Card.compareToSuit(Card(Suit.Spades, Face.King), Card(Suit.Clubs, Face.Ace)) shouldBe 1
    // this is equal to that
    Card.compareToSuit(Card(Suit.Hearts, Face.Seven), Card(Suit.Hearts, Face.Seven)) shouldBe 0
    // this is greater with same suit
    Card.compareToSuit(Card(Suit.Diamonds, Face.Jack), Card(Suit.Diamonds, Face.Ten)) shouldBe 1
    // this is less than with same face
    Card.compareToSuit(Card(Suit.Diamonds, Face.Four), Card(Suit.Hearts, Face.Four)) shouldBe -1
    // this is less than that with both suit and face
    Card.compareToSuit(Card(Suit.Hearts, Face.Three), Card(Suit.Diamonds, Face.Nine)) shouldBe 1
    Card.compareToSuit(Card(Suit.Diamonds, Face.Three), Card(Suit.Hearts, Face.Nine)) shouldBe -1
  }

}
