package com.fedcorp.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fedcorp.admin.apicall.CustomerDetailsDev;
import com.fedcorp.admin.apicall.Utilities;
import com.fedcorp.admin.entities.ApplicationEnterprises;
import com.fedcorp.admin.entities.ApplicationUsers;
import com.fedcorp.admin.entities.Branch;
import com.fedcorp.admin.entities.BranchVerifications;
import com.fedcorp.admin.entities.Documents;
import com.fedcorp.admin.entities.LoginUser;
import com.fedcorp.admin.service.impl.AdLoginUserServiceImpl;
import com.fedcorp.admin.service.impl.ApplicationEnterpriseServiceImpl;
import com.fedcorp.admin.service.impl.ApplicationFormServiceImpl;
import com.fedcorp.admin.service.impl.ApplicationServiceImpl;
import com.fedcorp.admin.service.impl.ApplicationUserServiceImpl;
import com.fedcorp.admin.service.impl.BranchServiceImpl;
import com.fedcorp.admin.service.impl.BranchVerificationServiceImpl;
import com.fedcorp.admin.service.impl.DocumentServiceImpl;
import com.fedcorp.admin.service.impl.EnterpriseServiceImpl;
import com.fedcorp.admin.service.impl.UserServiceImpl;

@Controller
public class ApplicationController {

	

	@Autowired
	public AdLoginUserServiceImpl adLoginUserService;

	@Autowired
	public CustomerDetailsDev customerDetailsDev;

	@Autowired
	public ApplicationServiceImpl applicationServiceImpl;

	@Autowired
	public ApplicationEnterpriseServiceImpl applicationEnterpriseServiceImpl;

	@Autowired
	public ApplicationUserServiceImpl applicationUserServiceImpl;

	@Autowired
	public BranchServiceImpl branchServiceImpl;

	@Autowired
	public BranchVerificationServiceImpl branchVerificationServiceImpl;

	@Autowired
	public DocumentServiceImpl documentServiceImpl;

	@Autowired
	public ApplicationFormServiceImpl applicationFormServiceImpl;

	@Autowired
	public Utilities utilities;

	@Autowired
	public EnterpriseServiceImpl enterpriseServiceImpl;

	@Autowired
	public UserServiceImpl userServiceImpl;

