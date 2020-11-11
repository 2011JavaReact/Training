package com.revature.constructors;

public class B extends A{
	
	private int myNumber;
	
	public B() {
		System.out.println("Printing from inside B's no-args constructor");
	}
	
	public B(int myNumber) {
		super(myNumber);
		System.out.println("Inside the 1-arg consturctor of B");
		this.myNumber = myNumber;
	}
}
