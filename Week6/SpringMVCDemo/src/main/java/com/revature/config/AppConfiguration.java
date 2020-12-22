package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.dao.PlanetDao;

@Configuration
public class AppConfiguration {

	@Bean
	public PlanetDao planetDao() {
		return new PlanetDao();
	}
	
}
