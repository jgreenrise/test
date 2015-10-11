package com.jsr.test;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jsr.java.GreetingImpl;
import com.jsr.java.iGreeting;

public class GreetingImplTest {
	
	private iGreeting greeting;

	@Before
	public void setup(){
		greeting = new GreetingImpl();
	}

	@Test
	public void greet_should_return_valid_output() {
		String actual = greeting.greet("Junit");
		String expected = "Hello Junit";
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void greet_should_throw_an_exception_for_name_is_null() {
		greeting.greet(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void greet_should_throw_an_exception_for_name_is_bank() {
		greeting.greet("");
	}
	
	@After
	public void tearDown(){
		greeting = null;
	}

}
