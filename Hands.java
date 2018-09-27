package BlackJack;

import java.util.*;

public interface Hands {
	public void addToHand(Card c);
	public void clearHand();
	public Card getCard(int card);
	public int getHandTotal();
}