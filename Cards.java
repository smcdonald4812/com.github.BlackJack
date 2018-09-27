package BlackJack;

import java.util.*;

interface Cards {
	void SetValue(int value);
	int getValue();
	String getDisplayValue();
	String getSuit();
	String getId();
	boolean isAce();
	boolean isFaceCard();
}