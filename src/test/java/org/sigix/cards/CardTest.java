package org.sigix.cards;

import static org.testng.Assert.*;

import org.sigix.cards.Card.Rank;
import org.sigix.cards.Card.Suit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CardTest {


	@DataProvider
	public Object[][] provideSomeSuitsAndRanks() {
		return new Object[][] {
			{Suit.CLUBS, Rank.ACE},
			{Suit.DIAMONDS, Rank.TWO},
			{Suit.SPADES, Rank.TEN},
			{Suit.HEARTS, Rank.KING},
		};
	}
	
	@Test(dataProvider = "provideSomeSuitsAndRanks")
	public void testToString(Suit suit, Rank rank) {
		//given
		Card card = new Card(suit, rank);
		
		//when
		String result = card.toString();
		
		//then
		assertEquals(result, rank.name() + " of " + suit.name(), "Incorrect string representation for card");
		
	}
	
	@Test(dataProvider = "provideSomeSuitsAndRanks")
	public void testEqualsForSameSuitAndRank(Suit suit, Rank rank) {
		//given
		Card cardA = new Card(suit, rank);
		Card cardB = new Card(suit, rank);
		
		//when
		boolean result = cardA.equals(cardB);
		
		//then
		assertTrue(result, "Cards should have been equal");
		
	}

	@Test(dataProvider = "provideSomeSuitsAndRanks")
	public void testHashcodeForSameSuitAndRank(Suit suit, Rank rank) {
		//given
		Card cardA = new Card(suit, rank);
		Card cardB = new Card(suit, rank);
		
		//when
		int hashcodeA = cardA.hashCode();
		int hashcodeB = cardB.hashCode();
		
		//then
		assertEquals(hashcodeA, hashcodeB, "Cards should have same hashcode");
	}
	
	@Test
	public void testDifferentHashcodeForDifferentSuit() {
		//given
		Card cardA = new Card(Suit.CLUBS, Rank.EIGHT);
		Card cardB = new Card(Suit.HEARTS, Rank.EIGHT);
		
		//when
		int hashcodeA = cardA.hashCode();
		int hashcodeB = cardB.hashCode();
		
		//then
		assertNotEquals(hashcodeA, hashcodeB, "Cards should have different hashcodes");
		
	}

	@Test
	public void testDifferentSuitAreNotEqual() {
		//given
		Card cardA = new Card(Suit.CLUBS, Rank.EIGHT);
		Card cardB = new Card(Suit.HEARTS, Rank.EIGHT);
		
		//when
		boolean result = cardA.equals(cardB);
		
		//then
		assertFalse(result, "Cards should not have been equal");
				
	}

	@Test
	public void testDifferentHashcodeForDifferentRank() {
		//given
		Card cardA = new Card(Suit.DIAMONDS, Rank.QUEEN);
		Card cardB = new Card(Suit.DIAMONDS, Rank.KING);
		
		//when
		int hashcodeA = cardA.hashCode();
		int hashcodeB = cardB.hashCode();
		
		//then
		assertNotEquals(hashcodeA, hashcodeB, "Cards should have different hashcodes");
		
	}

	@Test
	public void testDifferentRankAreNotEqual() {
		//given
		Card cardA = new Card(Suit.SPADES, Rank.THREE);
		Card cardB = new Card(Suit.SPADES, Rank.TEN);
		
		//when
		boolean result = cardA.equals(cardB);
		
		//then
		assertFalse(result, "Cards should not have been equal");
				
	}
}
