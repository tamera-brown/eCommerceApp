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
	static long counter;
	static int quantitynum;
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
		 
		 System.out.println("Name: ");
		 name=info.nextLine();
		// System.out.println(name);
		 
		 System.out.println("Email: ");
		 username=info.next();
		 		 
		 Matcher emailMatcher=emailRegex.matcher(username);
        validemail=emailMatcher.matches();
        
        while(validemail==false) {
       	 System.out.println("Invalid Email. Try again");
       	 System.out.println("Email");
            username = info.next();
            emailMatcher= emailRegex.matcher(username);
            validemail= emailMatcher.matches();
        }
      
        System.out.println("Password: ");
		 password=info.next();
		 
		 Matcher passwordMatcher=passwordRegex.matcher(password);
        validpassword=passwordMatcher.matches();
        
        while(validpassword==false) {
       	 System.out.println("Invalid Password. Try again");
       	 System.out.println("Password");
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
        System.out.println("Registered!!");
        
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
	

	
	Items newItems = new Items();
	
	Double totalPrice;
	//int quantitynum = 0;
	newItems.setItemname("Jeans");
	newItems.setItemcode("Jn");
	totalPrice=newItems.getPrice();
	items.add(newItems);
	
	
	System.out.println("        Store Inventory    ");
	System.out.println("+==============================+");
	System.out.println(Colors.ANSI_BOLD.getColor()+"  Items   Item Code   Price     "+Colors.ANSI_RESET.getColor());
	
	System.out.println("  "+   newItems.getItemname() +"     " + newItems.getItemcode() +"        $" + newItems.getPrice()                               );
	
	System.out.println("+==============================+");
	System.out.println("What would you like to buy? ");
	
	Scanner buyItem=new Scanner(System.in);
	String purchase;
	
	counter= newItems.getQuantity();
	purchase=buyItem.nextLine();
	if (purchase.equals(newItems.getItemname())) {
		//System.out.println(newItems.getQuantity());
		System.out.println("How many would you like to buy");
		quantitynum=buyItem.nextInt();
		newItems.setQuantity(counter-quantitynum);
		System.out.println(newItems.getQuantity());
		totalPrice*= quantitynum;
		System.out.println("totalPrice:$"+totalPrice);
	}
		
	
	for(int i=0;i<quantitynum;i++) {
		shoppingCart.push(newItems);
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
			System.out.println("Total Price: $ "+totalPrice);

			EcommerceShoppingApplication.Menu(buyItem);
		 
		}
		else {
			System.out.println("Invalid option");
			
		}
	}
public static void ReplaceItem() {
	
	LocalDate today=LocalDate.now();
	LocalDate invoiceDate;
	
	Scanner replaceItem =new Scanner(System.in);
	String replace;
		
	System.out.println(Colors.ANSI_BOLD.getColor()+"Invoice"+Colors.ANSI_RESET.getColor());
	invoiceDate=LocalDate.now().plusDays(15);
	System.out.println("Customer Name: "+ name + "     Date: " + invoiceDate);
	
	
	System.out.println(shoppingCart);
	System.out.print("What item would you like to replace?");
	replace=replaceItem.nextLine();
	if(today!=invoiceDate){
		System.out.println("Cannot replace item at this time");
		EcommerceShoppingApplication.Menu(replaceItem);
	}
	

	
	}
}

