package edu.tyss.ManyToOne_Example1.Dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.ManyToOne_Example1.model.Paticent;
import edu.tyss.ManyToOne_Example1.model.Reports;

public class Controller {

	    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
		static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		static EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		public void save(Reports reports) {
			entityTransaction.begin();
			entityManager.persist(reports);
		    entityManager.persist(reports.getPaticent());
			entityTransaction.commit(); 
		}
		
		public void findReport(int id) {
			Reports report = entityManager.find(Reports.class, id) ;
			
			System.out.println("PAtcent id : "+report.getPaticent().getId());
			System.out.println("PAtcent id : "+report.getPaticent().getName());
			System.out.println();
			System.out.println("Report ID : "+report.getId());
			System.out.println("Report ID : "+report.getName());
			System.out.println("Report ID : "+report.getReportName());
		}
		
		public void updateReport(int id, String string) {
			Reports report = entityManager.find(Reports.class, id) ;
			entityTransaction.begin();
			report.setName(string);
			entityManager.merge(report) ;
			entityTransaction.commit();
		}
		
		public void deleteReport(int id ) {
			
			entityTransaction.begin();
			Reports report = entityManager.find(Reports.class, id) ;
			entityManager.remove(report);
			entityTransaction.commit();
		}
	
}
