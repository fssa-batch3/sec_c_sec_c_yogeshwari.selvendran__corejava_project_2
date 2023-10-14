package com.fssa.liveon.validator;

import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.liveon.enums.GenderCategory;
import com.fssa.liveon.enums.ServicedVehicleType;
import com.fssa.liveon.exceptions.InvalidBookingDetailException;
import com.fssa.liveon.exceptions.InvalidPartnerDetailsException;
import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;
import com.fssa.liveon.exceptions.InvalidUserDetailsException;
import com.fssa.liveon.model.Partners;
import com.fssa.liveon.model.User;
import com.fssa.liveon.regexpattern.RegexPattern;

public class PartnerValidation {
	public boolean validatePartner(Partners partners) {
		if (partners == null) {
			throw new InvalidPartnerDetailsException(PartnerValidationError.EMPTY_PARTNER_ERROR_MESSAGE);
		}
		validFirstName(partners.getFirstName());
		validLastName(partners.getLastName());
		validEmail(partners.getEmail());
		validPassword(partners.getPassword());
		validNumber(partners.getNumber());
		validGender(partners.getGender());
		idValidate(partners.getPartnerId());
		return true;
	}
	public boolean validatePartnerUpdate(Partners partners) {
		if (partners == null) {
			throw new InvalidPartnerDetailsException(PartnerValidationError.EMPTY_PARTNER_ERROR_MESSAGE);
		}
		validFirstName(partners.getFirstName());
		validLastName(partners.getLastName());
		validNumber(partners.getNumber());
		validGender(partners.getGender());
	
		return true;
	}
	/**
	 * Validates the first name.
	 * 
	 * @param firstName The first name to be validated.
	 * @return True if the first name is valid; otherwise, throws an
	 *         InvalidPartnerDetailsException.
	 * @throws InvalidPartnerDetailsException If the first name is empty or doesn't
	 *                                        match the regex pattern.
	 */
	public boolean validFirstName(String firstName) throws InvalidPartnerDetailsException {
		// Check if the input first name is null or empty.
		if (firstName == null || firstName.trim().isEmpty()) {
			// If it is empty, throw an exception with an appropriate error message.
			throw new InvalidPartnerDetailsException(PartnerValidationError.EMPTY_FIRST_NAME_ERROR_MESSAGE);
		}

		// Define a regex pattern for a valid first name using the USER_FIRST_NAME_REGEX
		// constant.
		String nameregex = RegexPattern.USER_FIRST_NAME_REGEX;

		// Compile the regex pattern into a Pattern object.
		Pattern pattern = Pattern.compile(nameregex);

		// Create a Matcher to match the first name against the regex pattern.
		Matcher matcher = pattern.matcher(firstName);

		// Check if the first name matches the regex pattern.
		if (!matcher.matches()) {
			// If it doesn't match, throw an exception with an appropriate error message.
			throw new InvalidPartnerDetailsException(PartnerValidationError.INVALID_FIRST_NAME_ERROR_MESSAGE);
		}

		// If the first name is not empty and matches the pattern, it is considered
		// valid.
		return true;
	}

	/**
	 * Validates the last name.
	 * 
	 * @param lastName The last name to be validated.
	 * @return True if the last name is valid; otherwise, throws an
	 *         InvalidPartnerDetailsException.
	 * @throws InvalidPartnerDetailsException If the last name is empty or doesn't
	 *                                        match the regex pattern.
	 */
	public boolean validLastName(String lastName) throws InvalidPartnerDetailsException {
		// Step 1: Check if the last name is null or empty.
		if (lastName == null || lastName.trim().isEmpty()) {
			// Step 2: If it's null or empty, throw an InvalidPartnerDetailsException with
			// an appropriate error message.
			throw new InvalidPartnerDetailsException(PartnerValidationError.EMPTY_LAST_NAME_ERROR_MESSAGE);
		}

		// Step 3: Define a regular expression pattern for valid last names.
		String nameregex = RegexPattern.USER_LAST_NAME_REGEX;

		// Step 4: Compile the regex pattern into a Pattern object.
		Pattern pattern = Pattern.compile(nameregex);

		// Step 5: Create a Matcher object to match the last name against the regex
		// pattern.
		Matcher matcher = pattern.matcher(lastName);

		// Step 6: If the last name doesn't match the pattern, throw an
		// InvalidPartnerDetailsException with an appropriate error message.
		if (!matcher.matches()) {
			throw new InvalidPartnerDetailsException(PartnerValidationError.INVALID_LAST_NAME_ERROR_MESSAGE);
		}

		// Step 7: If the last name passes all validations, return true to indicate that
		// it is valid.
		return true;
	}

