package com.shoppingapp.dao;

import java.sql.Connection;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.shoppingapp.connection.ConnectionManager;

import com.shoppingapp.model.Order;

public class OrderDAOImp implements OrderDAO {
	
	private Connection conn = ConnectionManager.getConnection();
	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
List<Order> order = new ArrayList<Order>();
		
		try(Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from orders"); ){
			
			while(rs.next()) {
				Long orderNum = rs.getLong(1);
				String cust_username = rs.getString(2);
				String itemName = rs.getString(3);
				Long NumBought=rs.getLong(4);
				Double OrderPrice=rs.getDouble(5);
				Timestamp orderDate=rs.getTimestamp(6);
			
				// add to list
				Order neworder = new Order(orderNum, cust_username, itemName, NumBought, OrderPrice, orderDate);
				order.add(neworder);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return order;
	
	}
	
	

	@Override
	public Order getOrderByUserName(String username) {
		// TODO Auto-generated method stub
		   Order order = null;
			
			try(PreparedStatement pstmt = conn.prepareStatement("select * from orders where cust_username = ?")) {
				
				pstmt.setString(1, username);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					Long orderNum = rs.getLong(1);
					String cust_username = rs.getString(2);
					String itemName = rs.getString(3);
					Long NumBought=rs.getLong(4);
					Double OrderPrice=rs.getDouble(5);
					Timestamp orderDate=rs.getTimestamp(6);
					
				
					
				  order = new Order(orderNum, cust_username, itemName, NumBought, OrderPrice, orderDate);
					
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			return order;
	
	}

	@Override
	public Order getOrderByDate(Timestamp date) {
		// TODO Auto-generated method stub
		 Order order = null;
	
			
			
			
			try(PreparedStatement pstmt = conn.prepareStatement("select * from orders where OrderDate = ?")) {
				
				pstmt.setTimestamp(1, date);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					Long orderNum = rs.getLong(1);
					String cust_username = rs.getString(2);
					String itemName = rs.getString(3);
					Long NumBought=rs.getLong(4);
					Double OrderPrice=rs.getDouble(5);
					Timestamp orderDate=rs.getTimestamp(6);
					
				
					
				  order = new Order(orderNum, cust_username, itemName, NumBought, OrderPrice, orderDate);
					
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			return order;
	
		
	
	}

	@Override
	public Order getOrderByName(String name) {
		// TODO Auto-generated method stub
		Order order = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("select * from orders where itemName = ?")) {
			
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Long orderNum = rs.getLong(1);
				String cust_username = rs.getString(2);
				String itemName = rs.getString(3);
				Long NumBought=rs.getLong(4);
				Double OrderPrice=rs.getDouble(5);
				Timestamp orderDate=rs.getTimestamp(6);
				
			
				
			  order = new Order(orderNum, cust_username, itemName, NumBought, OrderPrice, orderDate);
				
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return order;

	
	}



	@Override
	public boolean addOrder(Order order) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into orders values(?,?,?,?,?,?)");
			
			
			pstmt.setLong(1, order.getOrderNum());
			pstmt.setNString(2, order.getCust_username());
			pstmt.setString(3, order.getItemName());
			pstmt.setLong(4, order.getNumofItemsBought());
			pstmt.setDouble(5, order.getPrice());
			pstmt.setTimestamp(6, order.getOrderDate());

			
			int insert = pstmt.executeUpdate();
			
			if(insert > 0) {
				return true;
			}
			
			pstmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	
	
	}

}
