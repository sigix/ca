package org.sigix.cards;


public class Card {

	public enum Suit {
		HEARTS, SPADES, CLUBS, DIAMONDS
	}
	
	public enum Rank {
		ACE,
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING
	}
	
	private final Suit suit;
	private final Rank rank;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return rank.name() + " of " + suit.name();
	}
	
	

	

}
