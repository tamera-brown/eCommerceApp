package com.shoppingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shoppingapp.connection.ConnectionManager;

import com.shoppingapp.model.Items;

public class ItemsDAOImp implements ItemsDAO {
	
	private Connection conn = ConnectionManager.getConnection();
	@Override
	public List<Items> getAllItems() {
		// TODO Auto-generated method stub
	List<Items> items = new ArrayList<Items>();
		
		try(Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from inventory"); ){
			
			while(rs.next()) {
				String itemname = rs.getString(1);
				String itemcode = rs.getString(2);
				Double price = rs.getDouble(3);
				Long quantity=rs.getLong(4);
			
				// add to list
				Items item = new Items(itemname,itemcode,price,quantity);
				items.add(item);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return items;
	
	}

	@Override
	public Items getItemByName(String name) {
		// TODO Auto-generated method stub
		  Items item = null;
			
			try(PreparedStatement pstmt = conn.prepareStatement("select * from inventory where itemname = ?")) {
				
				pstmt.setString(1, name);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String itemname = rs.getString(1);
					String itemcode = rs.getString(2);
					Double price = rs.getDouble(3);
					Long quantity=rs.getLong(4);
					
					
					item = new Items(itemname,itemcode,price,quantity);
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			return item;
		
	
	}

	@Override
	public Items getItemByCode(String itemcode) {
		// TODO Auto-generated method stub
		 Items item = null;
			
			try(PreparedStatement pstmt = conn.prepareStatement("select * from inventory where itemcode = ?")) {
				
				pstmt.setString(1, itemcode);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String itemname = rs.getString(1);
					String itemcode1 = rs.getString(2);
					Double price = rs.getDouble(3);
					Long quantity=rs.getLong(4);
					
					
					item = new Items(itemname,itemcode1,price,quantity);
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			return item;
		
	
	}
	public boolean addItems(Items item) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into inventory values(?,?,?,?)");
			
			pstmt.setString(1, item.getItemname());
			pstmt.setString(2, item.getItemcode());
			pstmt.setDouble(3, item.getPrice());
			pstmt.setLong(4, item.getQuantity());
			
			
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
