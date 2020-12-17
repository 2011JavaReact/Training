package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Planet;

@Transactional
public class PlanetDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public List<Planet> getPlanets() {
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery("from Planet p").getResultList();
	}
	
	public Planet addPlanet(Planet p) {
		Session session = sessionFactory.getCurrentSession();
		
//		Transaction tx = session.beginTransaction();
		
		int id = (int) session.save(p);
		
//		tx.commit();
		Planet planet = new Planet(p.getName(), p.getMass(), p.getTemperature());
		planet.setId(id);
		
		return planet;
	}

	public Planet getPlanetById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Planet planet = session.get(Planet.class, id);
		
		return planet;
	}
	
}
