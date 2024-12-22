package com.fedcorp.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fedcorp.admin.apicall.CustomerDetailsDev;
import com.fedcorp.admin.apicall.ManageCustAcctDetail;
import com.fedcorp.admin.apicall.Utilities;
import com.fedcorp.admin.config.SearchRequest;
import com.fedcorp.admin.entities.ApplicationDetails;
import com.fedcorp.admin.entities.ApplicationEnterprises;
import com.fedcorp.admin.entities.ApplicationStaus;
import com.fedcorp.admin.entities.ApplicationUsers;
import com.fedcorp.admin.entities.Comments;
import com.fedcorp.admin.entities.Documents;
import com.fedcorp.admin.entities.LoginUser;
import com.fedcorp.admin.entities.ManagedAccounts;
import com.fedcorp.admin.entities.Users;
import com.fedcorp.admin.service.impl.AdLoginUserServiceImpl;
import com.fedcorp.admin.service.impl.ApplicationEnterpriseServiceImpl;
import com.fedcorp.admin.service.impl.ApplicationFormServiceImpl;
import com.fedcorp.admin.service.impl.ApplicationServiceImpl;
import com.fedcorp.admin.service.impl.ApplicationUserServiceImpl;
import com.fedcorp.admin.service.impl.BranchServiceImpl;
import com.fedcorp.admin.service.impl.BranchVerificationServiceImpl;
import com.fedcorp.admin.service.impl.DocumentServiceImpl;
import com.fedcorp.admin.service.impl.ManagedAccountServiceImpl;

@Controller
public class AdminController {

	private static final org.apache.log4j.Logger logger = LogManager.getLogger(AdminController.class);

	@Autowired
	public AdLoginUserServiceImpl adLoginUserService;

	@Autowired
	public ApplicationUserServiceImpl applicationUserServiceImpl;

	@Autowired
	public ManagedAccountServiceImpl managedAccountServiceImpl;

	@Autowired
	public CustomerDetailsDev customerDetailsDev;

	@Autowired
	public ApplicationServiceImpl applicationServiceImpl;

	@Autowired
	public ApplicationEnterpriseServiceImpl applicationEnterpriseServiceImpl;

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

