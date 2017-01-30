package com.revature.exception;

public class NegativeIdFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegativeIdFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NegativeIdFoundException(String message) {
		super(message);
	}

}
