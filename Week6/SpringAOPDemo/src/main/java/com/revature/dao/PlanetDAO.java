package com.revature.dao;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.revature.model.Planet;

@Component
public class PlanetDAO {

	private String name;
	private int id;
	
	public Planet getPlanetById(int id) throws Exception {
		
		if (id == 0) {
			throw new Exception("An exception occurred");
		}
		
		System.out.println("PlanetDAO getPlanetById(int) invoked");
		return new Planet("earth", 100.5, 13.9);
	}
	
	public Planet addPlanet(Planet planet) throws InterruptedException {
		
		TimeUnit.SECONDS.sleep(5);
		System.out.println("Adding planet");
		
		return planet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
