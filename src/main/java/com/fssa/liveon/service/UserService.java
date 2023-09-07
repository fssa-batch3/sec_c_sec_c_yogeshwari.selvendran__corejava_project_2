package com.fssa.liveon.service;

import java.sql.SQLException;

import com.fssa.liveon.dao.UserDAO;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.User;
import com.fssa.liveon.validator.UserValidation;

public class UserService {
UserDAO userDao = new UserDAO();
UserValidation userValidation = new UserValidation();
public boolean addUser(User user)throws DAOException, SQLException{
	if(userValidation.validateUser(user)) {
		userDao. addUserDetails(user);
	}
	return true;
	
}
public boolean updateUser(User user)throws DAOException, SQLException{
	if(userValidation.validateUser(user)) {
		userDao.updateUserDetails(user);
	}
	return true;
}
public boolean deleteUser(int user)throws DAOException, SQLException{
	if(userValidation.validId(user)) {
		userDao.deleteUserDetails(1);
	}
	return true;
}
public User getUserByEmail(String email, String enteredPassword)throws DAOException, SQLException{
	return userDao.getUserByEmailAndPassword(email, enteredPassword);
}
}
