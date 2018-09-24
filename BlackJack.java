/*
*	Created by Steven McDonald
*	Version 0.0.1
*/

import java.util.*;

public class BlackJack {
	Scanner s = new Scanner(System.in);
	List<Deck> deck = new ArrayList<Deck>();
	Random r = new Random();
	
	public static void main(String... args) {
		String answer, name;
		Player player;
		
		System.out.println("Would you like to play? Select Y/N.");
		answer = answerLoop(answer);
		quit(answer);
		answer = "";
		System.out.println("Would you like to enter your name? Select Y/N.");
		answer = answerLoop(answer);
		name = named(answer);
		if(name.isEmpty()) player = new Player();
		else player = new Player(name);
		
		/*Need to make Table class implementing Games, Card class implementing Cards, 
		* Deck class implementing Decks and creating a List<Card> in the constructor for use in game.
		* The list will be randomized every time it needs to be reshuffled with Collections.shuffle(List<Card>); 
		*/
	}
	
	private String answerLoop(String answer) {
		boolean flag = false;
		while(flag) {
			answer = s.nextLine();
			if(answer.equalsIgnoreCase("Y") | answer.equalsIgnoreCase("N")) break;
			System.out.println("Please enter Y/N.");
		}
		return answer;
	}
	
	private void quit(String answer) {
		if(answer.equals("N")) {
			System.out.println("Have a nice day!!");
			System.exit(0);
		}
	}
	
	private String named(String answer) {
		if(anser.equals("N")) return "";
		else {
			String temp = "";
			answer = "";
			boolean flag = false;
			while(flag) {
				System.out.println("Please enter your name");
				temp = s.nextLine();
				System.out.println("Is " + temp + " correct? Select Y/N.");
				answer = answerLoop(answer);
				if(answer.equalsIgnoreCase("Y")) return temp;
			}
		}
	}
}