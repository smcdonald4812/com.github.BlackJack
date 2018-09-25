package BlackJack;
import java.util.*;

public class Table implements Games{
	private Dealer dealer;
	private Random r = new Random();
	private boolean containsDealer, seatTaken, tableFull, startRound, endRound;
	private Seat one, two, three, four, five, six;
	private final String id;
	
	public Table() {
		this.id = UUID.randomUUID().toString();
		this.six = new Seat(new Dealer(), 6);
	}
	public Table(Player player) {
		this();
		double temp = r.nextDouble();
		int spot = (int)(temp * 100) % 5; 
		switch (spot) {
			case 0:
				this.one = new Seat(player, 1);
				this.two = new Seat(new Bot(), 2);
				this.three = new Seat(new Bot(), 3);
				this.four = new Seat(new Bot(), 4);
				this.five = new Seat(new Bot(), 5);
			case 1:
				this.one = new Seat(new Bot(), 1);
				this.two = new Seat(player, 2);
				this.three = new Seat(new Bot(), 3);
				this.four = new Seat(new Bot(), 4);
				this.five = new Seat(new Bot(), 5);
			case 2:
				this.one = new Seat(new Bot(), 1);
				this.two = new Seat(new Bot(), 2);
				this.three = new Seat(player, 3);
				this.four = new Seat(new Bot(), 4);
				this.five = new Seat(new Bot(), 5);
			case 3:
				this.one = new Seat(new Bot(), 1);
				this.two = new Seat(new Bot(), 2);
				this.three = new Seat(new Bot(), 3);
				this.four = new Seat(player, 4);
				this.five = new Seat(new Bot(), 5);
			case 4:
				this.one = new Seat(new Bot(), 1);
				this.two = new Seat(new Bot(), 2);
				this.three = new Seat(new Bot(), 3);
				this.four = new Seat(new Bot(), 4);
				this.five = new Seat(player, 5);
		}
	}
	
	public void setDealer(Dealer dealer) {
		this.dealer = new Dealer();
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
}