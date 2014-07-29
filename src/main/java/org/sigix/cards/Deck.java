package org.sigix.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
				deck.add(new Card(suit, rank));
			}
		}
		
		return deck;
	}

	private void add(Card card) {
		cards.add(card);
	}

	public List<Card> getCards() {
		return Collections.unmodifiableList(cards);
	}

}
