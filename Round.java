package BlackJack;

import java.util.*;
import java.util.stream.*;
import Interfaces.*;

public class Round implements Rounds{
	private int total;
	private final String id;
	private String answer;
	private Player player;
	private Deck deck;
	private Scanner s;
	
	public Round() {
		this.total = 0;
		this.id = UUID.randomUUID().toString();
		this.answer = "";
	}
	public Round(Player player, Deck deck, Scanner s) {
		this();
		this.deck = deck;
		this.player = player;
		this.s = s;
	}
	public String getRoundId() {
		return this.id;
	}
	//would use event listeners and onClicks but this is text based only.
	public void getChoice(Hand hand) {
		boolean flag = true;
		playerHand(hand);
		System.out.println("What would you like to do. Press [H] to get help.");
		while(flag) {
			String pressed = s.nextLine();
			switch(pressed.toUpperCase()) {
				case "W":
					hit(hand);
					playerHand(hand);
					break;
				case "S":
					flag = false;
					break;
				case "D":
					if(hand.getHandList().size() < 3) {
						doubles(player, "double");
						playerHand(hand);
						flag = false;
					} else {
						System.out.println("Hand can only be doubled on first two cards.");
					}
					break;
				case "A":
					if(hand.getHandList().size() < 3 & this.isMatchingPair(hand)) {
						split(player);
						flag = false;
					} else {
						System.out.println("Hand can only be split on first two cards, and only if they are a pair or face cards.");
					}
					break;
				case "H":
					help();
					break;
				case "Q":
					System.out.println("Are you sure you want to quit?");
					answer = answerLoop(answer, s);
					quit(answer);
				default:
					System.out.println(pressed + " is invalid. Please enter W/A/S/D/H/Q only.");
			}
			if(!(player.isSplit())) {
				player.setTotalPoints(hand.getHandTotal());
				this.setTotal(hand.getHandTotal());
				if(this.getTotal() > 21) {
					player.setBusted(true);
					player.setBankRoll(-(player.getBet()));
					flag = false;
				}
			} else {
				if(player.getHands().size() > 1) {
					flag = false;
				} else {
					player.addHand(hand);
				}
			}
		}
	}
	public void playerHand(Hand hand) {
		System.out.print("Your hand is: ");
		hand.getHandList().stream().forEach(e -> System.out.print("[" + e.getDisplayValue().toLowerCase() + " of " + 
			e.getSuit() + "] "));
		System.out.println();
	}
	public boolean isMatchingPair(Hand hand) {
		if(hand.getHandList().get(0).getValue() == hand.getHandList().get(1).getValue()) {
			return true;
		}
		return false;
	}
	public void hit(Hand hand) {
		int temp = 0;
		temp = Game.getGameCount();
		hand.addToHand(deck.getDeckList().get(temp));
		total = hand.getHandTotal();
		this.player.setTotalPoints(total);
	}
	public boolean doubles(Player p, String doubleOrSplit) {
		if(p.isAbleToDouble(p.getBet(), p.getBankRoll())) {
			p.setBetDouble();
			return true;
		}	
		else {
			System.out.println("You do not have enough to " + doubleOrSplit + "!");
			return false;
		}
	}
	public void split(Player p) {
		boolean able = doubles(p, "split");
		int temp = 0;
		if(able) {
			Hand s1 = new Hand();
			s1.addToHand(p.getHand(0).getHandList().get(0));
			Hand s2 = new Hand();
			s2.addToHand(p.getHand(0).getHandList().get(1));
			p.removeHand(0);
			temp = Game.getGameCount();
			s1.addToHand(deck.getDeckList().get(temp));
			temp = Game.getGameCount();
			s2.addToHand(deck.getDeckList().get(temp));
			System.out.print("Hand one is: ");
			getChoice(s1);
			System.out.print("Hand two is: ");
			getChoice(s2);
		}
		return;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal() {
		return this.total;
	}
	public void help() {
		System.out.println(
		"Press H for help./n Press W to hit./n Press D to double./n Press A to split./n Press Q to quit.");
	}
	private void quit(String answer) {
		if(answer.equalsIgnoreCase("Y")) {
			System.out.println("Have a nice day!!");
			System.exit(0);
		}
	}
	private String answerLoop(String answer, Scanner s) {
		boolean fakeFlag = true;
		while(fakeFlag) {
			answer = s.nextLine();
			if(answer.equalsIgnoreCase("Y") | answer.equalsIgnoreCase("N")) break;
			System.out.println("Please enter Y/N.");
		}
		return answer;
	}
}