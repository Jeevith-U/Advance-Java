package com.workingsapce.WorkSpace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workingsapce.WorkSpace.Entity.Company;
import com.workingsapce.WorkSpace.Entity.CoworkSpace;

public interface CompanyRepository extends JpaRepository<Company, Long>{
	
	@Query("select c from Company c where c.id = ?1")
	Company findById(long id) ;
}
