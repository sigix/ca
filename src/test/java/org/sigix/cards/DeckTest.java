package org.sigix.cards;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

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
		assertEquals(cards.size(), 52,"Wrong number of cards in standard deck");
	}
}
