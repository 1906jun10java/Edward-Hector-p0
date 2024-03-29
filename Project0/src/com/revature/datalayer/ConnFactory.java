package com.revature.datalayer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
//This is a singleton factory
	private static ConnFactory cF = new ConnFactory();
	
	private ConnFactory() {
		//super();
	}
	//synchronized because we want only ONE to exist at a time
	public static synchronized ConnFactory getInstance() {
		if(cF == null) {
			cF = new ConnFactory();
		}
		return cF;
	}
	
	public Connection getConnection() {
		//System.out.println("in getConnection");
		Connection conn = null;
		//it is the DriverManager that gives us a connection DriverManager.getConnection(url, username, password)
		Properties props = new Properties();
		try {
			props.load(new FileReader("database.properties"));
			//We can read in a file, in this case we made a databse.properties file and are passing it in
			//via a Properties object (which uses a file reader to read the actual file).
			
			Class.forName(props.getProperty("driver"));
			conn = DriverManager.getConnection(props.getProperty("url"), 
					props.getProperty("usr"), props.getProperty("password"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//This static method was added so that it could be used with log4j2, which needs a way to get a Connection
	//without having to create an instance of a ConnFactory.
	public static Connection getLoggerConnection() {
		Connection conn = null;
		Properties props = new Properties();
		try {
			props.load(new FileReader("database.properties"));
			Class.forName(props.getProperty("driver"));
			conn = DriverManager.getConnection(props.getProperty("url"), 
					props.getProperty("usr"), props.getProperty("password"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
