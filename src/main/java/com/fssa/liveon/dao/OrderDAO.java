package com.fssa.liveon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.Orders;
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

			throw new DAOException(LiveOnDaoErrors.INVALID_ORDER_PLACED);
		}
		return true;
	}

	public Orders getAllOrdersById(int orderId) throws DAOException, SQLException {
		String selectQuery = "SELECT * FROM Orders WHERE orderID = ?";
		Orders orders = null; // Initialize the Orders object outside the try-catch block

		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {
				preparedStatement.setInt(1, orderId);
				try (ResultSet rs = preparedStatement.executeQuery()) {
					if (rs.next()) {
						// Create a new Orders object for the result row
						orders = new Orders();
						// Set the attributes of the Orders object using the ResultSet
						orders.setOrderID(rs.getInt("orderID")); // Assuming you have a method setOrderId
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
			throw new DAOException(LiveOnDaoErrors.INVALID_ALL_SPAREPART);
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
}
