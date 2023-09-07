package com.fssa.liveon.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;
import com.fssa.liveon.exceptions.InvalidUserDetailsException;
import com.fssa.liveon.model.User;
import com.fssa.liveon.util.ConnectionUtil;

public class UserDAO {
	public String hashPassword(String password) throws InvalidUserDetailsException {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

			StringBuilder hashsb = new StringBuilder();
			for (byte b : hashBytes) {
				hashsb.append(String.format("%02x", b));
			}

			return hashsb.toString();
		} catch (NoSuchAlgorithmException e) {

			throw new InvalidUserDetailsException(e.getMessage());

		}
	}
	public boolean addUserDetails(User user) throws DAOException, SQLException {
		String selectQuery = "INSERT INTO USER (firstname, lastname, gender, mobile, email, password) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {
				preparedStatement.setString(1, user.getFirstName());
				preparedStatement.setString(2, user.getLastName());
				preparedStatement.setString(3, user.getGender());
				preparedStatement.setLong(4, user.getNumber());
				preparedStatement.setString(5, user.getEmail());
				preparedStatement.setString(6, hashPassword(user.getPassword()));
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {

			throw new DAOException(LiveOnDaoErrors.INVALID_ADD_USER);
		}
		return true;
	}
	public boolean updateUserDetails(User user) throws DAOException, SQLException {
		if (user.getUserId() <= 0) {
			throw new InvalidUserDetailsException(LiveOnDaoErrors.INVALID_ID);
		}
		String updateQuery = "UPDATE USER SET firstname=?, lastname=?, gender=?, mobile=? WHERE id=?";
		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement preparedStatement = con.prepareStatement(updateQuery)) {

				preparedStatement.setString(1, user.getFirstName());
				preparedStatement.setString(2, user.getLastName());
				preparedStatement.setString(3, user.getGender());
				preparedStatement.setLong(4, user.getNumber());
				preparedStatement.setInt(5, user.getUserId());
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {

			throw new DAOException(LiveOnDaoErrors.INVALID_UPDATE_USER);
		}
		return true;
	}
	public boolean deleteUserDetails(int userId) throws DAOException, SQLException {
		if (userId <= 0) {
			throw new InvalidSparePartDetailsException(LiveOnDaoErrors.INVALID_ID);
		}
		String deleteQuery = "UPDATE USER SET status = 0 WHERE id=?";
		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
				preparedStatement.setInt(1, userId);
				preparedStatement.execute();
			}
		} catch (SQLException e) {

			throw new DAOException(LiveOnDaoErrors.INVALID_DELETE_USER);
		}
		return true;
	}
	public User getUserByEmailAndPassword(String email, String enteredPassword) throws SQLException, DAOException {
		User user = null;
	    String query = "SELECT * FROM USER WHERE email = ?";
	    
	    try (Connection con = ConnectionUtil.getConnection()) {
	        try (PreparedStatement pst = con.prepareStatement(query)) {
	            pst.setString(1, email);
	            
	            try (ResultSet rs = pst.executeQuery()) {
	                if (rs.next()) {
	                    String storedHashedPassword = rs.getString("password");
	                  
	                    String enteredHashedPassword = hashPassword(enteredPassword);
	                  
	                    if (storedHashedPassword.equals(enteredHashedPassword)) {
	                   user = new User();
	                    	user.setUserId(rs.getInt("id"));
	                    	user.setEmail(rs.getString("email"));
	                    	user.setPassword(rs.getString("password"));
	                       
	                    } else {
	                        throw new DAOException(LiveOnDaoErrors.INVALID_DELETE_USER);
	                    }
	                } else {
	                    throw new DAOException(LiveOnDaoErrors.INVALID_DELETE_USER);
	                }
	            }
	        }
	    } catch (SQLException e) {
	      
	        e.printStackTrace();
	        
	        throw new DAOException(LiveOnDaoErrors.INVALID_DELETE_USER);
	    }
	    
	    return user;
	}
}