package com.revature.logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.revature.beans.Car;
import com.revature.beans.Customer;
import com.revature.beans.Dealership;
import com.revature.beans.Offer;
import com.revature.beans.Users;

public class EmployeeFunctions extends UserFunctions {
	
	private Users thisEmployee;
	
	public EmployeeFunctions(Users thisEmployee) {
		this.thisEmployee=thisEmployee;
	}

	public void addCar(String make,String model,String color,int makeYear,double msrp) {
		Car newCar=new Car(make,model,color,makeYear,msrp);
	
		Dealership.carMap.put(newCar.getId(), newCar);
	}
	
	public int paymentsMadeOnOffer(int offerID) {
		Offer offer=Dealership.acceptedOffers.get(offerID);
		return offer.getNumberOfPayments()-offer.getPaymentsRemaining();
	}
	
	public Collection<Offer> getPendingOfferList(){
		return Dealership.pendingOffers.values();
	}
	
	public Collection<Offer> getAcceptedOfferList(){
		return Dealership.acceptedOffers.values();
	}
	
	public void accpetOffer(int offerID) {
		Offer offer=Dealership.pendingOffers.get(offerID);
		Dealership.acceptedOffers.put(offerID, offer);
		Car car=offer.getCar();
		Dealership.carMap.remove(car.getId());
		Dealership.pendingOffers.remove(car.getId());
		
		Customer user=offer.getUserThatMadeOffer();
		user.getMyPendingOffers().remove(offerID);
		
		List<Car> userList=user.getCarList();
		userList.add(car);
		
		//------------------------------------------------------------------------------------
		
		Collection<Offer> pendingOffers=Dealership.pendingOffers.values();
		Iterator<Offer> iterator = pendingOffers.iterator(); 
		
		Collection<Offer> pendingOffersWithCar=new ArrayList<>();
		
		 while (iterator.hasNext()) {
			 Offer offerOverIterator=iterator.next();
	           if (offerOverIterator.getCar().getId()==car.getId()) {
	        	   pendingOffersWithCar.add(offerOverIterator);
	           }
	    } 
		 Iterator<Offer> iteratorForRejection = pendingOffersWithCar.iterator(); 
		 
		 while (iteratorForRejection.hasNext()) {
			Offer offersToRemove=iteratorForRejection.next();
			Dealership.rejectedOffers.put(offersToRemove.getOfferNumber(),offersToRemove );
			Dealership.pendingOffers.remove(offersToRemove.getOfferNumber());
			Customer userToBeRejected=offersToRemove.getUserThatMadeOffer();
			userToBeRejected.getMyPendingOffers().remove(offersToRemove.getOfferNumber());
	    } 
		//--------------------------------------------------------------------------------------
		
	}
	
	public void rejectOffer(int offerID) {
		Offer offer=Dealership.pendingOffers.get(offerID);
		Dealership.rejectedOffers.put(offerID, offer);
		
		Dealership.pendingOffers.remove(offerID);
		Customer user=offer.getUserThatMadeOffer();
		
		user.getMyPendingOffers().remove(offerID);
	}
	 
	

}
