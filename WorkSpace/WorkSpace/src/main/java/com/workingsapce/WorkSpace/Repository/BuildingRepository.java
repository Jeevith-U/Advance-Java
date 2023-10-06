package com.workingsapce.WorkSpace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workingsapce.WorkSpace.Entity.Building;

public interface BuildingRepository extends JpaRepository<Building, Long> {
	
	@Query("select b from Building b where b.id = ?1")
	public Building findById(long id) ;
}
