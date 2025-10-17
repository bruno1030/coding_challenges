import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors{
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type ROCK, PAPER or SCISSORS");
		String userInput = scanner.nextLine().trim().toUpperCase();
		
		boolean validInput = false;
		
		while(!validInput) {
			if (
					!userInput.equalsIgnoreCase("ROCK")&&
					!userInput.equalsIgnoreCase("PAPER")&&
					!userInput.equalsIgnoreCase("SCISSORS")
					) {
				System.out.println("You should type ROCK, PAPER or SCISSORS");
				userInput = scanner.nextLine().trim().toUpperCase();
			}else {
				validInput = true;	
			}
		}
		
		Hand userHand = Hand.valueOf(userInput);
		
		Game.play(userHand);	
	}
	
	
	public class Game{
		
		static void play(Hand hand) {
			
			Hand[] possibleHands = Hand.values();
			
			Random random = new Random();
			
			Hand computerHand = possibleHands[random.nextInt(possibleHands.length)];
					
			System.out.println("User hand: " + hand.toString());
			System.out.println("Computer hand: " + computerHand.toString());
			
			if(hand == computerHand) {
				System.out.println("Nobody won");
			}else if(hand == Hand.ROCK && computerHand == Hand.SCISSORS) {
				System.out.println("User won");
			}else if(hand == Hand.PAPER && computerHand == Hand.ROCK) {
				System.out.println("User won");
			}else if(hand == Hand.SCISSORS && computerHand == Hand.PAPER) {
				System.out.println("User won");
			}else {
				System.out.println("Computer won");
			}
		}
		
	}
	
	public enum Hand{
		ROCK,
		PAPER,
		SCISSORS
	}
	
}