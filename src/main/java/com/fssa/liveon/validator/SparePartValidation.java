package com.fssa.liveon.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.liveon.constant.SparePartPrice;
import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;
import com.fssa.liveon.model.SparePart;
import com.fssa.liveon.regexpattern.RegexPattern;

public class SparePartValidation {

	public SparePartValidation() {
		// private constructor
	}
	EnamValidation enamValidation = new EnamValidation();
	public  boolean validateSparePart(SparePart sparepart) {
		if (sparepart == null) {
			
			throw new InvalidSparePartDetailsException(SparePartValidationsErrors.INVALID_PRODUCTOBJECT);
		}
		validateSparePartName(sparepart.getName());
		validateSparePartPrice(sparepart.getPrice());
		validateSparePartRating(sparepart.getRating());
		validateSparePartDescription(sparepart.getDescription());
		sparePartImagesValidator(sparepart.getImageUrl());
		enamValidation.validVehicleType(sparepart.getVehicleType());
		return true;
	}
	

// Product Name validation
	public  boolean validateSparePartName(String productName) throws InvalidSparePartDetailsException {
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
	public  boolean validateSparePartPrice(double price) throws InvalidSparePartDetailsException {
		if (price >= SparePartPrice.SPAREPART_MIN_PRICE && price <=  SparePartPrice.SPAREPART_MAX_PRICE) {
			return true;
		}
		throw new InvalidSparePartDetailsException(SparePartValidationsErrors.INVALID_PRODUCTPRICE);
	}

	// Product rating validation
	public  boolean validateSparePartRating(int rating) throws InvalidSparePartDetailsException {
		if (rating >= 1 && rating <= 5) {
			return true;
		}
		throw new InvalidSparePartDetailsException(SparePartValidationsErrors.INVALID_PRODUCTRATING);

	}

	// Product description validation
	public  boolean validateSparePartDescription(String productDescription) throws InvalidSparePartDetailsException {
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
	public  boolean sparePartImagesValidator(List<String> imageUrl) throws InvalidSparePartDetailsException {

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

	public  boolean idValidate(int id) throws InvalidSparePartDetailsException {
		if (id <= 0) {
			throw new InvalidSparePartDetailsException(SparePartValidationsErrors.INVALID_PRODUCTID);
		}
		return true;
	}
}
