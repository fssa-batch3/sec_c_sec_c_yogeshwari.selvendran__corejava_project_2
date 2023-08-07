package com.fssa.liveon.validator;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.liveon.exceptions.InvalidProductDetailsException;

public class TestProductValidation {
//	Valid test case for Product Name
	@Test
	public void testValidProductName() {
		String productName = "Air filter";
		Assertions.assertTrue(ProductValidation.validateProductName(productName));
	}

//	Invalid test case for product name
	@Test
	public void testInvalidProductName() {
		try {
			ProductValidation.validateProductName(null);
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCT_NAME_NULL, e.getMessage());
		}
		
		try {
			ProductValidation.validateProductName("u");
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCT_NAME, e.getMessage());
		}
	}

//	Valid test case for product price
	@Test
	public void validProductPrice() {
		double productPrice = 2600;
		Assertions.assertTrue(ProductValidation.validateProductPrice(productPrice));
	}

//	Invalid test case for product price
	@Test
	public void inValidProductPrice() {
		try {
			ProductValidation.validateProductPrice(0);
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCTPRICE, e.getMessage());
		}
	}

// 	Valid test case for product rating
	@Test
	public void validProductRating() {
		int rating = 4;
		Assertions.assertTrue(ProductValidation.validateProductRating(rating));
	}

//	Invalid test case for product rating 
	@Test
	public void inValidProductRating() {
		try {
			ProductValidation.validateProductRating(-2);
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCTRATING, e.getMessage());
		}
	}

//	Valid test case for about Product 
	@Test
	public void testValidAboutProduct() {
		String about = "Sampleaboutproduct";
		Assertions.assertTrue(ProductValidation.validateAboutProduct(about));
	}

//	Invalid test case for about product
	@Test
	public void testInvalidAboutProduct() {
		try {
			ProductValidation.validateAboutProduct(null);
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(ProductValidationsErrors.INVALID_ABOUTPRODUCT_NULL, e.getMessage());
		}
		
		try {
			ProductValidation.validateAboutProduct("s");
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(ProductValidationsErrors.INVALID_ABOUTPRODUCT, e.getMessage());
		}
	}

//	Valid test case for Product Description
	@Test
	public void testValidProductDescription() {
		String description = "Sampleproductdescription";
		Assertions.assertTrue(ProductValidation.validateProductDescription(description));
	}

//	Invalid test case for  product Description
	@Test
	public void testInvalidProductDescription() {
		try {
			ProductValidation.validateProductDescription(null);
			Assertions.fail("Tset case failed");
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCT_DESCRIPTION_NULL, e.getMessage());
		}
		
		try {
			ProductValidation.validateProductDescription("yib");
			Assertions.fail("Tset case failed");
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCT_DESCRIPTION, e.getMessage());
		}
	}
	// test valid vehicle type

	@Test
	public void testVehicleType() {
		String VehicleType = "Car";
		try {
			EnamValidation.ValidVehicleType(VehicleType);
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(ProductValidationsErrors.INVALID_VEHICLETYPE, e.getMessage());
		}

		String VehicleType2 = "Bike";

		try {
			EnamValidation.ValidVehicleType(VehicleType2);
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(ProductValidationsErrors.INVALID_VEHICLETYPE, e.getMessage());
		}

	}

// Test invalid vehicle type
	@Test
	public void testInvalidVehicletype() {
//	empty vehicle type
		try {
			EnamValidation.ValidVehicleType(null);
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(ProductValidationsErrors.EMPTY_VEHICLETYPE, e.getMessage());
		}
//	invalid vehicle type
		try {
			EnamValidation.ValidVehicleType("Truck");
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(ProductValidationsErrors.INVALID_VEHICLETYPE, e.getMessage());
		}
	}
	@Test
//	Valid image url test case
	public void testImageUrl() {
		ArrayList<String> validImages = new ArrayList<>();
		 validImages.add("https://iili.io/Hv6Okvf.png");
		 validImages.add("https://iili.io/Hv6tFqu.png");
	//	String imageUrl = "https://iili.io/Hv6Okvf.png";
		Assertions.assertTrue(ProductValidation.productImagesValidator(validImages));
	}
	@Test
//	Invalid image Url  test case
	public void inValidImageUrl() {
		ArrayList<String> invalidImages = new ArrayList<>();
	        invalidImages.add("https://example.com/image1");
	        invalidImages.add("https://example.com/image2.jpg.doc");
		try {
			ProductValidation.productImagesValidator(null);
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCTIMAGE_NULL, e.getMessage());
		}

		try {
			ProductValidation.productImagesValidator(invalidImages);
			Assertions.fail("Test case failed");
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(ProductValidationsErrors.INVALID_PRODUCTIMAGE, e.getMessage());
		}
	}
}
