package com.fssa.liveon.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.liveon.dao.SparePartsDAO;
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

	public SparePartService() {

	}

	SparePartsDAO sparepartsDao = new SparePartsDAO();
	SparePartValidation sparePartsValidation = new SparePartValidation();

	/**
	 * Method to add a product
	 * 
	 * @param product
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */

	public boolean addSparePart(SparePart product) throws DAOException, SQLException {
		/**
		 * Validate the product using ProductValidation
		 */

		if (sparePartsValidation.validateSparePart(product)) {
			/**
			 * Call the addProduct method in ProductDao
			 */

			sparepartsDao.addSparePart(product);
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

	public boolean updateSparePart(SparePart product) throws DAOException, SQLException {
		/**
		 * Validate the product using ProductValidation
		 */
		if (sparePartsValidation.validateSparePart(product)) {
			/**
			 * Call the updateProduct method in ProductDao
			 */

			sparepartsDao.updateSparePart(product);
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

	public boolean deleteSparePart(int productId) throws DAOException, SQLException {
		/**
		 * Validate the productId using ProductValidation
		 */

		if (sparePartsValidation.idValidate(productId)) {
			/**
			 * Call the deleteProduct method in ProductDao
			 */

			sparepartsDao.deleteSparePart(productId);
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

	public List<SparePart> getSparepartDetails() throws DAOException, SQLException {
		/**
		 * Call the getAllProduct method in ProductDao
		 */

		return sparepartsDao.getAllParts();
	}

	public List<SparePart> getSparepartsDetailByType() throws DAOException, SQLException {
		/**
		 * Call the getAllProduct method in ProductDao
		 */
		return sparepartsDao.findSparePartByVehicleType("Bike");

	}
	public SparePart getSparePartDetailById(int id) throws DAOException {
		/**
		 * Call the getAllProduct method in ProductDao
		 */
		return sparepartsDao.getSparePartDetailById(id);

	}

}
