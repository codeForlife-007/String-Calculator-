package test;

import java.util.List;

public class StringCalculatorUtil {
	
	public static boolean isNegativeNumber(int number) {
		return number < 0;
	}

	public static boolean isNumberMoreThanThousand(int number) {
		return number > 1000;
	}

	public static boolean isNumber(String number) {
		try {
			Integer.parseInt(number);
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public static String generateExceptionMessageForNegativeNumbers(List<Integer> negativeNumbers) {
		StringBuilder statusMessage = new StringBuilder();
		statusMessage.append("Negatives not Allowed -: ");
		for (int negativeNumber : negativeNumbers) {
			statusMessage.append(negativeNumber);
			statusMessage.append(",");
		}
		return statusMessage.toString().substring(0, statusMessage.length() - 1);
	}
}
