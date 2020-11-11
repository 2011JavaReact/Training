//package must be first; note that this is before imports or 
//class declaration
package com.revature.HelloWorld;
//so in Java you can create a single-line comment using the '//'
//any text proceeding a comment will not be executed

//if we wanted to import anything we would do it here
//import java.lang.*;// technically, we don't need this particular import since
//this package is always imported in every class that we write
//note the use of the *. This indicates that we want to import ALL classes from the
//java.lang package

//you can only have 1 public class per file
//However, you can have as many non-public classes as you would like (0 to many)
//The name of your public class must match the file name
public class Hello {
	//to run or execute a file, we need a main mehtod with matching method signature:
	public static void main(String[] args) {
		System.out.println("Hello, World!");
		Hello hello = new Hello();
	}
	
	//- single line comment
	/*
	 *  - multi line comment
	 */
	
	/**
	 * Java doc comment - these will show up when documentation is generated from this
	 * source code
	 */
	
	//the following is a constructor; it will be called upon instantiation of an object
	public Hello() {
		System.out.println("Hello Class Constructor");
	}
}
