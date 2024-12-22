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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
</head>
<script>
$(document).ready(function(){
var mainid = document.getElementById('applicationId').value;
var istrue = false;
if(mainid.length > 0 && mainid != localStorage.getItem("id1")) {
	localStorage.setItem("id1",mainid);
	istrue =true;  	
}
window.onbeforeunload = function(){
    	var id = document.getElementById('applicationId').value;
    	localStorage.setItem("id1",id);	
    }

window.addEventListener("load", (event) => {
	if (performance.navigation.type == performance.navigation.TYPE_RELOAD) {
		var inputData = {
				'applnformid': localStorage.getItem("id1")
		}
		$.ajax({
			url:'modified-application',
			method:'POST',
			data:inputData,
			 async:false,
			success:function(data){
				 document.open();
	             document.write(data);
	             document.close();	
			},
			error:function(e){
				console.log(e);
			}		
		});	 
	}
});
}); 
</script>
<body class="bg-light">
	<c:if test="${sessionScope.logindetails.userSession}">
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


			


				<script>
                    function ConvertMinutes(num) {
                        d = Math.floor(num / 1440); // 60*24
                        h = Math.floor((num - (d * 1440)) / 60);
                        m = Math.round(num % 60);

                        if (d > 0) {
                            var elem = d + " days, " + h + " hours, " + m + " minutes";

                            $("select[name='days']").find("option[value=" + d + "]").attr("selected", true);
                            $("select[name='hours']").find("option[value=" + h + "]").attr("selected", true);
                            $("select[name='minutes']").find("option[value=" + m + "]").attr("selected", true);
                        } else {
                            var elem = d + " days, " + h + " hours, " + m + " minutes";
                            $("select[name='days']").find("option[value=" + d + "]").attr("selected", true);
                            $("select[name='hours']").find("option[value=" + h + "]").attr("selected", true);
                            $("select[name='minutes']").find("option[value=" + m + "]").attr("selected", true);
                        }
                    }
                </script>

				<c:set var="relatedpartycheck" value="0" scope="page" />




				<div class="">
					<div class="content-application-form">
						<div class="validate-fields">
							<form id="needs-validation" class="edit_application_form"
								enctype="multipart/form-data" action="modifiedApplication"
								accept-charset="UTF-8" method="post" novalidate="novalidate">
								<input name="utf8" type="hidden" value=""><input
									type="hidden" name="_method" value="patch"><input
									type="hidden" name="authenticity_token"
									value="/2gtdwg33AtM3YiK34IWPpaUZZ5xPOf/TwmqhG5VOVY+bLt7cqxSC9unHjimG+8EajzsknYw5ykO5xMdfpz/uw==">

								<div class="card text-white bg-fed mb-3">
									<div class="card-header font-weight-bold required">Enterprise</div>
									<div class="card-body bg-white text-dark enterprise_form">
										<div class="form-group row">
											<label
												class="col-sm-3 col-form-label font-weight-bold required"
												for="application_form_application_enterprise_attributes_acc_no">Primary
												Account No</label>
											<div class="col-md-6">
												<input type="hidden" name="appid" id="applicationId"
													value="${applicationDetails.id}"> <input
													class="form-control input-lg required readonly"
													data-inputmask="&#39;mask&#39;: &#39;99999999999999&#39;"
													data-inputmask-placeholder="" required="required"
													placeholder="Primary Account No." readonly="readonly"
													type="text" value="${applicationDetails.accNo}"
													name="accNo"
													id="application_form_application_enterprise_attributes_acc_no">
												<div class="invalid-feedback"></div>
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
													type="text" value="${applicationDetails.accName}"
													name="accName"
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
													placeholder="Customer ID" type="text"
													value="${applicationDetails.custNo}" name="custNo"
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
													placeholder="Branch Code"
													value="${applicationDetails.branchCode}" type="text"
													name="branchCode"
													id="application_form_application_enterprise_attributes_branch">
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
													id="application_form_application_enterprise_attributes_address">${applicationDetails.address}</textarea>
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
													placeholder="Constitution" type="text"
													value="${applicationDetails.constitution}"
													name="constitution"
													id="application_form_application_enterprise_attributes_constitution">
												<div class="invalid-feedback"></div>
											</div>
										</div>
									</div>
								</div>
								<input type="hidden" name="id"
									id="application_form_application_enterprise_attributes_application_users_attributes__id"
									value="${applicationDetails.applnEnterprisesId}">
								<div class="container">
									<ul class="row list-unstyled related_parties">

										<c:forEach var="applicationUser" items="${applicationUsers}">
											<c:set var="relatedpartycheck"
												value="${relatedpartycheck + 1}" />
											<li class="col-md-6 user-form">
												<div class="card bg-light border border-dark mb-3 text-left">
													<div
														class="card-header bg-dark text-white font-weight-bold ">
														${applicationUser.userName}</div>
													<input type="hidden"
														name="application_form[application_enterprise_attributes][application_users_attributes][][id]"
														id="application_form_application_enterprise_attributes_application_users_attributes__id">
													<div class="card-body bg-secondary">
														<div class="form-group row row-info">
															<input type="text" name="applicationUserName"
																id="application_form_application_enterprise_attributes_application_users_attributes__user_name"
																value="${applicationUser.userName}" placeholder="Name"
																class="form-control form-control-sm" minlength="3"
																maxlength="100" required="required" readonly="readonly"
																pattern="[a-zA-Z. ]+">
														</div>
														<div class="form-group row row-info">
															<input type="text" name="applicationPrefNo"
																id="application_form_application_enterprise_attributes_application_users_attributes__pref_no"
																value="${applicationUser.prefNo}"
																placeholder="Preferred User ID"
																pattern="^[a-zA-Z0-9]{2,20}$"
																class="form-control form-control-sm" required="required"
																readonly="readonly">
														</div>
														<div class="form-group row row-info">
															<input type="text" name="applicationCustNo"
																id="application_form_application_enterprise_attributes_application_users_attributes__cust_no"
																value="${applicationUser.custNo}"
																placeholder="Customer ID"
																class="form-control form-control-sm
                                                    readonly"
																required="required" readonly="readonly">
														</div>
														<div class="form-group row row-info">
															<input type="number" name="applicationMobileNo"
																id="application_form_application_enterprise_attributes_application_users_attributes__mobile"
																value="${applicationUser.mobile}" placeholder="Mobile"
																class="form-control form-control-sm" required="required"
																minlength="6" maxlength="16" readonly="readonly">
														</div>
														<div class="form-group row row-info">
															<input type="number" name="applicationTransLimit"
																id="trans_limit_0" value="${applicationUser.transLimit}"
																placeholder="Transaction Limit"
																class="form-control
                                                    form-control-sm"
																min="1" max="1000000">
														</div>
														<div class="form-group row row-info">
															Authorized Signatory : &nbsp;&nbsp;&nbsp;<input
																type="checkbox"
																onchange="authSignUpdate(event,`${applicationUser.prefNo}`)"
																name="applicationAuthSignatory"
																id="application_form_application_enterprise_attributes_application_users_attributes__authorized_signatory"
																value="${applicationUser.authorizedSignatory}"
																<c:if test="${applicationUser.authorizedSignatory}">checked="checked"
                                                        </c:if>>
														</div>
													</div>

													<div class="card-footer bg-secondary text-center">
														<a class="close-icon btn btn-danger remove"
															onclick="return onclickRemoveUser(`${applicationUser.id}`,`${applicationUser.prefNo}`,this);"
															href="javascript:void(0)">Remove</a>
													</div>
												</div>
											</li>
										</c:forEach>
									</ul>
								</div>

								<p class="text-center">
									<a id="auto_load_users1" class="btn btn-info auto_load_users1"
										onclick="return onclickUserFunction()"
										href="javascript:void(0)">Add User</a>
								</p>



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
													required="required" min="100" max="3000000"
													value="${applicationDetails.dailyLimit}" type="number"
													name="dailyLimit"
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
													value="${applicationDetails.monthlyLimit}" type="number"
													name="monthlyLimit"
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
													pattern="^[a-zA-Z0-9]{3,20}$" minlength="3" maxlength="20"
													required="required" size="20" type="text"
													value="${applicationDetails.prefCorp}" name="prefCorp"
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
													required="required" name="modeOfOperation">
													<c:choose>
														<c:when test="${relatedpartycheck eq 1 }">
															<option selected="selected" value="Single">Single</option>
														</c:when>
														<c:otherwise>
															  <option selected="selected" value="${applicationDetails.modeOfOperation}">
																${applicationDetails.modeOfOperation}</option>
																
																<c:if test="${applicationDetails.modeOfOperation == 'Single'}">
																<option value="Joint">Joint</option>
																<option value="E or S">E or S</option>
																<option value="A or S">A or S</option>
																</c:if>
																
																<c:if test="${applicationDetails.modeOfOperation == 'Joint'}">
																<option value="Single">Single</option>
																<option value="E or S">E or S</option>
																<option value="A or S">A or S</option>
																
																</c:if>
																
																<c:if test="${applicationDetails.modeOfOperation == 'E or S'}">
																<option value="Single">Single</option>
																<option value="Joint">Joint</option>
																
																<option value="A or S">A or S</option>
																</c:if>
																
																
																<c:if test="${applicationDetails.modeOfOperation == 'A or S'}">
																<option value="Single">Single</option>
																<option value="Joint">Joint</option>
																<option value="E or S">E or S</option>
																
																</c:if>

														
														</c:otherwise>
													</c:choose>

												</select>
											</div>
										</div>
										<script>

                                            $('#singleOrMultipleOptions').on('change', function () {

                                                if (this.value == "E or S" || this.value == "A or S") {
                                                    $("#disableRulesForAccountOperation1").prop('readonly', true);
                                                    $("#disableRulesForAccountOperation1").val("0");
                                                    $("#disableRulesForAccountOperation2").prop('readonly', true);
                                                    $("#disableRulesForAccountOperation2").val("0");
                                                    $("#disableRulesForAccountOperation3").prop('readonly', true);
                                                    $("#disableRulesForAccountOperation3").val("0");

                                                    $("#disableRulesForAccountOperation1").attr({
                                                        "max": 0,
                                                        "min": 0
                                                    });
                                                    $("#disableRulesForAccountOperation2").attr({
                                                        "max": 0,
                                                        "min": 0
                                                    });
                                                    $("#disableRulesForAccountOperation3").attr({
                                                        "max": 0,
                                                        "min": 0
                                                    });

                                                }

                                                else {
                                                    $("#disableRulesForAccountOperation1").prop('readonly', false);
                                                    $("#disableRulesForAccountOperation1").val("1");
                                                    $("#disableRulesForAccountOperation2").prop('readonly', false);
                                                    $("#disableRulesForAccountOperation2").val("1");
                                                    $("#disableRulesForAccountOperation3").prop('readonly', false);
                                                    $("#disableRulesForAccountOperation3").val("1");

                                                    $("#disableRulesForAccountOperation1").prop("min", 1);
                                                    $("#disableRulesForAccountOperation2").prop("min", 1);
                                                    $("#disableRulesForAccountOperation3").prop("min", 1);
                                                    if (typeof i !== 'undefined') {
                                                        if (${relatedpartycheck} >= i)
                                            {
                                                $("#disableRulesForAccountOperation1").prop("max", ${relatedpartycheck -1});
                                                $("#disableRulesForAccountOperation2").prop("max", ${relatedpartycheck -1});
                                                $("#disableRulesForAccountOperation3").prop("max", ${relatedpartycheck -1});
                                            }
  else
                                            {
                                                $("#disableRulesForAccountOperation1").prop("max", i - 1);
                                                $("#disableRulesForAccountOperation2").prop("max", i - 1);
                                                $("#disableRulesForAccountOperation3").prop("max", i - 1);
                                            }
 }
 else
                                            {
                                                $("#disableRulesForAccountOperation1").prop("max", ${relatedpartycheck -1});
                                                $("#disableRulesForAccountOperation2").prop("max", ${relatedpartycheck -1});
                                                $("#disableRulesForAccountOperation3").prop("max", ${relatedpartycheck -1});
                                            }
  
  
    }
 
});

                                            $("#singleOrMultipleOptions").prop('readonly', false);
                                            if ($("#singleOrMultipleOptions").prop("readonly")) {
                                                $("#singleOrMultipleOptions")
                                                    .empty()
                                                    .append('<option value="Single">Single</option> <option value="Joint">Joint</option> <option value="E or S">E or S</option> <option value="A or S">A or S</options>');
                                            }


                                            $(document).ready(function () {
                                                // Handler for .ready() called.

                                                if ("${applicationDetails.modeOfOperation}" != null && ${applicationDetails.modeOfOperation eq 'Joint'})
                                            {
                                                $("#disableRulesForAccountOperation1").prop('readonly', false);
                                                $("#disableRulesForAccountOperation1").val(${applicationDetails.authFund});
                                                $("#disableRulesForAccountOperation2").prop('readonly', false);
                                                $("#disableRulesForAccountOperation2").val(${applicationDetails.authExt});
                                                $("#disableRulesForAccountOperation3").prop('readonly', false);
                                                $("#disableRulesForAccountOperation3").val(${applicationDetails.authBen});

                                                $("#disableRulesForAccountOperation1").prop("min", 1);
                                                $("#disableRulesForAccountOperation2").prop("min", 1);
                                                $("#disableRulesForAccountOperation3").prop("min", 1);
                                                $("#disableRulesForAccountOperation1").prop("max", ${relatedpartycheck - 1});
                                                $("#disableRulesForAccountOperation2").prop("max",  ${relatedpartycheck - 1});
                                                $("#disableRulesForAccountOperation3").prop("max", ${relatedpartycheck - 1});
                                            }
                                            else
                                            {
                                                $("#disableRulesForAccountOperation1").prop('readonly', true);
                                                $("#disableRulesForAccountOperation1").val("0");
                                                $("#disableRulesForAccountOperation2").prop('readonly', true);
                                                $("#disableRulesForAccountOperation2").val("0");
                                                $("#disableRulesForAccountOperation3").prop('readonly', true);
                                                $("#disableRulesForAccountOperation3").val("0");

                                                $("#disableRulesForAccountOperation1").attr({
                                                    "max": 0,
                                                    "min": 0
                                                });
                                                $("#disableRulesForAccountOperation2").attr({
                                                    "max": 0,
                                                    "min": 0
                                                });
                                                $("#disableRulesForAccountOperation3").attr({
                                                    "max": 0,
                                                    "min": 0
                                                });
                                            }
  
});


                                        </script>

										<script>
                                            $("#singleOrMultipleOptions").prop('readonly', false);
                                            if ($("#singleOrMultipleOptions").prop("readonly")) {
                                                $("#singleOrMultipleOptions")
                                                    .empty()
                                                    .append('<option value="Single">Single</option><option value="Joint">Joint</option> <option value="E or S">E or S</option> <option value="A or S">A or S</options>');
                                            }
                                        </script>
										<div class="row">
											<label class="custom-control custom-checkbox required">
												<input
												name="application_form[branch_verification_attributes][board_resolution_confirmed]"
												type="hidden" value="0"><input required="required"
												class="custom-control-input required" type="checkbox"
												value="${applicationDetails.boardResolutionConfirmed}"
												checked="checked" name="boardResolutionConfirmed"
												id="application_form_branch_verification_attributes_board_resolution_confirmed">
												<span class="custom-control-indicator"></span> <span
												class="custom-control-description" id="firstCheckBox">Board
													Resolution/Letter of Mandate Obtained and Verified</span>
											</label>
										</div>

										<div class="row">
											<label class="custom-control custom-checkbox required">
												<input
												name="application_form[branch_verification_attributes][mode_of_operation_confirmed]"
												type="hidden" value="0"><input required="required"
												class="custom-control-input required" type="checkbox"
												value="${applicationDetails.modeOfOperationConfirmed}"
												checked="checked" name="modeOfOperationConfirmed"
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
										<c:forEach var="document" items="${documents}">

											<div class="form-group row">
												<a target="_blank"
													href="fedservice/api/services/getFile/${document.filenetId}/SECURED">View
													Attachment</a>
												<div class="col-3 font-weight-bold">Type of Document :
												</div>
												<div class="col">${document.documentType}</div>
												<div class="row">
													<div class="col-auto mr-auto">
														<span class="badge badge-primary"> <fmt:formatDate
																value="${document.createdAt}"
																pattern="MMMM dd, YYYY hh:mm a" />
														</span>
													</div>
												</div>
											</div>
										</c:forEach>

										<div class="form-group row">
											<div class="col">
												<span class="font-weight-bold required">Upload
													resolutions and other documents (only pdf files)</span>
											</div>
										</div>
										<div class="form-group row">
											<input class="form-control" id="input-id"
												accept="application/pdf" type="file" name="documentfile">
										</div>
										<div class="form-group row">
											<label
												class="col-sm-2 col-form-label font-weight-bold required"
												for="application_form_document_attributes_document_type">Document
												Type</label>
											<div class="col-sm-6">
												<select class="form-control" name="documentType"
													id="application_form_document_attributes_document_type">
													<option value="Application Form">Application Form</option>
													<option
														value="Application Form along with Resolution/Mandate">Application
														Form along with Resolution/Mandate</option>
													<option value="Resolution/Mandate">Resolution/Mandate</option>
													<option value="Others">Others</option>
												</select>
											</div>
										</div>
									</div>
								</div>

								<script type="text/javascript">
                                    $(function () {
                                        $("#input-id").on('change', function (event) {
                                            var file = event.target.files[0];
                                            if (file.size >= 3 * 1024 * 1024) {
                                                alert("This file exceeds the maximum allowed file size (3 MB)");
                                                $("#input-id").val('');
                                                return;
                                            }

                                            if (!file.type.match('application/pdf')) {
                                                alert("Only PDF file with extension: .pdf are allowed");
                                                $("#input-id").val('');
                                                return;
                                            }

                                            var fileReader = new FileReader();
                                            fileReader.onload = function (e) {
                                                var int32View = new Uint8Array(e.target.result);
                                                //verify the magic number
                                                // for PDF is 0x25 0x50 0x44 0x46 0x2d (see https://en.wikipedia.org/wiki/List_of_file_signatures)
                                                if (int32View.length > 4 && int32View[0] == 0x25 && int32View[1] == 0x50 && int32View[2] == 0x44 && int32View[3] == 0x46 && int32View[4] == 0x2d) {
                                                    
                                                } else {
                                                    alert("Only valid PDF file");
                                                    $("#input-id").val('');
                                                    return;
                                                }
                                            };
                                            fileReader.readAsArrayBuffer(file);
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
														<script> 
                                                        $(document).ready(function () {  
                                                        	ConvertMinutes('${applicationDetails.coolingPeriod}') 
                                                        	});
                                                        </script>
														<select name="days"
															id="application_form_application_enterprise_attributes_days">
															<option selected="selected" value="0">0</option>
															<c:forEach begin="1" end="99" varStatus="days">
																<option value="${days.index}">${days.index}</option>
															</c:forEach>
														</select> day <select name="hours"
															id="application_form_application_enterprise_attributes_hours">
															<option selected="selected" value="0">0</option>
															<c:forEach begin="1" end="23" varStatus="hours">
																<option value="${hours.index}">${hours.index}</option>
															</c:forEach>
														</select> hr <select name="minutes"
															id="application_form_application_enterprise_attributes_minutes">
															<option selected="selected" value="0">0</option>
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
														<c:choose><c:when test="${relatedpartycheck eq 1 }"> min="0" max="0" </c:when><c:when test="${relatedpartycheck eq 2 }"> min="0" max="1" </c:when> <c:otherwise> min="0" max=2"</c:otherwise> </c:choose>
														title="No of Authorizers shall be less than the total number
                                                    of users added."
														required="required" value="${applicationDetails.authFund}"
														type="number" name="authFund">
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
														<c:choose><c:when test="${relatedpartycheck eq 1 }"> min="0" max="0" </c:when><c:when test="${relatedpartycheck eq 2 }"> min="0" max="1" </c:when> <c:otherwise> min="0" max=2"</c:otherwise> </c:choose>
														title="No of Authorizers shall be less than the total number
                                                    of users added."
														required="required" value="${applicationDetails.authExt}"
														type="number" name="authExt">
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
														<c:choose><c:when test="${relatedpartycheck eq 1 }"> min="0" max="0" </c:when><c:when test="${relatedpartycheck eq 2 }"> min="0" max="1" </c:when> <c:otherwise> min="0" max=2"</c:otherwise> </c:choose>
														title="No of Authorizers shall be less than the total number
                                                    of users added."
														required="required" value="${applicationDetails.authBen}"
														type="number" name="authBen">
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
														id="application_form_declaration">${applicationDetails.declaration}</textarea>
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
													value="${applicationDetails.referenceId}"
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
														<c:if
															test="${not empty  applicationDetails.applnFormCreatedAt}">
															<span class="badge badge-secondary">Added By
																:${applicationDetails.createdBy} </span>
															<span class="badge badge-primary"> <fmt:formatDate
																	value="${applicationDetails.applnFormCreatedAt}"
																	pattern="MMMM dd, YYYY hh:mm a" />
															</span>
														</c:if>
													</div>
												</div>
												<div class="row">
													<div class="col-auto mr-auto">
														<c:if test="${not empty  applicationDetails.forwardedAt}">
															<span class="badge badge-secondary">Forwarded By :
																${applicationDetails.forwardedBy}</span>
															<span class="badge badge-primary"> <fmt:formatDate
																	value="${applicationDetails.forwardedAt}"
																	pattern="MMMM dd, YYYY hh:mm a" />
															</span>
														</c:if>
													</div>
												</div>
												<div class="row">
													<div class="col-auto mr-auto">
														<c:if
															test="${not empty  applicationDetails.resubmittedAt}">
															<span class="badge badge-danger">Resubmitted By :
																${applicationDetails.resubmittedBy}</span>
															<span class="badge badge-primary"> <fmt:formatDate
																	value="${applicationDetails.resubmittedAt}"
																	pattern="MMMM dd, YYYY hh:mm a" />

															</span>
														</c:if>
													</div>
												</div>
												<div class="row">
													<div class="col-auto mr-auto">
														<c:if test="${not empty  applicationDetails.rejectedAt}">
															<span class="badge badge-secondary">Rejected By :
																${applicationDetails.rejectedBy} </span>
															<span class="badge badge-primary"> <fmt:formatDate
																	value="${applicationDetails.rejectedAt}"
																	pattern="MMMM dd, YYYY hh:mm a" />

															</span>
														</c:if>
													</div>
												</div>
												<div class="row">
													<div class="col-auto mr-auto">
														<c:if test="${not empty  applicationDetails.approvedAt}">
															<span class="badge badge-success">Approved By :
																${applicationDetails.approvedBy}</span>
															<span class="badge badge-primary"> <fmt:formatDate
																	value="${applicationDetails.approvedAt}"
																	pattern="MMMM dd, YYYY hh:mm a" />
															</span>
														</c:if>
													</div>
												</div>

											</div>
										</div>
										<div class="row">
											<div class="col-auto mr-auto">
												<div class="row">
													<div class="col-auto mr-auto"></div>
												</div>
											</div>
										</div>
									</div>
								</div>


								<div class="actions">
									<input type="submit" id="submit-button" name="commit"
										value="Modify"
										class="form-control btn btn-primary font-weight-bold"
										data-disable-with="Forward">
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