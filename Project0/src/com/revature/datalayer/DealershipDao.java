package com.revature.datalayer;

import java.util.ArrayList;
import com.revature.beans.*;

public interface DealershipDao {
	
	//Customer, Employee retrievers
	public Employee getEmployee(String userName);
	public Employee addEmployee(Employee e);
	public Customer getCustomer(String userName);
	public Customer addCustomer(Customer c);
	
	//Car lot methods
	public void addCar(Car c);
	public void removeCar(Car c); 
	public void transferCarToCustomer(Car c, Customer customer);
	public ArrayList<Car> getCarsOnLot();
	
	//Pending Offer methods
	//reject and accept moves a pending offer into respective offer map
	public void makeOffer(Offer o);
	public void rejectOffer(Offer o);
	public void acceptOffer(Offer o);
	
	//System
	//calc Payments
	public int calculateMonthlyPayment(Offer o);
	
}
