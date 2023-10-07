package com.fssa.liveon.service;

import java.sql.SQLException;

import com.fssa.liveon.dao.UserDAO;
import com.fssa.liveon.enums.LoginStatus;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.exceptions.InvalidUserDetailsException;
import com.fssa.liveon.model.User;
import com.fssa.liveon.validator.UserValidation;

public class UserService {
UserDAO userDao = new UserDAO();
UserValidation userValidation = new UserValidation();
public boolean addUser(User user)throws DAOException, SQLException, InvalidUserDetailsException{
	if(userValidation.validateUser(user) && !userDao.getUserEmail(user.getEmail())  ) {
		userDao. addUserDetails(user);
	}
	return true;
	
}
public boolean updateUser(User user)throws DAOException, SQLException,InvalidUserDetailsException{
	if(userValidation.validateUserUpdate(user)) {
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

public User getUserById(int id) throws SQLException, DAOException {
	return userDao.getUserById(id);
}

public User getUserByEmailAndPassword(String email, String enteredPassword)throws DAOException, SQLException,InvalidUserDetailsException{

	return userDao.getUserByEmailAndPassword(email,enteredPassword);

}
public  boolean validateUserEmail(String email) throws SQLException, DAOException,InvalidUserDetailsException{
	boolean userExists =  userDao.getUserEmail(email);
	if(userExists) {
		return true;
	}
	return false;
}
public LoginStatus login(String email, String password) throws SQLException, DAOException,InvalidUserDetailsException {
    // Check if the user with the provided email exists
    boolean exists = validateUserEmail(email);

    if (exists) {
        // If the user exists, validate the login credentials
        boolean isValidLogin = userDao.validateLogin(email, password);

        if (isValidLogin) {
            // Login credentials are valid
            return LoginStatus.SUCCESS;
        } else {
            // Password is incorrect
            return LoginStatus.INCORRECT_PASSWORD;
        }
    } else {
        // User with the provided email not found
        return LoginStatus.USER_NOT_FOUND;
    }
}
}
