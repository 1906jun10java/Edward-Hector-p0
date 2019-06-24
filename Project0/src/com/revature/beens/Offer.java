package com.revature.beens;

public class Offer {
	
	private Car car;
	private double offer;
	private String status;
	
	
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Offer(Car car, double offer) {
		super();
		this.car = car;
		this.offer = offer;
		this.status = "pending";
	}


	public Car getCar() {
		return car;
	}


	public void setOffer(double offer) {
		this.offer = offer;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
