package com.revature.constructors;

public class Driver {

	public static void main(String[] args) {
		A a = new A(5);
		System.out.println("===============");
		System.out.println("When constructor of B is invoked, it calls Constructor of A");
		B b = new B(10);
		System.out.println("===============");
		System.out.println("When constructor of C is invoked, it calls Constructor of B");
		System.out.println("And also the constructor of A");
		C c = new C(8);

	}

}
