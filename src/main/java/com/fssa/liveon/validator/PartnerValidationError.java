package com.fssa.liveon.validator;

public class PartnerValidationError {
	/**
	 * Error message for an empty partner details.
	 */
	public static final String EMPTY_PARTNER_ERROR_MESSAGE = "Partner details cannot be empty";

	/**
	 * Error message for an invalid partner ID format.
	 */

	public static final String INVALID_PARTNER_ID_ERROR_MESSAGE = "Invalid partner ID format";

	/**
	 * Error message for an empty first name.
	 */
	public static final String EMPTY_FIRST_NAME_ERROR_MESSAGE = "First name cannot be empty";

	/**
	 * Error message for an invalid first name. First name must contain only letters
	 * and spaces, with a length between 2 and 35 characters.
	 */
	public static final String INVALID_FIRST_NAME_ERROR_MESSAGE = "First name must contain only letters and spaces, with a length between 2 and 35 characters.";

	/**
	 * Error message for an empty last name.
	 */
	public static final String EMPTY_LAST_NAME_ERROR_MESSAGE = "Last name cannot be empty";

	/**
	 * Error message for an invalid last name. Last name must contain only letters
	 * and spaces, with a length between 1 and 35 characters.
	 */
	public static final String INVALID_LAST_NAME_ERROR_MESSAGE = "Last name must contain only letters and spaces, with a length between 1 and 35 characters.";

	/**
	 * Error message for an empty email address.
	 */
	public static final String EMPTY_EMAIL_ERROR_MESSAGE = "Email address cannot be empty";

	/**
	 * Error message for an invalid email address format.
	 */
	public static final String INVALID_EMAIL_ERROR_MESSAGE = "Invalid email address format. Please use a valid email address.";

	/**
	 * Error message for an empty password.
	 */
	public static final String EMPTY_PASSWORD_ERROR_MESSAGE = "Password cannot be empty";

	/**
	 * Error message for an invalid password. Password must contain at least one
	 * digit, one lowercase letter, one uppercase letter, and be at least 8
	 * characters long.
	 */
	public static final String INVALID_PASSWORD_ERROR_MESSAGE = "Password must contain at least one digit, one lowercase letter, one uppercase letter, and be at least 8 characters long.";

	/**
	 * Error message for an empty gender.
	 */
	public static final String EMPTY_GENDER_ERROR_MESSAGE = "Gender cannot be empty";

	/**
	 * Error message for an invalid gender type.
	 */
	public static final String INVALID_GENDER_ERROR_MESSAGE = "Invalid gender type";
	
	/**
	 * Error message for an invalid mobile number format. Mobile number should be a
	 * 10-digit number starting with a digit between 6 and 9.
	 */
	public static final String INVALID_NUMBER_ERROR_MESSAGE = "Invalid mobile number. Please enter a 10-digit number starting with a digit between 6 and 9.";

}