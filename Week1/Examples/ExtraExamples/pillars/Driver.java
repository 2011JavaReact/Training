package com.revature.pillars;

public class Driver {

	public static void main(String[] args) {
		Personality p = new Personality("Cheek", 76);
		Ocelot revolver = new Ocelot("Revolver",p);
		System.out.println(revolver.receiveHug());
		System.out.println(revolver.eat());
		System.out.println(revolver.speak());

	}

}
