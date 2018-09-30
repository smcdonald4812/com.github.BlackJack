package com.github.BlackJack;

import java.util.Random;

class BotTurn {
	private Bot bot;
	private Hand hand;
	private Random r;
	private int rando;
	private Game game;
	
	public BotTurn(Bot bot, Game game) {
		this.game = game;
		this.bot = bot;
		this.hand = bot.getHand();
		this.r = new Random();
		this.rando = (int)(r.nextDouble() * 100);
		this.bet(rando);
	}
	
	private void bet(int rando) {
		if(rando <= this.bot.getBankRoll()) {
			this.bot.setBet(rando);
			printBet();
			BlackJack.sleeps();
		} else if(this.bot.getBankRoll() < 10) {
			System.out.println(bot.getName() + " got more credits.");
			this.bot.setBankRoll(bot.getBankRoll() + 10_000);
			this.bot.setBet(rando);
			printBet();
			BlackJack.sleeps();
		} else {
			this.bot.setBet(this.bot.getBankRoll());
			printBet();
			BlackJack.sleeps();
		}
	}
	public void play() {
		boolean flag = true;
		int total = 0;
		System.out.println("It is " + bot.getName() + "'s turn.\n");
		while(flag) {
		    total = hand.getTotal();
			printHand(hand);
			System.out.println("The " + bot.getName() + "'s hand total is " + total  + "\n");
			BlackJack.sleeps();
			if(total > 21) {
				System.out.println(bot.getName() + " has busted!!!\n");
				BlackJack.sleeps();
				return;
			}
			if(total == 21) {
				if(hand.size() < 3) {
					System.out.println("BLACKJACK!!!!\n");
					BlackJack.sleeps();
					return;
				}
			}
			if(total < 16) {
				hit(hand);
			} else if(total == 16) {
				if(this.hand.hasAce()) {
					hit(hand);
				}
				else {
					System.out.println(bot.getName() + " stays.\n");
					BlackJack.sleeps();
					return;
				}
			} else {
				BlackJack.sleeps();
				System.out.println(bot.getName() + " stays.\n");
				return;
			}
		}
	}
	
	public void printHand(Hand hand) {
		System.out.print(bot.getName() + "'s hand is: ");
		hand.getDescriptions();
	}
	
	public void hit(Hand hand) {
		hand.add(game.deal());
	}
	
	private void printBet() {
		System.out.println(bot.getName() + " bets: " + bot.getBet() + "\n");
	}
}