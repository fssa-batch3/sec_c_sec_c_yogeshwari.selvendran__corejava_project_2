package com.fssa.liveon.regexpattern;

public class RegexPattern {

	private RegexPattern() {
		
//		private constructor
	}
	public static final String PRODUCT_NAME_REGEX = "^[a-zA-Z ]{2,35}$";
	public static final String ABOUT_PRODUCT_REGEX = "^[a-zA-Z0-9\\\\p{P}\\\\p{S}]{10,250}$";
	public static final String PRODUCT_DESCRIPTION_REGEX = "^[a-zA-Z0-9\\\\p{P}\\\\p{S}]{10,250}$";
	public static final String PRODUCT_IMAGE_REGEX = "(?i)\\b((https?|ftp)://)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?\\.(jpg|jpeg|gif|png|bmp)\\b";
	
}
