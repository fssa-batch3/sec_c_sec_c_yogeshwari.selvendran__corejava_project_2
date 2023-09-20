package com.fssa.liveon.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.liveon.builder.AppointmentBuilder;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.Appointment;
import com.fssa.liveon.util.Logger;

public class TestAppointmentService {
	AppointmentService service = new AppointmentService();
	static Logger logger = new Logger();
	
	
	Appointment getAppointment() {
		LocalDate date = LocalDate.of(2023, 8, 3);
		LocalDateTime time = LocalDateTime.of(2023, 8, 3, 12, 0);
		Appointment booking1 = new AppointmentBuilder()
				.buildBookingDate(date).buildBookingTime(time).buildVehicleType("Bike").buildVehicleService("Bike wash and polish")
				.buildStreetAddress("northStreet").buildCity("Madurai").buildPostalCode("654321").build();
		return booking1;
	}
	Appointment getAppointment1() {
		LocalDate date = LocalDate.of(2023, 8, 3);
		LocalDateTime time = LocalDateTime.of(2023, 8, 3, 12, 0);
		Appointment booking2 = new AppointmentBuilder().buildBookingId(1).buildBookingDate(date).buildBookingTime(time).buildVehicleType("Bike").buildVehicleService("Bike wash and polish")
				.buildStreetAddress("northStreet").buildCity("Madurai").buildPostalCode("654321").build();
		return booking2;
	}

	@Test
	void testAddAppointment()throws DAOException, SQLException {
		Appointment booking = getAppointment();
		Assertions.assertTrue(service.addAppointment(booking));
	}
	
	@Test
	void testUpdateAppointment()throws DAOException, SQLException {
		Appointment booking = getAppointment1();
		Assertions.assertTrue(service.updateAppointment(booking));
	}
	@Test
	void testDeleteAppointment()throws DAOException, SQLException {
	
		Assertions.assertTrue(service.deleteAppointment(1));
	}
}
