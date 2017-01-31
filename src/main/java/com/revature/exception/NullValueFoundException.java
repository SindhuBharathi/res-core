package com.revature.exception;

public class NullValueFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NullValueFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NullValueFoundException(String message) {
		super(message);
	}

}
