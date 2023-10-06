package com.tyss.spring_foodapp.configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.tyss")
public class ConfigurationClass {
	@Bean(value = "entityManager")
	@Scope(value = "prototype")
	public EntityManager entityManager() {
		return Persistence.createEntityManagerFactory("jeevith").createEntityManager();
	}
}
