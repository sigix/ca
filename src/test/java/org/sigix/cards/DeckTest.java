package org.sigix.cards;

import static org.testng.Assert.*;

import java.util.LinkedList;
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
	
	@Test
	public void testShuffle() {
		//given
		List<Card> originalOrder = new LinkedList<Card>(standardDeck.getCards());
		
		//when
		standardDeck.shuffle();
		
		//then
		assertNotEquals(standardDeck.getCards(), originalOrder, "Cards should have been shuffled");
		assertEquals(standardDeck.getCards().size(), originalOrder.size(), "Shuffling should not change size of deck");
	}

	@Test
	public void testReShuffle() {
		//given
		standardDeck.shuffle();
		List<Card> firstShuffleOrder = new LinkedList<Card>(standardDeck.getCards());
		
		//when
		standardDeck.shuffle();
		
		//then
		assertNotEquals(standardDeck.getCards(), firstShuffleOrder, "Cards should have been shuffled");
		assertEquals(standardDeck.getCards().size(), firstShuffleOrder.size(), "Shuffling should not change size of deck");
	}

}
