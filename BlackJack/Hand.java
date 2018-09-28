import java.util.*;
import java.util.stream.*;

public class Hand implements Hands {
	private List<Card> hand;
	private String id;
	private boolean hasAce;
	private int aceCount;
	
	public Hand() {
		this.hand = new ArrayList<Card>();
		this.id = UUID.randomUUID().toString();
		this.hasAce = false;
		this.aceCount = 0;
	}
	
	public void addToHand(Card c) {
		this.hand.add(c);
		if(c.getDisplayValue().equals("A")) {
			this.hasAce = true;
			this.aceCount++;
		}
	}
	public int getAceCount() {
		return this.aceCount;
	}
	public boolean getHasAce() {
		return this.hasAce;
	}
	public void clearHand() {
		this.hand.clear();
	}
	//prints the entire hand.
	public void getHand(Beings being) {
		System.out.print(being.getName() + "'s hand is: ");
		this.hand.stream().forEach(e -> System.out.print("[" + e.getDisplayValue().toLowerCase() + " of " + 
		e.getSuit() + "] "));
		System.out.println();
	}
	public List<Card> getHandList() {
		return this.hand;
	}
	//gets a card from the hand.
	public Card getCard(int card) {
		return this.hand.get(card);
	}
	public int getHandTotal() {
		int v = 0;
		for(Card c : this.hand) {
			v += c.getValue();
			if(v > 21 && this.getHasAce()) {
				v -= 10;
			}
		}
		return v;
	}
}