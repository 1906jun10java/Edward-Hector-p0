package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Users {
	
	private List<Car> carList;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String userName, String password, String firstName, String lastName) {
		super(userName, password, firstName, lastName);
		this.carList=new ArrayList<>();
	}

	public List<Car> getCarList() {
		return carList;
	}

	
	
	
	
	

}
