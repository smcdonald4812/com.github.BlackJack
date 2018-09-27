package BlackJack;

import java.util.*;
import Interfaces.*;

public class Bot extends Player implements Bots{
	private boolean doubled, insured, turn, busted;
	private int bet, bankRoll, total, stopValue, botSpot;
	private static int count = 0;
	private String name;
	private List<Hand> hands;
	private Hand hand;
	private final String id;
	
	public Bot() {
		super();
		this.name = "Bot " + count++;
		this.stopValue = 17;
		this.id = UUID.randomUUID().toString();
		this.hands = new ArrayList<Hand>();
		this.hand = new Hand();
		this.hands.add(hand);
	}
	public Bot(int spot) {
		this();
		this.botSpot = spot;
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
	public int getSpot() {
		return this.botSpot;
	}
	public void setSpot(int spot) {
		this.botSpot = spot;
	}
}