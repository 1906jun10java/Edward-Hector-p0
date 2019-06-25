package proj0.beans;

//User has some implemented methods, so it is abstract
abstract class User {
	private int id;
	private String firstName, lastName, userName;
	//booleans for possible future methods, hasRegistered means customer, isEmployee is clear
	private boolean hasRegistered;
	private boolean isEmployee;
	
	public User(int id, String firstName, String lastName, String userName, boolean isEmployee) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.isEmployee = isEmployee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isHasRegistered() {
		return hasRegistered;
	}

	public void setHasRegistered(boolean hasRegistered) {
		this.hasRegistered = hasRegistered;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}
	
	
}
