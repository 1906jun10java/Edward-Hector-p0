package com.revature.menu;

import com.revature.beans.Car;
import com.revature.beans.Dealership;
import com.revature.beans.Offer;
import com.revature.logic.AnnuityCalc;

public class CustomerMenu {

	public static void runCustomerMenu() {
		System.out.println("Hello " + LogInMenu.currentCustomer.getUserName());
		Dealership.initMaps(); //refreshes maps when entering new menu to remain up to date
		while (true) {
			System.out.println(" 1.See available cars \n 2.See cars you own \n 3.See your pending offers"
					+ "\n 4.Make an offer on a car \n 5.Make payment \n 6.Log Out");

			while (MainMenu.scanner.hasNextInt() != true) {
				System.out.println("Invalid input, please type an integer");
				MainMenu.scanner.next();
			}

			int userCaseVar = MainMenu.scanner.nextInt();
			// Get list of all cars in lot
			if (userCaseVar == 1) {
				System.out.println(LogInMenu.currentCustomer.getMyFunctions().getCarsInLot().toString());
				userCaseVar = 0;
			}
			// See cars the customer has bought
			else if (userCaseVar == 2) {
				System.out.println(LogInMenu.currentCustomer.getMyFunctions().seeMyCars().toString());
				userCaseVar = 0;

			}
			// See offers made on cars
			else if (userCaseVar == 3) {
				System.out.println(LogInMenu.currentCustomer.getMyFunctions().seeMyPendingOffers().toString());
				userCaseVar = 0;
			}
			// Make an offer
			else if (userCaseVar == 4) {
				
				while (userCaseVar == 4) {
					System.out.println("What is the ID of the car you want?");
					// Input validations
					while (MainMenu.scanner.hasNextInt() != true) {
						System.out.println("Invalid input, please type an integer");
						MainMenu.scanner.next();
					}

					int carID = MainMenu.scanner.nextInt();
					Car car = Dealership.carMap.get(carID);
					// Add logic: if the car id given not valid, then what?

					System.out.println("How much do you want to pay for the car? "
							+ "If you plan on taking a loan then what do you want the principal to be?"
							+ "\nThe principal ammount must be at least 90% of the cars msrp.");

					// Input validation
					while (MainMenu.scanner.hasNextDouble() != true) {
						System.out.println("Invalid input, please type an integer");
						MainMenu.scanner.next();
					}
					double ammount = MainMenu.scanner.nextDouble();
					
					if(ammount < 0.9*car.getMsrp()) {
						System.out.println("The ammount you want to pay is less than 90% of the cars msrp."
								+ " Your offer is invalid");
						break;
					}

					System.out.println("How many payments do you want to make on the car? "
							+ "Value must be an whole number that is greater than one.");
					// Input validation
					while (MainMenu.scanner.hasNextInt() != true) {
						System.out.println("Invalid input, please type an integer");
						MainMenu.scanner.next();
					}
					int numberOfPayments = MainMenu.scanner.nextInt();
					
					if(numberOfPayments<1) {
						System.out.println("Your desired tem length is invalid");
						break;
					}

					System.out.println("What is your desired interest rate? Non negative numbers only. "
							+ "Example 5 for 5%, 10.2 for 10.2%, etc");

					while (MainMenu.scanner.hasNextDouble() != true) {
						System.out.println("Invalid input, please type an integer");
						MainMenu.scanner.next();
					}

					double interest = MainMenu.scanner.nextDouble();
					
					if(interest<0) {
						System.out.println("You cant have a negative interest rate");
						break;
					}
					
					LogInMenu.currentCustomer.getMyFunctions().makeOffer(car, ammount, numberOfPayments, interest);
					userCaseVar = 0;
				}
				userCaseVar = 0;
			}
			// Make payments
			else if (userCaseVar == 5) {
				System.out.println("What is the id of the car you want to make a payment on?");
				while (MainMenu.scanner.hasNextInt() != true) {
					System.out.println("Invalid input, please type an integer");
					MainMenu.scanner.next();
				}
				int carID = MainMenu.scanner.nextInt();
				for (Offer o : Dealership.offers.values()) {
					if (o.getCar().getId() == carID && o.getStatus() ==1) {
						if (o.getUserThatMadeOffer().equals(LogInMenu.currentCustomer)
								&& o.getPaymentsRemaining() != 0) {
							System.out.println("You are about to make a payment of " + AnnuityCalc.annuityCalc(o)
									+ " for" + o.getCar().toString()
									+ "\nWould you like to procede? \n 1.Yes \n No (input any number)");
							while (MainMenu.scanner.hasNextInt() != true) {
								System.out.println("Invalid input, please type an integer");
								MainMenu.scanner.next();
							}
							int yesNo = MainMenu.scanner.nextInt();
							if (yesNo == 1) {
								o.setPaymentsRemaining(o.getPaymentsRemaining() - 1);
								break;
							} else {
								System.out.println("ok, no payment will be made");
								break;
							}

						} else {
							System.out.println("Either you do not own this car or you have already payed it off");
							break;
						}
					}

				}

			}

			// log out
			else if (userCaseVar == 6) {
				Dealership.pushAllMaps();
				MainMenu.mainMenuCaseVar = 0;
				break;
			}

		}
	}
}
