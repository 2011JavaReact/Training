package com.revature.designpatterns;
/*
 * A Factory design pattern aims to designate a class that will handle the
 * construction of a specific type of object so that all a user has to do
 * is request the object from the factory to receive a fully configured version
 * of the object
 */
public class ShapeFactory {
	public Shape getShape(String request) {
		switch(request.toLowerCase()) {
		case "circle":
			return new Circle();
		case "octagon":
			return new Octagon();
		case "quadrangle":
			return new Quadrangle();
		default:
			return null;
		}
	}
}
