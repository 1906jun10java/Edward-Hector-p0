package com.revature.menu;

import com.revature.beans.Customer;
import com.revature.beans.Dealership;

public class RegisterMenu {
	
	public static void runRegisterMenu() {
		System.out.println("Hello new user. Here you can register for a customer account"
				+ " please provide the following indicated fields in the correct format");
		
		System.out.println("What do you want your username to be?");
		String username=MainMenu.scanner.next();
		//add check for username, can have no repeting usernames
		while(Dealership.userMap.containsKey(username)==true) {
			System.out.println("This username is already taken. Input a new username");
			 username=MainMenu.scanner.next();
		}
		
		System.out.println("What do you want your password to be?");
		String password=MainMenu.scanner.next();
		
		
		System.out.println("your first name?");
		String firstName=MainMenu.scanner.next();
		
		
		System.out.println("Your last name?");
		String lastName=MainMenu.scanner.next();
		
		
		Customer newCustomer=new Customer(username,password,firstName,lastName);
		Dealership.userMap.put(username, newCustomer);
		System.out.println("Thank you for registering");
		
		MainMenu.mainMenuCaseVar=0;
		
	}

}
