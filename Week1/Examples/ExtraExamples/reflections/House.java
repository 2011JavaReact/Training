package com.revature.reflections;

public class House {
	private String color;
	private String address;
	
	
	public House() {
		color = "red";
		address = "123 street street";
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	private void secret() {
		System.out.println("The key is under the flower pot");
	}
}
