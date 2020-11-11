package com.revature.pillars;

/*
 * Interfaces Vs Abstract Classes
 * -Both can have concrete and abstact methods (as of Java 8). But interfaces require
 * the keywords static or default in order to make concrete methods
 * -AS well both cannot be instantiated in a standalone instance.
 * -Classes can implement as many interfaces as you want
 * -Classes can extend only one class at most
 * -Interfaces are typically used for determining the type of behavior
 * that the children will have
 * - Any child class that implements an interface will be required to implement
 * actions as opposed to states
 */
public interface Huggable {
	/*
	 * Impliciit interface actions
	 * 
	 * All fields will be public, static, and final regardless of whether or not
	 * you include these keywords
	 * 
	 * All methods are public as well as abstract, barring the use of default or
	 * static.	
	 */
	
	int huggability = 10;
	
	public String receiveHug();
	
	public default void method() {
		System.out.println("Generic method in Interface");
	}
	
	public static void method2() {
		System.out.println("Sorry, I didn't mean it...");
	}
}
