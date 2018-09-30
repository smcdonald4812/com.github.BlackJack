package com.github.BlackJack;

import java.util.ArrayList;

class Player{
	private boolean split = false;
	private int bet, bankRoll;
	private String name;
	private ArrayList<Hand> hands = new ArrayList<Hand>(2);
	
	public Player(String name) {
		this.name = name;
		this.bankRoll = 10_000;
		this.bet = 0;
		this.hands.add(new Hand());
	}
	
	public String getName() {
	    return this.name;
	}
	
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
	
	public void addHand() {
		this.hands.add(new Hand());
	}
	
	public ArrayList<Hand> getHands() {
		return this.hands;
	}
	
	public Hand getHand() {
		return this.hands.get(0);
	}
	
	public Hand getHand(int hand) {
		return this.hands.get(hand);
	}
	
	public void clear() {
		this.hands.clear();
		this.split = false;
		this.bet = 0;
	}
	
	public void setSplit(boolean split) {
		this.split = split;
	}
	
	public boolean getSplit() {
		return this.split;
	}
}