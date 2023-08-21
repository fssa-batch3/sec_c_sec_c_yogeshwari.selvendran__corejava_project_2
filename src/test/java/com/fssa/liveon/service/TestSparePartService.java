package com.fssa.liveon.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.SparePart;

class TestSparePartService{
	/**
	 * Helper method to create a valid Product instance for testing
	 */
	public SparePart getSparePart() {
		// Creating a list of image URLs
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");
		// Creating a valid Product object
		SparePart sp = new SparePart("Car", "AirFilter", 2000.0, 4, images, "Sampleproductdescription");
		return sp;
	}

	// Helper method to create another valid Product instance for testing
	public SparePart getSparePart2() {
		// Creating a list of image URLs
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");
		// Creating another valid Product object with a specific product ID
		SparePart sp = new SparePart(7, "Car", "AirFilter", 2000.0, 4, images,"Sampleproductdescription");
		return sp;
	}

	// Helper method to create and configure a ProductService instance for testing

	// Test for adding a product
	@Test
	void testAddSparePart() throws DAOException, SQLException {
		// Creating a valid Product instance
		SparePart p = getSparePart();

		// Creating a ProductService instance

		// Asserting that the addProduct method returns true for the valid Product
		Assertions.assertTrue(SparePartService.addSparePart(p));

	}

	// Test for updating a product
	@Test
	void testUpdateSparePart() throws DAOException, SQLException {
		// Creating a valid Product instance with a specific product ID
		SparePart p = getSparePart2();
		// Creating a ProductService instance

		// Asserting that the updateProduct method returns true for the valid Product
		Assertions.assertTrue(SparePartService.updateSparePart(p));

	}

	// Test for deleting a product
	@Test
	void testDeleteSparePart() throws DAOException, SQLException {
		// Creating a valid Product instance with a specific product ID
		SparePart p = getSparePart2();
		// Creating a ProductService instance

		// Asserting that the deleteProduct method returns true for the specific product
		// ID
		Assertions.assertTrue(SparePartService.deleteSparePart(11));

	}

	// Test for getting product details
	@Test
	void testGetSparePartDetails() throws DAOException, SQLException {
		// Creating a valid Product instance
		SparePart p = getSparePart();
		// Creating a ProductService instance

		// Asserting that the getProductDetail method returns true
		Assertions.assertTrue(SparePartService.getProductDetail());
	}

	@Test
	void testGetSparePartDetailsByType() throws DAOException, SQLException {
		// Creating a valid Product instance
		SparePart p = getSparePart();
		// Creating a ProductService instance
		// Asserting that the getProductDetail method returns true
		Assertions.assertTrue(SparePartService.getProductDetailByType());
	}

}
