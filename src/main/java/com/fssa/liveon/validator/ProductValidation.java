package com.fssa.liveon.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.liveon.exceptions.InvalidProductDetailsException;
import com.fssa.liveon.model.Product;
import com.fssa.liveon.regexpattern.RegexPattern;

public class ProductValidation {

	private ProductValidation() {
		// private constructor
	}

	public static boolean validateProduct(Product product) {
		if (product == null) {
			throw new InvalidProductDetailsException(ProductValidationsErrors.INVALID_PRODUCTOBJECT);
		}
		validateProductName(product.getProductName());
		validateProductPrice(product.getPrice());
		validateProductRating(product.getRating());
		validateAboutProduct(product.getAboutProduct());
		validateProductDescription(product.getDescription());
		productImagesValidator(product.getImageUrl());
		EnamValidation.validVehicleType(product.getVehicleType());
		return true;
	}

// Product Name validation
	public static boolean validateProductName(String productName) throws InvalidProductDetailsException {
		if (productName == null || "".equals(productName.trim())) {
			throw new InvalidProductDetailsException(ProductValidationsErrors.INVALID_PRODUCT_NAME_NULL);
		}
		// minimum 2 character and max 35 character
		String nameregex =  RegexPattern.PRODUCT_NAME_REGEX;
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(productName);
		Boolean isMatch = matcher.matches();

		if (isMatch.equals(Boolean.FALSE)) {
			throw new InvalidProductDetailsException(ProductValidationsErrors.INVALID_PRODUCT_NAME);

		}
		return true;
	}

	// Product price validation
	public static boolean validateProductPrice(double price) throws InvalidProductDetailsException {
		if (price >= 500 && price <= 30000) {
			return true;

		}
		throw new InvalidProductDetailsException(ProductValidationsErrors.INVALID_PRODUCTPRICE);
	}

	// Product rating validation
	public static boolean validateProductRating(int rating) throws InvalidProductDetailsException {
		if (rating >= 1 && rating <= 5) {
			return true;
		}
		throw new InvalidProductDetailsException(ProductValidationsErrors.INVALID_PRODUCTRATING);

	}

	// Product about validation
	public static boolean validateAboutProduct(String productAbout) throws InvalidProductDetailsException {
		if (productAbout == null || "".equals(productAbout.trim())) {
			throw new InvalidProductDetailsException(ProductValidationsErrors.INVALID_ABOUTPRODUCT_NULL);
		}
		// minimum 2 character and max 35 character
		String nameregex = RegexPattern.ABOUT_PRODUCT_REGEX;
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(productAbout);
		Boolean isMatch = matcher.matches();

		if (isMatch.equals(Boolean.FALSE)) {
			throw new InvalidProductDetailsException(ProductValidationsErrors.INVALID_ABOUTPRODUCT);

		}
		return true;
	}

	// Product description validation
	public static boolean validateProductDescription(String productDescription) throws InvalidProductDetailsException {
		if (productDescription == null || "".equals(productDescription.trim())) {
			throw new InvalidProductDetailsException(ProductValidationsErrors.INVALID_PRODUCT_DESCRIPTION_NULL);
		}
		// minimum 2 character and max 35 character
		String nameregex = RegexPattern.PRODUCT_DESCRIPTION_REGEX;
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(productDescription);
		Boolean isMatch = matcher.matches();

		if (isMatch.equals(Boolean.FALSE)) {
			throw new InvalidProductDetailsException(ProductValidationsErrors.INVALID_PRODUCT_DESCRIPTION);

		}
		return true;
	}

	// imageUrl validate
	public static boolean productImagesValidator(List<String> imageUrl) throws InvalidProductDetailsException {

		if (imageUrl == null || imageUrl.isEmpty()) {
			throw new InvalidProductDetailsException(ProductValidationsErrors.INVALID_PRODUCTIMAGE_NULL);
		}
		for (String image : imageUrl) {
			String urlRegex = RegexPattern.PRODUCT_IMAGE_REGEX;
			Pattern pattern = Pattern.compile(urlRegex);
			Matcher matcher = pattern.matcher(image);
			if (matcher.matches()) {
				return true;
			}
		}
		throw new InvalidProductDetailsException(ProductValidationsErrors.INVALID_PRODUCTIMAGE);

	}

	public static boolean productIdValidate(int productId) throws InvalidProductDetailsException {
		if (productId <= 0) {
			throw new InvalidProductDetailsException(ProductValidationsErrors.INVALID_PRODUCTID);
		}
		return true;
	}

}
