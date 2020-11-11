package com.revature.serialization;

import java.io.Serializable;

public class Cereal implements Serializable{
	private String name;
	private float price;
	public Cereal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cereal(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Cereal [name=" + name + ", price=" + price + "]";
	}
	
}
