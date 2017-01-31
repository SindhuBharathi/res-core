package com.revature.exception;

public class ItemServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ItemServiceException(String message) {
		super(message);
	}

}
