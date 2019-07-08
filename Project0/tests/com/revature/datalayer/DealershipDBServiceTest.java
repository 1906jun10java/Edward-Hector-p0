package com.revature.datalayer;

import java.sql.SQLException;
import java.util.Map;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.Car;
import com.revature.beans.Dealership;

public class DealershipDBServiceTest {
	
	//initialize the maps like we do in the MainMenu
	@BeforeClass
	public static void initTest() {
		Dealership.initMaps();
	}
	
	@Test
	public void ensureDatabaseCarMapEntryMatches() {
		DealershipDBService dbsrv = new DealershipDBService();
		Map<Integer, Car> diffOffer;
		try {
			assertEquals(Dealership.carMap, dbsrv.grabCarMap());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
