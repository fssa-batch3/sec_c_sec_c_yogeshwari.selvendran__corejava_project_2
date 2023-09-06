package com.fssa.liveon.validator;

public class UserValidationErrors {
	public static final String USER_NULL_ERROR_MESSAGE = "User inputs can not be null or empty";
	public static final String USER_FIRST_NAME_ERROR_MESSAGE = "First name must contain only letters and spaces, with a length between 2 and 35 characters.";
	public static final String USER_LAST_NAME_ERROR_MESSAGE = "Last name must contain only letters and spaces, with a length between 1 and 35 characters.";
	public static final String INVALID_EMAIL_MESSAGE = "Invalid email address format. Please use a valid email address.";
	public static final String PASSWORD_ERROR_MESSAGE = "Password must contain at least one digit, one lowercase letter, one uppercase letter, and be at least 8 characters long.";
	public static final String MOBILE_NUMBER_ERROR_MESSAGE = "Invalid mobile number. Please enter a 10-digit number starting with a digit between 6 and 9.";
	public static final String GENDER_ERROR_MESSAGE = "Invalid gender type";
	public static final String USER_ERROR_MESSAGE = "User Details is invalid";
	public static final String INVALID_USERID = "The User id is invalid";
}
