package com.revature.exceptions;

import java.io.FileNotFoundException;

public class Driver {

	public static void main(String[] args) {
		System.out.println("=====APP START====");
		Driver driver = new Driver();
		System.out.println(driver.somethingWeird());
//		driver.divideByZero();
//		driver.divideByZeroHandled();
//		throw new FileNotFoundException(); //note that in Java you can cause an exception to occur
		//by throwing it
		//The exception above is a checked exception, so the compiler will demand that we
		//handle it
//		throw new ArithmeticException();// the compiler will not require us to handle this
	}
	
	public void divideByZero() {
		System.out.println(1/0);
	}
	
	public void divideByZeroHandled() {
		/*
		 * An exception is described as an incident where something unexpected occurs.
		 * The application behaves in a manner it hsould not
		 * 
		 * Exceptions are NOT errors.
		 * An error is described as an incident that cannot reasonably be recovered from
		 */
		
		
		//you can handle an exception using a try-catch block
		try {// in the try block, you will put the code that could potentially cause
			//an exception
			//place risky code here
			
			System.out.println(1/0);
		}catch(ArithmeticException e) {//as our argument for the catch block, 
			//we want to put the exception we
			//are looking out for. Note that you are allowed to put a more general
			//exception as well
			e.printStackTrace();
			System.out.println("Caught IT!");			
		}finally {//this is optional
			/*
			 * This block will ALWAYS execute.
			 * If the exception does not occur, finally WILL execute
			 * If the exception DOES occur, finally WILL execute.
			 * If an exception, I did not properly catch occurs and crashes the app,
			 * Finally will execute
			 * You cannot stop finally except in the following edge circumstances:
			 * 1)you invoke System.exit(0)
			 * 2)If an Error occurs
			 * *)Infinite Loop
			 */
			System.out.println("===Finally Executes===");
		}
	}
	
	public void goodHandling() {
		try {
			/*
			 * If you want, you may have multiple try catch blocks. you need to catch
			 * them in order from most specific to least specific.
			 * Or more to the point, you cannot have a parent exception caught before a
			 * child.
			 */
		}catch(ArithmeticException e) {
			e.printStackTrace();
		}catch(NullPointerException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}catch(Error e) {//you can do this, but it is a bad idea
			e.printStackTrace();
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void checkedException() throws FileNotFoundException {
		//use throw to trigger an exception of your choice. Either for custom exceptions
		//or testing purposes
		
		/*
		 * Checked exceptions (any exception that does not  inherit from RuntimeException)
		 * are exceptions that the compiler looks for during compile time. Should it find
		 * any risky code that risks a checked exception, a red squiggley line will be 
		 * shown until you handle the code such as the one shown  ^  there 
		 */
		
		//note that you can either handle the exception by addressing it with a try
		//catch block, or by "ducking" and adding throws FileNotFoundException in the
		//method signature... it will then have to be handled by the caller of the method
			throw new FileNotFoundException();
	}
	
	public void mehtod1() throws WilliamException {
		method2();
	}
	public void method2() throws WilliamException {
		method3();
	}
	public void method3() throws WilliamException {
		throw new WilliamException();
	}
	
	public String somethingWeird() {
		try {
			System.out.println(1/0);
			return "TRY";
		}catch(Exception e) {
			return "CATCH";
		}finally {
			return "FINALLY";
		}
	}
}
