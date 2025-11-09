
public class FindMinAndMaxElement{
	
	public static void main(String[] args) {
		
		int[] numbers = new int[]{40,10, 70, 6, 9, 7, 28, 82,80};
		
		int min = numbers[0];
		
		int max = numbers[0];
		
		for (int i : numbers) {
			
			min = i < min ? i : min;
			
			max = i > max ? i : max;
			
		}
		
		System.out.println("Min value: " + min);
		System.out.println("Max value: " + max);
		
	}
	
}