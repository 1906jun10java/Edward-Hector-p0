package com.revature.menu;

import com.revature.beans.Customer;
import com.revature.beans.Dealership;
import com.revature.beans.Employee;

public class LogInMenu {
	public static Customer currentCustomer;
	public static Employee currentEmployee;

	public static void runLogInMenu() {
		System.out.println("Are you a\n 1.Customer \n 2.Employee");
		int type = MainMenu.scanner.nextInt();

		if (type == 1) {
			System.out.println("What is your username?");
			String username = MainMenu.scanner.next();
			System.out.println("What is your password");
			String password = MainMenu.scanner.next();
			
			//Check to see if the user is in the map
			if (Dealership.userMap.containsKey(username)) {
				//make sure that the user is a customer and not an employee
				if (Dealership.userMap.get(username).getUserType().equals("Customer")) {
					currentCustomer = (Customer) Dealership.userMap.get(username);
					//make sure the correct password was input
					if (currentCustomer.getPassword().equals(password)) {
						CustomerMenu.runCustomerMenu();
					} else {
						System.out.println("Wrong username or password, buddy");
						currentCustomer = null;
					}
				}
				//If the user puts in an existing of the wrong type then this
				else {
					System.out.println("Username not associated with a customer");
				}
				//if the username is not in the map then this
			} else {
				System.out.println("No such user exists, friend");
			}

			/*
			 * Need to add the employee stuff Need to add the logic to get back to main menu
			 * after this
			 */

		} else if (type == 2) {
			
			System.out.println("What is your username?");
			String username = MainMenu.scanner.next();
			System.out.println("What is your password");
			String password = MainMenu.scanner.next();
			
			if (Dealership.userMap.containsKey(username)) {
				//make sure that the user is a customer and not an employee
				if (Dealership.userMap.get(username).getUserType().equals("Employee")) {
					currentEmployee = (Employee) Dealership.userMap.get(username);
					//make sure the correct password was input
					if (currentEmployee.getPassword().equals(password)) {
						EmployeeMenu.runEmployeeMenu();
					} else {
						System.out.println("Wrong username or password, buddy");
						currentEmployee = null;
					}
				}
				//If the user puts in an existing of the wrong type then this
				else {
					System.out.println("Username not associated with an employee");
				}
				//if the username is not in the map then this
			} else {
				System.out.println("No such user exists, friend");
			}


		}
		currentCustomer = null;
		currentEmployee=null;
		MainMenu.mainMenuCaseVar = 0;

	}

}
