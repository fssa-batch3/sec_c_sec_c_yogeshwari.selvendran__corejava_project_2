package com.fssa.liveon.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.SparePart;
import com.fssa.liveon.util.Logger;

class TestSparePartService {
	static Logger logger = new Logger();
	SparePartService sparepart = new SparePartService();
	public SparePart getValidSparePart() {
		// Creating a list of image URLs
		List<String> images = new ArrayList<>();
		
		images.add("https://iili.io/HXVJmMJ.png");
		images.add("https://iili.io/HXVJmMJ.png");
		// Creating a valid Product object
		SparePart sp = new SparePart("Car", "Automotive Brake Part", 2000.0, 4, images, "alloy it is agood");
		return sp;
	}

	// Helper method to create another valid Product instance for testing
	public SparePart getValidSparePart2() {
		// Creating a list of image URLs
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");
		// Creating another valid Product object with a specific product ID
		SparePart sp = new SparePart(7, "Car", "Alternator Ford Motor", 2000.0, 4, images, "alloy it is good");
		return sp;
	}

	// Helper method to create and configure a ProductService instance for testing

	// Test for adding a product
	
	@Test
	void testAddSparePart() throws DAOException, SQLException {
		// Creating a valid Product instance
		SparePart p = getValidSparePart();

		// Creating a ProductService instance

		// Asserting that the addProduct method returns true for the valid Product
		Assertions.assertTrue(sparepart.addSparePart(p));
	}

	// Test for adding a product with invalid data (null name)
	
	
//	@Test
//	void testAddInvalidSparePart() throws DAOException, SQLException {
//		// Creating an invalid Product instance with a null name
//		SparePart invalidPart = getInvalidSparePart();
//
//		// Creating a ProductService instance
//
//		// Asserting that the addSparePart method returns false for the invalid Product
//		Assertions.assertFalse(SparePartService.addSparePart(invalidPart));
//	}

	// Test for updating a product

	@Test
	void testUpdateSparePart() throws DAOException, SQLException {
		// Creating a valid Product instance with a specific product ID
		SparePart p = getValidSparePart2();
		// Creating a ProductService instance

		// Asserting that the updateProduct method returns true for the valid Product
		Assertions.assertTrue(sparepart.updateSparePart(p));

	}

	// Test for deleting a product

	@Test
	void testDeleteSparePart() throws DAOException, SQLException {
		// Creating a valid Product instance with a specific product ID
		SparePart p = getValidSparePart2();
		// Creating a ProductService instance

		// Asserting that the deleteProduct method returns true for the specific product
		// ID
		Assertions.assertTrue(sparepart.deleteSparePart(2));

	}

	// Test for getting product details
	@Test
	void testGetSparePartDetails() throws DAOException, SQLException {
		// Creating a valid Product instance
		// SparePart p = getValidSparePart();
		// Creating a ProductService instance
		List<SparePart>  sparepartlist = sparepart.getSparepartDetails();
		for(SparePart sp : sparepartlist){
			logger.info(sp);
		}
		// Asserting that the getProductDetail method returns true		
	}

	@Test
	void testGetSparePartDetailsByType() throws DAOException, SQLException {
		// Creating a valid Product instance
		SparePart p = getValidSparePart();
		List<SparePart> spList = sparepart.getSparepartsDetailByType();
		for(SparePart sp : spList) {
			logger.info(sp);
		}
		// Creating a ProductService instance
		// Asserting that the getProductDetail method returns true
	}
	
	@Test
	void testGetSparePartDetailsById() throws DAOException {
		// Creating a valid Product instance
	
		// Creating a ProductService instance
		// Asserting that the getProductDetail method returns true
		sparepart.getSparePartDetailById(1);
	}
}
