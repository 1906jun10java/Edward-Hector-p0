package com.revature.beans;

public class Offer {
	
	private Car car;
	private double offer;
	private String status;
	private int offerNumber;
	private static int Number=1;
	
	
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Offer(Car car, double offer) {
		super();
		this.car = car;
		this.offer = offer;
		this.status = "pending";
		this.offerNumber=Number;
		Number++;
	}


	
	
	public double getOffer() {
		return offer;
	}


	public Car getCar() {
		return car;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	

}
