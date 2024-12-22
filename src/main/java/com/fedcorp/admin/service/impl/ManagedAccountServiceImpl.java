package com.fedcorp.admin.service.impl;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedcorp.admin.apicall.SMSSendAPI;
import com.fedcorp.admin.entities.ManagedAccounts;
import com.fedcorp.admin.entities.UserPins;
import com.fedcorp.admin.entities.UserTokens;
import com.fedcorp.admin.entities.Users;
import com.fedcorp.admin.repositories.ManagedAccountsRepository;
import com.fedcorp.admin.repositories.UserPinsRepository;
import com.fedcorp.admin.repositories.UserTokensRepository;
import com.fedcorp.admin.repositories.UsersRespository;

@Service
public class ManagedAccountServiceImpl {
	
	@Autowired
	private ManagedAccountsRepository managedAccountsRepository;
	
	
	@Autowired
	private UserPinsRepository userPinsRepository;
	
	@Autowired
	private UsersRespository usersRepository;
	
	@Autowired
	private UserTokensRepository userTokensRepository;
	
	
	public 	ManagedAccounts getAccounts(Long userId) {
		return managedAccountsRepository.findByUserId(userId);
	}

	public ManagedAccounts saveManageAccount(Long userId,String selectedacctId) {
		ManagedAccounts managedAccounts=new ManagedAccounts();
		managedAccounts.setAccounts(selectedacctId);
		managedAccounts.setUpdatedAt(new java.util.Date());
		managedAccounts.setCreatedAt(new java.util.Date());
		managedAccounts.setUserId(userId);
		return  managedAccountsRepository.save(managedAccounts);
		
	}

	public ManagedAccounts updateManageAccount(String account,Long userId) {
		ManagedAccounts managedAccounts=managedAccountsRepository.findByUserId(userId);
		managedAccounts.setAccounts(account);
		managedAccounts.setUpdatedAt(new java.util.Date());
		return managedAccountsRepository.save(managedAccounts);
		
	}

	public long generateToken(Long userid, String mobile) {
		long returnkeyid = 0;

		try {
			
			String token=randomString(8);
			Date dt = new Date();
			Calendar c = Calendar.getInstance(); 
			c.setTime(dt); 
			c.add(Calendar.DATE, 1);
			dt = c.getTime();
			UserTokens userTokens=new UserTokens();
			userTokens.setToken(token);
			userTokens.setUserId(userid);
			userTokens.setCreatedAt(new java.util.Date());
			userTokens.setUpdatedAt(new java.util.Date());
			userTokens.setExpiredAt(dt);
			userTokens.setActive(true);
			userTokens.setType("RegistrationToken");
			UserTokens newuserTokens =userTokensRepository.save(userTokens);
			System.out.println("Success");

			if (newuserTokens !=null) {
				
				SMSSendAPI apisms=new SMSSendAPI("");
				
				apisms.sendingSMSAPI(mobile, "Dear Customer, your application for Corporate FedMobile (FedCorp) has been processed and the activation token is "+ token +". Please do not share this token with anyone including Bank officials- Federal Bank");
			
				returnkeyid = newuserTokens.getId();
				

				System.out.println("generateToken Success");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnkeyid;

	}

	public long forgotPwd(Long userid, String mobile) {
		

		long returnkeyid = 0;
		try {

			String token=randomString(6);
			
			Calendar cal=GregorianCalendar.getInstance(TimeZone.getTimeZone(ZoneId.of("UTC")));
			cal.add(Calendar.HOUR, -5);
			cal.add(Calendar.MINUTE, -30);
			Timestamp now=Timestamp.from(cal.toInstant());
			cal.add(Calendar.MINUTE, 10);
			Timestamp time=Timestamp.from(cal.toInstant());


		
			UserPins userPins=new UserPins();
			userPins.setPin(token);
			userPins.setUserId(userid);
			userPins.setCreatedAt(now);
			userPins.setUpdatedAt(now);
			userPins.setExpiredAt(time);
			userPins.setType("ForgotPin");
			userPins.setActive(true);
			UserPins newuserPins =userPinsRepository.save(userPins);
			System.out.println("Success");


			if (newuserPins !=null) {
				
                SMSSendAPI apisms=new SMSSendAPI("");
				
				apisms.sendingSMSAPI(mobile, "Dear Customer, your MPIN reset token for Corporate FedMobile (FedCorp) is "+ token +". Please do not share this token with anyone including Bank officials. If the request was not initiated by you, please call 1800-425-1199 immediately-Federal Bank");

				
					returnkeyid = newuserPins.getId();
				

				System.out.println("forgotPwd Success");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnkeyid;

	}

	public long unblockUser(Long userid, String mobile) {
		long returnkeyid = 0;
		try {			
			Users users=usersRepository.findById(userid).get();
			users.setMpinCheckStatus("active");
			users.setWrongMpinCount("0");
			users.setUpdatedAt(new java.util.Date());
			Users updateUsers=	usersRepository.save(users);
			System.out.println("Success");
			if (updateUsers!=null) {				
				returnkeyid=updateUsers.getId();
				 SMSSendAPI apisms=new SMSSendAPI("");
 				 apisms.sendingSMSAPI(mobile, "Dear Customer, Based on your request we have enabled access to FedCorp mobile application. Please login with existing MPIN. To reset, use 'Forgot MPIN' option- Federal Bank");
 				System.out.println("sms sent successfully for unblocking mobile app "+mobile); 
				System.out.println("unblockUser Success");
			}
		
		} catch (Exception e) {

			e.printStackTrace();
		}

		return returnkeyid;

	}

	public long unblockWebUser(Long userid, String mobile) {
		long returnkeyid=0l;
		try{
		Users users=usersRepository.findById(userid).get();
		users.setWrongWebPasswordCount("0");
		users.setWebCheckStatus("active");
		Users updateUsers=	usersRepository.save(users);
		System.out.println("Success");

		if (updateUsers !=null) {	
			returnkeyid = updateUsers.getId();
			
			 SMSSendAPI apisms=new SMSSendAPI("");
			 apisms.sendingSMSAPI(mobile, "Dear Customer, Based on your request we have enabled access to FedCorp web application. Please login with existing credentials. To reset the password, use \"Forgot Password\" option - Federal Bank");
			System.out.println("sms sent successfully for unblocking mobile app "+mobile); 
			System.out.println("unblockd web User Successfully having user id: "+userid);
		}
	
		}catch(Exception e){
			System.out.println("not able to unblockd web User : "+userid);
			System.out.println("exception for user id "+Arrays.toString(e.getStackTrace()));
			e.printStackTrace();
			returnkeyid=0l;
		}
		return  returnkeyid;
		
	}
	
	
	
	static final String AB = "0123456789abcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	String randomString(int len){
	   StringBuilder sb = new StringBuilder(len);
	   for(int i = 0; i < len; i++)
	      sb.append(AB.charAt(rnd.nextInt(AB.length())));
	   return sb.toString();
	}
	
	

}
