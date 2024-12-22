package com.fedcorp.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedcorp.admin.apicall.ADSSOCall;
import com.fedcorp.admin.entities.AdLoginUsers;
import com.fedcorp.admin.entities.ApplicationDetails;
import com.fedcorp.admin.entities.ApplicationForms;
import com.fedcorp.admin.entities.ApplicationStaus;
import com.fedcorp.admin.entities.LoginUser;
import com.fedcorp.admin.repositories.AdLoginUsersRepository;
import com.fedcorp.admin.repositories.ApplicationFormRepository;
import com.fedcorp.admin.services.AdLoginUserService;

@Service
public class AdLoginUserServiceImpl implements AdLoginUserService {

	@Autowired
	private AdLoginUsersRepository adLoginUsersRepository;

	@Autowired
	private ApplicationFormRepository applicationFormRepository;





	public LoginUser logincheck(String adUsername) {
		LoginUser loginUser = new LoginUser();
		String username_1id = adUsername;

		String scale = "", username = "", depname = "", officetype = "", empno = "", validuser = "";

		java.lang.String username_1idTemp = null;
		if (!username_1id.equals("")) {
			username_1idTemp = username_1id;
		}

		ADSSOCall adscale = new ADSSOCall();

		String output = adscale.CheckUser(username_1idTemp);

		List<String> list_any16 = java.util.Arrays.asList(output);

		String temp_any16 = list_any16.toString();

		if ((temp_any16.indexOf("<Grade>")) > 0) {
			scale = temp_any16.substring(temp_any16.indexOf("<Grade>"), temp_any16.indexOf("</Grade>"))
					.replace("<Grade>", "").toString().trim();
		}

		if ((temp_any16.indexOf("<validUser>")) > 0) {
			validuser = temp_any16.substring(temp_any16.indexOf("<validUser>"), temp_any16.indexOf("</validUser>"))
					.replace("<validUser>", "").toString().trim();
		}

		if ((temp_any16.indexOf("<displayName>")) > 0) {
			username = temp_any16.substring(temp_any16.indexOf("<displayName>"), temp_any16.indexOf("</displayName>"))
					.replace("<displayName>", "").toString().trim();
		}

		if ((temp_any16.indexOf("<departmentNumber>")) > 0) {
			depname = temp_any16
					.substring(temp_any16.indexOf("<departmentNumber>"), temp_any16.indexOf("</departmentNumber>"))
					.replace("<departmentNumber>", "").toString().trim();
		}

		if ((temp_any16.indexOf("<OfficeType>")) > 0) {
			officetype = temp_any16.substring(temp_any16.indexOf("<OfficeType>"), temp_any16.indexOf("</OfficeType>"))
					.replace("<OfficeType>", "").toString().trim();
		}

		if ((temp_any16.indexOf("<employeeNumber>")) > 0) {
			empno = temp_any16
					.substring(temp_any16.indexOf("<employeeNumber>"), temp_any16.indexOf("</employeeNumber>"))
					.replace("<employeeNumber>", "").toString().trim();
		}

		if (depname.equals("OS1KKN") || depname.equals("OS") || depname.equals("OM") || officetype.equals("Branch")
				|| depname.equals("CD") || depname.equals("DCE")) {
			loginUser.setUserSession(username);
			loginUser.setUserScale(scale);
			loginUser.setDepname(depname);
			loginUser.setOfficetype(officetype);
			loginUser.setEmpno(empno);
			loginUser.setUserName(username_1id);
			loginUser.setDisplayName(username);
		} else if (validuser != null && !validuser.equals("")) {
			AdLoginUsers adminLoginUser = adLoginUsersRepository.findByUsernameAndIsFedservAndStatus(username_1id,true,"Y");
			if (adminLoginUser != null) {
				AdLoginUsers loginDetails = adLoginUsersRepository.findByUsernameAndIsFedserv(username_1id,true);
				if(loginDetails!=null) {
					loginUser.setUserSession(loginDetails.getEmpName());
					loginUser.setUserScale("S4");
					loginUser.setDepname("fedserv");
					loginUser.setOfficetype("fedserv");
					loginUser.setEmpno(loginDetails.getEmployeeNo());
					loginUser.setUserName(username_1id);
				}else {
					loginUser.setUserSession(username_1id);
					loginUser.setUserScale("S4");
					loginUser.setDepname("fedserv");
					loginUser.setOfficetype("fedserv");
					loginUser.setEmpno("0000");
					loginUser.setUserName(username_1id);
				}
				
			} else {
				loginUser=null;
			}

		}else {
			loginUser=null;
		}
		return loginUser;
	}