	@PostMapping(value = "registernewapp")
	public String submitNewApplicationForm(@ModelAttribute ApplicationEnterprises applicationEnterprises,
			@ModelAttribute Documents documents, @RequestParam("documentfile") MultipartFile documentfile,
			@ModelAttribute ApplicationUsers applicationUsers, @ModelAttribute Branch branches,
			@ModelAttribute BranchVerifications branchVerifications, Model model,HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		LoginUser adLoginUsers = (LoginUser) request.getSession().getAttribute("logindetails");
		JSONObject row = new JSONObject();
		String acc_no = applicationEnterprises.getAccNo();
		String acc_name = applicationEnterprises.getAccName();
		String cust_no = applicationEnterprises.getCustNo();
		String branchCode = branches.getBranchCode();
		String address = applicationEnterprises.getAddress();
		String constitution = applicationEnterprises.getConstitution();
		Long daily_limit = applicationEnterprises.getDailyLimit();
		Long monthly_limit = applicationEnterprises.getMonthlyLimit();
		String pref_corp = applicationEnterprises.getPrefCorp();
		String solid = branches.getSolId();
		String mode_of_operation = branchVerifications.getModeOfOperation();
//		Boolean board_resolution_confirmed = branchVerifications.getBoardResolutionConfirmed();
//		Boolean mode_of_operation_confirmed = branchVerifications.getModeOfOperationConfirmed();
		MultipartFile document = documentfile;
		String document_type = documents.getDocumentType();
		Long days = applicationEnterprises.getDays();
		Long hours = applicationEnterprises.getHours();
		Long minutes = applicationEnterprises.getMinutes();
		String auth_fund = applicationEnterprises.getAuthFund();
		String auth_ext = applicationEnterprises.getAuthExt();
		String auth_ben = applicationEnterprises.getAuthBen();
		String declaration = applicationEnterprises.getDeclaration();
//		String created_by = applicationUsers.getApplicationCreatedBy();
		String created_by = adLoginUsers.getUserSession();
		String reference_id = applicationEnterprises.getApplicationReferenceId();
		List<String> user_names = applicationUsers.getApplicationUserName();
		List<String> pref_noo = applicationUsers.getApplicationPrefNo();
		List<String> user_cust_no = applicationUsers.getApplicationCustNo();
		List<String> user_mobile_no = applicationUsers.getApplicationMobileNo();
		List<Long> trans_limit_0 = applicationUsers.getApplicationTransLimit();
		List<Boolean> authorized_signatory = applicationUsers.getApplicationAuthSignatory();

		/* validate start */
		row=applicationServiceImpl.submitvalidation(acc_no,acc_name,cust_no,branchCode,address,constitution,daily_limit,monthly_limit,pref_corp,auth_fund,auth_ext,auth_ben,reference_id,user_names,user_cust_no,pref_noo,user_mobile_no,trans_limit_0,authorized_signatory);
		/* validate end */
		String finalResultId="";
		String errorMsg = "";
		if (row.length()==0) {
			 finalResultId=applicationServiceImpl.createApplication(acc_no,acc_name,cust_no,branchCode,address,constitution,solid,mode_of_operation,document,document_type,
						daily_limit,monthly_limit,pref_corp,days,hours,minutes,auth_fund,auth_ext,auth_ben,declaration,created_by,reference_id,user_names,pref_noo,user_cust_no,
						user_mobile_no,trans_limit_0,authorized_signatory);
			if(!finalResultId.equals("")) {
				redirectAttributes.addFlashAttribute("successMsg", finalResultId);
			}else {
				errorMsg = "Something Went Wrong, Please try again later";
				redirectAttributes.addFlashAttribute("errorMsg", errorMsg);
			}
		}else {
			errorMsg = "Something Went Wrong, Please try again later";
			redirectAttributes.addFlashAttribute("errorMsg", errorMsg);
		}
		return "redirect:/homepage";
	}

