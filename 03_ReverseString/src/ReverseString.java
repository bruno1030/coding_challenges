import java.util.Scanner;

class ReverseString{
	
	public static void main(String[] args) {
		
		System.out.println("BEGIN");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type a string to reverse");
		String userInput = scanner.nextLine();
		
		char[] originalStringChars = userInput.toCharArray();
				
		StringBuilder reversedUserInput = new StringBuilder();
		
		for (int i = 0; i < originalStringChars.length; i++) {
			char c = originalStringChars[originalStringChars.length - i - 1]; //getting the chars from end to beginning of "originalStringChars" array
			reversedUserInput.append(c);
		}
		
		System.out.println("Reversed string: " + reversedUserInput);
		
		System.out.println("END");
		
	}
	
}