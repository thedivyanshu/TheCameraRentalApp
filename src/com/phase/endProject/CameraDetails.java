package com.phase.endProject;

public class CameraDetails {
	private int id;
	private String name;
	private String model;
	private double rentalPrice;
	private boolean available;
	private String renter; 

	public CameraDetails(int id,String name, String model, double rentalPrice,boolean available) {
		this.id=id;
		this.name = name;
		this.model = model;
		this.rentalPrice = rentalPrice;
		this.available = true;
		this.renter = null; 
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getRenter() {
		return renter;
	}

	public void setRenter(String renter) {
		this.renter = renter;
	}
}
