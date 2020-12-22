package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.PlanetDTO;
import com.revature.model.Planet;
import com.revature.service.PlanetService;

//@Controller // can replace Controller with RestController if I don't want to specify @ResponseBody in every single method
@RestController
@RequestMapping("/main")
public class PlanetController {

	// Annotations: @Controller: specifies a class as a controller, which is a special bean used to handle 
	// web application requests
	// @RequestBody: allows Spring unmarshal JSON from the body of an HTTP Request to a Java Object
	// @ResponseBody: allows Spring to marshal a Java object into JSON
	// @RequestParam: used to bind request parameters to variables in the method signature
	// @PathVariable: used to bind properties specified directly in the URL mapped for a certain method
	// @RestController: same as @Controller, but also adds @ResponseBody implicitly
	// @ResponseStatus: used to mark a method or exception with HTTP response status code
	// @RequestHeader: In addition to request parameters (@RequestParam) and body content (@RequestBody), 
	// we can also map header data to a method using this annotation
	
	@Autowired
	HttpServletRequest req;
	
	@Autowired
	HttpServletResponse resp;
	
	@Autowired
	private PlanetService planetService;
	
	@RequestMapping(value = "/planet", method = RequestMethod.GET)
//	@ResponseBody
	public List<Planet> getPlanets() {
		
//		return ResponseEntity.status(HttpStatus.OK).body(planetService.getPlanets());
//		resp.setStatus(400);
		return planetService.getPlanets();
	}
	
	@RequestMapping(value = "/planet/{id}", method = RequestMethod.GET)
//	@ResponseBody
	public Planet getPlanet(@PathVariable("id") int id) {
		return planetService.getPlanetById(id);
	}
	
//	@GetMapping(value = "/planet")
//	public Planet getPlanet(@RequestParam int planetId) {
//		return planetService.getPlanetById(planetId);
//	}
	
	@PostMapping(value = "/planet")
	public Planet addPlanet(@RequestBody PlanetDTO planet) {
		return planetService.addPlanet(planet);
	}
	
}
