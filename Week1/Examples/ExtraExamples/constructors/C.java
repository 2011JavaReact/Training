package com.revature.constructors;

public class C extends B{
	private int myNumber;
	
	public C() {
		System.out.println("Printing from inside C's no-arg constructor");
	}
	
	public C(int myNumber) {
		super(myNumber);
		System.out.println("Inside the 1-arg constructor of C");
		this.myNumber = myNumber;
	}
}
