package com.revature.constructors;

public class A {
	private int myNumber;
	
	public A() {
		//here the call to super is implicit
		System.out.println("Printing from A's no-args constructor");
	}
	
	public A(int number) {
		//super() refers to the parent class constructor, which in this case is just
		//Object()
		super();// if we do not do this one here, Java will do it for us
		System.out.println("Inside A's 1-arg constructor");
		this.myNumber = number;
	}
}
