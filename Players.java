//Players is used with the Player and Bot classes.

interface Players {
	void setBet();
	int getBet();
	void setInsured();
	boolean isInsured();
	void setDouble();
	boolean isDouble();
	boolean isAbleToDouble();
	boolean isMaxBet();
	void setBankRoll();
	int getBankRoll();
}