	public ApplicationForms getForm(Long id) {
		return applicationFormRepository.findById(id).get();
	}

	public List<ApplicationStaus>  applicationStatusCount(String officetype,String branchcode) {
		if (officetype.equals("Branch") && branchcode != "") {
		
			return applicationFormRepository.countDistinctApplicationformWithBranch(branchcode);
		} else {
			return applicationFormRepository.countDistinctApplicationformWithoutBranch();
		}

	}

	public List<ApplicationDetails>  pendingWithBranchApplicationForm(String officetype,String branchcode) {
		if (officetype.equals("Branch") && branchcode != "") {
			List<ApplicationDetails> applicationFormWithBranch = applicationFormRepository.pendingWithBranchApplicationWithBranch(branchcode);
			return applicationFormWithBranch;
		} else {
			List<ApplicationDetails> applicationforbranch = applicationFormRepository.pendingWithBranchApplicationWithoutBranch();
			return applicationforbranch;
		}
		
	}
	
	public List<ApplicationDetails>  pendingWithFinalApplication() {
			List<ApplicationDetails> approvedApplication = applicationFormRepository.pendingWithFinalApplicationWithoutBranch();
			return approvedApplication;
		
		
	}
	
	public List<ApplicationDetails>  approvedApplication(String officetype,String branchcode) {
		if (officetype.equals("Branch") && branchcode != "") {
			List<ApplicationDetails> approvedApplication = applicationFormRepository.approvedApplicationWithBranch(branchcode);
			return approvedApplication;
		} else {
			List<ApplicationDetails> approvedApplication = applicationFormRepository.approvedApplicationWithoutBranch();
			return approvedApplication;
		}
		
	}
	
	
	public List<ApplicationDetails>  rejectedApplication(String officetype,String branchcode) {
		if (officetype.equals("Branch") && branchcode != "") {
			List<ApplicationDetails> rejectedApplication = applicationFormRepository.rejectedApplicationWithBranch(branchcode);
			return rejectedApplication;
		} else {
			List<ApplicationDetails> rejectedApplication = applicationFormRepository.rejectedApplicationWithoutBranch();
			return rejectedApplication;
		}
		
	}
	
	

	public List<ApplicationDetails> searchPendingApplicationForm(String search_refno, String search_acc_name,
			String search_acc_no, String search_mobile) {
		
		List<ApplicationDetails> searchPendingApplicationForm=	applicationFormRepository.searchPendingApplicationForm(search_refno, search_acc_name, search_acc_no, search_mobile);
		return searchPendingApplicationForm;
	}

	public List<ApplicationDetails> searchApplicationFormNotPending(String search_status, String search_refno,
			String search_acc_name, String search_acc_no, String search_mobile) {
		
		List<ApplicationDetails> searchApplicationFormNotPending= applicationFormRepository.searchApplicationFormNotPending(search_status, search_refno, search_acc_name, search_acc_no,search_mobile);
		return searchApplicationFormNotPending;
	}

	public List<ApplicationDetails> searchPendingApplicationFormWithBranch(String branchcode, String search_refno,String search_acc_name, String search_acc_no, String search_mobile) {
		
		List<ApplicationDetails> searchPendingApplicationFormWithBranch= applicationFormRepository.searchPendingApplicationFormWithBranch(branchcode,search_refno, search_acc_name, search_acc_no,search_mobile);

		return searchPendingApplicationFormWithBranch;
	}

	public List<ApplicationDetails> searchStatusApplicationFormWithBranch(String search_status, String branchcode,
			String search_refno, String search_acc_name, String search_acc_no, String search_mobile) {
		List<ApplicationDetails> searchStatusApplicationFormWithBranch= applicationFormRepository.searchStatusApplicationFormWithBranch(search_status,branchcode, search_refno, search_acc_name, search_acc_no,search_mobile);

		return searchStatusApplicationFormWithBranch;
	}

	
	
}
