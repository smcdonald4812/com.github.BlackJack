import java.util.*;

public class Card implements Cards {
	private boolean ace, faceCard;
	private int value;
	private final String id;
	private String suit, displayValue;
	public enum SUIT {Spades, Dimonds, Clubs, Hearts};
	public enum DISPLAY_VALUE {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, J, Q, K, A};
	
	
	Card(int value, SUIT suit, DISPLAY_VALUE displayValue) {
		super();
		this.suit = suit.toString();
		this.displayValue = displayValue.toString();
		if(this.displayValue.equals("A")) {
			this.ace = true;
		} else {
			this.ace = false;
		}
		if((this.displayValue.equals("J")) | (this.displayValue.equals("Q")) | (this.displayValue.equals("K"))) {
			this.faceCard = true;
		} else {
			this.faceCard = false;
		}
		this.value = value;
		this.id = UUID.randomUUID().toString();
	}
	
	public int getValue() {
		return this.value;
	}
	public String getDisplayValue() {
		return this.displayValue;
	}
	public String getSuit() {
		return this.suit;
	}
	public String getId() {
		return this.id;
	}
	public boolean isAce() {
		if(this.ace == true) return true;
		return false;
	}
	public boolean isFaceCard() {
		if(this.faceCard == true) return true;
		return false;
	}
}