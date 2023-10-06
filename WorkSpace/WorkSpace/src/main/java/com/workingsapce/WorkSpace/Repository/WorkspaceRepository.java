package com.workingsapce.WorkSpace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workingsapce.WorkSpace.Entity.WorkSpace;

public interface WorkspaceRepository extends JpaRepository<WorkSpace, Long>{
	
	@Query("select w from WorkSpace w where w.id = ?1")
	WorkSpace findById(long id) ;
}
