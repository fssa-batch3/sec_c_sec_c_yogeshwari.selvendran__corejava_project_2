package com.fssa.liveon.validator;

import java.util.regex.Matcher;

import java.util.regex.Pattern;
import com.fssa.liveon.enums.GenderCategory;
import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;
import com.fssa.liveon.exceptions.InvalidUserDetailsException;
import com.fssa.liveon.model.User;
import com.fssa.liveon.regexpattern.RegexPattern;

public class UserValidation {
	
	public boolean validateUser(User user) {
		if(user == null) {
			throw new InvalidUserDetailsException(UserValidationErrors.USER_ERROR_MESSAGE);
		}
		validFirstName(user.getFirstName());
		validLastName(user.getLastName());
		validEmail(user.getEmail());
		validGender(user.getGender());
		validNumber(user.getNumber());
		validPassword(user.getPassword());
		return true;
	}
	public boolean validFirstName(String firstName) throws InvalidUserDetailsException {
		if (firstName == null || "".equals(firstName.trim())) {
			throw new InvalidUserDetailsException(UserValidationErrors.USER_NULL_ERROR_MESSAGE);
		}
		String nameregex = RegexPattern.USER_FIRST_NAME_REGEX;
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(firstName);
		Boolean isMatch = matcher.matches();
		if (isMatch.equals(Boolean.FALSE)) {
			throw new InvalidUserDetailsException(UserValidationErrors.USER_FIRST_NAME_ERROR_MESSAGE);

		}
		return true;
	}

	public boolean validLastName(String lastName) throws InvalidUserDetailsException {
		if (lastName == null || "".equals(lastName.trim())) {
			throw new InvalidUserDetailsException(UserValidationErrors.USER_NULL_ERROR_MESSAGE);
		}
		String nameregex = RegexPattern.USER_LAST_NAME_REGEX;
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(lastName);
		Boolean isMatch = matcher.matches();
		if (isMatch.equals(Boolean.FALSE)) {
			throw new InvalidUserDetailsException(UserValidationErrors.USER_LAST_NAME_ERROR_MESSAGE);

		}
		return true;
	}

	public boolean validEmail(String email) throws InvalidUserDetailsException {
		if (email == null || "".equals(email.trim())) {
			throw new InvalidUserDetailsException(UserValidationErrors.USER_NULL_ERROR_MESSAGE);
		}
		String nameregex = RegexPattern.USER_EMAIL_REGEX;
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(email);
		Boolean isMatch = matcher.matches();
		if (isMatch.equals(Boolean.FALSE)) {
			throw new InvalidUserDetailsException(UserValidationErrors.INVALID_EMAIL_MESSAGE);

		}
		return true;
	}

	public boolean validPassword(String password) throws InvalidUserDetailsException {
		if (password == null || "".equals(password.trim())) {
			throw new InvalidUserDetailsException(UserValidationErrors.USER_NULL_ERROR_MESSAGE);
		}
		String nameregex = RegexPattern.USER_PASSWORD_REGEX;
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(password);
		Boolean isMatch = matcher.matches();
		if (isMatch.equals(Boolean.FALSE)) {
			throw new InvalidUserDetailsException(UserValidationErrors.PASSWORD_ERROR_MESSAGE);

		}
		return true;
	}

	public boolean validNumber(long number) throws InvalidUserDetailsException {
	
		String nameregex = RegexPattern.USER_MOBILE_NUMBER_REGEX;
		Pattern pattern = Pattern.compile(nameregex);
		String numberStr = String.valueOf(number);
		Matcher matcher = pattern.matcher(numberStr);
		Boolean isMatch = matcher.matches();
		if (Boolean.FALSE.equals(isMatch)) {
			throw new InvalidUserDetailsException(UserValidationErrors.MOBILE_NUMBER_ERROR_MESSAGE);
		}
		
		return true;
	}

	public boolean validGender(String gender)throws InvalidUserDetailsException {
		if(gender == null) {
			throw new InvalidUserDetailsException(UserValidationErrors.USER_NULL_ERROR_MESSAGE);
		}
		for (GenderCategory category : GenderCategory.values()) {
			if (category.getGender().equalsIgnoreCase(gender)) {
				return true;

			}
		}
		throw new InvalidUserDetailsException(UserValidationErrors.GENDER_ERROR_MESSAGE);
	}
//	TODO write a test case
	public boolean validId(int id)throws InvalidUserDetailsException {
		if (id < 0) {
			throw new InvalidUserDetailsException(UserValidationErrors.INVALID_USERID);
		}
		return true;
	}
}
