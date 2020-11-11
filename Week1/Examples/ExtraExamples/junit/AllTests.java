package com.revature.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//A test suite is a grouping of test cases
//A test case is a grouping of test steps for testing a particular feature

@RunWith(Suite.class)//denotes that we are going to use a test suite
@SuiteClasses({ Annotations.class, ArithmeticTest.class, ArithmeticTest2.class })
//this denotes which tests are part of this testing suite
public class AllTests {

}
