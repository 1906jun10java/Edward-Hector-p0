package com.revature.beans;

public class Offer {
	
	private Car car;
	private double offerAmmount;
	private String status;
	private int offerNumber;
	private static int Number=1;
	private Customer userThatMadeOffer;
	
	
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Offer(Car car, double offer,Customer user) {
		super();
		this.car = car;
		this.offerAmmount = offer;
		this.status = "pending";
		this.userThatMadeOffer=user;
		this.offerNumber=Number;
		Number++;
	}


	
	
	public int getOfferNumber() {
		return offerNumber;
	}


	public Customer getUserThatMadeOffer() {
		return userThatMadeOffer;
	}
	


	public double getOfferAmmount() {
		return offerAmmount;
	}


	public Car getCar() {
		return car;
	}


	public String getStatus() {
		return status;
	}


	
	

}
