package com.revature.datalayer;

import java.sql.SQLException;
import java.util.HashMap;

import com.revature.beans.Car;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.Offer;

public interface DealershipDao {
	
	public void pushCarMap() throws SQLException;
	public HashMap<Integer, Car> grabCarMap() throws SQLException;
	
	public void pushCustomerMap() throws SQLException;
	public HashMap<Integer, Customer> grabCustomerMap() throws SQLException;
	
	public void pushEmployeeMap() throws SQLException;
	public HashMap<Integer, Employee> grabEmployeeMap() throws SQLException;
	
	public void pushOfferMaps() throws SQLException;
	public HashMap<Integer, Offer> grabPendingOffers() throws SQLException;
	public HashMap<Integer, Offer> grabRejectedOffers() throws SQLException;
	public HashMap<Integer, Offer> grabAcceptedOffers() throws SQLException;
}
