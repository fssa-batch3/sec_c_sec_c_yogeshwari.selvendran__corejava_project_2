package com.fssa.liveon.service;

import java.sql.SQLException; 
import com.fssa.liveon.dao.ProductDao;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.Product;
import com.fssa.liveon.validator.ProductValidation;

public class ProductService {
	  // Declare member variables for ProductValidation and ProductDao
	private ProductValidation ProductValidation;
	private ProductDao ProductDao;
	// Constructor that accepts instances of ProductValidation and ProductDao
	public ProductService(ProductValidation productValidation,ProductDao productDao) {
		super();
		ProductValidation = productValidation;
		ProductDao = productDao;
	}
	// Default constructor
	public ProductService() {
		
	}
	 // Method to add a product
	public boolean addProduct(Product product)throws DAOException,SQLException{
		 // Validate the product using ProductValidation
		if(this.ProductValidation.validateProduct(product)) {
			 // Call the addProduct method in ProductDao
			this.ProductDao.addProduct(product);
		}
		return true; 
	}
	 // Method to update a product
	public boolean updateProduct(Product product)throws DAOException,SQLException{
		  // Validate the product using ProductValidation
		if(this.ProductValidation.validateProduct(product)) {
			  // Call the updateProduct method in ProductDao
			this.ProductDao.updateProduct(product);
		}
		return true;
	}
	 // Method to delete a product by productId
	public boolean deleteProduct(int productId)throws DAOException,SQLException{
		// Create an instance of ProductValidation
		ProductValidation productValidation = new ProductValidation();
		 // Validate the productId using ProductValidation
		if(productValidation.productIdValidate(productId)) {
			   // Call the deleteProduct method in ProductDao
			this.ProductDao.deleteProduct(productId);
		}
		return true;
	}
	// Method to get product details
	public boolean getProductDetail()throws DAOException,SQLException {
		// Create an instance of ProductDao
		ProductDao  productdao = new ProductDao();
	    // Call the getAllProduct method in ProductDao
		productdao.getAllProduct();
		return true;
	}
}
