package com.fssa.liveon.dao;

/**
 * This class contains error messages related to product, user, and appointment
 * DAO operations.
 */
public class LiveOnDaoErrors {
	private LiveOnDaoErrors() {
		// private constructor      
	}

	public static final String INVALID_UPDATE_SHOP = "If the update operation fails. ";
	public static final String INVALID_PASSWORD = "Invalid password. Please try again.";
	public static final String EMAIL_NOT_FOUND = "Email not found. Please register or check your email.";
	public static final String DATABASE_ERROR = "Database error. Please try again later.";
	public static final String INVALID_ADD_PARTNER = "Failed to add partner details to the database.";
	/**
	 * Error message for a failed attempt to add product details to the database.
	 */
	public static final String INVALID_ADD_PRODUCT = "Failed to add product details to the database.";

	/**
	 * Error message for a failed attempt to update product details in the database.
	 */
	public static final String INVALID_UPDATE_PRODUCT = "Failed to update product details in the database.";

	/**
	 * Error message for a failed attempt to delete product details from the
	 * database.
	 */
	public static final String INVALID_DELETE_PRODUCT = "Failed to delete product details from the database.";

	/**
	 * Error message for an invalid product ID.
	 */
	public static final String INVALID_ID = "Invalid ID provided.";

	/**
	 * Error message for a failed attempt to retrieve all product details from the
	 * database.
	 */
	public static final String INVALID_GET_ALL_PRODUCTS = "Failed to retrieve all product details from the database.";

	/**
	 * Error message for a failed attempt to add a user to the database.
	 */
	public static final String INVALID_ADD_USER = "Failed to add user details to the database.";

	/**
	 * Error message for a failed attempt to update user details in the database.
	 */
	public static final String INVALID_UPDATE_USER = "Failed to update user details in the database.";

	/**
	 * Error message for a failed attempt to add a booking appointment for a user.
	 */
	public static final String INVALID_ADD_APPOINTMENT = "Failed to book an appointment for the user.";

	/**
	 * Error message for a failed attempt to update a booking appointment for a
	 * user.
	 */
	public static final String INVALID_UPDATE_APPOINTMENT = "Failed to update the booking appointment for the user.";

	/**
	 * Error message for a failed attempt to cancel an appointment for a user.
	 */
	public static final String INVALID_CANCEL_APPOINTMENT = "Failed to cancel the appointment for the user.";

	/**
	 * Error message for an invalid user appointment history.
	 */
	public static final String INVALID_APPOINTMENT_HISTORY = "Invalid user appointment history.";
	/**
	 * Error message for a failed attempt to delete user details from the database.
	 */
	public static final String INVALID_DELETE_USER = "Failed to delete user details from the database.";

	/**
	 * Error message for a user with an existing email address.
	 */
	public static final String USER_EMAIL_EXISTS = "A user with this email address already exists.";

	/**
	 * Error message for an invalid order placement.
	 */
	public static final String INVALID_ORDER_PLACEMENT = "Invalid order placement.";

	/**
	 * Error message for an invalid user order history.
	 */
	public static final String INVALID_ORDER_HISTORY = "Invalid order history.";

	/**
	 * Error message for an email address that already exists.
	 */
	public static final String EMAIL_ALREADY_EXISTS = "Email address already exists in the system.";
	public static final String INVALID_GET_SHOP_DETAILS = "The get shop detsails is invalid";
}
