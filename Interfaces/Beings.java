package Interfaces;

import BlackJack.*;

interface Beings {
	boolean isDealer();
	void setName(String name);
	String getName();
	String getBeingId();
	void setBusted(boolean busted);
	boolean isBusted();
	void setTurn(boolean turn);
	boolean isTurn();
	void setTotalPoints(int total);
	int getTotalPoints();
	void addHand(Hand hand);
	void removeHand(int i);
	Hand getHand();
	void setClearHands();
	Card getCard(int card);
	int getSpot();
	void setBankRoll(int i);
	int getBet();
}