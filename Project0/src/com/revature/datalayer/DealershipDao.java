package com.revature.datalayer;

import java.sql.SQLException;
import java.util.HashMap;

import com.revature.beans.Car;
import com.revature.beans.Offer;
import com.revature.beans.Users;

public interface DealershipDao {
	
	public void pushCarMap() throws SQLException;
	public HashMap<Integer, Car> grabCarMap() throws SQLException;
	
	//May be changed to UserMap
	public void pushUserMap() throws SQLException;
	public HashMap<Integer, Users> grabUserMap() throws SQLException;
	
	public void pushOfferMap() throws SQLException;
	public HashMap<Integer, Offer> grabOfferMap() throws SQLException;
}
