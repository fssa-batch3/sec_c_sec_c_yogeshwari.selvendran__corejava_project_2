package com.fssa.liveon.exceptions;

/**
 * Defining a custom exception class that extends the RuntimeException class
 * 
 * @author YogeshwariSelvendran
 *
 */
public class InvalidSparePartDetailsException extends RuntimeException {
	/**
	 * Define a constant serial version UID to ensure compatibility during
	 * serialization
	 */
	private static final long serialVersionUID = -8105491977357554060L;

	/**
	 * Constructor that takes a custom error message as input
	 * 
	 * @param msg
	 */
	public InvalidSparePartDetailsException(String msg) {
		/**
		 * Call the constructor of the parent class (RuntimeException) and pass the
		 * error message
		 */
		super(msg);
	}

	/**
	 * Constructor that takes a Throwable (exception) as input
	 * 
	 * @param te
	 */
	public InvalidSparePartDetailsException(Throwable te) {
		/**
		 * Call the constructor of the parent class (RuntimeException) and pass the
		 * exception
		 */
		super(te);

	}
	

	/**
	 * Constructor that takes both a custom error message and a Throwable as inputs
	 * 
	 * @param msg
	 * @param te
	 */
	public InvalidSparePartDetailsException(String msg, Throwable te) {
		/**
		 * Call the constructor of the parent class (RuntimeException) and pass both the
		 * custom error message and the exception
		 */
		super(msg, te);
	}
}
