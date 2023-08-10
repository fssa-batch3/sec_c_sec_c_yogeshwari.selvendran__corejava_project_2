package com.fssa.liveon.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.liveon.dao.ProductDao;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.Product;
import com.fssa.liveon.validator.ProductValidation;

class TestProductService {
	/**
	 * Helper method to create a valid Product instance for testing
	 */

	public Product getProduct() {
		// Creating a list of image URLs
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");
		// Creating a valid Product object
		Product product = new Product("Car", "AirFilter", 2000.0, 4, images, "Sampleproductdescription",
				"SampleAboutproduct");
		return product;
	}

	// Helper method to create another valid Product instance for testing
	public Product getProduct2() {
		// Creating a list of image URLs
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");
		// Creating another valid Product object with a specific product ID
		Product product = new Product(8, "Car", "AirFilter", 2000.0, 4, images, "Sampleproductdescription",
				"SampleAboutproduct");
		return product;
	}

	// Helper method to create and configure a ProductService instance for testing
	public ProductService getProductService() {
		// Creating instances for ProductValidation, ProductDao, and ProductService
//		ProductValidation productValidate = new ProductValidation();
//		ProductDao productDa0 = new ProductDao();
		ProductService productService = new ProductService();
		return productService;

	}

	// Test for adding a product
	@Test
	void testAddProduct() throws DAOException, SQLException {
		// Creating a valid Product instance
		Product product = getProduct();

		// Creating a ProductService instance
		ProductService productService = getProductService();
		// Asserting that the addProduct method returns true for the valid Product
		Assertions.assertTrue(productService.addProduct(product));

	}

	// Test for updating a product
	@Test
	void testUpdateProduct() throws DAOException, SQLException {
		// Creating a valid Product instance with a specific product ID
		Product product = getProduct2();
		// Creating a ProductService instance
		ProductService productService = getProductService();
		// Asserting that the updateProduct method returns true for the valid Product
		Assertions.assertTrue(productService.updateProduct(product));

	}

	// Test for deleting a product
	@Test
	void testDeleteProduct() throws DAOException, SQLException {
		// Creating a valid Product instance with a specific product ID
		Product product = getProduct2();
		// Creating a ProductService instance
		ProductService productService = getProductService();
		// Asserting that the deleteProduct method returns true for the specific product
		// ID
		Assertions.assertTrue(productService.deleteProduct(10));

	}

	// Test for getting product details
	@Test
	void testGetProductDetails() throws DAOException, SQLException {
		// Creating a valid Product instance
		Product product = getProduct();
		// Creating a ProductService instance
		ProductService productService = getProductService();
		// Asserting that the getProductDetail method returns true
		Assertions.assertTrue(productService.getProductDetail());
	}

}
