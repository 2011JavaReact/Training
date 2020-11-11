package com.revature.accessmod1;

public class Driver {

	public static void main(String[] args) {
		Modifiers mod = new Modifiers();
		System.out.println("========ACCESSING FIELDS DIRECTLY========");
		System.out.println(mod.pub);//public is accessible from anywhere
		System.out.println(mod.def);//default is accessible from same package
		System.out.println(mod.prot);//yes because same package;
//		System.out.println(mod.priv);// no because not the same class

	}

}
