package org.sigix.cards;

import static org.testng.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.sigix.cards.Card.Rank;
import org.sigix.cards.Card.Suit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeckTest {
	
	private static final int STANDARD_DECK_CARD_COUNT = 52;
	
	private Deck standardDeck;
	
	@BeforeMethod
	public void setupFixtures() {
		standardDeck = Deck.createStandardDeck();
	}

	@Test
	public void standardDeckHasCorrectNumberOfCards() {
		//given fixtures
		
		//when
		List<Card> cards = standardDeck.getCards();
		
		//then
		assertEquals(cards.size(), STANDARD_DECK_CARD_COUNT, "Wrong number of cards in standard deck");
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
	public void shuffledDeckStillHasOneSuitOfEachRank() {
		//given
		standardDeck.shuffle();
		
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
	
	// testDealOne returns a card
	@Test
	public void dealOneReturnsACard() {
		//given fixtures
		
		//when
		Card card = standardDeck.dealOneCard();
		
		//then
		assertNotNull(card);
	}
	
	@Test
	public void dealOneRemovesCardFromDeck() {
		//given fixtures
		
		//when
		Card card = standardDeck.dealOneCard();
		
		//then
		assertFalse(standardDeck.getCards().contains(card), "Dealt card should no longer remain in the deck");
	}
	
	@Test
	public void dealOneCanBeCalledCorrectNumberOfTimesUntilDeckIsEmpty() {
		//given fixtures
		
		//when
		int count = dealAllCards(standardDeck);
		
		//then
		assertEquals(count, STANDARD_DECK_CARD_COUNT, "Expected to be able to deal " + STANDARD_DECK_CARD_COUNT + " cards from a standard deck");
	}

	
	@Test
	public void callingDealOneOnEmptyDeckResultsInException() {
		//given
		boolean caughtExpectedException = false;
		dealAllCards(standardDeck);
		
		//when
		try {
			standardDeck.dealOneCard();
		} catch (EmptyDeckException e) {
			caughtExpectedException = true;
		}
		
		//then
		assertTrue(caughtExpectedException, "Did not catch expected exception trying to deal card from empty deck");
	}

	private static int dealAllCards(Deck deck) {
		int count = 0;
		while (!deck.isEmpty()) {
			deck.dealOneCard();
			count++;
		}
		return count;
	}

}
