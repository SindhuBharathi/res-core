package com.revature.exception;

public class NegativeValueFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegativeValueFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NegativeValueFoundException(String message) {
		super(message);
	}

}
