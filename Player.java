import java.util.*;

public Player implements Beings, Players{
	private boolean doubled, insured, turn, busted;
	private int bet, bankRoll, total;
	private String name;
	private final String id;
	
	public Player() {
		this.name = "Anon Y. Mous";
		this.bankRoll = 10_000;
		this.total = 0;
		this.bet = 0;
		this.doubled = false;
		this.insured = false;
		this.turn = false;
		this.busted = false;
		this.id = UUID.randomUUID().toString();
	}
	
	public Player(String name) {
		this();
		this.name = name;
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
	public void setBet(int bet) {
		this.bet = bet;
	}
	public int getBet() {
		return bet;
	}
	public void setBankRoll(int bankRoll) {
		this.bankRoll = bankRoll;
	}
	public int getBankRoll() {
		return bankRoll;
	}
}