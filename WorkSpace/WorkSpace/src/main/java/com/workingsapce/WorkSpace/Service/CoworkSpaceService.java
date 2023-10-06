package com.workingsapce.WorkSpace.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.workingsapce.WorkSpace.Dao.CoWorkSpaceDao;
import com.workingsapce.WorkSpace.Entity.CoworkSpace;
import com.workingsapce.WorkSpace.Exception.IdNotFoundException;
import com.workingsapce.WorkSpace.ResponseStructure.ResponseStructure;

@Service
public class CoworkSpaceService {

	@Autowired
	private CoWorkSpaceDao dao;

	public ResponseEntity<ResponseStructure<CoworkSpace>> saveCoWorkSpace(CoworkSpace coworkSpace) {

		if (coworkSpace != null) {
			ResponseStructure<CoworkSpace> response = new ResponseStructure<CoworkSpace>();
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage(HttpStatus.CREATED.getReasonPhrase());
			response.setMessage("CoworkSpace Saved Successfully...");
			response.setData(dao.saveCoworkSpace(coworkSpace));
			dao.saveCoworkSpace(dao.saveCoworkSpace(coworkSpace));
			return new ResponseEntity<ResponseStructure<CoworkSpace>>(response, HttpStatus.CREATED);
		} else {

			ResponseStructure<CoworkSpace> response = new ResponseStructure<CoworkSpace>();
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<CoworkSpace>>(response, HttpStatus.CREATED);
		}
	}

	public ResponseEntity<ResponseStructure<CoworkSpace>> findCoworkspaceById(long id) throws IdNotFoundException {

		if (dao.findById(id) != null) {
			ResponseStructure<CoworkSpace> response = new ResponseStructure<CoworkSpace>();
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage(HttpStatus.CREATED.getReasonPhrase());
			dao.findById(id);
			response.setData(dao.findById(id));
			return new ResponseEntity<ResponseStructure<CoworkSpace>>(response, HttpStatus.CREATED);
		} else
			throw new IdNotFoundException();
	}

   public ResponseEntity<ResponseStructure<CoworkSpace>> updateCoWorkSpace(CoworkSpace coworkSpace){
		
		if (coworkSpace != null) {
			ResponseStructure<CoworkSpace> response = new ResponseStructure<CoworkSpace>() ;
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage(HttpStatus.OK.getReasonPhrase());
			response.setData(coworkSpace);
			dao.updateCoWork(coworkSpace) ;
			return new ResponseEntity<ResponseStructure<CoworkSpace>>(response, HttpStatus.OK) ;
		}else {
			
			ResponseStructure<CoworkSpace> response = new ResponseStructure<CoworkSpace>() ;
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<CoworkSpace>>(response, HttpStatus.OK) ;
		}
    }
   
   public ResponseEntity<ResponseStructure<CoworkSpace>> deleteCoWorkSpace(long id) throws IdNotFoundException{
	   
		if (dao.findById(id) != null) {
			ResponseStructure<CoworkSpace> response = new ResponseStructure<CoworkSpace>() ;
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage(HttpStatus.OK.getReasonPhrase());
			response.setData(dao.findById(id));
			dao.deleteCoworkSpace(id) ;
			return new ResponseEntity<ResponseStructure<CoworkSpace>>(response, HttpStatus.OK) ;
		}else {
			
			throw new IdNotFoundException() ;
			
		/*	ResponseStructure<CoworkSpace> response = new ResponseStructure<CoworkSpace>() ;
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<CoworkSpace>>(response, HttpStatus.OK) ; */
		}
   }
}
