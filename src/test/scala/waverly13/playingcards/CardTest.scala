package waverly13.playingcards

import org.scalatest._

class CardTest extends FlatSpec with Matchers {

  "A card" should "print correctly" in {
      val card = Card(Suit.Clubs, Face.Ace)
      card.toString shouldEqual "Ace of Clubs"
  }

  it should "be able to have all 4 suits" in {
    val spade = Card(Suit.Spades, Face.Ace)
    val club = Card(Suit.Clubs, Face.Ace)
    val heart = Card(Suit.Hearts, Face.Ace)
    val diamond = Card(Suit.Diamonds, Face.Ace)

    spade.suit shouldBe Suit.Spades
    club.suit shouldBe Suit.Clubs
    heart.suit shouldBe Suit.Hearts
    diamond.suit shouldBe Suit.Diamonds
  }

  it should "have all possible faces" in {
    val ace = Card(Suit.Spades, Face.Ace)
    val two = Card(Suit.Spades, Face.Two)
    val three = Card(Suit.Spades, Face.Three)
    val four = Card(Suit.Spades, Face.Four)
    val five = Card(Suit.Spades, Face.Five)
    val six = Card(Suit.Spades, Face.Six)
    val seven = Card(Suit.Spades, Face.Seven)
    val eight = Card(Suit.Spades, Face.Eight)
    val nine = Card(Suit.Spades, Face.Nine)
    val ten = Card(Suit.Spades, Face.Ten)
    val jack = Card(Suit.Spades, Face.Jack)
    val queen = Card(Suit.Spades, Face.Queen)
    val king = Card(Suit.Spades, Face.King)

    ace.face shouldBe Face.Ace
    two.face shouldBe Face.Two
    three.face shouldBe Face.Three
    four.face shouldBe Face.Four
    five.face shouldBe Face.Five
    six.face shouldBe Face.Six
    seven.face shouldBe Face.Seven
    eight.face shouldBe Face.Eight
    nine.face shouldBe Face.Nine
    ten.face shouldBe Face.Ten
    jack.face shouldBe Face.Jack
    queen.face shouldBe Face.Queen
    king.face shouldBe Face.King
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
