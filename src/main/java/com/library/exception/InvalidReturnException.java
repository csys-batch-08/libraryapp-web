package com.library.exception;

public class InvalidReturnException extends Exception {
	
	String message="You dont have any pending books to return";
	
	public String message() {
		return this.message;
	}
	
	public InvalidReturnException () {
		message();
		
	}

	@Override
	public String toString() {
		return  message;
	}

}
