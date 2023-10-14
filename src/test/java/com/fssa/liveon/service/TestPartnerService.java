package com.fssa.liveon.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.liveon.builder.PartnerBuilder;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.Partners;
import com.fssa.liveon.model.User;
import com.fssa.liveon.util.Logger;

public class TestPartnerService {
	static Logger logger = new Logger();
	PartnerService partnerService = new PartnerService();
	
	Partners getValidPartner() {
		Partners partner = new PartnerBuilder().buildPartnerId(1).buildPartnerFirstName("Yogi").buildPartnerLastName("S")
				.buildPartnerGender("Female").buildPartnerEmail("yogeshwari@gmail.com").buildPartnerNumber(9876543210l)
				.buildPartnerPassword("Yogi@123").build();
		return partner;
	}
	Partners getValidPartner1() {
		Partners partner1 = new PartnerBuilder().buildPartnerId(3).buildPartnerFirstName("Yogi").buildPartnerLastName("S")
				.buildPartnerGender("Female").buildPartnerNumber(9876543310l)
				.build();
		return partner1;
	}
	@Test
	void  testAddPartner() throws DAOException, SQLException{
		Partners p = getValidPartner();
	Assertions.assertTrue(partnerService.addPartner(p));
	}
	@Test
	void  testUpdatePartner() throws DAOException, SQLException{
		Partners p = getValidPartner1();
	Assertions.assertTrue(partnerService.updatePartner(p));
	}
	
	@Test
	void testGetPartnerByEmailAndPass() throws DAOException, SQLException{
		 String email = "yogiYOGI@gmail.com";
		    String password = "YogiS@123";
		    Partners u=	partnerService.getPartnerByEmailAndPassword(email, password );
	logger.info(u);
	assertNotNull(u);
	assertEquals(email, u.getEmail());
	}
	@Test
	void testGetPartnerByEmail() throws DAOException, SQLException{
	Partners u=	partnerService.getPartnerById(1);
	logger.info(u);
	}
	
	
	
	
	
}
