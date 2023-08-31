package com.fssa.liveon.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;
import com.fssa.liveon.model.SparePart;

class TestSparePartsDao {
	// Create a valid Product instance for testing
	public static SparePart productValidate() {
		// Creating a list of image URLs
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");
		// Creating a valid Product object

		SparePart product = new SparePart();
		product.setId(1);
		product.setVehicleType("Bike");
		product.setName("Air filter fil");
		product.setPrice(2500);
		product.setRating(4);
		product.setDescription("Sample product dsecription");
		product.setImageUrl(images);
		return product;
	}

	// Create another valid Product instance for testing
	public static SparePart productValidate2() {
		// Creating a list of image URLs
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");
		// Creating another valid Product object
		SparePart product = new SparePart();

		product.setVehicleType("Bike");
		product.setName("Car Air filter");
		product.setPrice(2500);
		product.setRating(4);
		product.setDescription("Sample product dsecription");
		product.setImageUrl(images);
		return product;
	}

	SparePartsDAO sparePartDao =new SparePartsDAO();
	// Create an invalid Product instance for testing
	public static SparePart inValidProduct() {
		// Creating an invalid Product object with a negative product ID
		SparePart product = new SparePart();
		product.setId(-1);
		return product;
	}

	// Test for adding a valid product
	@Test
	void testValidAddProduct() throws DAOException, SQLException {
		// Assert that the ProductDao.addProduct method returns true for a valid product
		Assertions.assertTrue(sparePartDao.addSparePart(productValidate2()));
	}

	// Test for updating a valid product
	@Test
	void testValidUpdateProduct() throws DAOException, SQLException {
		// Assert that the ProductDao.addProduct method returns true for a valid product
		Assertions.assertTrue(sparePartDao.addSparePart(productValidate()));
	}

	// Test for deleting a valid product
	@Disabled
	
	@Test
	void testValidDeleteProduct() throws DAOException, SQLException {
		// Assert that the ProductDao.deleteProduct method returns true for a valid
		// product ID
		Assertions.assertTrue(sparePartDao.deleteSparePart(9));
	}

	// Test for adding an invalid product
	@Test
	void testInvalidAddProduct() throws DAOException, SQLException {
		try {
			// Attempt to add an invalid product, should throw an exception
			sparePartDao.addSparePart(productValidate());
		} catch (DAOException e) {
			// Assert that the exception message matches the expected error message
			Assertions.assertEquals(SparePartsDaoErrors.INVALID_ADD_SPAREPART, e.getMessage());
		}
	}

	// Test for updating a product with an invalid ID
	@Test
	void testInvalidUpdateProduct() throws DAOException, SQLException {
		try {
			// Attempt to update a product with an invalid ID, should throw an exception
			sparePartDao.updateSparePart(inValidProduct());
		} catch (InvalidSparePartDetailsException e) {
			// Assert that the exception message matches the expected error message
			Assertions.assertEquals(SparePartsDaoErrors.INVALID_ID, e.getMessage());
		}
	}

	// Test for deleting a product with an invalid ID
	@Test
	void testInvalidDeleteProduct() throws DAOException, SQLException {
		try {
			// Attempt to delete a product with an invalid ID, should throw an exception
			sparePartDao.deleteSparePart(inValidProduct().getId());
		} catch (InvalidSparePartDetailsException e) {
			// Assert that the exception message matches the expected error message
			Assertions.assertEquals(SparePartsDaoErrors.INVALID_ID, e.getMessage());
		}
	}
	
}
