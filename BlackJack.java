/*
*	Created by Steven McDonald
*	Version 0.0.2
*   need to add logic to skip turns if dealer has blackjack. and pause when blackjack is printed.
*/

package com.github.BlackJack;

import java.util.*;

public class BlackJack {
	public static Thread thread = new Thread();
	
	public static void main(String... args) {
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		String answer = "", name = "";
		Player player;
		
		name = startup(answer, s);
		if(name.isEmpty()) player = new Player("Anon Y. Mous");
		else player = new Player(name);
		Game game = new Game(player);
		List<Integer> order = game.getOrder();
			
		while(flag) {
			System.out.println();
			game.firstDeal();
			sleeps();
			checkingBet(player, s);
			System.out.println();
			sleeps();
			for(Integer i : order) {
				if(game.getSkip()) {
					game.turns(7);
					break;
				}
				game.turns((int)i);
				sleeps();
			}
			s.reset();
			System.out.println("Would you like to keep playing?");
			answer = answerLoop(answer, s);
			addCredits(answer, player);
			quit(answer, s);
		}
		s.close();
	}
	
	private static String answerLoop(String answer, Scanner s) {
		boolean fakeFlag = true;
		while(fakeFlag) {
			answer = s.nextLine();
			if(answer.equalsIgnoreCase("Y") | answer.equalsIgnoreCase("N")) {System.out.println(); break;}
			System.out.println("Please enter Y/N.");
		}
		return answer;
	}
	
	private static void quit(String answer, Scanner s) {
		if(answer.equalsIgnoreCase("N")) {
			System.out.println("Have a nice day!!");
			s.close();
			System.exit(0);
		}
	}
	
	private static String named(String answer, Scanner s) {
		if(answer.equalsIgnoreCase("N")) return "";
		else {
			String temp = "";
			answer = "";
			boolean fakeFlag = true;
			while(fakeFlag) {
				System.out.println("Please enter your name\n");
				temp = s.nextLine();
				System.out.println();
				System.out.println("Is " + temp + " correct? Select Y/N.");
				answer = answerLoop(answer, s);
				if(answer.equalsIgnoreCase("Y")) return temp;
			}
		}
		return "";
	}
	
	private static String startup(String answer, Scanner s) {
		String name = "";
		System.out.println("Welcome to BlackJack!!!\n\n");
		//System.out.println("Would you like to play? Select Y/N.");
		//answer = answerLoop(answer, s);
		//quit(answer, s);
		System.out.println("Would you like to enter your name? Select Y/N.");
		answer = answerLoop(answer, s);
		name = named(answer, s);
		return name;
	}
	
	private static void addCredits(String answer, Player player) {
		if(answer.equalsIgnoreCase("Y") & player.getBankRoll() < 100) {
			System.out.println("Refilling coffers.");
			player.setBankRoll(player.getBankRoll() + 10_000);
		}
	}
	
	private static void checkingBet(Player p, Scanner s) {
		int bet = 0;
		System.out.println("You have " + p.getBankRoll() + " credits.");
		System.out.println("How much would you like to bet?");
		boolean fakeFlag = true;
		while(fakeFlag) {
			try {
				bet = Integer.parseInt(s.nextLine());
				if(bet > p.getBankRoll()) {
					System.out.println("That is more than you have. Try again.");
				} else {
					p.setBet(bet);
					return;
				}
			} catch(NumberFormatException e) {
				System.out.println("Input must be a number!!! Try again.");
			}
		}
	}
	
	public static void sleeps() {
		try {
			BlackJack.thread.sleep(500);
		} catch(InterruptedException e) {
			e.printStackTrace();
			System.out.println("Thread's sleep function sleeps was interupted!");
		}
	}
	
	/*public static Thread getThread() {
		return BlackJack.thread;
	}*/
}