	@PostMapping("forwardApplicationSubmit")
	public String forwardApplicationSubmit(@ModelAttribute ApplicationEnterprises applicationEnterprises,
			@RequestParam("appid") Long appid, @ModelAttribute Documents documents,
			@RequestParam("documentfile") MultipartFile documentfile, @ModelAttribute ApplicationUsers applicationUsers,
			@ModelAttribute Branch branches, @ModelAttribute BranchVerifications branchVerifications, Model model,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {

		String error = "";
		Long application_id = appid;
		Long applicationEnterprisesId = applicationEnterprises.getId();
		Long daily_limit = applicationEnterprises.getDailyLimit();
		Long monthly_limit = applicationEnterprises.getMonthlyLimit();
		String mode_of_operation = branchVerifications.getModeOfOperation();
		Boolean board_resolution_confirmed = branchVerifications.getBoardResolutionConfirmed();
		Boolean mode_of_operation_confirmed = branchVerifications.getModeOfOperationConfirmed();
		MultipartFile document = documentfile;
		String document_type = documents.getDocumentType();
		Long days = applicationEnterprises.getDays();
		Long hours = applicationEnterprises.getHours();
		Long minutes = applicationEnterprises.getMinutes();
		String auth_fund = applicationEnterprises.getAuthFund();
		String auth_ext = applicationEnterprises.getAuthExt();
		String auth_ben = applicationEnterprises.getAuthBen();
		String declaration = applicationEnterprises.getDeclaration();
		String created_by = applicationUsers.getApplicationCreatedBy();
		String reference_id = applicationEnterprises.getApplicationReferenceId();
		List<String> user_names = applicationUsers.getApplicationUserName();
		List<String> pref_noo = applicationUsers.getApplicationPrefNo();
		List<String> user_cust_no = applicationUsers.getApplicationCustNo();
		List<String> user_mobile_no = applicationUsers.getApplicationMobileNo();
		List<Long> trans_limit_0 = applicationUsers.getApplicationTransLimit();
		List<Boolean> authorized_signatory = applicationUsers.getApplicationAuthSignatory();
		
			error= applicationServiceImpl.forwardValidation(application_id,applicationEnterprisesId,mode_of_operation,board_resolution_confirmed,mode_of_operation_confirmed, document,document_type,declaration,created_by,reference_id,days,hours,minutes,  daily_limit,monthly_limit,auth_fund,auth_ext,auth_ben,user_names,pref_noo,user_cust_no,user_mobile_no,trans_limit_0,authorized_signatory);
			if (error.equals("")) {
				String appref=applicationServiceImpl.forward(application_id,applicationEnterprisesId,mode_of_operation,board_resolution_confirmed,mode_of_operation_confirmed,document,document_type,declaration,created_by,reference_id,days,hours,minutes, daily_limit,monthly_limit,auth_fund,auth_ext,auth_ben,user_names,pref_noo,user_cust_no,user_mobile_no,trans_limit_0, authorized_signatory);
				
				if(!appref.equals("")) {
					redirectAttributes.addFlashAttribute("ref_no", appref);
				}else {
					String errorMsg = "Something Went Wrong, Please try again later";
					redirectAttributes.addFlashAttribute("errorMsg", errorMsg);
				}
			}else {
				String errorMsg = "Something Went Wrong, Please try again later";
				redirectAttributes.addFlashAttribute("errorMsg", errorMsg);
			}
			return "redirect:/homepage";

	}

	@PostMapping("applicationapprove")
	public String applicationapprove(@ModelAttribute ApplicationEnterprises applicationEnterprises, @RequestParam("appid") Long appid, RedirectAttributes redirectAttributes, HttpServletRequest request) {

		long long_application_id = appid;
		String app_Refer_No = "";
		LoginUser adLoginUsers = (LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/";
		} else {
			Long application_form_id = appid;
			Long entid = applicationEnterprises.getId();
			String acc_name = applicationEnterprises.getAccName();
			String acc_no = applicationEnterprises.getAccNo();
			String cust_no = applicationEnterprises.getCustNo();
			String pref_corp = applicationEnterprises.getPrefCorp();
			String address = applicationEnterprises.getAddress();
			String constitution = applicationEnterprises.getConstitution();
			String auth_fund = applicationEnterprises.getAuthFund();
			String auth_ben = applicationEnterprises.getAuthBen();
			String auth_ext = applicationEnterprises.getAuthExt();
			String loginname = adLoginUsers.getUserSession();
//			Long dailylimit = applicationEnterprises.getDailyLimit();
//			Long monthlimit = applicationEnterprises.getMonthlyLimit();
			String error=applicationServiceImpl.approvedValidation(application_form_id,entid,auth_fund,auth_ext,auth_ben,constitution,address,pref_corp,cust_no,acc_no,acc_name);
			
			if (error.equals("")) {
				System.out.println("application approve started for account " + acc_no + " application formid "	+ application_form_id + " appln enterpriseid " + entid);
				try {
					long get_enterpries_id = 0;
					System.out.println("checking enterprise records with applcationid " + long_application_id);
					long checkcust_ID = enterpriseServiceImpl.checkEnterprisetable(long_application_id);
					if (checkcust_ID == 0) {
						get_enterpries_id = enterpriseServiceImpl.enterprises_users(acc_name, auth_fund, auth_ben, auth_ext, pref_corp, acc_no, cust_no, address, constitution, long_application_id);
						System.out.println( "no records in enterprise adding enterprise prefcorp " + pref_corp + " account " + acc_no);
					} else {
						get_enterpries_id = checkcust_ID;
						System.out.println("with application id records are exist in enterprise and id " + get_enterpries_id);
					}
					String strLong_ent_id = Long.toString(get_enterpries_id);
					if (get_enterpries_id != 0) {
						System.out.println("with application id records are exist in enterprise and enterpriseid " + strLong_ent_id + " applicatnenterpriseid " + entid);
						long get_user_id = userServiceImpl.users_register(entid.toString(), strLong_ent_id);
						if (get_user_id != 0) {
							System.out.println("setting daily and monthly limit for existing record enterpriseid "+ strLong_ent_id + " applicatnenterpriseid " + entid);
	//						long getlimitid=addtranslimit("daily", strLong_ent_id, dailylimit);
	//						long getlimitid2=addtranslimit("monthly", strLong_ent_id, monthlimit);
							long getappid = applicationFormServiceImpl.finalapplicationapproveStatus(long_application_id, loginname);
							app_Refer_No = applicationFormServiceImpl.getReferenceNo(getappid);						
						}
					} 
				} catch (Exception e) {
					app_Refer_No="";
					e.printStackTrace();
				}
			}
		if(!app_Refer_No.equals("")) {
			redirectAttributes.addFlashAttribute("final_ref_no", app_Refer_No);	
		}else {
			String errorMsg = "Something Went Wrong, Please try again later";
			redirectAttributes.addFlashAttribute("message", errorMsg);
		}
			return "redirect:/approvelist";
		}

	}

	@PostMapping("modifiedApplication")
	public String modifiedApplicationSubmit(@ModelAttribute ApplicationEnterprises applicationEnterprises,
			@RequestParam("appid") Long appid, @ModelAttribute Documents documents,
			@RequestParam("documentfile") MultipartFile documentfile, @ModelAttribute ApplicationUsers applicationUsers,
			@ModelAttribute Branch branches, @ModelAttribute BranchVerifications branchVerifications, Model model,
			RedirectAttributes redirectAttributes) throws IOException {

		
		Long application_id = appid;
		Long applicationEnterprisesId = applicationEnterprises.getId();
		Long daily_limit = applicationEnterprises.getDailyLimit();
		Long monthly_limit = applicationEnterprises.getMonthlyLimit();
		String mode_of_operation = branchVerifications.getModeOfOperation();
//		Boolean board_resolution_confirmed = branchVerifications.getBoardResolutionConfirmed();
//		Boolean mode_of_operation_confirmed = branchVerifications.getModeOfOperationConfirmed();
		MultipartFile document = documentfile;
		String document_type = documents.getDocumentType();
		Long days = applicationEnterprises.getDays();
		Long hours = applicationEnterprises.getHours();
		Long minutes = applicationEnterprises.getMinutes();
		String auth_fund = applicationEnterprises.getAuthFund();
		String auth_ext = applicationEnterprises.getAuthExt();
		String auth_ben = applicationEnterprises.getAuthBen();
		String declaration = applicationEnterprises.getDeclaration();
		String created_by = applicationUsers.getApplicationCreatedBy();
		String reference_id = applicationEnterprises.getApplicationReferenceId();
		List<String> user_names = applicationUsers.getApplicationUserName();
		List<String> pref_noo = applicationUsers.getApplicationPrefNo();
		List<String> user_cust_no = applicationUsers.getApplicationCustNo();
		List<String> user_mobile_no = applicationUsers.getApplicationMobileNo();
		List<Long> trans_limit_0 = applicationUsers.getApplicationTransLimit();
		List<Boolean> authorized_signatory = applicationUsers.getApplicationAuthSignatory();
		String error=applicationServiceImpl.modifiedValidation(application_id,applicationEnterprisesId,daily_limit,monthly_limit,mode_of_operation,document,document_type,days,hours,minutes,auth_fund,auth_ext,auth_ben,declaration,created_by, reference_id,user_names,pref_noo,user_cust_no,user_mobile_no,trans_limit_0,	authorized_signatory);
		String app_Refer_No="";
		if (error.equals("")) {
			app_Refer_No=applicationServiceImpl.modifiedApplication(application_id,applicationEnterprisesId,daily_limit,monthly_limit,mode_of_operation, document,document_type,days,hours,minutes,auth_fund,auth_ext,auth_ben,declaration,created_by, reference_id,user_names,pref_noo,user_cust_no,user_mobile_no,trans_limit_0,	authorized_signatory);
			if(!app_Refer_No.equals("")) {
				redirectAttributes.addFlashAttribute("ref_no", app_Refer_No);
			}else {
				String errorMsg = "Something went wrong please try again later.";
				redirectAttributes.addFlashAttribute("message", errorMsg);
			}
		}else {
			String errorMsg = "Something went wrong please try again later.";
			redirectAttributes.addFlashAttribute("message", errorMsg);
		}
		return "redirect:/approvelist";
	}
}
