package com.revature.beans;

import java.sql.SQLException;
import java.util.Map;

import com.revature.datalayer.DealershipDBService;

public class Dealership {
	public static Employee system = new Employee();
	


	public static Map<Integer,Car> carMap;
	
	public static Map<String, Users> userMap;
	
	public static Map<Integer,Offer> offers;
	
	public static void initMaps() {
		DealershipDBService dbsrv = new DealershipDBService();
		try {
			userMap = dbsrv.grabUserMap();
			carMap = dbsrv.grabCarMap();
			offers = dbsrv.grabOfferMap();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}