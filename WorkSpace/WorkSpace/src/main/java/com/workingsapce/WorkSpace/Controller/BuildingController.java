package com.workingsapce.WorkSpace.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workingsapce.WorkSpace.Entity.Building;
import com.workingsapce.WorkSpace.Entity.CoworkSpace;
import com.workingsapce.WorkSpace.Exception.IdNotFoundException;
import com.workingsapce.WorkSpace.ResponseStructure.ResponseStructure;
import com.workingsapce.WorkSpace.Service.BuildingService;

@RestController
@RequestMapping("/building")
public class BuildingController {
	
	@Autowired
	private BuildingService service ;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Building>> saveBuilding(@RequestBody Building building) {
		
		return service.saveBuilding(building) ;
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<ResponseStructure<CoworkSpace>> saveBuilding(@RequestBody Building building, @PathVariable Long id ) {
		System.out.println(id);
		return service.saveBuildingToCoworkSpace(building, id) ;
	}
	
	@GetMapping("/buildin/{buildingId}")
	public ResponseEntity<ResponseStructure<Building>> findBuildingById(@PathVariable long id) throws IdNotFoundException {
		return service.findById(id) ;
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Building>> updateBuilding(@RequestBody Building building) {
		return service.updateBuilding(building) ;
	}
	
	@DeleteMapping("/{buildingId}")
	public ResponseEntity<ResponseStructure<Building>> deletingBuilding(@PathVariable long id) throws IdNotFoundException{
		return service.deleteBuilding(id) ;
	}
}
