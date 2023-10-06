package com.workingsapce.WorkSpace.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workingsapce.WorkSpace.Entity.CoworkSpace;
import com.workingsapce.WorkSpace.Exception.IdNotFoundException;
import com.workingsapce.WorkSpace.ResponseStructure.ResponseStructure;
import com.workingsapce.WorkSpace.Service.CoworkSpaceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CoWorkSpaceController {
	
	@Autowired
	private CoworkSpaceService service ;
	
	@ApiResponses(value = @ApiResponse(description = "cowork saved",responseCode = "201")
	            /*  value = @ApiResponse(description = "unable to save",responseCode = "404")*/)
	@Operation(description = "To save the Cowork to the Database", summary = "User will send the cowork data"
			+ " from the postman which we have to save in the data base")
	@PostMapping("/cowork")
	public ResponseEntity<ResponseStructure<CoworkSpace>> saveCoworkSpace(@RequestBody CoworkSpace coworkSpace) {
		return service.saveCoWorkSpace(coworkSpace) ;
	}
	
	@GetMapping("/cowork/{id}")
	public ResponseEntity<ResponseStructure<CoworkSpace>> findCoworkById(@PathVariable int id) throws IdNotFoundException {
		return service.findCoworkspaceById(id) ;
	}
	
	@PutMapping("/cowork")
	public ResponseEntity<ResponseStructure<CoworkSpace>> updateCoworkSpace(@RequestBody CoworkSpace coworkSpace) {
		return service.updateCoWorkSpace(coworkSpace) ;
	}
	
	@DeleteMapping("/cowork/{id}")
	public ResponseEntity<ResponseStructure<CoworkSpace>> deleteCowork(@PathVariable Long id) throws IdNotFoundException {
		return service.deleteCoWorkSpace(id) ;
	}
}
