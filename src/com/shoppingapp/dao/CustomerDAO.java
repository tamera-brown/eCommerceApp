package com.shoppingapp.dao;

import java.util.List;

import com.shoppingapp.model.Customer;

public interface CustomerDAO {
	
	
    public List<Customer> getAllCustomers();
	
	public Customer getCustomerByUserId(String userId);
	
	public Customer getCustomerByPassword(String password);
	
	public Customer getCustomerByEmail(String email);
	
	public boolean addCustomer(Customer customer);
}
