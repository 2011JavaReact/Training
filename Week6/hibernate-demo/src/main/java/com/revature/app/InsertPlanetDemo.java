package com.revature.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.entities.Planet;
import com.revature.utils.SessionUtility;

public class InsertPlanetDemo {

	public static void main(String[] args) {
		
		try (Session session = SessionUtility.getSession())  {
			// Create a planet object
			Planet earth = new Planet(13.9, "Earth", 100.5);
			
			Transaction tx = session.beginTransaction();
			
			// save() method will take a transient object and turn it into a persistent object
			// Alternatively, you can also use persist()
			// save() is Hibernate's implementation, while persist() is JPA EntityManager's method
			// We actually have to be careful about the differences if we were to do "cascading operations"
			session.save(earth);
			
//			session.getTransaction().commit();
			tx.commit();
		} 
		
	}
	
}
