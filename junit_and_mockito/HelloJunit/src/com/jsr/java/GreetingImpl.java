package com.jsr.java;

public class GreetingImpl implements iGreeting {

	@Override
	public String greet(String name) {
		
		if(name == null || name.length()  == 0){
			throw new IllegalArgumentException();
		}
		
		// TODO Auto-generated method stub
		return "Hello "+name;
	}

}
