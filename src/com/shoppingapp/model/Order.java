package com.shoppingapp.model;


import java.sql.Timestamp;
import java.time.Instant;




public class Order {

	private  Long orderNum;
	private String cust_username;
	private String itemName;
	private Long numofItemsBought;
	private Double price;
	private Timestamp orderDate;
	
	public Order() {
		this(1L,"N/A","N/A",1L,0.0, Timestamp.from(Instant.now()));
	}

	public Order(Long orderNum, String cust_username, String itemName, Long numofItemsBought, Double price, Timestamp orderDate) {
		super();
		this.orderNum = orderNum;
		this.cust_username = cust_username;
		this.itemName = itemName;
		this.numofItemsBought = numofItemsBought;
		this.price=price;
		this.orderDate=orderDate;
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	public String getCust_username() {
		return cust_username;
	}

	public void setCust_username(String cust_username) {
		this.cust_username = cust_username;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getNumofItemsBought() {
		return numofItemsBought;
	}

	public void setNumofItemsBought(Long numofItemsBought) {
		this.numofItemsBought = numofItemsBought;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [orderNum=" + orderNum + ", cust_username=" + cust_username + ", itemName=" + itemName
				+ ", numofItemsBought=" + numofItemsBought + ", price=" + price + ", orderDate=" + orderDate + "]";
	}

	
		
}
