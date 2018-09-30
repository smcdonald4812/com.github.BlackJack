package com.github.BlackJack;

import java.util.ArrayList;

class Dealer {
	private boolean busted;
	private String name;
	private Hand hand;
	
	public Dealer() {
		this.name = "Dealer";
		this.hand = new Hand();
		this.busted = false;
	}
	
	public String getName() {
	    return this.name;
	}
	
	public void newHand() {
		this.hand = new Hand();
	}
	
	public Hand getHand() {
		return this.hand;
	}
	
	public void clear() {
		this.hand.clear();
	}
}