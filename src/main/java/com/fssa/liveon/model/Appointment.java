package com.fssa.liveon.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Appointment {
	private LocalDate bookingDate;
	private LocalTime bookingTime;
	private String vehicletype;
	private String vehicleservice;
	private String streetAddress;
	private String city;
	private String postalCode;
	private int bookingId;
	private int userId;
	private String bookingStatus;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalTime bookingTime) {
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@Override
	public String toString() {
		return "Appointment [bookingDate=" + bookingDate + ", bookingTime=" + bookingTime + ", vehicletype="
				+ vehicletype + ", vehicleservice=" + vehicleservice + ", streetAddress=" + streetAddress + ", city="
				+ city + ", postalCode=" + postalCode + ", bookingId=" + bookingId + ", userId=" + userId
				+ ", bookingStatus=" + bookingStatus + "]";
	}
	
	
	
}