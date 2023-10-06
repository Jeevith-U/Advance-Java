package com.workingsapce.WorkSpace.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.workingsapce.WorkSpace.Entity.CoworkSpace;
import com.workingsapce.WorkSpace.Repository.CoWorkSpaceRepository;

@Repository
public class CoWorkSpaceDao {
	
	@Autowired
	private CoWorkSpaceRepository repo ;
	
	public CoworkSpace saveCoworkSpace(CoworkSpace coworkSpace) {
		return repo.save(coworkSpace) ;
	}
	
	public CoworkSpace findById(long id) {
		return repo.findById(id) ;
	}
	
	public List<CoworkSpace> findAllCoworkSpace(){
		return repo.findAll() ;
	}
	
	public CoworkSpace updateCoWork(CoworkSpace coworkSpace) {
		CoworkSpace updateSpace = findById(coworkSpace.getId()) ;
		if (updateSpace != null) {
			
			updateSpace.setName(coworkSpace.getName());
			updateSpace.setAddress(coworkSpace.getAddress());
			updateSpace.setBuildings(coworkSpace.getBuildings());
			repo.save(updateSpace) ;
			return updateSpace ;
		}
		return null;
	}
	
	public boolean deleteCoworkSpace(Long id) {
		CoworkSpace cowork = findById(id) ;
		if (cowork != null) {
			repo.delete(cowork); 
			return true ;
		}
		return false;
	}
}
