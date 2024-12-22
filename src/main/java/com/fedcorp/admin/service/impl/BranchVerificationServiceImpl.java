package com.fedcorp.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedcorp.admin.entities.BranchVerifications;
import com.fedcorp.admin.repositories.BranchVerificationsRepository;

@Service
public class BranchVerificationServiceImpl {
	
	@Autowired
	private BranchVerificationsRepository branchVerificationsRepository;

	public Long branch_verifications(Long appform_id, String mode_of_operation, Boolean board_resolution_confirmed, Boolean mode_of_operation_confirmed) {
		Long branchVerificationsId = null;
		  BranchVerifications branchVerifications=new BranchVerifications();
		    try {	
		    	
		    	branchVerifications.setApplicationFormId(appform_id);
		    	branchVerifications.setModeOfOperation(mode_of_operation);
		    	branchVerifications.setBoardResolutionConfirmed(board_resolution_confirmed);
		    	branchVerifications.setModeOfOperationConfirmed(mode_of_operation_confirmed);
		    	branchVerifications.setUserDetailsConfirmed(false);		    
		    	BranchVerifications newBranchVerification=branchVerificationsRepository.save(branchVerifications);	
		    	if(newBranchVerification!=null) {
		    		branchVerificationsId = newBranchVerification.getId(); 
		    	}		    	
		        System.out.println(" data save   into branchVerifications table....");		       
		    } catch (Exception e) {
		      e.printStackTrace();
		      System.out.println(" error during  data save   into branchVerifications  :"+e.getMessage());	
		    } 
		    return branchVerificationsId;
	}

	public int checkBranchVerification(long appform_id) {
			int getUserCont=0;			
			 try {				 
				getUserCont= branchVerificationsRepository.countByApplicationFormId(appform_id);	 
			} catch (Exception e) {
				e.printStackTrace();		
			}
			return getUserCont;
	}

  public long update_branch_verifications(long appform_id, String mode_of_operation) {
		 long returnkeyid = 0;
	     try {	    	 
	    	 BranchVerifications branchVerifications= branchVerificationsRepository.findByApplicationFormId(appform_id);	    	
	    	 branchVerifications.setModeOfOperation(mode_of_operation);
	    	 BranchVerifications updatedBranchVerifications= branchVerificationsRepository.save(branchVerifications);
			 returnkeyid=updatedBranchVerifications.getApplicationFormId();	
		
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return returnkeyid;			
	}
}
