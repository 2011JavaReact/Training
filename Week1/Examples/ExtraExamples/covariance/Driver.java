package com.revature.covariance;

public class Driver {

	public static void main(String[] args) {
		X x = new X();
		Y y = new Y();
		SevenTeen z = new SevenTeen();
		
		System.out.println("================");
		System.out.println(x.field);
		System.out.println(y.field);
		System.out.println(z.field);
		
		x.method1();
		y.method1();
		z.method1();

		System.out.println("================");
		X x2 = new SevenTeen();
		System.out.println(x2.field);
		x2.method1();
	}

}
