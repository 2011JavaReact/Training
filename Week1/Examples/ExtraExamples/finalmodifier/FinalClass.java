package com.revature.finalmodifier;

public final class FinalClass {
/*
 * final classes cannot be inherited
 */
	final int finalField = 10;
	/*
	 * Final fields cannot be reassigned after being assigned.
	 */
	public void mehtod1() {
//		finalField = 9; can't do this because the variable is final and cannot be
//		reassigned
	}
	
	public final void method2() {
		/*
		 * final methods cannot be overridden
		 */
	}
}
