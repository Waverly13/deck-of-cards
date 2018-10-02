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

}
