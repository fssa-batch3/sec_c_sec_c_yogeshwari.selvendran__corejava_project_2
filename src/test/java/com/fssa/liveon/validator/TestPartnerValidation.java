package com.fssa.liveon.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.liveon.builder.PartnerBuilder;
import com.fssa.liveon.exceptions.InvalidBookingDetailException;
import com.fssa.liveon.exceptions.InvalidPartnerDetailsException;
import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;
import com.fssa.liveon.exceptions.InvalidUserDetailsException;
import com.fssa.liveon.model.Partners;

public class TestPartnerValidation {
	PartnerValidation partners = new PartnerValidation();

	@Test
	void testPartners() {

		Partners partner = new PartnerBuilder().buildPartnerFirstName("Yogi").buildPartnerLastName("S")
				.buildPartnerGender("Female").buildPartnerEmail("yogeshwari@gmail.com").buildPartnerNumber(9876543210l)
				.buildPartnerPassword("Yogi@123").build();

		Assertions.assertTrue(partners.validatePartner(partner));
	}

	@Test
	void testInvaidPartner() {
		try {
			// Validating a null Product object should throw an
			// InvalidProductDetailsException
			partners.validatePartner(null);
			Assertions.fail("Test case failed");
		} catch (InvalidPartnerDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(PartnerValidationError.EMPTY_PARTNER_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	void testValidPartnerFirstName() {
		Assertions.assertTrue(partners.validFirstName("Yogi"));
	}

	@Test
	void testInvalidPartnerFirstName() {
		try {
			partners.validFirstName(null);
		} catch (InvalidPartnerDetailsException e) {
			Assertions.assertEquals(PartnerValidationError.EMPTY_FIRST_NAME_ERROR_MESSAGE, e.getMessage());
		}

		try {
			partners.validFirstName("yogi3");
			Assertions.fail("Test case failed");
		} catch (InvalidPartnerDetailsException e) {
			Assertions.assertEquals(PartnerValidationError.INVALID_FIRST_NAME_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	void testValidPartnerLastName() {
		Assertions.assertTrue(partners.validLastName("S"));
	}

	@Test
	void testInvalidPartnerLastName() {
		try {
			partners.validLastName(null);
		} catch (InvalidPartnerDetailsException e) {
			Assertions.assertEquals(PartnerValidationError.EMPTY_LAST_NAME_ERROR_MESSAGE, e.getMessage());
		}

		try {
			partners.validLastName("865");
			Assertions.fail("Test case failed");
		} catch (InvalidPartnerDetailsException e) {
			Assertions.assertEquals(PartnerValidationError.INVALID_LAST_NAME_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	void testValidPartnerEmail() {
		String email = "syogi@gmail.com";
		Assertions.assertTrue(partners.validEmail(email));
	}

	@Test
	void testInvalidPartnerEmail() {
		try {
			partners.validEmail(null);
		} catch (InvalidPartnerDetailsException e) {
			Assertions.assertEquals(PartnerValidationError.EMPTY_EMAIL_ERROR_MESSAGE, e.getMessage());
		}

		try {
			partners.validEmail("wedrftgyh.com");
			Assertions.fail("Test case failed");
		} catch (InvalidPartnerDetailsException e) {
			Assertions.assertEquals(PartnerValidationError.INVALID_EMAIL_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	void testValidPartnerNumber() {

		Assertions.assertTrue(partners.validNumber(9922920022l));
	}

	@Test
	void testInvalidPartnerNumber() {
		try {
			partners.validNumber(-765432);
			Assertions.fail("Test case failed");
		} catch (InvalidPartnerDetailsException e) {
			Assertions.assertEquals(PartnerValidationError.INVALID_NUMBER_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	void testValidPartnerPassword() {
		Assertions.assertTrue(partners.validPassword("Yogi@123"));
	}

	@Test
	void testInvalidPartnerPassword() {
		try {
			partners.validPassword(null);
		} catch (InvalidPartnerDetailsException e) {
			Assertions.assertEquals(PartnerValidationError.EMPTY_PASSWORD_ERROR_MESSAGE, e.getMessage());
		}

		try {
			partners.validPassword("wedrftgyh.com");
			Assertions.fail("Test case failed");
		} catch (InvalidPartnerDetailsException e) {
			Assertions.assertEquals(PartnerValidationError.INVALID_PASSWORD_ERROR_MESSAGE, e.getMessage());
		}
	}

//	@Test
//	void testValidPartnerId() {
//		Assertions.assertTrue(partners.idValidate(3));
//	}
//
//	@Test
//	void testInvalidPartnerId() {
//		try {
//			partners.idValidate(-2);
//		} catch (InvalidPartnerDetailsException e) {
//			Assertions.assertEquals(PartnerValidationError.INVALID_PARTNER_ID_ERROR_MESSAGE, e.getMessage());
//		}
//	}

	
}