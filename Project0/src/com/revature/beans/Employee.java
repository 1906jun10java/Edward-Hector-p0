package com.revature.beans;

import com.revature.logic.EmployeeFunctions;

public class Employee extends Users {
	
	private EmployeeFunctions myFunctions;


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String userName, String password, String firstName, String lastName) {
		super(userName, password, firstName, lastName,"Employee");
		myFunctions=new EmployeeFunctions(this);
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeFunctions getMyFunctions() {
		return myFunctions;
	}
	
	

}
