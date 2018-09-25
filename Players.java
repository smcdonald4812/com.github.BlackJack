package BlackJack;

interface Players {
	void setBet(int bet);
	int getBet();
	void setInsured(boolean insured);
	boolean isInsured();
	void setDouble(boolean doubled);
	boolean isDouble();
	boolean isAbleToDouble(int bet, int bankRoll);
	boolean isMaxBet(int bet, int bankRoll);
	void setBankRoll(int bankRoll);
	int getBankRoll();
}