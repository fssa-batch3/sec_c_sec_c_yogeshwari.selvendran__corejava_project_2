package com.fssa.liveon.validator;

public class BookingValidationErrors {
    
    /**
     * Error message for invalid or empty appointment input object.
     */
    public static final String INVALID_BOOKING_OBJECT = "Invalid or empty appointment input object.";

    /**
     * Error message for empty or null booking date.
     */
    public static final String EMPTY_BOOKING_DATE = "Booking date cannot be empty or null.";

    /**
     * Error message for booking date in the past.
     */
    public static final String INVALID_BOOKING_BEFORE_DATE = "Booking date should be in the present or future.";

    /**
     * Error message for empty or null booking time.
     */
    public static final String EMPTY_BOOKING_TIME = "Booking time cannot be empty or null.";

    /**
     * Error message for booking time in the past.
     */
    public static final String INVALID_BOOKING_BEFORE_TIME = "Booking time should be in the present or future.";

     /**
     * Error message for invalid or empty service element.
     */
    public static final String INVALID_SERVICE = "Service element is invalid or empty.";

    /**
     * Error message for invalid or empty address.
     */
    public static final String INVALID_ADDRESS = "Address is empty or null.";

    /**
     * Error message for invalid street address.
     */
    public static final String INVALID_STREET_ADDRESS = "Invalid street address.";
    public static final String EMPTY_CITY_ADDRESS = "Empty or null city address.";
    public static final String EMPTY_PINCODE_ADDRESS = "Empty or null pincode address.";
    public static final String EMPTY_STREET_ADDRESS = "Empty or null Street address.";

    /**
     * Error message for invalid city address.
     */
    public static final String INVALID_CITY_ADDRESS = "Invalid city address.";

    /**
     * Error message for invalid pincode address.
     */
    public static final String INVALID_PINCODE_ADDRESS = "Invalid pincode address.";

    /**
     * Error message for invalid vehicle type.
     */
    public static final String INVALID_VEHICLE_TYPE = "Invalid vehicle type.";

    /**
     * Error message for invalid bike service.
     */
    public static final String INVALID_BIKE_SERVICE = "Invalid bike service.";

    /**
     * Error message for invalid car service.
     */
    public static final String INVALID_CAR_SERVICE = "Invalid car service.";

    /**
     * Error message for empty or null vehicle type.
     */
    public static final String EMPTY_VEHICLE_TYPE = "Vehicle type cannot be empty or null.";

    /**
     * Error message for empty bike service.
     */
    public static final String EMPTY_BIKE_SERVICE = "Bike service cannot be empty or null.";

    /**
     * Error message for empty car service.
     */
    public static final String EMPTY_CAR_SERVICE = "Car service cannot be empty or null.";

    /**
     * Error message for invalid appointment id.
     */
    public static final String INVALID_APPOINTMENT_ID = "Invalid appointment id.";

    /**
     * Error message for failed attempt to add appointment details to the database.
     */
    public static final String INVALID_ADD_APPOINTMENT = "Failed to add appointment details to the database.";

    /**
     * Error message for failed attempt to update appointment details in the database.
     */
    public static final String INVALID_UPDATE_APPOINTMENT = "Failed to update appointment details in the database.";

    /**
     * Error message for failed attempt to delete appointment details from the database.
     */
    public static final String INVALID_DELETE_APPOINTMENT = "Failed to delete appointment details from the database.";

    /**
     * Error message for failed attempt to read appointment details from the database.
     */
    public static final String INVALID_READ_APPOINTMENT = "Failed to read appointment details from the database.";

    /**
     * Error message for an invalid booking id.
     */
    public static final String INVALID_BOOKING_ID = "Invalid booking id passed.";
}
