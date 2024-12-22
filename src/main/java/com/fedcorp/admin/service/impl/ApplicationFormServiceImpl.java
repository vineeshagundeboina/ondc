package com.fedcorp.admin.service.impl;

import java.util.Random;

import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedcorp.admin.entities.ApplicationForms;
import com.fedcorp.admin.repositories.ApplicationFormRepository;

@Service
public class ApplicationFormServiceImpl {

	private static final org.apache.log4j.Logger logger = LogManager.getLogger(ApplicationFormServiceImpl.class);

	@Autowired
	private ApplicationFormRepository applicationFormRepository;

	public Long applicationform(String declaration, String created_by, String reference_id) {
		String codehex = "";
		Long applicationFormId = null;
		codehex = getRandomHexString(6);
		codehex = "REF" + codehex.toUpperCase();

		ApplicationForms applicationForms = new ApplicationForms();
		applicationForms.setDeclaration(declaration);
		applicationForms.setRefNo(codehex);
		applicationForms.setReferenceId(reference_id);
		applicationForms.setCreatedAt(new java.util.Date());
		applicationForms.setUpdatedAt(new java.util.Date());
		applicationForms.setStatusDesc("Application submitted to Bank and Waiting for Approval");
		applicationForms.setCreatedBy(created_by);
		ApplicationForms newapplicationForms = applicationFormRepository.save(applicationForms);
		System.out.print(" data save  in application_forms table....");
		if (newapplicationForms != null) {
			applicationFormId = newapplicationForms.getId();
		}
		return applicationFormId;
	}

	private String getRandomHexString(int numchars) {
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		while (sb.length() < numchars)
			sb.append(Integer.toHexString(r.nextInt()));
		return sb.toString().substring(0, numchars);
	}

	public String finalApplicationUpdateStatus(Long appform_id) {
		String applicationFormId = null;
		try {
			ApplicationForms applicationForm = applicationFormRepository.findById(appform_id).get();
			applicationForm.setUpdatedAt(new java.util.Date());
			applicationForm.setStatus("new");
			ApplicationForms updatedApplicationForm = applicationFormRepository.save(applicationForm);
			if (updatedApplicationForm != null) {
				applicationFormId = updatedApplicationForm.getRefNo();
				System.out.println(">>>>>>FinalStatusID>>>>>>>>>" + updatedApplicationForm.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		}
		return applicationFormId;

	}

	public void finalApplicationUpdateStatusToRejected(Long appform_id) {
		try {
			ApplicationForms applicationForm = applicationFormRepository.findById(appform_id).get();
			applicationForm.setUpdatedAt(new java.util.Date());
			applicationForm.setStatus("rejected");// testing purpose set new but here value is rejected
			applicationForm.setDeclaration("Application rejected because of filenet issue");
			applicationFormRepository.save(applicationForm);
			System.out.println(" update applicationForm status rejected due to filenet issue .....");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		}

	}

	public String getReferenceNo(Long applicationid) {
		String app_Refer_No = "";
		try {
			ApplicationForms applicationForm = applicationFormRepository.findById(applicationid).get();
			app_Refer_No = applicationForm.getRefNo();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return app_Refer_No;
	}

	public long finalApplicationUpdate(long long_application_id, String actionBy, String reference_id,
			String declaration, String status) {
		long getapplnid = 0;

		try {
			ApplicationForms applicationForm = applicationFormRepository.findById(long_application_id).get();
			if (status.equals("pending")) {
				applicationForm.setForwardedBy(actionBy);
				applicationForm.setForwardedAt(new java.util.Date());
			}
			if (status.equals("modified")) {
				applicationForm.setModifiedBy(actionBy);
				applicationForm.setModifiedAt(new java.util.Date());
			}
			applicationForm.setStatus(status);
			applicationForm.setReferenceId(reference_id);
			applicationForm.setDeclaration(declaration);
			applicationForm.setUpdatedAt(new java.util.Date());
			ApplicationForms updatedApplicationForm = applicationFormRepository.save(applicationForm);
			getapplnid = updatedApplicationForm.getId();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		}

		return getapplnid;
	}

	public long finalapplicationapproveStatus(long long_application_id, String loginname) {
		long getapplnid = 0;

		try {
			ApplicationForms applicationForm = applicationFormRepository.findById(long_application_id).get();
			applicationForm.setStatus("approved");
			applicationForm.setStatusDesc("Application is approved");
			applicationForm.setApprovedBy(loginname);
			applicationForm.setApprovedAt(new java.util.Date());
			applicationForm.setUpdatedAt(new java.util.Date());
			ApplicationForms updatedApplicationForm = applicationFormRepository.save(applicationForm);
			if (updatedApplicationForm != null) {
				getapplnid = updatedApplicationForm.getId();
				logger.info("finalapplicationapproveStatus Success");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			logger.info(e);
		}

		return getapplnid;
	}
}
