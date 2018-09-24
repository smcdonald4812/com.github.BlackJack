//this interface is used by Player, Dealer, and Bot

interface Beings {
	boolean isDealer();
	void setName();
	String getName();
	void setBeingId();
	long getBeingId();
	void setBusted();
	boolean isBusted();
	void setTurn();
	boolean isTurn();
	void setTotalPoints();
	int getTotalPoints();
}
