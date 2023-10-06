package com.workingsapce.WorkSpace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workingsapce.WorkSpace.Entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
	
	@Query("select r from Room r where r.id = ?1")
	Room findBy(long id) ;
	

}
