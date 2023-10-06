package com.workingsapce.WorkSpace.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.workingsapce.WorkSpace.Dao.BuildingDao;
import com.workingsapce.WorkSpace.Dao.CoWorkSpaceDao;
import com.workingsapce.WorkSpace.Entity.Building;
import com.workingsapce.WorkSpace.Entity.CoworkSpace;
import com.workingsapce.WorkSpace.Exception.IdNotFoundException;
import com.workingsapce.WorkSpace.ResponseStructure.ResponseStructure;

@Service
public class BuildingService {

	@Autowired
	private BuildingDao dao;

	@Autowired
	private CoWorkSpaceDao workSpaceDao;

	public ResponseEntity<ResponseStructure<Building>> saveBuilding(Building building) {

		if (building != null) {
			ResponseStructure<Building> response = new ResponseStructure<Building>();
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage(HttpStatus.CREATED.getReasonPhrase());
			response.setMessage("Building Saved Successfully...");
			response.setData(dao.saveBuilding(building));
			dao.saveBuilding(dao.saveBuilding(building));
			return new ResponseEntity<ResponseStructure<Building>>(response, HttpStatus.CREATED);
		} else {

			ResponseStructure<Building> response = new ResponseStructure<Building>();
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<Building>>(response, HttpStatus.CREATED);
		}
	}

	public ResponseEntity<ResponseStructure<CoworkSpace>> saveBuildingToCoworkSpace(Building building, long id) {

		CoworkSpace space = workSpaceDao.findById(id);

		if (space != null && building != null) {

			ResponseStructure<CoworkSpace> response = new ResponseStructure<CoworkSpace>();
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage(HttpStatus.CREATED.getReasonPhrase());
			response.setData(space);
//			if (space.getBuildings().isEmpty()) {
				dao.saveBuilding(building);
				List<Building> buildings = space.getBuildings();
				buildings.add(building);
				space.setBuildings(buildings);
				workSpaceDao.updateCoWork(space);
				return new ResponseEntity<ResponseStructure<CoworkSpace>>(response, HttpStatus.CREATED);
//			} else
//				space.getBuildings().add(building);
//			workSpaceDao.saveCoworkSpace(space);
//			return new ResponseEntity<ResponseStructure<CoworkSpace>>(response, HttpStatus.CREATED);
		} else {
			ResponseStructure<CoworkSpace> response = new ResponseStructure<CoworkSpace>();
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<CoworkSpace>>(response, HttpStatus.CREATED);
		}
	}

	public ResponseEntity<ResponseStructure<Building>> findById(long id) throws IdNotFoundException {

		if (dao.findById(id) != null) {
			ResponseStructure<Building> response = new ResponseStructure<Building>();
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage(HttpStatus.CREATED.getReasonPhrase());
			dao.findById(id);
			response.setData(dao.findById(id));
			return new ResponseEntity<ResponseStructure<Building>>(response, HttpStatus.CREATED);
		} else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Building>> updateBuilding(Building building) {

		if (building != null) {
			ResponseStructure<Building> response = new ResponseStructure<Building>();
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage(HttpStatus.OK.getReasonPhrase());
			response.setData(building);
			dao.updateCoWork(building);
			return new ResponseEntity<ResponseStructure<Building>>(response, HttpStatus.OK);
		} else {

			ResponseStructure<Building> response = new ResponseStructure<Building>();
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<Building>>(response, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<Building>> deleteBuilding(long id) throws IdNotFoundException {

		if (findById(id) != null) {
			ResponseStructure<Building> response = new ResponseStructure<Building>();
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(dao.findById(id));
			dao.deleteBuilding(id);
			return new ResponseEntity<ResponseStructure<Building>>(response, HttpStatus.OK);
		} else {

			throw new IdNotFoundException();

			/*
			 * ResponseStructure<Building> response = new ResponseStructure<Building>() ;
			 * response.setStatusCode(HttpStatus.NO_CONTENT.value());
			 * response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			 * response.setData(null); return new
			 * ResponseEntity<ResponseStructure<Building>>(response, HttpStatus.OK) ;
			 */
		}
	}

}
