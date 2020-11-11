package com.revature.wrapperclasses;

public class Driver {

	/*
	 * Primitive datatypes (all EIGHT) are NOT objects
	 * However, if this lack of object-ness leaves a hole in your heart,
	 * well then, we have good news for you.
	 * Java provides Wrapper Classes, which are Object representations of the primitive
	 * datatypes
	 * 
	 * To access them, simply write the datatype in its full name preceded with a
	 * capital letter
	 */
	
	Integer i = new Integer(5); // this creates a new integer object with a value of 5
	Double d;
	Character c;
	Boolean bool;
	
	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.printValues();
	}
	
	public void printValues() {
		System.out.println(i);
		i = 7;
		System.out.println(i);
		
		/*
		 * Autoboxing vs Auto-unboxing
		 * -Anytime you come across a method/execution that requires a Wrapper Class
		 * as input, if you provide a primitive value, it will implicitly wrap the
		 * primitive into its Wrapper Class without you having to explicitly do so.
		 * This conversion is called autoboxing.
		 * 
		 * Vice versa, if you pass a Wrapper class to a function requiring a primitive
		 * value, it will unwrap the class into its primitive for use in the method.
		 */
		System.out.println(Integer.parseInt("47") + Integer.parseInt("53"));
		
		System.out.println(Float.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);
	}

}
