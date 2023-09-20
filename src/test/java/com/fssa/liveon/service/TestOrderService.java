package com.fssa.liveon.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.Orders;
import com.fssa.liveon.util.Logger;

public class TestOrderService {
	
	static Logger logger = new Logger();
	
	OrderService orderDetails = new OrderService();
	
	public Orders getValidOrder() {
		Orders order = new Orders(1,1,"123 Main St","City","600001","Credit Card");
		return order;
	}
	
	
	@Test
	void testPlaceOrder() throws DAOException, SQLException{
		Orders o = getValidOrder();
		Assertions.assertTrue(orderDetails.placeOrder(o));
	}
	
	@Test
	void testOrdersByUserId()throws DAOException, SQLException{
		Orders o = getValidOrder();
		List<Orders> orderlist = orderDetails.getOrdersByUserId();
		for(Orders p :orderlist) {
			Logger.info(p);
		}
	}
}
