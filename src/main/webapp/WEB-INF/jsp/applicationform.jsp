<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FedmobileSmeAdminWeb</title>
<meta name="csrf-param" content="authenticity_token">
<meta name="csrf-token"
	content="JJLPOKgrfKd8H9Szu9kE4pX7OHAirbJosCri+ZcTDn4DYY1PkWiH3slPZ3xy3JuxIXRz99l138zv2GtL1gJ0mw==">
<link href="./resources/assets/stylesheets/main.css" rel="stylesheet"
	media="all">
<script src="./resources/assets/javascripts/custom.js"></script>
<link href="./resources/assets/stylesheets/font-awesome.min.css"
	rel="stylesheet">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
</head>
<body class="bg-light">
	<c:if test="${empty sessionScope.logindetails.userSession}">
		<c:redirect url="login" />
	</c:if>
	<%@ include file="header.jsp"%>

	<div class="container-fluid">
		<marquee behavior="scroll" direction="left">
			<font color="red"> <b>To Generate Activation Token, Go to
					Approved list -&gt; Click on View -&gt; Manage Accounts -&gt;
					Generate Activation Token (Valid for 3 hours only).</b>
			</font>
		</marquee>
		<div class="row">

			<%@ include file="slider.jsp"%>


			<main role="main" class="col-md-9 col-sm-9 col-xs-12">
				<div class="modal" id="alert-box" tabindex="-1" role="dialog">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header text-white">
								<h5 class="modal-title">
									<i class="fa" aria-hidden="true"></i> &nbsp;Alert
								</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">x</span>
								</button>
							</div>
							<div class="modal-body">
								<p class="modal-data"></p>
							</div>

						</div>
					</div>
				</div>

				
				<div class="">
					<div class="content-application-form">
						<div class="validate-fields">
							<form id="needs-validation" class="new_application_form"
								enctype="multipart/form-data" action="registernewapp"
								accept-charset="UTF-8" method="post" novalidate="novalidate">
								<input name="utf8" type="hidden" value=""> <input
									type="hidden" name="authenticity_token"
									value="MJ1/dOTkse06FKvZcA2N8W4mkFmhjxcxS4yej9lZoutzUYTFZxmeAtxfqkdPe7zRGSWTs4wuQYzFNC3Nw/IbNQ==">

								<div class="card text-white bg-fed mb-3">
									<div class="card-header font-weight-bold required">Enterprise</div>
									<div class="card-body bg-white text-dark enterprise_form">
										<div class="form-group row">
											<label
												class="col-sm-3 col-form-label font-weight-bold required"
												for="application_form_application_enterprise_attributes_acc_no">Primary
												Account No</label>
											<div class="col-md-6">
												<input class="form-control input-lg required readonly"
													data-inputmask="&#39;mask&#39;: &#39;99999999999999&#39;"
													data-inputmask-placeholder="" required="required"
													placeholder="Primary Account No." type="text" name="accNo"
													id="application_form_application_enterprise_attributes_acc_no">
												<div class="invalid-feedback"></div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-sm-3"></div>
											<div class="col-md-2">
												<a href="" onclick="return onclickFunction()"
													data-remote="true" class="btn btn-primary load_details1">Load
													Details</a>
											</div>
											<div class="col-md-2">
												<a href="#" data-remote="false"
													class="btn btn-secondary clear_fields">Reset</a>
											</div>
										</div>
										<div class="form-group row">
											<label
												class="col-sm-3 col-form-label font-weight-bold required"
												for="application_form_application_enterprise_attributes_acc_name">Account
												Name</label>
											<div class="col-md-6">
												<input class="form-control input-lg readonly"
													pattern="^[A-Za-z0-9-._ &#39;&amp;]+$" required="required"
													readonly="readonly" placeholder="Name"
													title="Name can only contain alphanumeric characters and Special characters(.-_)"
													type="text" name="accName"
													id="application_form_application_enterprise_attributes_acc_name">
												<div class="invalid-feedback"></div>
											</div>
										</div>

										<div class="form-group row">
											<label
												class="col-sm-3 col-form-label font-weight-bold required"
												for="application_form_application_enterprise_attributes_cust_no">Customer
												ID</label>
											<div class="col-md-6">
												<input class="form-control input-lg readonly"
													required="required" readonly="readonly"
													placeholder="Customer ID" type="text" name="custNo"
													id="application_form_application_enterprise_attributes_cust_no">
												<div class="invalid-feedback"></div>
											</div>
										</div>

										<div class="form-group row">
											<label
												class="col-sm-3 col-form-label font-weight-bold required"
												for="application_form_application_enterprise_attributes_branch">Branch
												Code</label>
											<div class="col-md-6">
												<input class="form-control input-lg readonly"
													required="required" readonly="readonly"
													placeholder="Branch Code" type="text" name="branchCode"
													id="application_form_application_enterprise_attributes_branch">
												<input type="hidden" class="form-control input-lg readonly"
													required="required" readonly="readonly"
													placeholder="Branch Code" type="text" name="solId"
													id="application_form_application_enterprise_attributes_solid">

												<div class="invalid-feedback"></div>
											</div>
										</div>

										<div class="form-group row">
											<label
												class="col-sm-3 col-form-label font-weight-bold required"
												for="application_form_application_enterprise_attributes_address">Address</label>
											<div class="col-md-6">
												<textarea class="form-control readonly" rows="3"
													required="required" readonly="readonly"
													placeholder="Address" name="address"
													id="application_form_application_enterprise_attributes_address"></textarea>
												<div class="invalid-feedback"></div>
											</div>
										</div>

										<div class="form-group row">
											<label
												class="col-sm-3 col-form-label font-weight-bold required"
												for="application_form_application_enterprise_attributes_constitution">Constitution</label>
											<div class="col-md-6">
												<input class="form-control input-lg readonly"
													required="required" readonly="readonly"
													placeholder="Constitution" type="text" name="constitution"
													id="application_form_application_enterprise_attributes_constitution">
												<div class="invalid-feedback"></div>
											</div>
										</div>
									</div>
								</div>


								<div class="card text-white bg-fed mb-3">
									<div class="card-header font-weight-bold">Details of
										Authorized Users</div>
									<div class="card-body bg-white text-dark">
										<div class="alert alert-info" role="alert">
											<strong><u>Preferred User ID/Corp ID Hints</u></strong>
											<ul>
												<li>Spaces or Special characters are not allowed.</li>
												<li>Only letters and numbers are allowed.</li>
												<li>Must be between 3 and 20 characters long</li>
												<li>Preferred Corp ID is the preference of the
													Firm/Entity. Ex. Nippon, Nippon1, Nippon2 etc (Where Nippon
													is the Firm/Entity).</li>
												<li>Preferred User ID is the preference of the user.
													Ex. Ajay123, Ajay1, Ajay2 etc (where Ajay is the
													proprietor/Partner/Director)</li>
											</ul>
										</div>



										<div class="users_form">
											<div class="row">
												<div class="col-md-6 mb-3">
													<input class="form-control" placeholder="Name"
														required="required" readonly="readonly" type="text"
														name="userName"
														id="application_form_application_user_user_name">
													<div class="invalid-feedback"></div>
												</div>
												<div class="col-md-6 mb-3">
													<input class="form-control" placeholder="Preferred User ID"
														required="required" readonly="readonly" type="text"
														name="applicationPrefNo"
														id="application_form_application_user_pref_no">
													<div class="invalid-feedback"></div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6 mb-3">
													<input class="form-control" placeholder="Customer ID"
														required="required" readonly="readonly" type="text"
														name="applicationCustNo"
														id="application_form_application_user_cust_no">
												</div>
												<div class="col-md-6 mb-3">
													<input class="form-control"
														data-inputmask="&#39;mask&#39;: &#39;999999&#39;"
														data-inputmask-placeholder="" readonly="readonly"
														max="1000000" placeholder="Transaction Limit" type="text"
														name="applicationTransLimit"
														id="application_form_application_user_trans_limit">
												</div>
											</div>

										</div>
									</div>
								</div>



								<div class="card text-white bg-fed mb-3">
									<div class="card-header font-weight-bold">Enterprise
										Transaction Limits</div>
									<div class="card-body bg-white text-dark">
										<div class="form-group row">
											<label
												class="col-sm-3 col-form-label required font-weight-bold"
												for="application_form_application_enterprise_attributes_daily_limit">Daily
												Limit</label>
											<div class="col-sm-6">
												<input class="form-control input-lg validate-field required"
													title="Daily Limit- Min: 100, Max: 3000000"
													required="required" min="100" max="3000000" value="3000000"
													type="number" name="dailyLimit"
													id="application_form_application_enterprise_attributes_daily_limit">
											</div>
										</div>
										<div class="form-group row">
											<label
												class="col-sm-3 col-form-label required font-weight-bold"
												for="application_form_application_enterprise_attributes_monthly_limit">Monthly
												Limit</label>
											<div class="col-sm-6">
												<input class="form-control input-lg validate-field required"
													title="Monthly Limit- Min: 100, Max: 50000000"
													required="required" min="100" max="50000000"
													value="50000000" type="number" name="monthlyLimit"
													id="application_form_application_enterprise_attributes_monthly_limit">
											</div>
										</div>
									</div>
								</div>



								<div class="card text-white bg-fed mb-3">
									<div class="card-header font-weight-bold">Corporate</div>
									<div class="card-body bg-white text-dark">
										<div class="form-group row">
											<label
												class="col-sm-3 col-form-label required font-weight-bold"
												for="application_form_application_enterprise_attributes_pref_corp">Corporate
												ID</label>
											<div class="col-sm-6">
												<input class="form-control input-lg validate-field required"
													onkeyup="nospaces(this)"
													onkeypress="return blockSpecialChar(event)"
													pattern="^[a-zA-Z0-9]{3,20}$" minlength="3" maxlength="20"
													required="required" size="20" type="text" name="prefCorp"
													id="application_form_application_enterprise_attributes_pref_corp">
											</div>
										</div>
									</div>
								</div>



								<div class="card text-white bg-fed mb-3">
									<div class="card-header font-weight-bold">Branch
										Verification</div>
									<div class="card-body bg-white text-dark">
										<div class="form-group row">
											<label
												class="col-sm-3 col-form-label font-weight-bold required"
												for="application_form_branch_verification_attributes_mode_of_operation">Mode
												of Operation</label>
											<div class="col-sm-6">
												<select class="form-control" id="singleOrMultipleOptions"
													required="required" name="modeOfOperation"><option
														value=""></option>
												</select>
											</div>
										</div>
										<script>
											$('#singleOrMultipleOptions')
													.on(
															'change',
															function() {

																if (this.value == "E or S"
																		|| this.value == "A or S") {
																	$(
																			"#disableRulesForAccountOperation1")
																			.prop(
																					'readonly',
																					true);
																	$(
																			"#disableRulesForAccountOperation1")
																			.val(
																					"0");
																	$(
																			"#disableRulesForAccountOperation2")
																			.prop(
																					'readonly',
																					true);
																	$(
																			"#disableRulesForAccountOperation2")
																			.val(
																					"0");
																	$(
																			"#disableRulesForAccountOperation3")
																			.prop(
																					'readonly',
																					true);
																	$(
																			"#disableRulesForAccountOperation3")
																			.val(
																					"0");

																	$(
																			"#disableRulesForAccountOperation1")
																			.attr(
																					{
																						"max" : 0,
																						"min" : 0
																					});
																	$(
																			"#disableRulesForAccountOperation2")
																			.attr(
																					{
																						"max" : 0,
																						"min" : 0
																					});
																	$(
																			"#disableRulesForAccountOperation3")
																			.attr(
																					{
																						"max" : 0,
																						"min" : 0
																					});

																} else {
																	$(
																			"#disableRulesForAccountOperation1")
																			.prop(
																					'readonly',
																					false);
																	$(
																			"#disableRulesForAccountOperation1")
																			.val(
																					"1");
																	$(
																			"#disableRulesForAccountOperation2")
																			.prop(
																					'readonly',
																					false);
																	$(
																			"#disableRulesForAccountOperation2")
																			.val(
																					"1");
																	$(
																			"#disableRulesForAccountOperation3")
																			.prop(
																					'readonly',
																					false);
																	$(
																			"#disableRulesForAccountOperation3")
																			.val(
																					"1");

																	$(
																			"#disableRulesForAccountOperation1")
																			.attr(
																					{
																						"max" : i - 1,
																						"min" : 1
																					});
																	$(
																			"#disableRulesForAccountOperation2")
																			.attr(
																					{
																						"max" : i - 1,
																						"min" : 1
																					});
																	$(
																			"#disableRulesForAccountOperation3")
																			.attr(
																					{
																						"max" : i - 1,
																						"min" : 1
																					});

																}

															});

											$("#singleOrMultipleOptions1")
													.prop('readonly', false);
											if ($("#singleOrMultipleOptions1")
													.prop("readonly")) {
												$("#singleOrMultipleOptions1")
														.empty()
														.append(
																'<option value="Single">Single</option><option value="Joint">Joint</option> <option value="E or S">E or S</option> <option value="A or S">A or S</options>');
											}
										</script>

										<script>
											$("#singleOrMultipleOptions1")
													.prop('readonly', false);
											if ($("#singleOrMultipleOptions1")
													.prop("readonly")) {
												$("#singleOrMultipleOptions1")
														.empty()
														.append(
																'<option value="Single">Single</option><option value="Joint">Joint</option> <option value="E or S">E or S</option> <option value="A or S">A or S</options>');
											}
										</script>
										<div class="row">
											<label class="custom-control custom-checkbox required">

												<input required="required"
												class="custom-control-input required" type="checkbox"
												name="boardResolutionConfirmed"
												id="application_form_branch_verification_attributes_board_resolution_confirmed">
												<span class="custom-control-indicator"></span> <span
												class="custom-control-description" id="firstCheckBox">Board
													Resolution/Letter of Mandate Obtained and Verified</span>
											</label>
										</div>

										<div class="row">
											<label class="custom-control custom-checkbox required">

												<input required="required"
												class="custom-control-input required" type="checkbox"
												name="modeOfOperationConfirmed"
												id="application_form_branch_verification_attributes_mode_of_operation_confirmed">
												<span class="custom-control-indicator"></span> <span
												class="custom-control-description" id="secondCheckBox">Mode
													of Operation and rules for Account operation details
													confirmed</span>
											</label>
										</div>
										<div id="checkboxGroup"></div>
									</div>
								</div>



								<div class="card text-white bg-fed mb-3">
									<div class="card-header font-weight-bold">Mandatory
										Documents</div>
									<div class="card-body bg-white text-dark">
										<div class="form-group row">
											<div class="col">
												<span class="font-weight-bold required">Upload
													resolutions and other documents (only pdf files)</span>
											</div>
										</div>
										<div class="form-group row">
											<input class="form-control" id="input-id" required="required"
												accept="application/pdf" type="file" name="documentfile">
										</div>
										<div class="form-group row">
											<label
												class="col-sm-2 col-form-label font-weight-bold required"
												for="application_form_document_attributes_document_type">Document
												Type</label>
											<div class="col-sm-6">
												<select class="form-control" required="required"
													name="documentType"
													id="application_form_document_attributes_document_type"><option
														value="">Select</option>
													<option value="Application Form">Application Form</option>
													<option
														value="Application Form along with Resolution/Mandate">Application
														Form along with Resolution/Mandate</option>
													<option value="Resolution/Mandate">Resolution/Mandate</option>
													<option value="Others">Others</option></select>
											</div>
										</div>
									</div>
								</div>

								<script type="text/javascript">
									$(function() {
										$("#input-id")
												.on(
														'change',
														function(event) {

															var filePath = $(
																	this).val();
															console
																	.log(filePath);

															var file = event.target.files[0];
															if (file.size >= 3 * 1024 * 1024) {
																alert("This file exceeds the maximum allowed file size (3 MB)");
																$("#input-id")
																		.val('');
																return;
															}

															if (!file.type
																	.match('application/pdf')) {
																alert("Only PDF file with extension: .pdf are allowed");
																$("#input-id")
																		.val('');
																return;
															}

															var fileReader = new FileReader();
															fileReader.onload = function(
																	e) {
																var int32View = new Uint8Array(
																		e.target.result);
																//verify the magic number
																// for PDF is 0x25 0x50 0x44 0x46 0x2d (see https://en.wikipedia.org/wiki/List_of_file_signatures)
																if (int32View.length > 4
																		&& int32View[0] == 0x25
																		&& int32View[1] == 0x50
																		&& int32View[2] == 0x44
																		&& int32View[3] == 0x46
																		&& int32View[4] == 0x2d) {
																	//alert("Success!");
																} else {
																	alert("Only valid PDF file");
																	$(
																			"#input-id")
																			.val(
																					'');
																	return;
																}
															};
															fileReader
																	.readAsArrayBuffer(file);
														});
									});
								</script>



								<div class="card text-white bg-fed mb-3">
									<div class="card-header font-weight-bold">Cooling Period</div>
									<div class="card-body bg-white text-dark">
										<div class="form-group row">
											<label
												class="col-sm-4 col-form-label required font-weight-bold"
												for="application_form_application_enterprise_attributes_cooling_period">Cooling
												period for Beneficiary</label>
											<div class="col-sm-6">
												<div class="cooling_period_select ">
													<div class="cooling_period">
														<select name="days"
															id="application_form_application_enterprise_attributes_days">
															<option value="0">0</option>
															<c:forEach begin="1" end="99" varStatus="days">
																<option value="${days.index}">${days.index}</option>
															</c:forEach>
														</select> day <select name="hours"
															id="application_form_application_enterprise_attributes_hours"><option
																value="0">0</option>
															<c:forEach begin="1" end="23" varStatus="hours">
																<option value="${hours.index}">${hours.index}</option>
															</c:forEach>

														</select> hr <select name="minutes"
															id="application_form_application_enterprise_attributes_minutes"><option
																value="0">0</option>
															<c:forEach begin="1" end="59" varStatus="minutes">
																<option value="${minutes.index}">${minutes.index}</option>
															</c:forEach>
														</select> min
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>



								<div class="card text-white bg-fed mb-3">
									<div class="card-header font-weight-bold required">Set
										Rules for Account Operation</div>
									<div class="card-body bg-white text-dark">
										<div class="container">
											<div class="row">
												<div class="well well-sm">
													<em> <mark> Please note that only number of
															authorizers required need to be entered i.e in case of
															Single Operation, No of authorizers required would be '0'
															in case of Joint Operation by two users, No of
															authorizers required would be '1' in case of Joint
															Operation by three users, No of authorizers required
															would be '2' </mark>
													</em>
												</div>
											</div>
											<hr>
											<div class="form-group row">
												<label
													class="col-sm-5 col-form-label font-weight-bold required"
													for="application_form_application_enterprise_attributes_auth_fund">No
													of users to authorize fund transfer</label>
												<div class="col-md-6">
													<input class="form-control required input-lg user_auth"
														id="disableRulesForAccountOperation1" pattern="[0-9]"
														min="0" max="0"
														title="No of Authorizers shall be less than the total number of users added."
														required="required" value="0" type="number"
														name="authFund">
												</div>
											</div>
											<div class="form-group row">
												<label
													class="col-sm-5 col-form-label font-weight-bold required"
													for="application_form_application_enterprise_attributes_auth_ext">No
													of users to authorize add external user</label>
												<div class="col-md-6">
													<input
														class="form-control required input-lg validate-field user_auth"
														id="disableRulesForAccountOperation2" pattern="[0-9]"
														min="0" max="0"
														title="No of Authorizers shall be less than the total number of users added."
														required="required" value="0" type="number" name="authExt">
												</div>
											</div>
											<div class="form-group row">
												<label
													class="col-sm-5 col-form-label font-weight-bold required"
													for="application_form_application_enterprise_attributes_auth_ben">No
													of users to authorize add beneficiary</label>
												<div class="col-md-6">
													<input class="form-control required input-lg user_auth"
														id="disableRulesForAccountOperation3" pattern="[0-9]"
														min="0" max="0"
														title="No of Authorizers shall be less than the total number of users added."
														required="required" value="0" type="number" name="authBen">
												</div>
											</div>
										</div>
									</div>
								</div>


								<div class="card text-white bg-fed mb-3">
									<div class="card-header font-weight-bold">Remarks and
										Recommendations</div>
									<div class="card-body bg-white text-dark">
										<div class="container">
											<div class="form-group row">
												<div class="col-sm-10">
													<textarea class="form-control" rows="7" maxlength="200"
														placeholder="Remarks and Recommendations"
														required="required" name="declaration"
														id="application_form_declaration"></textarea>
												</div>
											</div>
										</div>
									</div>
								</div>
								<input value="${login_users.userSession}" type="hidden"
									name="applicationCreatedBy" id="application_form_created_by">
								<div class="card text-white bg-fed mb-3">
									<div class="card-header font-weight-bold">Reference</div>
									<div class="card-body bg-white text-dark">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label font-weight-bold"
												for="application_form_reference_id">Reference ID</label>
											<div class="col-md-6">
												<input class="form-control" maxlength="15"
													pattern="^[a-zA-Z0-9. /&#39;-]+$"
													placeholder="Referral Employee ID" size="15" type="text"
													name="applicationReferenceId"
													id="application_form_reference_id">
											</div>
										</div>
									</div>
								</div>


								<div class="card text-white bg-fed mb-3">
									<div class="card-body bg-white text-dark">
										<div class="container">
											<div class="application_detail">
												<div class="row">
													<div class="col-auto mr-auto">
														<span class="badge badge-secondary">Added By : </span> <span
															class="badge badge-primary"></span>
													</div>
												</div>
												<div class="row">
													<div class="col-auto mr-auto"></div>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="actions">
									<input type="submit" name="commit" id="submit-button"
										value="Create New Application"
										class="form-control btn btn-primary font-weight-bold"
										data-disable-with="Create New Application">
								</div>
							</form>
						</div>

					</div>

				</div>
			</main>
		</div>
	</div>

	<script src="./resources/assets/javascripts/function.js"></script>


</body>

</html>
