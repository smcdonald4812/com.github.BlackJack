/*
*	Created by Steven McDonald
*	Version 0.0.2
*/

import java.util.*;

public class BlackJack {
	Scanner s = new Scanner(System.in);
	
	public static void main(String... args) {
		private boolean flag;
		private String answer, name;
		private Player player;
		private Deck deck = new Deck();
		
		//Asking if the player wants to play as well as what their display name will be.
		System.out.println("Would you like to play? Select Y/N.");
		answer = answerLoop(answer);
		quit(answer);
		answer = "";
		System.out.println("Would you like to enter your name? Select Y/N.");
		answer = answerLoop(answer);
		name = named(answer);
		if(name.isEmpty()) player = new Player();
		else player = new Player(name);
		
		private Table table = new Table();
		
		while(flag) {
			/*
			* Need to add main game logic here...
			* The list will be randomized every time it needs to be reshuffled with Collections.shuffle(List<Card>); 
			*/
		}
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
