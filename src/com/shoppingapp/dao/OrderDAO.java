package com.shoppingapp.dao;

import java.sql.Timestamp;

import java.util.List;

import com.shoppingapp.model.Order;

public interface OrderDAO {

	public List<Order> getAllOrders();
	
	public Order getOrderByUserName(String username);
	
	public Order getOrderByDate(Timestamp date);
	
	public Order getOrderByName(String Name);
	
	public boolean addOrder(Order order);

	
	
}
