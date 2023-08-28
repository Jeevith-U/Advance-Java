package edu.tyss.empandcompany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.empandcompany.mode.Company;
import edu.tyss.empandcompany.mode.Employe;

public class CompanyAndEmployeController {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	
	public void saveCompany() {
		
		Company company = new Company() ;
		
		company.setId(101);
		company.setName("TYSS");
		company.setGSTno("TYSS101BNG");
		company.setRegisterNum("REG101HGE");
		
		List<Employe> list = new ArrayList<Employe>() ;
		
		Employe employe = new Employe() ;
		employe.setId(2024);
		employe.setName("Jeevith");
		employe.setPhno(98765432);
		employe.setEmail("jee@gmail.com");
		employe.setPassword("oikujyt876");
		
		Employe employe2 =new Employe() ;
		
		employe2.setId(20245);
		employe2.setName("Anivit");
		employe2.setPhno(876543267);
		employe2.setEmail("anivi@gmail.com");
		employe2.setPassword("iuyt564");
		
		list.add(employe) ;
		list.add(employe2) ;
		
		company.setListOfEmp(list);
		
		entityTransaction.begin();
		entityManager.persist(company);
		entityManager.persist(employe);
		entityManager.persist(employe2);
		entityTransaction.commit(); 
		
		System.out.println("Saved...!");
	}
	
	public void findCompany(int id) {
		
		Company comapny = entityManager.find(Company.class, 101) ;
		
		System.out.println("Company ID : "+ comapny.getId());
		System.out.println("Company Name : "+ comapny.getName());
		System.out.println("Company GSTNumber : "+ comapny.getGSTno());
		System.out.println("Company RegisterNumber : "+ comapny.getRegisterNum());
		System.out.println();
		System.out.println("Employees Are : ");
		List<Employe> list = comapny.getListOfEmp() ;
		
		for (Employe employe : list) {
			
			System.out.println("**************************************************");
			System.out.println("Employe ID :"+employe.getId());
			System.out.println("Employe name :"+employe.getName());
			System.out.println("Employe phoneNumber :"+employe.getPhno());
			System.out.println("Employe Email :"+employe.getEmail());
			System.out.println("Employe Password :"+employe.getPassword());
		}
		
	}
	
	public void updateCompany(int id, String name) {
		
		entityTransaction.begin();
		
		Company comapny = entityManager.find(Company.class, 101) ;
		
		comapny.setName(name);
		
		entityManager.merge(comapny) ;
		
		entityTransaction.commit();
		
		System.out.println("Updated Sucessfully...");
		
	}
	
	public void deleteCompany(int id) {
		
entityTransaction.begin();
		
		Company comapny = entityManager.find(Company.class, 101) ;
		
		entityManager.remove(comapny);
		
		entityTransaction.commit();
		
		System.out.println("Deleted SucessFully...");
		
	}
}
