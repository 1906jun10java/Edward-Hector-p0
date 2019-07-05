package com.revature.beans;

import java.util.HashMap;
import java.util.Map;

public class Dealership {
	public static Employee systemEmp = new Employee();
	
	public static Map<Integer,Car> carMap = new HashMap<>();
	
	//To be changed to user map
	public static Map<String,Employee> employeeMap = new HashMap<>();
	
	public static Map<String,Users> userMap = new HashMap();
	
	public static Map<Integer,Offer> offerMap = new HashMap<>();
}
