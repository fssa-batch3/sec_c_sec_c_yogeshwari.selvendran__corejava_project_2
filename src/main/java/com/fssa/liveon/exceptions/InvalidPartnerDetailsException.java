package com.fssa.liveon.exceptions;

public class InvalidPartnerDetailsException extends RuntimeException {
	private static final long serialVersionUID = -8105491977357554060L;

	// Calling each super constructors for each of the types
	public InvalidPartnerDetailsException(String msg) {
		super(msg);
	}

	public InvalidPartnerDetailsException(Throwable te) {
		super(te);
		
	}

	
	public InvalidPartnerDetailsException(String msg, Throwable te) {
		
		super(msg, te);
	}
}

