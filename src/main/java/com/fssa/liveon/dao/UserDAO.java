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

			throw new DAOException(LiveOnDaoErrors.EMAIL_ALREADY_EXISTS);
		}
		return true;
	}

	public boolean updateUserDetails(User user) throws DAOException, SQLException {
		if (user.getUserId() <= 0) {
			throw new InvalidUserDetailsException(LiveOnDaoErrors.INVALID_ID);
		}
		String updateQuery = "UPDATE USER SET firstname=?, lastname=?, mobile=? WHERE id=?";
		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement preparedStatement = con.prepareStatement(updateQuery)) {
				preparedStatement.setString(1, user.getFirstName());
				preparedStatement.setString(2, user.getLastName());
//				preparedStatement.setString(3, user.getGender());
				preparedStatement.setLong(3, user.getNumber());
				preparedStatement.setInt(4, user.getUserId());
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
	public User getUserById(int id) throws SQLException, DAOException {
		User user = null;
		String query = "SELECT * FROM USER WHERE id = ?";

		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setInt(1, id);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						user = new User();
						user.setUserId(rs.getInt("id"));
						user.setFirstName(rs.getString("firstname"));
						user.setLastName(rs.getString("lastname"));
						user.setEmail(rs.getString("email"));
						user.setPassword(rs.getString("password"));
						user.setGender(rs.getString("gender"));
						user.setNumber(rs.getLong("mobile"));
					}
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();

			throw new DAOException(LiveOnDaoErrors.INVALID_DELETE_USER);
		}

		return user;
	}

	public static boolean getUserEmail(String email) throws SQLException, DAOException {
		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) as count FROM USER WHERE email = ?")) {
				pst.setString(1, email);
				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						int count = rs.getInt("count");
						if (count == 1) {
							throw new DAOException(LiveOnDaoErrors.EMAIL_ALREADY_EXISTS);

						} else {
							return false;
						}

					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// throw new DAOException(LiveOnDaoErrors.INVALID_USER);
		}
		return true;
	}

	// Validate login using email and password
	public static boolean validateLogin(String email, String password) throws SQLException, DAOException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection
					.prepareStatement("SELECT COUNT(*) as count FROM USER WHERE email = ? AND password = ?")) {
				stmt.setString(1, email);
				stmt.setString(2, password);
				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						int count = rs.getInt("count");
						return count > 0;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // Return false if login validation fails
	}

}