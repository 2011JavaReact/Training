package com.revature.garbage;

public class Driver {

	public static void main(String[] args) {
		//this demonstration will show why it is not always most efficient to collect
		//garbage constantly
		for(int i = 0; i < 1_000_000; i++) {
			Rubbish rub = new Rubbish(i);
			System.gc(); //System.gc() is a way of suggesting that the garbage collector
			//take out the garbage
			//notice that if you call System.gc() after you create each object,
			//it will take out the garabge more frequently, but your performance takes
			//a large hit
		}

	}

}
