package com.fedcorp.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fedcorp.admin.apicall.Utilities;
import com.fedcorp.admin.entities.ApplicationDetails;
import com.fedcorp.admin.entities.LoginUser;
import com.fedcorp.admin.service.impl.AdLoginUserServiceImpl;
import com.fedcorp.admin.service.impl.ApplicationServiceImpl;

@Controller
public class ApplicationListController {

	@Autowired
	public AdLoginUserServiceImpl adLoginUserService;

	@Autowired
	public ApplicationServiceImpl applicationServiceImpl;

	@Autowired
	public Utilities utilities;

	@RequestMapping("pendfinalappv")
	public String pendingFinalAppv(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		LoginUser adLoginUsers = (LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/";
		} else {

			if (!adLoginUsers.getOfficetype().equals("Branch")) {
				List<ApplicationDetails> pendingFinalApplication = adLoginUserService.pendingWithFinalApplication();
				model.addAttribute("approvedApplication", pendingFinalApplication);
				model.addAttribute("login_users", adLoginUsers);
				if (redirectAttributes.containsAttribute("ref_no")) {
					String refno = redirectAttributes.getAttribute("ref_no").toString();
					model.addAttribute("ref_no", refno);

				}
				if (redirectAttributes.containsAttribute("message")) {
					String message = redirectAttributes.getAttribute("message").toString();
					model.addAttribute("message", message);

				}
				return "pending_with_final_list";
			} else {
				return "redirect:/homepage";
			}
		}
	}

	@RequestMapping("approvelist")
	public String approveList(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		LoginUser adLoginUsers = (LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/";
		} else {
			String officetype = adLoginUsers.getOfficetype();
			String depname = adLoginUsers.getDepname();
			List<ApplicationDetails> approvedApplication = adLoginUserService.approvedApplication(officetype, depname);
			model.addAttribute("approvedApplication", approvedApplication);
			model.addAttribute("login_users", adLoginUsers);
			return "approve_list";
		}
	}

	@GetMapping("rejectedlist")
	public String rejectedList(Model model, HttpServletRequest request) {
		LoginUser adLoginUsers = (LoginUser) request.getSession().getAttribute("logindetails");
		if (adLoginUsers == null) {
			return "redirect:/";
		} else {
			String officetype = adLoginUsers.getOfficetype();
			String depname = adLoginUsers.getDepname();
			List<ApplicationDetails> rejectedApplication = adLoginUserService.rejectedApplication(officetype, depname);
			model.addAttribute("rejectedApplication", rejectedApplication);
			model.addAttribute("login_users", adLoginUsers);
			return "rejected_list";
		}
	}

}
