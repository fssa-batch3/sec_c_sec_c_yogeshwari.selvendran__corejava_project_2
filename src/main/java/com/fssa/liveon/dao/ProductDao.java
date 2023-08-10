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

	// Method to add a product to the database
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

					String productName = rs.getString("productName");
					String vehicleType = rs.getNString("vehicle_type");
					double price = rs.getDouble("price");
					int rating = rs.getInt("rating");
					String aboutProduct = rs.getString("aboutProduct");
					String productDexcription = rs.getString("description");

					while (rs.next()) {
						int productId = rs.getInt("product_id");

						Product product = new Product();
						// Setting product attributes from the retrieved data
						product.setProductId(productId);
						product.setProductName(productName);
						product.setVehicleType(vehicleType);
						product.setPrice(price);
						product.setRating(rating);
						product.setAboutProduct(aboutProduct);
						product.setDescription(productDexcription);
						// Splitting and setting image URLs
						String imageUrlsdata = rs.getString("imageUrls");
						if (imageUrlsdata != null) {
							String[] imageUrl = imageUrlsdata.split(",");
							product.setImageUrl(Arrays.asList(imageUrl));
						} else {
							product.setImageUrl(new ArrayList<>());
						}

						// Logging retrieved product details
						logger.info(productName);
						logger.info(vehicleType);
						logger.info(price);
						logger.info(rating);
						logger.info(aboutProduct);
						logger.info(productDexcription);
						logger.info(imageUrlsdata);

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
					String productName1 = ys.getString("productName");
					String vehicleType1 = ys.getNString("vehicle_type");
					double price1 = ys.getDouble("price");
					int rating1 = ys.getInt("rating");
					String aboutProduct1 = ys.getString("aboutProduct");
					String productDexcription1 = ys.getString("description");
					while (ys.next()) {
						int productId = ys.getInt("product_id");

						Product readProduct = new Product();
						// Setting product attributes from the retrieved data
						readProduct.setProductId(productId);
						readProduct.setProductName(productName1);
						readProduct.setVehicleType(vehicleType1);
						readProduct.setPrice(price1);
						readProduct.setRating(rating1);
						readProduct.setAboutProduct(aboutProduct1);
						readProduct.setDescription(productDexcription1);
						// Splitting and setting image URLs
						String imageUrlsdata = ys.getString("imageUrls");
						if (imageUrlsdata != null) {
							String[] imageUrl = imageUrlsdata.split(",");
							readProduct.setImageUrl(Arrays.asList(imageUrl));
						} else {
							readProduct.setImageUrl(new ArrayList<>());
						}
						// Logging retrieved product details
						logger.info(productId);
						logger.info(productName1);
						logger.info(vehicleType1);
						logger.info(price1);
						logger.info(rating1);
						logger.info(aboutProduct1);
						logger.info(productDexcription1);

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
