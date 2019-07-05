package com.revature.beans;

public class Car {
	
	
	private String make;
	private String model;
	private String color;
	private int makeYear;
	private double msrp;
	private int id;
	private static int ID=1;
	private Users owner;
	
	
	public Car() {
		super();
	}
	
	

	public Car(String make, String model, String color, int makeYear, double msrp) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.makeYear = makeYear;
		this.msrp = msrp;
		this.id=ID;
		ID++;
	}



	public int getId() {
		return id;
	}


	public String getMake() {
		return make;
	}


	public String getModel() {
		return model;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMakeYear() {
		return makeYear;
	}

	public double getMsrp() {
		return msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}

	public Users getOwner() {
		return owner;
	}



	public void setOwner(Users owner) {
		this.owner = owner;
	}

	//-1 is a special ID meaning the car is owned by the Dealership
	public int getOwnerId() {
		if(this.getOwner() != null) {
			return this.getOwner().getUserID();
		}
		return -1;
	}
	//Only used in DB service,
	public void setId(int int1) {
		this.id = int1;
	}
	//prevents ID from incrementing when grabbing cars from DB
	public static void forceCounterDown() {
		ID--;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Car other = (Car) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
