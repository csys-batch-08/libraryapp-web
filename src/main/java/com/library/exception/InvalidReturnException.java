package com.library.exception;

public class InvalidReturnException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return "invalidReturn.jsp";
	}
}
