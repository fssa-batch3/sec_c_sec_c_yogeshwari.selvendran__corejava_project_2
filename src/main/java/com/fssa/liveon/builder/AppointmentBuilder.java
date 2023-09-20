package com.fssa.liveon.builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fssa.liveon.model.Appointment;

public class AppointmentBuilder {
    private LocalDate appointmentBookingDateForBuilder;
    private LocalDateTime appointmentbookingTimeForBuilder;
    private String appointmentvehicletypeForBuilder;
    private String appointmentvehicleserviceForBuilder;
    private String appointmentstreetAddressForBuilder;
    private String appointmentcityForBuilder;
//    private String appointmentstateProvinceForBuilder;
    private String appointmentpostalCodeForBuilder;
//    private String appointmentcountryForBuilder;
    private int appointmentbookingIdForBuilder;

    public AppointmentBuilder buildBookingDate(LocalDate bookingDate) {
        this.appointmentBookingDateForBuilder = bookingDate;
        return this;
    }

    public AppointmentBuilder buildBookingTime(LocalDateTime bookingTime) {
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

//    public AppointmentBuilder withCountry(String country) {
//        this.appointmentcountryForBuilder = country;
//        return this;
//    }

    public AppointmentBuilder buildBookingId(int bookingId) {
        this.appointmentbookingIdForBuilder = bookingId;
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
  //  	appointment.setStateProvince(appointmentstateProvinceForBuilder);
    	appointment.setPostalCode(appointmentpostalCodeForBuilder);
   // 	appointment.setCountry(appointmentcountryForBuilder);
    	appointment.setStreetAddress(appointmentstreetAddressForBuilder);

       return appointment;
    }
}
