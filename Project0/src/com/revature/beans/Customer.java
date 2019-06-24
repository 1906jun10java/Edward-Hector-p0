package com.revature.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer extends Users {
	
	private List<Car> carList;
	private Map<Integer,Offer> myPendingOffers;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String userName, String password, String firstName, String lastName) {
		super(userName, password, firstName, lastName);
		this.carList=new ArrayList<>();
		this.myPendingOffers=new HashMap<>();
	}

	public List<Car> getCarList() {
		return carList;
	}

	public Map<Integer, Offer> getMyPendingOffers() {
		return myPendingOffers;
	}



	
	
	
	
	

}
