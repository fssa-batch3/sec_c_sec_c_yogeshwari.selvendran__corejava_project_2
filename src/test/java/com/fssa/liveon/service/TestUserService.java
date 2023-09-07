package com.fssa.liveon.service;

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
		User u = new User("Parama","A","Female","parama@gmail.com",7449294567l,"Parama@123");
		return u;
	}
	public User getValidUser2() {
		User u = new User(4,"Yogii","S","Male","menuuudon@gmail.com",9276143219l,"Yogi@123");
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
void testGetUserByEmail() throws DAOException, SQLException{
User u=	user.getUserByEmail("heldon@gmail.com","yjYdcv@123" );
logger.info(u);
}
}
