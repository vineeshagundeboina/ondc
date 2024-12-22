package com.fedcorp.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fedcorp.admin.apicall.Utilities;
import com.fedcorp.admin.config.CommonRequest;
import com.fedcorp.admin.entities.ApplicationDetails;
import com.fedcorp.admin.entities.ApplicationUsers;
import com.fedcorp.admin.entities.Comments;
import com.fedcorp.admin.entities.Documents;
import com.fedcorp.admin.entities.LoginUser;
import com.fedcorp.admin.service.impl.AdLoginUserServiceImpl;
import com.fedcorp.admin.service.impl.ApplicationServiceImpl;

@Controller
public class ApplicationViewController {
	
	@Autowired
	public AdLoginUserServiceImpl adLoginUserService;

	@Autowired
	public ApplicationServiceImpl applicationServiceImpl;
	
	@Autowired
	public Utilities utilities;
	

	@GetMapping("/pending_with_branch_view")
	public String pending_with_branch_view(HttpServletRequest request, Model model) {
		LoginUser adLoginUsers =	(LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/"; 
		}else {
			return "pending_with_branch_application";
		}
	}
	@GetMapping("/forwarded_view")
	public String forwarded_view(HttpServletRequest request, Model model) {
		LoginUser adLoginUsers =	(LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/"; 
		}else {
			return "forwarded_application";
		}
	}
	
	
	@GetMapping("/rejected_view")
	public String rejected_view(HttpServletRequest request, Model model) {
		LoginUser adLoginUsers =	(LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/"; 
		}else {
			return "rejected_application";
		}
	}
	
	
	@GetMapping("/pending_with_final_application_view")
	public String pending_with_final_application_view(HttpServletRequest request, Model model) {
		LoginUser adLoginUsers =	(LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/"; 
		}else {
			return "pending_with_final_application_view";
		}
	}
	
	
	@GetMapping("/approved_view")
	public String approved_view(HttpServletRequest request, Model model) {
		LoginUser adLoginUsers =	(LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/"; 
		}else {
			return "approved_application";
		}
	}
	@GetMapping("/modified_view")
	public String modified_view(HttpServletRequest request, Model model) {
		LoginUser adLoginUsers =	(LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/"; 
		}else {
			return "modified_application";
		}
	}
	@GetMapping("/pending_final_application")
	public String pendingwithfinal_view(HttpServletRequest request, Model model) {
		LoginUser adLoginUsers =	(LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/"; 
		}else {
			return "pending_final_application";
		}
	}
	

	@PostMapping("newapplication-view")
	public String newApplicationView(@RequestParam("applnformid") String applicationid, Model model,HttpServletRequest request,RedirectAttributes redirectAttributes) {
		LoginUser adLoginUsers =	(LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/"; 
		} else {
			String applnreg="[0-9]+";
			if(applicationid.matches(applnreg)) {
				ApplicationDetails applicationDetails = applicationServiceImpl.applicationDetails(applicationid);	
				List<Comments> comments = applicationServiceImpl.applicationComments(applicationid);
				List<Documents> documents = applicationServiceImpl.applicationDocuments(applicationid);
				List<ApplicationUsers> applicationUsers = applicationServiceImpl.applicationUser(applicationDetails.getApplnEnterprisesId().toString());
				redirectAttributes.addFlashAttribute("applicationDetails", applicationDetails);
				redirectAttributes.addFlashAttribute("login_users", adLoginUsers);
				redirectAttributes.addFlashAttribute("comments", comments);
				redirectAttributes.addFlashAttribute("documents", documents);
				redirectAttributes.addFlashAttribute("applicationUsers", applicationUsers);
				
				if(applicationDetails.getStatus().equals("rejected") && !applicationDetails.getStatus().equals("new")) {
					return "redirect:/rejected_view"; 
				}else if(applicationDetails.getStatus().equals("approved") && !applicationDetails.getStatus().equals("new")) {
					return "redirect:/approved_view"; 
				}else if((applicationDetails.getStatus().equals("pending") || applicationDetails.getStatus().equals("modified")) && !applicationDetails.getStatus().equals("new")){
					return "redirect:/pending_with_final_application_view"; 	
				}else {
					return "redirect:/pending_with_branch_view"; 
				}
			}else {
				redirectAttributes.addFlashAttribute("errorMsg", "Something went wrong");
				return "redirect:/homepage"; 
			}
		}
	}
	
	
	@PostMapping("forwarded-application")
	public String forwardedApplicationform(@RequestParam("applnformid") String applicationid, Model model,HttpServletRequest request,RedirectAttributes redirectAttributes) {
	
		LoginUser adLoginUsers =	(LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/"; 
		} else {
			
			String applnreg="[0-9]+";
			if(applicationid.matches(applnreg)) {
			ApplicationDetails applicationDetails = applicationServiceImpl.applicationDetails(applicationid);
			List<Comments> comments = applicationServiceImpl.applicationComments(applicationid);
			List<Documents> documents = applicationServiceImpl.applicationDocuments(applicationid);
			List<ApplicationUsers> applicationUsers = applicationServiceImpl.applicationUser(applicationDetails.getApplnEnterprisesId().toString());
			redirectAttributes.addFlashAttribute("applicationDetails", applicationDetails);
			redirectAttributes.addFlashAttribute("login_users", adLoginUsers);
			redirectAttributes.addFlashAttribute("comments", comments);
			redirectAttributes.addFlashAttribute("documents", documents);
			redirectAttributes.addFlashAttribute("applicationUsers", applicationUsers);
			
			if(applicationDetails.getStatus().equals("rejected") && !applicationDetails.getStatus().equals("new")) {
				return "redirect:/rejected_view"; 
			}else if(applicationDetails.getStatus().equals("approved") && !applicationDetails.getStatus().equals("new")) {
				return "redirect:/approved_view"; 
			}else {
				return "redirect:/forwarded_view"; 
			}	
			}else {
				redirectAttributes.addFlashAttribute("errorMsg", "Something went wrong");
				return "redirect:/homepage"; 
			}
		}

	}
	
	
	
	
	
