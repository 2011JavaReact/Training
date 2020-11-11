package com.revature.scanners;

import java.util.Scanner;

public class Driver {

	
	
	public static void main(String[] args) {
		Scanner in = null;
		System.out.println("====APP BEGINNING===");
		/*
		 * Scanner is a class used to parse strings/streams
		 * e.g. parse numbers/letters/etc from strings with ease (arguably better than
		 * other ways)* this is an opinion
		 * 
		 * more commonly used for user input in the console application.
		 * by default, scanner will delimit by ' ' (space)
		 * 
		 * NOTE: System.in is the call for taking user input
		 */
		in = new Scanner(System.in);// allows for user input
		String input = "";
		System.out.println("Tell me something... and I will 'echo' it to you!");
		input = in.next(); // this will take the first word the user inputs
		//note you have options, such as: nextLine, nextInt, etc.
		System.out.println("Echoing...." + input);
	}

}
