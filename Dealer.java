import java.util.*;

public Dealer implements Beings, Dealers, Bots {
	private boolean turn, busted, startBlackJack;
	private int total, stopValue;
	private String name;
	private final String id;
	
	public Dealer() {
		name = "Dealer";
		total = 0;
		turn = false;
		busted = false;
		startBlackJack = false;
		stopValue = 16;
		id = UUID.randomUUID().toString();
	}
	
	public boolean isDealer() {
		return true;
	}
	public boolean isOverStopValue() {
		if(this.getTotal >= this.stopValue) return true;
		retun false;
	}
	public void setStartBlackJack(boolean startBlackJack) {
		this.startBlackJack = startBlackJack;
	}
	public boolean isStartBlackJack() {
		return startBlackJack;
	}
	public void setBusted(boolean busted) {
		this.busted = busted;
	}
	public boolean isBusted() {
		return busted;
	}
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	public boolean isTurn() {
		return turn;
	}
	
	public String getName() {
	    this.name;
	}
	public String getBeingId() {
		return this.id;
	}
	public void setTotalPoints(int points) {
		this.points = points;
	}
	public int getTotalPoints() {
		return points;
	}
	public void setStopValue(int stopValue) {
		this.stopValue = stopValue;
	}
	public int getStopValue() {
		return this.stopValue;
	}
}