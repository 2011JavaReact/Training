package com.revature.primitives;

public class Driver {

//		Java has 8 primitive (Non-object) datatypes
	int i; // 32 bit integer values
	short s; // 16 bit integer values
	long l; // 64 bit integer value; note that you must put an L afterwards
	byte b; // 8 bit integer value
	char c; // 16 bit character
	float f; // 32 bit decimal number. note that you need to put an f afterwards
	double d; // 64 bit decimal number
	boolean bool; // ?? anywhere from 1-8 bits

	/*
	 * Due to the nature of keeping memory allocations of the size of multiples of 8
	 * bits, it would be too difficult to have a datatype of 1 bit so java allegedly
	 * allocates 8 bits for booleans.
	 */

//		The following is not a primitive, but it is a very common datatype
	String str; // String is an OBJECT

	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.doStuff(); //this invokes the doStuff() method and prints out all the vars
		
		//note that if you have a variable as a field, java will give them a default
//		value if you use them in your methods.
//		for integer primitives, they will be set to 0;
//		for floating point values (decimals) they will be set to 0.0;
//		char will be set to be empty ''
//		booleans will be false
//		objects will be null
	}
	
	public void doStuff() {
		System.out.println(i);
		System.out.println(s);
		System.out.println(l);
		System.out.println(b);
		System.out.println(c);
		System.out.println(f);
		System.out.println(d);
		System.out.println(bool);
		System.out.println(str);
	}
	
	public void castingStuff() {
		/*
		 * Variable casting is the conversion of a variable's datatype to antoher
		 * casting comes in two different flavors:
		 * 1) implicit casting (widening)
		 * 	-you do not have to actually write out the cast
		 * 2)explicit casting (narrowing)
		 * 	-you DO have to write out the cast: (newDatatype) varName
		 * 
		 * When it comes to primitive casting, you can mostly perform implicit casting if
		 * you are converting a smaller datatype to a bigger one.
		 * However, when converting a bigger dataype into a smaller one, explicitly
		 * stating that you intend to do so is required
		 */
		
		l = i; // implicitly casting an int into a long (widening because longs are larger
		//than ints)
		i = (int)l; //explicitly casting a long into an int (narrowing because ints are
//		smaller than longs
		i = c; // you can set an int equal to a char
		c = (char) i;
		f = i; // you can implicitly cast an int into a float
		i = (int)f;
		d = f;
		f = (float) d;
		
	}

}
