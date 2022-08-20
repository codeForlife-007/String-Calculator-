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
			return getSum(numbers);
		}
	}

	private static int getSum(String numbers) {
		String[] numbersList = numbers.split(",");
		int sum = 0;
		for (int index = 0; index < numbersList.length; index++) {
			if (numbersList[index].length() == 1) {
				char character = numbersList[index].charAt(0);
				if (Character.isLowerCase(character) ) {
					sum += character - 'a' + 1;
					continue;
				}
			}
			sum += Integer.parseInt(numbersList[index]);
		}
		return sum;
	}
}
