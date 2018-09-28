import java.util.*;

public class Game implements Games {
	private boolean startRound, endRound;
	private String id, answer = "";
	private Table table;
	private int spot, neg;
	private Deck deck;
	private List<Seat> seatList;
	private Player player;
	private Scanner s;
	private static int count = 0;
	
	public Game() {
		this.spot = 0;
		this.neg = 0;
		this.id = UUID.randomUUID().toString();
	}
	public Game(Player player, Scanner s) {
		this();
		this.table = new Table(player);
		this.deck = new Deck();
		this.seatList = table.getList();
		this.spot = player.getSpot();
		this.player = player;
		this.s = s;
	}
	
	public static int getGameCount() {
		return count++;
	} 
	public String getGameId() {
		return this.id;
	}
	public boolean isStartRound() {
		return this.startRound;
	}
	public boolean isEndRound() {
		return this.endRound;
	}
	public void newGameStart() {
		System.out.println(player.getName() + " is sitting in seat " + player.getSpot());
		this.shuffle();
        for(Seat seat : seatList) {
			seat.getBeing().addHand(new Hand());
		}
	}
	public void shuffle() {
		System.out.println("Dealer is shuffling the deck.");
	    deck.reshuffleDeck();
	}
	//deal isn't loading cards into hands properly?
	public void deal() {
		System.out.println("Cards are being dealt.");
		for(int j = 0; j < 2; j++) {
			for(int i = 0; i < 6; i++) {
					seatList.get(i).getBeing().getHand().addToHand(deck.getDeckList().get(count++));
			}
		}
		System.out.println("Dealer's hand is: [Hidden] [" + table.getDealer().getHand().getHandList().get(1).getDisplayValue() +
		" of " + table.getDealer().getHand().getHandList().get(1).getSuit() + "]");
	}
	
	public boolean checkForInsurance() {
		Hand h = table.getDealer().getHand();
		if((h.getCard(1).getValue() > 9) & (player.getBankRoll() > (int)(player.getBet() * 1.5))) {
			System.out.println("Would you like to buy insurance? This will automatically be purchased at half of your current bet. Enter Y/N");
			answer = answerLoop(answer, s);
			if(answer.equalsIgnoreCase("Y")) {
				player.setInsured(true);
			}
		}
		if(table.getDealer().getTotalPoints() == 21) {
			System.out.println("The dealer has a blackjack.");
			if(!(player.isInsured())) {
				this.neg -= player.getBet();
				player.setBankRoll(neg);
				this.neg = 0;
			}
			return false;
		}
		return true;
	}
	public void rounds(int i) {
		if(i == player.getSpot()) {
			Round round = new Round(player, deck, s);
			round.getChoice(player.getHand(0));
		} else if (i == 6) {
			DealerRound round = new DealerRound(table.getDealer(), deck);
			round.getChoice(table.getDealer().getHand(0));
		} else {
			BotRound round = new BotRound(seatList.get(i-1).getBot(), deck);
			round.getChoice(seatList.get(i-1).getBot().getHand(0));
		}
	}
	public void checkForShuffle() {
		if(deck.size() - count < 50) this.shuffle();
	}
	public boolean checkPlayerBankRoll() {
		if(player.getBankRoll() < 10) return false;
		return true;
	}
	private void quit(String answer) {
		if(answer.equals("N")) {
			System.out.println("Have a nice day!!");
			s.close();
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
	private int answerBetLoop(Scanner s) {
		boolean fakeFlag = true;
		int bet = 0;
		while(fakeFlag) {
			try {
				bet = Integer.parseInt(s.nextLine());
				fakeFlag = false;
			} catch(NumberFormatException e) {
				System.out.print("This is not a valid number!! Try again.");
				fakeFlag = true;
			}
			if(bet > player.getBankRoll()) {
				System.out.println(bet + " is more than you have! Your remaining credits are: " + player.getBankRoll());
				fakeFlag = true;
			}
			if(bet < 1) {
				System.out.println("Bets can't be less than 1 credit!!!");
				fakeFlag = true;
			}
		}
		return bet;
	}
	public void bet(Scanner s) {
		int bet = 0;
		System.out.println("You currently have: " + player.getBankRoll() + " creits.");
		System.out.println("How much would you like to bet?");
		bet = answerBetLoop(s);
		player.setBet(bet);
	}
	public void endRoundCheck() {
		for(Seat seat : seatList) {
			if(table.getDealer().isBusted() & !(seat.getBeing().isBusted())) {
				seat.getBeing().setBankRoll(seat.getBeing().getBet() + seat.getBeing().getBankRoll());
			}
			if(!(seat.getBeing().isBusted()) && (seat.getBeing().getTotalPoints() > table.getDealer().getTotalPoints())) {
				seat.getBeing().setBankRoll(seat.getBeing().getBet() + seat.getBeing().getBankRoll());
			}
		}
		for(Seat seat : seatList) {
			seat.getBeing().setClearHands();
		}
	}
}