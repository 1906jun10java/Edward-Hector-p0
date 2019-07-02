package com.revature.beans;

public class Offer {
	
	private Car car;
	private double offerAmmount;
	private String status;
	private int offerNumber;
	private static int Number=1;
	private Customer userThatMadeOffer;
	private int numberOfPayments;
	private double interestRate;
	private int paymentsRemaining;
	
	
	
	

	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Offer(Car car, double offerAmmount,Customer user,int numberOfPayments,double interestRate) {
		super();
		this.car = car;
		this.offerAmmount = offerAmmount;
		this.status = "pending";
		this.userThatMadeOffer=user;
		this.numberOfPayments=numberOfPayments;
		this.interestRate=interestRate;
		this.offerNumber=Number;
		Number++;
	}
	
	public int getPaymentsRemaining() {
		return paymentsRemaining;
	}
	
	
	public int getNumberOfPayments() {
		return numberOfPayments;
	}



	public double getInterestRate() {
		return interestRate;
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
