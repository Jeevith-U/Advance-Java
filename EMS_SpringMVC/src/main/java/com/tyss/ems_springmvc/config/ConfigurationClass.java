package com.tyss.ems_springmvc.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.tyss")
public class ConfigurationClass {
	
	@Bean(name = "entityManagerFactory")
	public EntityManagerFactory getEntityManagerFactory()
	{
		return Persistence.createEntityManagerFactory("jeevith") ;
	}
	
	@Bean(name = "entityManager")
	@Scope(value = "prototype")
	public EntityManager getEntityManager() {
		return getEntityManagerFactory().createEntityManager() ;
	}
	
	@Bean(name = "entityTransaction")
	@Scope(value = "prototype")
	public EntityTransaction getEntityTransaction() {
		return getEntityManager().getTransaction() ;
	}
}
