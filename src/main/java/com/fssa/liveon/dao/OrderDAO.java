package com.fssa.liveon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.Orders;
import com.fssa.liveon.model.SparePart;
import com.fssa.liveon.model.User;
import com.fssa.liveon.util.ConnectionUtil;

public class OrderDAO {

	public boolean placeOrder(Orders order) throws DAOException, SQLException {
		String selectQuery = "INSERT INTO Orders (sparepart_id, user_id, street_address, city, postal_code, orderStatus, paymentMethod) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {
				preparedStatement.setInt(1, order.getSparepartId());
				preparedStatement.setInt(2, order.getUserId());
				preparedStatement.setString(3, order.getStreetAddress());
				preparedStatement.setString(4, order.getCity());
				preparedStatement.setString(5, order.getPostalCode());
				preparedStatement.setString(6, order.getOrderStatus());
				preparedStatement.setString(7, order.getPaymentmethod());
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {

			throw new DAOException(LiveOnDaoErrors.INVALID_ORDER_PLACEMENT);
		}
		return true;
	}

	public Orders getAllOrdersById(int orderId) throws DAOException, SQLException {
		String selectQuery = "SELECT * FROM Orders WHERE orderID = ?";
		Orders orders = null;
		// Initialize the Orders object outside the try-catch block

		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {
				preparedStatement.setInt(1, orderId);
				try (ResultSet rs = preparedStatement.executeQuery()) {
					if (rs.next()) {
						// Create a new Orders object for the result row
						orders = new Orders();
						// Set the attributes of the Orders object using the ResultSet
						orders.setOrderID(rs.getInt("orderID"));
						// Assuming you have a method setOrderId
						orders.setSparepartId(rs.getInt("sparepart_id"));
						orders.setUserId(rs.getInt("user_id"));
						orders.setDateAdded(rs.getTimestamp("DateAdded"));
						orders.setStreetAddress(rs.getString("street_address"));
						orders.setCity(rs.getString("city"));
						orders.setPostalCode(rs.getString("postal_code"));
						orders.setOrderStatus(rs.getString("orderStatus"));
						orders.setPaymentmethod(rs.getString("paymentMethod"));
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException(LiveOnDaoErrors.INVALID_GET_ALL_PRODUCTS);
		}
		return orders; // Return the Orders object, not the class name Orders
	}

	public List<Orders> getAllOrdersByUserId(int userId) throws DAOException {
		String selectQuery = "SELECT * FROM Orders WHERE user_id = ?";
		List<Orders> orders = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {

			preparedStatement.setInt(1, userId);

			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					// Create an Order object and populate it with data from the ResultSet
					Orders order = new Orders();
					order.setOrderID(rs.getInt("orderID"));
					order.setSparepartId(rs.getInt("sparepart_id"));
					order.setDateAdded(rs.getTimestamp("DateAdded"));
					order.setStreetAddress(rs.getString("street_address"));
					order.setCity(rs.getString("city"));
					order.setPostalCode(rs.getString("postal_code"));
					order.setOrderStatus(rs.getString("orderStatus"));
					order.setPaymentmethod(rs.getString("paymentMethod"));
					// Populate other order properties as needed
					// Add the order to the list
					orders.add(order);
				}
			}
		} catch (SQLException e) {
			throw new DAOException(LiveOnDaoErrors.INVALID_ORDER_HISTORY, e);
		}
		return orders;
	}
	public List<Orders> getAllOrdersForAdmin() throws DAOException, SQLException {
//	    String query = "SELECT o.orderID, o.DateAdded AS orderDate, u.firstname AS userFirstName, u.lastname AS userLastName, " +
//	            "u.gender AS userGender, u.mobile AS userMobile, u.email AS userEmail, s.name AS sparepartName, " +
//	            "s.vehicle_type AS sparepartVehicleType, s.price AS sparepartPrice, s.rating AS sparepartRating, " +
//	            "s.description AS sparepartDescription, o.street_address AS orderAddress, o.city AS orderCity, " +
//	            "o.postal_code AS orderPostalCode, o.orderStatus, o.paymentMethod " +
//	            "FROM Orders AS o " +
//	            "INNER JOIN USER AS u ON o.user_id = u.id " +
//	            "INNER JOIN Sparepart AS s ON o.sparepart_id = s.id";
		
	     String query = "SELECT " +
                 "o.orderID, " +
                 "MAX(o.DateAdded) AS orderDate, " +
                 "MAX(u.firstname) AS userFirstName, " +
                 "MAX(u.lastname) AS userLastName, " +
                 "MAX(u.gender) AS userGender, " +
                 "MAX(u.mobile) AS userMobile, " +
                 "MAX(u.email) AS userEmail, " +
                 "MAX(sp.name) AS sparepartName, " +
                 "MAX(sp.vehicle_type) AS sparepartVehicleType, " +
                 "MAX(sp.price) AS sparepartPrice, " +
                 "MAX(sp.rating) AS sparepartRating, " +
                 "MAX(sp.description) AS sparepartDescription, " +
                 "MAX(o.street_address) AS orderAddress, " +
                 "MAX(o.city) AS orderCity, " +
                 "MAX(o.postal_code) AS orderPostalCode, " +
                 "MAX(o.orderStatus) AS orderStatus, " +
                 "MAX(o.paymentMethod) AS paymentMethod, " +
                 "MAX(spi.img_id) AS imageId, " +
                 "MAX(spi.imageUrl) AS sparepartImageUrl " +
                 "FROM Orders AS o " +
                 "INNER JOIN USER AS u ON o.user_id = u.id " +
                 "INNER JOIN Sparepart AS sp ON o.sparepart_id = sp.id " +
                 "LEFT JOIN SparePartImages AS spi ON sp.id = spi.SparePart_Id " +
                 "GROUP BY o.orderID";

	    List<Orders> ordersList = new ArrayList<>();

	    try (Connection con = ConnectionUtil.getConnection();
	         PreparedStatement preparedStatement = con.prepareStatement(query);
	         ResultSet rs = preparedStatement.executeQuery()) {

	        while (rs.next()) {
	            Orders order = new Orders();
	            order.setOrderID(rs.getInt("orderID"));
	           // order.setOrderdate(rs.getTimestamp("orderDate")); // Assuming "DateAdded" is a timestamp
	            order.setOrderStatus(rs.getString("orderStatus"));
	            order.setPaymentmethod(rs.getString("paymentMethod"));
	            order.setStreetAddress(rs.getString("orderAddress"));
	            order.setCity(rs.getString("orderCity"));
	            order.setPostalCode(rs.getString("orderPostalCode"));

	            SparePart sparePart = new SparePart();
	            sparePart.setName(rs.getString("sparepartName"));
	            sparePart.setVehicleType(rs.getString("sparepartVehicleType"));
	            sparePart.setPrice(rs.getDouble("sparepartPrice"));
	            sparePart.setRating(rs.getInt("sparepartRating")); // Assuming "rating" is an INT
	            sparePart.setDescription(rs.getString("sparepartDescription"));

	            String imageUrlsData = rs.getString("sparepartImageUrl");
	            if (imageUrlsData != null) {
	                String[] imageUrlsArray = imageUrlsData.split(",");
	                sparePart.setImageUrl(Arrays.asList(imageUrlsArray));
	            } else {
	                // If there are no image URLs, you can set an empty list or handle it as needed.
	                sparePart.setImageUrl(new ArrayList<>());
	            }

	            order.setSparepart(sparePart);

	            User user = new User();
	            user.setFirstName(rs.getString("userFirstName"));
	            user.setLastName(rs.getString("userLastName"));
	            user.setGender(rs.getString("userGender"));
	           // user.setMobile(rs.getLong("userMobile"));
	            user.setEmail(rs.getString("userEmail"));

	            order.setUser(user);

	            ordersList.add(order);
	        }
	    } catch (SQLException e) {
	        throw new DAOException(LiveOnDaoErrors.INVALID_ORDER_HISTORY, e);
	    }

	    return ordersList;
	}


	
	}
