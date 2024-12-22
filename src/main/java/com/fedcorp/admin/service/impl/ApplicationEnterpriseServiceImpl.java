package com.fedcorp.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedcorp.admin.apicall.SMSSendAPI;
import com.fedcorp.admin.entities.ApplicationEnterprises;
import com.fedcorp.admin.repositories.ApplicationEnterprisesRepository;
import com.fedcorp.admin.services.ApplicationEnterprisesService;

@Service
public class ApplicationEnterpriseServiceImpl implements ApplicationEnterprisesService {
	@Autowired
	private ApplicationEnterprisesRepository applicationEnterprisesRepository;
	
	

	public List<ApplicationEnterprises> getAll() {
		return applicationEnterprisesRepository.findAll();
	}

	public Long applicationEnterprises(String acc_name, String cust_no, String acc_no, String address,
			Long application_form_id, String auth_fund, String auth_ext, String auth_ben, String pref_corp,
			String constitution, long branch_id, Long daily_limit, Long monthly_limit, long coolingPeriod) {
		Long applicationEnterprisesId = null;
		try {

			ApplicationEnterprises applicationEnterprises = new ApplicationEnterprises();
			applicationEnterprises.setAccName(acc_name);
			applicationEnterprises.setCustNo(cust_no);
			applicationEnterprises.setAccNo(acc_no);
			applicationEnterprises.setAddress(address);
			applicationEnterprises.setApplicationFormId(application_form_id);
			applicationEnterprises.setAuthFund(auth_fund);
			applicationEnterprises.setAuthExt(auth_ext);
			applicationEnterprises.setAuthBen(auth_ben);
			applicationEnterprises.setPrefCorp(pref_corp);
			applicationEnterprises.setCreatedAt(new java.util.Date());
			applicationEnterprises.setUpdatedAt(new java.util.Date());
			applicationEnterprises.setConstitution(constitution);
			applicationEnterprises.setBranchId(branch_id);
			applicationEnterprises.setActive(true);
			applicationEnterprises.setDailyLimit(daily_limit);
			applicationEnterprises.setMonthlyLimit(monthly_limit);
			applicationEnterprises.setCoolingPeriod(coolingPeriod);
			ApplicationEnterprises newApplicationEnterprises = applicationEnterprisesRepository.save(applicationEnterprises);
			if(newApplicationEnterprises!=null) {
				applicationEnterprisesId = newApplicationEnterprises.getId();
				System.out.println("data save into applicationEnterprises table....");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return applicationEnterprisesId;
	}

	public Long update_application_enterpries(long applicationEnterprisesId, String auth_fund, String auth_ext,
			String auth_ben, long totalminutes, Long monthly_limit, Long daily_limit) {

		Long getapplnid = null;

		try {
			ApplicationEnterprises applicationEnterprises = applicationEnterprisesRepository.findById(applicationEnterprisesId).get();
			applicationEnterprises.setAuthFund(auth_fund);
			applicationEnterprises.setAuthExt(auth_ext);
			applicationEnterprises.setAuthBen(auth_ben);
			applicationEnterprises.setCoolingPeriod(totalminutes);
			applicationEnterprises.setDailyLimit(daily_limit);
			applicationEnterprises.setMonthlyLimit(monthly_limit);
			applicationEnterprises.setUpdatedAt(new java.util.Date());
			ApplicationEnterprises updatedApplicationEnterprises = applicationEnterprisesRepository.save(applicationEnterprises);
			getapplnid = updatedApplicationEnterprises.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getapplnid;
	}

	public long updateApplicationEnterprises(Long applicationEnterprisesId, Long monthly_limit, Long daily_limit,
			List<String> user_mobile_no) {
		long getapplnid = 0;
		try {
			ApplicationEnterprises applicationEnterprises = applicationEnterprisesRepository .findById(applicationEnterprisesId).get();

			Long oldDailyLimit = applicationEnterprises.getDailyLimit();
			Long oldMonthlyLimit = applicationEnterprises.getMonthlyLimit();

			if (daily_limit != oldDailyLimit || oldMonthlyLimit != monthly_limit) {

				for (int i = 0; i < user_mobile_no.size(); i++) {
		    			 SMSSendAPI apisms=new SMSSendAPI("");
		 				 apisms.sendingSMSAPI(user_mobile_no.get(i), "Dear Customer, Your FedCorp transaction limit is modified as per your request. Call 18004251199 if not initiated by you - Federal Bank");
		    			 System.out.println(" sending sms for mobile "+user_mobile_no.get(i));

				}
				applicationEnterprises.setDailyLimit(daily_limit);
				applicationEnterprises.setMonthlyLimit(monthly_limit);
				applicationEnterprises.setUpdatedAt(new java.util.Date());
				applicationEnterprisesRepository.save(applicationEnterprises);
			}
			getapplnid = applicationEnterprises.getId();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return getapplnid;

	}

}
