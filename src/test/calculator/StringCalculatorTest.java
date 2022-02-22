package test.calculator;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import main.calculator.StringCalculator;

public class StringCalculatorTest {
   
	@Test
	public void shouldReturnZeroForEmptyString() {
		assertEquals(0, StringCalculator.add(""));	}
	@Test
	public void shouldReturnSumOfTwoNumbers() {
		assertEquals(3,StringCalculator.add("1,2"));}
	@Test
	public void shouldReturnSumOfUknownAmountOfNumbers() {
		assertEquals(10,StringCalculator.add("1,2,3,4"));}
	
	@Test
	public void shouldReturnSumOfManyNumbersSeparedByComasAndLines() {
		assertEquals(6,StringCalculator.add("1\n2,3"));}
	
	@Test
	public void shouldReturnSumOfManyNumbersSeparedByDifferentDelimiters() {
		assertEquals( 3,StringCalculator.add("//;\\n1;2"));}
	
	@Test
	public void shouldThrowExceptionIfNegativesArePresent() {
		 Exception exception = assertThrows(NumberFormatException.class, () -> {
			 StringCalculator.add("1,-2,4,-3");
		    });
		 assertTrue(exception.getMessage().contains("negatives not allowed"));
		 assertTrue(exception.getMessage().contains("-2"));
		 assertTrue(exception.getMessage().contains("-3"));
		
}
	
}
