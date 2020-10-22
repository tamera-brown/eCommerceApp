package com.shoppingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shoppingapp.connection.ConnectionManager;
import com.shoppingapp.model.Customer;

public class CustomerDAOImp implements CustomerDAO {
	
	private Connection conn = ConnectionManager.getConnection();
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers = new ArrayList<Customer>();
		
		try(Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from customers"); ){
			
			while(rs.next()) {
				String userId = rs.getString(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String email=rs.getNString(4);
			
				// add to list
				Customer customer = new Customer(userId, name,password, email);
				customers.add(customer);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return customers;
	
	}

	@Override
	public Customer getCustomerByUserId(String userId) {
		// TODO Auto-generated method stub
             Customer customer = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("select * from customers where user_id = ?")) {
			
			pstmt.setString(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String userId1 = rs.getString(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String email=rs.getNString(4);
				
				
				customer = new Customer(userId1, name, password,email);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return customer;
	
	}

	@Override
	public Customer getCustomerByPassword(String password) {
		// TODO Auto-generated method stub
       Customer customer = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("select * from customers where password = ?")) {
			
			pstmt.setString(1, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String userId = rs.getString(1);
				String name = rs.getString(2);
				String password1 = rs.getString(3);
				String email=rs.getNString(4);
				
				
				customer = new Customer(userId, name,password1,email);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	
	}

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into customers values(?,?,?,?)");
			
			pstmt.setString(1, customer.getUserID());
			pstmt.setString(2, customer.getName());
			pstmt.setString(3, customer.getPassword());
			pstmt.setNString(4, customer.getEmail());
			
			
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
@Override
public Customer getCustomerByEmail(String email){
	 Customer customer = null;
	 
	 try(PreparedStatement pstmt = conn.prepareStatement("select * from customers where email = ?")) {
			
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String userId1 = rs.getString(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String email1=rs.getNString(4);
				
				
				customer = new Customer(userId1, name, password,email1);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	
	return customer;
	
}
}
