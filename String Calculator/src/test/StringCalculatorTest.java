package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testNumberEmptyString(){
		int result = StringCalculator.add("");
		assertEquals(0, result);
	}
}