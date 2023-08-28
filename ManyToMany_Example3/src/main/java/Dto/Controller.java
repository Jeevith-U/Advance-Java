package Dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Model.Job;
import Model.Person;

public class Controller {
	
	    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
		static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		static EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		public void save(Person person) {
			
			entityTransaction.begin();
			entityManager.persist(person);
			for(  Job job : person.getList()) {
				entityManager.persist(job);
			}
			entityTransaction.commit(); 
		}
		
		public void findPersonJob(int id) {
			
			Person person = entityManager.find(Person.class, id) ;
			
			for(Job job : person.getList()) {
				
				System.out.println("Job Id : "+job.getId());
				System.out.println("Job designation : "+job.getDesignation());
				System.out.println("Job salary : "+job.getSal());
			}
		}
		
		public void updateJob(int id, int jid, String designation) {
			
            Person person = entityManager.find(Person.class, id) ;
            
            List<Job> jobs = person.getList() ;
			entityTransaction.begin();
			for(Job job : jobs) {
				if (job.getId()== jid) {
					job.setDesignation(designation);
					entityManager.merge(person) ;
				}
		   }
			
			entityTransaction.commit(); 
	    }
		
		public void deleteJob(int id, int jid) {
			
			 Person person = entityManager.find(Person.class, id) ;
	            
	            List<Job> jobs = person.getList() ;
	            Job delJob = null ;
				entityTransaction.begin();
				for(Job job : jobs) {
					delJob = job ;
				}
				
				person.getList().remove(delJob) ;
				entityManager.remove(delJob);
				entityManager.merge(person) ;
				entityTransaction.commit();
		}

	
}
