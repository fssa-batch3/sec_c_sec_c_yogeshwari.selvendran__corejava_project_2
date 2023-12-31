package com.fssa.liveon.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.exceptions.InvalidBookingDetailException;
import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;
import com.fssa.liveon.model.Appointment;
import com.fssa.liveon.model.User;
import com.fssa.liveon.util.ConnectionUtil;

public class AppointmentDAO {
	public AppointmentDAO() {

	}

	public boolean addAppointment(Appointment appointment) throws DAOException {
		String insertQuery = "INSERT INTO appointments (user_id, bookingDate, bookingTime, vehicletype, vehicleservice, streetAddress, city, postalCode) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		LocalTime time1 = appointment.getBookingTime();
		Time timeTs1 = Time.valueOf(time1);

		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement preparedStatement = con.prepareStatement(insertQuery)) {

				preparedStatement.setInt(1, appointment.getUserId());
				Date bookingUtilDate = Date.valueOf(appointment.getBookingDate());
				preparedStatement.setDate(2, bookingUtilDate);
				preparedStatement.setTime(3, timeTs1);
				preparedStatement.setString(4, appointment.getVehicletype());
				preparedStatement.setString(5, appointment.getVehicleservice());
				preparedStatement.setString(6, appointment.getStreetAddress());
				preparedStatement.setString(7, appointment.getCity());
				preparedStatement.setString(8, appointment.getPostalCode());
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {

			throw new DAOException(LiveOnDaoErrors.INVALID_ADD_APPOINTMENT);
		}
		return true;
	}

	public boolean updateAppointment(Appointment appointment) throws DAOException, SQLException {
		if (appointment.getBookingId() <= 0) {
			throw new InvalidBookingDetailException(LiveOnDaoErrors.INVALID_ID);
		}
		String selectQuery = "UPDATE appointments SET booking_date = ?, booking_time = ?,"
				+ "street_address = ?, city = ?, postal_code = ? WHERE booking_id = ?";

		LocalTime time1 = appointment.getBookingTime();
		Time timeTs1 = Time.valueOf(time1);

		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {

				preparedStatement.setInt(1, appointment.getUserId());
				Date bookingUtilDate = Date.valueOf(appointment.getBookingDate());
				preparedStatement.setDate(2, bookingUtilDate);
				preparedStatement.setTime(3, timeTs1);
				preparedStatement.setString(4, appointment.getVehicletype());
				preparedStatement.setString(5, appointment.getVehicleservice());
				preparedStatement.setString(6, appointment.getStreetAddress());
				preparedStatement.setString(7, appointment.getCity());
				preparedStatement.setString(8, appointment.getPostalCode());
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			throw new DAOException(LiveOnDaoErrors.INVALID_UPDATE_APPOINTMENT);
		}
		return true;
	}

	public boolean deleteAppointment(int bookingId) throws DAOException, SQLException {
		if (bookingId <= 0) {
			throw new InvalidSparePartDetailsException(LiveOnDaoErrors.INVALID_ID);
		}
		String deleteQuery = "DELETE FROM appointments WHERE bookingId = ?";
		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
				preparedStatement.setInt(1, bookingId);
				preparedStatement.execute();
			}
		} catch (SQLException e) {

			throw new DAOException(LiveOnDaoErrors.INVALID_CANCEL_APPOINTMENT);
		}
		return true;
	}

	public List<Appointment> getAllAppointmentsByUserId(int userId) throws DAOException, SQLException {
		String selectQuery = "SELECT * FROM appointments WHERE user_id = ?";
		List<Appointment> appointments = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {

			preparedStatement.setInt(1, userId);

			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					Appointment booking = new Appointment();
					booking.setBookingId(rs.getInt("bookingId"));
					booking.setBookingDate(rs.getDate("bookingDate").toLocalDate()); // Convert to LocalDate
					booking.setBookingTime(rs.getTime("bookingTime").toLocalTime()); // Convert to LocalTime
					booking.setVehicletype(rs.getString("vehicletype"));
					booking.setVehicleservice(rs.getString("vehicleservice"));
					booking.setStreetAddress(rs.getString("streetAddress"));
					booking.setCity(rs.getString("city"));
					booking.setPostalCode(rs.getString("postalCode"));
					appointments.add(booking);
				}
			}
		} catch (SQLException e) {
			throw new DAOException(LiveOnDaoErrors.INVALID_APPOINTMENT_HISTORY, e);
		}

		return appointments;
	}

	public List<Appointment> getAllAppointmentsAdmin() throws DAOException, SQLException {
		String query = "SELECT a.*, u.firstname, u.lastname, u.gender, u.mobile, u.email " + "FROM appointments a "
				+ "JOIN USER u ON a.user_id = u.id";
		List<Appointment> appointments = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(query)) {

			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					Appointment booking = new Appointment();
					booking.setBookingId(rs.getInt("bookingId"));
					booking.setBookingDate(rs.getDate("bookingDate").toLocalDate()); // Convert to LocalDate
					booking.setBookingTime(rs.getTime("bookingTime").toLocalTime()); // Convert to LocalTime
					booking.setVehicletype(rs.getString("vehicletype"));
					booking.setVehicleservice(rs.getString("vehicleservice"));
					booking.setStreetAddress(rs.getString("streetAddress"));
					booking.setCity(rs.getString("city"));
					booking.setPostalCode(rs.getString("postalCode"));
					User user = new User();
					user.setEmail(rs.getString("email"));
					user.setFirstName(rs.getString("firstname"));
					user.setNumber(rs.getLong("mobile"));
					booking.setUser(user);
					appointments.add(booking);
				}
			}
		} catch (SQLException e) {
			throw new DAOException(LiveOnDaoErrors.INVALID_APPOINTMENT_HISTORY, e);
		}

		return appointments;
	}
}
