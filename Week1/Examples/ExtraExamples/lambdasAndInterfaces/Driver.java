package com.revature.lambdasAndInterfaces;

public class Driver {
	public static void main(String[] args) {
		RedPanda rp = new RedPanda();
		rp.walk();
		
		Walkable walker = new Walkable() {
			public void walk() {
				System.out.println("Walking");
			}
			
			public void run() {
				
			}
		};
		walker.walk();
		
		Walkable lambda = () ->{}; {
			System.out.println("Lambda is lambda-ing");
		};		
		lambda.walk();
	}
}
