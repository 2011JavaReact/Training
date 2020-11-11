package com.revature.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ArithmeticTest {
	Arithmetic a = null;
	
	
	@Before
	public void setUp() {
		a = new Arithmetic();
	}
	@After
	public void tearDown() {
		a = null;
	}
	
	@Test
	public void testMultiply() {
		assertEquals(25, a.multiplication(5,5)); //checks to see if output of method
		//is what we expected it to be
	}
	
	@Test
	public void testDivision() {
		assertEquals(20, a.division(100,5)); 
	}
	
	/*
	 * Using the expected key/value pair inside of a test annotation will
	 * make it so the test ONLY passes if the exception mentioned occurs
	 */

	@Test(expected=ArithmeticException.class)
	//the annotation above expects the result of the test to be a member of the
	//ArithmeticException class
	public void testDivBy0() {
		a.division(25,0);
	}
	
	@Ignore// ignores the following test
	@Test(timeout=3000)//this test will be allowed to run for 3 seconds
	//if it takes longer, it will fail
	public void timeWaster() {
		while(true) {}
	}
	/*
	 * Different assertions:
	 * -assertEquals
	 * -assertNotEquals
	 * -assertNull
	 * -assertNotNull
	 * -assertArrayEquals
	 * -assertTrue
	 * -assertFalse
	 */
	
}
