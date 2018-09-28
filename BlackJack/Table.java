import java.util.*;

public class Table implements Tables{
	private Dealer dealer;
	private Random r = new Random();
	private boolean containsDealer, seatTaken, tableFull, startRound, endRound;
	private Seat one, two, three, four, five, six;
	private List<Seat> seats = new ArrayList<Seat>();
	private final String id;
	private int playerSpot;
	private Player player;
	private Bot b1, b2, b3, b4;
	
	public Table() {
		this.id = UUID.randomUUID().toString();
		this.dealer = new Dealer();
		this.six = new Seat(dealer, 6);
	}
	public Table(Player player) {
		this();
		this.player = player;
		double temp = r.nextDouble();
		int spot = (int)(temp * 100) % 5; 
		switch (spot) {
			case 0:
				this.one = new Seat(player, 1);
				player.setSpot(1);
				this.b1 = new Bot(2);
				this.b2 = new Bot(3);
				this.b3 = new Bot(4);
				this.b4 = new Bot(5);
				this.two = new Seat(b1, 2);
				this.three = new Seat(b2, 3);
				this.four = new Seat(b3, 4);
				this.five = new Seat(b4, 5);
				break;
			case 1:
				this.b1 = new Bot(1);
				this.b2 = new Bot(3);
				this.b3 = new Bot(4);
				this.b4 = new Bot(5);
				this.one = new Seat(b1, 1);
				this.two = new Seat(player, 2);
				player.setSpot(2);
				this.three = new Seat(b2, 3);
				this.four = new Seat(b3, 4);
				this.five = new Seat(b4, 5);
				break;
			case 2:
				this.b1 = new Bot(2);
				this.b2 = new Bot(1);
				this.b3 = new Bot(4);
				this.b4 = new Bot(5);
				this.one = new Seat(b2, 1);
				this.two = new Seat(b1, 2);
				this.three = new Seat(player, 3);
				player.setSpot(3);
				this.four = new Seat(b3, 4);
				this.five = new Seat(b4, 5);
				break;
			case 3:
				this.b1 = new Bot(2);
				this.b2 = new Bot(1);
				this.b3 = new Bot(3);
				this.b4 = new Bot(5);
				this.one = new Seat(b2, 1);
				this.two = new Seat(b1, 2);
				this.three = new Seat(b3, 3);
				this.four = new Seat(player, 4);
				player.setSpot(4);
				this.five = new Seat(b4, 5);
				break;
			case 4:
				this.b1 = new Bot(2);
				this.b2 = new Bot(1);
				this.b3 = new Bot(3);
				this.b4 = new Bot(4);
				this.one = new Seat(b2, 1);
				this.two = new Seat(b1, 2);
				this.three = new Seat(b3, 3);
				this.four = new Seat(b4, 4);
				this.five = new Seat(player, 5);
				player.setSpot(5);
		}
		this.seats.add(one);
		this.seats.add(two);
		this.seats.add(three);
		this.seats.add(four);
		this.seats.add(five);
		this.seats.add(six);
	}
	
	public void setDealer() {
		this.dealer = new Dealer();
	}
	public Dealer getDealer() {
		return this.dealer;
	}
	public void setContainingDealer(boolean containsDealer) {
		this.containsDealer = containsDealer;
	}
	public boolean isContainingDealer() {
		return this.containsDealer;
	}
	public void setTableFull(boolean tableFull) {
		this.tableFull = tableFull;
	}
	public boolean isTableFull() {
		return tableFull;
	}
	public String getTableId() {
		return id;
	}
	public void setStartRound(boolean startRound) {
		this.startRound = startRound;
	}
	public boolean isStartRound() {
		return startRound;
	}
	public void setEndRound(boolean endRound) {
		this.endRound = endRound;
	}
	public boolean isEndRound() {
		return endRound;
	}
	public Seat getSeat(int i) {
		return this.seats.get(i);
	}
	public void setSeatOne(Seat one) {
		this.one = one;
	}
	public void setSeatOne() {
		this.one = null;
	}
	public void setSeatTwo(Seat two) {
		this.two = two;
	}
	public void setSeatTwo() {
		this.two = null;
	}
	public void setSeatThree(Seat three) {
		this.three = three;
	}
	public void setSeatThree() {
		this.three = null;
	}
	public void setSeatFour(Seat four) {
		this.four = four;
	}
	public void setSeatFour() {
		this.four = null;
	}
	public void setSeatFive(Seat five) {
		this.five = five;
	}
	public void setSeatFive() {
		this.five = null;
	}
	public List<Seat> getList() {
		return this.seats;
	}
}