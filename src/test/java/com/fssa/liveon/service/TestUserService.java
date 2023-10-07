package com.fssa.liveon.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.User;
import com.fssa.liveon.util.Logger;

public class TestUserService {
	static Logger logger = new Logger();
	UserService user = new UserService();
	public User getValidUser() {
		User u = new User("Sandeep","P","male","dandeep@gmail.com",8838381954l,"Sand@123");
		return u;
	}
	public User getValidUser2() {
		User u = new User(4,"Yogii","S",9276143219l);
		return u;
	}
@Test
void  testAddUser() throws DAOException, SQLException{
User u = getValidUser();
Assertions.assertTrue(user.addUser(u));
}
@Test
void  testUpdateUser() throws DAOException, SQLException{
User u = getValidUser2();
Assertions.assertTrue(user.updateUser(u));
}
@Test
void  testDeleteUser() throws DAOException, SQLException{
User u = getValidUser2();
Assertions.assertTrue(user.deleteUser(1));
}

@Test
void testGetUserByEmailAndPass() throws DAOException, SQLException{
	 String email = "yogiYOGI@gmail.com";
	    String password = "YogiS@123";
User u=	user.getUserByEmailAndPassword(email, password );
logger.info(u);
assertNotNull(u);
assertEquals(email, u.getEmail());
}
@Test
void testGetUserByEmail() throws DAOException, SQLException{
User u=	user.getUserById(1);
logger.info(u);
}
}
