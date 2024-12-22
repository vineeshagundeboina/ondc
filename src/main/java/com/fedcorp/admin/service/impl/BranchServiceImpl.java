package com.fedcorp.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedcorp.admin.entities.Branch;
import com.fedcorp.admin.repositories.BranchRepository;

@Service
public class BranchServiceImpl {

	@Autowired
	private BranchRepository branchRepository;
	
	
	public Long getBranchDetails(String solid, String branchCode) {
		Long getBranchId = null;
	    try {	    	
	    	Branch branch=	branchRepository.findFirstElementBySolIdAndBranchCode(solid,branchCode);
	    	if(branch!=null) {
	    		getBranchId=branch.getId();
	    	}
	    } catch (Exception e) {
	      e.printStackTrace();
	      
	    } 
	    return getBranchId;
	}

}
