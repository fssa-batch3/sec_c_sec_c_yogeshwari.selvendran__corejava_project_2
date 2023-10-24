package com.fssa.liveon.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.exceptions.InvalidPartnerDetailsException;
import com.fssa.liveon.exceptions.InvalidUserDetailsException;
import com.fssa.liveon.model.Partners;
import com.fssa.liveon.util.ConnectionUtil;

public class PartnerDAO {
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
			throw new InvalidPartnerDetailsException(e.getMessage());
		}
	}

	public boolean addPartnerDetails(Partners partner) throws DAOException, SQLException {
		String selectQuery = "INSERT INTO Partners (firstName, lastName, gender, number, email, password) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {
				preparedStatement.setString(1, partner.getFirstName());
				preparedStatement.setString(2, partner.getLastName());
				preparedStatement.setString(3, partner.getGender());
				preparedStatement.setLong(4, partner.getNumber());
				preparedStatement.setString(5, partner.getEmail());
				preparedStatement.setString(6, hashPassword(partner.getPassword()));
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {

			throw new DAOException(LiveOnDaoErrors.EMAIL_ALREADY_EXISTS);
		}
		return true;
	}

	public boolean updatePartnerDetails(Partners partner) throws DAOException, SQLException {
		if (partner.getPartnerId() <= 0) {
			throw new InvalidUserDetailsException(LiveOnDaoErrors.INVALID_ID);
		}
		String updateQuery = "UPDATE Partners " + "SET firstName = ?, lastName = ?, gender = ?, number = ? "
				+ "WHERE partnerId = ?";
		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement preparedStatement = con.prepareStatement(updateQuery)) {
				preparedStatement.setString(1, partner.getFirstName());
				preparedStatement.setString(2, partner.getLastName());
				preparedStatement.setString(3, partner.getGender());
				preparedStatement.setLong(4, partner.getNumber());
				preparedStatement.setInt(5, partner.getPartnerId());
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			throw new DAOException(LiveOnDaoErrors.INVALID_UPDATE_USER);
		}
		return true;
	}

	public Partners getPartnerByEmailAndPassword(String email, String enteredPassword) throws SQLException, DAOException {
	    Partners partner = null;
	    String query = "SELECT * FROM Partners WHERE email = ?";

	    try (Connection con = ConnectionUtil.getConnection();
	         PreparedStatement pst = con.prepareStatement(query)) {
	        pst.setString(1, email);

	        try (ResultSet rs = pst.executeQuery()) {
	            if (rs.next()) {
	                String storedHashedPassword = rs.getString("password");
	                String enteredHashedPassword = hashPassword(enteredPassword);

	                if (storedHashedPassword.equals(enteredHashedPassword)) {
	                    partner = new Partners();
	                    partner.setPartnerId(rs.getInt("partnerId"));
	                    partner.setEmail(rs.getString("email"));
	                    partner.setPassword(rs.getString("password"));
	                    // Add more attributes as needed
	                } else {
	                    throw new DAOException(LiveOnDaoErrors.INVALID_PASSWORD);
	                }
	            } else {
	                throw new DAOException(LiveOnDaoErrors.EMAIL_NOT_FOUND);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DAOException(LiveOnDaoErrors.DATABASE_ERROR);
	    }

	    return partner;
	}


	public Partners getPartnerById(int id) throws SQLException, DAOException {
		Partners partner = null;
		String query =  "SELECT * FROM Partners WHERE partnerId = ?";

		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setInt(1, id);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						   partner = new Partners();
		                    partner.setPartnerId(rs.getInt("partnerId"));
		                    partner.setFirstName(rs.getString("firstName"));
		                    partner.setLastName(rs.getString("lastName"));
		                    partner.setGender(rs.getString("gender"));
		                    partner.setEmail(rs.getString("email"));
		                    partner.setNumber(rs.getLong("number"));
		                    partner.setPassword(rs.getString("password"));
		                  
					}
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();

			throw new DAOException(LiveOnDaoErrors.INVALID_DELETE_USER);
		}

		return partner;
	}

	public static boolean getPartnerEmail(String email) throws DAOException {
	    try (Connection con = ConnectionUtil.getConnection();
	         PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) as count FROM Partners WHERE email = ?")) {
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
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DAOException(LiveOnDaoErrors.INVALID_ADD_PARTNER);
	    }
	    return true;
	}
	

	public static void main(String[] args) throws SQLException, DAOException {
		PartnerDAO s = new PartnerDAO();
	//	s.getPartnerById(1);
		System.out.print(s.getPartnerById(1));
	}

}
