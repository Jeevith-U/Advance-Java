package com.workingsapce.WorkSpace.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.workingsapce.WorkSpace.Dao.FloorDao;
import com.workingsapce.WorkSpace.Dao.WorkSpaceDao;
import com.workingsapce.WorkSpace.Entity.Building;
import com.workingsapce.WorkSpace.Entity.Floor;
import com.workingsapce.WorkSpace.Entity.WorkSpace;
import com.workingsapce.WorkSpace.Entity.WorkSpace;
import com.workingsapce.WorkSpace.Exception.IdNotFoundException;
import com.workingsapce.WorkSpace.ResponseStructure.ResponseStructure;

@Service
public class WorkspaceService {
	
	@Autowired
	private WorkSpaceDao dao ;
	
	@Autowired 
	private FloorDao floorDao ;
	
	public ResponseEntity<ResponseStructure<WorkSpace>> saveWorkSpace(WorkSpace workSpace) {

		if (workSpace != null) {
			ResponseStructure<WorkSpace> response = new ResponseStructure<WorkSpace>();
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage(HttpStatus.CREATED.getReasonPhrase());
			response.setMessage("WorkSpace Saved Successfully...");
			response.setData(dao.saveWorkSpace(workSpace));
			dao.saveWorkSpace(dao.saveWorkSpace(workSpace));
			return new ResponseEntity<ResponseStructure<WorkSpace>>(response, HttpStatus.CREATED);
		} else {

			ResponseStructure<WorkSpace> response = new ResponseStructure<WorkSpace>();
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<WorkSpace>>(response, HttpStatus.CREATED);
		}
	}

	public ResponseEntity<ResponseStructure<WorkSpace>> findWorkspaceById(long id) throws IdNotFoundException {

		if (dao.findById(id) != null) {
			ResponseStructure<WorkSpace> response = new ResponseStructure<WorkSpace>();
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage(HttpStatus.CREATED.getReasonPhrase());
			dao.findById(id);
			response.setData(dao.findById(id));
			return new ResponseEntity<ResponseStructure<WorkSpace>>(response, HttpStatus.CREATED);
		} else
			throw new IdNotFoundException();
	}

   public ResponseEntity<ResponseStructure<WorkSpace>> updateWorkSpace(WorkSpace workSpace){
		
		if (workSpace != null) {
			ResponseStructure<WorkSpace> response = new ResponseStructure<WorkSpace>() ;
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage(HttpStatus.OK.getReasonPhrase());
			response.setData(workSpace);
			dao.updateCoWork(workSpace) ;
			return new ResponseEntity<ResponseStructure<WorkSpace>>(response, HttpStatus.OK) ;
		}else {
			
			ResponseStructure<WorkSpace> response = new ResponseStructure<WorkSpace>() ;
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<WorkSpace>>(response, HttpStatus.OK) ;
		}
    }
   
   public ResponseEntity<ResponseStructure<WorkSpace>> deleteWorkSpace(long id){
	   
		if (id != 0) {
			ResponseStructure<WorkSpace> response = new ResponseStructure<WorkSpace>() ;
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(dao.findById(id));
			dao.deleteWorkSpace(id) ;
			return new ResponseEntity<ResponseStructure<WorkSpace>>(response, HttpStatus.OK) ;
		}else {
			
			ResponseStructure<WorkSpace> response = new ResponseStructure<WorkSpace>() ;
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<WorkSpace>>(response, HttpStatus.OK) ;
		}
   }
 
    public ResponseEntity<ResponseStructure<Floor>> saveWorkSpaceInFloor(WorkSpace space, long id) throws IdNotFoundException {
    	
    	Floor flor = floorDao.findById(id) ;
    	
    	if (flor != null && space != null) {
    		
    		ResponseStructure<Floor> response = new ResponseStructure<Floor>() ;
    		response.setStatusCode(HttpStatus.CREATED.value());
    		response.setMessage(HttpStatus.CREATED.getReasonPhrase());
    		response.setData(flor);
    		if (flor.getWorkSpaces() != null) {
				flor.getWorkSpaces().add(space) ;
			}else {
				List<WorkSpace> workSpaceList = new ArrayList<WorkSpace>() ;
				workSpaceList.add(space) ;
				flor.setWorkSpaces(workSpaceList);
			}
    		floorDao.saveFloor(flor) ;
    		return new ResponseEntity<ResponseStructure<Floor>>(response, HttpStatus.CREATED) ;
    	}else {
    		throw new IdNotFoundException() ;
    	}
    }
}
