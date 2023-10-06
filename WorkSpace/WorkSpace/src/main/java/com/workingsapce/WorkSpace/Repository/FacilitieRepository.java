package com.workingsapce.WorkSpace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workingsapce.WorkSpace.Entity.Facilitie;
import com.workingsapce.WorkSpace.Entity.WorkSpace;

public interface FacilitieRepository extends JpaRepository<Facilitie, Long> {
	
	@Query("select f from Facilitie f where f.id = ?1")
	WorkSpace findById(long id) ;
}
