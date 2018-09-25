package BlackJack;

interface Cards {
	void SetValue(int value);
	int GetValue();
	String getDisplayValue();
	String getSuit();
	String getId();
	boolean isAce();
	boolean isFaceCard();
}