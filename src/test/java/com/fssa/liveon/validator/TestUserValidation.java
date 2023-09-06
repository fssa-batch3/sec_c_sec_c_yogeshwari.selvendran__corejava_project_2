package com.fssa.liveon.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.liveon.exceptions.InvalidUserDetailsException;
import com.fssa.liveon.model.User;

public class TestUserValidation {
	UserValidation userValidate = new UserValidation();

	@Test
	void testValidtateUser() {
		User user = new User("Yogi", "S", "Female", "yogeshwari@gmail.com", 9876543210l, "Yogi@123");
		Assertions.assertTrue(userValidate.validateUser(user));
	}

	@Test
	void testInvalidUser() {
		try {
			userValidate.validateUser(null);
		} catch (InvalidUserDetailsException e) {
			Assertions.assertEquals(UserValidationErrors.USER_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	void testValidUserFirstName() {
		Assertions.assertTrue(userValidate.validFirstName("Yogi"));
	}

	@Test
	void testInvalidUserFirstName() {
		try {
			userValidate.validFirstName(null);
		} catch (InvalidUserDetailsException e) {
			Assertions.assertEquals(UserValidationErrors.USER_NULL_ERROR_MESSAGE, e.getMessage());
		}

		try {
			userValidate.validFirstName("yogi3");
			Assertions.fail("Test case failed");
		} catch (InvalidUserDetailsException e) {
			Assertions.assertEquals(UserValidationErrors.USER_FIRST_NAME_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	void testValidUserLastName() {
		Assertions.assertTrue(userValidate.validLastName("S"));
	}

	@Test
	void testInvalidUserLastName() {
		try {
			userValidate.validLastName(null);
		} catch (InvalidUserDetailsException e) {
			Assertions.assertEquals(UserValidationErrors.USER_NULL_ERROR_MESSAGE, e.getMessage());
		}

		try {
			userValidate.validLastName("865");
			Assertions.fail("Test case failed");
		} catch (InvalidUserDetailsException e) {
			Assertions.assertEquals(UserValidationErrors.USER_LAST_NAME_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	void testValidUserEmail() {
		String email = "syogi@gmail.com";
		Assertions.assertTrue(userValidate.validEmail(email));
	}

	@Test
	void testInvalidUserEmail() {
		try {
			userValidate.validEmail(null);
		} catch (InvalidUserDetailsException e) {
			Assertions.assertEquals(UserValidationErrors.USER_NULL_ERROR_MESSAGE, e.getMessage());
		}

		try {
			userValidate.validEmail("wedrftgyh.com");
			Assertions.fail("Test case failed");
		} catch (InvalidUserDetailsException e) {
			Assertions.assertEquals(UserValidationErrors.INVALID_EMAIL_MESSAGE, e.getMessage());
		}
	}

	@Test
	void testValidUserNumber() {
	
		Assertions.assertTrue(userValidate.validNumber(9922920022l));
	}

	@Test
	void testInvalidUserNumber() {
		try {
			userValidate.validNumber(-765432);
			Assertions.fail("Test case failed");
		} catch (InvalidUserDetailsException e) {
			Assertions.assertEquals(UserValidationErrors.MOBILE_NUMBER_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	void testValidUserPassword() {
		Assertions.assertTrue(userValidate.validPassword("Yogi@123"));
	}

	@Test
	void testInvalidUserPassword() {
		try {
			userValidate.validPassword(null);
		} catch (InvalidUserDetailsException e) {
			Assertions.assertEquals(UserValidationErrors.USER_NULL_ERROR_MESSAGE, e.getMessage());
		}

		try {
			userValidate.validPassword("wedrftgyh.com");
			Assertions.fail("Test case failed");
		} catch (InvalidUserDetailsException e) {
			Assertions.assertEquals(UserValidationErrors.PASSWORD_ERROR_MESSAGE, e.getMessage());
		}
	}
	@Test
	void testValidUserId() {
		Assertions.assertTrue(userValidate.validId(4));
	}

	@Test
	void testInvalidUserId() {
		try {
			userValidate.validId(-3);
		} catch (InvalidUserDetailsException e) {
			Assertions.assertEquals(UserValidationErrors.INVALID_USERID , e.getMessage());
		}
}
}