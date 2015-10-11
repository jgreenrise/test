package com.jsr.maven.calculator;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorImplTest {

	private int num1, num2, result;

	public CalculatorImplTest(int num1, int num2, int result) {
		this.num1 = num1;
		this.num2 = num2;
		this.result = result;
	}
	
	@Parameters
	public static Collection<Integer[]> data(){
		return Arrays.asList(new Integer [] [] {{-1, 2, 1}, {3,4,7}, {5,-10, -5}});
	}

	@Test
	public void test_add() {
		iCalculator cal = new CalculatorImpl();
		int actual = cal.add(num1, num2);
		assertEquals(result, actual);
	}

}
