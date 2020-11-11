package com.revature.junit;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/*
 * JUnit is a java unit testing tool.
 * Unit testing is the most micro level of testing where we take the individual 
 * methods and components and execute them to ensure we get expected output.
 * Typically these tests are run before you deploy your code.
 * They will usually run on the compiled code itself, so requiring deployment is not
 * necessary.
 */
public class Annotations {

	/*
	 * Before class will be the first method called regardless of others.
	 * This method should be used to prepare the global test environment.
	 * (Such as setting up constants for your tests)
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BEFORE CLASS");
	}

	/*
	 * After Class will be executed last. It should be used to clean up test data if any
	 * were created. e.g. Previous tests inserted trash into the database, use this method
	 * to delete all trash data from the database in order to keep it clean and tidy.
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AFTER CLASS");
	}

	/*
	 * Before is executed before every test case (Or test annotation)
	 * It should be used to reset instances that are used be each test.
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("BEFORE");
	}

	/*
	 * After is executed after each individual test (or test annotation) and should be 
	 * used for cleaning of instances that were used by prior tests.
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("AFTER");
	}

	/*
	 * Test is the actual test case and should either pass or fail. The total result
	 * summary is based off the amount of @Test you have in your test class.
	 */
	@Test
	public void test1() {
		System.out.println("TEST1");
		fail("Not yet implemented");
	}
	@Test
	public void test2() {
		System.out.println("TEST2");
		fail("Not yet implemented");
	}
	@Test
	public void test3() {
		System.out.println("TEST3");
		fail("Not yet implemented");
	}

}
