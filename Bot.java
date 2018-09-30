package com.github.BlackJack;

import java.util.ArrayList;

class Bot {
	private int bet, bankRoll;
	private static int count = 1;
	private String name;
	private Hand hand;
	
	public Bot() {
		this.name = "Bot " + count++;
		this.bankRoll = 10_000;
		this.bet = 0;
		this.hand = new Hand();
	}
	
	public String getName() {
	    return this.name;
	}
	
	//might want to randomize bet int inside here instead of elsewhere...
	public void setBet(int bet) {
		this.bet = bet;
	}
	
	public int getBet() {
		return bet;
	}
	
	public void setBankRoll(int bankRoll) {
		this.bankRoll = bankRoll;
	}
	
	public int getBankRoll() {
		return this.bankRoll;
	}
	
	public void newHand() {
		this.hand = new Hand();
	}
	
	public Hand getHand() {
		return this.hand;
	}
	
	public void clear() {
		this.hand.clear();
		this.bet = 0;
	}
}