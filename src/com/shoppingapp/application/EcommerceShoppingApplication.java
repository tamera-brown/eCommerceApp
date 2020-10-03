package com.shoppingapp.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.shoppingapp.service.UserService;
import com.shoppingapp.utility.ColorsUtility.Colors;

public class EcommerceShoppingApplication {
	private static String id;
	public static void main(String[] argss) {
		Scanner option=null;
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
			UserService.Register(option);
			Menu(option);
			
			break;
		case 2:
			id=UserService.Login(option);
			break;
		case 3:
			UserService.BuyItem();
			break;
		case 4:
			UserService.ReplaceItem();
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
