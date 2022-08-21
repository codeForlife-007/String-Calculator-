package test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static int add(String numbers) throws StringCalculatorException {
		int result;
		if (numbers.isEmpty()) {
			result = 0;
		}  else if (numbers.startsWith("//")) {
			result = getTotalSumSeparatedByUserEnteredDelimiter(numbers);
		} else if (numbers.contains(",") || numbers.contains("\n")) {
			result = getTotalSumSeparatedByDefaultDelimiter(numbers);
		} else {
			result = getOneConsolidatedNumber(numbers);
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
	
	private static int getTotalSumSeparatedByDefaultDelimiter(String numbers) throws StringCalculatorException {
		return getTotalSumSeparatedByDelimiter(numbers, ",|\n");
	}
	
	private static int getTotalSumSeparatedByUserEnteredDelimiter(String numbers) throws StringCalculatorException {
		Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(numbers);
		matcher.find();
		return getTotalSumSeparatedByDelimiter(matcher.group(2), matcher.group(1));
	}
	
	private static int getTotalSumSeparatedByDelimiter(String numbers, String delimiter) throws StringCalculatorException {
		String[] numbersList = numbers.split(delimiter);
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
		for (int index = 0; index < numbers.length; index++) {
			if(StringCalculatorUtil.isNumber(numbers[index])) { 
				int number = Integer.parseInt(numbers[index]);
				if(StringCalculatorUtil.isNegativeNumber(number)) {
					negativeNumbers.add(number);
				}
			}
		}
		return negativeNumbers;
	}
}
