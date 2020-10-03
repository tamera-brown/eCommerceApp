package com.shoppingapp.service;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.shoppingapp.application.EcommerceShoppingApplication;
import com.shoppingapp.model.Items;
import com.shoppingapp.model.User;
import com.shoppingapp.utility.ColorsUtility.Colors;



public class UserService {
	
	
	 static HashMap<String, User> users = new HashMap<String, User>();
	 static ArrayList<Items> items = new ArrayList<Items>();
	 static Stack<Items> shoppingCart = new Stack<Items>();
      static User newUser;
    
	 
	 static String username;
	 static String name;
	 
	public static void Register(Scanner info) {
		// TODO Auto-generated method stub
		newUser= new User();
		
		info= new Scanner(System.in);

		 Pattern emailRegex =Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		 Pattern passwordRegex = Pattern.compile("(?=.*[a-z])(?=.*[@#$%!^&])(?=.*[A-Z]).{8}");
		 
		
		 String password;
		 boolean validemail;
		 boolean validpassword;
		 
		 System.out.println("Name: "+Colors.ANSI_CYAN.getColor());
		 name=info.nextLine();
		// System.out.println(name);
		 
		 System.out.println(Colors.ANSI_RESET.getColor()+"Email: "+Colors.ANSI_CYAN.getColor());
		 username=info.next();
		 		 
		 Matcher emailMatcher=emailRegex.matcher(username);
        validemail=emailMatcher.matches();
        
        while(validemail==false) {
       	 System.out.println(Colors.ANSI_RED.getColor()+"Invalid Email. Try again"+Colors.ANSI_RESET.getColor());
       	 System.out.println("Email"+Colors.ANSI_CYAN.getColor());
            username = info.next();
            emailMatcher= emailRegex.matcher(username);
            validemail= emailMatcher.matches();
        }
      
        System.out.println(Colors.ANSI_RESET.getColor()+"Password: "+Colors.ANSI_CYAN.getColor());
		 password=info.next();
		 
		 Matcher passwordMatcher=passwordRegex.matcher(password);
        validpassword=passwordMatcher.matches();
        
        while(validpassword==false) {
       	 System.out.println(Colors.ANSI_RED.getColor()+"Invalid Password. Try again"+Colors.ANSI_RESET.getColor());
       	 System.out.println("Password"+Colors.ANSI_CYAN.getColor());
            password = info.next();
            passwordMatcher= passwordRegex.matcher(password);
            validpassword= passwordMatcher.matches();
        }
		 		 
        newUser.setName(name);
        User.setUserID(username);
        newUser.setPassword(password);
        User user = new User(name,password);
        users.put(User.getUserID(), user);
        System.out.println(users);
        //database.addCustomer(customer);
        System.out.println(Colors.ANSI_PURPLE.getColor()+"Registered!!"+Colors.ANSI_RESET.getColor());
        
        EcommerceShoppingApplication.Menu(info);
        info.close();
	}
public static String Login(Scanner info) {
	 info = new Scanner(System.in);
	    //String customerId;
	    String password;
	    System.out.println(Colors.ANSI_RESET.getColor()+"Email: " + Colors.ANSI_CYAN.getColor());
	    
	        username = info.nextLine();
	        
	    
	    System.out.println(Colors.ANSI_RESET.getColor()+"Password: "+Colors.ANSI_CYAN.getColor());
	   
	        password = info.nextLine();
	        
	        User found = users.get(username);
	        
	    System.out.println(username);
	        while(!users.containsKey(username) || !password.equals(found.getPassword()) ) {
	            System.out.println(Colors.ANSI_RED.getColor()+"Invalid Username or Password. Try again!");
	            Login(info);
	        }
	            	 System.out.println(Colors.ANSI_PURPLE.getColor()+"Login Success"+ Colors.ANSI_RESET.getColor());
	            	EcommerceShoppingApplication.Menu(info);
	            

	    info.close();
		return username;
		
	}
public static void BuyItem() {
	

	
	Items item1 = new Items("Jeans","Jn", 15.00, 15L);
	Items item2 = new Items("Shirts","Shi", 20.00, 15L);
	Items item3 = new Items("Hats","Hat", 5.00, 15L);
	Items item4 = new Items("Sneakers","sneak", 40.00, 15L);
	Items item5 = new Items("Hoodies","Hood", 50.00, 15L);
	
	items.add(item1);
	items.add(item2);
	items.add(item3);
	items.add(item4);
	items.add(item5);

	long counter;
	Double totalPrice =0.00;
	int quantitynum;

	System.out.println("        Store Inventory    ");
	System.out.println("+==============================+");
	System.out.println(Colors.ANSI_BOLD.getColor()+"  Items   Item Code   Price     "+Colors.ANSI_RESET.getColor());
	
	System.out.println("  "+   item1.getItemname() +"     " + item1.getItemcode() +"        $" + item1.getPrice()                               );
	System.out.println("  "+   item2.getItemname() +"     " + item2.getItemcode() +"        $" + item2.getPrice()                               );
	System.out.println("  "+   item3.getItemname() +"     " + item3.getItemcode() +"        $" + item3.getPrice()                               );
	System.out.println("  "+   item4.getItemname() +"     " + item4.getItemcode() +"        $" + item4.getPrice()                               );
	System.out.println("  "+   item5.getItemname() +"     " + item5.getItemcode() +"        $" + item5.getPrice()                               );
	
	System.out.println("+==============================+");
	System.out.println("What would you like to buy? ");

	
	Scanner buyItem=new Scanner(System.in);
	String purchase;
	purchase=buyItem.nextLine();
	
	
	switch (purchase) {
	case "Jeans":
		counter= item1.getQuantity();
		System.out.println("How many would you like to buy");
		quantitynum=buyItem.nextInt();
		item1.setQuantity(counter-quantitynum);
		System.out.println(item1.getQuantity());
		totalPrice+=(item1.getPrice() * quantitynum);
		System.out.println("totalPrice:$"+totalPrice);
		for(int i=0;i<quantitynum;i++) {
			shoppingCart.push(item1);
		}
		break;
	case "Shirts":
		counter= item2.getQuantity();
		System.out.println("How many would you like to buy");
		quantitynum=buyItem.nextInt();
		item2.setQuantity(counter-quantitynum);
		System.out.println(item2.getQuantity());
		totalPrice+=(item2.getPrice() * quantitynum);
		System.out.println("totalPrice:$"+totalPrice);
		for(int i=0;i<quantitynum;i++) {
			shoppingCart.push(item2);
		}
		break;
	case "Hats":
		counter= item3.getQuantity();
		System.out.println("How many would you like to buy");
		quantitynum=buyItem.nextInt();
		item3.setQuantity(counter-quantitynum);
		System.out.println(item3.getQuantity());
		totalPrice+=(item3.getPrice() * quantitynum);
		System.out.println("totalPrice:$"+totalPrice);
		for(int i=0;i<quantitynum;i++) {
			shoppingCart.push(item3);
		}
		break;
	case "Sneakers":
		counter= item4.getQuantity();
		System.out.println("How many would you like to buy");
		quantitynum=buyItem.nextInt();
		item4.setQuantity(counter-quantitynum);
		System.out.println(item4.getQuantity());
		totalPrice+=(item4.getPrice() * quantitynum);
		System.out.println("totalPrice:$"+totalPrice);
		for(int i=0;i<quantitynum;i++) {
			shoppingCart.push(item4);
		}
		break;
	case "Hoodies":
		counter= item5.getQuantity();
		System.out.println("How many would you like to buy");
		quantitynum=buyItem.nextInt();
		item5.setQuantity(counter-quantitynum);
		System.out.println(item5.getQuantity());
		totalPrice+=(item5.getPrice() * quantitynum);
		System.out.println("totalPrice:$"+totalPrice);
		for(int i=0;i<quantitynum;i++) {
			shoppingCart.push(item5);
		}
		break;
		default:
			System.out.println("The store doesn't have that item");
			BuyItem();
	}
	
	System.out.println("Would you like to buy another item? ");
		char option;
		option=buyItem.next().charAt(0);
		if(option=='Y' || option=='y') {
			
			BuyItem();
		}
		else if(option=='N'|| option=='n') {
			
		
		 
			System.out.println("Sending your invoice to "+ username);

			System.out.println(Colors.ANSI_BOLD.getColor()+"Here is your reciept"+Colors.ANSI_RESET.getColor());
			System.out.println(new Date());
			System.out.println(shoppingCart);
			System.out.println(Colors.ANSI_GREEN.getColor()+"Total Price: $ "+totalPrice+Colors.ANSI_RESET.getColor());

			EcommerceShoppingApplication.Menu(buyItem);
		 
		}
		else {
			System.out.println("Invalid option");
			
		}
	}
public static void ReplaceItem() {
	
	LocalDate today=LocalDate.now();
	LocalDate invoiceDate;
	int invoiceNum = 0;
	int counter;
	Scanner replaceItem =new Scanner(System.in);
	String replace;
		
	System.out.println(Colors.ANSI_BOLD.getColor()+"Invoice"+Colors.ANSI_RESET.getColor());
	invoiceDate=LocalDate.now().plusDays(15);
	System.out.println("Customer Name: "+ name + "     Date: " + invoiceDate);
	counter=(++invoiceNum);
	
	System.out.println("Invoice No: "+ invoiceNum);
	
	
	
	
	System.out.println(shoppingCart);
	System.out.print("What item would you like to replace? ");
	replace=replaceItem.nextLine();
	
	 if(today!=invoiceDate){
		System.out.println("Cannot replace item at this time");
		EcommerceShoppingApplication.Menu(replaceItem);
	}
	

	
	}
}

