import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

class CountVowelsAndConsonants {

	public static void main(String[] args) {
		
		System.out.println("BEGIN");
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your text");
		
		String userInput = scanner.nextLine();
		
		System.out.println("User input: '" + userInput + "'");
		
		char[] userInputChars = userInput.toLowerCase().toCharArray();
		
		// considering 'y' as consonant
		Set<Character> charsSet = Set.of('a', 'e', 'i', 'o', 'u');
		
		int countVowels = 0;
		int countConsonants = 0;
		
		for (int i = 0; i < userInputChars.length; i++) {
			char c = userInputChars[i];
			if(Character.isLetter(c)) {
				if(charsSet.contains(c)) {
					countVowels++;
				}else {
					countConsonants++;
				}
			}
		}
		
		System.out.println("Count vowels: " + String.valueOf(countVowels));
		
		System.out.println("Count consonants: " + String.valueOf(countConsonants));
		
	}
	
}
