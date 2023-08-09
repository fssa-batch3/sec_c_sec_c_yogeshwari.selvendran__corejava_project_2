package com.fssa.liveon.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.exceptions.InvalidProductDetailsException;
import com.fssa.liveon.model.Product;

public class TestProductDao {
	// Create a valid Product instance for testing
	public static Product productValidate() {
		// Creating a list of image URLs
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");
		// Creating a valid Product object
		Product product = new Product();
		product.setProductId(4);
		product.setVehicleType("Car");
		product.setProductName("Air filter");
		product.setPrice(2500);
		product.setRating(4);
		product.setAboutProduct("Sample about product");
		product.setDescription("Sample product dsecription");
		product.setImageUrl(images);
		return product;
	}

	// Create another valid Product instance for testing
	public static Product productValidate2() {
		// Creating a list of image URLs
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");
		// Creating another valid Product object
		Product product = new Product();

		product.setVehicleType("Car");
		product.setProductName("Air filter");
		product.setPrice(2500);
		product.setRating(4);
		product.setAboutProduct("Sample about product");
		product.setDescription("Sample product dsecription");
		product.setImageUrl(images);
		return product;
	}

	// Create an invalid Product instance for testing
	public static Product inValidProduct() {
		// Creating an invalid Product object with a negative product ID
		Product product = new Product();
		product.setProductId(-1);
		return product;
	}

	// Test for adding a valid product
	@Test
	public void testValidAddProduct() throws DAOException, SQLException {
		// Assert that the ProductDao.addProduct method returns true for a valid product
		Assertions.assertTrue(ProductDao.addProduct(productValidate2()));
	}

	// Test for updating a valid product
	@Test
	public void testValidUpdateProduct() throws DAOException, SQLException {
		// Assert that the ProductDao.addProduct method returns true for a valid product
		Assertions.assertTrue(ProductDao.addProduct(productValidate()));
	}

	// Test for deleting a valid product
	@Test
	public void testValidDeleteProduct() throws DAOException, SQLException {
		// Assert that the ProductDao.deleteProduct method returns true for a valid
		// product ID
		Assertions.assertTrue(ProductDao.deleteProduct(5));
	}

	// Test for adding an invalid product
	@Test
	public void testInvalidAddProduct() throws DAOException, SQLException {
		try {
			// Attempt to add an invalid product, should throw an exception
			ProductDao.addProduct(productValidate());
		} catch (InvalidProductDetailsException e) {
			// Assert that the exception message matches the expected error message
			Assertions.assertEquals(productDaoErrors.INVALID_ADD_PRODUCT, e.getMessage());
		}
	}

	// Test for updating a product with an invalid ID
	@Test
	public void testInvalidUpdateProduct() throws DAOException, SQLException {
		try {
			// Attempt to update a product with an invalid ID, should throw an exception
			ProductDao.updateProduct(inValidProduct());
		} catch (InvalidProductDetailsException e) {
			// Assert that the exception message matches the expected error message
			Assertions.assertEquals(productDaoErrors.INVALID_PRODUCT_ID, e.getMessage());
		}
	}

	// Test for deleting a product with an invalid ID
	@Test
	public void testInvalidDeleteProduct() throws DAOException, SQLException {
		try {
			// Attempt to delete a product with an invalid ID, should throw an exception
			ProductDao.deleteProduct(inValidProduct().getProductId());
		} catch (InvalidProductDetailsException e) {
			// Assert that the exception message matches the expected error message
			Assertions.assertEquals(productDaoErrors.INVALID_PRODUCT_ID, e.getMessage());
		}
	}
}
