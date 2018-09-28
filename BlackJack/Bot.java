import java.util.*;

public class Bot implements Beings, Bots{
	private boolean doubled, split, insured, turn, busted;
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
	public boolean isSplit() {
		return this.split;
	}
	public void setSplit(boolean split) {
		this.split = split;
	}
	public boolean isDealer() {
		return false;
	}
	public void setInsured(boolean insured) {
		this.insured = insured;
	}
	public boolean isInsured() {
	    return insured;
	}
	public void setDouble(boolean doubled) {
		this.doubled = doubled;
	}
	public boolean isDouble() {
		return doubled;
	}
	public boolean isAbleToDouble(int bet, int bankRoll) {
		if((int)(bankRoll / 2) >= bet) return true;
		return false;
	}
	public boolean isMaxBet(int bet, int bankRoll) {
		if(bet == bankRoll) return true;
		return false;
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
	public void setBet(int bet) {
		this.bet = bet;
	}
	public void setBetDouble() {
		this.bet += bet;
	}
	public int getBet() {
		return bet;
	}
	public void setBankRoll(int bankRoll) {
		this.bankRoll = bankRoll;
	}
	public int getBankRoll() {
		return this.bankRoll;
	}
	public void addHand(Hand hand) {
		this.hands.add(hand);
	}
	//removes specified hand from hands list.
	public void removeHand(int i) {
		this.hands.remove(i);
	}
	//gets hand from list.
	public Hand getHand() {
		return this.hand;
	}
	public Hand getHand(int hand) {
		return this.hands.get(hand);
	}
	public List<Hand> getHands() {
		return this.hands;
	}
	public void setClearHands() {
		this.hands.clear();
	}
	//gets a card from the hand.
	public Card getCard(int card) {
		return hand.getCard(card);
	}
}