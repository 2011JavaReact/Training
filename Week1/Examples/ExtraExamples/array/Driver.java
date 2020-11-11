package com.revature.array;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		/*
		 * Arrays
		 * 
		 * An array is a group of like-typed variables that are referred to by a common
		 * name. some things to note about arrays in Java include:
		 * 
		 * -Arrays are of a fixed size. This means that they are instantiated (yes,
		 * arrays are objects) their size cannot be changed.
		 * -The variables in an array are ordered and each have an index beginning from 0
		 * -The size of an array must be specified by an int value and not a long
		 * or a short
		 * -You are allowed to created multi-dimentional arrays (an array of arrays)
		 * -The length of an array can be found by invoking the 'length' member on any
		 * array
		 */
		
		//Arrays can be declared in one of the following ways
		int myIntArray[];//valid, this indicates that you want to create an array
		//of ints that will be referred to as "myIntArray"
		int[] myOtherIntArray; //this is also valid
		
		//Likewise, there are a few ways to instantiate arrays:
		myIntArray = new int[5];//valid, this creates an array that is of size 5
		myOtherIntArray = new int[] {1, 2, 3, 4, 5}; //valid
		
		//array literals by themselves need to be included on the same line as the
		//array's declaration
		char[] myCharArray = {'a','b','c'};
		
		//once again, you can access an item in an array by referring to its position
		//in the array. Remember in Java, we start counting with 0
		int x = myIntArray[2];//sets x to the value in the array at an index of 2
		myIntArray[2] = 7; //this changes the item at the index of to to 7
//		myIntArray[5] = 9; note that if you try to access an index that is not in the
//		array, you will get an ArrayIndexOutOfBoundsException
//		note that you can get the length of an array in the following way:
		System.out.println(myIntArray.length);//remember that you cannot change the
//		length of an array
//		myIntArray.length = 7;The length of an array is final and cannot be changed
		
//		looping through array:
		for(int i: myOtherIntArray) {
			System.out.println("Enchanced:" + i);
		}
//		Alternative way of printing out an array:
		System.out.println(Arrays.toString(myOtherIntArray));
//		Arrays.toString() is a convenience method that comes from the Arrays class
//		in the util package
		System.out.println("-----------------------");
		
		
//		note that we can make arrays with object, such as strings, as well
		String[] pirates = new String[4];
		pirates[0] = "Black Beard...The pirate i guess";
		pirates[1] = "Steve The Pirate";
		pirates[2] = "Cap'n John Pidgeon: Where's the Coke?";
		pirates[3] = "Captain Munch";
		
		System.out.println(Arrays.toString(pirates));

		System.out.println("-----------------------");
		//multi-dimensional arrays
		int[][] the2dArray = new int[3][3];
		int[][] literal2dArray = { {1,2,3}, {4,5,6}, {7,8,9} };
		int[][][][] fourD = new int[4][4][4][4];
		int value = literal2dArray[1][0];
		System.out.println("value = "+value);
		System.out.println(myIntArray); //if it is not a char array, trying to print out
//		the array will result in receiving the hash code of an array
		System.out.println(literal2dArray);
		System.out.println(Arrays.deepToString(literal2dArray));
//		deepToString() allows you to print out nested for loops
		System.out.println(Arrays.toString(literal2dArray));
//		System.out.println(Arrays.deepToString(myOtherIntArray)); can't do this
//		needs to be multi-dimmensional to use deep to string
		System.out.println(Arrays.deepToString(fourD)); //yes you can do as many dimensions
		//as you would like
		
		
		//note that you also have the option of using as many for loops as there are
		//dimensions in order to loop through the array.
		
	}
	//note that arrays can be taken as arguments for a method
	public static void workWithArrays(int[] arr) {
		Arrays.toString(arr);
	}

}
