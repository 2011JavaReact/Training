package com.revature.controlflow;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
//		control();
//		enhanced();
//		ternary();
//		shortCircuit();
//		breakControl();
		switchStatements();
	}
	
	public static void switchStatements() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input a value: ");
		int x = scan.nextInt();
		//one thing to note is that switch statements are kind of like if statements
		//except that instead of two possibilities, there are n number of possibilities
		//note that switch statements accept number primitives and strings and chars
		switch(x) {
		case 0: System.out.println("x was 0"); break; //note that if you do not have
		//the break, you will execute the line proceeding the case you entered
		case 1: System.out.println("x is 1"); break;
		case 2: System.out.println("x is 2"); break;
		default: System.out.println("This is the default case");		
		}
	}
	
	public static void breakControl() {
		//labels, break, continue
//		for(int i = 0; i< 10; i++) {
//			System.out.println(i);
//			if(i==5) {
//				continue;
//				//continue will basically re-enter the loop
//			}
//			if(i==7) {
//				break;
//				//break will exit the loop that it is currently in
//			}
//			System.out.println(i);
//		}
		loop1: for(int i = 0; i < 10; i++) {//this is called a label
			loop2: for(int j = 0; j<10 ; j++) {
				if(i==7 && j > 3) {
					continue loop2;
				}
				System.out.println(i+ " " + j);
			}
		}
	}
	
	private static void shortCircuit() {
		int x = 6;
		int y = 6;
		int z = 7;
		System.out.println("x="+x+" y="+ y + " z="+z);
		
//		if(false | false) {
//			System.out.println("This happened to have executed");
//		}
		//the & operator returns true only if both of the operands are ture
		//the | operator returns true if one or both operand is true
		
		//do not get these confused with || or &&
		//basically, the && will not check the second operand if the first is false
		//the || will not check the second operand if the first is true
		//these are called 'short circuits' because in the interest of efficiency they
		//will not check the second operand in order to save memory
		//sometimes it will matter functionally:
		if(x++ == y | x == z++) {//if you change the | to ||, you will get a different
//			result
			
			//side note: ++x will increment x by 1, then return value
			//x++ will return x then increment by 1
			System.out.println("true");
		}

		System.out.println("x="+x+" y="+ y + " z="+z);
		
		
	}
	
	private static void ternary() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input a value please...");
		int x = scan.nextInt();
		
		String s = x>3 ? "x is greater than 3" : "x is not greater than 3";
		System.out.println(s);
	}
	
	private static void enhanced() {
		String[] arr = {"Cat","Dogs are also great","pig","pie","quinoa"};
		//for each loops can be used with arrays or objects that are "iterable"
		for(int i = 0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		//the loop below is called an 'enhanced for loop' or a 'for-each loop'
		for(String thing:arr) {
			System.out.println(thing);
		}
	}
	
	private static void control() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input a value: ");
		
		int x = scan.nextInt();
		
		//if statements
		if(x > 3) {
			System.out.println("x is greater than 3");
		}else if(x < 3) {
			System.out.println("x is less than 3");
		}else {
			System.out.println("x = 3");
		}
		
		//for loop
		for (int i = 0; i<x; i++) {
			System.out.println(i);
		}
		
		//while loop
		int i = 0;
		while(i<x) {
			System.out.println(i);
			i++;
		}
		
		//do while loop
		int j = 0;
		do {
			System.out.println(j);
			j++;
		}while(j<x);
	}

}
