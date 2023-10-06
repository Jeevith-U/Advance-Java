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
import com.workingsapce.WorkSpace.Entity.Floor;
import com.workingsapce.WorkSpace.Exception.IdNotFoundException;
import com.workingsapce.WorkSpace.ResponseStructure.ResponseStructure;
import com.workingsapce.WorkSpace.Service.FloorService;

@RestController
@RequestMapping("/floor")
public class FloorController {
	
	@Autowired
	private FloorService service ;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Floor>> saveFloor(@RequestBody Floor building) {
		
		return service.saveFloor(building) ;
	}
	
	@PostMapping("/{floorId}")
	public ResponseEntity<ResponseStructure<Floor>> findBuildingById(@PathVariable long id ) throws IdNotFoundException {
		return service.findFloorById(id) ;
	}
	
	
	@GetMapping("/{buildingId}")
	public ResponseEntity<ResponseStructure<Building>> findFloorById(@RequestBody Floor floor, @PathVariable long id) throws IdNotFoundException {
		return service.saveFloorInBuilding(floor ,id) ;
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Floor>> updateFloor(@RequestBody Floor building) {
		return service.updateFloor(building) ;
	}
	
	@DeleteMapping("/{floorId}")
	public ResponseEntity<ResponseStructure<Floor>> deletingFloor(@PathVariable long id){
		return service.deleteFloor(id) ;
	}
}
