package com.revature.accessmod2;

import com.revature.accessmod1.Modifiers;

//import com.revature.accessmod1.Modifiers;

public class Driver extends Modifiers{

	public static void main(String[] args) {
		Modifiers mod = new Modifiers();
		System.out.println("========ACCESSING FIELDS DIRECTLY========");
		System.out.println(mod.pub);//public is accessible from anywhere
		
		Driver driver = new Driver();
		System.out.println(driver.pub);
		System.out.println(driver.prot);
//		System.out.println(driver.priv);
//		System.out.println(driver.def);
	}

}
