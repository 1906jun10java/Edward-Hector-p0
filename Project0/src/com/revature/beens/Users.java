package com.revature.beens;

import java.util.ArrayList;

public abstract class Users {
	
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String userName, String password, String firstName, String lastName) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
