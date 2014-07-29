package org.sigix.cards;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.sigix.cards.Card.Rank;
import static org.sigix.cards.Card.Suit;

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

	@DataProvider
	public Object[][] provideConstructorCodesAndExpectations() {
		
		return new Object[][] {
			{"AS", Rank.ACE, Suit.SPADES},
			{"2H", Rank.TWO, Suit.HEARTS},
			{"10D", Rank.TEN, Suit.DIAMONDS},
			{"JC", Rank.JACK, Suit.CLUBS},
		};
	}
	
	@Test(dataProvider = "provideConstructorCodesAndExpectations")
	public void testCodeConstructor(String code, Rank expectedRank, Suit expectedSuit) {
		//given provided code
		
		//when
//		Card card = new Card(code);
		

		//then
//		assertEquals(card.getRank(), expectedRank, "Card has wrong rank");
//		assertEquals(card.getSuit(), expectedSuit, "Card has wrong suit");

		
	}
}
