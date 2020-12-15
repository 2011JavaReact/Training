package com.revature.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.entities.Planet;
import com.revature.utils.SessionUtility;

public class CachingDemo {
	
	public static void main(String[] args) {
		
		// In this example, for L1 caching, we will see the database hit twice, once for each session
		// In L2, which is scoped to SessionFactory, we should really only see 1 hit
		Session session = SessionUtility.getSession();
		
		Transaction tx = session.beginTransaction();
		
		Planet planet1 = session.get(Planet.class, 1);
		
		Planet planet2 = session.get(Planet.class, 1);
		
		tx.commit();
		
		session.close();
		
		session = SessionUtility.getSession();
		
		Planet planet3 = session.get(Planet.class, 1);
		
	}

}
