package com.revature.beans;

import java.util.HashMap;
import java.util.Map;

public class Dealership {
	public static Employee systemEmp = new Employee();
	
	public static Map<Integer,Car> carMap = new HashMap<>();
	
	public static Map<String,Employee> employeeMap = new HashMap<>();
	
	public static Map<String,Customer> customerMap = new HashMap<>();
	
	public static Map<Integer,Offer> pendingOffers = new HashMap<>();
	
	public static Map<Integer,Offer> acceptedOffers = new HashMap<>();
	
	public static Map<Integer,Offer> rejectedOffers = new HashMap<>();
	
}
