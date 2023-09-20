package com.fssa.liveon.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.liveon.enums.BikeService;
import com.fssa.liveon.exceptions.InvalidBookingDetailException;
import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;
import com.fssa.liveon.model.Appointment;
import com.fssa.liveon.regexpattern.RegexPattern;

public class AppointmentValidation {

	public AppointmentValidation() {

	}

// EnamValidation enamValidation = new EnamValidation();

	public static boolean ValidateAppointment(Appointment appointment) throws InvalidBookingDetailException {
		if (appointment == null) {
			throw new InvalidBookingDetailException(BookingValidationErrors.INVALID_BOOKINGOBJECT);
		}
		ValidDate(appointment.getBookingDate());
		validTime(appointment.getBookingTime());
		validStreetAddress(appointment.getStreetAddress());
		validCity(appointment.getCity());
		validPostalCode(appointment.getPostalCode());
		validBokkingVehicleType(appointment.getVehicletype());
		idValidate(appointment.getBookingId());
		ValidBikeService(appointment.getVehicleservice());
		// enamValidation.ValidCarService(appointment.getVehicleservice());
		return true;
	}

	public static boolean ValidDate(LocalDate bookingDate) throws InvalidBookingDetailException {
		LocalDate currentDate = LocalDate.now();
		if (bookingDate == null) {
			throw new InvalidBookingDetailException(BookingValidationErrors.EMPTY_BOOKINGDATE);
		}
		if (bookingDate.isBefore(currentDate)) {
			throw new InvalidBookingDetailException(BookingValidationErrors.INVALID_BOOKINGBEFOREDATE);
		}
		return true;
	}

// write a validation for LocalDateTime

	public static boolean validTime(LocalDateTime bookingTime) throws InvalidBookingDetailException {
		LocalDateTime currentTime = LocalDateTime.now();
		if (bookingTime == null) {
			throw new InvalidBookingDetailException(BookingValidationErrors.EMPTY_BOOKINGTIME);
		}
		if (bookingTime.isBefore(currentTime)) {
			throw new InvalidBookingDetailException(BookingValidationErrors.INVALID_BOOKINGBEFORETIME);
		}
//	The time is valid
		return true;
	}

	public static boolean validStreetAddress(String street) throws InvalidBookingDetailException {
		// Check if the address is not null and not empty
		if (street == null || street.trim().isEmpty()) {
			throw new InvalidBookingDetailException(BookingValidationErrors.INVALID_ADDRESS);
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
			throw new InvalidSparePartDetailsException(BookingValidationErrors.INVALID_ADDRESS);
		}
		return true;
	}

	public static boolean validCity(String city) throws InvalidBookingDetailException {
		// Check if the address is not null and not empty
		if (city == null || city.trim().isEmpty()) {
			throw new InvalidBookingDetailException(BookingValidationErrors.INVALID_ADDRESS);
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
			throw new InvalidBookingDetailException(BookingValidationErrors.INVALID_ADDRESS);
		}
		return true;
	}

	public static boolean validPostalCode(String postalCode) throws InvalidBookingDetailException {
		// Check if the address is not null and not empty
		if (postalCode == null || postalCode.trim().isEmpty()) {
			throw new InvalidBookingDetailException(BookingValidationErrors.INVALID_ADDRESS);
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
			throw new InvalidBookingDetailException(BookingValidationErrors.INVALID_ADDRESS);
		}
		return true;
	}

	public static boolean idValidate(int id) throws InvalidBookingDetailException {
		if (id <= 0) {
			throw new InvalidBookingDetailException(BookingValidationErrors.INVALID_APPOINTMENT_ID);
		}
		return true;
	}

	public static boolean validBokkingVehicleType(String vehicleType) throws InvalidBookingDetailException {
		if (vehicleType == null) {
			throw new InvalidSparePartDetailsException(BookingValidationErrors.EMPTY_VEHICLETYPE);
		} else if (vehicleType == "Bike") {
			return true;
		} else {
			throw new InvalidSparePartDetailsException(BookingValidationErrors.EMPTY_VEHICLETYPE);
		}
	}
	// create a validation for bike service
	public static boolean ValidBikeService(String service) {
        for (BikeService bikeService : BikeService.values()) {
            if (bikeService.getBikeService().equalsIgnoreCase(service)) {
                return true; // Service is valid
            }
        }
        return false; // Service is not valid
    }
}