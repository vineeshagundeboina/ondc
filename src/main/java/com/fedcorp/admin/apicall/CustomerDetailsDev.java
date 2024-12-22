package com.fedcorp.admin.apicall;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fedcorp.admin.entities.ApplicationUsers;
import com.fedcorp.admin.entities.UserMobileChanges;
import com.fedcorp.admin.entities.Users;
import com.fedcorp.admin.repositories.ApplicationEnterprisesRepository;
import com.fedcorp.admin.repositories.ApplicationFormRepository;
import com.fedcorp.admin.repositories.ApplicationUsersRepository;
import com.fedcorp.admin.repositories.UserMobileChangesRepository;
import com.fedcorp.admin.repositories.UsersRespository;

@Service
public class CustomerDetailsDev {

	@Autowired
	public ApplicationEnterprisesRepository applicationEnterprisesRepository;

	@Autowired
	public ApplicationFormRepository applicationFormRepository;

	@Autowired
	public UsersRespository usersRespository;

	@Autowired
	public ApplicationUsersRepository applicationUsersRepository;

	@Autowired
	public UserMobileChangesRepository userMobileChangesRepository;

	boolean accountStatus, accttype, status = false;
	String strSQL = "", strSQL1 = "", strSQL2 = "", strSQL3 = "", statusdesc = "";
	Object check = "", checkerr = "", checkerrstatus = "", check01 = "";
	JSONObject obj, data, dataa, acctobj1;

	JSONArray data1 = null;
	JSONObject custdetails, recacct;

