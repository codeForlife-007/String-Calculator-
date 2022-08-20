package test;

public class StringCalculator {
	
	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		} 
		else if (!numbers.contains(",")) {
			return Integer.parseInt(numbers);
		} 
		else {
			String[] numbersList = numbers.split(",");
			int sum = 0;
			for (int index = 0; index < numbersList.length; index++) {
				sum += Integer.parseInt(numbersList[index]);
			}
			return sum;
		}
	}
}
