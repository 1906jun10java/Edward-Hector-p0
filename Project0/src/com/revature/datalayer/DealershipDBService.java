package com.revature.datalayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.revature.beans.Car;
import com.revature.beans.Customer;
import com.revature.beans.Dealership;
import com.revature.beans.Employee;
import com.revature.beans.Offer;
import com.revature.beans.Users;

public class DealershipDBService implements DealershipDao {
	public static ConnFactory cF = ConnFactory.getInstance();

	//might just make the whole thing static
	public static void main(String[] args) {

	}
	
	@Override
	//To be called to push the current carMap in the Dealership into the database
	public void pushCarMap() throws SQLException {
		Map<Integer,Car> diffCars = grabCarMap();
		for(Car c : diffCars.values()) {
			//System.out.println("DB fetched: "+c.getId()+" "+c.getMake());
		}
		for (Car c : Dealership.carMap.values()) {
			//System.out.println("allDealerCars: "+c.getId()+" "+c.getMake());
		    if(diffCars.containsValue(c)) {
		    	if(c.getOwner() != null) {
		    		updateCar(c, c.getOwner());
		    	}
		    } else {
		    	//System.out.println("\nInserting Car: "+c.getId()+" "+c.getMake()+" :"+diffCars.get(c.getId()));
		    	insertCar(c);
		    	//TODO clean this up later if need be
		    	if(c.getOwner() != null) {
		    		updateCar(c, c.getOwner());
		    	}
		    }
		}
	}
	
	//when inserting a car into the DB, it should (as per getOwnerID()) add it with an owner of Dealership
	private void insertCar(Car c)  throws SQLException {
		Connection conn = cF.getConnection();
		String sql = "INSERT INTO CAR VALUES ("+c.getId()+",'"+c.getMake()+"','"+c.getModel()+"','"+
		c.getColor()+"',"+c.getMakeYear()+","+c.getMsrp()+","+c.getOwner()+")";
		//System.out.println("=============="+"\n"+sql+"==================");
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeQuery();
		ps.close();
		conn.close();
	}

	//to be called updating a car, id is the ID of the Customer which owns that car
	private void updateCar(Car c, Users u) throws SQLException {
		//System.out.println("in update car");
		Connection conn = cF.getConnection();
		String sql = "UPDATE CAR SET OWNER_ID = "+u.getUserID()+"WHERE CAR_VIM = "+c.getId();
		CallableStatement call = conn.prepareCall(sql);
		call.execute();
		conn.close();
	}

	@Override
	//Grabs all cars currently in the dealership
	public HashMap<Integer, Car> grabCarMap() throws SQLException {
		HashMap<Integer, Car> cMap = new HashMap<Integer, Car>();
		Connection conn = cF.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rS = stmt.executeQuery("SELECT * FROM CAR");
		Car c = null;
		while(rS.next()) {
			c = new Car(rS.getString(2), rS.getString(3), rS.getString(4), rS.getInt(5), rS.getDouble(6));
			c.setId(rS.getInt(1)); 
			//System.out.println("Grabbing "+c.toString());
			//Car.forceCounterDown(); 
			if(rS.getInt(7) <= 0) {
				c.setOwner(null);
			}
			
			if(Dealership.userMap == null) {
				System.out.println("userMap is null");
			}
			
			c.setOwner(Dealership.userMap.get(new Integer (rS.getInt(7))));
			cMap.put(new Integer(c.getId()), c);
		}
		rS.close();
		conn.close();
		return cMap;
	}

	@Override
	public void pushUserMap() throws SQLException {
		Map<String, Users> diffCust = grabUserMap();

		for(Users u : diffCust.values()) {
			//System.out.println("diffCust "+u.getUserName()+" "+u.getUserID());
		}
		for (Users u : Dealership.userMap.values()) {
			//System.out.println("allDealerCust: "+u.getUserName()+" "+u.getUserID());
		    if(!diffCust.containsValue(u) && u.getUserName() != null) {
		    	insertUser(u);
		    } 
		}
	}
	
	//Or we could just use update car whenever a car is modified
	public void addCarToCustomer(Car car, Customer newOwner) throws SQLException {
		Connection conn = cF.getConnection();
		String sql = "UPDATE CAR SET OWNER_ID = "+newOwner.getUserID()+" WHERE CAR_VIM = "+car.getId();
		CallableStatement call = conn.prepareCall(sql);
		call.execute();
		conn.close();
	}

	private void insertUser(Users u) throws SQLException {
		Connection conn = cF.getConnection();
		String sql = "INSERT INTO DEALERSHIP_USER VALUES ("+u.getUserID()+",'"+u.getFirstName()+"','"+u.getLastName()+"','"+
		u.getUserName()+"','"+u.getPassword()+"',"+0+")";
		//System.out.println("CUSTOMER: \n"+ sql);
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeQuery();
		ps.close();
		conn.close();
	}

