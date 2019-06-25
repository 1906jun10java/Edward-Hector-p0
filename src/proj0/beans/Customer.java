package proj0.beans;

import java.util.ArrayList;

public class Customer extends User{
	private int creditScore;
	private ArrayList<Car> ownedCars;

	
	public Customer(int id, String firstName, String lastName, String userName, boolean isEmployee) {
		super(id, firstName, lastName, userName, isEmployee);
		ownedCars = new ArrayList<>();
		
	}
	
	
	
}
