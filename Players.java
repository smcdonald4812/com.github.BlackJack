package Interfaces;

import BlackJack.*;

interface Players {
	void setBet(int bet);
	void setBetDouble();
	int getBet();
	void setInsured(boolean insured);
	boolean isInsured();
	void setDouble(boolean doubled);
	boolean isDouble();
	boolean isAbleToDouble(int bet, int bankRoll);
	boolean isMaxBet(int bet, int bankRoll);
	void setBankRoll(int bankRoll);
	int getBankRoll();
	void setSpot(int spot);
	Hand getHand();
	Hand getHand(int hand);
}