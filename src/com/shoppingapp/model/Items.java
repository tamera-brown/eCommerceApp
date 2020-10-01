package com.shoppingapp.model;

public class Items {

	private String itemname;
	private String itemcode;
	private Double price;
	private Long quantity;
	
	public Items() {
		this("N/A","N/A",20.00,15L);
	}

	public Items(String itemname, String itemcode, Double price, Long quantity) {
		super();
		this.itemname = itemname;
		this.itemcode = itemcode;
		this.price = price;
		this.quantity = quantity;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemcode() {
		return itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Items [itemname=" + itemname + ", itemcode=" + itemcode + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
	
}
