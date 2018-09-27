package BlackJack;
import java.util.*;

public class Dealer implements Beings, Dealers, Bots {
	private boolean turn, busted, startBlackJack, cardShowing;
	private int total, stopValue, dealerSpot, bankRoll;
	private String name;
	private List<Hand> hands;
	private Hand hand;
	private final String id;
	
	public Dealer() {
		this.bankRoll = 10000000;
		this.name = "Dealer";
		this.total = 0;
		this.turn = false;
		this.busted = false;
		this.startBlackJack = false;
		this.stopValue = 16;
		this.dealerSpot = 6;
		this.id = UUID.randomUUID().toString();
		this.hands = new ArrayList<Hand>();
		this.hand = new Hand();
		this.hands.add(hand);
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
	public void addHand(Hand hand) {
		this.hands.add(hand);
	}
	//removes specified hand from hands list.
	public void removeHand(int i) {
		this.hands.remove(i);
	}
	//gets hand from list.
	public Hand getHand(int hand) {
		return this.hands.get(hand);
	}
	public Hand getHand() {
		return this.hand;
	}
	public void setClearHands() {
		this.hands.clear();
	}
	//gets a card from the hand.
	public Card getCard(int card) {
		return this.hand.getCard(card);
	}
	//to be used in GUI
	public void setCardShowing(boolean cardShowing) {
		this.cardShowing = cardShowing;
	}
	public boolean isCardShowing() {
		return this.cardShowing;
	}
	public int getSpot() {
		return this.dealerSpot;
	}
	public void setBankRoll(int i) {
		this.bankRoll = 100000000;
	}
	public int getBet() {
		return 0;
	}
}