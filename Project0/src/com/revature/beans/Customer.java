package com.revature.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.logic.CustomerFunctions;

public class Customer extends Users {
	
	

	private List<Car> carList;
	private Map<Integer,Offer> myPendingOffers;
	private CustomerFunctions myFunctions;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String userName, String password, String firstName, String lastName) {
		super(userName, password, firstName, lastName,"Customer");
		myFunctions=new CustomerFunctions(this);
		this.carList=new ArrayList<>();
		this.myPendingOffers=new HashMap<>();
	}

	public List<Car> getCarList() {
		return carList;
	}

	public Map<Integer, Offer> getMyPendingOffers() {
		return myPendingOffers;
	}

	public CustomerFunctions getMyFunctions() {
		return myFunctions;
	}
	
	
	
	
	

}
