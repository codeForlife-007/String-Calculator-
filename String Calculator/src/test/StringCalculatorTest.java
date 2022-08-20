package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testNumberEmptyString(){
		int result = StringCalculator.add("");
		assertEquals(0, result);	
	}
	
	@Test 
	public void testOneNumberInInputString() {
		int result = StringCalculator.add("143");
		assertEquals(143, result);
	}
	
	@Test 
	public void testTwoNumbersInInputString() {
		int result = StringCalculator.add("143,23");
		assertEquals(166, result);
	}
	
	@Test 
	public void testMultipleNumbersInInputString() {
		int result = StringCalculator.add("150,50,50,50");
		assertEquals(300, result);
	}
}