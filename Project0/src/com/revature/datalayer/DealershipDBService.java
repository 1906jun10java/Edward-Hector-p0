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
import com.revature.conn.ConnFactory;

public class DealershipDBService implements DealershipDao {
	public static ConnFactory cF = ConnFactory.getInstance();

	//might just make the whole thing static
	public static void main(String[] args) {
		DealershipDBService dbsrv = new DealershipDBService();
		/*
		 * DealershipDBService dbsrv = new DealershipDBService(); 
		 * Car testCar = new
		 * Car("Paddy","Wagon","green", 2010,10000d); Car testCar2 = new
		 * Car("Paddy","Wagon2","black", 1999,9000d); Car testCar3 = new
		 * Car("Parick","Wagon3","silver", 2012,12000d); Car testCar4 = new
		 * Car("Paddy","Wagon4","orange", 2011,14000d); Customer testCust = new
		 * Customer("testman","testpass","Test","Man");
		 * 
		 * Dealership.userMap.put(testCust.getUserID(), testCust);
		 * testCar2.setOwner(testCust); //No users, means no fk, means no entry
		 * Dealership.carMap.put(testCar.getId(), testCar);
		 * Dealership.carMap.put(testCar2.getId(), testCar2);
		 * Dealership.carMap.put(testCar3.getId(), testCar3);
		 * Dealership.carMap.put(testCar4.getId(), testCar4);
		 * testCar4.setOwner(testCust); Offer testOffer = new Offer(testCar, 15000,
		 * testCust, 24, 2.5d); Dealership.offerMap.put(new Integer(testOffer.getId()),
		 * testOffer);
		 * 
		 * try { dbsrv.pushUserMap(); dbsrv.pushCarMap(); dbsrv.pushOfferMap(); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * testOffer.setPaymentsRemaining(testOffer.getPaymentsRemaining()-1); try {
		 * dbsrv.updateOfferPayments(testOffer); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * System.out.println(testOffer.getNumberOfPayments());
		 * System.out.println("Done with main()");
		 */
		
		try {
			Dealership.userMap = dbsrv.grabUserMap();
			Dealership.carMap = dbsrv.grabCarMap();
			Dealership.offerMap = dbsrv.grabOfferMap();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Offer o: Dealership.offerMap.values()) {
			o.setPaymentsRemaining(o.getPaymentsRemaining()-1);
			try {
				dbsrv.updateOfferPayments(o);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(o.toString());
		}
		System.out.println("Done printing offers");
		for(Car c: Dealership.carMap.values()) {
			if(c.getOwner() != null) {
				System.out.println(c.getId()+" "+c.getMake()+" "+c.getModel()+" Ownedby: "+c.getOwner().getUserName());
			} else {
				System.out.println(c.getId()+" "+c.getMake()+" "+c.getModel()+" Ownedby: DEALERSHIP");
			}
		}
		System.out.println("Done printing cars");
		for(Users u : Dealership.userMap.values()) {
			System.out.println(u.getUserName()+" is "+u.getUserType());
		}
	}
	
	@Override
	//To be called to push the current carMap in the Dealership into the database
	public void pushCarMap() throws SQLException {
		Map<Integer,Car> diffCars = grabCarMap();
		for(Car c : diffCars.values()) {
			//System.out.println(c.getId()+" "+c.getModel());
		}
		for (Car c : Dealership.carMap.values()) {
			//System.out.println("allDealerCars: "+c.getId()+" "+c.getModel());
		    if(diffCars.containsValue(c)) {
		    	if(c.getOwnerId() != -1) {
		    		updateCar(c, c.getOwnerId());
		    	}
		    } else {
		    	insertCar(c);
		    	//TODO clean this up later if need be
		    	if(c.getOwnerId() != -1) {
		    		updateCar(c, c.getOwnerId());
		    	}
		    }
		}
	}
	
	//when inserting a car into the DB, it should (as per getOwnerID()) add it with an owner of Dealership
	private void insertCar(Car c)  throws SQLException {
		Connection conn = cF.getConnection();
		String sql = "INSERT INTO CAR VALUES ("+c.getId()+",'"+c.getMake()+"','"+c.getModel()+"','"+
		c.getColor()+"',"+c.getMakeYear()+","+c.getMsrp()+","+c.getOwnerId()+")";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeQuery();
	}
	
	//to be called updating a car, id is the ID of the Customer which owns that car
	private void updateCar(Car c, int id) throws SQLException {
		//System.out.println("in update car");
		Connection conn = cF.getConnection();
		String sql = "UPDATE CAR SET OWNER_ID = "+id+"WHERE CAR_VIM = "+c.getId();
		CallableStatement call = conn.prepareCall(sql);
		call.execute();
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
			c.setId(rS.getInt(1)); //sets ID to the one stored in the DB manually,
			Car.forceCounterDown(); //and prevents our id generator logic in Car.java from misbehaving
			if(rS.getInt(7) == -1) {
				c.setOwner(null);
			}
			c.setOwner(Dealership.userMap.get(new Integer (rS.getInt(7))));
			cMap.put(new Integer(c.getId()), c);
		}
		
		return cMap;
	}

