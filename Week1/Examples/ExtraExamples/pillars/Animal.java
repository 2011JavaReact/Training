package com.revature.pillars;

/*
 * ABSTRACT CLASSES
 * -When applied to a class, 'abstract' allows for the class to have abstract methods.
 * -It also foregoes the ability of that class to be instantiated
 * -The purpose of an abstract class is to provide a class that you want all of the
 * children to inherit from and guarantee they share a certain set of behaviors
 * -
 */
public abstract class Animal implements Huggable{
	//Abstract method.
	public abstract String speak(); //notice that we close with a semicolon and not {}
	//Concrete method
	public String eat() {
		return "Generic eating...";
	}
}
