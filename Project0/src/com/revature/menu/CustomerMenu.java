package com.revature.menu;

import com.revature.beans.Car;
import com.revature.beans.Dealership;

public class CustomerMenu {

	public static void runCustomerMenu() {
		System.out.println("Hello " + LogInMenu.currentCustomer.getUserName());

		while (true) {
			System.out.println("1.See available cars \n2.See cars you own \n 3.See your pending offers"
					+ "\n 4.Make an offer on a car \n 5.Log Out");
			int userCaseVar = MainMenu.scanner.nextInt();
			if (userCaseVar == 1) {
				System.out.println(LogInMenu.currentCustomer.getMyFunctions().getCarsInLot());
				userCaseVar = 0;
			} else if (userCaseVar == 2) {
				System.out.println(LogInMenu.currentCustomer.getMyFunctions().seeMyCars());
				userCaseVar=0;

			} else if (userCaseVar == 3) {
				System.out.println(LogInMenu.currentCustomer.getMyFunctions().seeMyPendingOffers());
				userCaseVar=0;
			} else if (userCaseVar == 4) {
				System.out.println("What is the ID of the cat you want?");
				int carID = MainMenu.scanner.nextInt();
				Car car=Dealership.carMap.get(carID);
				//Add logic: if the car id given not valid, then what? 
				System.out.println("How much do you want to pay for the car? "
						+ "If you plan on taking a loan then what do you want the principal to be?");
				double ammount = MainMenu.scanner.nextDouble();
				System.out.println("How many payments do you want to make on the car? "
						+ "Value must be an whole number that is greater than one.");
				int numberOfPayments = MainMenu.scanner.nextInt();
				System.out.println("What is your desired interest rate? Non negative numbers only.");
				double interest = MainMenu.scanner.nextDouble();
				LogInMenu.currentCustomer.getMyFunctions().makeOffer(car, ammount, numberOfPayments, interest);
				userCaseVar=0;
			}
			else if(userCaseVar==5) {
				MainMenu.mainMenuCaseVar=0;
				break;
			}

		}
	}
}
