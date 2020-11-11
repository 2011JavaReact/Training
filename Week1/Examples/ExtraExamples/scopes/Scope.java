package com.revature.scopes;

//DESIGN PATTERNS
/*
 * A design pattern is a tried and true approach and methodology for achieving a
 * desired functionality or structure in programming.
 * Arguably considered the 'best' way to go a bout certain tasks
 */

//POJO
/*
 * POJO: Plain ol' Java Object
 * A POJO is a design pattern that aims to simply create a class that serves to contain
 * and provide data. Typically it provides no advanced functionality.
 * Simply retains states
 */

public class Scope {
	public static int count = 0;
	//Static Scope
	/*
	 * static is the most available scope that you can give an entity.
	 * Anything static is created upon starting the app, and destroyed when the app
	 * is terminated. The entity is available for the full lifecycle of a running app
	 */
	
	//Instance Scope
	/*
	 * Any field within the class, but outside of any methods is considered to be in
	 * Instance scope. This means that the field is created when the object is
	 * instantiated, but it is destroyed when the object is destroyed
	 */
	
	private String thing;
	private String otherThing;
	
	/*
	 * A constructor aids in creating instances of objects.
	 * It will be the first method called when an object is created.
	 * Invoking the 'new' keyword calls the object's constructor
	 * All constructors follow a naming convention of:
	 * ClassName(){ something}
	 * 
	 * In other words, you do not need a return type
	 */
	
	public Scope(String thing, String otherThing) {
		this.thing = thing;
		this.otherThing = otherThing;
		count++; //count++ is equivalent to saying count = count + 1
	}
	
	public Scope() {
		thing ="unknown";
		otherThing ="unknown";
		count++;
	}
	
	public String getThing() {
		return thing;
	}
	public void setThing(String thing) {
		this.thing = thing;
	}
	public String getOtherThing() {
		return otherThing;
	}
	public void setOtherThing(String otherThing) {
		this.otherThing = otherThing;
	}
	
	
	/*
	 * PASS BY VALUE
	 * -When you call a method and give it an input, that input is NOT passed into the
	 * method.
	 * -Instead, a copy of the value you are inputting is made and created within
	 * the method itself for use
	 * -JAVA is Pass by Value
	 * 
	 * 
	 * PASS BY REFERENCE
	 * -you can pass the location of memory to a function/method and whatever
	 * changes occur to that location of memory is automatically represented outside
	 * of function with no need to return the modified data.
	 */
	
	public void methodScope() {
		//METHOD SCOPE
		/*
		 * Any variables created within a method can only be accessed within the method
		 * it was created in. Once the method is finished, the variables in that method
		 * are also destroyed
		 */
		String stuff = "things"; //this variable would only be able to be referenced
		//from within this method
		
		for(int i = 0; i<10; i++) {
			//LOOP SCOPE
			/*
			 * field 'i' is only accessible within this loop. Once the loop finishes.
			 * 'i' will be destroyed
			 */
			int j = 0; // j is also in loop scope
			System.out.println(stuff);

			for(int k = 0 ; k< 5;k++) { }
//			k =8; can't do this because we are outside the scope of k
		}
	}
	
	public String toString() {
		return "Scope: thing=" + thing + " otherThing = " + otherThing;
	}
	
}
