package com.tyss.userdetails.configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.tyss.userdetails.model")
public class MyConfiguration {
	
	@Bean(name = "entitymanagerfactory")
	public EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("jeevith");
	}
	
	@Bean(name = "entitymanager")
	public EntityManager entityManager() {
		return getEntityManagerFactory().createEntityManager() ;
	}
	
	@Bean(name = "entitytransaction")
	public EntityTransaction getEntityTransaction() {
		return entityManager().getTransaction() ;
	}
}
