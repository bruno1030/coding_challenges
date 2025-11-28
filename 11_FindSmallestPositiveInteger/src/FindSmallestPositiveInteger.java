// Find the smallest positive integer that is not present in the array of int values

public class FindSmallestPositiveInteger{
	
	public static void main(String[] args) {
		
		int[] A = {1, 2, 3}; // 4
		
		int[] B = {-1, -3}; // 1
		
		int[] C = {1, 3, 6, 4, 1, 2}; //5
		
		System.out.println("Smallest positive integer for int array A: " + findSmallestPositiveInteger(A));
		System.out.println("Smallest positive integer for int array B: " + findSmallestPositiveInteger(B));
		System.out.println("Smallest positive integer for int array C: " + findSmallestPositiveInteger(C));
		
	}
	
	private static int findSmallestPositiveInteger(int[] intArray) {
		
		int smallestPositiveInteger = 1;
		
		boolean numberIsFound = false;
		
		while(!numberIsFound) {
			
			Boolean intArrayContainsNumber = false;
			
			for(int number: intArray) {
				if(number == smallestPositiveInteger) {
					intArrayContainsNumber = true;
					break;
				}
			}
			
			if(intArrayContainsNumber) {
				smallestPositiveInteger++;
			}else {
				numberIsFound = true;
			}
		
		}
		
		return smallestPositiveInteger;
	}
	
}



