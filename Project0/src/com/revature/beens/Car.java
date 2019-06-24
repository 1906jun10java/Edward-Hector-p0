package com.revature.beens;

public class Car {
	
	private String make;
	private String model;
	private String color;
	private int makeYear;
	private double msrp;
	
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
	}



	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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

	public void setMakeYear(int makeYear) {
		this.makeYear = makeYear;
	}

	public double getMsrp() {
		return msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}
	
	

}
