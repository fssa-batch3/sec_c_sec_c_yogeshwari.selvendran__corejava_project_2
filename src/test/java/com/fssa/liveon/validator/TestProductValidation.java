package com.fssa.liveon.validator;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.liveon.exceptions.InvalidProductDetailsException;
import com.fssa.liveon.model.Product;

class TestProductValidation {
	// Valid test case for product details
	@Test
	void testValidteProduct() {
		// Creating a list of image URLs
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");
		// Creating a valid Product object
		Product product = new Product("Car", "AirFilter", 2000.0, 4, images, "Sampleproductdescription",
				"SampleAboutproduct");
		// Asserting that the product validation returns true for this valid Product
		// object
		Assertions.assertTrue(ProductValidation.validateProduct(product));
	}

	// Invalid test case for product details

	@Test
	void testInvaidProduct() {
		try {
			// Validating a null Product object should throw an
			// InvalidProductDetailsException
			ProductValidation.validateProduct(null);
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCTOBJECT, e.getMessage());
		}
	}

//	Valid test case for Product Name
	@Test
	void testValidProductName() {
		String productName = "Air filter";
		// Asserting that the product name validation returns true for this valid
		// Product object
		Assertions.assertTrue(ProductValidation.validateProductName(productName));
	}

//	Invalid test case for product name
	@Test
	void testInvalidProductName() {
		try {
			// Validating a null Product object should throw an
			// InvalidProductDetailsException
			ProductValidation.validateProductName(null);
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCT_NAME_NULL, e.getMessage());
		}

		try {
			// Validating a single character Product name should throw an
			// InvalidProductDetailsException
			ProductValidation.validateProductName("u");
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCT_NAME, e.getMessage());
		}
	}

//	Valid test case for product price
	@Test
	void validProductPrice() {
		double productPrice = 2600;
		// Asserting that the product price validation returns true for this valid
		// Product object
		Assertions.assertTrue(ProductValidation.validateProductPrice(productPrice));
	}

//	Invalid test case for product price
	@Test
	void inValidProductPrice() {
		try {
			// Validating a 0 Product price should throw an InvalidProductDetailsException
			ProductValidation.validateProductPrice(0);
		} catch (InvalidProductDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCTPRICE, e.getMessage());
		}
	}

// 	Valid test case for product rating
	@Test
	void validProductRating() {
		int rating = 4;
		// Asserting that the product rating validation returns true for this valid
		// Product object
		Assertions.assertTrue(ProductValidation.validateProductRating(rating));
	}

//	Invalid test case for product rating 
	@Test
	void inValidProductRating() {
		try {
			// Validating a negative Product rating should throw an
			// InvalidProductDetailsException
			ProductValidation.validateProductRating(-2);
		} catch (InvalidProductDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCTRATING, e.getMessage());
		}
	}

//	Valid test case for about Product 
	@Test
	void testValidAboutProduct() {
		String about = "Sampleaboutproduct";
		// Asserting that the about product validation returns true for this valid
		// Product object
		Assertions.assertTrue(ProductValidation.validateAboutProduct(about));
	}

//	Invalid test case for about product
	@Test
	void testInvalidAboutProduct() {
		try {
			// Validating a null Product object should throw an
			// InvalidProductDetailsException
			ProductValidation.validateAboutProduct(null);
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.INVALID_ABOUTPRODUCT_NULL, e.getMessage());
		}

		try {
			ProductValidation.validateAboutProduct("s");
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.INVALID_ABOUTPRODUCT, e.getMessage());
		}
	}

//	Valid test case for Product Description
	@Test
	void testValidProductDescription() {
		String description = "Sampleproductdescription";
		// Asserting that the product description validation returns true for this valid
		// Product object
		Assertions.assertTrue(ProductValidation.validateProductDescription(description));
	}

//	Invalid test case for  product Description
	@Test
	void testInvalidProductDescription() {
		try {
			// Validating a null Product object should throw an
			// InvalidProductDetailsException
			ProductValidation.validateProductDescription(null);
			Assertions.fail("Tset case failed");
		} catch (InvalidProductDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCT_DESCRIPTION_NULL, e.getMessage());
		}

		try {
			// Validating a three letter Product description should throw an
			// InvalidProductDetailsException
			ProductValidation.validateProductDescription("yib");
			Assertions.fail("Tset case failed");
		} catch (InvalidProductDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCT_DESCRIPTION, e.getMessage());
		}
	}
	// test valid vehicle type

	@Test
	
	void testVehicleType() {
		String VehicleType = "Car";
		try {
			EnamValidation.validVehicleType(VehicleType);
		} catch (InvalidProductDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.INVALID_VEHICLETYPE, e.getMessage());
		}

		String VehicleType2 = "Bike";

		try {
			EnamValidation.validVehicleType(VehicleType2);
		} catch (InvalidProductDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.INVALID_VEHICLETYPE, e.getMessage());
		}

	}

// Test invalid vehicle type
	@Test
	void testInvalidVehicletype() {
//	empty vehicle type
		try {
			// Validating a null Product object should throw an
			// InvalidProductDetailsException
			EnamValidation.validVehicleType(null);
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.EMPTY_VEHICLETYPE, e.getMessage());
		}
//	invalid vehicle type
		try {
			EnamValidation.validVehicleType("Truck");
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.INVALID_VEHICLETYPE, e.getMessage());
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
		Assertions.assertTrue(ProductValidation.productImagesValidator(validImages));
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
			ProductValidation.productImagesValidator(null);
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCTIMAGE_NULL, e.getMessage());
		}

		try {
			ProductValidation.productImagesValidator(invalidImages);
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCTIMAGE, e.getMessage());
		}
	}

//	Valid product id
	@Test
	void validProductId() {
		// Asserting that the product Id validation returns true for this valid Product
		// object
		Assertions.assertTrue(ProductValidation.productIdValidate(1));
	}

//	Invalid product Id 
	void inValidProductId() {
		try {
			// Attempt to validate an invalid product ID, should throw an exception
			ProductValidation.productIdValidate(-1);
		} catch (InvalidProductDetailsException e) {
			// Assert that the exception message matches the expected error message
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCTID, e.getMessage());
		}
	}
}
