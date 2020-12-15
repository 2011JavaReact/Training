package com.revature.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.entities.Planet;
import com.revature.utils.SessionUtility;

public class RetrievePlanetDemo {

	public static void main(String[] args) {
		try (Session session = SessionUtility.getSession())  {
			
			Transaction tx = session.beginTransaction();
			
			Planet planet = session.get(Planet.class, 1);
			
			System.out.println(planet);
			
			tx.commit();
			
		}
	}
}
