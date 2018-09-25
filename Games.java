package BlackJack;

interface Games {
	void setDealer(Dealer dealer);
	void setContainingDealer(boolean containingDealer);
	boolean isContainingDealer();
	void setTableFull(boolean tableFull);
	boolean isTableFull();
	String getTableId();
	void setStartRound(boolean startRound);
	boolean isStartRound();
	void setEndRound(boolean endRound);
	boolean isEndRound();
	void setSeatOne(Seat one);
	void setSeatTwo(Seat two);
	void setSeatThree(Seat three);
	void setSeatFour(Seat four);
	void setSeatFive(Seat five);
}