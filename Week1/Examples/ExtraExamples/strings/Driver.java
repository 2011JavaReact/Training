package com.revature.strings;

public class Driver {

	public static void main(String[] args) {
		//A String is an array of characters
		//By default, strings are immutable
		//This means that you cannot change the contents of a particular string
		//they are final
		
		String s1 = "Monty";
		//System.identityHashCode(x) will give you the hash code for a particular object
		System.out.println("s1:" + System.identityHashCode(s1));
		s1 = s1 + "s"; //s1 += "s";
		System.out.println("s1 after adding the s" + System.identityHashCode(s1));
		
		System.out.println("======================");

		String s2 = "HashSlinging...The CrashFlinging...";
		String s3 = "HashSlinging...The CrashFlinging...";
		
		System.out.println("s2:" + System.identityHashCode(s2));	
		System.out.println("s3:" + System.identityHashCode(s3));
		System.out.println(s2==s3);//the == operator checks to see if the location in memory
//		of two entities is the same
		
		s2 += "Flinging";
		s3 += "Flinging";
		
		System.out.println("s2:" + System.identityHashCode(s2));	
		System.out.println("s3:" + System.identityHashCode(s3));
		System.out.println(s2==s3);
		System.out.println(s2.equals(s3));
		
//		String s4 = "HashSlinging...The CrashFlinging...Flinging";
//		System.out.println("s4:" + System.identityHashCode(s4));	
//		System.out.println("s3:" + System.identityHashCode(s3));
//		System.out.println(s4==s3);
//		System.out.println(s4.equals(s3));
		System.out.println("============");
		s2 = s2.intern(); //Points to, or creates then points to a reference in the String
//		pool
		s3 = s3.intern();
		System.out.println("AFTER intern:" + (s2==s3));
		
		System.out.println("==============");
		//String Builder. Useful if you wanted to use a mutable string
		StringBuilder sbui = new StringBuilder("Stuff"); //this creates a new 
		System.out.println(sbui);
		//StringBuilder object that basically represents "Stuff"
		System.out.println("Hash Code:"+System.identityHashCode(sbui));
		sbui.append(" and Things!");
		System.out.println(sbui);
		System.out.println("Hash Code:"+System.identityHashCode(sbui));
		
		/*
		 * StringBuilder and StringBuffer
		 * -Both of these classes allow us to make mutable string. They wrap around the
		 * string class and allow us to create strings that, when changed, do not
		 * require the creation of a new String object to hold the new value.
		 * So, a common question that gets asked is this: what is the difference between
		 * String, StringBuilder and StringBuffer?
		 * String is immutable, and any time it "changes" a new string is created in its
		 * place.
		 * String also supports the use of the String pool.
		 * 
		 * StringBuffer and StringBuilder allow us to make strings that we are able to
		 * change. In addition, the core difference between these two classes is that
		 * StringBuilder is NOT thread safe, whereas StirngBuffer IS threadsafe
		 * (IE synchronized).
		 */
		
		System.out.println("====Builder vs Buffer=====");
		StringBuffer sbuff = new StringBuffer("someting");
		sbuff.append(" or other");
	}

}
