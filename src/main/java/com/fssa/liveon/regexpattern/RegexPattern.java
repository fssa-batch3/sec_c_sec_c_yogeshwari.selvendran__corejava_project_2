package com.fssa.liveon.regexpattern;

public class RegexPattern {

	private RegexPattern() {
		
//		private constructor
	}
	public static final String PRODUCT_NAME_REGEX = "^[a-zA-Z ]{2,35}$";
	public static final String ABOUT_PRODUCT_REGEX = "^[a-zA-Z0-9\\\\p{P}\\\\p{S}]{10,250}$";
	public static final String PRODUCT_DESCRIPTION_REGEX = "^[A-Za-z0-9\\s\\p{P}]{7,500}$";
	public static final String PRODUCT_IMAGE_REGEX = "(?i)\\b((https?|ftp)://)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?\\.(jpg|jpeg|gif|png|bmp)\\b";
	public static final String USER_FIRST_NAME_REGEX = "^[a-zA-Z ]{2,35}$";
	public static final String USER_LAST_NAME_REGEX = "^[a-zA-Z ]{1,35}$";
	public static final String USER_EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
	public static final String USER_PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
	public static final String USER_MOBILE_NUMBER_REGEX = "(0/91)?[7-9][0-9]{9}";
	public static final String USER_STREET_REGEX = "^[0-9A-Za-z\\s.,-]+$";
	public static final String USER_CITY_REGEX = "^[A-Za-z\\s-]+$";
	public static final String USER_POSTAL_CODE_REGEX ="^[1-9][0-9]{5}$";
}