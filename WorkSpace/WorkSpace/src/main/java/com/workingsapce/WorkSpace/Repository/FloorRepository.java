package com.workingsapce.WorkSpace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workingsapce.WorkSpace.Entity.Building;
import com.workingsapce.WorkSpace.Entity.Floor;

public interface FloorRepository extends JpaRepository<Floor, Long>{
	
	@Query("select b from Floor b where b.id = ?1")
	public Floor findById(long id) ;
}
