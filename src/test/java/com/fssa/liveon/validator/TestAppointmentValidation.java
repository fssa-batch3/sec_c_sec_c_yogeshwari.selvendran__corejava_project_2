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
		LocalDate date = LocalDate.of(2023, 8, 3);
		LocalDateTime time = LocalDateTime.of(2023, 8, 3, 12, 0);
		Appointment booking1 = new AppointmentBuilder()
				.buildBookingDate(date).buildBookingTime(time).buildVehicleType("Bike").buildVehicleService("Bike wash and polish")
				.buildStreetAddress("northStreet").buildCity("Madurai").buildPostalCode("654321").build();
		Assertions.assertTrue(booking.ValidateAppointment(booking1));
	}
	@Test
	void testInValidBooking() {
		try {
			booking.ValidateAppointment(null);
			Assertions.fail("Test case failed");
		} catch (InvalidBookingDetailException e) {
			Assertions.assertEquals(BookingValidationErrors.INVALID_BOOKINGBEFOREDATE, e.getMessage());
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
				Assertions.assertEquals(BookingValidationErrors.INVALID_BOOKINGBEFOREDATE, e.getMessage());
			}

			try {
				AppointmentValidation.ValidDate(null);
				Assertions.fail("Test case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.EMPTY_BOOKINGDATE, e.getMessage());
			}

		}
		
		@Test
		public void testValidTime() {
			LocalDateTime currentTime = LocalDateTime.now();
			LocalDateTime validTime = currentTime.plusMinutes(30);
			Assertions.assertTrue(AppointmentValidation.validTime(validTime));
		}

	//invalid date
		@Test
		public void testInvalidTime() {
			LocalDateTime currentTime = LocalDateTime.now();
			LocalDateTime invalidTime = currentTime.minusMinutes(10);
			try {
				AppointmentValidation.validTime(invalidTime);
				Assertions.fail("Test case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.INVALID_BOOKINGBEFORETIME, e.getMessage());
			}
			try {
				AppointmentValidation.validTime(null);
				Assertions.fail("Test case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.EMPTY_BOOKINGTIME, e.getMessage());
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
				Assertions.fail("Tset case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.EMPTY_USEREMAIL, e.getMessage());
			}

			try {
				AppointmentValidation.validStreetAddress("8754321");
				
				Assertions.fail("Tset case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.INVALID_USEREMAIL, e.getMessage());
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
				Assertions.fail("Tset case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.EMPTY_USEREMAIL, e.getMessage());
			}

			try {
				AppointmentValidation.validCity("8754321");
				
				Assertions.fail("Tset case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.INVALID_USEREMAIL, e.getMessage());
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
				Assertions.fail("Tset case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.EMPTY_USEREMAIL, e.getMessage());
			}

			try {
				AppointmentValidation.validCity("north");
				
				Assertions.fail("Tset case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.INVALID_USEREMAIL, e.getMessage());
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
				Assertions.fail("Tset case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.EMPTY_USEREMAIL, e.getMessage());
			}

			try {
				AppointmentValidation.validCity("Car");
				
				Assertions.fail("Tset case failed");
			} catch (InvalidBookingDetailException e) {
				Assertions.assertEquals(BookingValidationErrors.INVALID_USEREMAIL, e.getMessage());
			}
		}
		
//		@Test
//		public void testValidBikeService() {
//			String BikeService = "Bike wash and polish";
//			try {
//				ValidBikeService(BikeService);
//			} catch (InvalidBookingDetailException e) {
//				Assertions.assertEquals(BookingValidationErrors.INVALID_BIKESERVICE, e.getMessage());
//			}
//
//		}
//
//
//	// test invalid bike service
//		@Test
//		public void testInvalidBikeService() {
////		empty Bike Service
//			try {
//				ValidBikeService(null);
//				Assertions.fail("Test case failed");
//			} catch (InvalidBookingDetailException e) {
//				Assertions.assertEquals(BookingValidationErrors.EMPTY_BIKESERVICE, e.getMessage());
//			}
////		invalid  Bike Service
//			try {
//				ValidBikeService("Wheel alignment");
//				Assertions.fail("Test case failed");
//
//			} catch (InvalidBookingDetailException e) {
//				Assertions.assertEquals(BookingValidationErrors.INVALID_BIKESERVICE, e.getMessage());
//			}
//		}
}
