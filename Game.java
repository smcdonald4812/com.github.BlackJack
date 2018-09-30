package com.github.BlackJack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Game {
	private int count = 0;
	private boolean skip = false;
	private ArrayList<Integer> order;
	private Player player;
	private Bot one, two, three, four;
	private Dealer dealer;
	private Deck deck;
	private Random r;
	private BotTurn bTurn;
	private PlayerTurn pTurn;
	private DealerTurn dTurn;
	
	public Game(Player player) {
		this.player = player;
		this.deck = new Deck();
		this.one = new Bot();
		this.two = new Bot();
		this.three = new Bot();
		this.four = new Bot();
		this.dealer = new Dealer();
		this.r = new Random();
		this.order = new ArrayList<Integer>(6);
		randomSeating();
	}
	
	private void randomSeating() {
		double temp = r.nextDouble();
		int spot = (int)(temp * 100) % 5; 
		switch (spot) {
			case 0:
				this.order.add(0);
				this.order.add(5);
				System.out.println("You are in seat one.\n");
				this.order.add(2);
				this.order.add(3);
				this.order.add(4);
				this.order.add(1);
				this.order.add(6);
				break;
			case 1:
				this.order.add(0);
				this.order.add(1);
				this.order.add(5);
				System.out.println("You are in seat two.\n");
				this.order.add(3);
				this.order.add(4);
				this.order.add(5);
				this.order.add(6);
				break;
			case 2:
				this.order.add(0);
				this.order.add(1);
				this.order.add(2);
				this.order.add(5);
				System.out.println("You are in seat three.\n");
				this.order.add(4);
				this.order.add(3);
				this.order.add(6);
				break;
			case 3:
				this.order.add(0);
				this.order.add(1);
				this.order.add(2);
				this.order.add(3);
				this.order.add(5);
				System.out.println("You are in seat four.\n");
				this.order.add(4);
				this.order.add(6);
				break;
			case 4:
				this.order.add(0);
				this.order.add(1);
				this.order.add(2);
				this.order.add(3);
				this.order.add(4);
				this.order.add(5);
				System.out.println("You are in seat five.\n");
				this.order.add(6);
		}
		this.order.add(7);
	}
	
	public void firstDeal() {
		System.out.println("Dealer is dealing cards.\n");
		for(int i = 0; i < 2; i++) {
			this.player.getHand().add(this.deal());
			this.one.getHand().add(this.deal());
			this.two.getHand().add(this.deal());
			this.three.getHand().add(this.deal());
			this.four.getHand().add(this.deal());
			this.dealer.getHand().add(this.deal());
		}
	}
	
	public ArrayList<Integer> getOrder() {
		return this.order;
	}
	
	public Card deal() {
		if(count > 51) {
			this.count = 0;
			this.deck = new Deck();
		}
		return this.deck.getCard(this.count++);
	}
	
	public boolean getSkip() {
		return this.skip;
	}
	
	public void turns(int i) {
		switch(i) {
			case 0:
				checkForInsurance();
				break;
			case 1:
				this.bTurn = new BotTurn(one, this);
				bTurn.play();
				break;
			case 2:
				this.bTurn = new BotTurn(two, this);
				bTurn.play();
				break;
			case 3:
				this.bTurn = new BotTurn(three, this);
				bTurn.play();
				break;
			case 4:
				this.bTurn = new BotTurn(four, this);
				bTurn.play();
				break;
			case 5:
				this.pTurn = new PlayerTurn(player, this);
				pTurn.play();
				break;
			case 6:
				this.dTurn = new DealerTurn(dealer, this);
				dTurn.play();
				break;
			case 7:
				determineWinnings(one, dealer);
				determineWinnings(two, dealer);
				determineWinnings(three, dealer);
				determineWinnings(four, dealer);
				determineWinnings(player, dealer);
				resetValues();
		}
	}
	
	
	private void checkForInsurance() {
		dealerHidden();
		if(this.dealer.getHand().get(1).getCardValue() == 10 | this.dealer.getHand().get(1).getCardValue() == 1) {
			if((int)(this.player.getBet() * 1.5) <= this.player.getBankRoll()) {
				Scanner s = new Scanner(System.in);
				String answer = "";
				System.out.println("Would you like to buy insurance? Enter Y/N.");
				while(true) {
					answer = s.nextLine().toString();
					if(answer.equalsIgnoreCase("Y") | answer.equalsIgnoreCase("N")) {
						if(answer.equalsIgnoreCase("Y")) {
							if(this.dealer.getHand().getTotal() == 21) {
								this.player.setBankRoll(this.player.getBankRoll() + (int)(this.player.getBet() * 1.5));
								this.skip = true;
							} else {
								this.player.setBankRoll(this.player.getBankRoll() - (int)(this.player.getBet() * 0.5));
							}
							System.out.println("Dealer did not have BlackJack!!! You lost " + (int)(this.player.getBet() * 0.5) + "\n");
							return;
						} else {
							if(this.dealer.getHand().getTotal() == 21) {
								this.player.setBankRoll(this.player.getBankRoll() - (int)(this.player.getBet() * 0.5));
								this.skip = true;
							}
							return;
						}
					}
					System.out.println("Please enter Y/N.\n");
				}
			}
		}
	}
	
	private void dealerHidden() {
		System.out.println("The dealer has [hidden] " + this.dealer.getHand().get(1).getDescription() + "\n");
	}
	
	private void determineWinnings(Bot b, Dealer dealer) {
		int d = dealer.getHand().getTotal(),
		total = b.getHand().getTotal(),
		bet = b.getBet(), bankRoll = b.getBankRoll();
		
		if(d > 21) {
			if(total < 22) {
				b.setBankRoll(bankRoll + bet);
				System.out.println(b.getName() + " won.\n");
			} else {
				b.setBankRoll(bankRoll - bet);
				System.out.println(b.getName() + " lost.\n");
			}
		} else if(total > d & total < 22) {
			b.setBankRoll(bankRoll + bet);
			System.out.println(b.getName() + " won.\n");
		} else if(total < d) {
			b.setBankRoll(bankRoll - bet);
			System.out.println(b.getName() + " lost.\n");
		} else if(total == d && total < 22) {
				System.out.println(b.getName() + " got a draw.\n");
		} else {
			b.setBankRoll(bankRoll - bet);
			System.out.println(b.getName() + " lost.\n");
		}
		if(total == 21 & b.getHand().size() < 3) {
			b.setBankRoll((int)(bankRoll + (bet * 1.5)));
		}
		System.out.println(b.getName() + "'s credits are " + b.getBankRoll() +"\n");
	}
	
	private void determineWinnings(Player p, Dealer dealer) {
		int d = dealer.getHand().getTotal(),
		total = p.getHand().getTotal(), total2 = 0,
		bet = p.getBet(), bankRoll = p.getBankRoll();
		
		if(p.getSplit()) {
			total2 = player.getHand(1).getTotal();
		}
		if(d > 21) {
			if(total < 22) {
				p.setBankRoll(bankRoll + bet);
				System.out.println(p.getName() + " won.\n");
			} else {
				p.setBankRoll(bankRoll - bet);
				System.out.println(p.getName() + " lost.\n");
			}
		} else if(total > d && total < 22) {
			p.setBankRoll(bankRoll + bet);
			System.out.println(p.getName() + " won.\n");
		} else if(total < d) {
			p.setBankRoll(bankRoll - bet);
			System.out.println(p.getName() + " lost.\n");
		} else if(total == d && total < 22) {
				System.out.println(p.getName() + " got a draw.\n");
		} else {
			p.setBankRoll(bankRoll - bet);
			System.out.println(p.getName() + " lost.\n");
		}
		if(total == 21 & p.getHand().size() < 3) {
			p.setBankRoll((int)(bankRoll + (bet * 1.5)));
		}
		if(p.getSplit()) {
			if(d > 21) {
				if(total2 < 22) {
					p.setBankRoll(bankRoll + bet);
					System.out.println(p.getName() + " won.\n");
				} else {
					p.setBankRoll(bankRoll - bet);
					System.out.println(p.getName() + " lost.\n");
				}
			} else if(total2 > d && total2 < 22) {
				p.setBankRoll(bankRoll + bet);
				System.out.println(p.getName() + " won.\n");
			} else if(total2 < d) {
				p.setBankRoll(bankRoll - bet);
				System.out.println(p.getName() + " lost.\n");
			} else if(total2 == d && total2 < 22) {
				System.out.println(p.getName() + " got a draw.\n");
			} else {
				p.setBankRoll(bankRoll - bet);
				System.out.println(p.getName() + " lost.\n");
			}
			if(total2 == 21 & p.getHand(1).size() < 3) {
				p.setBankRoll((int)(bankRoll + (bet * 1.5)));
			}
		}
		System.out.println(p.getName() + "'s credits are " + p.getBankRoll() + "\n");
	}
	
	private void resetValues() {
		this.one.clear();
		this.two.clear();
		this.three.clear();
		this.four.clear();
		this.player.clear();
		this.player.getHands().add(new Hand());
		this.dealer = new Dealer();
		this.skip = false;
		this.player.setSplit(false);
	}
}