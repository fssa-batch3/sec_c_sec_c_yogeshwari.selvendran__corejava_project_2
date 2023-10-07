package com.fssa.liveon.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
//		LocalDate date = LocalDate.of(2023, 9, 22);
//		LocalTime time = LocalTime.of(16, 30);
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
		return booking1;
	}
	Appointment getAppointment1() {
		LocalDate date = LocalDate.of(2023, 8, 3);
		LocalTime time = LocalTime.of(16, 30);
		Appointment booking2 = new AppointmentBuilder().buildBookingId(1).buildBookingDate(date).buildBookingTime(time).buildVehicleType("Bike").buildVehicleService("Bike wash and polish")
				.buildStreetAddress("northStreet").buildCity("Madurai").buildPostalCode("654321").buildUserId(1).build();
		return booking2;
	}

	@Test
	void testAddAppintment()throws DAOException, SQLException {
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
	@Test
	void testAppointmentsByUserId()throws DAOException, SQLException{
		Appointment ap = getAppointment();
		List<Appointment> bookinlist = service.getAppointmentsByUserId(1);
		for(Appointment p : bookinlist) {
			Logger.info(p);
		}
	}
}
