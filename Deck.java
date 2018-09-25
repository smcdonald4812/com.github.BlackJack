import java.util.*;

public Deck implements Decks {
	//size of 8 52 card decks
	private ArrayList<Card> fullDeck = new ArrayList<Card>(416);
	private final id;
	
	public Deck() {
		private int value = 0;
		this.id = UUID.randomUUID().toString();
		
		for(int i = 0; i < 8; i++) {
			for(SUIT suit : SUIT.values()) {
				for(DISPLAY_VALUES dv : DISPLAY_VALUES.values()) {
					if(dv.ordinal() < 10) {
						value = dv.ordinal();
					} else if(dv.ordinal() > 9 & dv.ordinal() < 12) {
						value = 10;
					} else {
						value = 11;
					}
					fullDeck.add(new Card(value, suit, dv));
				}
			}
		}
	}
	
	public String getDeckId(String id) {
		return id;
	}
	public void reshuffleDeck() {
		Collections.shuffle(this.fullDeck);
	}
}