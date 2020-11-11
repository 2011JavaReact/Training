package com.revature.designpatterns;
import static com.revature.designpatterns.SingletonObject.getSingleton;

/*
 * Use static imports in order to bring in static methods for use without having
 * to invoke them through the classname directly
 */


public class Driver {

	public static void main(String[] args) {
		SingletonObject so1 = getSingleton();
		SingletonObject so2 = getSingleton();
		
		System.out.println(so1 == so2);
		
		System.out.println("====FACTORY====");
		ShapeFactory sf = new ShapeFactory();
		sf.getShape("circle").draw();
		sf.getShape("OCTAGON").draw();
		sf.getShape("QuadRANgle").draw();
	}

}
