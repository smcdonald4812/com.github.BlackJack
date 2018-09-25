package BlackJack;
import java.util.*;

public class Dealer implements Beings, Dealers, Bots {
	private boolean turn, busted, startBlackJack, cardShowing;
	private int total, stopValue;
	private String name;
	private final String id;
	
	public Dealer() {
		this.name = "Dealer";
		this.total = 0;
		this.turn = false;
		this.busted = false;
		this.startBlackJack = false;
		this.stopValue = 16;
		this.id = UUID.randomUUID().toString();
	}
	
	public boolean isDealer() {
		return true;
	}
	public boolean isOverStopValue() {
		if(this.total >= this.stopValue) return true;
		return false;
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
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
	    return this.name;
	}
	public String getBeingId() {
		return this.id;
	}
	public void setTotalPoints(int total) {
		this.total = total;
	}
	public int getTotalPoints() {
		return total;
	}
	public void setStopValue(int stopValue) {
		this.stopValue = stopValue;
	}
	public int getStopValue() {
		return this.stopValue;
	}
	public void setCardShowing(boolean cardShowing) {
		this.cardShowing = cardShowing;
	}
	public boolean isCardShowing() {
		return this.cardShowing;
	}
}