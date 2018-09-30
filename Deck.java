package com.github.BlackJack;

import java.util.ArrayList;
import java.util.Collections;

final class Deck {
	private int temp;
	private Card card;
	private final ArrayList<Card> cards = new ArrayList<Card>(52);
	
	/**
	* Constructor for a new 52 card deck.
	*
	* This constructor uses the enums SUIT and VALUE, as well as,
	* a Card class to add cards to List<Card> cards and shuffles deck.
	*/
	public Deck() {
		for(SUIT suit : SUIT.values()) {
			for(VALUE value : VALUE.values()) {
				temp = (value.ordinal() > 8 ? 10 : value.ordinal() + 1);
				cards.add(new Card(suit, value, temp));
			}
		}
		Collections.shuffle(cards);
	}
	
	/**
	* returns List<Card>.
	*/
	public ArrayList<Card> getDeck() {
		return this.cards;
	}
	
	/**
	* Return Card.
	* @param int card.
	*/
	public Card getCard(int card) {
		return this.cards.get(card);
	}
}