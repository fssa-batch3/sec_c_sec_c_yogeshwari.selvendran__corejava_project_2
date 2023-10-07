package com.fssa.liveon.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.liveon.dao.OrderDAO;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.exceptions.InvalidOrderDetailsException;
import com.fssa.liveon.model.Appointment;
import com.fssa.liveon.model.Orders;
import com.fssa.liveon.validator.OrdersValidation;

public class OrderService {
	OrderDAO orderDao = new OrderDAO();
	OrdersValidation orderValidate = new OrdersValidation();
	
	public boolean placeOrder(Orders order) throws DAOException, SQLException ,InvalidOrderDetailsException {
		if(orderValidate.validateOrderDetails(order)){
			orderDao.placeOrder(order);
		}
		return true;
	}
	
	public List<Orders> getOrdersByUserId(int id) throws DAOException, SQLException {
		return orderDao.getAllOrdersByUserId(id);
	}
	
	public Orders getOrdersById()throws DAOException, SQLException{
		return orderDao.getAllOrdersById(2);
	}
	
	public List<Orders> getAllOrdersForAdmin()throws DAOException, SQLException{
		return orderDao.getAllOrdersForAdmin();
	}
	
}
