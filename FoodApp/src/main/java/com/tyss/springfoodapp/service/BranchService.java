package com.tyss.springfoodapp.service;

import java.util.List;
import javax.management.Query;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tyss.springfoodapp.dao.BranchDao;
import com.tyss.springfoodapp.dto.Branch;

@Component
@Scope(value = "prototype")
public class BranchService {

	@Autowired
	private BranchDao dao;

	@Autowired
	private EntityManager entityManager;

	public Branch saveBranch(Branch branch) {
		return dao.saveBranch(branch);
	}

	public Branch findBranch(int id) {
		return dao.findBranch(id);
	}

	public Branch updateBranchervice(Branch branch) {

		return dao.updateBranch(branch);
	}

	public boolean deleteBranchervice(int id) {

		return dao.deleteBranch(id);
	}

	public List<Branch> getAllBranchervice() {
		javax.persistence.Query query = entityManager.createQuery("from Branch");
		return query.getResultList();
	}
}
