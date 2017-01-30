package com.revature.exception;

public class NullItemFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NullItemFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NullItemFoundException(String message) {
		super(message);
	}

}
