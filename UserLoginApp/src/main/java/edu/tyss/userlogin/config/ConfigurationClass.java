package edu.tyss.userlogin.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("edu.tyss")
public class ConfigurationClass {
	
	@Bean(name = "entityManagerFactory")
	public EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("jeevith") ;
	}
	
	@Bean(name = "entityManager")
	public EntityManager getEntityManager() {
		
		return getEntityManagerFactory().createEntityManager() ;
	}
	
	@Bean(name = "entityTransaction")
	public EntityTransaction getEntityTransaction() {
		return getEntityManager().getTransaction() ;
	}
	

}
