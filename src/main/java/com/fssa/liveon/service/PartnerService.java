package com.fssa.liveon.service;

import java.sql.SQLException;

import com.fssa.liveon.dao.PartnerDAO;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.exceptions.InvalidPartnerDetailsException;
import com.fssa.liveon.model.Partners;
import com.fssa.liveon.validator.PartnerValidation;

public class PartnerService {
	PartnerDAO partnerDao = new PartnerDAO();
	PartnerValidation partnerValidation = new PartnerValidation();

	public boolean addPartner(Partners partner) throws DAOException, SQLException, InvalidPartnerDetailsException {
		if (partnerValidation.validatePartner(partner) && !partnerDao.getPartnerEmail(partner.getEmail())) {
			partnerDao.addPartnerDetails(partner);
		}
		return true;
	}

	public boolean updatePartner(Partners partner) throws DAOException, SQLException, InvalidPartnerDetailsException {
		if (partnerValidation.validatePartnerUpdate(partner)) {
			partnerDao.updatePartnerDetails(partner);
		}
		return true;
	}

	public Partners getPartnerById(int id) throws SQLException, DAOException, InvalidPartnerDetailsException {
		return partnerDao.getPartnerById(0);
	}

	public Partners getPartnerByEmailAndPassword(String email, String enteredPassword)
			throws DAOException, SQLException, InvalidPartnerDetailsException {

		return partnerDao.getPartnerByEmailAndPassword(email, enteredPassword);
	}

	public boolean validatePartnerEmail(String email)
			throws SQLException, DAOException, InvalidPartnerDetailsException {
		boolean partnerExists = partnerDao.getPartnerEmail(email);
		if (partnerExists) {
			return true;
		}
		return false;
	}
}
