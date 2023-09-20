package com.fssa.liveon.exceptions;

public class InvalidBookingDetailException extends RuntimeException {
	private static final long serialVersionUID = -8105491977357554060L;

	// Calling each super constructors for each of the types
	public InvalidBookingDetailException(String msg) {
		super(msg);
	}

	public InvalidBookingDetailException(Throwable te) {
		super(te);
		
	}

	
	public InvalidBookingDetailException(String msg, Throwable te) {
		
		super(msg, te);
	}
}
