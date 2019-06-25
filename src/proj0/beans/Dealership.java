package proj0.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Containing class
public class Dealership {
	/*
	 * Dealership contains a list of:
	 * Users <ID, User>
	 * Cars (on lot) <Arraylist, maybe change to map <VIN, Car>>
	 * Employees <ID, Employee>
	 * Customers <ID, Customer>
	 * A map of offers and the cars
	 */
	ArrayList<Car> carLot = new ArrayList<>();
	Map<Integer, User> userList = new HashMap<>();
	Map<Integer, Employee> employees = new HashMap<>();
	Map<Integer, Customer> customers = new HashMap<>();

	
}
