package com.revature.dto;

public class PlanetDTO {

	private String name;
	private double mass;
	private double temperature;
	
	public PlanetDTO() {
		super();
	}

	public PlanetDTO(String name, double mass, double temperature) {
		super();
		this.name = name;
		this.mass = mass;
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

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
}
