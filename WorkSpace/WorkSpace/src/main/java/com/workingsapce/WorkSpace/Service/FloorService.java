package com.workingsapce.WorkSpace.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BulkBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.workingsapce.WorkSpace.Dao.BuildingDao;
import com.workingsapce.WorkSpace.Dao.FloorDao;
import com.workingsapce.WorkSpace.Entity.Building;
import com.workingsapce.WorkSpace.Entity.Floor;
import com.workingsapce.WorkSpace.Exception.IdNotFoundException;
import com.workingsapce.WorkSpace.ResponseStructure.ResponseStructure;

@Service
public class FloorService {
	
	@Autowired
	private FloorDao dao ;
	
	@Autowired
	private BuildingDao buildingDao ;
	
	public ResponseEntity<ResponseStructure<Floor>> saveFloor(Floor floor) {

		if (floor != null) {
			ResponseStructure<Floor> response = new ResponseStructure<Floor>();
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage(HttpStatus.CREATED.getReasonPhrase());
			response.setMessage("Floor Saved Successfully...");
			response.setData(dao.saveFloor(floor));
			dao.saveFloor(dao.saveFloor(floor));
			return new ResponseEntity<ResponseStructure<Floor>>(response, HttpStatus.CREATED);
		} else {

			ResponseStructure<Floor> response = new ResponseStructure<Floor>();
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<Floor>>(response, HttpStatus.CREATED);
		}
	}

	public ResponseEntity<ResponseStructure<Floor>> findFloorById(long id) throws IdNotFoundException {

		if (dao.findById(id) != null) {
			ResponseStructure<Floor> response = new ResponseStructure<Floor>();
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage(HttpStatus.CREATED.getReasonPhrase());
			dao.findById(id);
			response.setData(dao.findById(id));
			return new ResponseEntity<ResponseStructure<Floor>>(response, HttpStatus.CREATED);
		} else
			throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Building>> saveFloorInBuilding(Floor floor , long id) throws IdNotFoundException{
		
		Building building = buildingDao.findById(id) ;
		
		if (building !=  null && floor != null) {
			
			ResponseStructure<Building> response = new ResponseStructure<Building>() ;
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage(HttpStatus.CREATED.getReasonPhrase());
			response.setData(building);
			if (building.getFloors().isEmpty()) {
				List<Floor> floorList = new ArrayList<Floor>() ;
				floorList.add(floor) ;
				building.setFloors(floorList);
			}else {
				building.getFloors().add(floor) ;
			}
			buildingDao.saveBuilding(building) ;
			return new ResponseEntity<ResponseStructure<Building>>(response, HttpStatus.CREATED) ;
		}else {
			throw new IdNotFoundException() ;
		}
		
	}

   public ResponseEntity<ResponseStructure<Floor>> updateFloor(Floor floor){
		
		if (floor != null) {
			ResponseStructure<Floor> response = new ResponseStructure<Floor>() ;
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage(HttpStatus.OK.getReasonPhrase());
			response.setData(floor);
			dao.updateCoWork(floor) ;
			return new ResponseEntity<ResponseStructure<Floor>>(response, HttpStatus.OK) ;
		}else {
			
			ResponseStructure<Floor> response = new ResponseStructure<Floor>() ;
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<Floor>>(response, HttpStatus.OK) ;
		}
    }
   
   public ResponseEntity<ResponseStructure<Floor>> deleteFloor(long id){
	   
		if (id != 0) {
			ResponseStructure<Floor> response = new ResponseStructure<Floor>() ;
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(dao.findById(id));
			dao.deleteFloor(id) ;
			return new ResponseEntity<ResponseStructure<Floor>>(response, HttpStatus.OK) ;
		}else {
			
			ResponseStructure<Floor> response = new ResponseStructure<Floor>() ;
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<Floor>>(response, HttpStatus.OK) ;
		}
   }
}
