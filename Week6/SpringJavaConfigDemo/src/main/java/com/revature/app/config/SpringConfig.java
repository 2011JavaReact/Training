package com.revature.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.revature.app.BoothTable;
import com.revature.app.Customer;
import com.revature.app.FancyTable;
import com.revature.app.Table;

@Configuration
@ComponentScan
@PropertySource("classpath:customername.properties")
public class SpringConfig {

	@Bean
	// @Bean acts as an interceptor for whenever we want to request a bean from the container. If the bean already exists in the container,
	// it will not run the method and will instead give us the already existing bean. Otherwise, if it does not exist already in the container,
	// It will run this method, and then store this newly created bean inside our container
	public Table boothTable() {
		Table table = new BoothTable();
		
		return table;
	}
	
	@Bean
	public Table fancyTable() {
		Table table = new FancyTable();
		
		return table;
	}
	
	@Bean
	public Customer customer() {
		Customer customer = new Customer(fancyTable());
//		customer.setName("William");
		return customer;
	}
	
	// Another benefit of doing this is if you're using third party libraries, for example Amazon S3 (or Hibernate, like what we've been doing)
	// Remember that when we were creating a SessionFactory object, we had to do a bunch of configuration, setting properties, calling
	// methods like .configure("hibernate.cfg.xml"). We can't really put a @Controller annotation or really even use XML configuration for
	// those cases. So if we want to make a bean of type SessionFactory, we will instead do the SessionFactory construction here, which
	// will then be stored as a bean
//	@Bean
//	public SessionFactory sessionFactory() {
//		SessionFactory sessionFactory = new Configuration()
//				.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"))
//				.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"))
//				.configure("hibernate.cfg.xml")
//				.buildSessionFactory();
//		
//		return sessionFactory;
//	}
}
