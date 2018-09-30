package com.github.BlackJack;

import java.util.ArrayList;

class Hand extends ArrayList<Card>{
	private int total;
	private boolean ace = false;
	
	/**
	* Return int total of cards in hand.
	*/
	public int getTotal() {
		this.total = 0;
		this.ace = false;
		for(Card c : this) {
			if(c.getValue().toString().equals("ACE")) {
				this.ace = true;
				this.total += 11;
			} else {
				this.total += c.getCardValue();
			}
			if(this.total > 21 & this.ace) {
				this.total -= 10;
				this.ace = false;
			}			
		}
		return this.total;
	}
	
	/**
	* Return String description of card.
	* @param int i. Index of card in list.
	*/
	public String getDescription(int i) {
		return this.get(i).getDescription();
	}
	
	/**
	* Prints hand.
	*/
	public void getDescriptions() {
		for(Card c : this) {
			System.out.print(c.getDescription());
		}
		System.out.println();
	}
	
	public boolean hasAce() {
		return this.ace;
	}
	
	//public Card get(int i) {
	//	return this.get(i);
	//}
}