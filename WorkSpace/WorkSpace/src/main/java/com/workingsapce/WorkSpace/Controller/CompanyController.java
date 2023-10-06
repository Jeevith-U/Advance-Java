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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.workingsapce.WorkSpace.Entity.Building;
import com.workingsapce.WorkSpace.Entity.Company;
import com.workingsapce.WorkSpace.Entity.WorkSpace;
import com.workingsapce.WorkSpace.Exception.IdNotFoundException;
import com.workingsapce.WorkSpace.ResponseStructure.ResponseStructure;
import com.workingsapce.WorkSpace.Service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService service ;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Company>> saveCompany(@RequestBody Company company) {
		return service.saveCompany(company) ;
	}
	
	
	@GetMapping("/{companyId}")
	public ResponseEntity<ResponseStructure<Company>> findById(@PathVariable long id) throws IdNotFoundException {
		return service.findCompanyById(id) ;
	}
	
	@PostMapping("/workspaceId")
	public ResponseEntity<ResponseStructure<WorkSpace>> saveCompanyInWorkSpace(@RequestBody Company company, @PathVariable long id ) throws IdNotFoundException{
		return service.saveCompanyInWorkSpace(company, id) ;
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Company>> updateCompany(@RequestBody Company company) {
		return service.updateCompany(company) ;
	}
	
	@DeleteMapping("/{companyId}")
	public ResponseEntity<ResponseStructure<Company>> deleteCompany(@PathVariable long id) {
		return service.deleteCompany(id) ;
	}
}
