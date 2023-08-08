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

public class TestProductService {
	public Product getProduct() {
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");

		Product product = new Product("Car", "AirFilter", 2000.0, 4, images, "Sampleproductdescription",
				"SampleAboutproduct");
		return product;
	}

	public Product getProduct2() {
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");

		Product product = new Product(5, "Car", "AirFilter", 2000.0, 4, images, "Sampleproductdescription",
				"SampleAboutproduct");
		return product;
	}

	public ProductService getProductService() {

		ProductValidation productValidate = new ProductValidation();
		ProductDao productDa0 = new ProductDao();
		ProductService productService = new ProductService();
		return productService;

	}
	
	@Test
	public void testAddProduct()throws DAOException, SQLException{
		Product product = getProduct();
		ProductService productService = getProductService();
		Assertions.assertTrue(productService.addProduct(product));
		
	}
	@Test
	public void testUpdateProduct()throws DAOException, SQLException{
		Product product = getProduct2();
		ProductService productService = getProductService();
		Assertions.assertTrue(productService.updateProduct(product));
		
	}
	
	@Test
	public void testDeleteProduct()throws DAOException, SQLException{
		Product product = getProduct2();
		ProductService productService = getProductService();
		Assertions.assertTrue(productService.deleteProduct(7));
		
	}
	@Test
	public void testGetProductDetails()throws DAOException, SQLException{
		Product product = getProduct();
		ProductService productService = getProductService();
		Assertions.assertTrue(productService.getProductDetail());
	}

}
