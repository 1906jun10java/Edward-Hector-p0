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
		//empty constructor used to init Dealership Emp with reserved ID
		this.userName = "Dealership";
		this.userID = -1;
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
	
	//Needed to prevent false increments when grabbing from DB
	public void setId(int int1) {
		this.userID = int1;
	}
	//prevents ID from incrementing when grabbing cars from DB
	public static void forceCounterDown() {
		UID--;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userID;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (userID != other.userID)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}
	
}
