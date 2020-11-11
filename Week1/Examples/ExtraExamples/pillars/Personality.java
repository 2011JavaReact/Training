package com.revature.pillars;
import java.io.*;
/*
 * BEANS
 * -Beans are a design pattern that, like the POJO, aims to represent data and state.
 * -The difference between the two is that Beans follow a strict naming convention,
 * and have a few other additional rules:
 * 	-All getters and setters must be named getVarName/setVarName
 * 	-All beans must have a no args constructor
 * 	-All beans should override toString
 * 	-implement Serializable
 * 	-override equals() and hashCode()
 * -The reason for these restrictions is that there exists frameworks that assume
 * the names of your getters and setter so that it can connect and use them for you.
 * As well as create instances of these beans without you having to do so. In addition,
 * this process sometimes requires the use of a no args constructor
 */

//Serializable is a marker interface. It does not enforce any behaviours, yet
//only members of Serializable are allowed to be serialized
public class Personality implements Serializable{
	private String type;
	private int intensity;
	
	
	public Personality() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Personality(String type, int intensity) {
		super();
		this.type = type;
		this.intensity = intensity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getIntensity() {
		return intensity;
	}
	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}
	@Override
	public String toString() {
		return "Personality [type=" + type + ", intensity=" + intensity + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + intensity;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Personality other = (Personality) obj;
		if (intensity != other.intensity)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	
	
	
}
