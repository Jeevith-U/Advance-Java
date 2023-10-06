package com.workingsapce.WorkSpace.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.workingsapce.WorkSpace.Entity.WorkSpace;
import com.workingsapce.WorkSpace.Entity.WorkSpace;
import com.workingsapce.WorkSpace.Repository.WorkspaceRepository;

@Repository
public class WorkSpaceDao {
	
	@Autowired
	private WorkspaceRepository repo ;
	
	public WorkSpace saveWorkSpace(WorkSpace workSpace) {
	return repo.save(workSpace) ;
	}
	
	public WorkSpace findById(long id) {
		return repo.findById(id) ;
	}
	
	public List<WorkSpace> findAllWorkSpace(){
		return repo.findAll() ;
	}
	
	public WorkSpace updateCoWork(WorkSpace workSpace) {
		WorkSpace updateSpace = findById(workSpace.getWorkspaceId()) ;
		if (updateSpace != null) {
			
			updateSpace.setCompany(workSpace.getCompany());
			updateSpace.setRooms(workSpace.getRooms());
			repo.save(updateSpace) ;
			return updateSpace ;
		}
		return null;
	}
	
	public boolean deleteWorkSpace(long id) {
		
		WorkSpace delworkspace = findById(id) ;
		
		if (delworkspace != null) {
			repo.delete(delworkspace); 
			return true ;
		}
		return false;
	}
}
