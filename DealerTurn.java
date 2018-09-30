package com.github.BlackJack;

class DealerTurn {
	private Dealer dealer;
	private Game game;
	private Hand hand;
	
	public DealerTurn(Dealer dealer, Game game) {
		this.game = game;
		this.dealer = dealer;
		this.hand = dealer.getHand();
	}
	
	public void play() {
		boolean flag = true;
		int total = 0;
		System.out.println("It is the dealers turn.");
		while(flag) {
			total = hand.getTotal();
			printHand(hand);
			System.out.println("The dealer's hand total is " + total + "\n");
			BlackJack.sleeps();
			if(total > 21) {
				System.out.println("Dealer has busted!!!\n");
				BlackJack.sleeps();
				return;
			}
			if(total < 16) {
				hit(hand);
				BlackJack.sleeps();
			} else if(total == 16) {
				if(hand.hasAce()) {
					hit(hand);
					BlackJack.sleeps();
				}
				else {
					System.out.println("Dealer stays.\n");
					BlackJack.sleeps();
					return;
				}
			} else {
				System.out.println("Dealer stays.\n");
				BlackJack.sleeps();
				return;
			}
		}
	}
	
	public void printHand(Hand hand) {
		System.out.print("Dealer's hand is: ");
		hand.getDescriptions();
	}
	
	public void hit(Hand hand) {
		hand.add(game.deal());
	}
}