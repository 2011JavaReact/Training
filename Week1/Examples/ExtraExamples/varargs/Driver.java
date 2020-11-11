package com.revature.varargs;

public class Driver {

	public static void main(String[] args) {
		Driver driver = new Driver();
//		System.out.println(driver.sum());
		System.out.println(driver.sum(1));
		System.out.println(driver.sum(1,2));
		System.out.println(driver.sum(1,2,3));
		System.out.println(driver.sum(1,2,3,4));
		

	}
	
	public int sum(int a, int b) {
		System.out.println("non var args");
		return a + b;
	}
	
	public int sum(int a, int b, int c) {
		System.out.println("non var args");
		return a + b + c;
	}
	
	/*
	 * When you use vararg, you are telling the method to expect a VARIABLE number of
	 * ARGUMENTS. Note that this number of arguments can be any number between 0 and many
	 * It basically allows for multiple arguments and follows the following syntax:
	 * variable-type...name-of-array
	 * The variables are placed inside of an array of the type that is specified before
	 * the ...
	 */
	
	public int sum(int a,int ...nums) {
		int result = 0;
		for(int i: nums) {
			result += i;
		}
		return result;
	}
	
	//note that var args must come last in your list of parameters
	//note that you can only use varargs once as a parameter

}
