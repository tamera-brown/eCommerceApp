package com.shoppingapp.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.shoppingapp.application.eCommerceShoppingApplication;
import com.shoppingapp.dao.*;
import com.shoppingapp.model.*;

import com.shoppingapp.utility.ColorsUtility.Colors;



public class CustomerService {


	public static final CustomerDAO customerdao = new CustomerDAOImp();
	public static final ItemsDAO itemdao = new ItemsDAOImp();
	public static final OrderDAO orderdao = new OrderDAOImp();
	
	
	 static Items item1;
	 static Items item2;
	 static Items item3;
	 static Items item4;
	 static Items item5;
	 
	
	 static String userId;
	static Timestamp today=Timestamp.from(Instant.now()); 
	 
	 
	 public static void Register(Scanner info) {
			
	
	
	info= new Scanner(System.in);

	 Pattern emailRegex =Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	 Pattern passwordRegex = Pattern.compile("(?=.*[a-z])(?=.*[@#$%!^&])(?=.*[A-Z]).{8}");
	 
	 String name;
	String email;
	 String password;
	 boolean validemail;
	 boolean validpassword;
	 
	 System.out.println("User ID: "+Colors.ANSI_CYAN.getColor());
	 userId=info.nextLine();
	 
	 Customer usernameCheck = customerdao.getCustomerByUserId(userId);
	 if(usernameCheck!=null) {
		 System.out.println(Colors.ANSI_RED.getColor()+"Username aleady taken" + Colors.ANSI_RESET.getColor());
		 System.out.println("User ID: "+Colors.ANSI_CYAN.getColor());
		 userId=info.nextLine();
		 
	 }
	 System.out.println(Colors.ANSI_RESET.getColor()+"Name: "+Colors.ANSI_CYAN.getColor());
	 
	 name=info.nextLine();
	// System.out.println(name);
	 
	 System.out.println(Colors.ANSI_RESET.getColor()+"Email: "+Colors.ANSI_CYAN.getColor());
	 email=info.next();
	 Customer emailCheck = customerdao.getCustomerByEmail(email);
	 		 if(emailCheck!=null) {
	 			 System.out.println(Colors.ANSI_RED.getColor()+"There is an account already associated with that email" + Colors.ANSI_RESET.getColor());
	 			 System.out.println("Email: "+Colors.ANSI_CYAN.getColor());
	 			 email=info.next();
	 		 }
	 Matcher emailMatcher=emailRegex.matcher(email);
    validemail=emailMatcher.matches();
    
    while(validemail==false) {
   	 System.out.println(Colors.ANSI_RED.getColor()+"Invalid Email. Try again"+Colors.ANSI_RESET.getColor());
   	 System.out.println("Email"+Colors.ANSI_CYAN.getColor());
        email = info.next();
        emailMatcher= emailRegex.matcher(email);
        validemail= emailMatcher.matches();
    }
  
    System.out.println(Colors.ANSI_RESET.getColor()+"Password: "+Colors.ANSI_CYAN.getColor());
	 password=info.next();
	 
	 Customer passwordCheck = customerdao.getCustomerByPassword(password);
	 while(passwordCheck!=null) {
		 System.out.println(Colors.ANSI_RED.getColor()+"Password aleady taken" + Colors.ANSI_RESET.getColor());
		  System.out.println("Password: "+Colors.ANSI_CYAN.getColor());
			 password=info.next();
	 }
	 
	 Matcher passwordMatcher=passwordRegex.matcher(password);
    validpassword=passwordMatcher.matches();
    
    while(validpassword==false) {
   	 System.out.println(Colors.ANSI_RED.getColor()+"Invalid Password. Try again"+Colors.ANSI_RESET.getColor());
   	 System.out.println("Password"+Colors.ANSI_CYAN.getColor());
        password = info.next();
        passwordMatcher= passwordRegex.matcher(password);
        validpassword= passwordMatcher.matches();
    }
    
	 		 
    Customer newCustomer = new Customer(userId, name, password, email);
	customerdao.addCustomer(newCustomer);
	
    System.out.println(Colors.ANSI_PURPLE.getColor()+"Registered!!"+Colors.ANSI_RESET.getColor());
    
    eCommerceShoppingApplication.Menu(info);
    info.close();
}
public static void Login(Scanner info) {
 info = new Scanner(System.in);
   
    String password;
    System.out.println(Colors.ANSI_RESET.getColor()+"User ID: " + Colors.ANSI_CYAN.getColor());
    
        userId = info.nextLine();
        Customer found = customerdao.getCustomerByUserId(userId);
        while(found!=null) {
    
    System.out.println(Colors.ANSI_RESET.getColor()+"Password: "+Colors.ANSI_CYAN.getColor());
   
        password = info.nextLine();
        
        if(password.equals(found.getPassword())) {
     
        System.out.println(Colors.ANSI_PURPLE.getColor()+"Login Success"+ Colors.ANSI_RESET.getColor());
    	eCommerceShoppingApplication.Menu(info);
        }
        else {
        	 System.out.println(Colors.ANSI_RED.getColor()+"Invalid Username or Password. Try again!");
             Login(info);
        }
    
        
    
   // info.close();
   
	
        }
}
public static void addInventory() {
	
    item1 = new Items("Jeans","Jn", 15.00, 15L);
	item2 = new Items("Shirts","Shi", 20.00, 15L);
	item3 = new Items("Hats","Hat", 5.00, 15L);
	item4 = new Items("Sneakers","sneak", 40.00, 15L);
	item5 = new Items("Hoodies","Hood", 50.00, 15L);
	


}
        
public static void BuyItem() {
	
		
	System.out.println("        Store Inventory    ");
	System.out.println("+==============================+");
	System.out.println(Colors.ANSI_BOLD.getColor()+"  Items   Item Code   Price     "+Colors.ANSI_RESET.getColor());
	
	System.out.println("  "+   item1.getItemname()+"     " + item1.getItemcode() +"        $" + item1.getPrice()                               );
	System.out.println("  "+   item2.getItemname() +"     " + item2.getItemcode() +"        $" + item2.getPrice()                               );
	System.out.println("  "+   item3.getItemname() +"     " + item3.getItemcode() +"        $" + item3.getPrice()                               );
	System.out.println("  "+   item4.getItemname() +"     " + item4.getItemcode() +"        $" + item4.getPrice()                               );
	System.out.println("  "+   item5.getItemname() +"     " + item5.getItemcode() +"        $" + item5.getPrice()                               );
	
	System.out.println("+==============================+");
	System.out.println("What would you like to buy? ");
	
	
	Scanner buyItem=new Scanner(System.in);
	String purchase;
	Double totalPrice=0.0;
	Long quantitynum;
	Long counter;
	today=new Timestamp(today.getTime());
	
	purchase=buyItem.nextLine();
	Items ItemCheck = itemdao.getItemByName(purchase);
	while(ItemCheck==null) {
		System.out.println(Colors.ANSI_RED.getColor()+"The store doesn't have that item"+Colors.ANSI_RESET.getColor());
		System.out.println("What would you like to buy? ");
		purchase=buyItem.nextLine();
		
	}
	switch (purchase) {
	case "Jeans":
	     counter= item1.getQuantity();
		System.out.println("How many would you like to buy");
		 quantitynum=buyItem.nextLong();
		item1.setQuantity(counter-quantitynum);
		System.out.println(item1.getQuantity());
		totalPrice+=(item1.getPrice() * quantitynum);
		System.out.println("totalPrice: $ "+totalPrice);
		
		Order newOrder= new Order(1L, userId, item1.getItemname(), quantitynum,totalPrice, today);
		orderdao.addOrder(newOrder);
		itemdao.getItemByCode(item1.getItemcode()).setQuantity(item1.getQuantity()-quantitynum);
		
		break;
	case "Shirts":
		counter= item2.getQuantity();
		System.out.println("How many would you like to buy");
		quantitynum=buyItem.nextLong();
		item2.setQuantity(counter-quantitynum);
		System.out.println(item2.getQuantity());
		totalPrice+=(item2.getPrice() * quantitynum);
		System.out.println("totalPrice: $ "+totalPrice);
		
		Order newOrder1= new Order(1L, userId, item2.getItemname(), quantitynum,totalPrice, today);
		orderdao.addOrder(newOrder1);
		itemdao.getItemByCode(item1.getItemcode()).setQuantity(item2.getQuantity()-quantitynum);
		break;
	case "Hats":
		counter= item3.getQuantity();
		System.out.println("How many would you like to buy");
		quantitynum=buyItem.nextLong();
		item3.setQuantity(counter-quantitynum);
		System.out.println(item3.getQuantity());
		totalPrice+=(item3.getPrice() * quantitynum);
		System.out.println("totalPrice: $ "+totalPrice);
		Order newOrder2= new Order(1L, userId, item3.getItemname(), quantitynum,totalPrice, today);
		orderdao.addOrder(newOrder2);
		itemdao.getItemByCode(item1.getItemcode()).setQuantity(item3.getQuantity()-quantitynum);
		break;
	case "Sneakers":
		counter= item4.getQuantity();
		System.out.println("How many would you like to buy");
		quantitynum=buyItem.nextLong();
		item4.setQuantity(counter-quantitynum);
		System.out.println(item4.getQuantity());
		totalPrice+=(item4.getPrice() * quantitynum);
		System.out.println("totalPrice: $ "+totalPrice);
		Order newOrder3= new Order(1L,userId, item4.getItemname(), quantitynum,totalPrice, today);
		orderdao.addOrder(newOrder3);
		itemdao.getItemByCode(item1.getItemcode()).setQuantity(item4.getQuantity()-quantitynum);
		break;
	case "Hoodies":
		counter= item5.getQuantity();
		System.out.println("How many would you like to buy");
		quantitynum=buyItem.nextLong();
		item5.setQuantity(counter-quantitynum);
		System.out.println(item5.getQuantity());
		totalPrice+=(item5.getPrice() * quantitynum);
		Order newOrder4= new Order(1L, userId, item5.getItemname(), quantitynum,totalPrice, today);
		orderdao.addOrder(newOrder4);
		itemdao.getItemByCode(item1.getItemcode()).setQuantity(item5.getQuantity()-quantitynum);
		break;
}
	System.out.println("Would you like to buy another item? ");
	char option;
	option=buyItem.next().charAt(0);
	if(option=='Y' || option=='y') {
		
		BuyItem();
	}
	else if(option=='N'|| option=='n') {
		
	String cust_email= customerdao.getCustomerByUserId(userId).getEmail();
	 
		System.out.println("Sending your invoice to "+ cust_email);

		System.out.println(Colors.ANSI_BOLD.getColor()+"Here is your reciept"+Colors.ANSI_RESET.getColor());
		System.out.println(LocalDate.now());
		System.out.println(orderdao.getOrderByUserName(userId));
		System.out.println(Colors.ANSI_GREEN.getColor()+"Total Price: $ "+totalPrice+Colors.ANSI_RESET.getColor());

		eCommerceShoppingApplication.Menu(buyItem);
}

}
public static void ReplaceItem() {
	
	Timestamp cust_orderDate=orderdao.getOrderByUserName(userId).getOrderDate();
	

	 Timestamp invoiceDate = new Timestamp(cust_orderDate.getTime());
	 
	 Calendar cal = Calendar.getInstance();
	    cal.setTimeInMillis(invoiceDate.getTime());
	   
	    cal.add(Calendar.DAY_OF_MONTH, 15);
	    invoiceDate= new Timestamp(cal.getTime().getTime());
	    
	  
	  today=new Timestamp(today.getTime());
	 
	  
	 
	
	int invoiceNum = 0;
	int counter;
	Scanner replaceItem =new Scanner(System.in);
	String replace;
	String cust_name= customerdao.getCustomerByUserId(userId).getName();
	System.out.println(Colors.ANSI_BOLD.getColor()+"Invoice"+Colors.ANSI_RESET.getColor());
	
	System.out.println("Customer Name: "+ cust_name + "     Date: " + invoiceDate);
	counter=(++invoiceNum);
	
	System.out.println("Invoice No: "+ counter);
	
	
	
	Order customerorder=orderdao.getOrderByUserName(userId);
	System.out.println(customerorder);
	
	 if(today==invoiceDate){
		System.out.println("Cannot replace item at this time");
		eCommerceShoppingApplication.Menu(replaceItem);
	}
	 
	 System.out.print("What item would you like to replace? ");
		replace=replaceItem.nextLine();
		Order replaceCheck=orderdao.getOrderByName(replace);
		if(replaceCheck==null && customerorder!=null) {
			System.out.print(Colors.ANSI_RED.getColor()+"You cannot replace an item you didn't buy"+Colors.ANSI_RESET.getColor()+'\n');
			eCommerceShoppingApplication.Menu(replaceItem);
		}
		else {
			System.out.print("How many "+ replace + " would you like to replace ");
			Long replaceNum=replaceItem.nextLong();
			
		}
		 
	
}
}






