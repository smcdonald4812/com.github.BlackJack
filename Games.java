//To be used with the Table class, which has not been created yet.

interface Games {
	void setDealer();
	boolean isContainingDealer();
	void setSeatTaken();
	boolean isSeatTaken();
	void setTableFull();
	boolean isTableFull();
	void setTableId();
	long getTableId();
	void setStartRound();
	boolean isStartRound();
	void getNewShuffleCards();
	boolean isShuffled();
	void setEndRound();
	boolean isEndRound();
	void setEndOfDeck();
	boolean isEndOfDeck();
	void setCardShowing();
	boolean isCardShowing();
}
