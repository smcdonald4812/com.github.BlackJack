package Interfaces;

import BlackJack.*;

interface Cards {
	void SetValue(int value);
	int getValue();
	String getDisplayValue();
	String getSuit();
	String getId();
	boolean isAce();
	boolean isFaceCard();
}