package com.fssa.liveon.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointment {
    private LocalDate bookingDate;
    private LocalDateTime bookingTime;
    private String vehicletype;
    private String vehicleservice;
    private String streetAddress;
    private String city;
    private String postalCode;
    private int bookingId;
   
    
	@Override
	public String toString() {
		return "Appointment [bookingDate=" + bookingDate + ", bookingTime=" + bookingTime + ", vehicletype="
				+ vehicletype + ", vehicleservice=" + vehicleservice + ", streetAddress=" + streetAddress + ", city="
				+ city + ", postalCode=" + postalCode 
				+ ", bookingId=" + bookingId + "]";
	}
	
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalDateTime getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getVehicletype() {
		return vehicletype;
	}
	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}
	public String getVehicleservice() {
		return vehicleservice;
	}
	public void setVehicleservice(String vehicleservice) {
		this.vehicleservice = vehicleservice;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

}