/*
*	Created by Steven McDonald
*	Version 0.0.4
*/
package BlackJack;

import java.util.*;

public class BlackJack {
	public static void main(String... args) {
		Scanner s = new Scanner(System.in);
		boolean flag = true, flag2 = true;
		String answer = "", name = "";
		Player player;
		
		//Asking if the player wants to play as well as what their display name will be.
		System.out.println("Would you like to play? Select Y/N.");
		answer = answerLoop(answer, s);
		quit(answer, s);
		System.out.println("Would you like to enter your name? Select Y/N.");
		answer = answerLoop(answer, s);
		name = named(answer, s);
		if(name.isEmpty()) player = new Player();
		else player = new Player(name);
		Game game = new Game(player, s);
				
		while(flag) {
			game.newGameStart();
			while(flag2) {
				game.bet(s);
				game.deal();
				game.checkForInsurance();
				game.rounds(1);
				game.rounds(2);
				game.rounds(3);
				game.rounds(4);
				game.rounds(5);
				game.rounds(6);
				game.checkForShuffle();
				game.endRoundCheck();
				flag2 = game.checkPlayerBankRoll();
			}
			System.out.println("Would you like to play again?");
			answer = answerLoop(answer, s);
			quit(answer, s);
		}
		s.close();
	}
	
	private static String answerLoop(String answer, Scanner s) {
		boolean fakeFlag = true;
		while(fakeFlag) {
			answer = s.nextLine();
			if(answer.equalsIgnoreCase("Y") | answer.equalsIgnoreCase("N")) break;
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
				System.out.println("Please enter your name");
				temp = s.nextLine();
				System.out.println("Is " + temp + " correct? Select Y/N.");
				answer = answerLoop(answer, s);
				if(answer.equalsIgnoreCase("Y")) return temp;
			}
		}
		return "";
	}
}