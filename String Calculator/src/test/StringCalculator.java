package test;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public static int add(String numbers) throws StringCalculatorException {
		int result;
		if (numbers.isEmpty()) {
			result = 0;
		} else if (!numbers.contains(",")) {
			result = getOneConsolidatedNumber(numbers);
		} else {
			result = getTotalSumSeparatedByDelimiter(numbers);
		}
		return result;
	}

	private static int getOneConsolidatedNumber(String numbers) throws StringCalculatorException {
		int number = Integer.parseInt(numbers);
		if (StringCalculatorUtil.isNegativeNumber(number)) {
			List<Integer> negativeNumbers = new ArrayList<>();
			negativeNumbers.add(number);
			String errorMessage = StringCalculatorUtil.generateExceptionMessageForNegativeNumbers(negativeNumbers);
			throw new StringCalculatorException(errorMessage);
		}
		return number;
	}

	private static int getTotalSumSeparatedByDelimiter(String numbers) throws StringCalculatorException {
		String[] numbersList = numbers.split(",");
		List<Integer> negativeNumbers = getNegativeNumbers(numbersList);
		if (!negativeNumbers.isEmpty()) {
			String errorMessage = StringCalculatorUtil.generateExceptionMessageForNegativeNumbers(negativeNumbers);
			throw new StringCalculatorException(errorMessage);
		}
		return getTotalSum(numbersList);
	}

	private static int getTotalSum(String[] numbersList) {
		int sum = 0;
		for (int index = 0; index < numbersList.length; index++) {
			if (numbersList[index].length() == 1) {
				char character = numbersList[index].charAt(0);
				if (Character.isLowerCase(character)) {
					sum += character - 'a' + 1;
					continue;
				}
			}
			int number = Integer.parseInt(numbersList[index]);
			if (StringCalculatorUtil.isNumberMoreThanThousand(number)) {
				continue;
			}
			sum += number;
		}
		return sum;
	}
	
	private static List<Integer> getNegativeNumbers(String[] numbers) {
		List<Integer> negativeNumbers = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			if(StringCalculatorUtil.isNumber(numbers[i])) { 
				int number = Integer.parseInt(numbers[i]);
				if(StringCalculatorUtil.isNegativeNumber(number)) {
					negativeNumbers.add(number);
				}
			}
		}
		return negativeNumbers;
	}
}
