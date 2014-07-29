package org.sigix.cards;

import static org.testng.Assert.assertEquals;

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

}
