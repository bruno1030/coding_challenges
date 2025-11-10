import java.util.Scanner;

public class SumNumberDigits{
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		boolean intValueWasEntered = false;
		
		String userInput = "";
		
		Integer intUserInput = 0;
		
		while(!intValueWasEntered) {
			System.out.println("Type a number");
			userInput = scanner.nextLine().trim();
			try {
				intUserInput = Integer.valueOf(userInput);
				intValueWasEntered = true;
			}catch (Exception e){
				System.out.println("Invalid value, please type a number");
			}
		}
		
		int sum = 0;
		
		int currentNumber = intUserInput;

		int lastNumber = 0;
		
		while(currentNumber > 0) {
			
			lastNumber = currentNumber % 10;
			
			sum += lastNumber;
			
			currentNumber = currentNumber / 10;
		}
		
		System.out.println("Sum: " + String.valueOf(sum));
		
	}
	
}