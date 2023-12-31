package com.fssa.liveon.dao;

/**
 * This class contains error messages related to product DAO operations.
 */
public class SparePartsDaoErrors {
	private SparePartsDaoErrors() {
		// private constructor
	}

	/**
	 * Error message for failed attempt to add product details to the database.
	 */
	public static final String INVALID_ADD_SPAREPART = "The attempt to add Product details to the database has failed.";
	/**
	 * Error message for failed attempt to update product details in the database.
	 */
	public static final String INVALID_UPDATE_SPAREPART = "The attempt to update Product details in the database has failed.";
	/**
	 * Error message for failed attempt to delete product details from the database.
	 */
	public static final String INVALID_DELETE_SPAREPART = "The attempt to delete Product details from the database has failed.";
	/**
	 * Error message for invalid product ID.
	 */
	public static final String INVALID_ID = "The provided Product ID is invalid.";
	/**
	 * Error message for failed attempt to retrieve all product details from the
	 * database.
	 */
	public static final String INVALID_ALL_SPAREPART = "The attempt to retrieve all Product details from the database has failed.";
}
