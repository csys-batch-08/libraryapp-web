package com.library.exception;

public class NumberFormatException1 extends Exception {
	String message1="Only allow numbers";

	public NumberFormatException1(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NumberFormatException1() {
		// TODO Auto-generated constructor stub
		System.out.println(message1);
		
	}

}
