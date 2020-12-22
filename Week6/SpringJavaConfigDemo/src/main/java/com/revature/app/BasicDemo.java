package com.revature.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Customer customer = ac.getBean(Customer.class, "customer");
		customer.reserve();
		
		System.out.println(customer.getName());
		
//		Table table = ac.getBean(Table.class, "boothTable");
//		table.occupy();
		
		ac.close();
	}
	
}
