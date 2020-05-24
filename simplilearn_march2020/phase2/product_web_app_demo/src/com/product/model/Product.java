package com.product.model;

public class Product {

	private int id;
	private String name;
	private double cost;
	private float rating;
	private String manufacturerName;
	private String uniqueId;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public Product(String name, double cost, float rating, String manufacturerName) {
		super();
		this.name = name;
		this.cost = cost;
		this.rating = rating;
		this.manufacturerName = manufacturerName;
	}

	public Product(int id, String name, double cost, float rating, String manufacturerName) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.rating = rating;
		this.manufacturerName = manufacturerName;
	}

	

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", rating=" + rating + ", manufacturerName="
				+ manufacturerName + ", uniqueId=" + uniqueId + "]";
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	
}
