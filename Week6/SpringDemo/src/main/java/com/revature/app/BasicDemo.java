package com.revature.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicDemo {

	public static void main(String[] args) {
		// Here we are achieving IoC, by not having to instantiate the object ourselves. Instead the Spring framework handles it for us
		// by scanning through our configurations and then instantiating and storing it in the ApplicationContext container itself
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// And then we simply request the bean when we want it
		Customer customer = ac.getBean(Customer.class, "myCustomer");
		
		Customer customer1 = ac.getBean(Customer.class, "myCustomer");
		
		System.out.println("They are equal: " + (customer == customer1));
		
		customer.reserve();
		
		System.out.println(customer.getName());
		
		ac.close();
	}
	
}
