package com.fssa.liveon.service;

import java.sql.SQLException;
import com.fssa.liveon.dao.SparePartsDao;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.SparePart;
import com.fssa.liveon.validator.SparePartValidation;

public class SparePartService {
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

	private SparePartService() {

	}

	/**
	 * Method to add a product
	 * 
	 * @param product
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */

	public static boolean addSparePart(SparePart product) throws DAOException, SQLException {
		/**
		 * Validate the product using ProductValidation
		 */

		if (SparePartValidation.validateProduct(product)) {
			/**
			 * Call the addProduct method in ProductDao
			 */

			SparePartsDao.addSparePart(product);
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

	public static boolean updateSparePart(SparePart product) throws DAOException, SQLException {
		/**
		 * Validate the product using ProductValidation
		 */

		if (SparePartValidation.validateProduct(product)) {
			/**
			 * Call the updateProduct method in ProductDao
			 */

			SparePartsDao.UpdateSparePart(product);
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

	public static boolean deleteSparePart(int productId) throws DAOException, SQLException {
		/**
		 * Validate the productId using ProductValidation
		 */

		if (SparePartValidation.productIdValidate(productId)) {
			/**
			 * Call the deleteProduct method in ProductDao
			 */

			SparePartsDao.deleteSparePart(productId);
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
		SparePartsDao.getAllParts();
		return true;
	}

	public static boolean getProductDetailByType() throws DAOException, SQLException {
		/**
		 * Call the getAllProduct method in ProductDao
		 */
		SparePartsDao.findSparePartByVehicleType("Bike");
		return true;

	}

}