	/**
	 * Validates the email address.
	 * 
	 * @param email The email address to be validated.
	 * @return True if the email address is valid; otherwise, throws an
	 *         InvalidPartnerDetailsException.
	 * @throws InvalidPartnerDetailsException If the email address is empty or
	 *                                        doesn't match the regex pattern.
	 */
	public boolean validEmail(String email) throws InvalidPartnerDetailsException {
		// Step 1: Check if the email address is null or empty.
		if (email == null || email.trim().isEmpty()) {
			// Step 2: If it's null or empty, throw an InvalidPartnerDetailsException with
			// an appropriate error message.
			throw new InvalidPartnerDetailsException(PartnerValidationError.EMPTY_EMAIL_ERROR_MESSAGE);
		}

		// Step 3: Define a regular expression pattern for valid email addresses.
		String emailRegex = RegexPattern.USER_EMAIL_REGEX;

		// Step 4: Compile the regex pattern into a Pattern object.
		Pattern pattern = Pattern.compile(emailRegex);

		// Step 5: Create a Matcher object to match the email against the regex pattern.
		Matcher matcher = pattern.matcher(email);

		// Step 6: If the email doesn't match the pattern, throw an
		// InvalidPartnerDetailsException with an appropriate error message.
		if (!matcher.matches()) {
			throw new InvalidPartnerDetailsException(PartnerValidationError.INVALID_EMAIL_ERROR_MESSAGE);
		}

		// Step 7: If the email address passes all validations, return true to indicate
		// that it is valid.
		return true;
	}

	/**
	 * Validates the password.
	 * 
	 * @param password The password to be validated.
	 * @return True if the password is valid; otherwise, throws an
	 *         InvalidPartnerDetailsException.
	 * @throws InvalidPartnerDetailsException If the password is empty or doesn't
	 *                                        match the regex pattern.
	 */

	public boolean validPassword(String password) throws InvalidPartnerDetailsException {
		// Step 1: Check if the password is null or empty.
		if (password == null || password.trim().isEmpty()) {
			// Step 2: If it's null or empty, throw an InvalidPartnerDetailsException with
			// an appropriate error message.
			throw new InvalidPartnerDetailsException(PartnerValidationError.EMPTY_PASSWORD_ERROR_MESSAGE);
		}

		// Step 3: Define a regular expression pattern for valid passwords.
		String passwordRegex = RegexPattern.USER_PASSWORD_REGEX;

		// Step 4: Compile the regex pattern into a Pattern object.
		Pattern pattern = Pattern.compile(passwordRegex);

		// Step 5: Create a Matcher object to match the password against the regex
		// pattern.
		Matcher matcher = pattern.matcher(password);

		// Step 6: If the password doesn't match the pattern, throw an
		// InvalidPartnerDetailsException with an appropriate error message.
		if (!matcher.matches()) {
			throw new InvalidPartnerDetailsException(PartnerValidationError.INVALID_PASSWORD_ERROR_MESSAGE);
		}

		// Step 7: If the password passes all validations, return true to indicate that
		// it is valid.
		return true;
	}

	public boolean validNumber(long number) throws InvalidPartnerDetailsException {

		String nameregex = RegexPattern.USER_MOBILE_NUMBER_REGEX;
		Pattern pattern = Pattern.compile(nameregex);
		String numberStr = String.valueOf(number);
		Matcher matcher = pattern.matcher(numberStr);

		if (!matcher.matches()) {
			throw new InvalidPartnerDetailsException(PartnerValidationError.INVALID_NUMBER_ERROR_MESSAGE);
		}

		return true;
	}

	public boolean validGender(String gender) throws InvalidPartnerDetailsException {
		if (gender == null) {
			throw new InvalidPartnerDetailsException(PartnerValidationError.EMPTY_GENDER_ERROR_MESSAGE);
		}
		for (GenderCategory category : GenderCategory.values()) {
			if (category.getGender().equalsIgnoreCase(gender)) {
				return true;
			}
		}
		throw new InvalidPartnerDetailsException(PartnerValidationError.INVALID_GENDER_ERROR_MESSAGE);
	}

	

	public boolean idValidate(int id) throws InvalidPartnerDetailsException {
		if (id <= 0) {
			throw new InvalidPartnerDetailsException(PartnerValidationError.INVALID_PARTNER_ID_ERROR_MESSAGE);
		}
		return true;
	}
	
	
}
