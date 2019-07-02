package com.revature.logic;

import java.util.Collection;

import com.revature.beans.Car;
import com.revature.beans.Dealership;

public abstract class UserFunctions {
	
	public Collection<Car> getCarsInLot(){
		
		return Dealership.carMap.values();
	} 
	
	
	
}
