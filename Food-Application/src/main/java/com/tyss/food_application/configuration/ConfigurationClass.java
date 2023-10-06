package com.tyss.food_application.configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.tyss")
public class ConfigurationClass {
	
	@Bean(name = "entityManager")
	@Scope(value = "prototype")
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("mysqldb").createEntityManager() ;
	}
}
