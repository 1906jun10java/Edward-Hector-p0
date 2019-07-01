package com.revature.beans;

public class Car {
	
	
	private String make;
	private String model;
	private String color;
	private int makeYear;
	private double msrp;
	private int id;
	private static int ID=1;
	
	
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
	
	

}