	@PostMapping("approved-application")
	public String approvedApplicationView(CommonRequest commonRequest, Model model,HttpServletRequest request,RedirectAttributes redirectAttributes) {
		LoginUser adLoginUsers =	(LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/";  
		} else {
			String applicationid=	commonRequest.getApplnformid();
			String regex="[0-9]+";
			if(applicationid.matches(regex)) {
				ApplicationDetails applicationDetails = applicationServiceImpl.applicationDetails(applicationid);
				List<Comments> comments = applicationServiceImpl.applicationComments(applicationid);
				List<Documents> documents = applicationServiceImpl.applicationDocuments(applicationid);
				List<ApplicationUsers> applicationUsers = applicationServiceImpl.applicationUser(applicationDetails.getApplnEnterprisesId().toString());
				redirectAttributes.addFlashAttribute("applicationDetails", applicationDetails);
				redirectAttributes.addFlashAttribute("login_users", adLoginUsers);
				redirectAttributes.addFlashAttribute("comments", comments);
				redirectAttributes.addFlashAttribute("documents", documents);
				redirectAttributes.addFlashAttribute("applicationUsers", applicationUsers);
				if(applicationDetails.getStatus().equals("rejected") && !applicationDetails.getStatus().equals("approved")) {
					return "redirect:/rejected_view"; 
				}else if(applicationDetails.getStatus().equals("new") && !applicationDetails.getStatus().equals("approved")) {
					return "redirect:/forwarded_view"; 
				}else {
					return "redirect:/approved_view"; 
				}
			}else {
				redirectAttributes.addFlashAttribute("errorMsg", "Something went wrong");
				return "redirect:/homepage"; 
			}
		}
	}
	
	
	
	@PostMapping("modified-application")
	public String modifiedApplicationform(@RequestParam("applnformid") String applicationid, Model model,HttpServletRequest request,RedirectAttributes redirectAttributes) {
		LoginUser adLoginUsers =	(LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/"; 
		} else {
			String regex="[0-9]+";
			int app=Integer.parseInt(applicationid);
			if(app>Integer.MAX_VALUE) {
				redirectAttributes.addFlashAttribute("errorMsg", "applicationid is exceeding maximum integer limit");
				return "redirect:/homepage";
				
			}
			else {
				
			applicationid=String.valueOf(app);	
			if(applicationid.matches(regex)) {
				ApplicationDetails applicationDetails = applicationServiceImpl.applicationDetails(applicationid);
				List<Comments> comments = applicationServiceImpl.applicationComments(applicationid);
				List<Documents> documents = applicationServiceImpl.applicationDocuments(applicationid);
				List<ApplicationUsers> applicationUsers = applicationServiceImpl.applicationUser(applicationDetails.getApplnEnterprisesId().toString());
				redirectAttributes.addFlashAttribute("applicationDetails", applicationDetails);
				redirectAttributes.addFlashAttribute("login_users", adLoginUsers);
				redirectAttributes.addFlashAttribute("comments", comments);
				redirectAttributes.addFlashAttribute("documents", documents);
				redirectAttributes.addFlashAttribute("applicationUsers", applicationUsers);
	
				return "redirect:/modified_view";
			}else {
				redirectAttributes.addFlashAttribute("errorMsg", "Something went wrong");
				return "redirect:/homepage";
			}
			}
		}

	}

