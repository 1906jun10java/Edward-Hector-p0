package com.revature.beans;

import java.util.HashMap;
import java.util.Map;

public class Dealership {
	public static Employee system = new Employee();
	
	public static Map<Integer,Car> carMap = new HashMap<>();
	
	public static Map<Integer,Users> userMap = new HashMap<>();
	
	public static Map<Integer,Offer> offerMap = new HashMap<>();
}
