package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculatorExtended {

	public static int add(String numbers) throws StringCalculatorException {
		if (numbers.isEmpty()) {
			return 0;
		} else if (!numbers.contains(",")) {
			return handleCaseForOneNumber(numbers);
		} else {
			return handleCaseForMoreThanOneNumber(numbers);
		}
	}

	private static int handleCaseForOneNumber(String numbers) throws StringCalculatorException {
		int number = Integer.parseInt(numbers);
		if (isNegativeNumber(number)) {
			List<Integer> negativeNumbers = new ArrayList<>();
			negativeNumbers.add(number);
			String errorMessage = generateExceptionMessageForNegativeNumbers(negativeNumbers);
			throw new StringCalculatorException(errorMessage);
		}
		return number;
	}

	private static int handleCaseForMoreThanOneNumber(String numbers) throws StringCalculatorException {
		String[] numbersList = numbers.split(",");

		List<Integer> negativeNumbers = Arrays.stream(numbersList).filter(x -> isNumber(x))
				.map(x -> Integer.parseInt(x)).filter(x -> isNegativeNumber(x)).collect(Collectors.toList());

		if (!negativeNumbers.isEmpty()) {
			String errorMessage = generateExceptionMessageForNegativeNumbers(negativeNumbers);
			throw new StringCalculatorException(errorMessage);
		}
		return getTotalSum(numbersList);
	}

	private static boolean isNegativeNumber(int number) {
		return number < 0;
	}

	private static boolean isNumberMoreThanThousand(int number) {
		return number > 1000;
	}

	private static boolean isNumber(String number) {
		try {
			Integer.parseInt(number);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private static String generateExceptionMessageForNegativeNumbers(List<Integer> negativeNumbers) {
		StringBuilder statusMessage = new StringBuilder();
		statusMessage.append("Negatives not Allowed -: ");
		for (Integer negativeNumber : negativeNumbers) {
			statusMessage.append(negativeNumber);
			statusMessage.append(",");
		}
		return statusMessage.toString().substring(0, statusMessage.length() - 1);
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
			if (isNumberMoreThanThousand(number)) {
				continue;
			}
			sum += number;
		}
		return sum;
	}
}
