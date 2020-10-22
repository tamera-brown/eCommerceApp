package com.shoppingapp.model;

public class Customer {
	
	private String UserID;
	private String name;
	private String password;
	private String email;
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
		this("N/A","N/A","N/A","N/A");
	}


	public Customer(String userID, String name, String password, String email) {
		super();
		UserID = userID;
		this.name = name;
		this.password = password;
		this.email = email;
	}


	public String getUserID() {
		return UserID;
	}


	public void setUserID(String userID) {
		UserID = userID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Customer [UserID=" + UserID + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}


}