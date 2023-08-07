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
import com.fssa.liveon.validator.ProductValidationsErrors;

public class ProductDao {
	public static boolean addProduct(Product product) throws DAOException, SQLException {
		String storedProcedureCall = "{call InsertProduct(?, ?, ?, ?, ?, ?, ?)}";
		boolean rows;
		try (Connection con = ConnectionUtil.getConnection();
				CallableStatement callableStatement = con.prepareCall(storedProcedureCall)) {

			callableStatement.setString(1, product.getProductName());
			callableStatement.setString(2, product.getVehicleType());
			callableStatement.setDouble(3, product.getPrice());
			callableStatement.setInt(4, product.getRating());
			callableStatement.setString(5, product.getAboutProduct());
			callableStatement.setString(6, product.getDescription());

			String productImagesStr = String.join(",", product.getImageUrl());

			callableStatement.setString(7, productImagesStr);

			rows = callableStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(productDaoErrors.INVALID_ADD_PRODUCT);
		}
		return true;
	}

	public static boolean updateProduct(Product product) throws DAOException, SQLException {
		String storedProcedureCall = "{call UpdateProduct(?, ?, ?, ?, ?, ?, ?,?)}";
		boolean rows;
		try (Connection con = ConnectionUtil.getConnection();
				CallableStatement callableStatement = con.prepareCall(storedProcedureCall)) {

			callableStatement.setInt(1, product.getProductId());
			callableStatement.setString(2, product.getProductName());
			callableStatement.setString(3, product.getVehicleType());
			callableStatement.setDouble(4, product.getPrice());
			callableStatement.setInt(5, product.getRating());
			callableStatement.setString(6, product.getAboutProduct());
			callableStatement.setString(7, product.getDescription());

			String productImagesStr = String.join(",", product.getImageUrl());

			callableStatement.setString(8, productImagesStr);

			rows = callableStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(productDaoErrors.INVALID_UPDATE_PRODUCT);

		}
		return true;
	}

	public static boolean deleteProduct(int productId) throws DAOException, SQLException {

		if (productId <= 0) {
			throw new InvalidProductDetailsException(productDaoErrors.INVALID_PRODUCT_ID);
		}
		String storedProcedureCall = "{call DeleteProduct(?)}";
		boolean rows;
		try (Connection con = ConnectionUtil.getConnection();
				CallableStatement callableStatement = con.prepareCall(storedProcedureCall)) {

			callableStatement.setInt(1, productId);

			rows = callableStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(productDaoErrors.INVALID_DELETE_PRODUCT);

		}
		return true;
	}

	public static boolean getAllProduct() throws DAOException, SQLException {

		List<Product> productList = new ArrayList<>();

		/**
		 * The Query for selecting all grounddetails from all the table
		 */

		String selectQuery = "SELECT p.*, "
				+ "(SELECT GROUP_CONCAT(imageUrl) FROM ProductImages pi WHERE pi.product_Id = p.id) AS imageUrls, "
				+ "FROM Ground p";

		try (Connection con = ConnectionUtil.getConnection();

				PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
				ResultSet rs = preparedStatement.executeQuery()) {

			while (rs.next()) {
				int productId = rs.getInt("product_id");

				Product product = new Product();

				product.setProductId(productId);
				product.setProductName(rs.getString("productName"));
				product.setVehicleType(rs.getString("vehicle_type"));
				product.setPrice(rs.getDouble("price"));
				product.setRating(rs.getInt("rating"));
				product.setAboutProduct(rs.getString("aboutProduct"));
				product.setDescription(rs.getString("description"));

				String imageUrlsdata = rs.getString("imageUrls");
				if (imageUrlsdata != null) {
					String[] imageUrl = imageUrlsdata.split(",");
					product.setImageUrl(Arrays.asList(imageUrl));
				} else {
					product.setImageUrl(new ArrayList<>());
				}

				productList.add(product);
			}

		} catch (SQLException e) {

			throw new DAOException(productDaoErrors.INVALID_ALL_PRODUCT);
		}

		return true;
	}
}
