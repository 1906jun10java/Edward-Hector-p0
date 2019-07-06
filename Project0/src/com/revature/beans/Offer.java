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
	


	public void setStatus(String status) {
		this.status = status;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		long temp;
		temp = Double.doubleToLongBits(interestRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numberOfPayments;
		temp = Double.doubleToLongBits(offerAmmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + offerNumber;
		result = prime * result + paymentsRemaining;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (Double.doubleToLongBits(interestRate) != Double.doubleToLongBits(other.interestRate))
			return false;
		if (numberOfPayments != other.numberOfPayments)
			return false;
		if (Double.doubleToLongBits(offerAmmount) != Double.doubleToLongBits(other.offerAmmount))
			return false;
		if (offerNumber != other.offerNumber)
			return false;
		if (paymentsRemaining != other.paymentsRemaining)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userThatMadeOffer == null) {
			if (other.userThatMadeOffer != null)
				return false;
		} else if (!userThatMadeOffer.equals(other.userThatMadeOffer))
			return false;
		return true;
	}





	
	

}
