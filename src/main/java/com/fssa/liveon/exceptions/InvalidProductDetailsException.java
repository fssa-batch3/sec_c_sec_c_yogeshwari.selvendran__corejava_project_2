package com.fssa.liveon.exceptions;

public class InvalidProductDetailsException extends RuntimeException {
	private static final long serialVersionUID = -8105491977357554060L;

	// Calling each super constructors for each of the types
	public InvalidProductDetailsException(String msg) {
		super(msg);
	}

	public InvalidProductDetailsException(Throwable te) {
		super(te);
		
	}

	
	public InvalidProductDetailsException(String msg, Throwable te) {
		
		super(msg, te);
	}
}
