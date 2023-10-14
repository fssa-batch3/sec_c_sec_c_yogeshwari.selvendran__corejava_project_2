package com.fssa.liveon.validator;

public class UserValidationErrors {
    /**
     * Error message for null or empty user inputs.
     */
    public static final String USER_NULL_ERROR_MESSAGE = "User inputs can not be null or empty";

    /**
     * Error message for an invalid first name. First name must contain only letters and spaces,
     * with a length between 2 and 35 characters.
     */
    public static final String USER_FIRST_NAME_ERROR_MESSAGE = "First name must contain only letters and spaces, with a length between 2 and 35 characters.";

    /**
     * Error message for an invalid last name. Last name must contain only letters and spaces,
     * with a length between 1 and 35 characters.
     */
    public static final String USER_LAST_NAME_ERROR_MESSAGE = "Last name must contain only letters and spaces, with a length between 1 and 35 characters.";

    /**
     * Error message for an invalid email address format.
     */
    public static final String INVALID_EMAIL_MESSAGE = "Invalid email address format. Please use a valid email address.";

    /**
     * Error message for an invalid password. Password must contain at least one digit, one lowercase letter,
     * one uppercase letter, and be at least 8 characters long.
     */
    public static final String PASSWORD_ERROR_MESSAGE = "Password must contain at least one digit, one lowercase letter, one uppercase letter, and be at least 8 characters long.";

    /**
     * Error message for an invalid mobile number format. Mobile number should be a 10-digit number starting with a digit between 6 and 9.
     */
    public static final String MOBILE_NUMBER_ERROR_MESSAGE = "Invalid mobile number. Please enter a 10-digit number starting with a digit between 6 and 9.";

    /**
     * Error message for an invalid gender type.
     */
    public static final String GENDER_ERROR_MESSAGE = "Invalid gender type";

    /**
     * Error message for overall invalid user details.
     */
    public static final String USER_ERROR_MESSAGE = "User Details is invalid";

    /**
     * Error message for an invalid user ID.
     */
    public static final String INVALID_USERID = "The User ID is invalid";
}
