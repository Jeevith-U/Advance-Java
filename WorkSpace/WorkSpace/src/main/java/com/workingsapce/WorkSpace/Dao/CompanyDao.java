package com.workingsapce.WorkSpace.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.workingsapce.WorkSpace.Entity.Company;
import com.workingsapce.WorkSpace.Repository.CompanyRepository;

@Repository
public class CompanyDao {
	
	@Autowired
	private CompanyRepository repo ;
	
public Company saveCompany(Company company) {
		
		if (company != null) {
			return repo.save(company) ;
		}
		return null ;
	}
	
	public Company findById(long id) {
		return repo.findById(id) ;
	}
	
	public List<Company> findAllCompany(){
		return repo.findAll() ;
	}
	
	public Company updateCoWork(Company company) {
		Company updateSpace = findById(company.getCompanyId()) ;
		if (updateSpace != null) {
			
			repo.save(updateSpace) ;
			return updateSpace ;
		}
		return null;
	}
	
	public boolean deleteCompany(long id) {
		Company delcompany = findById(id) ;
		if (delcompany != null) {
			repo.delete(delcompany); 
			return true ;
		}
		return false;
	}
}
