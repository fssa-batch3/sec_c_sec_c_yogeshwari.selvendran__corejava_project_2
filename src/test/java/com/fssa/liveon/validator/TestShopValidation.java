package com.fssa.liveon.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.liveon.builder.ShopBuilder;
import com.fssa.liveon.exceptions.InvalidShopDetailsException;
import com.fssa.liveon.model.Shop;

public class TestShopValidation {
	ShopValidation shops = new ShopValidation();

	@Test
	void testShops() {
		List<String> items = Arrays.asList("https://iili.io/Hv6Okvf.png", "https://iili.io/Hv6Okvf.png",
				"https://iili.io/Hv6Okvf.png");
		Shop shop = new ShopBuilder().buildShopId(1).buildPartnerId(1).buildShopName("Mechanic shop").buildShopLicenceNumber("ABC123")
				.buildShopServicedVehicleType("car").buildShopDetails("The shop details").buildImageUrl(items)
				.buildShopNumber(9876543210l).buildStreetAddress("north street").buildCity("madurai")
				.buildPostalCode("654321").buildPartnerId(1).build();
		
		Assertions.assertTrue(shops.validateShop(shop));
	}
	
	@Test
	void testValidShopId() {
		Assertions.assertTrue(shops.shopIdValidate(3));
	}

	@Test
	void testInvalidShopId() {
		try {
			shops.shopIdValidate(-1);
		} catch (InvalidShopDetailsException e) {
			Assertions.assertEquals(ShopValivationErrors.INVALID_SHOP_ID_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void testValidStreet() {
	    String street = "123 Main St"; // Corrected variable name "Street" to "street"
	    Assertions.assertTrue(shops.validStreetAddress(street)); // Assuming that "shops" is the correct reference to your class
	}

	@Test
	public void testInvalidStreetNull() {
	    try {
	        shops.validStreetAddress(null);
	        Assertions.fail("Test case failed");
	    } catch (InvalidShopDetailsException e) {
	        Assertions.assertEquals(ShopValivationErrors.EMPTY_STREET_ADDRESS_ERROR_MESSAGE, e.getMessage());
	    }
	}

	@Test
	public void testInvalidStreetFormat() {
	    try {
	        shops.validStreetAddress(")(**&&^%$4");
	        Assertions.fail("Test case failed");
	    } catch (InvalidShopDetailsException e) {
	        Assertions.assertEquals(ShopValivationErrors.INVALID_STREET_ADDRESS_ERROR_MESSAGE, e.getMessage());
	    }
	}

	@Test
	public void testValidCity() {
		String City = "Madurai";
		Assertions.assertTrue(shops.validCity(City));
	}

	@Test
	public void testInvalidCity() {
		try {
			shops.validCity(null);
			Assertions.fail("Test case failed");
		} catch (InvalidShopDetailsException e) {
			Assertions.assertEquals(ShopValivationErrors.EMPTY_CITY_ERROR_MESSAGE, e.getMessage());
		}

		try {
			shops.validCity("8754321");

			Assertions.fail("Test case failed");
		} catch (InvalidShopDetailsException e) {
			Assertions.assertEquals(ShopValivationErrors.INVALID_CITY_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void testValidPostalCode() {
		String Pincode = "654321";
		Assertions.assertTrue(shops.validPostalCode(Pincode));
	}

	@Test
	public void testInvalidPostalCode() {
		try {
			shops.validPostalCode(null);
			Assertions.fail("Test case failed");
		} catch (InvalidShopDetailsException e) {
			Assertions.assertEquals(ShopValivationErrors.EMPTY_POSTAL_CODE_ERROR_MESSAGE, e.getMessage());
		}

		try {
			shops.validPostalCode("north");

			Assertions.fail("Test case failed");
		} catch (InvalidShopDetailsException e) {
			Assertions.assertEquals(ShopValivationErrors.INVALID_POSTAL_CODE_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test

	void testVehicleType() {
		String VehicleType = "Car";
		try {
			shops.validVehicleType(VehicleType);
		} catch (InvalidShopDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ShopValivationErrors.INVALID_VEHICLETYPE, e.getMessage());
		}

		String VehicleType2 = "Bike";

		try {
			shops.validVehicleType(VehicleType2);
		} catch (InvalidShopDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ShopValivationErrors.INVALID_VEHICLETYPE, e.getMessage());
		}
		String VehicleType3 = "Both";

		try {
			shops.validVehicleType(VehicleType3);
		} catch (InvalidShopDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ShopValivationErrors.INVALID_VEHICLETYPE, e.getMessage());
		}
	}

// Test invalid vehicle type
	@Test
	void testInvalidVehicletype() {
//	empty vehicle type
		try {
			// Validating a null Product object should throw an
			// InvalidProductDetailsException
			shops.validVehicleType(null);
			Assertions.fail("Test case failed");
		} catch (InvalidShopDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ShopValivationErrors.EMPTY_VEHICLETYPE, e.getMessage());
		}
//	invalid vehicle type
		try {
			shops.validVehicleType("Truck");
			Assertions.fail("Test case failed");
		} catch (InvalidShopDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ShopValivationErrors.INVALID_VEHICLETYPE, e.getMessage());
		}
		try {
			shops.validVehicleType("Auto");
			Assertions.fail("Test case failed");
		} catch (InvalidShopDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ShopValivationErrors.INVALID_VEHICLETYPE, e.getMessage());
		}
	}

	@Test
//	Valid image url test case
	void testImageUrl() {
		ArrayList<String> validImages = new ArrayList<>();
		validImages.add("https://iili.io/Hv6Okvf.png");
		validImages.add("https://iili.io/Hv6tFqu.png");
		// Asserting that the product images validation returns true for this valid
		// Product object
		Assertions.assertTrue(shops.shopImagesValidator(validImages));
	}

	@Test
//	Invalid image Url  test case
	void inValidImageUrl() {
		ArrayList<String> invalidImages = new ArrayList<>();
		invalidImages.add("https://example.com/image1");
		invalidImages.add("https://example.com/image2.jpg.doc");
		try {
			// Validating a null Product object should throw an
			// InvalidProductDetailsException
			shops.shopImagesValidator(null);
			Assertions.fail("Test case failed");
		} catch (InvalidShopDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ShopValivationErrors.EMPTY_IMAGE_URL_ERROR_MESSAGE, e.getMessage());
		}

		try {
			shops.shopImagesValidator(invalidImages);
			Assertions.fail("Test case failed");
		} catch (InvalidShopDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ShopValivationErrors.INVALID_IMAGE_URL_ERROR_MESSAGE, e.getMessage());
		}
	}
}
