package org.sigix.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.sigix.cards.Card.Rank;
import org.sigix.cards.Card.Suit;

public class Deck {
	
	private final Random random = new Random();

	private final List<Card> cards;

	private Deck() {
		cards = new LinkedList<Card>();
	}

	public static Deck createStandardDeck() {
		Deck deck = new Deck();
		
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.cards.add(new Card(suit, rank));
			}
		}
		
		return deck;
	}

	List<Card> getCards() {
		/*
		 * Given the current set of requirements, there is no need to expose
		 * this method as public at this time - it is only used by the tests
		 */
		return Collections.unmodifiableList(cards);
	}

	public void shuffle() {
		/*
		 * Given the small size of the deck of cards we are dealing with here,
		 * I am opting for simplicity and clarity of algorithm over best
		 * theoretical run time performance or memory footprint.
		 */
		
		List<Card> temporaryList = new ArrayList<Card>(cards);
		cards.clear();
		
		while (!temporaryList.isEmpty()) {
			cards.add(temporaryList.remove(random.nextInt(temporaryList.size())));
		}
	}

	public Card dealOneCard() {
		
		if (cards.isEmpty()) {
			throw new EmptyDeckException();
		}
		
		return cards.remove(cards.size() - 1);
	}

	public boolean isEmpty() {
		return cards.isEmpty();
	}

}
