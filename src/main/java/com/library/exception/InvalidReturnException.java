package com.library.exception;

public class InvalidReturnException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
