package com.fssa.liveon.exceptions;

public class InvalidShopDetailsException extends RuntimeException {
	private static final long serialVersionUID = -8105491977357554060L;

	// Calling each super constructors for each of the types
	public InvalidShopDetailsException(String msg) {
		super(msg);
	}

	public InvalidShopDetailsException(Throwable te) {
		super(te);
		
	}

	
	public InvalidShopDetailsException(String msg, Throwable te) {
		
		super(msg, te);
	}
}
