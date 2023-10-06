package com.workingsapce.WorkSpace.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.workingsapce.WorkSpace.Entity.Floor;
import com.workingsapce.WorkSpace.Repository.FloorRepository;

@Repository
public class FloorDao {
	
	@Autowired
	private FloorRepository repo ;
	
   public Floor saveFloor(Floor floor) {
		
		if (floor != null) {
			return repo.save(floor) ;
		}
		return null ;
	}
	
	public Floor findById(long id) {
		return repo.findById(id) ;
	}
	
	public List<Floor> findAllFloor(){
		return repo.findAll() ;
	}
	
	public Floor updateCoWork(Floor floor) {
		Floor updateSpace = findById(floor.getFloorId()) ;
		if (updateSpace != null) {
			
			repo.save(updateSpace) ;
			return updateSpace ;
		}
		return null;
	}
	
	public boolean deleteFloor(long id) {
		
		Floor floor = findById(id) ;
		
		if (floor != null) {
			repo.delete(floor); 
			return true ;
		}
		return false;
	}
}
