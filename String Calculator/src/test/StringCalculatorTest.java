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
	public void testStringWithOneNumber() {
		int result = StringCalculator.add("143");
		assertEquals(143, result);
	}
}