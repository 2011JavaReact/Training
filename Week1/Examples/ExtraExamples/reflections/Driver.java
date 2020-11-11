package com.revature.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Driver {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		House house = new House();
		Class c = house.getClass();
		
		for(Method m : c.getDeclaredMethods()) {
			System.out.println(m.getName());
		}

		Method m1 = c.getMethod("getColor");
		System.out.println(m1.invoke(house, null));

		Method m2 = c.getMethod("setColor",String.class);
		m2.invoke(house, "blue");
		System.out.println(house.getColor());
		
		Method m3 = c.getDeclaredMethod("secret");
		m3.setAccessible(true);
		m3.invoke(house, null);

		Field f1 = c.getDeclaredField("color");
		Field f2 = c.getDeclaredField("address");
		f1.setAccessible(true);
		f2.setAccessible(true);
		System.out.println(f1.get(house));
		System.out.println(f2.get(house));

	}

}
