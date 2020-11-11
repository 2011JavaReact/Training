package com.revature.pillars;

import java.io.Serializable;

public class Ocelot extends Animal implements Serializable{
	/*
	 * The fact that the Ocelot extends animal means that the bear "IS-A" animal.
	 * The fact that the Ocelot has a field called personality, means that an animal
	 * "HAS-A" personality.
	 */
	String name;
	Personality personality;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Personality getPersonality() {
		return personality;
	}

	public void setPersonality(Personality personality) {
		this.personality = personality;
	}

	@Override
	public String toString() {
		return "Ocelot [name=" + name + ", personality=" + personality + "]";
	}

	public Ocelot(String name, Personality personality) {
		super(); //when we call super() we are calling on the constructor for the
		//parent class
		//note that if you wanted to call on a constructor for the current class,
		//you could do so with this().
		//the first line of a constructor is always super() or this() (it may have
		//arguments)
		this.name = name;
		this.personality = personality;
	}

	public Ocelot() {
		super();
		// TODO Auto-generated constructor stub
	}

	//The methods below must be overriden by the Ocelot class due to the fact that
	//it inherits from the Animal class and the huggable interface
	
	//Below we have Override preceded by an "@" symbol.
	/*
	 * This is known as an annotation. It provides metadata and additional checks
	 * for Java applications. In the case of @Override, it tells us that the below
	 * implementation is changing existing methods that were inherited. It is an
	 * optional annotation, but provides additional assurance that we are indeed
	 * overriding the method of a parent rather than creating our own, misspelled
	 * version of the intended method.
	 */
	@Override
	public String receiveHug() {
		return "I am " + name + " so I will now maul your face with "
				+ "this much enthusiasm:" + personality.getIntensity();
	}

	@Override
	public String speak() {
		return "I " + personality.getType() + "-ily say HI!";
	}

}
