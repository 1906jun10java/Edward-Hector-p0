package proj0.beans;

import java.util.HashMap;
import java.util.Map;

public class Car {
	private int vin;
	private int year;
	private int price; //stores the value of the listed price of the car, modifiable only by employees
	private int soldFor; //stores the value of the accepted offer
	private String make;
	private String model;
	private String color;
	private Map<Customer, Integer> currentOffers; 
	
	public Car(int vin, int year, int price, String make, String model, String color) {
		super();
		this.vin = vin;
		this.year = year;
		this.price = price;
		this.make = make;
		this.model = model;
		this.color = color;
		currentOffers = new HashMap<>();
	}

	public int getVin() {
		return vin;
	}

	public void setVin(int vin) {
		this.vin = vin;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
