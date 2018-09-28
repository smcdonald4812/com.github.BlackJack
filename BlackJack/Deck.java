import java.util.*;

public class Deck implements Decks {
	//size of 8 52 card decks
	private ArrayList<Card> fullDeck = new ArrayList<Card>(416);
	private final String id;
	
	public Deck() {
		int value = 0;
		this.id = UUID.randomUUID().toString();
		
		for(int i = 0; i < 8; i++) {
			for(Card.SUIT suit : Card.SUIT.values()) {
				for(Card.DISPLAY_VALUE dv : Card.DISPLAY_VALUE.values()) {
					if(dv.ordinal() < 9) {
						value = dv.ordinal() + 2;
					} else if(dv.ordinal() == 12) {
						value = 11;
					} else {
						value = 10;
					}
					fullDeck.add(new Card(value, suit, dv));
				}
			}
		}
	}
	
	public ArrayList<Card> getDeckList() {
		return this.fullDeck;
	}
	public int size() {
		return this.fullDeck.size();
	}
	public String getDeckId(String id) {
		return id;
	}
	public void reshuffleDeck() {
		Collections.shuffle(this.fullDeck);
	}
}