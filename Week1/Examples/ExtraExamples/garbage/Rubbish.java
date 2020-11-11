package com.revature.garbage;

public class Rubbish {
	/*
	 * Java does not let you, the developer, handle memory. Java take full control of that
	 * itself. This is done using the Garbage Collector. An execution who serves only to
	 * ensure that we do not have any unreachable resources remaining. For example, 
	 * un-referred objects sitting around and cluttering up memory
	 * 
	 * Any object in Java is eligible for garbage collection if one fo the following criteria
	 * are met:
	 * -reference is reassigned
	 * -reference points to null
	 * -Scope of the instance is expired
	 */
	
	public int id;
	
	public Rubbish(int id) {
		this.id =id;
		System.out.println("Rubbish CREATED, ID =" + id);
	}
	
	//We are overriding the finalize() method given to us by the Object class
	protected void finalize() throws Throwable {
		System.out.println("\t\tRubbish ID = " + id + " Collection Started");
	}
	
	/*
	 * This method does NOTHING for the actual garbage collection.
	 * It is simply the method that is called by the garbage collector prior to
	 * actually reclaiming the memory of the particular object
	 */
}
