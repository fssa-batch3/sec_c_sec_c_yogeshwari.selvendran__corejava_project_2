package com.fssa.liveon.validator;

public class ShopValivationErrors {
//	Invalid product name
	public static final String EMPTY_SHOP_NAME = "shop name  cannot be empty or null";
	public static final String INVALID_SHOP_NAME = "The name should be  minimum 2 letters and maximum 35 letters";
//	Product Description
	public static final String EMPTY_SHOP_DETAILS = "Shop details is cannot be empty or null";
	
	public static final String INVALID_SHOP_DETAILS = "The details should be  minimum 2 letters and maximum 300 letters";
	/**
	 * Error message for an empty partner details.
	 */
	public static final String EMPTY_SHOP_ERROR_MESSAGE = "Shop details cannot be empty";

	/**
	 * Error message for an empty first name.
	 */
	public static final String EMPTY_SHOP_NAME_ERROR_MESSAGE = "First name cannot be empty";

	/**
	 * Error message for an empty mobile number.
	 */
	public static final String INVALID_SHOP_NUMBER_ERROR_MESSAGE = "Invalid mobile number. Please enter a 10-digit number.";

	/**
	 * Error message for an invalid mobile number format. Mobile number should be a
	 * 10-digit number starting with a digit between 6 and 9.
	 */
	public static final String INVALID_NUMBER_ERROR_MESSAGE = "Invalid mobile number. Please enter a 10-digit number starting with a digit between 6 and 9.";
	/**
	 * Error message for an invalid partner ID format.
	 */
	public static final String INVALID_SHOP_ID_ERROR_MESSAGE = "Invalid shop ID format";

	/**
	 * Error message for an empty or null image URL.
	 */
	public static final String EMPTY_IMAGE_URL_ERROR_MESSAGE = "Image URL cannot be empty or null";

	/**
	 * Error message for an invalid image URL format.
	 */

	/**
	 * Error message for an empty street address.
	 */
	public static final String EMPTY_STREET_ADDRESS_ERROR_MESSAGE = "Street address cannot be empty";

	/**
	 * Error message for an empty city.
	 */
	public static final String EMPTY_CITY_ERROR_MESSAGE = "City cannot be empty";

	/**
	 * Error message for an empty postal code.
	 */
	public static final String EMPTY_POSTAL_CODE_ERROR_MESSAGE = "Postal code cannot be empty";

	/**
	 * Error message for an invalid street address format.
	 */
	public static final String INVALID_STREET_ADDRESS_ERROR_MESSAGE = "Invalid street address format. Please provide a valid street address.";

	/**
	 * Error message for an invalid city format.
	 */
	public static final String INVALID_CITY_ERROR_MESSAGE = "Invalid city format. Please provide a valid city name.";

	/**
	 * Error message for an invalid postal code format.
	 */
	public static final String INVALID_POSTAL_CODE_ERROR_MESSAGE = "Invalid postal code format. Please use a valid postal code.";
	/**
	 * Error message for an invalid image URL format.
	 */
	public static final String INVALID_IMAGE_URL_ERROR_MESSAGE = "Invalid image URL format. Please provide a valid URL.";

	/**
	 * Error message for an invalid vehicle type.
	 */
	public static final String INVALID_VEHICLETYPE = "Vehicle type is invalid";

	/**
	 * Error message for an empty vehicle type.
	 */
	public static final String EMPTY_VEHICLETYPE = "Vehicle type cannot be null or empty";

}
