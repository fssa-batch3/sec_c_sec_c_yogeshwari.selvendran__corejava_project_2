package com.fssa.liveon.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.liveon.enums.PaymentCategory;
import com.fssa.liveon.exceptions.InvalidBookingDetailException;
import com.fssa.liveon.exceptions.InvalidOrderDetailsException;
import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;
import com.fssa.liveon.exceptions.InvalidUserDetailsException;
import com.fssa.liveon.model.Orders;
import com.fssa.liveon.regexpattern.RegexPattern;

public class OrdersValidation {
	public static boolean validateOrderDetails(Orders order)throws InvalidOrderDetailsException{
		if (order == null) {
			throw new InvalidOrderDetailsException(OrderValidationErrors.EMPTY_ORDERDETAILS);
		}
//		validOrderId(order.getOrderID());
		validUserId(order.getUserId());
		validSparePartId(order.getSparepartId());
		validStreetAddress(order.getStreetAddress());
		validCity(order.getCity());
		validPostalCode(order.getPostalCode());
		validPaymentMethod(order.getPaymentmethod());
		return true;
	}
	
	public static boolean validOrderId(int id) throws InvalidOrderDetailsException {
		if (id < 0) {
			throw new InvalidUserDetailsException(OrderValidationErrors.INVALID_ORDERID);
		}
		return true;
	}
	public static boolean validUserId(int id) throws InvalidOrderDetailsException {
		if (id < 0) {
			throw new InvalidOrderDetailsException(OrderValidationErrors.INVALID_USERID);
		}
		return true;
	}
	public static boolean validSparePartId(int id) throws InvalidOrderDetailsException {
		if (id < 0) {
			throw new InvalidOrderDetailsException(OrderValidationErrors.INVALID_SPAREPART_ID);
		}
		return true;
	}
//	
//	public  static boolean ValidDate(LocalDate bookingDate) throws InvalidOrderDetailsException {
//		LocalDate currentDate = LocalDate.now();
//		if (bookingDate == null) {
//			throw new InvalidBookingDetailException(OrderValidationErrors.EMPTY_DATE);
//		}
//		if (bookingDate.isBefore(currentDate)) {
//			throw new InvalidBookingDetailException(OrderValidationErrors.INVALID_DATE);
//		}
//		return true;
//	}
	
	public static boolean validStreetAddress(String street) throws InvalidOrderDetailsException {
		// Check if the address is not null and not empty
		if (street == null || street.trim().isEmpty()) {
			throw new InvalidBookingDetailException(OrderValidationErrors.EMPTY_STREED_ADDRESS);
		}
		// Define the regex pattern for a simple street address
		String regexPattern = RegexPattern.USER_STREET_REGEX;

		// Create a Pattern object
		Pattern pattern = Pattern.compile(regexPattern);

		// Create a Matcher object
		Matcher matcher = pattern.matcher(street);
		Boolean isMatch = matcher.matches();
		// Check if the street address matches the pattern
		if (isMatch.equals(Boolean.FALSE)) {
			throw new InvalidSparePartDetailsException(OrderValidationErrors.EMPTY_STREED_ADDRESS);
		}
		return true;
	}

	public static boolean validCity(String city) throws InvalidOrderDetailsException {
		// Check if the address is not null and not empty
		if (city == null || city.trim().isEmpty()) {
			throw new InvalidBookingDetailException(OrderValidationErrors.EMPTY_CITY_ADDRESS);
		}
		// Define your regex pattern for a valid city name here
		String regexPattern = RegexPattern.USER_CITY_REGEX;

		// Create a Pattern object
		Pattern pattern = Pattern.compile(regexPattern);

		// Create a Matcher object
		Matcher matcher = pattern.matcher(city);
		Boolean isMatch = matcher.matches();
		// Check if the street address matches the pattern
		if (isMatch.equals(Boolean.FALSE)) {
			throw new InvalidBookingDetailException(OrderValidationErrors.INVALID_CITY_ADDRESS);
		}
		return true;
	}

	public static boolean validPostalCode(String postalCode) throws InvalidOrderDetailsException {
		// Check if the address is not null and not empty
		if (postalCode == null || postalCode.trim().isEmpty()) {
			throw new InvalidBookingDetailException(OrderValidationErrors.EMPTY_POSTALCODE);
		}
		// Define a regex pattern for a postal code (adjust the pattern as needed)
		String regexPattern = RegexPattern.USER_POSTAL_CODE_REGEX;
		// Compile the regex pattern
		Pattern pattern = Pattern.compile(regexPattern);
		// Create a Matcher object and check if the postal code matches the pattern
		Matcher matcher = pattern.matcher(postalCode);
		Boolean isMatch = matcher.matches();
		// Check if the street address matches the pattern
		if (isMatch.equals(Boolean.FALSE)) {
			throw new InvalidBookingDetailException(OrderValidationErrors.INVALID_POSTALCODE);
		}
		return true;
	}
	 public static boolean validPaymentMethod(String payment) {
		 if (payment == null) {

				throw new InvalidBookingDetailException(OrderValidationErrors.EMPTY_PAYMENT_METHOD);
			}
	        for (PaymentCategory category : PaymentCategory.values()) {
	            if (category.getPaymentmethod().equalsIgnoreCase(payment)) {
	                return true;
	            }
	        }
	        throw new InvalidBookingDetailException(OrderValidationErrors.INVALID_PAYMENT_METHOD);
	    }

}
