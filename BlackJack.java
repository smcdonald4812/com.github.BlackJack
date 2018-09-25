/*
*	Created by Steven McDonald
*	Version 0.0.1
*/
package BlackJack;
import java.util.*;

public class BlackJack {
	public static void main(String... args) {
		Scanner s = new Scanner(System.in);
		boolean flag = false;
		String answer = "", name = "";
		Player player;
		Deck deck = new Deck();
		
		//Asking if the player wants to play as well as what their display name will be.
		System.out.println("Would you like to play? Select Y/N.");
		answer = answerLoop(answer, s);
		quit(answer);
		answer = "";
		System.out.println("Would you like to enter your name? Select Y/N.");
		answer = answerLoop(answer, s);
		name = named(answer, s);
		if(name.isEmpty()) player = new Player();
		else player = new Player(name);
		
		Table table = new Table();
		
		//while(flag) {
			/*
			* The list will be randomized every time it needs to be reshuffled with Collections.shuffle(List<Card>); 
			*/
		//}
		s.close();
	}
	
	private static String answerLoop(String answer, Scanner s) {
		boolean flag = false;
		while(flag) {
			answer = s.nextLine();
			if(answer.equalsIgnoreCase("Y") | answer.equalsIgnoreCase("N")) break;
			System.out.println("Please enter Y/N.");
		}
		return answer;
	}
	
	private static void quit(String answer) {
		if(answer.equals("N")) {
			System.out.println("Have a nice day!!");
			System.exit(0);
		}
	}
	
	private static String named(String answer, Scanner s) {
		if(answer.equals("N")) return "";
		else {
			String temp = "";
			answer = "";
			boolean flag = false;
			while(flag) {
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