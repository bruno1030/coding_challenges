import java.util.Random;
import java.util.Scanner;

public class Jockenpo{
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite PEDRA, PAPEL ou TESOURA");
		String userInput = scanner.nextLine().trim().toUpperCase();
		
		boolean validInput = false;
		
		while(!validInput) {
			if (
					!userInput.equalsIgnoreCase("PEDRA")&&
					!userInput.equalsIgnoreCase("PAPEL")&&
					!userInput.equalsIgnoreCase("TESOURA")
					) {
				System.out.println("Você deve digitar PEDRA, PAPEL ou TESOURA");
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
					
			System.out.println("Mão do usuário: " + hand.toString());
			System.out.println("Mão do computador: " + computerHand.toString());
			
			if(hand == computerHand) {
				System.out.println("Ninguem ganhou");
			}else if(hand == Hand.PEDRA && computerHand == Hand.TESOURA) {
				System.out.println("Usuário ganhou");
			}else if(hand == Hand.PAPEL && computerHand == Hand.PEDRA) {
				System.out.println("Usuário ganhou");
			}else if(hand == Hand.TESOURA && computerHand == Hand.PAPEL) {
				System.out.println("Usuário ganhou");
			}else {
				System.out.println("Computador ganhou");
			}
		}
		
	}
	
	public enum Hand{
		PEDRA,
		PAPEL,
		TESOURA
	}
	
}