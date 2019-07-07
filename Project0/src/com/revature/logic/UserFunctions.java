package com.revature.logic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.revature.beans.Car;
import com.revature.beans.Dealership;

public abstract class UserFunctions {
	
	public Collection<Car> getCarsInLot(){
		
		Map<Integer, Car> temp = new HashMap<>();
		for(Car c : Dealership.carMap.values()){
			if(c.getOwner() == null){
				temp.put(c.getId(), c);
			}
		}
		return (Collection<Car>) temp;
	} 
	
	
	
}
