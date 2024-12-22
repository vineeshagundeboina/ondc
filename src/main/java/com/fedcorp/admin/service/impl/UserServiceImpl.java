package com.fedcorp.admin.service.impl;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedcorp.admin.apicall.SMSSendAPI;
import com.fedcorp.admin.entities.ApplicationUsers;
import com.fedcorp.admin.entities.UserTokens;
import com.fedcorp.admin.entities.Users;
import com.fedcorp.admin.repositories.ApplicationUsersRepository;
import com.fedcorp.admin.repositories.UserTokensRepository;
import com.fedcorp.admin.repositories.UsersRespository;

@Service
public class UserServiceImpl {

	private static final org.apache.log4j.Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private ApplicationUsersRepository applicationUsersRepository;

	@Autowired
	private UsersRespository usersRespository;

	@Autowired
	public ApplicationUserServiceImpl applicationUserServiceImpl;

	@Autowired
	private UserTokensRepository userTokensRepository;

	public long users_register(String enterprid, String entuserid) {
		System.out.println("started updatedtion for existing enterprise applnenterprise ID>>>" + enterprid + "<<<enterprise id>>>" + entuserid);

		long returnkeyid = 0;
		Date expiredt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(expiredt);
		c.add(Calendar.DATE, 1);
		expiredt = c.getTime();
		try {
			System.out.println("appln enterprise ID>>>" + enterprid + "<<<entuserid>>>" + entuserid);
			Date date = new Date();
			List<ApplicationUsers> applicationUsers = applicationUsersRepository .findByApplicationEnterpriseId(enterprid);
			System.out.println("executed query  with appln enterise id" + enterprid);
			if (applicationUsers != null && !applicationUsers.isEmpty()) {
				for (ApplicationUsers applicationUser : applicationUsers) {
					Users insertUser = null;
					System.out.println("checking whether user exist for this enterprise id and customer number" + entuserid + " customer no " + applicationUser.getCustNo());
					long usertablecheck = checkUsertable(entuserid, applicationUser.getCustNo());
					String mobile = applicationUser.getMobile();
					if (usertablecheck == 0) {
						String pwdtoken = randomString(10);
						MessageDigest md = MessageDigest.getInstance("SHA-256");
						byte[] buffer = pwdtoken.getBytes("UTF-8");
						md.update(buffer);
						byte[] digest = md.digest();
						StringBuilder sb = new StringBuilder();
						for (int i = 0; i < digest.length; i++) {
							sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
						}
						String viewHash = sb.toString();
						
						Users user = new Users();
						user.setUserName(applicationUser.getUserName());
						user.setEnterprisesId(entuserid);
						user.setPrefNo(applicationUser.getPrefNo());
						user.setCustNo(applicationUser.getCustNo());
						user.setMobile(applicationUser.getMobile());
						user.setCreatedAt(date);
						user.setUpdatedAt(date);
						user.setPasswordChangedAt(date);
						user.setMarkAsEnabled(1);
						user.setWrongActivationTokenCount("0");
						user.setWebSignInCount(0l);
						user.setSignInCount(0l);	
						user.setAuthorizedSignatory(applicationUser.getAuthorizedSignatory() ? 1 : 0);
						user.setActivationStatus("pending_activation");
						
						user.setViewHash(viewHash);	
						System.out.println("-------------------------users: "+user);
						insertUser = usersRespository.save(user);
						System.out.println("hash value---------------------------------");
						System.out.println(viewHash);
						System.out.println("---------------------------------");
						System.out.println("inserted new record in users with prefno " + applicationUser.getPrefNo() + " mobile " + applicationUser.getMobile() + " password " + pwdtoken);
					} else {
						Users user = usersRespository.findById(usertablecheck).get();
						user.setAuthorizedSignatory(applicationUser.getAuthorizedSignatory() ? 1 : 0);
						user.setActivationStatus("pending_activation");
						user.setMarkAsEnabled(1);
						user.setUpdatedAt(date);
						usersRespository.save(user);
						System.out.println("Update users with id " + usertablecheck);

					}
					System.out.println("INSERTUSER>>>" + insertUser);

					System.out.println("After Calling User check Table user id>>>" + usertablecheck);

					if (insertUser != null) {
						String token = randomString(8);
						returnkeyid = insertUser.getId();
						System.out.println( "generating users_register_token for existing users " + token + " id " + returnkeyid);
						UserTokens userTokens = new UserTokens();
						userTokens.setToken(token);
						userTokens.setUserId(returnkeyid);
						userTokens.setType("RegistrationToken");
						userTokens.setExpiredAt(expiredt);
						userTokens.setCreatedAt(date);
						userTokens.setUpdatedAt(date);
						userTokens.setActive(true);
						UserTokens insertUserToken = userTokensRepository.save(userTokens);
						if (insertUserToken != null) {
							SMSSendAPI apisms = new SMSSendAPI("");
							apisms.sendingSMSAPI(mobile, "Dear Customer, your application for Corporate FedMobile (FedCorp) has been processed and the activation token is "
											+ token + ". Please do not share this token with anyone including Bank officials- Federal Bank");
							System.out.println("sms sent successfully for new registration for " + mobile);

							System.out.println("users_register_token Success");
						}

						

					} else {
						String token = randomString(8);

						returnkeyid = usertablecheck;

						System.out.println("generating user token User Update Table>>>" + returnkeyid);

						UserTokens userTokens = new UserTokens();
						userTokens.setToken(token);
						userTokens.setUserId(returnkeyid);
						userTokens.setType("RegistrationToken");
						userTokens.setExpiredAt(expiredt);
						userTokens.setCreatedAt(date);
						userTokens.setUpdatedAt(date);
						userTokens.setActive(true);
						UserTokens updateUsertoken = userTokensRepository.save(userTokens);
						if (updateUsertoken != null) {
							SMSSendAPI apisms = new SMSSendAPI("");
							apisms.sendingSMSAPI(mobile,
									"Dear Customer, your application for Corporate FedMobile (FedCorp) has been processed and the activation token is "
											+ token + ". Please do not share this token with anyone including Bank officials- Federal Bank");
							System.out.println("sms sent successfully for new registration for " + mobile);
							System.out.println("users_register_token Success");
						}
						

					}

				}
			}

		}catch (Exception e) {
			returnkeyid=0;
			e.printStackTrace();
		}

		return returnkeyid;
	}

	private String randomString(int numchars) {
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		while (sb.length() < numchars)
			sb.append(Integer.toHexString(r.nextInt()));
		return sb.toString().substring(0, numchars);

	}

	public long checkUsertable(String ent_applicationid, String User_cust_Id){
		System.out.println(" checking users with enterp id " + ent_applicationid + " cust id " + User_cust_Id);
		long getUserCont = 0;

		try {
			Users users = usersRespository.findByCustNoAndEnterprisesId(User_cust_Id, ent_applicationid);
			if (users != null) {
				getUserCont = users.getId();
				System.out.println(" existing users id " + getUserCont);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" final user exist or not users id " + getUserCont);
		return getUserCont;

	}

}
