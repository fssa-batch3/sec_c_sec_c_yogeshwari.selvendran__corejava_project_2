package com.fssa.liveon.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.liveon.enums.ServicedVehicleType;
import com.fssa.liveon.exceptions.InvalidPartnerDetailsException;
import com.fssa.liveon.exceptions.InvalidShopDetailsException;
import com.fssa.liveon.model.Shop;
import com.fssa.liveon.regexpattern.RegexPattern;

public class ShopValidation {
	
	public boolean validateShop(Shop shop) {
		if (shop == null) {
			throw new InvalidPartnerDetailsException(ShopValivationErrors.EMPTY_SHOP_ERROR_MESSAGE);
		}
		
		shopImagesValidator(shop.getImageUrl());
		partnerIdValidate(shop.getPartnerId());
		validateShoptName(shop.getShopName());
		validateShopDetails(shop.getShopDetails());
		validShopNumber(shop.getShopNumber());
		validShopLicenceNumber(shop.getShopLicenceNumber());
		validVehicleType(shop.getVehicleType());
		validStreetAddress(shop.getStreetAddress());
		validCity(shop.getCity());
		validPostalCode(shop.getPostalCode());
		return true;
	}
	public boolean updateShop(Shop shop) {
		if (shop == null) {
			throw new InvalidPartnerDetailsException(ShopValivationErrors.EMPTY_SHOP_ERROR_MESSAGE);
		}
		
	
		shopIdValidate(shop.getShopId());
		validateShoptName(shop.getShopName());
		validShopNumber(shop.getShopNumber());
		validStreetAddress(shop.getStreetAddress());
		validCity(shop.getCity());
		validPostalCode(shop.getPostalCode());
		validVehicleType(shop.getVehicleType());
		validateShopDetails(shop.getShopDetails());
		shopImagesValidator(shop.getImageUrl());
		return true;
	}

	public boolean shopIdValidate(int id) throws InvalidShopDetailsException {
		if (id <= 0) {
			throw new InvalidShopDetailsException(ShopValivationErrors.INVALID_SHOP_ID_ERROR_MESSAGE);
		}
		return true;
	}
	public boolean partnerIdValidate(int id) throws InvalidShopDetailsException {
		if (id <= 0) {
			throw new InvalidShopDetailsException(ShopValivationErrors.INVALID_SHOP_ID_ERROR_MESSAGE);
		}
		return true;
	}
	public boolean validShopNumber(long number) throws InvalidShopDetailsException {

		String nameregex = RegexPattern.SHOP_NUMBER_REGEX;
		Pattern pattern = Pattern.compile(nameregex);
		String numberStr = String.valueOf(number);
		Matcher matcher = pattern.matcher(numberStr);

		if (!matcher.matches()) {
			throw new InvalidShopDetailsException(ShopValivationErrors.INVALID_SHOP_NUMBER_ERROR_MESSAGE);
		}

		return true;
	}

	// Product Name validation
	public boolean validateShoptName(String shopName) throws InvalidShopDetailsException {
		if (shopName == null || shopName.trim().isEmpty()) {
			throw new InvalidShopDetailsException(ShopValivationErrors.EMPTY_SHOP_NAME);
		}

		// Minimum 2 characters and maximum 35 characters
		String nameregex = RegexPattern.SHOP_NAME_REGEX;
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(shopName);

		if (!matcher.matches()) {
			throw new InvalidShopDetailsException(ShopValivationErrors.INVALID_SHOP_NAME);
		}

		return true;
	}

	// Product description validation
	public boolean validateShopDetails(String shopDetails) throws InvalidShopDetailsException {
		if (shopDetails == null || shopDetails.trim().isEmpty()) {
			throw new InvalidShopDetailsException(ShopValivationErrors.EMPTY_SHOP_DETAILS);
		}

		// Minimum 2 characters and maximum 35 characters
		String nameregex = RegexPattern.PRODUCT_DESCRIPTION_REGEX;
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(shopDetails);

		if (!matcher.matches()) {
			throw new InvalidShopDetailsException(ShopValivationErrors.INVALID_SHOP_DETAILS);
		}

		return true;
	}

	// imageUrl validate
	public boolean shopImagesValidator(List<String> imageUrl) throws InvalidShopDetailsException {

		if (imageUrl == null || imageUrl.isEmpty()) {
			throw new InvalidShopDetailsException(ShopValivationErrors.EMPTY_IMAGE_URL_ERROR_MESSAGE);
		}
		for (String image : imageUrl) {
			String urlRegex = RegexPattern.PRODUCT_IMAGE_REGEX;
			Pattern pattern = Pattern.compile(urlRegex);
			Matcher matcher = pattern.matcher(image);
			if (matcher.matches()) {
				return true;
			}
		}
		throw new InvalidShopDetailsException(ShopValivationErrors.INVALID_IMAGE_URL_ERROR_MESSAGE);
	}

	public boolean validShopLicenceNumber(String licence) throws InvalidShopDetailsException {

		String nameregex = RegexPattern.SHOP_LICENCE_REGEX;
		Pattern pattern = Pattern.compile(nameregex);
		String numberStr = String.valueOf(licence);
		Matcher matcher = pattern.matcher(numberStr);

		if (!matcher.matches()) {
			throw new InvalidShopDetailsException(ShopValivationErrors.INVALID_SHOP_NUMBER_ERROR_MESSAGE);
		}

		return true;
	}

	public boolean validVehicleType(String vehicleType) throws InvalidShopDetailsException {
		if (vehicleType == null) {

			throw new InvalidShopDetailsException(ShopValivationErrors.EMPTY_VEHICLETYPE);
		}

		for (ServicedVehicleType category : ServicedVehicleType.values()) {
			if (category.getVehicleType().equalsIgnoreCase(vehicleType)) {
				return true;

			}
		}
		throw new InvalidShopDetailsException(ShopValivationErrors.INVALID_VEHICLETYPE);
	}

	public static boolean validStreetAddress(String street) throws InvalidShopDetailsException {
		if (street == null || street.trim().isEmpty()) {
			throw new InvalidShopDetailsException(ShopValivationErrors.EMPTY_STREET_ADDRESS_ERROR_MESSAGE);
		}

		String regexPattern = RegexPattern.USER_STREET_REGEX;
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(street);

		if (!matcher.matches()) {
			throw new InvalidShopDetailsException(ShopValivationErrors.INVALID_STREET_ADDRESS_ERROR_MESSAGE);
		}

		return true;
	}

	public static boolean validCity(String city) throws InvalidShopDetailsException {
		if (city == null || city.trim().isEmpty()) {
			throw new InvalidShopDetailsException(ShopValivationErrors.EMPTY_CITY_ERROR_MESSAGE);
		}

		String regexPattern = RegexPattern.USER_CITY_REGEX;
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(city);

		if (!matcher.matches()) {
			throw new InvalidShopDetailsException(ShopValivationErrors.INVALID_CITY_ERROR_MESSAGE);
		}

		return true;
	}

	public static boolean validPostalCode(String postalCode) throws InvalidShopDetailsException {
		if (postalCode == null || postalCode.trim().isEmpty()) {
			throw new InvalidShopDetailsException(ShopValivationErrors.EMPTY_POSTAL_CODE_ERROR_MESSAGE);
		}

		String regexPattern = RegexPattern.USER_POSTAL_CODE_REGEX;
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(postalCode);

		if (!matcher.matches()) {
			throw new InvalidShopDetailsException(ShopValivationErrors.INVALID_POSTAL_CODE_ERROR_MESSAGE);
		}

		return true;
	}

}
