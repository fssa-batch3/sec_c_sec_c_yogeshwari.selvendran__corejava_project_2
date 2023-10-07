package com.fssa.liveon.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.liveon.dao.AppointmentDAO;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.exceptions.InvalidBookingDetailException;
import com.fssa.liveon.model.Appointment;
import com.fssa.liveon.util.Logger;
import com.fssa.liveon.validator.AppointmentValidation;

public class AppointmentService {
	public AppointmentService() {

	}

	static Logger logger = new Logger();
	AppointmentDAO appointmentDao = new AppointmentDAO();
	AppointmentValidation appointmentValidation = new AppointmentValidation();

	public boolean addAppointment(Appointment appointment) throws DAOException, SQLException,InvalidBookingDetailException {
		if (appointmentValidation.ValidateAppointment(appointment)) {
			appointmentDao.addAppointment(appointment);
		}
		return true;
	}

	public boolean updateAppointment(Appointment appointment) throws DAOException, SQLException {
		if (appointmentValidation.ValidateAppointment(appointment)) {
			appointmentDao.updateAppointment(appointment);
		}
		return true;
	}

	public boolean deleteAppointment(int appointmentId) throws DAOException, SQLException {
		if (appointmentValidation.idValidate(appointmentId)) {
			appointmentDao.deleteAppointment(appointmentId);
		}
		return true;
	}
	
	public List<Appointment> getAppointmentsByUserId(int id)throws DAOException, SQLException{
		return appointmentDao.getAllAppointmentsByUserId(id);
	}
	
	public List<Appointment> getAllAppointmentForAdmin() throws DAOException, SQLException{
	return appointmentDao.getAllAppointmentsAdmin();
	}
}
