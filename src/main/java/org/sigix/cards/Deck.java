package org.sigix.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private final List<Card> cards;

	private Deck(int initialCapacity) {
		cards = new ArrayList<Card>(initialCapacity);
	}

	public static Deck createStandardDeck() {
		return new Deck(52);
	}

	public List<Card> getCards() {
		return Collections.unmodifiableList(cards);
	}

}
