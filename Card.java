import java.util.*;

public Card implements Cards {
	private boolean ace, faceCard;
	private int value;
	private final id;
	public final enum SUIT {Spades, Dimonds, Clubs, Hearts};
	public final enum DISPLAY_VALUE {2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A};
	
	public Card(int value, enum SUIT, enum DISPLAY_NAME) {
		super();
		this.SUIT = SUIT;
		this.DISPLAY_VALUE = DISPLAY_VALUE;
		if(this.DISPLAY_VALUE == A) {
			this.ace = true;
		} else {
			this.ace = false;
		}
		if((this.DISPLAY_NAME == J) | (this.DISPLAY_NAME == Q) | (this.DISPLAY_NAME == K)) {
			this.faceCard = true;
		} else {
			this.faceCard = false;
		}
		this.value = value;
		this.id = UUID.randomUUID().toString();
	}
	
	public void SetValue(int value) {
		this.value = value;
	}
	public int GetValue() {
		return value;
	}
	public void setDiplayValue(enum DISPLAY_VALUE) {
		this.DISPLAY_VALUE = DISPLAY_VALUE;
	}
	public String getDisplayValue() {
		return DISPLAY_VALUE.toString();
	}
	public void setSuit(enum SUIT) {
		this.SUIT = SUIT;
	}
	public String getSuit() {
		return SUIT.toString();
	}
	public String getId() {
		return id;
	}
	public void isAce() {
		if(this.ace == true) return true;
		return false;
	}
	public void isFaceCard() {
		if(this.faceCard == true) return true;
		return false;
	}
}