package com.fssa.liveon.exceptions;

/**
 * Define a custom exception class named DAOException, extending the built-in
 * Exception class
 * 
 * @author YogeshwariSelvendran
 *
 */
public class DAOException extends Exception {
	/**
	 * Declare a static final serialVersionUID to ensure version compatibility for
	 * serialization
	 */
	private static final long serialVersionUID = -8105491977357554060L;

	/**
	 * Constructor: Initialize the exception with a custom message
	 * 
	 * @param msg
	 */

	public DAOException(String msg) {
		/**
		 * Call the superclass (Exception) constructor with the provided message
		 */
		super(msg);
	}

	/**
	 * Constructor: Initialize the exception with a throwable (another exception)
	 * 
	 * @param te
	 */
	public DAOException(Throwable te) {
		/**
		 * Call the superclass (Exception) constructor with the provided throwable
		 */
		super(te);
	}

	/**
	 * Constructor: Initialize the exception with a custom message and a throwable
	 * 
	 * @param msg
	 * @param te
	 */
	public DAOException(String msg, Throwable te) {
		/**
		 * Call the superclass (Exception) constructor with both the message and the
		 * throwable
		 */
		super(msg, te);
	}
}