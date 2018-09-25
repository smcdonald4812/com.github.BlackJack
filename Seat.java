import java.util.*;

public Seat {
	private String b;
	private boolean seatTaken, containsBot, containsDealer, containsPlayer;
	private final String id;
	private int seatNumber;
	
	public Seat() {
		this.id = UUID.randomUUID().toString();
		this.b = "";
		this.seatNumber = -1;
		this.seatTaken = false;
		this.containsBot = false;
		this.containsPlayer = false;
		this.containsDealer = false;
	}
	//b is a Being instance.getName()
	public Seat(Being being, int seatNumber) {
		this();
		this.b = being.getName();
		this.seatTaken = true;
		this.seatNumber = seatNumber;
		//not sure if this will work, but trying to set bools based on type of instance
		if(being instanceOf Bot) this.containsBot = true;
		else this.containsBot = false;
		if(being instanceOf Dealer) this.containsDealer = true;
		else this.containsDealer = false;
		if(being instanceOf Player) this.containsPlayer = true;
		else this.containsPlayer = false;
	}
	
	public boolean isBot() {
		return this.containsBot;
	}
	public boolean isPlayer() {
		return this.containsPlayer;
	}
	public boolean isDealer() {
		return this.containsDealer
	}
	public void setSeat(Being being, String b, int seatNumber) {
		this.b = b;
		this.seatTaken = true;
		//still not sure if this will work
		if(being instanceOf Bot) this.containsBot = true;
		else this.containsBot = false;
		if(being instanceOf Dealer) this.containsDealer = true;
		else this.containsDealer = false;
		if(being instanceOf Player) this.containsPlayer = true;
		else this.containsPlayer = false;
		this.seatNumber = seatNumber;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public String getDisplayName() {
		return this.b;
	}
	public boolean isSeatTaken() {
		return this.seatTaken;
	}
}