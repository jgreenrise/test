package com.jsr.maven.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorImplTest {

	@Test
	public void test_add() {
		iCalculator cal = new CalculatorImpl();
		int actual = cal.add(10,  20);
		assertEquals(30, actual);
	}

}
