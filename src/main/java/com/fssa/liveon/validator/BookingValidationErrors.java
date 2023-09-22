package com.fssa.liveon.validator;

public class BookingValidationErrors {
	public static final String INVALID_BOOKINGOBJECT = "Appointment inputs can not be null or empty";
	public static final String EMPTY_BOOKINGDATE = "Booking date cannot be empty or null";
	public static final String INVALID_BOOKINGBEFOREDATE = "Booking date should be in the present";
	public static final String EMPTY_BOOKINGTIME = "Booking Time cannot be empty or null";
	public static final String INVALID_BOOKINGBEFORETIME = "Booking Time should be in the present";
	public static final String EMPTY_MOBILENUMBER = "Number cannot be null or must be exactly 10 characters";
	public static final String INVALID_MOBILENUMBER = "Number should only contain digits";
	public static final String INVALID_USEREMAIL = "The email address is Invalid";
	public static final String EMPTY_USEREMAIL = "The email address is null or empty";
	public static final String INVALID_USERNAME = "Name cannot be empty or null or name should be minimum 3 character";
	public static final String INVALID_SERVICE = "element is null or empty";
	public static final String INVALID_ADDRESS = "Address is null or empty";
	public static final String INVALID_STREET_ADDRESS = " street Address is invalid";
	public static final String INVALID_CITY_ADDRESS = " city Address is invalid";
	public static final String INVALID_PINCODE_ADDRESS = " pincode Address is invalid";
	public static final String INVALID_VEHICLETYPE = "Vehicle type is invalid";
	public static final String INVALID_BIKESERVICE = "Bike service is invalid";
	public static final String INVALID_CARSERVICE = "Car service is invalid";
	public static final String EMPTY_VEHICLETYPE = "Vehicle type cannot be null or empty";
	public static final String EMPTY_BIKESERVICE = "Bike Srvice cannot benull or empty";
	public static final String EMPTY_CARSERVICE = "Car Srvice cannot benull or empty";
	public static final String INVALID_APPOINTMENT_ID = "appointment id is invalid";
	public static final String INVALID_ADD_APPOINTMENT = "The ADD Appointment details to database is failed";
	public static final String INVALID_UPDATE_APPOINTMENT = "The Update Appointment details to database is failed";
	public static final String INVALID_DELETE_APPOINTMENT = "The Delete Appointment details to database is failed";
	public static final String INVALID_READ_APPOINTMENT = "The Read Appointment details to database is failed";
	public static final String INVALID_BOOKING_ID = "Invalid Booking id passed";
}