	@GetMapping("/login")
	public String login(Model model, HttpServletRequest request) {
		LoginUser adLoginUsers = (LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/";
		} else {
			return "redirect:/homepage";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/";

	}

	@GetMapping("application-form")
	public String createApplicationForm(Model model, HttpServletRequest request) {
		LoginUser adLoginUsers = (LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/";
		} else {
			if (adLoginUsers.getOfficetype().equals("Branch") || (adLoginUsers.getOfficetype().equals("Administrative Office") && !adLoginUsers.getDepname().equals("OS"))) {
				model.addAttribute("login_users", adLoginUsers);
				return "applicationform";
			} else {
				return "redirect:/homepage";
			}
		}
	}

	@PostMapping("newappln")
	public String addUser(@RequestParam("acctno") String acctnumber, @RequestParam("user") String user, Model model) {
		if (acctnumber.equals("")) {
			acctnumber = "12345";
		}
		String accountreg="[0-9]+";
		JSONObject addUser =null;
		if(acctnumber.matches(accountreg)) {
			 addUser = utilities.addUser(acctnumber, user);
		}
		model.addAttribute("addUser", addUser);
		return "newappln";
	}

	@GetMapping("validatePrefCorp")
	public String validatePrefCorp(@RequestParam("validatePrefCorp") String prefCorp, Model model) {
		String reg="[a-zA-Z0-9]+";
		Integer prefCorpValidate =null;
		if(prefCorp.matches(reg)) {
			 prefCorpValidate = customerDetailsDev.prfcorpValidation(prefCorp);
			
		}
		model.addAttribute("prefCorpValidate", prefCorpValidate);
		return "newappln";

	}

	@PostMapping("rejectappln")
	public String applicationReject(@RequestParam("appid") Long appid, Model model, HttpServletRequest request) {
		LoginUser adLoginUsers = (LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/";
		} else {
			String refNo = applicationServiceImpl.rejectApplication(appid, adLoginUsers.getDisplayName());
			model.addAttribute("refNo", refNo);
			return "rejectappln";
		}
	}

	@PostMapping("addcomments")
	public String addcomments(@RequestParam("application_form_id") Long application_form_id, @RequestParam("body") String body, @RequestParam("page") String page, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		LoginUser adLoginUsers = (LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/";
		} else {
			String regex="[0-9]+";
			if(application_form_id.toString().matches(regex)) {
				String errorMsg = "Something Went Wrong, Please try again later";
				String body_reg = "^[a-zA-Z0-9 ]{1,200}$";
				if (body.matches(body_reg)) {
					Comments comment_status = applicationServiceImpl.saveComments(application_form_id.toString(), adLoginUsers.getDisplayName(), body);
					if (comment_status != null) {
						redirectAttributes.addFlashAttribute("comment_status", comment_status);
					} else {
						logger.info("comment must be alphanumeric characater........");
						redirectAttributes.addFlashAttribute("message", errorMsg);
					}
				} else {
					logger.info("comment must be alphanumeric characater........");
					redirectAttributes.addFlashAttribute("message", errorMsg);
				}
	
				ApplicationDetails applicationDetails = applicationServiceImpl.pendingWithFinalappln(application_form_id.toString());
				List<Comments> comments = applicationServiceImpl.applicationComments(application_form_id.toString());
				List<Documents> documents = applicationServiceImpl.applicationDocuments(application_form_id.toString());
				List<ApplicationUsers> applicationUsers = applicationServiceImpl.applicationUser(applicationDetails.getApplnEnterprisesId().toString());
				redirectAttributes.addFlashAttribute("applicationDetails", applicationDetails);
				redirectAttributes.addFlashAttribute("login_users", adLoginUsers);
				redirectAttributes.addFlashAttribute("comments", comments);
				redirectAttributes.addFlashAttribute("documents", documents);
				redirectAttributes.addFlashAttribute("applicationUsers", applicationUsers);
				return "redirect:/pending_final_application";
			}else {
				redirectAttributes.addFlashAttribute("errorMsg", "Something went wrong");
				return "redirect:/homepage"; 
			}
		}
	}

	@PostMapping("resubmitappln")
	public String resubmitappln(@RequestParam("appid") Long appid, Model model, HttpServletRequest request) {
		LoginUser adLoginUsers = (LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/";
		} else {
			String refNo = applicationServiceImpl.resubmitappln(appid, adLoginUsers.getDisplayName());
			model.addAttribute("refNo", refNo);
			return "resubmitappln";
		}
	}

	@PostMapping("removenewappln")
	public String removeNewAppln(@RequestParam("authuserid") String authuserid,
			@RequestParam("userperfid") String userperfid, Model model) {
		applicationServiceImpl.removeNewAppln(authuserid, userperfid);
		return "removenewappln";
	}

	@PostMapping("/logincheck")
	public String logincheck(@RequestParam("adusername") String adusername, Model model, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		Long pendingWithBranch = 0l, pendingfinal = 0l, approve = 0l, reject = 0l, modified = 0l;
		String userreg="[a-zA-Z0-9._]+";
		if(adusername.matches(userreg)) {
			LoginUser adLoginUsers = adLoginUserService.logincheck(adusername);
			if (adLoginUsers == null) {
				model.addAttribute("message", "Access Denied");
				return "index";
			} else {
				String officetype = adLoginUsers.getOfficetype();
				String depname = adLoginUsers.getDepname();
	
				List<ApplicationStaus> applicationStatusCount = adLoginUserService.applicationStatusCount(officetype,
						depname);
				for (int i = 0; i < applicationStatusCount.size(); i++) {
					if (applicationStatusCount.get(i).getApplicationStatus().equals("rejected")) {
						reject = applicationStatusCount.get(i).getTotal();
					}
	
					else if (applicationStatusCount.get(i).getApplicationStatus().equals("pending")) {
						pendingfinal = applicationStatusCount.get(i).getTotal();
					}
	
					else if (applicationStatusCount.get(i).getApplicationStatus().equals("approved")) {
						approve = applicationStatusCount.get(i).getTotal();
					}
	
					else if (applicationStatusCount.get(i).getApplicationStatus().equals("new")) {
						pendingWithBranch = applicationStatusCount.get(i).getTotal();
					}
	
					else if (applicationStatusCount.get(i).getApplicationStatus().equals("modified")) {
						modified = applicationStatusCount.get(i).getTotal();
					}
				}
	
				List<ApplicationDetails> allPendingWithBranchApplicationForm = adLoginUserService.pendingWithBranchApplicationForm(officetype, depname);
				request.getSession().setAttribute("logindetails", adLoginUsers);
				model.addAttribute("login_users", adLoginUsers);
				model.addAttribute("pendingWithBranchApplicationForm", allPendingWithBranchApplicationForm);
				model.addAttribute("pendingWithBranch", pendingWithBranch);
				model.addAttribute("pendingfinal", pendingfinal);
				model.addAttribute("approve", approve);
				model.addAttribute("reject", reject);
				model.addAttribute("modified", modified);
				return "redirect:/homepage";
			}
		}else {
			model.addAttribute("message", "Access Denied");
			return "index";
		}

	}

	@GetMapping("homepage")
	public String homepage(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Long pendingWithBranch = 0l, pendingfinal = 0l, approve = 0l, reject = 0l, modified = 0l;
		LoginUser adLoginUsers = (LoginUser) request.getSession().getAttribute("logindetails");

		if (adLoginUsers == null) {
			return "redirect:/";
		} else {
			String officetype = adLoginUsers.getOfficetype();
			String depname = adLoginUsers.getDepname();
			List<ApplicationStaus> applicationStatusCount = adLoginUserService.applicationStatusCount(officetype, depname);
			for (int i = 0; i < applicationStatusCount.size(); i++) {
				if (applicationStatusCount.get(i).getApplicationStatus().equals("rejected")) {
					reject = applicationStatusCount.get(i).getTotal();
				}

				else if (applicationStatusCount.get(i).getApplicationStatus().equals("pending")) {
					pendingfinal = applicationStatusCount.get(i).getTotal();
				}

				else if (applicationStatusCount.get(i).getApplicationStatus().equals("approved")) {
					approve = applicationStatusCount.get(i).getTotal();
				}

				else if (applicationStatusCount.get(i).getApplicationStatus().equals("new")) {
					pendingWithBranch = applicationStatusCount.get(i).getTotal();
				}

				else if (applicationStatusCount.get(i).getApplicationStatus().equals("modified")) {
					modified = applicationStatusCount.get(i).getTotal();
				}

			}

			List<ApplicationDetails> allPendingWithBranchApplicationForm = adLoginUserService.pendingWithBranchApplicationForm(officetype, depname);
			if (redirectAttributes.containsAttribute("ref_no")) {
				String refno = redirectAttributes.getAttribute("ref_no").toString();
				model.addAttribute("ref_no", refno);
			}

			model.addAttribute("login_users", adLoginUsers);
			model.addAttribute("pendingWithBranchApplicationForm", allPendingWithBranchApplicationForm);
			model.addAttribute("pendingWithBranch", pendingWithBranch);
			model.addAttribute("pendingfinal", pendingfinal);
			model.addAttribute("approve", approve);
			model.addAttribute("reject", reject);
			model.addAttribute("modified", modified);
			return "homepage";
		}

	}

	@PostMapping("searchApplication")
	public String searchApplication(HttpServletRequest request, SearchRequest searchRequest, Model model, RedirectAttributes redirectAttributes) {

		LoginUser adLoginUsers = (LoginUser) request.getSession().getAttribute("logindetails");
		Long pendingWithBranch = 0l, pendingfinal = 0l, approve = 0l, reject = 0l, modified = 0l;
		
		
		String acc_name=	searchRequest.getAcc_name();
		String acc_no=	searchRequest.getAcc_no();
		String mobile=	searchRequest.getMobile();
		String ref_no=	searchRequest.getRef_no();
		String status=searchRequest.getStatus();
		String statusRegex="[a-z,]+";
		if(status.matches(statusRegex)) {
			if (adLoginUsers != null) {
				String search_refno = "", search_acc_name = "", search_acc_no = "", search_mobile = "", search_status = "";
	
				String officetype = adLoginUsers.getOfficetype();
				String branchcode = adLoginUsers.getDepname();
	
				if (ref_no != null && !ref_no.equals("")) {
					search_refno = ref_no;
				} else {
					search_refno = "";
				}
				if (acc_name != null && !acc_name.equals("")) {
					search_acc_name = acc_name;
				} else {
					search_acc_name = "";
				}
				if (acc_no != null && !acc_no.equals("")) {
					search_acc_no = acc_no;
				} else {
					search_acc_no = "";
				}
				if (mobile != null && !mobile.equals("")) {
					search_mobile = mobile;
				} else {
					search_mobile = "";
				}
				if (status != null) {
	
					if (status.equals("pending,modified")) {
						search_status = "pending";
					} else {
						search_status = status;
					}
	
				} 
//				else {
//					search_status = "";
//				}
	
				if (officetype.equals("Branch") && branchcode != "") {
	
					if (search_status.equals("pending")) {
						List<ApplicationDetails> searchPendingWithBranchApplicationForm = null;
						if (search_acc_no != "" || search_acc_name != "" || search_refno != "") {
							searchPendingWithBranchApplicationForm = adLoginUserService .searchPendingApplicationFormWithBranch(branchcode, search_refno, search_acc_name, search_acc_no, search_mobile);
	
						} else {
							searchPendingWithBranchApplicationForm = adLoginUserService .searchPendingApplicationFormWithBranch(branchcode, search_refno, search_acc_name, search_acc_no, search_mobile);
						}
						model.addAttribute("search_status", search_status);
						model.addAttribute("login_users", adLoginUsers);
						model.addAttribute("pendingWithBranchApplicationForm", searchPendingWithBranchApplicationForm);
					} else {
						List<ApplicationDetails> searchNotPendingWithBranchApplicationForm = null;
						if (search_acc_no != "" || search_acc_name != "" || search_refno != "") {
							searchNotPendingWithBranchApplicationForm = adLoginUserService .searchStatusApplicationFormWithBranch(search_status, branchcode, search_refno, search_acc_name, search_acc_no, search_mobile);
							model.addAttribute("search_status", search_status);
						} else {
							searchNotPendingWithBranchApplicationForm = adLoginUserService .searchStatusApplicationFormWithBranch(search_status, branchcode, search_refno, search_acc_name, search_acc_no, search_mobile);
							model.addAttribute("search_status", search_status);
						}
	
						model.addAttribute("login_users", adLoginUsers);
						model.addAttribute("pendingWithBranchApplicationForm", searchNotPendingWithBranchApplicationForm);
					}
				}
	
				else {
	
					if (search_status.equals("pending")) {
						List<ApplicationDetails> allPendingWithBranchApplicationForm = null;
	
						if (search_acc_no != "" || search_acc_name != "" || search_refno != "") {
							allPendingWithBranchApplicationForm = adLoginUserService.searchPendingApplicationForm( search_refno, search_acc_name, search_acc_no, search_mobile);
	
						} else {
							allPendingWithBranchApplicationForm = adLoginUserService.searchPendingApplicationForm( search_refno, search_acc_name, search_acc_no, search_mobile);
	
						}
	
						if (redirectAttributes.containsAttribute("ref_no")) {
							String refno = redirectAttributes.getAttribute("ref_no").toString();
							model.addAttribute("ref_no", refno);
						}
						model.addAttribute("search_status", search_status);
						model.addAttribute("login_users", adLoginUsers);
						model.addAttribute("pendingWithBranchApplicationForm", allPendingWithBranchApplicationForm);

					
					} else {
						List<ApplicationDetails> allPendingWithBranchApplicationForm = null;
	
						if (search_acc_no != "" || search_acc_name != "" || search_refno != "") {
							allPendingWithBranchApplicationForm = adLoginUserService.searchApplicationFormNotPending( search_status, search_refno, search_acc_name, search_acc_no, search_mobile);
							model.addAttribute("search_status", search_status);
						} else {
							allPendingWithBranchApplicationForm = adLoginUserService.searchApplicationFormNotPending( search_status, search_refno, search_acc_name, search_acc_no, search_mobile);
							model.addAttribute("search_status", search_status);
	
						}
						
					
					
						model.addAttribute("login_users", adLoginUsers);
						model.addAttribute("pendingWithBranchApplicationForm", allPendingWithBranchApplicationForm);
	
					}
				}
			} else {
				return "redirect:/";
			}
		}
		String officetype = adLoginUsers.getOfficetype();
		String depname = adLoginUsers.getDepname();
		List<ApplicationStaus> applicationStatusCount = adLoginUserService.applicationStatusCount(officetype, depname);
		for (int i = 0; i < applicationStatusCount.size(); i++) {
			if (applicationStatusCount.get(i).getApplicationStatus().equals("rejected")) {
				reject = applicationStatusCount.get(i).getTotal();
			}

			else if (applicationStatusCount.get(i).getApplicationStatus().equals("pending")) {
				pendingfinal = applicationStatusCount.get(i).getTotal();
			}

			else if (applicationStatusCount.get(i).getApplicationStatus().equals("approved")) {
				approve = applicationStatusCount.get(i).getTotal();
			}

			else if (applicationStatusCount.get(i).getApplicationStatus().equals("new")) {
				pendingWithBranch = applicationStatusCount.get(i).getTotal();
			}

			else if (applicationStatusCount.get(i).getApplicationStatus().equals("modified")) {
				modified = applicationStatusCount.get(i).getTotal();
			}

		}

		model.addAttribute("pendingWithBranch", pendingWithBranch);
		model.addAttribute("pendingfinal", pendingfinal);
		model.addAttribute("approve", approve);
		model.addAttribute("reject", reject);
		model.addAttribute("modified", modified);
		return "search_file";
	}

	@PostMapping("manageaccount")
	public String manageAccount(Model model, @ModelAttribute ApplicationUsers applicationUsers,
			@ModelAttribute ApplicationEnterprises applicationEnterprises, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirectAttributes) {

		LoginUser adLoginUsers = (LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/";
		} else {
			
			String prefCorpRegex="[a-zA-Z0-9]+";
			if(applicationEnterprises.getPrefCorp().matches(prefCorpRegex)) {
				
					String acc_no = applicationUsers.getAccNo();
					String[] manage_accno_cust = null;
					String[] manage_accno = null;
					ManageCustAcctDetail manageCustAcctDetail = new ManageCustAcctDetail();
					String urlcall = manageCustAcctDetail.manageCheckUser(acc_no).toString();
					JSONObject jsonObject = new JSONObject(urlcall);
					System.out.println(urlcall);
					if (jsonObject.has("Acctlist")) {
		
						ApplicationUsers applnUsers = applicationUserServiceImpl.getApplicationUsers(applicationUsers, applicationEnterprises);
						List<String> listPrefNo = new ArrayList<>();
						listPrefNo.add(applnUsers.getPrefNo());
						listPrefNo.add(applnUsers.getPrefNo().toUpperCase());
						Users user = applicationUserServiceImpl.getUsersByPrefNoInAndMarkAsEnabled(listPrefNo, 1);
						if (user != null) {
							Long user_id = user.getId();
							manage_accno_cust = jsonObject.get("Acctlist").toString().replaceAll("\"", "").replaceAll("\\[", "") .replaceAll("\\]", "").split(",");
							ManagedAccounts manageAccountList = managedAccountServiceImpl.getAccounts(user_id);
							if (manageAccountList != null) {
								manage_accno = manageAccountList.getAccounts().replaceAll("\"", "").replaceAll("\\[", "") .replaceAll("\\]", "").split(",");
							}
		
							int n = 0;
							if (manage_accno != null) {
								n = manage_accno.length;
							}
							int n1 = manage_accno_cust.length;
		
							List<String> result = new ArrayList<>();
							List<String> result2 = new ArrayList<>();
							boolean unique = true;
		
							int k = 0;
		
							int k1 = 0;
		
							for (int i = 0; i < n1; i++) {
		
								unique = true;
		
								for (int j = 0; j < n; j++) {
		
									if (manage_accno_cust[i].equals(manage_accno[j])) {
										unique = false;
									}
								}
								if (unique == true) {
									result.add(manage_accno_cust[i]);
									k++;
								} else {
									result2.add(manage_accno_cust[i]);
		
									k1++;
								}
							}
		
							model.addAttribute("login_users", adLoginUsers);
							model.addAttribute("applnUsers", applnUsers);
							model.addAttribute("applicationEnterprises", applicationEnterprises);
							model.addAttribute("user", user);
							model.addAttribute("result", result);
							model.addAttribute("result2", result2);
							model.addAttribute("manage_accno_cust", manage_accno_cust);
							model.addAttribute("manage_accno", manage_accno);
							model.addAttribute("appid", applicationEnterprises.getApplicationFormId());
						} else {
							System.out.println("invalid user........");
							redirectAttributes.addFlashAttribute("message", "Something went wrong");
							return "redirect:/approvelist";
						}
					} else {
						System.out.println("account list is empty........");
						String msg="";
						if(jsonObject.has("msg")) {
							msg=jsonObject.get("msg").toString();
						}else {
							msg="Something went wrong";
						}
						redirectAttributes.addFlashAttribute("message",msg);
						return "redirect:/approvelist";
					}
			}else {
				System.out.println("invalid data........");
				redirectAttributes.addFlashAttribute("message", "Something went wrong");
				return "redirect:/approvelist";
			}
			return "manage_account";
		}
	}
}
