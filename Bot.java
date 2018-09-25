package BlackJack;
import java.util.*;

public class Bot extends Player implements Bots{
	private boolean doubled, insured, turn, busted;
	private int bet, bankRoll, total, stopValue;
	private static int count = 0;
	private String name;
	private final String id;
	
	public Bot() {
		super();
		this.name = "Bot " + count++;
		this.stopValue = 17;
		this.id = UUID.randomUUID().toString();
	}
	
	public boolean isOverStopValue() {
		if(this.total >= this.stopValue) return true;
		return false;
	} 
	
	public void setStopValue(int stopValue) {
		this.stopValue = stopValue;
	}
	public int getStopValue() {
		return stopValue;
	}
}