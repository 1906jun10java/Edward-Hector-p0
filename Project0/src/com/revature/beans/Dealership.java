package com.revature.beans;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import com.revature.datalayer.DealershipDBService;

public class Dealership {

	public static Map<Integer,Car> carMap;
	
	public static Map<String, Users> userMap;
	
	public static Map<Integer,Offer> offers;
	

	public static void initMaps() {
		DealershipDBService dbsrv = new DealershipDBService();
		try {
			System.out.println("...Updating local maps...");
			userMap = dbsrv.grabUserMap();
			carMap = dbsrv.grabCarMap();
			offers = dbsrv.grabOfferMap();
			assignCars();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public static void pushAllMaps() {
		DealershipDBService dbsrv = new DealershipDBService();
		System.out.println("...Pushing all local changes to Database...");
		try {
			dbsrv.pushCarMap();
			dbsrv.pushOfferMap();
			dbsrv.pushUserMap();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void assignCars() {
		Customer temp = null;
		for(Offer o : offers.values()) {
			if(o.getStatus() == 1) {
				if((temp = o.getUserThatMadeOffer()) != null) {
					Car oCar = carMap.get(o.getCar().getId());
					temp.getCarList().add(oCar);
					oCar.setOwner(o.getUserThatMadeOffer());
				}
			} else if(o.getStatus() == 0) {
				if((temp = o.getUserThatMadeOffer()) != null) {
					temp.getMyPendingOffers().put(new Integer(o.getId()), o);
				}
			}
		}
	}
	
}