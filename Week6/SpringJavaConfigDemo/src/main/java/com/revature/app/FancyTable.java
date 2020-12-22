package com.revature.app;

import org.springframework.stereotype.Component;

public class FancyTable implements Table {

	@Override
	public void occupy() {
		System.out.println("Fancy table is occupied");
	}

}
