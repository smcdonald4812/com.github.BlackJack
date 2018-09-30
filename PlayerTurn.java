package com.github.BlackJack;

import java.util.Scanner;

class PlayerTurn {
	private Scanner sc;
	private Hand hand;
	private Game game;
	private Player player;
	private String answer;
	
	public PlayerTurn(Player player, Game game) {
		this.sc = new Scanner(System.in);
		this.game = game;
		this.player = player;
		this.hand = player.getHand();
		this.answer = "";
	}
	
	public void play() {
		getChoice(hand);
	}
	
	public void getChoice(Hand hand) {
		boolean flag = true;
		int total = 0;
		while(flag) {
			playerHand(hand);
			total = hand.getTotal();
			System.out.println("Hand total is " + total + "\n");
			if(total > 21) {
				System.out.println("You busted!!!\n");
				this.sc.reset();
				return;
			}
			if(total == 21) {
				System.out.println("Nice!! You have 21.\n");
				if(hand.size() < 3) {
					System.out.println("BLACKJACK!!!!\n");
				}
				this.sc.reset();
				return;
			}
			System.out.println("What would you like to do. Press [H] to get help.");
			String pressed = sc.nextLine();
			switch(pressed.toUpperCase()) {
				case "W":
					hit(hand);
					break;
				case "S":
					flag = false;
					break;
				case "D":
					if(hand.size() < 3) {
						boolean doub = doubles(player, "double");
						if(doub) {
							hit(hand);
							total = hand.getTotal();
							playerHand(hand);
							System.out.println("Hand total is " + total + "\n");
							flag = false;
						}
					} else {
						System.out.println("\nHand can only be doubled on first two cards.");
					}
					break;
				case "A":
					if(!(player.getSplit()) & (hand.size() < 3) & (hand.get(0).getCardValue() == hand.get(1).getCardValue())) {
						split(player);
						flag = false;
					} else {
						System.out.println("\nHand can only be split on first two cards, and only if their point values are the same.");
					}
					break;
				case "H":
					help();
					break;
				case "Q":
					System.out.println("Are you sure you want to quit?");
					answer = answerLoop(answer, sc);
					quit(answer);
				default:
					System.out.println(pressed + " is invalid. Please enter W/A/S/D/H/Q only.");
			}
			System.out.println();
		}
		this.sc.reset();
	}
	
	public void playerHand(Hand hand) {
		System.out.print("Your hand is: ");
		hand.getDescriptions();
	}
	
	public void hit(Hand hand) {
		hand.add(game.deal());
	}
	
	public boolean doubles(Player p, String doubleOrSplit) {
		if(p.getBankRoll() > (p.getBet() * 2)) {
			p.setBet(p.getBet() * 2);
			return true;
		}	
		else {
			System.out.println("You do not have enough to " + doubleOrSplit + "!");
			return false;
		}
	}
	
	public void split(Player p) {
		Hand s1 = new Hand();
		Hand s2 = new Hand();
		s1.add(p.getHand(0).get(0));
		s2.add(p.getHand(0).get(1));
		s1.add(game.deal());
		s2.add(game.deal());
		p.getHands().add(s1);
		p.getHands().add(s2);
		p.getHands().remove(0);
		getChoice(s1);
		getChoice(s2);
	}
	
	private void help() {
		System.out.println(
		"Press H for help.\nPress W to hit.\nPress S to stand.\nPress D to double.\nPress A to split.\nPress Q to quit.");
	}
	
	private void quit(String answer) {
		if(answer.equalsIgnoreCase("Y")) {
			System.out.println("Have a nice day!!");
			System.exit(0);
		}
	}
	
	private String answerLoop(String answer, Scanner sc) {
		boolean fakeFlag = true;
		while(fakeFlag) {
			answer = sc.nextLine();
			if(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N")) fakeFlag = false;
			else System.out.println("Please enter Y/N.");
		}
		return answer;
	}
}