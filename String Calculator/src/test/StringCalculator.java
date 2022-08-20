package test;

public class StringCalculator {
	
	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		} 
		else if (!numbers.contains(",")) {
			return Integer.parseInt(numbers);
		} 
		return -1;
	}
}
