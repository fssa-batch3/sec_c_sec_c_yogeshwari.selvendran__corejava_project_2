package com.fssa.liveon.validator;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.liveon.builder.AppointmentBuilder;
import com.fssa.liveon.exceptions.InvalidBookingDetailException;
import com.fssa.liveon.model.Appointment;
public class TestAppointmentValidation {
	AppointmentValidation booking = new AppointmentValidation();
//	static Logger logger = new Logger();
	
	@Test
	void testBooking() {
		Appointment booking1 = new AppointmentBuilder()
				.buildBookingDate(LocalDate.of(2023, 9, 22))
			    .buildBookingTime(LocalTime.of(16, 30))
			    .buildVehicleType("Bike")
			    .buildVehicleService("Bike wash and polish")
			    .buildStreetAddress("northStreet")
			    .buildCity("Madurai")
			    .buildPostalCode("654321")
			    .buildUserId(1)
			    .build();
		Assertions.assertTrue(booking.ValidateAppointment(booking1));
	}
	@Test
	void testInValidBooking() {
		try {
			booking.ValidateAppointment(null);
			Assertions.fail("Test case failed");
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingValidationErrors.INVALID_BOOKING_OBJECT, e.getMessage());
		}
	}
		@Test
		public void testValidDate() {
			LocalDate currentDate = LocalDate.now();
			LocalDate validDate = currentDate.plusDays(1);
			Assertions.assertTrue(AppointmentValidation.ValidDate(validDate));
		}
		
		@Test
		public void testInvalidDate() {
			LocalDate currentDate = LocalDate.now();
			LocalDate invalidDate = currentDate.minusDays(1);
			try {
				AppointmentValidation.ValidDate(invalidDate);
				Assertions.fail("Test case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.INVALID_BOOKING_BEFORE_DATE, e.getMessage());
			}

			try {
				AppointmentValidation.ValidDate(null);
				Assertions.fail("Test case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.EMPTY_BOOKING_DATE, e.getMessage());
			}

		}
		
		@Test
		public void testValidTime() {
			LocalTime currentTime = LocalTime.now();
			LocalTime validTime = currentTime.plusMinutes(30);
			Assertions.assertTrue(AppointmentValidation.validTime(validTime));
		}

	//invalid date
		@Test
		public void testInvalidTime() {
			LocalTime currentTime = LocalTime.now();
			LocalTime invalidTime = currentTime.minusMinutes(10);
			try {
				AppointmentValidation.validTime(invalidTime);
				Assertions.fail("Test case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors. INVALID_BOOKING_BEFORE_TIME, e.getMessage());
			}
			try {
				AppointmentValidation.validTime(null);
				Assertions.fail("Test case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.EMPTY_BOOKING_TIME, e.getMessage());
			}
		}
		@Test
		public void testValidStreet() {
		String Street = "123 Main St";
			Assertions.assertTrue(AppointmentValidation.validStreetAddress(Street));
		}
		
		@Test
		public void testInvalidStreet() {
			try {
				AppointmentValidation.validStreetAddress(null);
				Assertions.fail("Test case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.EMPTY_STREET_ADDRESS , e.getMessage());
			}

			try {
				AppointmentValidation.validStreetAddress("8754321");
				
				Assertions.fail("Test case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.INVALID_STREET_ADDRESS, e.getMessage());
			}
		}
		
		@Test
		public void testValidCity() {
		String City = "Madurai";
			Assertions.assertTrue(AppointmentValidation.validCity(City));
		}
		
		@Test
		public void testInvalidCity() {
			try {
				AppointmentValidation.validCity(null);
				Assertions.fail("Test case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.EMPTY_CITY_NAME, e.getMessage());
			}

			try {
				AppointmentValidation.validCity("8754321");
				
				Assertions.fail("Test case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.INVALID_CITY_NAME, e.getMessage());
			}
		}

		@Test
		public void testValidPostalCode() {
		String Pincode = "654321";
			Assertions.assertTrue(AppointmentValidation.validCity(Pincode));
		}
		
		@Test
		public void testInvalidPostalCode() {
			try {
				AppointmentValidation.validCity(null);
				Assertions.fail("Test case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.EMPTY_PINCODE_ADDRESS, e.getMessage());
			}

			try {
				AppointmentValidation.validCity("north");
				
				Assertions.fail("Test case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.INVALID_PINCODE_ADDRESS, e.getMessage());
			}
		}
		@Test
		public void testValidVehiclyType() {
		String Vehicle = "Bike";
			Assertions.assertTrue(AppointmentValidation.validCity(Vehicle));
		}
		
		@Test
		public void testInvalidVehiclyType() {
			try {
				AppointmentValidation.validCity(null);
				Assertions.fail("Test case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.EMPTY_VEHICLE_TYPE, e.getMessage());
			}

			try {
				AppointmentValidation.validCity("Car");
				
				Assertions.fail("Test case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.INVALID_VEHICLE_TYPE, e.getMessage());
			}
		}
		
}
