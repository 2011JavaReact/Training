package com.revature.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "planet")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Planet {

	// Specify this field as the Id for our entity, as well as allowing for auto incrementation
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "planet_id")
	private int id;
	
	@Column(name = "temperature")
	private double temperature;
	
	@Column(name = "name", length = 255)
	private String name;
	
	@Column(name = "mass")
	private double mass;
	
	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "planet_detail_id")
	private PlanetDetail planetDetail;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Satellite> satellites;
	
	// You will need to create a no-args constructor in order for Hibernate to be able to properly instantiate the objects that are mapped
	public Planet() {
		super();
	}
	
	public Planet(double temperature, String name, double mass) {
		this.temperature = temperature;
		this.name = name;
		this.mass = mass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public PlanetDetail getPlanetDetail() {
		return planetDetail;
	}

	public void setPlanetDetail(PlanetDetail planetDetail) {
		this.planetDetail = planetDetail;
	}

	public List<Satellite> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<Satellite> satellites) {
		this.satellites = satellites;
	}
	
	public void addSatellite(Satellite satellite) {
		if (this.satellites == null) {
			this.satellites = new ArrayList<>();
		}
		
		this.satellites.add(satellite);
	}

	@Override
	public String toString() {
		return "Planet [id=" + id + ", temperature=" + temperature + ", name=" + name + ", mass=" + mass
				+ ", planetDetail=" + planetDetail + "]";
	}

}
