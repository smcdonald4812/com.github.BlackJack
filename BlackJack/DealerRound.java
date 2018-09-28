import java.util.*;
import java.util.stream.*;

public class DealerRound implements Rounds {
	private int total;
	private final String id;
	private Dealer dealer;
	private Deck deck;
	
	public DealerRound() {
		this.total = 0;
		this.id = UUID.randomUUID().toString();
	}
	public DealerRound(Dealer dealer, Deck deck) {
		this();
		this.deck = deck;
		this.dealer = dealer;
	}
	
	public String getRoundId() {
		return this.id;
	}
	public void getChoice(Hand hand) {
		boolean flag = true;
		System.out.println("It is the dealers turn.");
		while(flag) {
			playerHand(hand);
			this.setTotal(hand.getHandTotal());
			System.out.println("The dealer's hand total is " + this.getTotal());
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
			dealer.setTotalPoints(hand.getHandTotal());
			this.setTotal(hand.getHandTotal());
			if(this.getTotal() > 21) {
				dealer.setBusted(true);
				flag = false;
				playerHand(hand);
				System.out.println("Dealer's hand total is " + hand.getHandTotal());
				System.out.println("The dealer has busted!!!");
			}
		}
	}
	public void playerHand(Hand hand) {
		System.out.print("Dealer's hand is: ");
		hand.getHandList().stream().forEach(e -> System.out.print("[" + e.getDisplayValue().toLowerCase() + " of " + 
			e.getSuit() + "] "));
		System.out.println();
	}
	public void hit(Hand hand) {
		int temp = 0;
		temp = Game.getGameCount();
		hand.addToHand(deck.getDeckList().get(temp));
		total = hand.getHandTotal();
		this.dealer.setTotalPoints(total);
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal() {
		return this.total;
	}
}