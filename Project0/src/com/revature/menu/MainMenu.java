package com.revature.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.beans.Dealership;
import com.revature.beans.Users;
import com.revature.datalayer.DealershipDBService;

public class MainMenu {

	public static Scanner scanner;
	public static int mainMenuCaseVar;

	public MainMenu() {
		super();

	}

	public static void runMainMenu() {
		Dealership.initMaps();
		scanner=new Scanner(System.in);
		/*
		 * System.out.println("Welcome\nSelect on of the options");
		 * System.out.println("1.Log In \n" + "2.Register \n" + "3.Close Program");
		 * mainMenuCaseVar = scanner.nextInt();
		 * 
		 */
		
		//I'll forget what the usernames and passwords are, so print them out.
		for (Users u : Dealership.userMap.values()) {
			System.out.println(u.toString());
		}
		
		
//		Customer genericCustomer=new Customer();
//		Dealership.userMap.put(null, genericCustomer);
		while (true) {
			
			System.out.println("Welcome\nSelect on of the options");
			System.out.println("1.Log In \n" + "2.Register \n" + "3.Close Program");
			mainMenuCaseVar = scanner.nextInt();
			//add check so that non int valuse don't break the code lol
			while (mainMenuCaseVar == 1) {
				LogInMenu.runLogInMenu();
			}

			while (mainMenuCaseVar == 2) {
				RegisterMenu.runRegisterMenu();
			}
			
			if(mainMenuCaseVar==3) {
				System.out.println("Closing Program  :)");
				scanner.close();
				
				//Pushes all changes to the DB on exit.
				DealershipDBService dbsrv = new DealershipDBService();
				try {
					dbsrv.pushCarMap();
					dbsrv.pushOfferMap();
					dbsrv.pushUserMap();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

		}
	}

	public static void main(String[] args) {
		runMainMenu();
	}

}
