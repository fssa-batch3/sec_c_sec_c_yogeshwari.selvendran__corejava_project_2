package com.fssa.liveon.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.SparePart;

class TestSparePartService {
	/**
	 * Helper method to create a valid Product instance for testing
	 */

	public SparePart getProduct() {
		// Creating a list of image URLs
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");
		// Creating a valid Product object
		SparePart product = new SparePart("Car", "AirFilter", 2000.0, 4, images, "Sampleproductdescription");
		return product;
	}

	// Helper method to create another valid Product instance for testing
	public SparePart getProduct2() {
		// Creating a list of image URLs
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");
		// Creating another valid Product object with a specific product ID
		SparePart product = new SparePart(7, "Car", "AirFilter", 2000.0, 4, images, "Sampleproductdescription");
		return product;
	}

	// Helper method to create and configure a ProductService instance for testing

	// Test for adding a product
	@Test
	void testAddProduct() throws DAOException, SQLException {
		// Creating a valid Product instance
		SparePart product = getProduct();

		// Creating a ProductService instance

		// Asserting that the addProduct method returns true for the valid Product
		Assertions.assertTrue(SparePartService.addSparePart(product));

	}

	// Test for updating a product
	@Test
	void testUpdateProduct() throws DAOException, SQLException {
		// Creating a valid Product instance with a specific product ID
		SparePart product = getProduct2();
		// Creating a ProductService instance

		// Asserting that the updateProduct method returns true for the valid Product
		Assertions.assertTrue(SparePartService.updateSparePart(product));

	}

	// Test for deleting a product
	@Test
	void testDeleteProduct() throws DAOException, SQLException {
		// Creating a valid Product instance with a specific product ID
		SparePart product = getProduct2();
		// Creating a ProductService instance

		// Asserting that the deleteProduct method returns true for the specific product
		// ID
		Assertions.assertTrue(SparePartService.deleteSparePart(11));

	}

	// Test for getting product details
	@Test
	void testGetProductDetails() throws DAOException, SQLException {
		// Creating a valid Product instance
		SparePart product = getProduct();
		// Creating a ProductService instance

		// Asserting that the getProductDetail method returns true
		Assertions.assertTrue(SparePartService.getProductDetail());
	}

	@Test
	void testGetProductDetailsByType() throws DAOException, SQLException {
		// Creating a valid Product instance
		SparePart product = getProduct();
		// Creating a ProductService instance

		// Asserting that the getProductDetail method returns true
		Assertions.assertTrue(SparePartService.getProductDetailByType());
	}

}
