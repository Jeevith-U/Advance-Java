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

import com.workingsapce.WorkSpace.Entity.Floor;
import com.workingsapce.WorkSpace.Entity.WorkSpace;
import com.workingsapce.WorkSpace.Exception.IdNotFoundException;
import com.workingsapce.WorkSpace.ResponseStructure.ResponseStructure;
import com.workingsapce.WorkSpace.Service.WorkspaceService;

@RestController
@RequestMapping("/workspace")
public class WorkSpaceController {
	
	@Autowired
	private WorkspaceService service ;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<WorkSpace>> saveWorkSpace(@RequestBody WorkSpace workSpace) {
		
		return service.saveWorkSpace(workSpace) ;
	}
	
	@GetMapping("/{workspaceId}")
	public ResponseEntity<ResponseStructure<WorkSpace>> findWorkSpaceById(@PathVariable long id) throws IdNotFoundException {
		return service.findWorkspaceById(id) ;
	}
	
	@PutMapping("/{floorId}")
	public ResponseEntity<ResponseStructure<Floor>> saveWorkSpaceInFloor(@RequestBody WorkSpace space, @PathVariable long id) throws IdNotFoundException{
		return service.saveWorkSpaceInFloor(space, id) ;
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<WorkSpace>> updateWorkSpace(@RequestBody WorkSpace workSpace) {
		return service.updateWorkSpace(workSpace) ;
	}
	
	@DeleteMapping("/{workspaceId}")
	public ResponseEntity<ResponseStructure<WorkSpace>> deletingWorkSpace(@PathVariable long id){
		return service.deleteWorkSpace(id) ;
	}
}
