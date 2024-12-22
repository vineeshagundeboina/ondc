package com.fedcorp.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fedcorp.admin.apicall.CustomerDetailsDev;
import com.fedcorp.admin.apicall.ManageCustAcctDetail;
import com.fedcorp.admin.config.CommonRequest;
import com.fedcorp.admin.entities.ApplicationDetails;
import com.fedcorp.admin.entities.ApplicationEnterprises;
import com.fedcorp.admin.entities.ApplicationUsers;
import com.fedcorp.admin.entities.Comments;
import com.fedcorp.admin.entities.Documents;
import com.fedcorp.admin.entities.LoginUser;
import com.fedcorp.admin.entities.ManagedAccounts;
import com.fedcorp.admin.entities.Users;
import com.fedcorp.admin.service.impl.ApplicationServiceImpl;
import com.fedcorp.admin.service.impl.ApplicationUserServiceImpl;
import com.fedcorp.admin.service.impl.ManagedAccountServiceImpl;

@Controller
public class ManageAccountController {

	private static final org.apache.log4j.Logger logger = LogManager.getLogger(ManageAccountController.class);
	
	@Autowired
	public ManagedAccountServiceImpl managedAccountServiceImpl;

	@Autowired
	public CustomerDetailsDev customerDetailsDev;
	
	

	@Autowired
	public ApplicationUserServiceImpl applicationUserServiceImpl;
	
	@Autowired
	public ApplicationServiceImpl applicationServiceImpl;
	
	@PostMapping("accountList")
	public String manageAccount(CommonRequest commonRequest,Model model, RedirectAttributes redirectAttributes,HttpServletRequest request) {
		LoginUser adLoginUsers =(LoginUser) request.getSession().getAttribute("logindetails");
		List<String> acctlists=commonRequest.getAccount();
		String applicationid=commonRequest.getApplicationFormId();
		Long user_id=commonRequest.getUser_id();	
		ManagedAccounts managedAccounts = null;
		String regex="[0-9]+";
		if(applicationid.matches(regex) && user_id.toString().matches(regex)) {
			if (!acctlists.isEmpty()) {
	
				for (int i = 0; i < acctlists.size(); i++) {
					if (acctlists.get(i) != null) {
						ManagedAccounts managedAcc = managedAccountServiceImpl.getAccounts(user_id);
						if (managedAcc != null) {
							managedAccounts = managedAccountServiceImpl.updateManageAccount(acctlists.get(i), user_id);
	
						} else {
							managedAccounts = managedAccountServiceImpl.saveManageAccount(user_id, acctlists.get(i));
						}
	
					}
				}
	
				redirectAttributes.addFlashAttribute("action", "acctlist");
			} else {
				redirectAttributes.addFlashAttribute("action", "failed");
			}
		}else {
			redirectAttributes.addFlashAttribute("action", "failed");
		}
		ApplicationDetails applicationDetails = applicationServiceImpl.applicationDetails(applicationid);
		List<Comments> comments = applicationServiceImpl.applicationComments(applicationid);
		List<Documents> documents = applicationServiceImpl.applicationDocuments(applicationid);
		List<ApplicationUsers> applicationUsers = applicationServiceImpl.applicationUser(applicationDetails.getApplnEnterprisesId().toString());
		redirectAttributes.addFlashAttribute("applicationDetails", applicationDetails);
		redirectAttributes.addFlashAttribute("login_users", adLoginUsers);
		redirectAttributes.addFlashAttribute("comments", comments);
		redirectAttributes.addFlashAttribute("documents", documents);
		redirectAttributes.addFlashAttribute("applicationUsers", applicationUsers);
		return "redirect:/approved_view";
	}

	@PostMapping("manageacctfunc")
	public String manageAccountFunction(@RequestParam("action") String action,	@RequestParam("userid") Long userid, @ModelAttribute ApplicationUsers applicationUsers,
			@ModelAttribute ApplicationEnterprises applicationEnterprises,
			HttpServletRequest request, Model model,RedirectAttributes redirectAttributes) {
		LoginUser adLoginUsers =	(LoginUser) request.getSession().getAttribute("logindetails");
		try {
			if (action.equals("gentkn")) {
				long genid = managedAccountServiceImpl.generateToken(userid, applicationUsers.getMobile());
				model.addAttribute("action", action);
			} else if (action.equals("forgot")) {
				long forgotid = managedAccountServiceImpl.forgotPwd(userid, applicationUsers.getMobile());
				model.addAttribute("action", action);
			} else if (action.equals("unblock")) {
				long unblockid = managedAccountServiceImpl.unblockUser(userid, applicationUsers.getMobile());
				model.addAttribute("action", action);

			} else if (action.equals("web_unblock")) {
				managedAccountServiceImpl.unblockWebUser(userid, applicationUsers.getMobile());
				model.addAttribute("action", action);
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("action", "failed");
		}
		String acc_no = applicationUsers.getAccNo();
		String accountRegx="[0-9]+";
		if(acc_no.matches(accountRegx)) {
			String[] manage_accno_cust = null;
			String[] manage_accno = null;
			ManageCustAcctDetail manageCustAcctDetail = new ManageCustAcctDetail();
			String urlcall = manageCustAcctDetail.manageCheckUser(acc_no).toString();
			JSONObject jsonObject = new JSONObject(urlcall);
			System.out.println(urlcall);
			if (jsonObject.has("Acctlist")) {
				ApplicationUsers applnUsers = applicationUserServiceImpl.getApplicationUsers(applicationUsers,applicationEnterprises);
				List<String> listPrefNo = new ArrayList<>();
				listPrefNo.add(applnUsers.getPrefNo());
				listPrefNo.add(applnUsers.getPrefNo().toUpperCase());
				Users user = applicationUserServiceImpl.getUsersByPrefNoInAndMarkAsEnabled(listPrefNo, 1);
				if (user != null) {
					Long user_id = user.getId();
					manage_accno_cust = jsonObject.get("Acctlist").toString().replaceAll("\"", "").replaceAll("\\[", "").replaceAll("\\]", "").split(",");
					ManagedAccounts manageAccountList = managedAccountServiceImpl.getAccounts(user_id);
					if (manageAccountList != null) {
						manage_accno = manageAccountList.getAccounts().replaceAll("\"", "").replaceAll("\\[", "").replaceAll("\\]", "").split(",");
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
					logger.info("invalid user........");
					model.addAttribute("action", "failed");
					return "manage_account";
				}
			} else {
				logger.info("account list is empty........");
				model.addAttribute("action", "failed");
				return "manage_account";
			}
		} else {
			logger.info("Invalid account no........");
			model.addAttribute("action", "failed");
			return "manage_account";
		}
		return "manage_account";
	}

	
	
	@PostMapping("updatemobile")
	public String updateMobile(@RequestParam("action") String action,@RequestParam("account") String account,@RequestParam("cust") String cust,
			@RequestParam("mobile") String mobile,Model model) {
		if(action!=null) {
			JSONObject resp=null;
			try{
				String mobileReg="[0-9]+";
				if(mobile.matches(mobileReg)) {
					resp=customerDetailsDev.mobileUpdate(mobile, cust, account);
				}else {
					System.out.println("invalid mobile no......");
					resp=new JSONObject();
					resp.put("status", false);
					resp.put("message", "Invalid mobile no...");
				}
				
			}catch(Exception e){
				e.printStackTrace();
				resp=new JSONObject();
				resp.put("status", false);
				resp.put("message", "Something went wrong while calling getcustdetails");
			}
			model.addAttribute("resp", resp);
			
		}
		return "newappln";
		
	}
	
	
	
}
