package com.workingsapce.WorkSpace.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.workingsapce.WorkSpace.Dao.CompanyDao;
import com.workingsapce.WorkSpace.Dao.RoomDao;
import com.workingsapce.WorkSpace.Entity.Company;
import com.workingsapce.WorkSpace.Entity.Room;
import com.workingsapce.WorkSpace.Entity.Room;
import com.workingsapce.WorkSpace.Exception.IdNotFoundException;
import com.workingsapce.WorkSpace.ResponseStructure.ResponseStructure;

@Service
public class RoomService {
	
	@Autowired
	private RoomDao dao ;
	
	@Autowired
	private CompanyDao companyDao ;
	
	public ResponseEntity<ResponseStructure<Room>> saveRoom(Room room) {

		if (room != null) {
			ResponseStructure<Room> response = new ResponseStructure<Room>();
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage(HttpStatus.CREATED.getReasonPhrase());
			response.setMessage("Room Saved Successfully...");
			response.setData(dao.saveRoom(room));
			dao.saveRoom(dao.saveRoom(room));
			return new ResponseEntity<ResponseStructure<Room>>(response, HttpStatus.CREATED);
		} else {

			ResponseStructure<Room> response = new ResponseStructure<Room>();
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<Room>>(response, HttpStatus.CREATED);
		}
	}

	public ResponseEntity<ResponseStructure<Room>> findById(long id) throws IdNotFoundException {

		if (dao.findById(id) != null) {
			ResponseStructure<Room> response = new ResponseStructure<Room>();
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage(HttpStatus.CREATED.getReasonPhrase());
			dao.findById(id);
			response.setData(dao.findById(id));
			return new ResponseEntity<ResponseStructure<Room>>(response, HttpStatus.CREATED);
		} else
			throw new IdNotFoundException();
	}

   public ResponseEntity<ResponseStructure<Room>> updateRoom(Room room){
		
		if (room != null) {
			ResponseStructure<Room> response = new ResponseStructure<Room>() ;
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage(HttpStatus.OK.getReasonPhrase());
			response.setData(room);
			dao.updateCoWork(room) ;
			return new ResponseEntity<ResponseStructure<Room>>(response, HttpStatus.OK) ;
		}else {
			
			ResponseStructure<Room> response = new ResponseStructure<Room>() ;
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<Room>>(response, HttpStatus.OK) ;
		}
    }
   
   public ResponseEntity<ResponseStructure<Room>> deleteRoom(long id){
	   
		if (id != 0) {
			ResponseStructure<Room> response = new ResponseStructure<Room>() ;
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(dao.findById(id));
			dao.deleteRoom(id) ;
			return new ResponseEntity<ResponseStructure<Room>>(response, HttpStatus.OK) ;
		}else {
			
			ResponseStructure<Room> response = new ResponseStructure<Room>() ;
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<Room>>(response, HttpStatus.OK) ;
		}
   }

    public ResponseEntity<ResponseStructure<Room>> saveRoomInCompany(Room room, long id) throws IdNotFoundException {
    	  Company upcompany = companyDao.findById(id) ;
    	  if (room != null && room != null) {
    		  
    		  ResponseStructure<Room> response = new ResponseStructure<Room>();
    		  response.setStatusCode(HttpStatus.CREATED.value());
    		  response.setMessage(HttpStatus.CREATED.getReasonPhrase());
    		  response.setData(room);
    		  if (upcompany.getRoomList().isEmpty()) {
				List<Room> rooms = new ArrayList<Room>() ;
				rooms.add(room) ;
				upcompany.setRoomList(rooms);
			}else {
				upcompany.getRoomList().add(room) ;
			}
    		  
    		  companyDao.saveCompany(upcompany) ;
    		  return new ResponseEntity<ResponseStructure<Room>>(response,HttpStatus.OK) ;
			
		}
		throw new IdNotFoundException() ;
    	
}
}
