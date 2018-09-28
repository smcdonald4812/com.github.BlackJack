import java.util.*;
import java.util.stream.*;

public class BotRound implements Rounds {
	private int total;
	private final String id;
	private Bot bot;
	private Deck deck;
	
	public BotRound() {
		this.total = 0;
		this.id = UUID.randomUUID().toString();
	}
	public BotRound(Bot bot, Deck deck) {
		this();
		this.deck = deck;
		this.bot = bot;
	}
	
	public String getRoundId() {
		return this.id;
	}
	public void getChoice(Hand hand) {
		boolean flag = true;
		System.out.println("It is " + bot.getName() + "'s turn.");
		while(flag) {
			playerHand(hand);
			this.setTotal(hand.getHandTotal());
			System.out.println(bot.getName() + "'s hand total is " + this.getTotal());
			if(total < 16) {
				hit(hand);
			} else if(total == 16) {
				if(hand.getHasAce()) {
					hit(hand);
				}
				else {
					flag = false;
				}
			} else {
				flag = false;
			}
			bot.setTotalPoints(hand.getHandTotal());
			this.setTotal(hand.getHandTotal());
			if(this.getTotal() > 21) {
				bot.setBusted(true);
				flag = false;
				playerHand(hand);
				System.out.println(bot.getName() + "'s hand total is " + hand.getHandTotal());
				System.out.println(bot.getName() + " has busted!!!");
			}
		}
	}
	public void playerHand(Hand hand) {
		System.out.print(bot.getName() + "'s hand is: ");
		hand.getHandList().stream().forEach(e -> System.out.print("[" + e.getDisplayValue().toLowerCase() + " of " + 
			e.getSuit() + "] "));
		System.out.println();
	}
	public void hit(Hand hand) {
		int temp = 0;
		temp = Game.getGameCount();
		hand.addToHand(deck.getDeckList().get(temp));
		total = hand.getHandTotal();
		this.bot.setTotalPoints(total);
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal() {
		return this.total;
	}
}