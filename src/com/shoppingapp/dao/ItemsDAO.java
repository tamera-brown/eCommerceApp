package com.shoppingapp.dao;

import java.util.List;


import com.shoppingapp.model.Items;



public interface ItemsDAO {

	public List<Items> getAllItems();
	
	public Items getItemByName(String name);
	
	public Items getItemByCode(String itemcode);
	public boolean addItems(Items item);
}
