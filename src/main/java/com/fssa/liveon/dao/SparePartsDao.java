package com.fssa.liveon.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;
import com.fssa.liveon.model.SparePart;
import com.fssa.liveon.util.ConnectionUtil;
import com.fssa.liveon.util.Logger;

public class SparePartsDao {

	private SparePartsDao() {
		// private constructor
	}

	static Logger logger = new Logger();

	static final String PRODUCT_NAME_KEY = "name";
	static final String VEHICLE_TYPE = "vehicle_type";
	static final String PRICE_KEY = "price";
	static final String PRODUCT_RATING = "rating";
	static final String PRODUCT_DESCRIPTION = "description";
	static final String IMAGES_URL = "imageUrls";

	public static boolean addSparePart(SparePart product) throws DAOException, SQLException {

		String storedProcedureCall = "{call InsertSparepart(?, ?, ?, ?, ?, ?)}";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (CallableStatement callableStatement = con.prepareCall(storedProcedureCall)) {
				// Setting parameters for the stored procedure
				callableStatement.setString(1, product.getName());
				callableStatement.setString(2, product.getVehicleType());
				callableStatement.setDouble(3, product.getPrice());
				callableStatement.setInt(4, product.getRating());
				callableStatement.setString(5, product.getDescription());

				String productImagesStr = String.join(",", product.getImageUrl());

				callableStatement.setString(6, productImagesStr);
				// Executing the stored procedure
				callableStatement.execute();

			}
		} catch (SQLException e) {

			throw new DAOException(SparePartsDaoErrors.INVALID_ADD_PRODUCT);
		}
		return true;
	}

	// Method to update a product in the database
	public static boolean UpdateSparePart(SparePart product) throws DAOException, SQLException {

		// Checking if the product ID is valid
		if (product.getId() <= 0) {
			throw new InvalidSparePartDetailsException(SparePartsDaoErrors.INVALID_PRODUCT_ID);
		}
		String storedProcedureCall = "{call UpdateSpare_part(?, ?, ?, ?, ?, ?, ?)}";

		try (Connection con = ConnectionUtil.getConnection()) {
			try (CallableStatement callableStatement1 = con.prepareCall(storedProcedureCall)) {

				callableStatement1.setInt(1, product.getId());
				callableStatement1.setString(2, product.getName());
				callableStatement1.setString(3, product.getVehicleType());
				callableStatement1.setDouble(4, product.getPrice());
				callableStatement1.setInt(5, product.getRating());
				callableStatement1.setString(6, product.getDescription());
				String productImagesStr = String.join(",", product.getImageUrl());

				callableStatement1.setString(7, productImagesStr);
				// Executing the stored procedure
				callableStatement1.execute();
			}
		} catch (SQLException e) {

			throw new DAOException(SparePartsDaoErrors.INVALID_UPDATE_PRODUCT);

		}
		return true;
	}

	// Method to delete a product from the database
	public static boolean deleteSparePart(int productId) throws DAOException, SQLException {
		// Checking if the product ID is valid
		if (productId <= 0) {
			throw new InvalidSparePartDetailsException(SparePartsDaoErrors.INVALID_PRODUCT_ID);
		}
		String storedProcedureCall = "{call DeleteSpareParts(?)}";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (CallableStatement callableStatement2 = con.prepareCall(storedProcedureCall)) {

				callableStatement2.setInt(1, productId);
				// Executing the stored procedure
				callableStatement2.execute();
			}
		} catch (SQLException e) {

			throw new DAOException(SparePartsDaoErrors.INVALID_DELETE_PRODUCT);

		}
		return true;
	}

	public static List<SparePart> getAllParts() throws DAOException, SQLException {

	    List<SparePart> sparePartList = new ArrayList<>();

	    // SQL query to retrieve product details along with image URLs
	    String selectQuery = "SELECT sp.*, "
	            + "(SELECT GROUP_CONCAT(imageUrl) FROM SparePartImages spi WHERE spi.SparePart_Id = sp.id) AS imageUrls "
	            + "FROM Sparepart sp";

	    try (Connection con = ConnectionUtil.getConnection()) {

	        try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {
	            try (ResultSet rs = preparedStatement.executeQuery()) {

	                while (rs.next()) {
	                    int sparePartId = rs.getInt("id");

	                    SparePart product = new SparePart();
	                    // Setting product attributes from the retrieved data

	                    product.setId(sparePartId );
	                    product.setName(rs.getString(PRODUCT_NAME_KEY));
	                    product.setVehicleType(rs.getString(VEHICLE_TYPE));
	                    product.setPrice(rs.getDouble(PRICE_KEY));
	                    product.setRating(rs.getInt(PRODUCT_RATING));
	                    product.setDescription(rs.getString(PRODUCT_DESCRIPTION));
	                    // Splitting and setting image URLs
	                    String imageUrlsdata = rs.getString(IMAGES_URL);
	                    if (imageUrlsdata != null) {
	                        String[] imageUrl = imageUrlsdata.split(",");
	                        product.setImageUrl(Arrays.asList(imageUrl));
	                    } else {
	                        product.setImageUrl(new ArrayList<>());
	                    }

	                    // Logging retrieved product details
	                    logger.info(rs.getString(PRODUCT_NAME_KEY));
	                    logger.info(rs.getString(VEHICLE_TYPE));
	                    logger.info(rs.getDouble(PRICE_KEY));
	                    logger.info(rs.getInt(PRODUCT_RATING));
	                    logger.info(rs.getString(PRODUCT_DESCRIPTION));
	                    logger.info(rs.getString(IMAGES_URL));

	                    sparePartList.add(product);
	                }

	            }
	        }
	    } catch (SQLException e) {

	        throw new DAOException(SparePartsDaoErrors.INVALID_ALL_PRODUCT);
	    }

	    return sparePartList;
	}


 public static List<SparePart> findSparePartByVehicleType(String vehicleType) throws DAOException, SQLException {

	    List<SparePart> sparePartList = new ArrayList<>();

		// SQL query to retrieve product details along with image URLs

	    String selectQuery = "SELECT sp.*, "
	            + "(SELECT GROUP_CONCAT(imageUrl) FROM SparePartImages spi WHERE spi.SparePart_Id = sp.id) AS imageUrls "
	            + "FROM Sparepart sp "
	            + "WHERE sp.vehicle_type = ?";


		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {

				preparedStatement.setString(1, vehicleType);

				try (ResultSet ys = preparedStatement.executeQuery()) {

					while (ys.next()) {
						int productId = ys.getInt("id");

						SparePart readProduct = new SparePart();
						// Setting product attributes from the retrieved data
						readProduct.setId(productId);
						readProduct.setName(ys.getString(PRODUCT_NAME_KEY));
						readProduct.setVehicleType(ys.getString(VEHICLE_TYPE));
						readProduct.setPrice(ys.getDouble(PRICE_KEY));
						readProduct.setRating(ys.getInt(PRODUCT_RATING));
						readProduct.setDescription(ys.getString(PRODUCT_DESCRIPTION));
						// Splitting and setting image URLs
						String imageUrlsdata = ys.getString(IMAGES_URL);
						if (imageUrlsdata != null) {
							String[] imageUrl = imageUrlsdata.split(",");
							readProduct.setImageUrl(Arrays.asList(imageUrl));
						} else {
							readProduct.setImageUrl(new ArrayList<>());
						}
						// Logging retrieved product details
						logger.info(ys.getString(PRODUCT_NAME_KEY));
						logger.info(ys.getString(VEHICLE_TYPE));
						logger.info(ys.getDouble(PRICE_KEY));
						logger.info(ys.getInt(PRODUCT_RATING));
						logger.info(ys.getString(PRODUCT_DESCRIPTION));
						logger.info(ys.getString(IMAGES_URL));

						sparePartList.add(readProduct);
					}

				}
			}

		} catch (SQLException e) {

			throw new DAOException(SparePartsDaoErrors.INVALID_ALL_PRODUCT);
		}

		return sparePartList;

	}

}
