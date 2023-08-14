package com.fssa.liveon.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;
import com.fssa.liveon.model.SparePart;
import com.fssa.liveon.regexpattern.RegexPattern;

public class SparePartValidation {

	private SparePartValidation() {
		// private constructor
	}

	public static boolean validateProduct(SparePart product) {
		if (product == null) {
			throw new InvalidSparePartDetailsException(SparePartValidationsErrors.INVALID_PRODUCTOBJECT);
		}
		validateProductName(product.getName());
		validateProductPrice(product.getPrice());
		validateProductRating(product.getRating());
		validateProductDescription(product.getDescription());
		productImagesValidator(product.getImageUrl());
		EnamValidation.validVehicleType(product.getVehicleType());
		return true;
	}

// Product Name validation
	public static boolean validateProductName(String productName) throws InvalidSparePartDetailsException {
		if (productName == null || "".equals(productName.trim())) {
			throw new InvalidSparePartDetailsException(SparePartValidationsErrors.INVALID_PRODUCT_NAME_NULL);
		}
		// minimum 2 character and max 35 character
		String nameregex = RegexPattern.PRODUCT_NAME_REGEX;
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(productName);
		Boolean isMatch = matcher.matches();

		if (isMatch.equals(Boolean.FALSE)) {
			throw new InvalidSparePartDetailsException(SparePartValidationsErrors.INVALID_PRODUCT_NAME);

		}
		return true;
	}

	// Product price validation
	public static boolean validateProductPrice(double price) throws InvalidSparePartDetailsException {
		if (price >= 500 && price <= 30000) {
			return true;
		}
		throw new InvalidSparePartDetailsException(SparePartValidationsErrors.INVALID_PRODUCTPRICE);
	}

	// Product rating validation
	public static boolean validateProductRating(int rating) throws InvalidSparePartDetailsException {
		if (rating >= 1 && rating <= 5) {
			return true;
		}
		throw new InvalidSparePartDetailsException(SparePartValidationsErrors.INVALID_PRODUCTRATING);

	}

	// Product description validation
	public static boolean validateProductDescription(String productDescription) throws InvalidSparePartDetailsException {
		if (productDescription == null || "".equals(productDescription.trim())) {
			throw new InvalidSparePartDetailsException(SparePartValidationsErrors.INVALID_PRODUCT_DESCRIPTION_NULL);
		}
		// minimum 2 character and max 35 character
		String nameregex = RegexPattern.PRODUCT_DESCRIPTION_REGEX;
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(productDescription);
		Boolean isMatch = matcher.matches();

		if (isMatch.equals(Boolean.FALSE)) {
			throw new InvalidSparePartDetailsException(SparePartValidationsErrors.INVALID_PRODUCT_DESCRIPTION);

		}
		return true;
	}

	// imageUrl validate
	public static boolean productImagesValidator(List<String> imageUrl) throws InvalidSparePartDetailsException {

		if (imageUrl == null || imageUrl.isEmpty()) {
			throw new InvalidSparePartDetailsException(SparePartValidationsErrors.INVALID_PRODUCTIMAGE_NULL);
		}
		for (String image : imageUrl) {
			String urlRegex = RegexPattern.PRODUCT_IMAGE_REGEX;
			Pattern pattern = Pattern.compile(urlRegex);
			Matcher matcher = pattern.matcher(image);
			if (matcher.matches()) {
				return true;
			}
		}
		throw new InvalidSparePartDetailsException(SparePartValidationsErrors.INVALID_PRODUCTIMAGE);

	}

	public static boolean productIdValidate(int productId) throws InvalidSparePartDetailsException {
		if (productId <= 0) {
			throw new InvalidSparePartDetailsException(SparePartValidationsErrors.INVALID_PRODUCTID);
		}
		return true;
	}

}
