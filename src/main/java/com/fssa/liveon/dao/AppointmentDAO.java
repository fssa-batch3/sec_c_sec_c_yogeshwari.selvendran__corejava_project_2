package com.fssa.liveon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.exceptions.InvalidBookingDetailException;
import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;
import com.fssa.liveon.model.Appointment;
import com.fssa.liveon.util.ConnectionUtil;
import com.fssa.liveon.util.Logger;

public class AppointmentDAO {
public AppointmentDAO() {
	
}
public boolean addAppointment(Appointment appointment) throws DAOException, SQLException {
	  String selectQuery = "INSERT INTO bookings (booking_date, booking_time, vehicle_type, vehicle_service, " +
              "street_address, city, postal_code) VALUES (?, ?, ?, ?, ?, ?, ?)";

	  try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {
				preparedStatement.setObject(1, appointment.getBookingDate());
                preparedStatement.setObject(2, appointment.getBookingTime());
                preparedStatement.setString(3, appointment.getVehicletype());
                preparedStatement.setString(4, appointment.getVehicleservice());
                preparedStatement.setString(5, appointment.getStreetAddress());
                preparedStatement.setString(6, appointment.getCity());
                preparedStatement.setString(7, appointment.getPostalCode());
			}
		} catch (SQLException e) {

			throw new DAOException(LiveOnDaoErrors.INVALID_ADD_USER);
		}
		return true;
}


public boolean updateAppointment(Appointment appointment) throws DAOException, SQLException {
	if (appointment.getBookingId() <= 0) {
		throw new InvalidBookingDetailException(LiveOnDaoErrors.INVALID_ID);
	}
	  String selectQuery =  "UPDATE bookings SET booking_date = ?, booking_time = ?," +
              "street_address = ?, city = ?, postal_code = ? WHERE booking_id = ?";

	  try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {
				preparedStatement.setObject(1, appointment.getBookingDate());
                preparedStatement.setObject(2, appointment.getBookingTime());
                preparedStatement.setString(3, appointment.getStreetAddress());
                preparedStatement.setString(4, appointment.getCity());
                preparedStatement.setString(5, appointment.getPostalCode());
                preparedStatement.setInt(6, appointment.getBookingId());
            	preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			throw new DAOException(LiveOnDaoErrors.INVALID_ADD_USER);
		}
		return true;
}
public boolean deleteAppointment(int bookingId) throws DAOException, SQLException {
	if (bookingId <= 0) {
		throw new InvalidSparePartDetailsException(LiveOnDaoErrors.INVALID_ID);
	}
	String deleteQuery = "DELETE FROM bookings WHERE bookingId = ?";
	try (Connection con = ConnectionUtil.getConnection()) {

		try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
			preparedStatement.setInt(1, bookingId);
			preparedStatement.execute();
		}
	} catch (SQLException e) {

		throw new DAOException(LiveOnDaoErrors.INVALID_DELETE_USER);
	}
	return true;
}
}
