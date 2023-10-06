package com.workingsapce.WorkSpace.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.workingsapce.WorkSpace.Entity.Room;
import com.workingsapce.WorkSpace.Entity.Room;
import com.workingsapce.WorkSpace.Repository.RoomRepository;

@Repository
public class RoomDao {
	
	@Autowired
	private RoomRepository repo ;
	
	public Room saveRoom(Room room) {
		return repo.save(room) ;
	}
	
	public Room findById(long id) {
		return repo.findBy(id) ;
	}
	
	public List<Room> findAllRoom(){
		return repo.findAll() ;
	}
	
	public Room updateCoWork(Room room) {
		Room updateSpace = findById(room.getRoomId()) ;
		if (updateSpace != null) {
			
			updateSpace.setFacilities(room.getFacilities());
			updateSpace.setType(room.getType());
			repo.save(updateSpace) ;
			return updateSpace ;
		}
		return null;
	}
	
	public boolean deleteRoom(long id) {
		
		Room delRoom = findById(id) ;
		
		if (delRoom != null) {
			repo.delete(delRoom); 
			return true ;
		}
		return false;
	}

	
	
}
