package com.revature.app;

import org.springframework.stereotype.Component;

@Component
public class BoothTable implements Table {
	
	@Override
	public void occupy() {
		System.out.println("BoothTable is occupied");
	}
	
}
