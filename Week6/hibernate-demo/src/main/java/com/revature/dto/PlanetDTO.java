package com.revature.dto;

public class PlanetDTO {
	
	private double temperature;
	
	private String name;
	
	private double mass;

	public PlanetDTO() {
		super();
	}

	public PlanetDTO(double temperature, String name, double mass) {
		super();
		this.temperature = temperature;
		this.name = name;
		this.mass = mass;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	@Override
	public String toString() {
		return "PlanetDTO [temperature=" + temperature + ", name=" + name + ", mass=" + mass + "]";
	}

}
