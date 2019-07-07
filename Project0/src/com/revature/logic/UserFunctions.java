package com.revature.logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.revature.beans.Car;
import com.revature.beans.Dealership;

public abstract class UserFunctions {
	
	public Collection<Car> getCarsInLot(){
		
		List<Car> temp = new ArrayList<>();
		for(Car c : Dealership.carMap.values()){
			if(c.getOwner() == null){
				temp.add(c);
			}
		}
		return temp;
	} 
	
	
	
}
