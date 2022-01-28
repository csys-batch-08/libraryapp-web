package com.library.exception;

public class InvalidCategoryException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "invalidCategory.jsp";
	}

}
