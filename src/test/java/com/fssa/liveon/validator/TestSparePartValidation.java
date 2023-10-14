package com.fssa.liveon.validator;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;
import com.fssa.liveon.model.SparePart;
import com.fssa.liveon.validator.*;

class TestSparePartValidation {

	SparePartValidation sparepartsValidation = new SparePartValidation();

	EnamValidation enamValidation = new EnamValidation();

	// Valid test case for product details
	@Test
	void testValidateProduct() {
		// Creating a list of image URLs
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");
		// Creating a valid Product object
		SparePart product = new SparePart("Bike", "AirFilter", 2000.0, 4, images, "Sampleproductdescription");
		// Asserting that the product validation returns true for this valid Product
		// object
		Assertions.assertTrue(sparepartsValidation.validateSparePart(product));
	}

	// Invalid test case for product details

	@Test
	void testInvaidProduct() {
		try {
			// Validating a null Product object should throw an
			// InvalidProductDetailsException
			sparepartsValidation.validateSparePart(null);
			Assertions.fail("Test case failed");
		} catch (InvalidSparePartDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.INVALID_PRODUCTOBJECT, e.getMessage());
		}
	}

//	Valid test case for Product Name
	@Test
	void testValidProductName() {
		String productName = "Air filter";
		// Asserting that the product name validation returns true for this valid
		// Product object
		Assertions.assertTrue(sparepartsValidation.validateSparePartName(productName));
	}

//	Invalid test case for product name
	@Test
	void testInvalidProductName() {
		try {
			// Validating a null Product object should throw an
			// InvalidProductDetailsException
			sparepartsValidation.validateSparePartName(null);
			Assertions.fail("Test case failed");
		} catch (InvalidSparePartDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.INVALID_PRODUCT_NAME_NULL, e.getMessage());
		}

		try {
			// Validating a single character Product name should throw an
			// InvalidProductDetailsException
			sparepartsValidation.validateSparePartName("u");
			Assertions.fail("Test case failed");
		} catch (InvalidSparePartDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.INVALID_PRODUCT_NAME, e.getMessage());
		}
	}

//	Valid test case for product price
	@Test
	void validProductPrice() {
		double productPrice = 2600;
		// Asserting that the product price validation returns true for this valid
		// Product object
		Assertions.assertTrue(sparepartsValidation.validateSparePartPrice(productPrice));
	}

//	Invalid test case for product price
	@Test
	void inValidProductPrice() {
		try {
			// Validating a 0 Product price should throw an InvalidProductDetailsException
			sparepartsValidation.validateSparePartPrice(0);
		} catch (InvalidSparePartDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.INVALID_PRODUCTPRICE, e.getMessage());
		}
	}

// 	Valid test case for product rating
	@Test
	void validProductRating() {
		int rating = 4;
		// Asserting that the product rating validation returns true for this valid
		// Product object
		Assertions.assertTrue(sparepartsValidation.validateSparePartRating(rating));
	}

//	Invalid test case for product rating 
	@Test
	void inValidProductRating() {
		try {
			// Validating a negative Product rating should throw an
			// InvalidProductDetailsException
			sparepartsValidation.validateSparePartRating(-2);
		} catch (InvalidSparePartDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.INVALID_PRODUCTRATING, e.getMessage());
		}
	}

//	Valid test case for Product Description
	@Test
	void testValidProductDescription() {
		String description = "Sampleproductdescription";
		// Asserting that the product description validation returns true for this valid
		// Product object
		Assertions.assertTrue(sparepartsValidation.validateSparePartDescription(description));
	}

//	Invalid test case for  product Description
	@Test
	void testInvalidProductDescription() {
		try {
			// Validating a null Product object should throw an
			// InvalidProductDetailsException
			sparepartsValidation.validateSparePartDescription(null);
			Assertions.fail("Tset case failed");
		} catch (InvalidSparePartDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.INVALID_PRODUCT_DESCRIPTION_NULL, e.getMessage());
		}

		try {
			// Validating a three letter Product description should throw an
			// InvalidProductDetailsException
			sparepartsValidation.validateSparePartDescription("yi");
			Assertions.fail("Test case failed");
		} catch (InvalidSparePartDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.INVALID_PRODUCT_DESCRIPTION, e.getMessage());
		}
	}
	// test valid vehicle type

	@Test

	void testVehicleType() {
		String VehicleType = "Car";
		try {
			enamValidation.validVehicleType(VehicleType);
		} catch (InvalidSparePartDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.INVALID_VEHICLETYPE, e.getMessage());
		}

		String VehicleType2 = "Bike";

		try {
			enamValidation.validVehicleType(VehicleType2);
		} catch (InvalidSparePartDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.INVALID_VEHICLETYPE, e.getMessage());
		}

	}

// Test invalid vehicle type
	@Test
	void testInvalidVehicletype() {
//	empty vehicle type
		try {
			// Validating a null Product object should throw an
			// InvalidProductDetailsException
			enamValidation.validVehicleType(null);
			Assertions.fail("Test case failed");
		} catch (InvalidSparePartDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.EMPTY_VEHICLETYPE, e.getMessage());
		}
//	invalid vehicle type
		try {
			enamValidation.validVehicleType("Truck");
			Assertions.fail("Test case failed");
		} catch (InvalidSparePartDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.INVALID_VEHICLETYPE, e.getMessage());
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
		Assertions.assertTrue(sparepartsValidation.sparePartImagesValidator(validImages));
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
			sparepartsValidation.sparePartImagesValidator(null);
			Assertions.fail("Test case failed");
		} catch (InvalidSparePartDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.INVALID_PRODUCTIMAGE_NULL, e.getMessage());
		}

		try {
			sparepartsValidation.sparePartImagesValidator(invalidImages);
			Assertions.fail("Test case failed");
		} catch (InvalidSparePartDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.INVALID_PRODUCTIMAGE, e.getMessage());
		}
	}

//	Valid product id
	@Test
	void validProductId() {
		// Asserting that the product Id validation returns true for this valid Product
		// object
		Assertions.assertTrue(sparepartsValidation.idValidate(1));
	}

//	Invalid product Id 
	void inValidProductId() {
		try {
			// Attempt to validate an invalid product ID, should throw an exception
			sparepartsValidation.idValidate(-1);
		} catch (InvalidSparePartDetailsException e) {
			// Assert that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.INVALID_PRODUCTID, e.getMessage());
		}
	}
}
