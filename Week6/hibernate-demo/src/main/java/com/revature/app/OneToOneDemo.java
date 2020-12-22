package com.revature.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.entities.Planet;
import com.revature.entities.PlanetDetail;
import com.revature.utils.SessionUtility;

public class OneToOneDemo {

	public static void main(String[] args) {
		
		try (Session session = SessionUtility.getSession())  {
			
			Transaction tx = session.beginTransaction();
			
			Planet planet = new Planet(13.9, "Earth", 100.5);
			PlanetDetail planetDetail = new PlanetDetail("This is the only known planet with life", "Mostly nitrogen and Oxygen");
			
			planet.setPlanetDetail(planetDetail);
			
			// in order to cascade, we have to use persist and not save, because persist is a JPA operation, and the cascade annotation
			// values we're using only apply to JPA
			
			// Does not work
//			int id = (Integer) session.save(planet);
			
			// Works since persist() is in the JPA specification
			session.persist(planet);
			
			// Retrieve a Planet with ID 1
			Planet earth = session.get(Planet.class, 1);
			System.out.println(earth.getPlanetDetail());
			
			planetDetail = session.get(PlanetDetail.class, 1);
			
			// HQL Hibernate Query language
			// So here I switched from bidirectional back to unidirectional, so if I wanted to get a planet for planetdetail, I can't use 
			// getPlanet(), because the mapping only exists on Planet
			// So I can actually do joins using HQL
			// Remember that HQL is "object-oriented SQL"
			// HQL queries are not type-safe
			
			Planet earth2 = (Planet) session.createQuery("from Planet p WHERE p.id = 1").getSingleResult();
			System.out.println(earth2);
			
			// We can use this to get the Planet associated with PlanetDetail even without having a bidirectional relationship.
			// I actually prefer this way of doing things because I've had a lot of trouble with infinite loops in the past
			// Especially when serializing objects to JSON
			
			Planet earth3 = (Planet) session.createQuery("SELECT p from Planet p JOIN p.planetDetail pd WHERE pd.id = :pdi")
					.setParameter("pdi", 1)
					.getSingleResult();
			System.out.println(earth3);
			
			// Named queries
			Planet earth4 = (Planet) session.createNamedQuery("PlanetDetail_getAssociatedPlanet")
					.setParameter("pdi", 1)
					.getSingleResult();
			System.out.println(earth4);
			
			tx.commit();
			
		} 

	}

}