	public JSONObject existCheckUser(String acctnumber) {
		try {
			data = new JSONObject();

			Long cnt_data = applicationEnterprisesRepository.totalApplicationByAccountNo(acctnumber);
			if (cnt_data > 0) {

				
					APIGateGetCustDetails urlcall = new APIGateGetCustDetails("check");
					JSONObject custdetails = urlcall.getCustomer(acctnumber);

					JSONObject getCustomerDetailsObj = custdetails.getJSONObject("GetCustomerDetailsResp");

					System.out.println("Fedcorp:" + getCustomerDetailsObj.toString());

					if (getCustomerDetailsObj.get("AccountDetails") instanceof JSONArray) {

						JSONArray array1 = new JSONArray();

						array1 = getCustomerDetailsObj.getJSONArray("AccountDetails");

						System.out.println("Fedcorp:" + getCustomerDetailsObj.toString());

						for (int i = 0; i < array1.length(); i++) {

							JSONObject recacct = array1.getJSONObject(i);

							if (recacct.getJSONObject("RELATEDPARTY").get("DETAILS") instanceof JSONArray) {
								JSONArray details = recacct.getJSONObject("RELATEDPARTY").getJSONArray("DETAILS");
								for (int j = 0; j < details.length(); j++) {
									checkerr = recacct.getJSONObject("RELATEDPARTY").getJSONArray("DETAILS")
											.getJSONObject(j).get("ERRORCODE");
									checkerrstatus = recacct.getJSONObject("RELATEDPARTY").getJSONArray("DETAILS")
											.getJSONObject(j).get("ERRORMSG");

								}
							} else {
								checkerr = recacct.getJSONObject("RELATEDPARTY").getJSONObject("DETAILS")
										.get("ERRORCODE");
								checkerrstatus = recacct.getJSONObject("RELATEDPARTY").getJSONObject("DETAILS")
										.get("ERRORMSG");
							}

							System.out.println("jsonarray" + recacct);
							System.out.println("account number check added: " + recacct.get("FORACID"));
							String account = recacct.get("FORACID").toString();
							if (account.equals(acctnumber)) {
								if (!checkerr.equals("00")) {

									data.put("status", recacct.getJSONObject("RELATEDPARTY").getJSONObject("DETAILS")
											.get("ERRORMSG"));
									data.put("statusCode", "01");
									return data;

								}

								else

								{

									if (recacct.has("ERRORCODE")) {
										check = recacct.getString("ERRORCODE");
									} else {
										check = recacct.getString("ERRCODE");
									}

									System.out.println(check + "<><><><><>");

									if (check.equals("00")) {

										System.out.println("JSONARRAY" + recacct);

										try {

											JSONObject main = new JSONObject();

											JSONObject user = new JSONObject();

											JSONObject user1 = new JSONObject();
											user.put("AccountDetails", recacct);
											user1.put("GetCustomerDetailsResp", user);
											main.put("result", user1);
											main.put("statusCode", "00");
											main.put("status", "Success");
											return main;
										} catch (Exception ex) {
											ex.printStackTrace();
											data.put("status", "Something Went Wrong");
											data.put("statusCode", "01");
											return data;
										}
									}

									else {
										data.put("status", recacct.has("ERRMSG") ? recacct.getString("ERRMSG")
												: recacct.getString("ERRORMSG"));
										data.put("statusCode", recacct.has("ERRCODE") ? recacct.getString("ERRCODE")
												: recacct.getString("ERRORCODE"));
										return data;
									}

								}
							}
						}
						return data;
					}

					JSONObject getCustomerDetailsResp = custdetails.getJSONObject("GetCustomerDetailsResp")
							.getJSONObject("AccountDetails");

					System.out.println("Fedcorp:" + getCustomerDetailsResp.toString());

					if (getCustomerDetailsResp.has("ERRORCODE")) {
						check = getCustomerDetailsResp.get("ERRORCODE");
					} else {
						check = getCustomerDetailsResp.get("ERRCODE");
					}

					if (check.equals("00")) {

						data.put("status", "Success");
						data.put("statusCode", "00");
						data.put("result", custdetails);
						return data;
					}

					else {
						data.put("status", getCustomerDetailsResp.has("ERRMSG") ? getCustomerDetailsResp.get("ERRMSG")
								: getCustomerDetailsResp.get("ERRORMSG"));
						data.put("statusCode",
								getCustomerDetailsResp.has("ERRCODE") ? getCustomerDetailsResp.get("ERRCODE")
										: getCustomerDetailsResp.get("ERRORCODE"));
						return data;
					}
				
			} else {
				APIGateGetCustDetails urlcall = new APIGateGetCustDetails("check");
				custdetails = urlcall.getCustomer(acctnumber);
				JSONObject getCustomerDetailsObj = custdetails.getJSONObject("GetCustomerDetailsResp");
				System.out.println("Fedcorp:" + getCustomerDetailsObj.toString());

				if (getCustomerDetailsObj.get("AccountDetails") instanceof JSONArray) {

					JSONArray array1 = new JSONArray();

					array1 = getCustomerDetailsObj.getJSONArray("AccountDetails");

					System.out.println("Fedcorp:" + getCustomerDetailsObj.toString());

					for (int i = 0; i < array1.length(); i++) {

						recacct = array1.getJSONObject(i);

						if (recacct.getJSONObject("RELATEDPARTY").get("DETAILS") instanceof JSONArray) {
							JSONArray details = recacct.getJSONObject("RELATEDPARTY").getJSONArray("DETAILS");
							for (int j = 0; j < details.length(); j++) {
								checkerr = recacct.getJSONObject("RELATEDPARTY").getJSONArray("DETAILS")
										.getJSONObject(j).get("ERRORCODE");
								checkerrstatus = recacct.getJSONObject("RELATEDPARTY").getJSONArray("DETAILS")
										.getJSONObject(j).get("ERRORMSG");
							}
						} else {
							checkerr = recacct.getJSONObject("RELATEDPARTY").getJSONObject("DETAILS").get("ERRORCODE");
							checkerrstatus = recacct.getJSONObject("RELATEDPARTY").getJSONObject("DETAILS")
									.get("ERRORMSG");
						}

						System.out.println("jsonarray" + recacct);
						System.out.println("account number check added: " + recacct.get("FORACID"));
						String account = recacct.get("FORACID").toString();
						if (account.equals(acctnumber)) {

							if (!checkerr.equals("00")) {
								data.put("status",
										recacct.getJSONObject("RELATEDPARTY").getJSONObject("DETAILS").get("ERRORMSG"));
								data.put("statusCode", "01");
								return data;
							}

							else

							{

								if (recacct.has("ERRORCODE")) {
									check = recacct.getString("ERRORCODE");
								} else {
									check = recacct.getString("ERRCODE");
								}

								System.out.println(check + "<><><><><>");

								if (check.equals("00")) {

									System.out.println("JSONARRAY" + recacct);

									try {

										JSONObject main = new JSONObject();

										JSONObject user = new JSONObject();

										JSONObject user1 = new JSONObject();
										user.put("AccountDetails", recacct);
										user1.put("GetCustomerDetailsResp", user);
										main.put("result", user1);
										main.put("statusCode", "00");
										main.put("status", "Success");
										return main;
									} catch (Exception ex) {
										ex.printStackTrace();
										data.put("status", "Something Went Wrong");
										data.put("statusCode", "01");
										return data;

									}
								}

								else {
									data.put("status", recacct.has("ERRMSG") ? recacct.getString("ERRMSG")
											: recacct.getString("ERRORMSG"));
									data.put("statusCode", recacct.has("ERRCODE") ? recacct.getString("ERRCODE")
											: recacct.getString("ERRORCODE"));
									return data;
								}

							}
						}
					}
					return data;
				}

				JSONObject getCustomerDetailsResp = custdetails.getJSONObject("GetCustomerDetailsResp")
						.getJSONObject("AccountDetails");

				System.out.println("Fedcorp:" + getCustomerDetailsResp.toString());

				if (getCustomerDetailsResp.has("ERRORCODE")) {
					check = getCustomerDetailsResp.get("ERRORCODE");
				} else {
					check = getCustomerDetailsResp.get("ERRCODE");
				}

				if (check.equals("00")) {

					data.put("status", "Success");
					data.put("statusCode", "00");
					data.put("result", custdetails);
					return data;
				}

				else {
					data.put("status", getCustomerDetailsResp.has("ERRMSG") ? getCustomerDetailsResp.get("ERRMSG")
							: getCustomerDetailsResp.get("ERRORMSG"));
					data.put("statusCode", getCustomerDetailsResp.has("ERRCODE") ? getCustomerDetailsResp.get("ERRCODE")
							: getCustomerDetailsResp.get("ERRORCODE"));
					return data;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return data;

	}

	public JSONObject checkUser(String acctno) {
		try {
			JSONObject data = new JSONObject();
			Integer cnt_data = applicationEnterprisesRepository.countByActiveAndAccNo(true, acctno);

			if (cnt_data > 0) {
				System.out.println("count data " + cnt_data);
				Integer cnt_data1 = applicationFormRepository
						.totalCommonApplicationFromApplicationFormAndApplicationEnterprises(acctno);
				if (cnt_data1 > 0) {
					status = false;
					statusdesc = "Account Number already taken";
					data.put("status", statusdesc);
					data.put("statusCode", "01");
					return data;
				} else {

					try {

						APIGateGetCustDetails urlcall = new APIGateGetCustDetails("check");
						custdetails = urlcall.getCustomer(acctno);

						JSONObject getCustomerDetailsObj = custdetails.getJSONObject("GetCustomerDetailsResp");

						System.out.println("Fedcorp:" + getCustomerDetailsObj.toString());

						if (getCustomerDetailsObj.get("AccountDetails") instanceof JSONArray) {

							JSONArray array1 = new JSONArray();

							array1 = getCustomerDetailsObj.getJSONArray("AccountDetails");

							System.out.println("Fedcorp:" + getCustomerDetailsObj.toString());

							for (int i = 0; i < array1.length(); i++) {

								recacct = array1.getJSONObject(i);

								if (recacct.getJSONObject("RELATEDPARTY").get("DETAILS") instanceof JSONArray) {

									checkerr = recacct.getJSONObject("RELATEDPARTY").getJSONArray("DETAILS")
											.getJSONObject(0).get("ERRORCODE");
									checkerrstatus = recacct.getJSONObject("RELATEDPARTY").getJSONArray("DETAILS")
											.getJSONObject(0).get("ERRORMSG");

								} else {
									checkerr = recacct.getJSONObject("RELATEDPARTY").getJSONObject("DETAILS")
											.get("ERRORCODE");
									checkerrstatus = recacct.getJSONObject("RELATEDPARTY").getJSONObject("DETAILS")
											.get("ERRORMSG");
								}
								System.out.println("checking account number here: " + recacct);
								String account = recacct.get("FORACID").toString();
								if (account.equals(acctno)) {
									if (!checkerr.equals("00")) {

										data.put("status", checkerrstatus);
										data.put("statusCode", "01");
										return data;

									}

									else

									{

										if (recacct.has("ERRORCODE")) {
											check = recacct.getString("ERRORCODE");
										} else {
											check = recacct.getString("ERRCODE");
										}

										System.out.println(check + "<><><><><>");

										if (check.equals("00")) {

											System.out.println("JSONARRAY" + recacct);

											try {

												JSONObject main = new JSONObject();

												JSONObject user = new JSONObject();

												JSONObject user1 = new JSONObject();
												user.put("AccountDetails", recacct);
												user1.put("GetCustomerDetailsResp", user);
												main.put("result", user1);
												main.put("statusCode", "00");
												main.put("status", "Success");
												return main;
											} catch (Exception ex) {
												ex.printStackTrace();
												data.put("status", "Something Went Wrong");

												data.put("statusCode", "01");
												return data;
											}
										}

										else {
											data.put("status", recacct.has("ERRMSG") ? recacct.getString("ERRMSG")
													: recacct.getString("ERRORMSG"));
											data.put("statusCode", recacct.has("ERRCODE") ? recacct.getString("ERRCODE")
													: recacct.getString("ERRORCODE"));
											return data;
										}

									}
								}
							}
							return data;
						}

						JSONObject getCustomerDetailsResp = custdetails.getJSONObject("GetCustomerDetailsResp")
								.getJSONObject("AccountDetails");

						System.out.println("Fedcorp->" + getCustomerDetailsResp.toString());

						if (getCustomerDetailsResp.getJSONObject("RELATEDPARTY").get("DETAILS") instanceof JSONArray) {
							if (getCustomerDetailsResp.has("ERRORCODE")) {
								check = getCustomerDetailsResp.get("ERRORCODE");
							} else {
								check = getCustomerDetailsResp.get("ERRCODE");
							}

							if (check.equals("00")) {
								data.put("status", "Success");
								data.put("statusCode", "00");
								data.put("result", custdetails);
								return data;
							}

							else {
								data.put("status",
										getCustomerDetailsResp.has("ERRMSG") ? getCustomerDetailsResp.get("ERRMSG")
												: getCustomerDetailsResp.get("ERRORMSG"));
								data.put("statusCode",
										getCustomerDetailsResp.has("ERRCODE") ? getCustomerDetailsResp.get("ERRCODE")
												: getCustomerDetailsResp.get("ERRORCODE"));
								return data;
							}
						} else {
							checkerr = getCustomerDetailsResp.getJSONObject("RELATEDPARTY").getJSONObject("DETAILS")
									.get("ERRORCODE");

							if (getCustomerDetailsResp.has("ERRORCODE")) {
								check = getCustomerDetailsResp.get("ERRORCODE");
							} else {
								check = getCustomerDetailsResp.get("ERRCODE");
							}

							if (check.equals("00")) {

								if (!checkerr.equals("00")) {
									data.put("status", getCustomerDetailsResp.getJSONObject("RELATEDPARTY")
											.getJSONObject("DETAILS").get("ERRORMSG"));
									data.put("statusCode", "01");
									return data;

								}

								data.put("status", "Success");
								data.put("statusCode", "00");
								data.put("result", custdetails);
								return data;
							}

							else {
								data.put("status",
										getCustomerDetailsResp.has("ERRMSG") ? getCustomerDetailsResp.get("ERRMSG")
												: getCustomerDetailsResp.get("ERRORMSG"));
								data.put("statusCode",
										getCustomerDetailsResp.has("ERRCODE") ? getCustomerDetailsResp.get("ERRCODE")
												: getCustomerDetailsResp.get("ERRORCODE"));
								return data;
							}

						}
					} catch (Exception e) {
						e.printStackTrace();
						data.put("status", "Something Went Wrong, Please try again later");
						data.put("statusCode", "01");
						return data;
					}

				}
			} else {
				System.out.println("count data is lass than 0");
				Integer cnt_data1 = applicationFormRepository
						.totalCommonApplicationFromApplicationFormAndApplicationEnterprises(acctno);
				System.out.println("application count : " + cnt_data);
				if (cnt_data1 > 0) {
					status = false;
					statusdesc = "Account Number already taken";
					data.put("status", statusdesc);
					data.put("statusCode", "01");
					return data;

				} else {
					System.out.println("count data is less than " + cnt_data1);

					APIGateGetCustDetails urlcall = new APIGateGetCustDetails("check");
					custdetails = urlcall.getCustomer(acctno);

					JSONObject getCustomerDetailsObj = custdetails.getJSONObject("GetCustomerDetailsResp");

					System.out.println("Fedcorp:" + getCustomerDetailsObj.toString());

					if (getCustomerDetailsObj.get("AccountDetails") instanceof JSONArray) {

						JSONArray array1 = new JSONArray();

						array1 = getCustomerDetailsObj.getJSONArray("AccountDetails");

						System.out.println("Fedcorp:" + getCustomerDetailsObj.toString());

						for (int i = 0; i < array1.length(); i++) {

							recacct = array1.getJSONObject(i);

							if (recacct.getJSONObject("RELATEDPARTY").get("DETAILS") instanceof JSONArray) {
								JSONArray details = recacct.getJSONObject("RELATEDPARTY").getJSONArray("DETAILS");
								for (int j = 0; j < details.length(); j++) {
									checkerr = recacct.getJSONObject("RELATEDPARTY").getJSONArray("DETAILS")
											.getJSONObject(j).get("ERRORCODE");
									checkerrstatus = recacct.getJSONObject("RELATEDPARTY").getJSONArray("DETAILS")
											.getJSONObject(j).get("ERRORMSG");
								}
							} else {
								checkerr = recacct.getJSONObject("RELATEDPARTY").getJSONObject("DETAILS")
										.get("ERRORCODE");
								checkerrstatus = recacct.getJSONObject("RELATEDPARTY").getJSONObject("DETAILS")
										.get("ERRORMSG");
							}

							System.out.println("jsonarray" + recacct);
							System.out.println("account number check added: " + recacct.get("FORACID"));
							String account = recacct.get("FORACID").toString();
							if (account.equals(acctno)) {
								if (!checkerr.equals("00")) {
									data.put("status", checkerrstatus);
									data.put("statusCode", "01");
									return data;

								}

								else

								{

									if (recacct.has("ERRORCODE")) {
										check = recacct.getString("ERRORCODE");
									} else {
										check = recacct.getString("ERRCODE");
									}

									System.out.println(check + "<><><><><>");

									if (check.equals("00")) {

										System.out.println("JSONARRAY" + recacct);

										try {

											JSONObject main = new JSONObject();

											JSONObject user = new JSONObject();

											JSONObject user1 = new JSONObject();
											user.put("AccountDetails", recacct);
											user1.put("GetCustomerDetailsResp", user);
											main.put("result", user1);
											main.put("statusCode", "00");
											main.put("status", "Success");
											return main;
										} catch (Exception ex) {
											ex.printStackTrace();
											data.put("status", "Something Went Wrong");
											data.put("statusCode", "01");
											return data;

										}
									}

									else {
										data.put("status", recacct.has("ERRMSG") ? recacct.getString("ERRMSG")
												: recacct.getString("ERRORMSG"));
										data.put("statusCode", recacct.has("ERRCODE") ? recacct.getString("ERRCODE")
												: recacct.getString("ERRORCODE"));
										return data;
									}

								}
							}
						}
						return data;
					}

					JSONObject getCustomerDetailsResp = custdetails.getJSONObject("GetCustomerDetailsResp")
							.getJSONObject("AccountDetails");

					System.out.println("Fedcorp:" + getCustomerDetailsResp.toString());

					if (getCustomerDetailsResp.getJSONObject("RELATEDPARTY").get("DETAILS") instanceof JSONArray) {
						if (getCustomerDetailsResp.has("ERRORCODE")) {
							check = getCustomerDetailsResp.get("ERRORCODE");
						} else {
							check = getCustomerDetailsResp.get("ERRCODE");
						}

						if (check.equals("00")) {
							data.put("status", "Success");
							data.put("statusCode", "00");
							data.put("result", custdetails);
							return data;
						} else {
							data.put("status",
									getCustomerDetailsResp.has("ERRMSG") ? getCustomerDetailsResp.get("ERRMSG")
											: getCustomerDetailsResp.get("ERRORMSG"));
							data.put("statusCode",
									getCustomerDetailsResp.has("ERRCODE") ? getCustomerDetailsResp.get("ERRCODE")
											: getCustomerDetailsResp.get("ERRORCODE"));
							return data;
						}

					}

					else {

						checkerr = getCustomerDetailsResp.getJSONObject("RELATEDPARTY").getJSONObject("DETAILS")
								.get("ERRORCODE");

						if (getCustomerDetailsResp.has("ERRORCODE")) {
							check = getCustomerDetailsResp.get("ERRORCODE");
						} else {
							check = getCustomerDetailsResp.get("ERRCODE");
						}

						if (getCustomerDetailsResp.has("ERRORCODE")) {
							check01 = getCustomerDetailsResp.get("ERRORMSG");
						} else {
							check01 = getCustomerDetailsResp.has("ERRMSG") ? getCustomerDetailsResp.get("ERRMSG")
									: getCustomerDetailsResp.get("ERRORMSG");
						}

						if (check.equals("00")) {

							if (!checkerr.equals("00")) {
								data.put("status", getCustomerDetailsResp.getJSONObject("RELATEDPARTY")
										.getJSONObject("DETAILS").get("ERRORMSG"));
								data.put("statusCode", "01");
								return data;
							}
							data.put("status", "Success");
							data.put("statusCode", "00");
							data.put("result", custdetails);
							return data;
						}

						else {
							data.put("status", check01);
							data.put("statusCode", check);
							return data;
						}

					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public JSONObject checkMobile(String data, String acctnumber) {

		System.out.println("Mobile validation started here");

		List<String> mobile = new ArrayList<String>();
		JSONObject mobileD = null;
		try {

			JSONObject mob = new JSONObject(data);
			if (mob.getJSONObject("result").getJSONObject("GetCustomerDetailsResp") .get("AccountDetails") instanceof JSONArray) {
				JSONArray accounts = mob.getJSONObject("result").getJSONObject("GetCustomerDetailsResp") .getJSONArray("AccountDetails");
				for (int i = 0; i < accounts.length(); i++) {

					if (accounts.getJSONObject(0).getJSONObject("RELATEDPARTY").get("DETAILS") instanceof JSONArray) {
						JSONArray details = accounts.getJSONObject(i).getJSONObject("RELATEDPARTY") .getJSONArray("DETAILS");
						for (int j = 0; j < details.length(); j++) {
							mobile.add(String.valueOf(accounts.getJSONObject(i).getJSONObject("RELATEDPARTY") .getJSONArray("DETAILS").getJSONObject(j).getLong("CONTACT_NO")));
//			exist=validateMobileNumber(mobile);
						}
					} else {
						mobile.add(String.valueOf(accounts.getJSONObject(i).getJSONObject("RELATEDPARTY") .getJSONObject("DETAILS").getLong("CONTACT_NO")));
					}
				}
			} else {
				if (mob.getJSONObject("result").getJSONObject("GetCustomerDetailsResp").getJSONObject("AccountDetails") .getJSONObject("RELATEDPARTY").get("DETAILS") instanceof JSONArray) {
					JSONArray details = mob.getJSONObject("result").getJSONObject("GetCustomerDetailsResp") .getJSONObject("AccountDetails").getJSONObject("RELATEDPARTY").getJSONArray("DETAILS");
					for (int k = 0; k < details.length(); k++) {
						mobile.add(String.valueOf(mob.getJSONObject("result").getJSONObject("GetCustomerDetailsResp") .getJSONObject("AccountDetails").getJSONObject("RELATEDPARTY").getJSONArray("DETAILS") .getJSONObject(k).getLong("CONTACT_NO")));
					}
				} else {
					mobile.add(String.valueOf(mob.getJSONObject("result").getJSONObject("GetCustomerDetailsResp") .getJSONObject("AccountDetails").getJSONObject("RELATEDPARTY").getJSONObject("DETAILS") .getLong("CONTACT_NO")));
				}
			}
			System.out.println("Mobile numbers from external url: " + mobile.toString());

			mobileD = validateMobileNumber(mobile, acctnumber);
		} catch (Exception e) {
			System.out.println("exception occured while validating mobile numbers ");
			e.printStackTrace();
		}
		try {
			System.out.println("Mobile numbers validation completed: mobile exist? " + mobileD.getBoolean("status"));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return mobileD;

	}

	public JSONObject validateMobileNumber(List<String> mobile, String account)
			throws ClassNotFoundException, JSONException {

		JSONObject json = new JSONObject();
		json.put("status", false);
		String mobiles = "";
		List<String> mob = usersRespository.getUserMobile(account);
		for (int i = 0; i < mob.size(); i++) {
			String mob1 = mob.get(i);
			int indes = mobile.indexOf(mob1);
			if (indes >= 0) {
				mobile.remove(mobile.indexOf(mob1));
			}
		}

		for (String action : mobile) {
			mobiles = StringUtils.hasLength(mobiles) ? mobiles + "'" + action + "'" : mobiles + "," + "'" + action + "'";
		}
		;
		if (mobile.size() > 0) {
			Users user = usersRespository.getUser(mobile);
			if (user != null) {

				String mobileNum = user.getMobile();
				json = new JSONObject();
				json.put("status", true);
				json.put("mobile", mobileNum);
				System.out.println("this number exist in users table: " + mobileNum);
			}

		}

		return json;
	}

	public Integer prfcorpValidation(String prefCorpNumber) {

		String upper = prefCorpNumber.toUpperCase();
		Integer count = 0;
		String lower = prefCorpNumber.toLowerCase();
		Boolean active = true;
		List<String> prefCorp = new ArrayList<String>();
		prefCorp.add(upper);
		prefCorp.add(lower);
		try {
			count = applicationEnterprisesRepository.countByPrefCorpInAndActive(prefCorp, active);
			System.out.println("this prefCorpNumber exist in users table?: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	public JSONObject mobileUpdate(String mobile, String custNo, String account) throws JSONException {
		JSONObject resp = null;
		System.out.println("getcust calling to check mobile is motching " + custNo + " " + mobile);

		APIGateGetCustDetails urlcall = new APIGateGetCustDetails("check");
		custdetails = urlcall.getCustomer(account);
		try {
			resp = new JSONObject();
			JSONObject GetCustomerDetailsObj = custdetails.getJSONObject("GetCustomerDetailsResp");

			System.out.println("Fedcorp:" + GetCustomerDetailsObj.toString());

			if (GetCustomerDetailsObj.get("AccountDetails") instanceof JSONArray) {
				JSONArray array1 = GetCustomerDetailsObj.getJSONArray("AccountDetails");
				for (int i = 0; i < array1.length(); i++) {
					recacct = array1.getJSONObject(i);
					if (recacct.getJSONObject("RELATEDPARTY").get("DETAILS") instanceof JSONArray) {
						JSONArray details = recacct.getJSONObject("RELATEDPARTY").getJSONArray("DETAILS");
						for (int j = 0; j < details.length(); j++) {
							String customerId = details.getJSONObject(j).get("CUSTOMER_ID").toString();
							String custMobile = details.getJSONObject(j).get("CONTACT_NO").toString();
							if (customerId.equals(custNo)) {
								if (!custMobile.equals(mobile)) {
									resp.put("status", true);
									resp.put("oldMobile", mobile);
									resp.put("getCustMobile", custMobile);
									resp.put("message",
											"This is the new Mobile " + custMobile + ",Do you want to update?");
								} else {
									resp.put("status", false);
									resp.put("message", "Mobile number is already upto date");
								}
							} else {
								resp.put("status", false);
								resp.put("message", "CustomerId not matching");
							}
						}
					} else {
						String customerId = recacct.getJSONObject("RELATEDPARTY").getJSONObject("DETAILS") .get("CUSTOMER_ID").toString();
						String custMobile = recacct.getJSONObject("RELATEDPARTY").getJSONObject("DETAILS") .get("CONTACT_NO").toString();
						if (customerId.equals(custNo)) {
							if (!custMobile.equals(mobile)) {
								resp.put("status", true);
								resp.put("oldMobile", mobile);
								resp.put("getCustMobile", custMobile);
								resp.put("message", "This is the new Mobile " + custMobile + ",Do you want to update?");
							} else {
								resp.put("status", false);
								resp.put("message", "Mobile number is already upto date");
							}
						} else {
							resp.put("status", false);
							resp.put("message", "CustomerId not matching");
						}

					}
				}
			} else {
				if (GetCustomerDetailsObj.getJSONObject("AccountDetails").getJSONObject("RELATEDPARTY") .get("DETAILS") instanceof JSONArray) {
					JSONArray details = GetCustomerDetailsObj.getJSONObject("AccountDetails") .getJSONObject("RELATEDPARTY").getJSONArray("DETAILS");
					for (int j = 0; j < details.length(); j++) {
						String customerId = details.getJSONObject(j).get("CUSTOMER_ID").toString();
						String custMobile = details.getJSONObject(j).get("CONTACT_NO").toString();
						if (customerId.equals(custNo)) {
							if (!custMobile.equals(mobile)) {
								resp.put("status", true);
								resp.put("oldMobile", mobile);
								resp.put("getCustMobile", custMobile);
								resp.put("message", "This is the new Mobile " + custMobile + ",Do you want to update?");
							} else {
								resp.put("status", false);
								resp.put("message", "Mobile number is already upto date");
							}
						} else {
							resp.put("status", false);
							resp.put("message", "CustomerId not matching");
						}
					}
				} else {
					String customerId = GetCustomerDetailsObj.getJSONObject("AccountDetails") .getJSONObject("RELATEDPARTY").getJSONObject("DETAILS").get("CUSTOMER_ID").toString();
					String custMobile = GetCustomerDetailsObj.getJSONObject("AccountDetails") .getJSONObject("RELATEDPARTY").getJSONObject("DETAILS").get("CONTACT_NO").toString();
					if (customerId.equals(custNo)) {
						if (!custMobile.equals(mobile)) {
							resp.put("status", true);
							resp.put("oldMobile", mobile);
							resp.put("getCustMobile", custMobile);
							resp.put("message", "This is the new Mobile " + custMobile + ",Do you want to update?");
						} else {
							resp.put("status", false);
							resp.put("message", "Mobile number is already upto date");
						}
					} else {
						resp.put("status", false);
						resp.put("message", "CustomerId not matching");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp = new JSONObject();
			resp.put("status", false);
			resp.put("message", "Somethinng went wrong while calling getcustdetails");
		}
		System.out.println("response of mobile update getcustdetails" + resp.toString());
		return resp;
	}

	public JSONObject updateMobileNumber(String oldMobile, String newMobile, String cust, String username)
			throws JSONException {
		System.out.println("mobile number updation started " + oldMobile + " new mobile " + newMobile);

		int i = 0;
		JSONObject resp = new JSONObject();

		try {
			UserMobileChanges userMobileChanges = new UserMobileChanges();
			userMobileChanges.setCustomerNo(cust);
			userMobileChanges.setOldMobileNo(oldMobile);
			userMobileChanges.setNewMobileNo(newMobile);
			userMobileChanges.setUpdatedBy(username);
			userMobileChanges.setUpdatedAt(new java.util.Date());
			userMobileChanges.setCreatedAt(new java.util.Date());
			UserMobileChanges newuserMobileChanges = userMobileChangesRepository.save(userMobileChanges);
			if (newuserMobileChanges != null) {
				ApplicationUsers appUser = applicationUsersRepository.findByMobileAndCustNoAndActive(oldMobile, cust, true);
				appUser.setMobile(newMobile);
				applicationUsersRepository.save(appUser);
				Users user = usersRespository.findByMobileAndMarkAsEnabled(oldMobile, 1);
				user.setMobile(newMobile);
				usersRespository.save(user);
				resp.put("status", true);
				resp.put("message", "Mobile updated successfully");
			} else {
				resp.put("status", false);
				resp.put("message", "Not able to update mobile number");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.put("status", false);
			resp.put("message", "Not able to update mobile number");
		}
		System.out.println("mobile number updation completed" + resp.toString());
		return resp;
	}

}
