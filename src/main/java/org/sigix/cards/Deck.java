package org.sigix.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.sigix.cards.Card.Rank;
import org.sigix.cards.Card.Suit;

public class Deck {
	
	private final List<Card> cards;

	private Deck(int initialCapacity) {
		cards = new ArrayList<Card>(initialCapacity);
	}

	public static Deck createStandardDeck() {
		Deck deck = new Deck(52);
		
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.cards.add(new Card(suit, rank));
			}
		}
		
		return deck;
	}

	public List<Card> getCards() {
		return Collections.unmodifiableList(cards);
	}

	public void shuffle() {
		/*
		 * Given the small size of the deck of cards we are dealing with here,
		 * I am opting for simplicity and clarity of algorithm over best
		 * theoretical run time performance or memory footprint.
		 */
		
		Random random = new Random();
		
		List<Card> temporaryList = new ArrayList<Card>(cards);
		cards.clear();
		while (!temporaryList.isEmpty()) {
			cards.add(temporaryList.remove(random.nextInt(temporaryList.size())));
		}
	}

}
