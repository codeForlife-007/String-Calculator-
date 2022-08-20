package test;

import static org.junit.Assert.*;

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
	
	@Test(expected = StringCalculatorException.class) 
	public void testOneNegativeNumberException() throws StringCalculatorException {
		int result = StringCalculator.add("-12");
	}
	
	@Test(expected = StringCalculatorException.class) 
	public void testMultipleNegativeNumbersException() throws StringCalculatorException {
		int result = StringCalculator.add("-12,65,-13,21,-76,");
	}
}