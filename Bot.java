import java.util.*;

public Bot extends Player implements Bots{
	private boolean doubled, insured, turn, busted;
	private int bet, bankRoll, total, stopValue;
	private static count = 0;
	private String name;
	private final String id;
	
	public Bot {
		super();
		name = "Bot " + count++;
		stopValue = 17;
	}
	
	public boolean isOverStopValue() {
		if(this.getTotal >= this.stopValue) return true;
		retun false;
	} 
	
	public void setStopValue(int stopValue) {
		this.stopValue = stopValue;
	}
	public int getStopValue() {
		return stopValue();
	}
}