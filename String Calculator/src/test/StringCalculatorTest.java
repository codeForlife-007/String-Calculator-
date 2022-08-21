package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testNumberEmptyString() throws StringCalculatorException{
		int result = StringCalculator.add("");
		assertEquals(0, result);	
	}
	
	@Test 
	public void testOneNumberInInputString() throws StringCalculatorException {
		int result = StringCalculator.add("143");
		assertEquals(143, result);
	}
	
	@Test 
	public void testTwoNumbersInInputString() throws StringCalculatorException {
		int result = StringCalculator.add("143,23");
		assertEquals(166, result);
	}
	
	@Test 
	public void testMultipleNumbersInInputString() throws StringCalculatorException {
		int result = StringCalculator.add("150,50,50,50");
		assertEquals(300, result);
	}
	
	@Test 
	public void testLowerCaseCharacterInInputString() throws StringCalculatorException {
		int result = StringCalculator.add("12,a,1,12,z");
		assertEquals(52, result);
	}
	
	@Test
	public void testOneNegativeNumberException() throws StringCalculatorException {
		try {			
			int result = StringCalculator.add("-12");
		} catch (StringCalculatorException e) {
			String errorMessage = "Negatives not Allowed -: -12";
			assertEquals(errorMessage, e.getMessage());
		};
	}
	
	@Test 
	public void testMultipleNegativeNumbersException() throws StringCalculatorException {
		try {			
			int result = StringCalculator.add("-12,65,-13,21,-76,");
		} catch (StringCalculatorException e) {
			String errorMessage = "Negatives not Allowed -: -12,-13,-76";
			assertEquals(errorMessage, e.getMessage());
		};
	}
	
	@Test 
	public void testNumbersMoreThanThousand() throws StringCalculatorException {
		int result = StringCalculator.add("1001,201,103,1005");
		assertEquals(304, result);
	}
	
	@Test
	public void testToHandleNewLinesBetweenNumbers() throws StringCalculatorException {
		int result = StringCalculator.add("1\n2,3,4\n5");
		assertEquals(15, result);
	}
	
	@Test 
	public void testToSupportDifferentDelimiters() throws StringCalculatorException {
		int result = StringCalculator.add("//;\n1;2;3");
		assertEquals(6, result);
	}
}