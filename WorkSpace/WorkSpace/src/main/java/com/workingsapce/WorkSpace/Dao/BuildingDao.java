package com.workingsapce.WorkSpace.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.workingsapce.WorkSpace.Entity.Building;
import com.workingsapce.WorkSpace.Entity.Building;
import com.workingsapce.WorkSpace.Repository.BuildingRepository;

@Repository
public class BuildingDao {
	
	@Autowired
	private BuildingRepository repo ;
	
	public Building saveBuilding(Building building) {
		
		if (building != null) {
			return repo.save(building);
		}
		return null ;
	}
	
	public Building findById(long id) {
		return repo.findById(id) ;
	}
	
	public List<Building> findAllBuilding(){
		return repo.findAll() ;
	}
	
	public Building updateCoWork(Building building) {
		Building updateSpace = findById(building.getBuildingId()) ;
		if (updateSpace != null) {
			
			updateSpace.setBuildingName(building.getBuildingName());
			updateSpace.setAddress(building.getAddress());
			updateSpace.setFloors(building.getFloors());
			repo.save(updateSpace) ;
			return updateSpace ;
		}
		return null;
	}
	
	public boolean deleteBuilding(long id) {
		
		Building delBuilding = findById(id) ;
		
		if (delBuilding != null) {
			repo.delete(delBuilding); 
			return true ;
		}
		return false;
	}
	
}
