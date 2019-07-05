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
			if (Dealership.customerMap.containsKey(username)) {
				 currentCustomer = Dealership.customerMap.get(username);
				 System.out.println(currentCustomer);
				if (currentCustomer.getPassword().equals(password)) {
					CustomerMenu.runCustomerMenu();
				} else {
					System.out.println("Wrong username or password, buddy");
					currentCustomer=null;
				}
			}
			else {
				System.out.println("No such user exists, friend");
			}
			
			/*Need to add the employee stuff
			 * Need to add the logic to get back to main menu after this
			 */
			
		} else if (type == 2) {

		}
		currentCustomer=null;
		MainMenu.mainMenuCaseVar=0;

	}

}
