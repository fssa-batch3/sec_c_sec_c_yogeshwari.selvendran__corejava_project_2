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

					while (rs.next()) {
						int productId = rs.getInt("product_id");

						Product product = new Product();
						// Setting product attributes from the retrieved data
						product.setProductId(productId);
						product.setProductName(rs.getString("productName"));
						product.setVehicleType(rs.getString("vehicle_type"));
						product.setPrice(rs.getDouble("price"));
						product.setRating(rs.getInt("rating"));
						product.setAboutProduct(rs.getString("aboutProduct"));
						product.setDescription(rs.getString("description"));
						// Splitting and setting image URLs
						String imageUrlsdata = rs.getString("imageUrls");
						if (imageUrlsdata != null) {
							String[] imageUrl = imageUrlsdata.split(",");
							product.setImageUrl(Arrays.asList(imageUrl));
						} else {
							product.setImageUrl(new ArrayList<>());
						}

						// Logging retrieved product details
						logger.info(rs.getString("productName"));
						logger.info(rs.getString("vehicle_type"));
						logger.info(rs.getDouble("price"));
						logger.info(rs.getInt("rating"));
						logger.info(rs.getString("aboutProduct"));
						logger.info(rs.getString("description"));
						logger.info(rs.getString("imageUrls"));

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
						readProduct.setProductName(ys.getString("productName"));
						readProduct.setVehicleType(ys.getString("vehicle_type"));
						readProduct.setPrice(ys.getDouble("price"));
						readProduct.setRating(ys.getInt("rating"));
						readProduct.setAboutProduct(ys.getString("aboutProduct"));
						readProduct.setDescription(ys.getString("description"));
						// Splitting and setting image URLs
						String imageUrlsdata = ys.getString("imageUrls");
						if (imageUrlsdata != null) {
							String[] imageUrl = imageUrlsdata.split(",");
							readProduct.setImageUrl(Arrays.asList(imageUrl));
						} else {
							readProduct.setImageUrl(new ArrayList<>());
						}
						// Logging retrieved product details
						logger.info(ys.getString("productName"));
						logger.info(ys.getString("vehicle_type"));
						logger.info(ys.getDouble("price"));
						logger.info(ys.getInt("rating"));
						logger.info(ys.getString("aboutProduct"));
						logger.info(ys.getString("description"));
						logger.info(ys.getString("imageUrls"));

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
