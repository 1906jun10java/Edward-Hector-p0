package com.revature.logic;

import java.util.Collection;

import com.revature.beans.Car;
import com.revature.beans.Customer;
import com.revature.beans.Dealership;
import com.revature.beans.Offer;
import com.revature.beans.Users;

public class CustomerFunctions extends UserFunctions {
	
	public Customer thisCustomer;
	
	public CustomerFunctions(Customer thisCustomer) {
		this.thisCustomer=thisCustomer;
	}
	
	public Collection<Car> seeMyCars(){
		return thisCustomer.getCarList();
	}
	
	public Collection<Offer> seeMyPendingOffers(){
		return thisCustomer.getMyPendingOffers().values();
	}
	
	public void makeOffer(Car car, double offerAmmount,int numberOfPayments,double interestRate) {
		Offer newOffer=new Offer(car,offerAmmount,thisCustomer,numberOfPayments,interestRate);
		thisCustomer.getMyPendingOffers().put(newOffer.getOfferNumber(),newOffer );
		Dealership.pendingOffers.put(newOffer.getOfferNumber(), newOffer);
		
	}
	
	

}
