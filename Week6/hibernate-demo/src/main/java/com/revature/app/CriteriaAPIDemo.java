package com.revature.app;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.dto.PlanetDTO;
import com.revature.entities.Planet;
import com.revature.entities.PlanetDetail;
import com.revature.utils.SessionUtility;

public class CriteriaAPIDemo {

	public static void main(String[] args) {
//		basicQuery();
//		partialSelect();
		join();
	}
	
	public static void basicQuery() {
		try (Session session = SessionUtility.getSession()) {
			Transaction tx = session.beginTransaction();
			
			// .get() or .load() from the session object, HQL, JPQL, Criteria API, Native SQL
			
			// Criteria API
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Planet> criteriaQuery = builder.createQuery(Planet.class);
			Root<Planet> root = criteriaQuery.from(Planet.class);
			
			criteriaQuery.select(root);
			criteriaQuery.where(builder.equal(root.get("id"), 1));
			
			Query<Planet> query = session.createQuery(criteriaQuery);
			List<Planet> planets = query.getResultList();
			
			System.out.println(planets);
			
			tx.commit();
		}
	}
	
	public static void partialSelect() {
		try (Session session = SessionUtility.getSession()) {
			Transaction tx = session.beginTransaction();
			
			// .get() or .load() from the session object, HQL, JPQL, Criteria API, Native SQL
			
			// Criteria API
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<PlanetDTO> criteriaQuery = builder.createQuery(PlanetDTO.class);
			Root<Planet> root = criteriaQuery.from(Planet.class);
			
			Path<Object> temperature = root.get("temperature");
			Path<Object> name = root.get("name");
			Path<Object> mass = root.get("mass");
			
			criteriaQuery.select(builder.construct(PlanetDTO.class, temperature, name, mass));
			
			Query<PlanetDTO> query = session.createQuery(criteriaQuery);
			List<PlanetDTO> planetDTOs = query.getResultList();
			
			System.out.println(planetDTOs);
			
			tx.commit();
		}
	}
	
	public static void join() {
		try (Session session = SessionUtility.getSession()) {
			Transaction tx = session.beginTransaction();
			
			// .get() or .load() from the session object, HQL, JPQL, Criteria API, Native SQL
			
			// Criteria API
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Planet> criteriaQuery = builder.createQuery(Planet.class);
			Root<Planet> root = criteriaQuery.from(Planet.class);
			Join<Planet, PlanetDetail> join = root.join("planetDetail");
			
			criteriaQuery.select(root);
			criteriaQuery.where(builder.equal(join.get("description"), "This is the only known planet with life"));
			
			Query<Planet> query = session.createQuery(criteriaQuery);
			Planet planet = query.getSingleResult();
			System.out.println(planet);
			
			tx.commit();
		}
	}
	
}
