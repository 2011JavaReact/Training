package com.revature.app;

import org.springframework.stereotype.Component;

@Component
public class Customer {
	
	private Table table;
	
	private String name;
	
	public Customer() {
		super();
	}
	
	public Customer(Table table) {
		System.out.println("Constructor injection invoked inside Customer");
		this.table = table;
	}
	
	public void customInit() {
		System.out.println("Custom init method invoked");
	}
	
	public void customDestroy() {
		System.out.println("closing resources...");
	}
	
	public void reserve() {
		System.out.println("Customer has reserved a table");
		table.occupy();
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		System.out.println("Setter injection invoked inside Customer for Table dependency");
		this.table = table;
	}
}
