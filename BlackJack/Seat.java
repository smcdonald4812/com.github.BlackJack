import java.util.*;

public class Seat {
	private String b;
	private boolean seatTaken, containsBot, containsDealer, containsPlayer;
	private final String id;
	private int seatNumber;
	private Beings being;
	private Player player;
	private Bot bot;
	private Dealer dealer;
	
	public Seat() {
		this.id = UUID.randomUUID().toString();
		this.b = "";
		this.seatNumber = -1;
		this.seatTaken = false;
		this.containsBot = false;
		this.containsPlayer = false;
		this.containsDealer = false;
	}
	public Seat(Player player, int seatNumber) {
		this();
		this.b = player.getName();
		this.player = player;
		this.being = player;
		this.seatTaken = true;
		this.seatNumber = seatNumber;
		this.containsPlayer = true;
	}
	public Seat(Dealer dealer, int seatNumber) {
		this();
		this.b = dealer.getName();
		this.dealer = dealer;
		this.being = dealer;
		this.seatTaken = true;
		this.seatNumber = seatNumber;
		this.containsDealer = true;
	}
	public Seat(Bot bot, int seatNumber) {
		this();
		this.b = bot.getName();
		this.bot = bot;
		this.being = bot;
		this.seatTaken = true;
		this.seatNumber = seatNumber;
		this.containsBot = true;
		
	}
	
	public boolean isBot() {
		return this.containsBot;
	}
	public boolean isPlayer() {
		return this.containsPlayer;
	}
	public boolean isDealer() {
		return this.containsDealer;
	}
	public void setSeat(Beings being, String b, int seatNumber) {
		this.b = b;
		this.seatTaken = true;
		if(being instanceof Bot) this.containsBot = true;
		else this.containsBot = false;
		if(being instanceof Dealer) this.containsDealer = true;
		else this.containsDealer = false;
		if(being instanceof Player) this.containsPlayer = true;
		else this.containsPlayer = false;
		this.seatNumber = seatNumber;
	}
	public Beings getBeing() {
		return this.being;
	}
	public Player getPlayer() {
		return this.player;
	}
	public Bot getBot() {
		return this.bot;
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