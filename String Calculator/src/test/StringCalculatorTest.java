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
		int result = StringCalculator.add("12,a,12,12,z");
		assertEquals(63, result);
	}
	
	@Test(expected = StringCalculatorException.class) 
	public void testOneNumberNegativeException() throws StringCalculatorException {
		int result = StringCalculator.add("-12");
	}
}