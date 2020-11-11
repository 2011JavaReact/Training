package com.revature.designpatterns;
/*
 * A common design pattern used in applications is called the "Singleton"
 * A singleton aims to make it so an instantiation of the class may only happen
 * one time.
 * In other words, for the whole lifecylcle of an app, there will ever only be one
 * instance of a singleton. Should any other part of the app choose to use it, it
 * will be the same instance that was originally created.
 */
public class SingletonObject {
	private static SingletonObject s = null;
	
	private SingletonObject() {
		//this is a constructor with private access
	}
	
	public static SingletonObject getSingleton() {
		if(s== null) {
			s = new SingletonObject();
		}
		return s;
	}
}
