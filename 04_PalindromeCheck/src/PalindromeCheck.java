import java.util.Scanner;

class PalindromeCheck{
	
	public static void main(String[] args) {
		
		System.out.println("PALINDROME CHECK");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please, enter a text");
		
		String userInput = scanner.nextLine();
		
		String userInputNormalized = userInput.toLowerCase().replaceAll(" ", "");
		
		char[] userInputChars = userInputNormalized.toCharArray();
		
		boolean isPalindrome = true;
		
		for (int i = 0; i < userInputChars.length; i++) {
			
			if(userInputChars[i] != userInputChars[userInputChars.length - i - 1]){
				isPalindrome = false;
				break;
			}
		}
		
		if(isPalindrome) {
			System.out.println("Yes, it is a palindrome");
		}else {
			System.out.println("No, it is not a palindrome");
		}
		
		scanner.close();
		
	}
	
}