package com.fssa.liveon.builder;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fssa.liveon.model.Appointment;

public class AppointmentBuilder {
	private LocalDate appointmentBookingDateForBuilder;
	private LocalTime appointmentbookingTimeForBuilder;
	private String appointmentvehicletypeForBuilder;
	private String appointmentvehicleserviceForBuilder;
	private String appointmentstreetAddressForBuilder;
	private String appointmentcityForBuilder;
//    private String appointmentstateProvinceForBuilder;
	private String appointmentpostalCodeForBuilder;
//    private String appointmentcountryForBuilder;
	private int appointmentbookingIdForBuilder;
	private int appointmentUserIdForBuilder;
	private String appointmentbookingStatusForBuilder;

	public AppointmentBuilder buildBookingDate(LocalDate bookingDate) {
		this.appointmentBookingDateForBuilder = bookingDate;
		return this;
	}

	public AppointmentBuilder buildBookingTime(LocalTime bookingTime) {
		this.appointmentbookingTimeForBuilder = bookingTime;
		return this;
	}

	public AppointmentBuilder buildVehicleType(String vehicletype) {
		this.appointmentvehicletypeForBuilder = vehicletype;
		return this;
	}

	public AppointmentBuilder buildVehicleService(String vehicleservice) {
		this.appointmentvehicleserviceForBuilder = vehicleservice;
		return this;
	}

	public AppointmentBuilder buildStreetAddress(String streetAddress) {
		this.appointmentstreetAddressForBuilder = streetAddress;
		return this;
	}

	public AppointmentBuilder buildCity(String city) {
		this.appointmentcityForBuilder = city;
		return this;
	}

//    public AppointmentBuilder withStateProvince(String stateProvince) {
//        this.appointmentstateProvinceForBuilder = stateProvince;
//        return this;
//    }

	public AppointmentBuilder buildPostalCode(String postalCode) {
		this.appointmentpostalCodeForBuilder = postalCode;
		return this;
	}

	public AppointmentBuilder buildbookingStatus(String bookingStatus) {
		this.appointmentbookingStatusForBuilder = bookingStatus;
		return this;
	}

	public AppointmentBuilder buildBookingId(int bookingId) {
		this.appointmentbookingIdForBuilder = bookingId;
		return this;
	}

	public AppointmentBuilder buildUserId(int userId) {
		this.appointmentUserIdForBuilder = userId;
		return this;
	}

	public Appointment build() {
		Appointment appointment = new Appointment();
		appointment.setBookingDate(appointmentBookingDateForBuilder);
		appointment.setBookingTime(appointmentbookingTimeForBuilder);
		appointment.setVehicletype(appointmentvehicletypeForBuilder);
		appointment.setVehicleservice(appointmentvehicleserviceForBuilder);
		appointment.setBookingId(appointmentbookingIdForBuilder);
		appointment.setCity(appointmentcityForBuilder);
		appointment.setBookingStatus(appointmentbookingStatusForBuilder);
		appointment.setPostalCode(appointmentpostalCodeForBuilder);
		appointment.setUserId(appointmentUserIdForBuilder);
		appointment.setStreetAddress(appointmentstreetAddressForBuilder);

		return appointment;
	}
}