	@Override
	public void pushUserMap() throws SQLException {
		
		Map<Integer, Users> diffCust = grabUserMap();
		for(Users u : diffCust.values()) {
			//System.out.println("diffCust "+u.getUserName()+" "+u.getUserID());
		}
		for (Users u : Dealership.userMap.values()) {
			//System.out.println("allDealerCust: "+u.getUserName()+" "+u.getUserID());
		    if(!diffCust.containsValue(u)) {
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
	}

	private void insertUser(Users u) throws SQLException {
		Connection conn = cF.getConnection();
		String sql = "INSERT INTO DEALERSHIP_USER VALUES ("+u.getUserID()+",'"+u.getFirstName()+"','"+u.getLastName()+"','"+
		u.getUserName()+"','"+u.getPassword()+"',"+0+")";
		//System.out.println("CUSTOMER: \n"+ sql);
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeQuery();
		
	}

	@Override
	public HashMap<Integer, Users> grabUserMap() throws SQLException {
		HashMap<Integer, Users> uMap = new HashMap<Integer, Users>();
		Connection conn = cF.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rS = stmt.executeQuery("SELECT * FROM DEALERSHIP_USER");
		Customer c = null;
		Employee e = null;
		//TODO add if statement depending on rS.getInt(6)
		while(rS.next()) {
			if (rS.getInt(6) == 0) {
				c = new Customer(rS.getString(4), rS.getString(5), rS.getString(2), rS.getString(3));
				c.setId(rS.getInt(1)); //sets ID to the one stored in the DB manually,
				Users.forceCounterDown(); //and prevents our id generator logic in Car.java from misbehaving
				uMap.put(new Integer(c.getUserID()), c);
			} else if (rS.getInt(6) == 1){
				e = new Employee(rS.getString(4), rS.getString(5), rS.getString(2), rS.getString(3));
				e.setId(rS.getInt(1));
				Users.forceCounterDown(); //and prevents our id generator logic in Car.java from misbehaving
				uMap.put(new Integer(e.getUserID()), e);
			}
		}
		
		return uMap;
	}

	@Override
	public void pushOfferMap() throws SQLException {
		
		Map<Integer, Offer> diffOffer = grabOfferMap();
		for(Offer o : diffOffer.values()) {
			System.out.println("diffoffer "+o.getId()+" "+o.getStatus());
		}
		for (Offer o : Dealership.offerMap.values()) {
			System.out.println("allDealerOffers: "+o.getId()+" "+o.getStatus());
		    if(!diffOffer.containsValue(o)) {
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
	}
	
	//Where Offer status 0=pending, 1=accepted, 2=rejected
	public void makePaymentOnOffer(Offer o, int status) throws SQLException {
		int customerID = o.getUserThatMadeOffer().getUserID();
		Connection conn = cF.getConnection();
		String sql = "UPDATE OFFER SET OWNER_CUSTOMER = "+customerID+"WHERE OFFER_ID = "+o.getId();
		CallableStatement call = conn.prepareCall(sql);
		call.execute();
	}
	
	//call this to update DB with new payments left
	public void updateOfferPayments(Offer o) throws SQLException{
		Connection conn = cF.getConnection();
		String sql = "UPDATE OFFER SET PAYMENTS_LEFT = "+o.getPaymentsRemaining()+"WHERE OFFER_ID = "+o.getId();
		CallableStatement call = conn.prepareCall(sql);
		call.execute();
	}

	@Override
	public HashMap<Integer, Offer> grabOfferMap() throws SQLException {
		HashMap<Integer, Offer> oMap = new HashMap<Integer, Offer>();
		Connection conn = cF.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rS = stmt.executeQuery("SELECT * FROM OFFER");
		Offer o = null;
		//TODO add if statement depending on rS.getInt(6)
		while(rS.next()) {
			Customer cThatMadeOffer = (Customer) Dealership.userMap.get(new Integer(rS.getInt(5)));
			Car attached = Dealership.carMap.get(new Integer(rS.getInt(3)));
			
			o = new Offer(attached, rS.getInt(4),cThatMadeOffer,rS.getInt(6),rS.getInt(7));
			o.setId(rS.getInt(1)); //sets ID to the one stored in the DB manually,
			Offer.forceCounterDown(); //and prevents our id generator logic in Offer.java from misbehaving
			oMap.put(new Integer(o.getId()), o);
		}
		return oMap;
	}

}