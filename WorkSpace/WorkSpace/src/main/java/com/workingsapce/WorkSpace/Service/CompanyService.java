package com.workingsapce.WorkSpace.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.workingsapce.WorkSpace.Dao.CompanyDao;
import com.workingsapce.WorkSpace.Dao.WorkSpaceDao;
import com.workingsapce.WorkSpace.Entity.Company;
import com.workingsapce.WorkSpace.Entity.WorkSpace;
import com.workingsapce.WorkSpace.Exception.IdNotFoundException;
import com.workingsapce.WorkSpace.ResponseStructure.ResponseStructure;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyDao dao ;
	
	@Autowired
	private WorkSpaceDao workSpaceDao ;
	
	public ResponseEntity<ResponseStructure<Company>> saveCompany(Company company) {

		if (company != null) {
			ResponseStructure<Company> response = new ResponseStructure<Company>();
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage(HttpStatus.CREATED.getReasonPhrase());
			response.setMessage("Company Saved Successfully...");
			response.setData(dao.saveCompany(company));
			dao.saveCompany(dao.saveCompany(company));
			return new ResponseEntity<ResponseStructure<Company>>(response, HttpStatus.CREATED);
		} else {

			ResponseStructure<Company> response = new ResponseStructure<Company>();
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<Company>>(response, HttpStatus.CREATED);
		}
	}

	public ResponseEntity<ResponseStructure<Company>> findCompanyById(long id) throws IdNotFoundException {

		if (dao.findById(id) != null) {
			ResponseStructure<Company> response = new ResponseStructure<Company>();
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage(HttpStatus.CREATED.getReasonPhrase());
			dao.findById(id);
			response.setData(dao.findById(id));
			return new ResponseEntity<ResponseStructure<Company>>(response, HttpStatus.CREATED);
		} else
			throw new IdNotFoundException();
	}

   public ResponseEntity<ResponseStructure<Company>> updateCompany(Company company){
		
		if (company != null) {
			ResponseStructure<Company> response = new ResponseStructure<Company>() ;
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage(HttpStatus.OK.getReasonPhrase());
			response.setData(company);
			dao.updateCoWork(company) ;
			return new ResponseEntity<ResponseStructure<Company>>(response, HttpStatus.OK) ;
		}else {
			
			ResponseStructure<Company> response = new ResponseStructure<Company>() ;
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<Company>>(response, HttpStatus.OK) ;
		}
    }
   
   public ResponseEntity<ResponseStructure<Company>> deleteCompany(long id){
	   
		if (id != 0) {
			ResponseStructure<Company> response = new ResponseStructure<Company>() ;
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(dao.findById(id));
			dao.deleteCompany(id) ;
			return new ResponseEntity<ResponseStructure<Company>>(response, HttpStatus.OK) ;
		}else {
			
			ResponseStructure<Company> response = new ResponseStructure<Company>() ;
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
			response.setMessage(HttpStatus.NO_CONTENT.getReasonPhrase());
			response.setData(null);
			return new ResponseEntity<ResponseStructure<Company>>(response, HttpStatus.OK) ;
		}
   }

    public ResponseEntity<ResponseStructure<WorkSpace>> saveCompanyInWorkSpace(Company company, long id) throws IdNotFoundException {
    	
    	WorkSpace workspace = workSpaceDao.findById(id) ;
    	if (workspace != null && company != null) {
    		ResponseStructure<WorkSpace> response = new ResponseStructure<WorkSpace>() ;
    		response.setStatusCode(HttpStatus.CREATED.value());
    		response.setMessage(HttpStatus.CREATED.getReasonPhrase());
    		response.setData(workspace);
    		if (workspace.getCompany() != null) {
				workspace.setCompany(company);
			}
    		else {
    			workspace.setCompany(company);
    		}
    		workSpaceDao.saveWorkSpace(workspace) ;
    		return new ResponseEntity<ResponseStructure<WorkSpace>>(response, HttpStatus.CREATED) ;
		}
    	else {
    		throw new IdNotFoundException() ;
    	}
}
}
