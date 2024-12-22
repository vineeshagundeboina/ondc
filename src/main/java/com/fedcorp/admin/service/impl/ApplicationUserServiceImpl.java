package com.fedcorp.admin.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedcorp.admin.entities.ApplicationEnterprises;
import com.fedcorp.admin.entities.ApplicationUsers;
import com.fedcorp.admin.entities.Users;
import com.fedcorp.admin.repositories.ApplicationEnterprisesRepository;
import com.fedcorp.admin.repositories.ApplicationUsersRepository;
import com.fedcorp.admin.repositories.UsersRespository;

@Service
public class ApplicationUserServiceImpl {

	@Autowired
	private ApplicationUsersRepository applicationUsersRepository;
	
	@Autowired
	private UsersRespository usersRespository;
	
	@Autowired
	private ApplicationEnterprisesRepository applicationEnterprisesRepository;
	
	public long application_users(String user_name, String application_enterprise_id, String pref_no, String cust_no, String mobile, Long trans_limit, Boolean lon_authorized_signatory) {
		String codehex = "";
	    long returnkeyid = 0L;
	    ApplicationUsers applicationUsers=new ApplicationUsers();
	    try {
	      codehex = getRandomHexString(6);
	      codehex = "REF" + codehex.toUpperCase();
	      applicationUsers.setUserName(user_name);
	      applicationUsers.setApplicationEnterpriseId(application_enterprise_id);
	      applicationUsers.setPrefNo(pref_no);
	      applicationUsers.setCustNo(cust_no);
	      applicationUsers.setMobile(mobile);
	      applicationUsers.setCreatedAt(new java.util.Date());
	      applicationUsers.setUpdatedAt(new java.util.Date());
	      applicationUsers.setTransLimit(trans_limit.toString());
	      applicationUsers.setActive(true);
	      applicationUsers.setAuthorizedSignatory(lon_authorized_signatory);	      
	      ApplicationUsers newApplicationUser=applicationUsersRepository.save(applicationUsers);
	      returnkeyid = newApplicationUser.getId(); 
	      System.out.println(" data save into applicationUsers table....");
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.out.println("error during save data in application users table: "+e.getMessage());
	    } 
	    return returnkeyid;
	}
	
	 private String getRandomHexString(int numchars) {
		    Random r = new Random();
		    StringBuffer sb = new StringBuffer();
		    while (sb.length() < numchars)
		      sb.append(Integer.toHexString(r.nextInt())); 
		    return sb.toString().substring(0, numchars);
		  }

	public int checkEnterpriseUser(Long applicationEnterprisesId, String custNo) {			
			int getUserCont=0;
			String applicationEnterId=applicationEnterprisesId.toString();
			 try {
			  getUserCont=applicationUsersRepository.countByCustNoAndApplicationEnterpriseId(custNo,applicationEnterId);	 
		     } catch (Exception e) {
				e.printStackTrace();
			}

			
			return getUserCont;
	}

	public long update_application_users(String applicationEnterId, String custNo, Long trans_limit, String pref_no,String mobile,Boolean auth) {
		long getapplnid=0;
		 try {
			 ApplicationUsers applicationUser= applicationUsersRepository.findByApplicationEnterpriseIdAndMobileAndCustNo(applicationEnterId,mobile,custNo);
			 applicationUser.setAuthorizedSignatory(auth);
			 applicationUser.setTransLimit(trans_limit.toString());
			 applicationUser.setActive(true);
			 applicationUser.setUpdatedAt(new java.util.Date());
			 ApplicationUsers updatedApplicationUser= applicationUsersRepository.save(applicationUser);
		     getapplnid=Long.parseLong(updatedApplicationUser.getApplicationEnterpriseId()); 				    	
		} catch (Exception e) {
			e.printStackTrace();
			
		}

			return getapplnid;
		
	}

	public ApplicationUsers getApplicationUsers(ApplicationUsers applicationUsers,ApplicationEnterprises applicationEnterprises) {
	
		  String prefNo=applicationUsers.getPrefNo();
		  Long applicationFormId=applicationEnterprises.getApplicationFormId();
		  String accNo=applicationUsers.getAccNo();
		  ApplicationUsers applnUsers=null;
		  ApplicationEnterprises applnEnterprises=applicationEnterprisesRepository.findByAccNoAndApplicationFormId(accNo,applicationFormId);
		 try {
		  if(applnEnterprises!=null) {
		   Long applicationEnterpriseId=applnEnterprises.getId();
		   applnUsers=applicationUsersRepository.getPrefNoAndApplicationEnterpriseId(prefNo,applicationEnterpriseId.toString());
		   if(applnUsers!=null) {
			   System.out.println(applnUsers);
			 return applnUsers;
		   }
		}
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		  return applnUsers;
		 
		 
		
	}

	public Users getUsersByPrefNoInAndMarkAsEnabled(List<String> listPrefNo, Integer b) {
		 Users user=null;
		 try {
		 user=usersRespository.findFirstByPrefNoInAndMarkAsEnabled(listPrefNo,1);
		   if(user!=null) {
			  System.out.println(user);
			  System.out.println(user.getId());  
		  }
		 }catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
		return user;
	}

	

}
