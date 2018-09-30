package com.github.BlackJack;

final class Card {
	private final int valueOfCard;
	private final SUIT suit;
	private final VALUE value;
	
	/**
	* Constructor for immutable Card.
	*
	*@param @NotNull SUIT suit. Is suit of card.
	*@param @NotNull VALUE value. Is number or face value of card.
	*@param @NotNull int valueOfCard. This is the value of the card.
	*/
	Card(SUIT suit, VALUE value, int valueOfCard) {
		this.suit = suit;
		this.value = value;
		this.valueOfCard = valueOfCard;
	}
	
	/**
	* returns value for calculations and display in hands.
	*/
	public VALUE getValue() {
		return this.value;
	}
	
	/**
	* returns suit for display in hands.
	*/
	public SUIT getSuit() {
		return this.suit;
	}
	
	/**
	* returns int value for calculations.
	*/
	public int getCardValue() {
		return this.valueOfCard;
	}
	
	/**
	* Return String description of card.
	*/
	public String getDescription() {
		return new String("[" + value.toString().substring(0 , 1) 
				+ value.toString().substring(1).toLowerCase() + " of " + suit.toString().substring(0 , 1) 
				+ suit.toString().substring(1).toLowerCase() + "] ");
	}
}