package waverly13.playingcards

import org.scalatest._

class CardTest extends FlatSpec with Matchers {

  "A card" should "print correctly" in {
      val card = Card(Suite.Clubs, Face.Ace)
      card.toString shouldEqual "Ace of Clubs"
  }

  it should "be able to have all 4 suites" in {
    val spade = Card(Suite.Spades, Face.Ace)
    val club = Card(Suite.Clubs, Face.Ace)
    val heart = Card(Suite.Hearts, Face.Ace)
    val diamond = Card(Suite.Diamonds, Face.Ace)

    spade.suite shouldBe Suite.Spades
    club.suite shouldBe Suite.Clubs
    heart.suite shouldBe Suite.Hearts
    diamond.suite shouldBe Suite.Diamonds
  }

  it should "have all possible faces" in {
    val ace = Card(Suite.Spades, Face.Ace)
    val two = Card(Suite.Spades, Face.Two)
    val three = Card(Suite.Spades, Face.Three)
    val four = Card(Suite.Spades, Face.Four)
    val five = Card(Suite.Spades, Face.Five)
    val six = Card(Suite.Spades, Face.Six)
    val seven = Card(Suite.Spades, Face.Seven)
    val eight = Card(Suite.Spades, Face.Eight)
    val nine = Card(Suite.Spades, Face.Nine)
    val ten = Card(Suite.Spades, Face.Ten)
    val jack = Card(Suite.Spades, Face.Jack)
    val queen = Card(Suite.Spades, Face.Queen)
    val king = Card(Suite.Spades, Face.King)

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

}
