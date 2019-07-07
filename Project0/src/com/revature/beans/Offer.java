package com.revature.beans;

public class Offer {
	
	private Car car;
	private double offerAmmount;
	private int status; //0-3
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
		this.status = 0;
		this.userThatMadeOffer=user;
		this.numberOfPayments=numberOfPayments;
		this.paymentsRemaining = numberOfPayments;
		this.interestRate=interestRate;
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


	public int getStatus() {
		return status;
	}

	public void setPaymentsRemaining(int paymentsRemaining) {
		this.paymentsRemaining = paymentsRemaining;
	}


	@Override
	public String toString() {
		return "Offer [car=" + car + ", offerAmmount=" + offerAmmount + ", status=" + status + ", offerNumber="
				+ offerNumber + ", userThatMadeOffer=" + userThatMadeOffer + ", numberOfPayments=" + numberOfPayments
				+ ", interestRate=" + interestRate + ", paymentsRemaining=" + paymentsRemaining + "]";
	}

	public void setNumberOfPayments(int numberOfPayments) {
		this.numberOfPayments = numberOfPayments;
	}

	public int getId() {
		return this.offerNumber;
	}
	//Needed to prevent false increments when grabbing from DB
	public void setId(int int1) {
		this.offerNumber = int1;
	}
	//prevents ID from incrementing when grabbing cars from DB
	public static void forceCounterDown() {
		Number--;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		long temp;
		temp = Double.doubleToLongBits(offerAmmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + offerNumber;
		result = prime * result + status;
		result = prime * result + ((userThatMadeOffer == null) ? 0 : userThatMadeOffer.hashCode());
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
		Offer other = (Offer) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (Double.doubleToLongBits(offerAmmount) != Double.doubleToLongBits(other.offerAmmount))
			return false;
		if (offerNumber != other.offerNumber)
			return false;
		if (status != other.status)
			return false;
		if (userThatMadeOffer == null) {
			if (other.userThatMadeOffer != null)
				return false;
		} else if (!userThatMadeOffer.equals(other.userThatMadeOffer))
			return false;
		return true;
	}

	public void setStatus(int i) {
		this.status = i;
	}

}

