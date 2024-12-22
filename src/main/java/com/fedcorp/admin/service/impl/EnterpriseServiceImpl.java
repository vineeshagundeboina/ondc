package com.fedcorp.admin.service.impl;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedcorp.admin.entities.Enterprises;
import com.fedcorp.admin.repositories.EnterprisesRepository;

@Service
public class EnterpriseServiceImpl {

	private static final org.apache.log4j.Logger logger = LogManager.getLogger(EnterpriseServiceImpl.class);

	@Autowired
	private EnterprisesRepository enterprisesRepository;

	public long checkEnterprisetable(long long_application_id) {
		long getUserCont = 0;

		try {

			System.out.println("Enterprises Check Called for application id " + long_application_id);

			Enterprises enterprises = enterprisesRepository.findFirstByApplicationFormId(long_application_id);
			if (enterprises != null) {
				getUserCont = enterprises.getId();
				System.out.println("Enterprises Check Called for existing entrprise id " + getUserCont);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		System.out.println("final enterprise id of existing " + getUserCont);

		return getUserCont;

	}

	public long enterprises_users(String acc_name, String auth_fund, String auth_ben, String auth_ext, String pref_corp,
			String accnum, String customerid, String address, String constitution, long appid) {

		System.out.println(" inserting into enterprises " + accnum + " customer id " + customerid + " applicatn id " + appid);
		Date date = new Date();
		long returnkeyid = 0;
		try {
			Enterprises enterprises = new Enterprises();
			enterprises.setAccName(constitution);
			enterprises.setAuthFund(auth_fund);
			enterprises.setAuthBen(auth_ben);
			enterprises.setAuthExt(auth_ext);
			enterprises.setPrefCorp(pref_corp);
			enterprises.setAccNo(accnum);
			enterprises.setCustNo(customerid);
			enterprises.setAddress(address);
			enterprises.setConstitution(constitution);
			enterprises.setApplicationFormId(appid);
			enterprises.setCreatedAt(date);
			enterprises.setUpdatedAt(date);
			enterprises.setActive(true);
			enterprises.setCoolingPeriod(0L);
			Enterprises insert = enterprisesRepository.save(enterprises);
			if (insert != null) {
				returnkeyid = insert.getId();
				System.out.println("insert into enterprise completed  with appln id" + appid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnkeyid;
	}

}
