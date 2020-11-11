package com.revature.scopes;

public class Driver {

	public static void main(String[] args) {
		System.out.println(Scope.count); // we can do this because count is static
		Scope scope = new Scope("Cat", "pizza");
		System.out.println(scope.count);
		
		Scope scope2 = new Scope();
		System.out.println(scope2.count);
		System.out.println(Scope.count);
		System.out.println(scope.count);

	}

}