	@Override
	public HashMap<String, Users> grabUserMap() throws SQLException {
		Map<String, Users> uMap = new HashMap<String, Users>();

		Connection conn = cF.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rS = stmt.executeQuery("SELECT * FROM DEALERSHIP_USER");
		Customer c = null;
		Employee e = null;
		while(rS.next()) {
			if (rS.getInt(6) == 0) {
				c = new Customer(rS.getString(4), rS.getString(5), rS.getString(2), rS.getString(3));
				c.setId(rS.getInt(1)); //sets ID to the one stored in the DB manually,
				Users.forceCounterDown(); //and prevents our id generator logic in Car.java from misbehaving
				uMap.put(rS.getString(4), c);
			} else if (rS.getInt(6) == 1){
				e = new Employee(rS.getString(4), rS.getString(5), rS.getString(2), rS.getString(3));
				e.setId(rS.getInt(1));
				Users.forceCounterDown(); //and prevents our id generator logic in Car.java from misbehaving
				uMap.put(rS.getString(4), e);
			}
		}
		rS.close();
		conn.close();
		return (HashMap<String, Users>) uMap;
	}

	@Override
	public void pushOfferMap() throws SQLException {
		
		Map<Integer, Offer> diffOffer = grabOfferMap();
		for(Offer o : diffOffer.values()) {
			//System.out.println("diffoffer "+o.getId()+" "+o.getStatus());
		}
		for (Offer o : Dealership.offers.values()) {
			//System.out.println("allDealerOffers: "+o.getId()+" "+o.getStatus());
			//System.out.println("Inserting Offer: "+o.getId()+" status: "+ o.getStatus()+ "isIn DB: "+diffOffer.containsKey(o.getId()));
		    if(!diffOffer.containsKey(o.getId())) {
		    	insertOffer(o);
		    } 
		}
	}
	
	private void insertOffer(Offer o) throws SQLException {
		Connection conn = cF.getConnection();
		String sql = "INSERT INTO OFFER VALUES ("+o.getId()+","+o.getStatus()+","+o.getCar().getId()+","+
				o.getOfferAmmount()+","+o.getUserThatMadeOffer().getUserID()+","+o.getPaymentsRemaining()+","+o.getInterestRate()+")";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeQuery();
		ps.close();
		conn.close();
	}
	
	//Where Offer status 0=pending, 1=accepted, 2=rejected
	public void makePaymentOnOffer(Offer o, int status) throws SQLException {
		int customerID = o.getUserThatMadeOffer().getUserID();
		Connection conn = cF.getConnection();
		String sql = "UPDATE OFFER SET OWNER_CUSTOMER = "+customerID+"WHERE OFFER_ID = "+o.getId();
		CallableStatement call = conn.prepareCall(sql);
		call.execute();
		conn.close();
	}
	
	//call this to update DB with new payments left
	public void updateOfferPayments(Offer o) throws SQLException{
		Connection conn = cF.getConnection();
		String sql = "UPDATE OFFER SET PAYMENTS_LEFT = "+o.getPaymentsRemaining()+"WHERE OFFER_ID = "+o.getId();
		CallableStatement call = conn.prepareCall(sql);
		call.execute();
		conn.close();
	}

	@Override
	public HashMap<Integer, Offer> grabOfferMap() throws SQLException {
		HashMap<Integer, Offer> oMap = new HashMap<Integer, Offer>();
		Connection conn = cF.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rS = stmt.executeQuery("SELECT * FROM OFFER");
		Offer o = null;

		while(rS.next()) {
			Customer cThatMadeOffer = (Customer) Dealership.userMap.get(new Integer(rS.getInt(5)));
			Car attached = Dealership.carMap.get(new Integer(rS.getInt(3)));
			o = new Offer(attached, rS.getInt(4),cThatMadeOffer,rS.getInt(6),rS.getInt(7));
			o.setId(rS.getInt(1)); //sets ID to the one stored in the DB manually,
			
			o.setStatus(rS.getInt(2));
			oMap.put(new Integer(o.getId()), o);
		}
		rS.close();
		conn.close();
		
		return oMap;
	}
	
	public int getMaxCarID() throws SQLException {
		int maxCarId = 0;
		Connection conn = cF.getConnection();
		String sql = "SELECT MAX(CAR_VIM) FROM CAR";
		Statement call = conn.createStatement();
		ResultSet rS = call.executeQuery(sql);
		rS.next();
		maxCarId = rS.getInt(1);
		rS.close();
		conn.close();
		return maxCarId;
	}
	
	public int getMaxUserID() throws SQLException {
		int maxId = 0;
		Connection conn = cF.getConnection();
		String sql = "SELECT MAX(USER_ID) FROM DEALERSHIP_USER";
		Statement call = conn.createStatement();
		ResultSet rS = call.executeQuery(sql);
		rS.next();
		maxId = rS.getInt(1);
		rS.close();
		conn.close();
		return maxId;
	}
	
	public int getMaxOfferID() throws SQLException {
		int maxId = 0;
		Connection conn = cF.getConnection();
		String sql = "SELECT MAX(OFFER_ID) FROM OFFER";
		Statement call = conn.createStatement();
		ResultSet rS = call.executeQuery(sql);
		rS.next();
		maxId = rS.getInt(1);
		rS.close();
		conn.close();
		return maxId;
	}

}
