package com.revature.beans;

public class Car {
	
	
	private String make;
	private String model;
	private String color;
	private int makeYear;
	private double msrp;
	private int id;
	private static int ID=0;
	private Users owner;
	
	
	public Car() {
		super();
	}
	
	

	public Car(String make, String model, String color, int makeYear, double msrp) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.makeYear = makeYear;
		this.msrp = msrp;
		this.id=ID;
		ID++;
	}



	public int getId() {
		return id;
	}


	public String getMake() {
		return make;
	}


	public String getModel() {
		return model;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMakeYear() {
		return makeYear;
	}

	public double getMsrp() {
		return msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}

	
	public Users getOwner() {
		return owner;
	}



	public void setOwner(Users owner) {
		this.owner = owner;
	}



	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", color=" + color + ", makeYear=" + makeYear + ", msrp="
				+ msrp + ", id=" + id + ", owner=" + owner + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + id;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + makeYear;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(msrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (id != other.id)
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (makeYear != other.makeYear)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(msrp) != Double.doubleToLongBits(other.msrp))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

	public void setId(int int1) {
		this.id = int1;
		
	}

	public static void forceCounterDown() {
		ID--;
	}
	
}
	
