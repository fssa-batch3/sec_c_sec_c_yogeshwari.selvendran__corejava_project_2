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
import com.fssa.liveon.exceptions.InvalidProductDetailsException;
import com.fssa.liveon.model.Product;
import com.fssa.liveon.util.ConnectionUtil;
import com.fssa.liveon.util.Logger;

public class ProductDao {

	private ProductDao() {
		// private constructor
	}

	static Logger logger = new Logger();

	final static String PRODUCT_NAME_KEY = "productName";
	final static String VEHICLE_TYPE = "vehicle_type";
	final static String PRICE_KEY = "price";
	final static String PRODUCT_RATING = "rating";
	final static String ABOUT_PRODUCT = "aboutProduct";
	final static String PRODUCT_DESCRIPTION = "description";
	final static String IMAGES_URL = "imageUrls";

	public static boolean addProduct(Product product) throws DAOException, SQLException {

		String storedProcedureCall = "{call InsertProduct(?, ?, ?, ?, ?, ?, ?)}";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (CallableStatement callableStatement = con.prepareCall(storedProcedureCall)) {
				// Setting parameters for the stored procedure
				callableStatement.setString(1, product.getProductName());
				callableStatement.setString(2, product.getVehicleType());
				callableStatement.setDouble(3, product.getPrice());
				callableStatement.setInt(4, product.getRating());
				callableStatement.setString(5, product.getAboutProduct());
				callableStatement.setString(6, product.getDescription());

				String productImagesStr = String.join(",", product.getImageUrl());

				callableStatement.setString(7, productImagesStr);
				// Executing the stored procedure
				callableStatement.execute();

			}
		} catch (SQLException e) {

			throw new DAOException(ProductSDaoErrors.INVALID_ADD_PRODUCT);
		}
		return true;
	}

	// Method to update a product in the database
	public static boolean updateProduct(Product product) throws DAOException, SQLException {

		// Checking if the product ID is valid
		if (product.getProductId() <= 0) {
			throw new InvalidProductDetailsException(ProductSDaoErrors.INVALID_PRODUCT_ID);
		}
		String storedProcedureCall = "{call UpdateProduct(?, ?, ?, ?, ?, ?, ?,?)}";

		try (Connection con = ConnectionUtil.getConnection()) {
			try (CallableStatement callableStatement1 = con.prepareCall(storedProcedureCall)) {

				callableStatement1.setInt(1, product.getProductId());
				callableStatement1.setString(2, product.getProductName());
				callableStatement1.setString(3, product.getVehicleType());
				callableStatement1.setDouble(4, product.getPrice());
				callableStatement1.setInt(5, product.getRating());
				callableStatement1.setString(6, product.getAboutProduct());
				callableStatement1.setString(7, product.getDescription());
				String productImagesStr = String.join(",", product.getImageUrl());

				callableStatement1.setString(8, productImagesStr);
				// Executing the stored procedure
				callableStatement1.execute();
			}
		} catch (SQLException e) {

			throw new DAOException(ProductSDaoErrors.INVALID_UPDATE_PRODUCT);

		}
		return true;
	}

	// Method to delete a product from the database
	public static boolean deleteProduct(int productId) throws DAOException, SQLException {
		// Checking if the product ID is valid
		if (productId <= 0) {
			throw new InvalidProductDetailsException(ProductSDaoErrors.INVALID_PRODUCT_ID);
		}
		String storedProcedureCall = "{call DeleteProduct(?)}";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (CallableStatement callableStatement2 = con.prepareCall(storedProcedureCall)) {

				callableStatement2.setInt(1, productId);
				// Executing the stored procedure
				callableStatement2.execute();
			}
		} catch (SQLException e) {

			throw new DAOException(ProductSDaoErrors.INVALID_DELETE_PRODUCT);

		}
		return true;
	}

	// Method to retrieve all product details from the database
	public static boolean getAllProduct() throws DAOException, SQLException {

		List<Product> productList = new ArrayList<>();

		// SQL query to retrieve product details along with image URLs
		String selectQuery = "SELECT p.*, "
				+ "(SELECT GROUP_CONCAT(imageUrl) FROM ProductImages pi WHERE pi.product_Id = p.product_id) AS imageUrls "
				+ "FROM Product p";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {
				try (ResultSet rs = preparedStatement.executeQuery()) {

					while (rs.next()) {
						int productId = rs.getInt("product_id");

						Product product = new Product();
						// Setting product attributes from the retrieved data

						product.setProductId(productId);
						product.setProductName(rs.getString(PRODUCT_NAME_KEY));
						product.setVehicleType(rs.getString(VEHICLE_TYPE));
						product.setPrice(rs.getDouble(PRICE_KEY));
						product.setRating(rs.getInt(PRODUCT_RATING));
						product.setAboutProduct(rs.getString(ABOUT_PRODUCT));
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
						logger.info(rs.getString(ABOUT_PRODUCT));
						logger.info(rs.getString(PRODUCT_DESCRIPTION));
						logger.info(rs.getString(IMAGES_URL));

						productList.add(product);
					}

				}
			}
		} catch (SQLException e) {

			throw new DAOException(ProductSDaoErrors.INVALID_ALL_PRODUCT);
		}

		return true;
	}

	public static boolean findProductByVehicleType(String vehicleType) throws DAOException, SQLException {

		List<Product> productList = new ArrayList<>();

		// SQL query to retrieve product details along with image URLs

		String selectQuery = "SELECT p.*, "
				+ "(SELECT GROUP_CONCAT(imageUrl) FROM ProductImages pi WHERE pi.product_Id = p.product_id) AS imageUrls "
				+ "FROM Product p " + "WHERE p.vehicle_type = ?";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {

				preparedStatement.setString(1, vehicleType);

				try (ResultSet ys = preparedStatement.executeQuery()) {

					while (ys.next()) {
						int productId = ys.getInt("product_id");

						Product readProduct = new Product();
						// Setting product attributes from the retrieved data
						readProduct.setProductId(productId);
						readProduct.setProductName(ys.getString(PRODUCT_NAME_KEY));
						readProduct.setVehicleType(ys.getString(VEHICLE_TYPE));
						readProduct.setPrice(ys.getDouble(PRICE_KEY));
						readProduct.setRating(ys.getInt(PRODUCT_RATING));
						readProduct.setAboutProduct(ys.getString(ABOUT_PRODUCT));
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
						logger.info(ys.getString(ABOUT_PRODUCT));
						logger.info(ys.getString(PRODUCT_DESCRIPTION));
						logger.info(ys.getString(IMAGES_URL));

						productList.add(readProduct);
					}
				}
			}

		} catch (SQLException e) {

			throw new DAOException(ProductSDaoErrors.INVALID_ALL_PRODUCT);
		}

		return true;

	}

}
