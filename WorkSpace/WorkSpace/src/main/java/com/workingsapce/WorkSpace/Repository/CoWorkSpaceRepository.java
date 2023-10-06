package com.workingsapce.WorkSpace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workingsapce.WorkSpace.Entity.CoworkSpace;

public interface CoWorkSpaceRepository extends JpaRepository<CoworkSpace, Long>{
	
	@Query("select c from CoworkSpace c where c.id = ?1")
	CoworkSpace findById(long id) ;

}
