package com.revature.accessmod1;

public class Modifiers {
	/*
	 * There are two kinds of 'modifiers' available in java. One of the two are called
	 * 'access modifiers', whereas the other is called 'non-access modifiers'
	 * -note that you can use access modifers on classes, interfaces, variables and
	 * methods
	 * 
	 * PRIVATE:
	 * -restricts access to the entity to only within the class where it exists
	 * -for example, you cannot access a private entity from outside of its class
	 * -ex: private int i = 0; //we would only be able to access this in the class
	 * where it was declared
	 * DEFAULT:
	 * -restricts access to only classes that are within the same package of the class
	 * -if you do not add an access modifier to a particular member, it will be 'default'
	 * by default
	 * -ex: int i = 0;
	 * PROTECTED
	 * -protected is restricted to classes of the same package OR classes that inherit
	 * from this class specifically. So there is a class that 
	 * is NOT in the same package as this one, BUT inherits from this class, it WILL
	 * have access to this member
	 * PUBLIC
	 * -accessible from anywhere in the project
	 * 
	 * NON ACCESS MODIFIERS:
	 * STATIC
	 * -sets the resource to be available without needing to create an instances
	 * of the class
	 * -any static fields are shared among all instances of the class
	 * -furthermore, there can only be ONE version of whatever you make static
	 * FINAL
	 * -makes fields constant. you cannot change or reassign the field value
	 * -makes methods impossible to override
	 * -makes classes uninheritable
	 * -basically, you can't change what the reference variable points to
	 * ABSTRACT
	 * -foregoes the requirement to provide a body implementation for a method (if
	 * method is abstract). Instead, any classs that inherits this method willl be
	 * required to provide an implementation for the method itself
	 * -when attached to a class, you cannot instantiate the class.
	 * TRANSIENT
	 * -prevents the resource from being serialized.
	 * SYNCHRONIZED
	 * -Limits the amount of threads that can access a resource at a given time to
	 * only ONE
	 * DEFAULT (as in the actual keyword)
	 * -Brought to us in Java 8, it allows you to provide a body for abstract methods.
	 * -specifically for interfaces
	 * STRICTFP
	 * -if you put this on a class, all methods are strictfp
	 * -ensures all floating points are configured to follow IEEE standards
	 * VOLATILE
	 * -a volatile variable must be accessed via main memory... this means that all
	 * threads will be able to access this specific variable regardless of if it is
	 * local or not
	 * NATIVE
	 * -implementation of a method that is marked as native will NOT be written in Java
	 * instead, it will be written in another language
	 * 
	 */
	private String priv = "private";
	String def = "default";
	protected String prot = "protected";
	public String pub = "public";
	
}