	@PostMapping("reject-application")
	public String rejectedApplicationView(@RequestParam("applnformid") String applicationid, Model model,HttpServletRequest request,RedirectAttributes redirectAttributes) {
		LoginUser adLoginUsers =(LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/"; 
		} else {
			String regex="[0-9]+";
			if(applicationid.matches(regex)) {
				ApplicationDetails applicationDetails = applicationServiceImpl.applicationDetails(applicationid);
				List<Comments> comments = applicationServiceImpl.applicationComments(applicationid);
				List<Documents> documents = applicationServiceImpl.applicationDocuments(applicationid);
				List<ApplicationUsers> applicationUsers = applicationServiceImpl.applicationUser(applicationDetails.getApplnEnterprisesId().toString());
				redirectAttributes.addFlashAttribute("applicationDetails", applicationDetails);
				redirectAttributes.addFlashAttribute("login_users", adLoginUsers);
				redirectAttributes.addFlashAttribute("comments", comments);
				redirectAttributes.addFlashAttribute("documents", documents);
				redirectAttributes.addFlashAttribute("applicationUsers", applicationUsers);
				
				if(applicationDetails.getStatus().equals("new") && !applicationDetails.getStatus().equals("rejected")) {
					return "redirect:/pending_with_branch_view"; 
				}else if(applicationDetails.getStatus().equals("approved") && !applicationDetails.getStatus().equals("rejected")) {
					return "redirect:/approved_view"; 
				}else {
					return "redirect:/rejected_view"; 
				}
				
			}else {
				redirectAttributes.addFlashAttribute("errorMsg", "Something went wrong");
				return "redirect:/homepage";
			}
		}
	}
	
	
	
	@PostMapping("pending_with_final_application")
	public String pending_with_final_application_view(@RequestParam("applnformid") String applicationid, Model model,HttpServletRequest request,RedirectAttributes redirectAttributes) {
		LoginUser adLoginUsers =(LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/"; 
		} else {
			String regex="[0-9]+";
			if(applicationid.matches(regex)) {
				ApplicationDetails applicationDetails = applicationServiceImpl.pendingWithFinalappln(applicationid);
				List<Comments> comments = applicationServiceImpl.applicationComments(applicationid);
				List<Documents> documents = applicationServiceImpl.applicationDocuments(applicationid);
				List<ApplicationUsers> applicationUsers = applicationServiceImpl.applicationUser(applicationDetails.getApplnEnterprisesId().toString());
		
				redirectAttributes.addFlashAttribute("applicationDetails", applicationDetails);
				redirectAttributes.addFlashAttribute("login_users", adLoginUsers);
				redirectAttributes.addFlashAttribute("comments", comments);
				redirectAttributes.addFlashAttribute("documents", documents);
				redirectAttributes.addFlashAttribute("applicationUsers", applicationUsers);
				if(applicationDetails.getStatus().equals("rejected") && !applicationDetails.getStatus().equals("new")) {
					return "redirect:/rejected_view"; 
				}else if(applicationDetails.getStatus().equals("approved") && !applicationDetails.getStatus().equals("new")) {
					return "redirect:/approved_view"; 
				}else {
					return "redirect:/pending_with_final_application_view"; 
				}
			}else {
				redirectAttributes.addFlashAttribute("errorMsg", "Something went wrong");
				return "redirect:/homepage"; 
			}
		}
	}

	
	
	
	@PostMapping("pendingwithfinalapplication")
	public String pendingwithfinalapplication(@RequestParam(value = "applnformid", required = false) String applicationid, Model model,HttpServletRequest request,RedirectAttributes redirectAttributes) {
		LoginUser adLoginUsers =	(LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/";  
		} else {
			String regex="[0-9]+";
			if(applicationid.matches(regex)) {
				ApplicationDetails applicationDetails = applicationServiceImpl.pendingWithFinalappln(applicationid);
				List<Comments> comments = applicationServiceImpl.applicationComments(applicationid);
				List<Documents> documents = applicationServiceImpl.applicationDocuments(applicationid);
				List<ApplicationUsers> applicationUsers = applicationServiceImpl.applicationUser(applicationDetails.getApplnEnterprisesId().toString());
				redirectAttributes.addFlashAttribute("applicationDetails", applicationDetails);
				redirectAttributes.addFlashAttribute("login_users", adLoginUsers);
				redirectAttributes.addFlashAttribute("comments", comments);
				redirectAttributes.addFlashAttribute("documents", documents);
				redirectAttributes.addFlashAttribute("applicationUsers", applicationUsers);
				if(applicationDetails.getStatus().equals("rejected") && !applicationDetails.getStatus().equals("new")) {
					return "redirect:/rejected_view"; 
				}else if(applicationDetails.getStatus().equals("approved") && !applicationDetails.getStatus().equals("new")) {
					return "redirect:/approved_view"; 
				}else {
					return "redirect:/pending_final_application"; 
				}
			}else {
				redirectAttributes.addFlashAttribute("errorMsg", "Something went wrong");
				return "redirect:/homepage"; 
			}
		}
	}
	
	
	
}
