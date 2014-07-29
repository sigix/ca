package org.sigix.cards;

import static org.testng.Assert.*;

import java.util.List;

import org.sigix.cards.Card.Rank;
import org.sigix.cards.Card.Suit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeckTest {
	
	private Deck standardDeck;
	
	@BeforeTest
	public void setupFixtures() {
		standardDeck = Deck.createStandardDeck();
	}

	@Test
	public void standardDeckHas52Cards() {
		//given fixtures
		
		//when
		List<Card> cards = standardDeck.getCards();
		
		//then
		assertEquals(cards.size(), 52, "Wrong number of cards in standard deck");
	}
	
	@Test
	public void standardDeckHasOneSuitOfEachRank() {
		//given fixtures
		
		//when
		List<Card> cards = standardDeck.getCards();
		
		//then
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(suit, rank);
				assertTrue(cards.contains(card), "Deck missing card " + card);
			}
		}
		
	}
}
