package com.fedcorp.admin.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fedcorp.admin.apicall.CustomerDetailsDev;
import com.fedcorp.admin.apicall.Utilities;
import com.fedcorp.admin.entities.ApplicationDetails;
import com.fedcorp.admin.entities.ApplicationEnterprises;
import com.fedcorp.admin.entities.ApplicationForms;
import com.fedcorp.admin.entities.ApplicationUsers;
import com.fedcorp.admin.entities.Comments;
import com.fedcorp.admin.entities.Documents;
import com.fedcorp.admin.entities.Enterprises;
import com.fedcorp.admin.entities.Users;
import com.fedcorp.admin.file.FileNetUpload;
import com.fedcorp.admin.repositories.ApplicationEnterprisesRepository;
import com.fedcorp.admin.repositories.ApplicationFormRepository;
import com.fedcorp.admin.repositories.ApplicationUsersRepository;
import com.fedcorp.admin.repositories.CommentsRepository;
import com.fedcorp.admin.repositories.DocumentsRepository;
import com.fedcorp.admin.repositories.EnterprisesRepository;
import com.fedcorp.admin.repositories.UsersRespository;
import com.fedcorp.admin.services.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	
	public	static String filepathloc = "";
	public static	String userName = "";
	public static String password = "";
	public static String stanza = "";
	public static String uri = "";
	public static	String obStore = "";
	public static String foldername = "";
	
	@Autowired
	private ApplicationFormRepository applicationFormRepository;

	@Autowired
	private CommentsRepository commentsRepository;

	@Autowired
	private DocumentsRepository documentsRepository;

	@Autowired
	private ApplicationUsersRepository applicationUsersRepository;

	@Autowired
	private UsersRespository usersRespository;

	@Autowired
	private EnterprisesRepository enterprisesRepository;

	@Autowired
	private ApplicationEnterprisesRepository applicationEnterprisesRepository;
	
	
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

	
	static {
		Properties props = new Properties();
			try {
				props.load(Thread.currentThread().getContextClassLoader() .getResourceAsStream("application.properties"));
				   filepathloc = System.getenv("fileuploadloc");
				   userName = System.getenv("filenet_uname");
					password = System.getenv("filenet_pwd");
					stanza = System.getenv("filenet_stanza");
					uri = System.getenv("filenet_url");
					obStore = System.getenv("filenet_obStore");
					foldername = System.getenv("filenet_foldername");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	

	public ApplicationDetails applicationDetails(String applicationid) {
		return applicationFormRepository.getForwardedApplicationDetails(applicationid);
	}

	public List<Comments> applicationComments(String applicationid) {

		return commentsRepository.applicationComments(applicationid);

	}

	public List<Documents> applicationDocuments(String applicationid) {

		return documentsRepository.applicationDocuments(applicationid);

	}

	public List<ApplicationUsers> applicationUser(String applicationid) {

		return applicationUsersRepository.applicationUser(applicationid);

	}

	public String rejectApplication(Long applnid, String uname) {

		Date date = new Date();
		String resubmittedBy = "";
		String refNo = "";
		String enterprisesId = "";
		long applicationEnterprisesId = 0;

		ApplicationForms rejectApplication = applicationFormRepository.findById(applnid).get();
		if (rejectApplication != null) {
			ApplicationEnterprises applicationEnterprise = applicationEnterprisesRepository
					.findByApplicationFormId(applnid);
			if (applicationEnterprise != null) {
				refNo = rejectApplication.getRefNo();
				resubmittedBy = rejectApplication.getResubmittedBy();
				applicationEnterprisesId = applicationEnterprise.getId();
				Enterprises enterprisesApplication = enterprisesRepository
						.findFirstByApplicationFormId(applicationEnterprise.getApplicationFormId());
				if (enterprisesApplication != null) {
					enterprisesId = Long.toString(enterprisesApplication.getId());
				}
			}

		}

		if (resubmittedBy != "" && resubmittedBy != null) {
			String entstrLong = Long.toString(applicationEnterprisesId);

			ApplicationForms applnform = applicationFormRepository.findById(applnid).get();
			applnform.setStatus("rejected");
			applnform.setStatusDesc("Application is rejected");
			applnform.setRejectedBy(uname);
			applnform.setRejectedAt(date);
			applnform.setUpdatedAt(date);
			applicationFormRepository.save(applnform);

			List<ApplicationUsers> applicationUsers = applicationUsersRepository
					.findByApplicationEnterpriseId(entstrLong);
			if (!applicationUsers.isEmpty()) {
				for (ApplicationUsers element : applicationUsers) {
					element.setActive(false);
					applicationUsersRepository.save(element);
				}
			}

			if (!enterprisesId.equals("")) {
				List<Users> users = usersRespository.findByEnterprisesId(enterprisesId);
				if (!users.isEmpty()) {
					for (Users element : users) {
						element.setMarkAsEnabled(0);
						usersRespository.save(element);
					}
				}

			}
			List<Enterprises> enterprises = enterprisesRepository.findByApplicationFormId(applnid);
			if (!enterprises.isEmpty()) {
				for (Enterprises element : enterprises) {
					element.setActive(false);
					element.setUpdatedAt(date);
					enterprisesRepository.save(element);
				}
			}

		} else {
			String entstrLong = Long.toString(applicationEnterprisesId);
			ApplicationForms applnform = applicationFormRepository.findById(applnid).get();
			applnform.setStatus("rejected");
			applnform.setStatusDesc("Application is rejected");
			applnform.setRejectedBy(uname);
			applnform.setRejectedAt(date);
			applnform.setUpdatedAt(date);
			applicationFormRepository.save(applnform);

			List<ApplicationUsers> applicationUsers = applicationUsersRepository
					.findByApplicationEnterpriseId(entstrLong);
			if (!applicationUsers.isEmpty()) {
				for (ApplicationUsers element : applicationUsers) {
					element.setActive(false);
					applicationUsersRepository.save(element);
				}
			}

			if (!enterprisesId.equals("")) {
				List<Users> users = usersRespository.findByEnterprisesId(enterprisesId);
				if (!users.isEmpty()) {
					for (Users element : users) {
						element.setMarkAsEnabled(0);
						usersRespository.save(element);
					}
				}

			}
			List<Enterprises> enterprises = enterprisesRepository.findByApplicationFormId(applnid);
			if (!enterprises.isEmpty()) {
				for (Enterprises element : enterprises) {
					element.setActive(false);
					element.setUpdatedAt(date);
					enterprisesRepository.save(element);
				}
			}
		}

		return refNo;
	}

	public void removeNewAppln(String authuserapplnid, String authuserperfid) {
		if (authuserapplnid != "" && authuserapplnid != null && authuserperfid != "" && authuserperfid != null) {
			System.out.print("application user id-----:" + authuserapplnid);
			System.out.print("pref no ---:" + authuserperfid);
			Long applnid = Long.parseLong(authuserapplnid);
			Date date = new Date();
			List<Users> users = usersRespository.findByPrefNo(authuserperfid);
			
			if (users != null && !users.isEmpty()) {
				for (Users element : users) {
					element.setMarkAsEnabled(0);
					element.setUpdatedAt(date);
					usersRespository.save(element);
				}
				
			}

			ApplicationUsers applicationUsers = applicationUsersRepository.findById(applnid).get();
			if (applicationUsers != null) {
				applicationUsers.setActive(false);
				applicationUsers.setUpdatedAt(date);
				applicationUsersRepository.save(applicationUsers);
			}

		}

	}

	public ApplicationDetails pendingWithFinalappln(String applicationid) {
		return applicationFormRepository.pendingWithFinalappln(applicationid);
	}

	public String resubmitappln(Long applnid, String uname) {
		String refno = "", resumt = "";
		Long applicationEnterprisesId = null;
		System.out.print("Resubmit_applnid>>>>" + applnid);
		Date date = new Date();
		ApplicationForms applicationForm = applicationFormRepository.findById(applnid).get();
		if (applicationForm != null) {
			ApplicationEnterprises applicationEnterprises = applicationEnterprisesRepository
					.findByApplicationFormId(applicationForm.getId());
			applicationEnterprisesId = applicationEnterprises.getId();
			refno = applicationForm.getRefNo();
			resumt = applicationForm.getResubmittedBy();
		}
		if (resumt != "" && resumt != null) {
			ApplicationForms currentApplicationForms = applicationFormRepository.findById(applnid).get();
			currentApplicationForms.setStatus("new");
			currentApplicationForms.setStatusDesc("Application is Submitted and Will be confirmed soon");
			currentApplicationForms.setResubmittedBy(uname);
			currentApplicationForms.setResubmittedAt(date);
			currentApplicationForms.setUpdatedAt(date);
			ApplicationForms updateApplicationForm = applicationFormRepository.save(currentApplicationForms);
			if (updateApplicationForm != null) {
				return refno;
			} else {
				return refno;
			}

		} else {
			ApplicationForms currentApplicationForms = applicationFormRepository.findById(applnid).get();
			currentApplicationForms.setStatus("new");
			currentApplicationForms.setStatusDesc("Application is Submitted and Will be confirmed soon");
			currentApplicationForms.setResubmittedBy(uname);
			currentApplicationForms.setResubmittedAt(date);
			currentApplicationForms.setUpdatedAt(date);
			ApplicationForms updateApplicationForm = applicationFormRepository.save(currentApplicationForms);
			if (updateApplicationForm != null) {
				return refno;
			} else {
				return refno;
			}

		}

	}

	public Comments saveComments(String appid, String displayName, String body) {
		Date date = new Date();
		Comments newcomments = null;
		Comments comments = new Comments();
		comments.setApplicationFormId(appid);
		comments.setCreatedAt(date);
		comments.setUpdatedAt(date);
		comments.setAddedBy(displayName);
		comments.setBody(body);
		newcomments = commentsRepository.save(comments);
		return newcomments;

	}
	
	public String uploadPath(Long appform_id) {
		String uploadPath = String.valueOf(filepathloc) + File.separator + appform_id;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		System.out.println("upload path : "+uploadPath);
		return uploadPath;

	}

	
	public JSONObject submitvalidation(String acc_no, String acc_name, String cust_no, String branchCode, String address,
			String constitution, Long daily_limit, Long monthly_limit, String pref_corp, String auth_fund,
			String auth_ext, String auth_ben,String reference_id, List<String> user_names,List<String> user_cust_no, List<String> pref_noo,
			List<String> user_mobile_no, List<Long> trans_limit_0, List<Boolean> authorized_signatory) {
		JSONObject row = new JSONObject();
		String error="";
		String regex = "/^[a-zA-Z0-9]{2,20}$/";
		String commonRegex="[a-zA-Z0-9._ ]+";
		String digitReg="[0-9]+";
		String addressRegex="[a-zA-Z0-9\\r\\n/.,_ ]+";
		if (!acc_no.isEmpty()) {
			if (acc_no.length() < 14 || acc_no.length() > 14 || !acc_no.matches(digitReg) ) {
				error = "Please provide valid 14 digit Account No.";
				row.put("acc_no", error);
			}

		} else {
			error = "Account No. cannot be blank. Please provide valid 14 digit Account No.";
			row.put("acc_no", error);
		}
		if (acc_name.equals("")|| !acc_name.matches(commonRegex)) {
			error = "Please provide a valid Account Name.";
			row.put("acc_name", error);
		}
		if (cust_no.equals("")|| !cust_no.matches(commonRegex)) {
			error = "Please provide a valid Customer ID.";
			row.put("cust_no", error);
		}
		if (branchCode.equals("") || !branchCode.matches(commonRegex)) {
			error = "Please provide a valid Branch.";
			row.put("branchCode", error);
		}
		if (address.equals("")|| !address.matches(addressRegex) ) {
			error = "Please provide a valid Preferred Address.";
			row.put("address", error);
		}
		if (constitution.equals("")|| !constitution.matches(commonRegex)) {
			error = "Please provide a valid Constitution.";
			row.put("address", error);
		}
		if (daily_limit.toString().matches(digitReg)) {
			if (daily_limit > monthly_limit) {
				error = "Daily limit must be less than Monthly limit.";
				row.put("daily_limit", error);
			}
			if (daily_limit.toString().length() < 3 || daily_limit.toString().length() > 7) {
				error = "Daily Limit should be between 3 and 7 numeric characters long.";
				row.put("daily_limit", error);
			}
		} else {
			error = "Please provide a valid Daily Limit.";
			row.put("daily_limit", error);
		}
		if (monthly_limit.toString().matches(digitReg)) {
			if (monthly_limit < daily_limit) {
				error = "Monthly limit must be greater than Daily limit.";
				row.put("monthly_limit", error);
			}
			if (monthly_limit.toString().length() < 3 || monthly_limit.toString().length() > 9) {
				error = "Monthly Limit should be between 3 and 9 numeric characters long.";
				row.put("monthly_limit", error);
			}
		} else {
			error = "Please provide a valid Monthly Limit.";
			row.put("monthly_limit", error);
		}
		String prefRegex = "^[a-zA-Z0-9]{3,20}$";
		if (pref_corp.equals("") || pref_corp.equals("0")) {
			error = "Please provide a valid Preferred Corporate ID.";
			row.put("pref_corp", error);
		} else if (pref_corp.length() < 3 || pref_corp.length() > 20 || !pref_corp.matches(prefRegex)) {
			error = "Preferred Corporate ID should be between 3 and 20 alphanumeric characters long.";
			row.put("pref_corp", error);
		} else {
			Integer validPref = customerDetailsDev.prfcorpValidation(pref_corp);
			if (validPref != 0) {
				error = "Corporate Id Already exist.";
				row.put("pref_corp", error);
			}
		}
		if (auth_fund.equals("")|| !auth_fund.toString().matches(digitReg)) {
			error = "Please provide No of authorizers required for fund transfer.";
			row.put("auth_fund", error);
		}
		if (auth_ext.equals("")|| !auth_ext.toString().matches(digitReg)) {
			error = "Please provide No of authorizers required for fund transfer.";
			row.put("auth_fund", error);
		}
		if (auth_ben.equals("")|| !auth_ben.toString().matches(digitReg)) {
			error = "Please provide No of authorizers required for beneficiary addition.";
			row.put("auth_fund", error);
		}
		if(!reference_id.equals("")) {
			if (!reference_id.matches(commonRegex)) {
				error = "Please provide valid reference_id.";
				row.put("reference_id", error);
			}
		}
		if (user_names.isEmpty() ) {
			error = "Please provide a valid User Name.";
			row.put("user_names", error);
		}
		for (String element : user_names) {
			if (element.isEmpty() || !element.matches(commonRegex)) {
				error = "Please provide a valid User Name.";
				row.put("user_names", error);
			}
		}
		for (String element : user_cust_no) {
			if (element.isEmpty() || !element.matches(commonRegex)) {
				error = "Please provide a valid custno.";
				row.put("user_cust_no", error);
			}
		}
		
		
		for (String element : pref_noo) {
		
			if (!element.isEmpty() || element.matches(regex)) {
				if (element.length() < 3 || element.length() > 20) {
					error = "pref no should be between 3 and 20 numericharacters long..";
					row.put("pref_noo", error);
				}
			} else {
				error = "Please provide a valid Pref no.";
				row.put("pref_noo", error);
			}
		}

		for (String element : user_mobile_no) {
			if (element.isEmpty() || !element.matches(digitReg)) {
				error = "Cannot proceed without mobile no.";
				row.put("user_mobile_no", error);
			}
		}

		for (Long element : trans_limit_0) {
			if (element != 0  || !element.toString().matches(digitReg)) {
				if (element.toString().length() < 3 || element.toString().length() > 7) {
					error = "TransLimit should be between 3 and 7 characters long..";
					row.put("trans_limit_0", error);
				}
				if (element > daily_limit) {
					error = "Transaction limit must be lesser than daily limit.";
					row.put("trans_limit_0", error);
				}
			} else {
				error = "Please provide a valid translimit.";
				row.put("trans_limit_0", error);
			}
		}
		int count = 0;
		for (Boolean element : authorized_signatory) {
			if (element) {
				count++;
			}
		}
		if (count == 0) {
			error = "You must select at least 1 Authorized Signatory to proceed.";
			row.put("authorized_signatory", error);

		}
		if(!error.equals("")) {
			System.out.println("validtion error: "+row.toString());
		}
		return row;
	}



	public String forward(Long application_id, Long applicationEnterprisesId, String mode_of_operation,
			Boolean board_resolution_confirmed, Boolean mode_of_operation_confirmed, MultipartFile document,
			String document_type, String declaration, String created_by, String reference_id,Long days,Long hours,Long minutes, Long daily_limit,
			Long monthly_limit, String auth_fund, String auth_ext, String auth_ben, List<String> user_names,
			List<String> pref_noo, List<String> user_cust_no, List<String> user_mobile_no, List<Long> trans_limit_0,
			List<Boolean> authorized_signatory) {

		
		String app_Refer_No="";
		long finalResultId = 0;
		Duration duration = Duration.ofDays(days).plusHours(hours).plusMinutes(minutes);
		long totalminutes = duration.toMinutes();
		String status = "pending";
		if (mode_of_operation.equals("Single")) {
			try {
				app_Refer_No = applicationFormServiceImpl.getReferenceNo(application_id);
				System.out.println("app_Reference_No-------:" + app_Refer_No);
				long entrauthparmup = applicationEnterpriseServiceImpl.update_application_enterpries( applicationEnterprisesId, auth_fund, auth_ext, auth_ben, totalminutes, monthly_limit, daily_limit);
				System.out.println("ApplicationEnterprises Id-------:" + entrauthparmup);
				if (application_id != 0) {
					long appuser_id = 0;
					for (int i = 0; i < authorized_signatory.size(); i++) {
						Boolean lon_authorized_signatory = false;

						if (i < 0 || i >= authorized_signatory.size()) {
							lon_authorized_signatory = false;
						} else {
							if (authorized_signatory.get(i)) {
								lon_authorized_signatory = true;
							}
						}
						if (lon_authorized_signatory) {
							int checkcust_ID = applicationUserServiceImpl.checkEnterpriseUser(applicationEnterprisesId, user_cust_no.get(i));
							System.out.println("checkcust_ID Id-------:" + checkcust_ID);
							String stringApplicationEnterprisesId = applicationEnterprisesId.toString();
							if (checkcust_ID == 0) {
								appuser_id = applicationUserServiceImpl.application_users(user_names.get(i), stringApplicationEnterprisesId, pref_noo.get(i), user_cust_no.get(i), user_mobile_no.get(i), trans_limit_0.get(i), lon_authorized_signatory);
							} else {
								appuser_id = applicationUserServiceImpl.update_application_users( stringApplicationEnterprisesId, user_cust_no.get(i), trans_limit_0.get(i), pref_noo.get(i), user_mobile_no.get(i), lon_authorized_signatory);
							}
							System.out.println("ApplicationUsers Id-------:" + appuser_id);
						}
					}

					int checkbranchveri_ID = branchVerificationServiceImpl .checkBranchVerification(application_id);
					System.out.println("checkbranchveri_ID Id-------:" + checkbranchveri_ID);
					if (checkbranchveri_ID == 0) {
						long branchver_id = branchVerificationServiceImpl.branch_verifications(application_id, mode_of_operation, true, true);
						System.out.println("branch_verifications Id-------:" + branchver_id);
					} else {
						long branchver_id = branchVerificationServiceImpl.update_branch_verifications(application_id, mode_of_operation);
						System.out.println("branch_verifications Id-------:" + branchver_id);
					}				
					if (document.getSize() > 0) {
						finalResultId =documentUpload(application_id,document,document_type, created_by, reference_id, declaration, status);					
					} else {
						finalResultId = applicationFormServiceImpl.finalApplicationUpdate(application_id, created_by, reference_id, declaration, status);						
					}					
				} 
			}catch (Exception e) {
				System.out.println("Error: " + e.getMessage());	
				e.printStackTrace();
			}
		} else {
			if (application_id != 0 && application_id != null) {
				app_Refer_No = applicationFormServiceImpl.getReferenceNo(application_id);
				System.out.println("app_Refer_No -------:" + app_Refer_No);
				long entrauthparmup = applicationEnterpriseServiceImpl.update_application_enterpries( applicationEnterprisesId, auth_fund, auth_ext, auth_ben, totalminutes, monthly_limit, daily_limit);
				System.out.println("ApplicationEnterprises Id -------:" + entrauthparmup);
				long appuser_id = 0;
				for (int i = 0; i < authorized_signatory.size(); i++) {
					Boolean lon_authorized_signatory = false;
					if (i < 0 || i >= authorized_signatory.size()) {
						lon_authorized_signatory = false;
					} else {
						if (authorized_signatory.get(i)) {
							lon_authorized_signatory = true;
						}
					}
					int checkcust_ID = applicationUserServiceImpl.checkEnterpriseUser(applicationEnterprisesId, user_cust_no.get(i));
					System.out.println("checkcust_ID Id -------:" + checkcust_ID);
					String stringApplicationEnterprisesId = applicationEnterprisesId.toString();
					if (checkcust_ID == 0) {
						appuser_id = applicationUserServiceImpl.application_users(user_names.get(i), stringApplicationEnterprisesId, pref_noo.get(i), user_cust_no.get(i), user_mobile_no.get(i), trans_limit_0.get(i), lon_authorized_signatory);
						System.out.println("appuser_id Id -------:" + appuser_id);
					} else {
						appuser_id = applicationUserServiceImpl.update_application_users( stringApplicationEnterprisesId, user_cust_no.get(i), trans_limit_0.get(i), pref_noo.get(i), user_mobile_no.get(i), lon_authorized_signatory);
						System.out.println("appuser_id Id -------:" + appuser_id);
					}
				}

				int checkbranchveri_ID = branchVerificationServiceImpl.checkBranchVerification(application_id);
				System.out.println("checkbranchveri_ID Id -------:" + checkbranchveri_ID);
				if (checkbranchveri_ID == 0) {
					Long branchver_id = branchVerificationServiceImpl.branch_verifications(application_id, mode_of_operation, true, true);
					System.out.println("branchver_id Id1 -------:" + branchver_id);
				} else {
					Long branchver_id = branchVerificationServiceImpl .update_branch_verifications(application_id, mode_of_operation);
					System.out.println("branchver_id Id2 -------:" + branchver_id);
				}
				if (document.getSize() > 0) {
					finalResultId = documentUpload(application_id,document,document_type, created_by, reference_id, declaration, status);
				} else {
					finalResultId = applicationFormServiceImpl.finalApplicationUpdate(application_id, created_by, reference_id, declaration, status);
				}
			} 
		}
		System.out.println("FinalStatusID -------:" + finalResultId);
		if(finalResultId!=0) {
			return app_Refer_No;
		}else {
			return "";
		}
		
	
	}

	public String forwardValidation(Long application_id, Long applicationEnterprisesId, String mode_of_operation,
			Boolean board_resolution_confirmed, Boolean mode_of_operation_confirmed, MultipartFile document,
			String document_type, String declaration, String created_by, String reference_id, Long days, Long hours,
			Long minutes, Long daily_limit, Long monthly_limit, String auth_fund, String auth_ext, String auth_ben,
			List<String> user_names, List<String> pref_noo, List<String> user_cust_no, List<String> user_mobile_no,
			List<Long> trans_limit_0, List<Boolean> authorized_signatory) {
		String error="";
		String pref_regex = "/^[a-zA-Z0-9]{2,20}$/";
		String commonRegex="[a-zA-Z0-9,._ ]+";
		String digitReg="[0-9]+";
	
		JSONObject row = new JSONObject();
		
		
		if (!application_id.toString().matches(digitReg)) {
			error = "Please provide valid application_id.";
			row.put("application_id", error);
		}
		if (!applicationEnterprisesId.toString().matches(digitReg)) {
			error = "Please provide valid applicationEnterprisesId.";
			row.put("applicationEnterprisesId", error);
		}
		if (!mode_of_operation.matches(commonRegex)) {
			error = "Please provide valid mode_of_operation.";
			row.put("mode_of_operation", error);
		}
		if(!reference_id.equals("")) {
			if (!reference_id.matches(commonRegex)) {
				error = "Please provide valid reference_id.";
				row.put("reference_id", error);
			}
		}
		if (daily_limit.toString().matches(digitReg) && monthly_limit.toString().matches(digitReg)) {
			if (daily_limit > monthly_limit) {
				error = "Daily limit must be less than Monthly limit.";
				row.put("daily_limit", error);
			}
			if (daily_limit.toString().length() < 3 || daily_limit.toString().length() > 7) {
				error = "Daily Limit should be between 3 and 7 numeric characters long.";
				row.put("daily_limit", error);
			}
		} else {
			error = "Please provide a valid Daily Limit.";
			row.put("daily_limit", error);
		}
		if (daily_limit.toString().matches(digitReg) && monthly_limit.toString().matches(digitReg)) {
			if (monthly_limit < daily_limit) {
				error = "Monthly limit must be greater than Daily limit.";
				row.put("monthly_limit", error);
			}
			if (monthly_limit.toString().length() < 3 || monthly_limit.toString().length() > 9) {
				error = "Monthly Limit should be between 3 and 9 numeric characters long.";
				row.put("monthly_limit", error);
			}
		} else {
			error = "Please provide a valid Monthly Limit.";
			row.put("monthly_limit", error);
		}

		if (auth_fund.equals("") || !auth_fund.matches(digitReg)) {
			error = "Please provide No of authorizers required for fund transfer.";
			row.put("auth_fund", error);
		}

		if (auth_ext.equals("")|| !auth_ext.matches(digitReg)) {
			error = "Please provide No of authorizers required for fund transfer.";
			row.put("auth_fund", error);
		}
		if (auth_ben.equals("")|| !auth_ben.matches(digitReg)) {
			error = "Please provide No of authorizers required for beneficiary addition.";
			row.put("auth_fund", error);
		}
		if (declaration.equals("")|| !declaration.matches(commonRegex)) {
			error = "Please provide a valid declaration.";
			row.put("declaration", error);
		}
		if (user_names != null && pref_noo != null && user_mobile_no != null && trans_limit_0 != null
				&& authorized_signatory != null) {

			for (String element : user_names) {
				if (element.isEmpty() || !element.matches(commonRegex)) {
					error = "Please provide a valid User Name.";
					row.put("user_names", error);
				}
			}
			for (String element : user_cust_no) {
				if (element.isEmpty() || !element.matches(commonRegex)) {
					error = "Please provide a valid custno.";
					row.put("user_cust_no", error);
				}
			}

			
			for (String element : pref_noo) {
				if (!element.isEmpty() || element.matches(pref_regex)) {
					if (element.length() < 3 || element.length() > 20) {
						error = "pref no should be between 3 and 20 numericharacters long..";
						row.put("pref_noo", error);
					}
				} else {
					error = "Please provide a valid Pref no.";
					row.put("pref_noo", error);
				}
			}

			for (String element : user_mobile_no) {
				if (element.isEmpty() || !element.matches(digitReg)) {
					error = "Cannot proceed without mobile no.";
					row.put("user_mobile_no", error);
				}
			}
			for (Long element : trans_limit_0) {
				if (element != 0 || !element.toString().matches(digitReg)) {
					if (element.toString().length() < 3 || element.toString().length() > 7) {
						error = "TransLimit should be between 3 and 7 characters long..";
						row.put("trans_limit_0", error);
					}
					if (element > daily_limit) {
						error = "Transaction limit must be lesser than daily limit.";
						row.put("trans_limit_0", error);
					}
				} else {
					error = "Please provide a valid translimit.";
					row.put("trans_limit_0", error);
				}
			}

			int count = 0;
			for (Boolean element : authorized_signatory) {
				if (element) {
					count++;
				}
			}
			if (count == 0) {
				error = "You must select at least 1 Authorized Signatory to proceed.";
				row.put("authorized_signatory", error);

			}

		} else {
			error = "You must add at least 1 user Authorized Signatory to proceed.";
			row.put("authorized_signatory", error);
		}
		if(!error.equals("")) {
			System.out.println("validtion error: "+row.toString());
		}
		return error;
	}
	
	public long documentUpload(Long application_id,MultipartFile document, String document_type, String created_by, String reference_id,String declaration,String status ) {
		String filenetkey="";
		long finalResultId = 0;
try {
		String uploadPath=uploadPath(application_id);
		Long document_store = documentServiceImpl.documentform(application_id, "file.pdf",	document_type);
		System.out.println("document_store Id -------:" + document_store);
		if (document_store != 0 && document_store != null) {			
				String docname = document_store + "_file.pdf";
				String filepdfname="";				
				filepdfname = documentServiceImpl.fileUploadfolder(document, uploadPath, docname);
				System.out.println("generated file pdfname -------:" + filepdfname);
				LinkedHashMap<String, String> lstDocNo = new LinkedHashMap<String, String>();
//				System.out.println("Username:" + userName);
//				System.out.println("password:" + password);
//				System.out.println("stanza:" + stanza);
//				System.out.println("uri:" + uri);
//				System.out.println("obStore:" + obStore);
//				System.out.println("folderName:" + foldername);
//				System.out.println("filenet upload class...start");
				FileNetUpload fnu = new FileNetUpload(userName, password, stanza, uri, obStore,	foldername);
				System.out.println("filenet upload class...end");
				System.out.println("folderName:" + foldername);
				lstDocNo = fnu.doUpload(new File(uploadPath + File.separator + filepdfname),FileNetUpload.FILE, null);
				for (String key : lstDocNo.keySet()) {
					System.out.println(key + ":\t" + lstDocNo.get(key));
					System.out.println(lstDocNo.get(key));
					String result = lstDocNo.get(key).replaceAll("[{}]", "");
					filenetkey = result;
				}
			
				System.out.println(document_store);
				String filestatus = documentServiceImpl.filenetupdate(document_store, filenetkey);
				System.out.println("filestatus  -------:" + filestatus);
				
				System.out.println("File delete start.......................................");		
//				filedelete(document,filepdfname,application_id);	
				try {
					FileUtils.deleteDirectory(new File(uploadPath));
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("File delete end.......................................");
				System.out.println("document_store Id -------: " + document_store);
				if (filestatus.equals("Success")){
					finalResultId = applicationFormServiceImpl.finalApplicationUpdate(application_id, created_by, reference_id, declaration, status);			
				}
			}
}catch(Exception e) {
	e.printStackTrace();
}
		return finalResultId;
}


	private void filedelete(MultipartFile document,String filepdfname,Long applicationid) throws IOException {
		
		String uploadPath=uploadPath(applicationid);
		System.out.println("upload path: "+uploadPath);
		byte[] bytes = document.getBytes();
			Path rootPath = Paths.get(String.valueOf(uploadPath)+ File.separator + filepdfname).toAbsolutePath().normalize();
			File dir = new File(rootPath.toString());
			if (!dir.exists()) {
				if (dir.mkdir()) {
					System.out.println("The Application Folder For  Created Successfully");
				} else {
					System.out.println("Failed To Created Folder For Application");
				}
			}
			File serverFile = new File(dir.getAbsolutePath());
			System.out.println("serverFile: "+serverFile.toString());
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			String path  = dir.getAbsolutePath();
			System.out.println("path: "+path.toString());
			stream.write(bytes);
			stream.close();     				
		boolean b=serverFile.delete();
		if(b) {
			System.out.println("delete file: "+serverFile.toString());
		}				
	}

	public String createApplication(String acc_no, String acc_name, String cust_no, String branchCode, String address,
			String constitution, String solid,String mode_of_operation,MultipartFile document,String document_type, Long daily_limit, Long monthly_limit, String pref_corp, Long days, Long hours,
			Long minutes, String auth_fund, String auth_ext, String auth_ben, String declaration, String created_by,
			String reference_id, List<String> user_names, List<String> pref_noo, List<String> user_cust_no,
			List<String> user_mobile_no, List<Long> trans_limit_0, List<Boolean> authorized_signatory) {

		String filenetkey = "";
		boolean exception = false;
		String finalResultId="";
		
		String successMsg = "";
		try {
		Long appform_id = applicationFormServiceImpl.applicationform(declaration, created_by, reference_id);
		System.out.println("ApplicationForm ID-------:" + appform_id);
		if (appform_id != null && appform_id != 0) {
			Long branch_id = branchServiceImpl.getBranchDetails(solid, branchCode);
			System.out.println("Branch ID-------:" + branch_id);
			Duration duration = Duration.ofDays(days).plusHours(hours).plusMinutes(minutes);
			long totalminutes = duration.toMinutes();
			System.out.println("totalSeconds >>>>" + totalminutes);
			Long applicationEnterprisesId = applicationEnterpriseServiceImpl.applicationEnterprises(acc_name, cust_no, acc_no, address, appform_id, auth_fund, auth_ext, auth_ben, pref_corp, constitution, branch_id, daily_limit, monthly_limit, totalminutes);
			System.out.println("ApplicationEnterprises ID-------:" + applicationEnterprisesId);
			if (applicationEnterprisesId != 0 && applicationEnterprisesId != null) {
				for (int i = 0; i < user_names.size(); i++) {
					Boolean lon_authorized_signatory = false;
					if (i < 0 || i >= authorized_signatory.size()) {
						lon_authorized_signatory = false;
					} else if (authorized_signatory.get(i).equals(true)) {
						lon_authorized_signatory = true;
					}
					if (lon_authorized_signatory) {
						String strentformidLong = Long.toString(applicationEnterprisesId);
						long appuser_id = applicationUserServiceImpl.application_users(user_names.get(i), strentformidLong, pref_noo.get(i), user_cust_no.get(i), user_mobile_no.get(i), trans_limit_0.get(i), lon_authorized_signatory);
						System.out.println("ApplicationUsers ID-------:" + appuser_id);
					}
				}
			}
			Long branchVerificationId = branchVerificationServiceImpl.branch_verifications(appform_id,mode_of_operation, true, true);
			System.out.println("Branch verificaton ID-------:" + branchVerificationId);
			String uploadPath=uploadPath(appform_id);
			Long document_id = documentServiceImpl.documentform(appform_id, "file.pdf", document_type);
			System.out.println("Documents ID-------:" + document_id);
			String docname = String.valueOf(document_id) + "_file.pdf";
			String filepdfname = documentServiceImpl.fileUploadfolder(document, uploadPath, docname);
			System.out.println("filepdfname >>>>" + filepdfname);
			FileNetUpload fnu = new FileNetUpload(userName, password, stanza, uri, obStore, foldername);
			LinkedHashMap<String, String> 	lstDocNo = fnu.doUpload(new File(String.valueOf(uploadPath) + File.separator + filepdfname), "file",null);
			System.out.println("----" + lstDocNo.keySet().size());
			for (String key : lstDocNo.keySet()) {
				System.out.println(String.valueOf(key) + ":\t" + (String) lstDocNo.get(key));
				System.out.println(lstDocNo.get(key));
				String result = ((String) lstDocNo.get(key)).replaceAll("[{}]", "");
				filenetkey = result;
				if (key == null) {
					exception = true;
				}
			}
			if (!exception) {
				if (document_id != null && document_id != 0) {
					String filestatus = documentServiceImpl.filenetupdate(document_id, filenetkey);
					System.out.println("file status: "+filestatus);	
					try {				
					FileUtils.deleteDirectory(new File(uploadPath));				
					}catch(Exception e){
						e.printStackTrace();
					}
					
					if (filestatus.equals("Success")) {
						finalResultId = applicationFormServiceImpl.finalApplicationUpdateStatus(appform_id);
						System.out.println(">>>>>RefNo.>>>>>>>>>" + finalResultId);
						successMsg = finalResultId.toString();
					}
				}
			} else {
				System.out.println(">>>>>>issue while uploading filenet docs>>>>>>>>>" + appform_id);
				String filestatus = documentServiceImpl.filenetupdateToBlank(document_id, filenetkey,appform_id);
				applicationFormServiceImpl.finalApplicationUpdateStatusToRejected(appform_id);
				System.out.println("filestatus-------:" + filestatus);
			
			}
		} else {
			System.out.println("ApplicationForm Id Not Found");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	return successMsg;

	}

	public String modifiedApplication(Long application_id, Long applicationEnterprisesId, Long daily_limit,
			Long monthly_limit, String mode_of_operation, MultipartFile document, String document_type, Long days,
			Long hours, Long minutes, String auth_fund, String auth_ext, String auth_ben, String declaration,
			String created_by, String reference_id, List<String> user_names, List<String> pref_noo,
			List<String> user_cust_no, List<String> user_mobile_no, List<Long> trans_limit_0,
			List<Boolean> authorized_signatory) {

		Long finalResultId = 0L;
		String filenetkey = "";
		String app_Refer_No = "";
		boolean exception = false;
		long document_id = 0;
		long appform_id = 0;
		Duration duration = Duration.ofDays(days).plusHours(hours).plusMinutes(minutes);
		long totalminutes = duration.toMinutes();
		String uploadPath=uploadPath(application_id);
		if (document.getSize() > 0) {
			try {
				document_id = documentServiceImpl.documentform(application_id, "file.pdf", document_type);
				String docname = document_id + "_file.pdf";
				String filepdfname = documentServiceImpl.fileUploadfolder(document, uploadPath, docname);
				System.out.println("filepdfname: " + filepdfname);
				LinkedHashMap<String, String> lstDocNo = new LinkedHashMap<String, String>();
				FileNetUpload fnu = new FileNetUpload(userName, password, stanza, uri, obStore, foldername);
				lstDocNo = fnu.doUpload(new File(uploadPath + File.separator + filepdfname), FileNetUpload.FILE, null);
				for (String key : lstDocNo.keySet()) {
					System.out.println(key + ":\t" + lstDocNo.get(key));
					System.out.println(lstDocNo.get(key));
					String result = lstDocNo.get(key).replaceAll("[{}]", "");
					if (key == null) {
						exception = true;
					}
					filenetkey = result;
				}
				System.out.println(document_id);

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("document_id  -------: " + document_id);
		}
		if (!exception) {
			long appuser_id = 0;
			String status = "modified";
			long getappid = applicationFormServiceImpl.finalApplicationUpdate(application_id, created_by, reference_id, declaration, status);
			applicationEnterpriseServiceImpl.updateApplicationEnterprises(applicationEnterprisesId, monthly_limit, daily_limit, user_mobile_no);
			long branchver_id = branchVerificationServiceImpl.update_branch_verifications(application_id, mode_of_operation);
			System.out.println("Branch varification id: "+branchver_id);
			long entrauthparmup = applicationEnterpriseServiceImpl.update_application_enterpries( applicationEnterprisesId, auth_fund, auth_ext, auth_ben, totalminutes, monthly_limit, daily_limit);
			System.out.println("applicationEnterprisesId  -------:" + entrauthparmup);
			for (int i = 0; i < authorized_signatory.size(); i++) {
				System.out.println(authorized_signatory.get(i) + "  auth sign value");
				Boolean lon_authorized_signatory = false;
				if (i < 0 || i >= authorized_signatory.size()) {
					lon_authorized_signatory = false;
				} else {
					if (authorized_signatory.get(i)) {
						lon_authorized_signatory = true;
					}
				}
				if (lon_authorized_signatory) {
					int checkcust_ID = applicationUserServiceImpl.checkEnterpriseUser(applicationEnterprisesId, user_cust_no.get(i));
					String strApplnEnterpriseId = applicationEnterprisesId.toString();
					if (checkcust_ID == 0) {
						appuser_id = applicationUserServiceImpl.application_users(user_names.get(i), strApplnEnterpriseId, pref_noo.get(i), user_cust_no.get(i), user_mobile_no.get(i), trans_limit_0.get(i), lon_authorized_signatory);					
					} else {
						appuser_id = applicationUserServiceImpl.update_application_users(strApplnEnterpriseId, user_cust_no.get(i), trans_limit_0.get(i), pref_noo.get(i), user_mobile_no.get(i), lon_authorized_signatory);
					}
					System.out.println("applicationuser_id  -------:" + appuser_id);
				}
			}
			if (document_id != 0) {
				String filestatus = documentServiceImpl.filenetupdate(document_id, filenetkey);
				System.out.println("file status: "+filestatus);
				try {
					FileUtils.deleteDirectory(new File(uploadPath));
				} catch (Exception e) {
					System.out.println("Error file not deleted" + e.getMessage());
					e.printStackTrace();
				}
				if (filestatus.equals("Success")) {
					finalResultId = applicationFormServiceImpl.finalApplicationUpdate(application_id, created_by, reference_id, declaration, status);
					System.out.println("finalResultId  -------:" + finalResultId);
				
				}
			}
			app_Refer_No = applicationFormServiceImpl.getReferenceNo(getappid);
		} else {
			String filestatus = documentServiceImpl.filenetupdateToBlank(document_id, filenetkey, appform_id);
			System.out.println("filestatus  -------:" + filestatus);	
		
		}
	return app_Refer_No;
	
	}

	public String modifiedValidation(Long application_id, Long applicationEnterprisesId, Long daily_limit,
			Long monthly_limit, String mode_of_operation, MultipartFile document, String document_type, Long days,
			Long hours, Long minutes, String auth_fund, String auth_ext, String auth_ben, String declaration,
			String created_by, String reference_id, List<String> user_names, List<String> pref_noo,
			List<String> user_cust_no, List<String> user_mobile_no, List<Long> trans_limit_0,
			List<Boolean> authorized_signatory) {

		String error="";
		JSONObject row = new JSONObject();
		String pref_regex = "/^[a-zA-Z0-9]{2,20}$/";
		String commonregex = "[a-zA-Z0-9_. ]+";
		String digitregex="[0-9]+";
		if (declaration.equals("")|| !declaration.matches(commonregex)) {
			error = "Please provide a valid declaration.";
			row.put("declaration", error);
		}
		if (!mode_of_operation.matches(commonregex)) {
			error = "Please provide valid mode_of_operation.";
			row.put("mode_of_operation", error);
		}
		if(!reference_id.equals("")) {
			if (!reference_id.matches(commonregex)) {
				error = "Please provide valid reference_id.";
				row.put("reference_id", error);
			}
		}
		if (daily_limit != null && monthly_limit != null) {
			if (daily_limit > monthly_limit) {
				error = "Daily limit must be less than Monthly limit.";
				row.put("daily_limit", error);
			}
			if (daily_limit.toString().length() < 3 || daily_limit.toString().length() > 7) {
				error = "Daily Limit should be between 3 and 7 numeric characters long.";
				row.put("daily_limit", error);
			}
		} else {
			error = "Please provide a valid Daily Limit.";
			row.put("daily_limit", error);
		}
		if (monthly_limit != null && daily_limit != null) {
			if (monthly_limit < daily_limit) {
				error = "Monthly limit must be greater than Daily limit.";
				row.put("monthly_limit", error);
			}
			if (monthly_limit.toString().length() < 3 || monthly_limit.toString().length() > 9) {
				error = "Monthly Limit should be between 3 and 9 numeric characters long.";
				row.put("monthly_limit", error);
			}
		} else {
			error = "Please provide a valid Monthly Limit.";
			row.put("monthly_limit", error);
		}

		if (auth_fund.equals("") || !auth_fund.matches(digitregex)) {
			error = "Please provide No of authorizers required for fund transfer.";
			row.put("auth_fund", error);
		}

		if (auth_ext.equals("") || !auth_ext.matches(digitregex)) {
			error = "Please provide No of authorizers required for fund transfer.";
			row.put("auth_ext", error);
		}
		if (auth_ben.equals("") || !auth_ben.matches(digitregex)) {
			error = "Please provide No of authorizers required for beneficiary addition.";
			row.put("auth_ben", error);
		}

		if (user_names != null && pref_noo != null && user_mobile_no != null && trans_limit_0 != null
				&& authorized_signatory != null) {

			for (String element : user_names) {
				if (element.isEmpty() || !element.matches(commonregex)) {
					error = "Please provide a valid User Name.";
					row.put("user_names", error);
				}
			}

			for (String element : pref_noo) {
				if (!element.isEmpty() || element.matches(pref_regex)) {
					if (element.length() < 3 || element.length() > 20) {
						error = "pref no should be between 3 and 20 numericharacters long..";
						row.put("pref_noo", error);
					}
				} else {
					error = "Please provide a valid Pref no.";
					row.put("pref_noo", error);
				}
			}

			for (String element : user_mobile_no) {
				if (element.isEmpty() || !element.matches(digitregex)) {
					error = "Cannot proceed without mobile no.";
					row.put("user_mobile_no", error);
				}
			}
			for (Long element : trans_limit_0) {
				if (element != 0 || !element.toString().matches(digitregex)) {
					if (element.toString().length() < 3 || element.toString().length() > 7) {
						error = "TransLimit should be between 3 and 7 characters long..";
						row.put("trans_limit_0", error);
					}
					if (element > daily_limit) {
						error = "Transaction limit must be lesser than daily limit.";
						row.put("trans_limit_0", error);
					}
				} else {
					error = "Please provide a valid translimit.";
					row.put("trans_limit_0", error);
				}
			}

			int count = 0;
			for (Boolean element : authorized_signatory) {
				if (element) {
					count++;
				}
			}
			if (count == 0) {
				error = "You must select at least 1 Authorized Signatory to proceed.";
				row.put("authorized_signatory", error);

			}

		} else {
			error = "You must add at least 1 user Authorized Signatory to proceed.";
			row.put("authorized_signatory", error);
		}
		if(!error.equals("")) {
			System.out.println("validation error: "+row.toString());
		}
		return error;
	
	}

	public String approvedValidation(Long application_form_id, Long entid, String auth_fund, String auth_ext,
			String auth_ben, String constitution, String address, String pref_corp, String cust_no, String acc_no,
			String acc_name) {
		
		String error="";
		JSONObject row = new JSONObject();
		String pref_regex = "[a-zA-Z0-9_. ]+";
		String regex="[0-9]+";
	
		if (!application_form_id.toString().matches(regex)) {
			error = "Please provide valid application form id.";
			row.put("applicationformid", error);
		}

		if (!entid.toString().matches(regex)) {
			error = "Please provide valid enterprise id.";
			row.put("enterpriseid", error);
		}
		if (!constitution.matches(pref_regex)) {
			error = "Please provide valid constitution.";
			row.put("constitution", error);
		}
		
		if (!pref_corp.matches(pref_regex)) {
			error = "Please provide valid pref_corp.";
			row.put("pref_corp", error);
		}
		if (!cust_no.matches(pref_regex)) {
			error = "Please provide valid cust_no.";
			row.put("auth_fund", error);
		}
		
		if (!acc_no.matches(pref_regex)) {
			error = "Please provide Valid acc_no.";
			row.put("acc_no", error);
		}
		if (!acc_name.matches(pref_regex)) {
			error = "Please provide Valid acc_name.";
			row.put("acc_name", error);
		}
		
		
		if (auth_fund.equals("")) {
			error = "Please provide No of authorizers required for fund transfer.";
			row.put("auth_fund", error);
		}

		if (auth_ext.equals("")) {
			error = "Please provide No of authorizers required for fund transfer.";
			row.put("auth_fund", error);
		}
		if (auth_ben.equals("")) {
			error = "Please provide No of authorizers required for beneficiary addition.";
			row.put("auth_fund", error);
		}

		
		if(!error.equals("")) {
			System.out.println("validation error: "+row.toString());
		}
		return error;
	}



	
}
