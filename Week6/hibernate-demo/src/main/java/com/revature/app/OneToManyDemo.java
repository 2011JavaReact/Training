package com.revature.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.entities.Planet;
import com.revature.entities.Satellite;
import com.revature.utils.SessionUtility;

public class OneToManyDemo {

	public static void main(String[] args) {
		try (Session session = SessionUtility.getSession())  {
			
			Transaction tx = session.beginTransaction();
			
			Planet earth2 = new Planet(13.9, "Earth", 100.5);
			
			Satellite satellite1 = new Satellite("ISS", "The International Space Station");
			Satellite satellite2 = new Satellite("Sputnik", "Already fell to earth and got destroyed");
			
			earth2.addSatellite(satellite1);
			earth2.addSatellite(satellite2);
			
			session.persist(earth2);
//			I don't need these because I specified the cascadeType of PERSIST in my OneToMany mapping between Planet and Satellite
//			session.persist(satellite1);
//			session.persist(satellite2);
			
			tx.commit();
		
		} 
	}
	
}
