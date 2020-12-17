package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.PlanetDao;
import com.revature.dto.PlanetDTO;
import com.revature.model.Planet;

@Service
public class PlanetService {

	@Autowired
	private PlanetDao planetDao;
		
	public List<Planet> getPlanets() {
		return planetDao.getPlanets();
	}
	
	public Planet getPlanetById(int id) {
		return planetDao.getPlanetById(id);
	}
	
	public Planet addPlanet(PlanetDTO dto) {
		
		Planet planet = new Planet(dto.getName(), dto.getMass(), dto.getTemperature());
		return planetDao.addPlanet(planet);
		
	}
	
}
