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
import com.fssa.liveon.exceptions.InvalidShopDetailsException;
import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;
import com.fssa.liveon.model.Shop;
import com.fssa.liveon.model.SparePart;
import com.fssa.liveon.util.ConnectionUtil;
import com.fssa.liveon.util.Logger;

public class ShopDAO {
	static Logger logger = new Logger();

	public boolean addShop(Shop shop) throws DAOException, SQLException {

		String storedProcedureCall = "{call InsertShop(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (CallableStatement callableStatement = con.prepareCall(storedProcedureCall)) {
				// Setting parameters for the stored procedure
				callableStatement.setString(1, shop.getShopName());
				callableStatement.setLong(2, shop.getShopNumber());
				callableStatement.setString(3, shop.getShopLicenceNumber());
				callableStatement.setString(4, shop.getStreetAddress());
				callableStatement.setString(5, shop.getCity());
				callableStatement.setString(6, shop.getPostalCode());
				callableStatement.setString(7, shop.getVehicleType());
				callableStatement.setString(8, shop.getShopDetails());
				callableStatement.setInt(9, shop.getPartnerId());
				String shopImagesStr = String.join(",", shop.getImageUrl());
				callableStatement.setString(10, shopImagesStr);

				callableStatement.execute();
			}
		} catch (SQLException e) {
			// Log the exception or handle it as needed
			e.printStackTrace();
			throw new DAOException(LiveOnDaoErrors.INVALID_ADD_PRODUCT, e);
		}
		return true;
	}

	public boolean updateShop(Shop shop) throws DAOException, SQLException {
		// Checking if the shop ID is valid
		if (shop.getShopId() <= 0) {
			throw new InvalidSparePartDetailsException(LiveOnDaoErrors.INVALID_ID);
		}

		String storedProcedureCall = "{call UpdateShop(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

		try (Connection con = ConnectionUtil.getConnection()) {
			try (CallableStatement callableStatement = con.prepareCall(storedProcedureCall)) {
				callableStatement.setInt(1, shop.getShopId());
				callableStatement.setString(2, shop.getShopName());
				callableStatement.setLong(3, shop.getShopNumber());
				callableStatement.setString(4, shop.getStreetAddress());
				callableStatement.setString(5, shop.getCity());
				callableStatement.setString(6, shop.getPostalCode());
				callableStatement.setString(7, shop.getVehicleType());
				callableStatement.setString(8, shop.getShopDetails());

				// If you want to update image URLs, you can pass them as a concatenated string
				String shopImagesStr = String.join(",", shop.getImageUrl());
				callableStatement.setString(9, shopImagesStr);

				// Execute the stored procedure
				callableStatement.execute();
			}

		} catch (SQLException e) {
			throw new DAOException(LiveOnDaoErrors.INVALID_UPDATE_SHOP);
		}
		return true;
	}

	// Method to delete a product from the database
	public boolean deleteShop(int shopId) throws DAOException, SQLException {
		// Checking if the product ID is valid
		if (shopId <= 0) {
			throw new InvalidSparePartDetailsException(LiveOnDaoErrors.INVALID_ID);
		}
		String storedProcedureCall = "{call DeleteShop(?)}";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (CallableStatement callableStatement2 = con.prepareCall(storedProcedureCall)) {

				callableStatement2.setInt(1, shopId);
				// Executing the stored procedure
				callableStatement2.execute();
			}
		} catch (SQLException e) {

			throw new DAOException(LiveOnDaoErrors.INVALID_DELETE_PRODUCT);

		}
		return true;
	}

	public List<Shop> getShopDetailByPartnerId(int partnerId) throws DAOException {
		List<Shop> shopList = new ArrayList();

		// SQL query to retrieve shop details along with image URLs
		String selectQuery = "SELECT " + "S.shopId, " + "S.shopName, " + "S.shopNumber, " + "S.shopLicenceNumber, "
				+ "S.streetAddress, " + "S.city, " + "S.postalCode, " + "S.vehicleType, " + "S.shopDetails, "
				+ "S.shopStatus, " + "GROUP_CONCAT(SI.imageUrl) AS imageUrls " + "FROM Shops AS S "
				+ "LEFT JOIN ShopImages AS SI ON S.shopId = SI.shopId " + "WHERE S.partnerId = ? "
				+ "GROUP BY S.shopId";

		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {
				preparedStatement.setInt(1, partnerId);

				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						Shop readShop = new Shop();
						// Setting shop attributes from the retrieved data
						readShop.setShopId(resultSet.getInt("shopId"));
						readShop.setShopName(resultSet.getString("shopName"));
						readShop.setShopNumber(resultSet.getLong("shopNumber"));
						readShop.setShopLicenceNumber(resultSet.getString("shopLicenceNumber"));
						readShop.setStreetAddress(resultSet.getString("streetAddress"));
						readShop.setCity(resultSet.getString("city"));
						readShop.setPostalCode(resultSet.getString("postalCode"));
						readShop.setVehicleType(resultSet.getString("vehicleType"));
						readShop.setShopDetails(resultSet.getString("shopDetails"));
						// Splitting and setting image URLs
						String imageUrlsData = resultSet.getString("imageUrls");
						if (imageUrlsData != null) {
							String[] imageUrls = imageUrlsData.split(",");
							readShop.setImageUrl(Arrays.asList(imageUrls));
						} else {
							readShop.setImageUrl(new ArrayList<>());
						}
						shopList.add(readShop);
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException(LiveOnDaoErrors.INVALID_GET_SHOP_DETAILS);
		}
		return shopList;
	}

	public List<Shop> getAllShops() throws DAOException, SQLException {
		List<Shop> shopList = new ArrayList<>();

		// SQL query to retrieve shop details along with image URLs
		String selectQuery = "SELECT " + "S.shopId, " + "S.shopName, " + "S.shopNumber, " + "S.shopLicenceNumber, "
				+ "S.streetAddress, " + "S.city, " + "S.postalCode, " + "S.vehicleType, " + "S.shopDetails, "
				+ "S.shopStatus, " + "GROUP_CONCAT(SI.imageUrl) AS imageUrls " + "FROM Shops AS S "
				+ "LEFT JOIN ShopImages AS SI ON S.shopId = SI.shopId " + "WHERE S.shopStatus = 1 "
				+ "GROUP BY S.shopId";

		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {
				try (ResultSet rs = preparedStatement.executeQuery()) {
					while (rs.next()) {
						Shop shop = new Shop();
						shop.setShopId(rs.getInt("shopId"));
						shop.setShopName(rs.getString("shopName"));
						shop.setShopNumber(rs.getLong("shopNumber"));
						shop.setShopLicenceNumber(rs.getString("shopLicenceNumber"));
						shop.setStreetAddress(rs.getString("streetAddress"));
						shop.setCity(rs.getString("city"));
						shop.setPostalCode(rs.getString("postalCode"));
						shop.setVehicleType(rs.getString("vehicleType"));
						shop.setShopDetails(rs.getString("shopDetails"));

						// Corrected setting of shopStatus
						// shop.set(rs.getByte("shopStatus"));

						// Splitting and setting image URLs
						String imageUrlsData = rs.getString("imageUrls");
						if (imageUrlsData != null) {
							String[] imageUrls = imageUrlsData.split(",");
							shop.setImageUrl(Arrays.asList(imageUrls));
						} else {
							shop.setImageUrl(new ArrayList<>());
						}

						shopList.add(shop);
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException(LiveOnDaoErrors.INVALID_GET_SHOP_DETAILS);
		}

		return shopList;
	}

	public Shop getShopDetailById(int id) throws DAOException {
		String selectQuery = "SELECT " + "S.shopId, " + "S.shopName, " + "S.shopNumber, " + "S.shopLicenceNumber, "
				+ "S.streetAddress, " + "S.city, " + "S.postalCode, " + "S.vehicleType, " + "S.shopDetails, "
				+ "S.partnerId, " + "GROUP_CONCAT(SI.imageUrl) AS imageUrls " + "FROM Shops AS S "
				+ "LEFT JOIN ShopImages AS SI ON S.shopId = SI.shopId " + "WHERE S.shopId = ? " + "GROUP BY S.shopId";
		;

		Shop shop = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {
				preparedStatement.setInt(1, id);

				try (ResultSet rs = preparedStatement.executeQuery()) {
					if (rs.next()) {
						shop = new Shop();
						shop.setShopId(rs.getInt("shopId"));
						shop.setShopName(rs.getString("shopName"));
						shop.setShopNumber(rs.getLong("shopNumber"));
						shop.setShopLicenceNumber(rs.getString("shopLicenceNumber"));
						shop.setStreetAddress(rs.getString("streetAddress"));
						shop.setCity(rs.getString("city"));
						shop.setPostalCode(rs.getString("postalCode"));
						shop.setVehicleType(rs.getString("vehicleType"));
						shop.setShopDetails(rs.getString("shopDetails"));
						shop.setPartnerId(rs.getInt("partnerId"));
						// Splitting and setting image URLs
						String imageUrlsData = rs.getString("imageUrls"); // Corrected field name
						if (imageUrlsData != null) {
							String[] imageUrls = imageUrlsData.split(",");
							shop.setImageUrl(Arrays.asList(imageUrls));
						} else {
							shop.setImageUrl(new ArrayList<>());
						}
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException(LiveOnDaoErrors.INVALID_GET_SHOP_DETAILS);
		}

		return shop;
	}

}
