package com.revature.beans;



public abstract class Users {
	
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private int userID;
	private static int UID=1;
	private String userType;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String userName, String password, String firstName, String lastName,String userType) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType=userType;
		this.userID=UID;
		UID++;
	}
	
	
	public int getUserID() {
		return userID;
	}
	
	public String getUserType() {
		return userType;
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
	@Override
	public String toString() {
		return "Users [userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", userID=" + userID + ", userType=" + userType + "]";
	}
	

}
