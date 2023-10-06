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

import com.workingsapce.WorkSpace.Entity.Company;
import com.workingsapce.WorkSpace.Entity.Room;
import com.workingsapce.WorkSpace.Exception.IdNotFoundException;
import com.workingsapce.WorkSpace.ResponseStructure.ResponseStructure;
import com.workingsapce.WorkSpace.Service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService service ;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Room>> saveRoom(@RequestBody Room room) {
		return service.saveRoom(room) ;
	}
	
	@PostMapping("/companyId")
	public ResponseEntity<ResponseStructure<Room>> saveRoomInCompany(@RequestBody  Room room,
			@PathVariable long id) throws IdNotFoundException{
		return service.saveRoomInCompany(room, id) ;
		
	}
	
	@GetMapping("/{roomId}")
	public ResponseEntity<ResponseStructure<Room>> findById(@PathVariable long id) throws IdNotFoundException {
		return service.findById(id) ;
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Room>> updateById(@RequestBody Room room) {
		return service.updateRoom(room) ;
	}
	
	@DeleteMapping("/{roomId}")
	public ResponseEntity<ResponseStructure<Room>> deleteById(@PathVariable long id){
		return service.deleteRoom(id) ;
	}
}
