package proj0.beans;

import java.util.ArrayList;

public class Employee extends User {
	private int quota;
	private ArrayList<Car> acceptedOffers;
	
	public Employee(int id, String firstName, String lastName, String userName, boolean isEmployee) {
		super(id, firstName, lastName, userName, isEmployee);
		acceptedOffers = new ArrayList<>();
	}
	
}
