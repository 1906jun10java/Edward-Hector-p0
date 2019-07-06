package com.revature.menu;

import java.awt.List;

import com.revature.beans.Car;
import com.revature.beans.Dealership;
import com.revature.beans.Offer;
import com.revature.logic.AnnuityCalc;

public class EmployeeMenu {
	public static void runEmployeeMenu() {
		System.out.println("Hello " + LogInMenu.currentEmployee.getUserName());

		while (true) {
			
			System.out.println("1.Add Car to lot \n2.See pending offers \n 3.Reject offer"
					+ "\n 4.Accept Offer \n 5.See payments remaining on a car \n 6.See accepted offers"
					+ " \n7. Log Out");

			int userCaseVar = MainMenu.scanner.nextInt();

			if (userCaseVar == 1) {
				System.out.println("Make of the car?");
				String make = MainMenu.scanner.next();
				System.out.println("Model of the car?");
				String model = MainMenu.scanner.next();
				System.out.println("Color of the car?");
				String color = MainMenu.scanner.next();

				System.out.println("Year of the car?");
				while (MainMenu.scanner.hasNextInt() != true) {
					System.out.println("Invalid input, please type an integer");
					MainMenu.scanner.next();
				}
				int year = MainMenu.scanner.nextInt();

				System.out.println("MSRP for the car?");
				while (MainMenu.scanner.hasNextDouble() != true) {
					System.out.println("Invalid input, type a number");
					MainMenu.scanner.next();
				}
				double msrp = MainMenu.scanner.nextDouble();

				LogInMenu.currentEmployee.getMyFunctions().addCar(make, model, color, year, msrp);

				userCaseVar = 0;
				
				// Get pending offers
				
				
				
			} else if (userCaseVar == 2) {

				for (Offer o : Dealership.offers.values()) {
					if (o.getStatus() == 0) {
						System.out.println(o);
					}
				}

				userCaseVar = 0;

				
				
				
				// Reject offer
			} else if (userCaseVar == 3) {
				System.out.println("The offer number?");

				while (MainMenu.scanner.hasNextInt() != true) {
					System.out.println("Invalid input, please type an integer");
					MainMenu.scanner.next();
				}
				int offerID = MainMenu.scanner.nextInt();

				LogInMenu.currentEmployee.getMyFunctions().rejectOffer(offerID);
				userCaseVar = 0;

				
				
				
				
				// Accept offer
			} else if (userCaseVar == 4) {

				System.out.println("The offer number?");

				while (MainMenu.scanner.hasNextInt() != true) {
					System.out.println("Invalid input, please type an integer");
					MainMenu.scanner.next();
				}
				int offerID = MainMenu.scanner.nextInt();
				

				LogInMenu.currentEmployee.getMyFunctions().accpetOffer(offerID);

				userCaseVar = 0;
				
				
				
				
				//See payments
			} else if(userCaseVar==5) {
				
				System.out.println("The car id number?");

				while (MainMenu.scanner.hasNextInt() != true) {
					System.out.println("Invalid input, please type an integer");
					MainMenu.scanner.next();
				}
				int carID = MainMenu.scanner.nextInt();
				
				for (Car c : Dealership.carMap.values()) {
					if (c.getId()==carID && c.getOwner()!=null) {
						Car carToWorkWith=c;
						for(Offer o:Dealership.offers.values()) {
							if(o.getCar().equals(carToWorkWith)) {
								int paymentsLeft=o.getPaymentsRemaining();
								System.out.println(c.getOwner().getFirstName()+" "+c.getOwner().getLastName()
										+"has made"+(o.getNumberOfPayments()-paymentsLeft)+"of"+AnnuityCalc.annuityCalc(o)
										+"of a total of"+o.getNumberOfPayments());
								
							}
						}
					}
					else {
						System.out.println("The car you are looking for is either not registered here or"
								+" it had not been sold.");
					}
				}
				
				
				//see accepted offers
			}else if (userCaseVar == 6) {
				for (Offer o : Dealership.offers.values()) {
					if (o.getStatus() == 1) {
						System.out.println(o);
					}
				}

				userCaseVar = 0;
				//log out
			}else if (userCaseVar == 7) {
				MainMenu.mainMenuCaseVar = 0;
				break;
			}

		}

	}
}
