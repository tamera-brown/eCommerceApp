package com.shoppingapp.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.shoppingapp.service.CustomerService;



public class eCommerceShoppingApplication {

	public static void main(String[] argss) {
		Scanner option=null;
		CustomerService.addInventory();
		Menu(option);
	}

	public static void Menu(Scanner option) {
		
		int choice;
		try {
			
			
		
		option =new Scanner(System.in);
		
		 System.out.println("    Standalone Ecommerce App");
         System.out.println("+==============================+");
         System.out.println("+   1.Register                 +");
         System.out.println("+   2.Login                    +");
         System.out.println("+   3.Buy an item              +");
         System.out.println("+   4.Replace an item          +");
         System.out.println("+   5.Exit                     +");
         System.out.println("+==============================+");

         choice = option.nextInt();
         switch (choice) {
		case 1: 
			CustomerService.Register(option);
			Menu(option);
			
			break;
		case 2:
			CustomerService.Login(option);
    		break;
		case 3:
			CustomerService.BuyItem();
			break;
		case 4:
			CustomerService.ReplaceItem();
			break;
		case 5:
			System.out.println("Thank you for shopping with us! \n");
		
			break;
			
			
		default:
			System.out.println("Invail option!!!. Please try again");
			Menu(option);
		}
     	
		} catch (InputMismatchException e) {
			// TODO: handle exception
		}
	}
}
