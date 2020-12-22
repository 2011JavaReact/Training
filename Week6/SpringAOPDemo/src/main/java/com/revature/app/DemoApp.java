package com.revature.app;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.aspect.NotAuthenticatedException;
import com.revature.config.Config;
import com.revature.controller.FakeController;
import com.revature.dao.PlanetDAO;
import com.revature.model.Planet;

public class DemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		PlanetDAO planetDAO = context.getBean("planetDAO", PlanetDAO.class);
	
//		try {
//			planetDAO.getPlanetById(1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		try {
			Planet planet = planetDAO.addPlanet(new Planet("earth", 100.5, 13.9));
			System.out.println(planet);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		planetDAO.getId();
//		planetDAO.getName();
//		planetDAO.setId(1);
//		planetDAO.setName("test");
		
//		FakeController controller = context.getBean("fakeController", FakeController.class);
//		System.out.println(controller.getAllUsers());
		
		
		context.close();
	}

}
