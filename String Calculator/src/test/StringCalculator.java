package test;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	
	public static int add(String numbers) throws StringCalculatorException {
			if (numbers.isEmpty()) {
				return 0;
			} 
			else if (!numbers.contains(",")) {
				int number = Integer.parseInt(numbers);
				if(isNegativeNumber(number)) {
					StringBuilder statusMessage = new StringBuilder();
					statusMessage.append("Negatives not Allowed -");
					statusMessage.append(number);
					throw new StringCalculatorException(statusMessage.toString());
				}
				return number;
			} 
			else {
				return getSum(numbers);
			}
	}

	private static int getSum(String numbers) throws StringCalculatorException {
		String[] numbersList = numbers.split(",");
		int sum = 0;
		List<Integer> negativeNumbers = new ArrayList<>();
		for (int index = 0; index < numbersList.length; index++) {
			if (numbersList[index].length() == 1) {
				char character = numbersList[index].charAt(0);
				if (Character.isLowerCase(character) ) {
					sum += character - 'a' + 1;
					continue;
				}
			}
			int number = Integer.parseInt(numbersList[index]);
			
			if (isNegativeNumber(number)) {
				negativeNumbers.add(number);
				continue;
			}
			sum += number;
		}
		if(!negativeNumbers.isEmpty()) {
			StringBuilder statusMessage = new StringBuilder();
			statusMessage.append("Negatives not Allowed -: ");
			for (Integer negativeNumber : negativeNumbers) {
				statusMessage.append(negativeNumber);
				statusMessage.append(",");
			}
			throw new StringCalculatorException(statusMessage.toString().substring(0, statusMessage.length() - 1));
		}
		return sum;
	}
	
	public static boolean isNegativeNumber(int number) {
		return number < 0;
	}

}
