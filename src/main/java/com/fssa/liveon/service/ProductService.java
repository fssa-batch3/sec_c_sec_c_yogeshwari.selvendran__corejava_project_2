package com.fssa.liveon.service;

import java.sql.SQLException;
import com.fssa.liveon.dao.ProductDao;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.Product;
import com.fssa.liveon.validator.ProductValidation;

public class ProductService {
	/**
	 * Declare member variables for ProductValidation and ProductDao
	 */


	/**
	 * Constructor that accepts instances of ProductValidation and ProductDao
	 * 
	 * @param productValidation
	 * @param productDao
	 */


	/**
	 * Default constructor
	 */

	private ProductService() {

	}

	/**
	 * Method to add a product
	 * 
	 * @param product
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */

	public static boolean addProduct(Product product) throws DAOException, SQLException {
		/**
		 * Validate the product using ProductValidation
		 */

		if (ProductValidation.validateProduct(product)) {
			/**
			 * Call the addProduct method in ProductDao
			 */

			ProductDao.addProduct(product);
		}
		return true;
	}

	/**
	 * Method to update a product
	 * 
	 * @param product
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */

	public static boolean updateProduct(Product product) throws DAOException, SQLException {
		/**
		 * Validate the product using ProductValidation
		 */

		if (ProductValidation.validateProduct(product)) {
			/**
			 * Call the updateProduct method in ProductDao
			 */

			ProductDao.updateProduct(product);
		}
		return true;
	}

	/**
	 * Method to delete a product by productId
	 * 
	 * @param productId
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */

	public static boolean deleteProduct(int productId) throws DAOException, SQLException {
		/**
		 * Validate the productId using ProductValidation
		 */

		if (ProductValidation.productIdValidate(productId)) {
			/**
			 * Call the deleteProduct method in ProductDao
			 */

			ProductDao.deleteProduct(productId);
		}
		return true;
	}

	/**
	 * Method to get product details
	 * 
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */

	public static boolean getProductDetail() throws DAOException, SQLException {
		/**
		 * Call the getAllProduct method in ProductDao
		 */

		ProductDao.getAllProduct();
		return true;
	}
}
