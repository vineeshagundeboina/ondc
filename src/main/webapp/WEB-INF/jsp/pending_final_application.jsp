<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FedmobileSmeAdminWeb</title>
    <meta name="csrf-param" content="authenticity_token">
    <meta name="csrf-token" content="JJLPOKgrfKd8H9Szu9kE4pX7OHAirbJosCri+ZcTDn4DYY1PkWiH3slPZ3xy3JuxIXRz99l138zv2GtL1gJ0mw==">
    <link href="./resources/assets/stylesheets/main.css" rel="stylesheet" media="all">
    <script src="./resources/assets/javascripts/custom.js"></script>
    <link href="./resources/assets/stylesheets/font-awesome.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ page import=" java.util.*, java.io.*" %>
    <%@ page isELIgnored="false"%>
    
   
    <style type="text/css">
        .turbolinks-progress-bar {
            position: fixed;
            display: block;
            top: 0;
            left: 0;
            height: 3px;
            background: #0076ff;
            z-index: 9999;
            transition: width 300ms ease-out, opacity 150ms 150ms ease-in;
            transform: translate3d(0, 0, 0);
        }
    </style>
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
    			url:'pendingwithfinalapplication',
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
 <script>
        function ConvertMinutes(num) {
            d = Math.floor(num / 1440); // 60*24
            h = Math.floor((num - (d * 1440)) / 60);
            m = Math.round(num % 60);

            if (d > 0) {
                var elem = d + " day, " + h + " hr, " + m + " min";

                document.getElementById("_days").innerHTML = elem;

            } else {
                var elem = d + " day, " + h + " hr, " + m + " min";

                document.getElementById("_days").innerHTML = elem;
            }
        }
    </script>
    



<body class="bg-light" >
    <c:if test="${sessionScope.logindetails.userSession}">
        <c:redirect url="login" />
    </c:if>
    <%@ include file="header.jsp" %>

    <div class="container-fluid">
        <marquee behavior="scroll" direction="left">
            <font color="red">
                <b>To Generate Activation Token, Go to Approved list -&gt; Click on View -&gt; Manage Accounts -&gt;
                    Generate Activation Token (Valid for 3 hours only).</b>
            </font>
        </marquee>
        <div class="row">

            <%@ include file="slider.jsp" %>

            <main role="main" class="col-md-9 col-sm-9 col-xs-12">
                <div class="modal" id="alert-box" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header text-white">
                                <h5 class="modal-title"><i class="fa" aria-hidden="true"></i> &nbsp;Alert</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">x</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <p class="modal-data"></p>
                            </div>

                        </div>
                    </div>
                </div>

                <c:if test="${not empty message}">
                <script>
                	var v ="${message}"; 
                	 alert_box("danger",v);
                </script>
                </c:if>
                <c:if test="${not empty comment_status}">
                <script>
                	 alert_box("success","Comment added successfully ");
                </script>
                </c:if>

              
                <div class="">             
                   


                    <div class="content-application-form">
                        <div class="card text-white mb-3">
                            <div class="card-header font-weight-bold  bg-info">
                                Application Status: &nbsp;&nbsp;<i class="text-uppercase">Pending With Final Approval </i>
                                
                            </div>
                        </div>



                        <div class="card text-white bg-fed mb-3">
                            <div class="card-header font-weight-bold">Enterprise</div>
                            <div class="card-body bg-white text-dark">
                                <div class="container">
                                    <div class="row row-info">
                                        <div class="col-3 font-weight-bold">
                                            Reg ID :
                                        </div>
                                        <div class="col">
                                            ${applicationDetails.id}
                                        </div>
                                        <input type ="hidden" id="applicationId" value="${applicationDetails.id}" name="applnid" />

                                    </div>
                                    <div class="row row-info">
                                        <div class="col-3 font-weight-bold">
                                            Account Name :
                                        </div>
                                        <div class="col">
                                            ${applicationDetails.accName}
                                        </div>
                                    </div>
                                    <div class="row row-info">
                                        <div class="col-3 font-weight-bold">
                                            Primary Account No :
                                        </div>
                                        <div class="col">
                                            ${applicationDetails.accNo}
                                        </div>
                                    </div>
                                    <div class="row row-info">
                                        <div class="col-3 font-weight-bold">
                                            Customer ID :
                                        </div>
                                        <div class="col">
                                            ${applicationDetails.custNo}
                                        </div>
                                    </div>
                                    <div class="row row-info">
                                        <div class="col-3 font-weight-bold">
                                            Branch Code :
                                        </div>
                                        <div class="col">
                                            ${applicationDetails.branchCode}
                                        </div>
                                    </div>
                                    <div class="row row-info">
                                        <div class="col-3 font-weight-bold">
                                            Address :
                                        </div>
                                        <div class="col">
                                            ${applicationDetails.address}
                                        </div>
                                    </div>
                                    <div class="row row-info">
                                        <div class="col-3 font-weight-bold">
                                            Constitution :
                                        </div>
                                        <div class="col">
                                            ${applicationDetails.constitution}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                       


                        <div class="card text-white bg-fed mb-3">
                            <div class="card-header font-weight-bold">Details of Authorized Users</div>
                            <div class="card-body bg-white text-dark">
                                <div class="container">
                                    <div class="row row-info">
                                        <div class="alert alert-info" role="alert">
                                            <strong><u>Preferred User ID/Corp ID Hints</u></strong>
                                            <ul>
                                                <li>Spaces or Special characters are not allowed.</li>
                                                <li>Only letters and numbers are allowed.</li>
                                                <li>Must be between 3 and 20 characters long</li>
                                                <li>Preferred Corp ID is the preference of the Firm/Entity. Ex. Nippon,
                                                    Nippon1, Nippon2...etc (Where Nippon is the Firm/Entity).</li>
                                                <li>Preferred User ID is the preference of the user. Ex. Ajay123,
                                                    Ajay1, Ajay2...etc (where Ajay is the proprietor/Partner/Director)</li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="row row-info">
                                        <div class="container bg-light user-list">
                                            <div class="row row-info align-items-center">

                                                <c:forEach var="applicationUser" items="${applicationUsers}">

                                                    <div class="col-sm-6">
                                                        <div class="card mb-3 text-left">
                                                            <div class="card-header border-dark bg-info font-weight-bold">

                                                                ${applicationUser.userName}
                                                            </div>
                                                            <div class="card-body">
                                                                <div class="container">
                                                                    <div class="row row-info">
                                                                        <div class="col-5 font-weight-bold">
                                                                            User ID :
                                                                        </div>
                                                                        <div>

                                                                            ${applicationUser.prefNo}
                                                                        </div>
                                                                    </div>
                                                                    <div class="row row-info">
                                                                        <div class="col-5 font-weight-bold">
                                                                            Customer ID :
                                                                        </div>
                                                                        <div>

                                                                            ${applicationUser.custNo}
                                                                        </div>
                                                                    </div>
                                                                    <div class="row row-info">
                                                                        <div class="col-5 font-weight-bold">
                                                                            Mobile :
                                                                        </div>
                                                                        <div>

                                                                            ${applicationUser.mobile}
                                                                        </div>
                                                                    </div>
                                                                    <div class="row row-info">
                                                                        <div class="col-5 font-weight-bold">
                                                                            Transaction Limit :
                                                                        </div>
                                                                        <div>

                                                                            <c:choose>
                                                                                <c:when test=" ${applicationUser.transLimit eq null}">
                                                                                    1000000
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    ${applicationUser.transLimit}
                                                                                </c:otherwise>
                                                                            </c:choose>




                                                                        </div>
                                                                    </div>
                                                                    <div class="row row-info">
                                                                        <div class="col-6 font-weight-bold">
                                                                            Authorized Signatory :
                                                                        </div>
                                                                        <div>

                                                                            <c:choose>
                                                                                <c:when test="${applicationUser.authorizedSignatory}">
                                                                                    Yes
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    No
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </c:forEach>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>



                        <div class="card text-white bg-fed mb-3">
                            <div class="card-header font-weight-bold">Enterprise Transaction Limit</div>
                            <div class="card-body bg-white text-dark">
                                <div class="container">
                                    <div class="row row-info">
                                        <div class="col-3 font-weight-bold">
                                            Daily Limit :
                                        </div>
                                        <div class="col">

                                            <c:choose>
                                                <c:when test="${applicationDetails.dailyLimit eq 0}">
                                                    3000000
                                                </c:when>
                                                <c:otherwise>
                                                    ${applicationDetails.dailyLimit}
                                                </c:otherwise>
                                            </c:choose>



                                        </div>
                                    </div>
                                    <div class="row row-info">
                                        <div class="col-3 font-weight-bold">
                                            Monthly Limit :
                                        </div>
                                        <div class="col">
                                            <c:choose>
                                                <c:when test="${applicationDetails.monthlyLimit eq 0}">
                                                    50000000
                                                </c:when>
                                                <c:otherwise>
                                                    ${applicationDetails.monthlyLimit}
                                                </c:otherwise>
                                            </c:choose>


                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="card text-white bg-fed mb-3">
                            <div class="card-header font-weight-bold">Corporate</div>
                            <div class="card-body bg-white text-dark">
                                <div class="container">
                                    <div class="row row-info">
                                        <div class="col-3 font-weight-bold">
                                            Preferred Corporate ID :
                                        </div>
                                        <div class="col">

                                            ${applicationDetails.prefCorp}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="card text-white bg-fed mb-3">
                            <div class="card-header font-weight-bold">Branch Verification</div>
                            <div class="card-body bg-white text-dark">
                                <div class="container">
                                    <div class="row row-info">
                                        <div class="col-7 font-weight-bold">
                                            Mode of Operation :
                                        </div>
                                        <div class="col">

                                            <c:choose>
                                                <c:when test="${applicationDetails.modeOfOperation eq null}">
                                                </c:when>
                                                <c:otherwise>
                                                    ${applicationDetails.modeOfOperation}
                                                </c:otherwise>
                                            </c:choose>



                                        </div>
                                    </div>
                                    <div class="row row-info">
                                        <div class="col-7 font-weight-bold">
                                            Signed application form obtained and verified :
                                        </div>
                                        <div class="col">

                                            <c:choose>
                                                <c:when test="${applicationDetails.boardResolutionConfirmed eq 0}">

                                                </c:when>
                                                <c:otherwise>
                                                    true
                                                </c:otherwise>
                                            </c:choose>

                                        </div>
                                    </div>
                                    <div class="row row-info">
                                        <div class="col-7 font-weight-bold">

                                            <c:choose>
                                                <c:when test="${applicationDetails.modeOfOperation eq null || applicationDetails.modeOfOperation eq 'Joint'}">
                                                    Mode of Operation and rules for Account operation details confirmed
                                                    :
                                                </c:when>
                                                <c:otherwise>
                                                    In case of an entity with joint holders, Branch confirms that only
                                                    the Propreitor is authorised to use this facility and is added as
                                                    the sole user :
                                                </c:otherwise>
                                            </c:choose>


                                        </div>
                                        <div class="col">

                                            <c:choose>
                                                <c:when test="${applicationDetails.modeOfOperationConfirmed eq 0}">

                                                </c:when>
                                                <c:otherwise>
                                                    true
                                                </c:otherwise>
                                            </c:choose>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="card text-white bg-fed mb-3">
                            <div class="card-header font-weight-bold">Mandatory Documents</div>
                            <div class="card-body bg-white text-dark">
                                <div class="container">

                                    <c:forEach var="document" items="${documents}">


                                        <div class="row row-info">
                                            <a target="_blank" href="fedservice/api/services/getFile/${document.filenetId}/SECURED">View
                                                Attachment</a>
                                            <div class="col-3 font-weight-bold">
                                                Type of Document :
                                            </div>
                                            <div class="col">
                                                <c:if test="${not empty document.documentType}">
                                                    ${document.documentType}
                                                </c:if>
                                            </div>
                                            <div class="row">
                                                <div class="col-auto mr-auto">
                                                    <span class="badge badge-primary">
                                                        <fmt:formatDate value="${document.createdAt}" pattern="MMMM dd, YYYY hh:mm a" />
                                                    </span>
                                                </div>
                                            </div>
                                        </div>

                                    </c:forEach>

                                </div>
                            </div>
                        </div>

                        <div class="card text-white bg-fed mb-3">
                            <div class="card-header font-weight-bold">Cooling Period</div>
                            <div class="card-body bg-white text-dark">
                                <div class="container">
                                    <div class="row row-info">
                                        <div class="col-4 font-weight-bold">
                                            Cooling Period for Beneficiary:
                                        </div>
                                        <div class="col" id="_days">
                                            <script>ConvertMinutes('${applicationDetails.coolingPeriod}');</script>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="card text-white bg-fed mb-3">
                            <div class="card-header font-weight-bold">Set Rules for Account Operation</div>
                            <div class="card-body bg-white text-dark">
                                <div class="container">
                                    <div class="row row-info">
                                        <div class="well well-sm">
                                            <em>
                                                <mark>
                                                    Please note that only number of authorizers required need to be
                                                    entered
                                                    i.e in case of Single Operation, No of authorizers required would
                                                    be '0'
                                                    in case of Joint Operation by two users, No of authorizers required
                                                    would be '1'
                                                    in case of Joint Operation by three users, No of authorizers
                                                    required would be '2'
                                                </mark>
                                            </em>
                                        </div>
                                    </div>
                                    <div class="row row-info">
                                        <div class="col-6 font-weight-bold">
                                            No of users to authorize fund transfer :
                                        </div>
                                        <div class="col">

                                            <c:choose>
                                                <c:when test="${applicationDetails.authFund eq null  }">
                                                </c:when>
                                                <c:otherwise>
                                                    ${applicationDetails.authFund}
                                                </c:otherwise>
                                            </c:choose>


                                        </div>
                                    </div>
                                    <div class="row row-info">
                                        <div class="col-6 font-weight-bold">
                                            No of users to authorize add external user :
                                        </div>
                                        <div class="col">

                                            <c:choose>
                                                <c:when test="${applicationDetails.authExt eq null  }">

                                                </c:when>
                                                <c:otherwise>
                                                    ${applicationDetails.authExt}
                                                </c:otherwise>
                                            </c:choose>


                                        </div>
                                    </div>
                                    <div class="row row-info">
                                        <div class="col-6 font-weight-bold">
                                            No of users to authorize add beneficiary :
                                        </div>
                                        <div class="col">
                                            <c:choose>
                                                <c:when test="${applicationDetails.authBen eq null  }">

                                                </c:when>
                                                <c:otherwise>
                                                    ${applicationDetails.authBen}
                                                </c:otherwise>
                                            </c:choose>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="card text-white bg-fed mb-3">
                            <div class="card-header font-weight-bold">Remarks/Recommendations</div>
                            <div class="card-body bg-white text-dark">
                                <div class="container">
                                    <div class="row row-info">
                                        <div class="col">


                                            <c:if test="${not empty  applicationDetails.declaration}">
                                                ${applicationDetails.declaration}
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="card text-white bg-fed mb-3">
                            <div class="card-header font-weight-bold">Reference</div>
                            <div class="card-body bg-white text-dark">
                                <div class="container">
                                    <div class="row row-info">
                                        <div class="col">




                                            <c:if test="${not empty  applicationDetails.referenceId}">
                                                ${applicationDetails.referenceId}
                                            </c:if>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        
                        <div class="card text-white bg-fed mb-3">
                        <div class="card-header font-weight-bold">Comments</div>
                        <div class="card-body bg-white text-dark">
                          <div class="container">
                            <div class="row">
                              <div class="col-lg-10 col-md-4">
                                <div class="comment-container">
                                
                                <c:forEach var="comment" items="${comments}">
                                <div class="alert alert-success text-dark" role="alert">
                                    ${comment.addedBy}.<sup>
                                        <fmt:formatDate value="${comment.createdAt}" pattern="MMMM dd, YYYY hh:mm a" />
                                    </sup><br>
                                    <strong>${comment.body}</strong>
                                </div>

                            </c:forEach>

                      </div>
                              </div>
                            </div>
                            <div class="row">
                              <div class="col-lg-10 col-md-4">
                                <form class="new_comment" id="new_comment" action="addcomments" accept-charset="UTF-8"  method="post">
                                <input name="utf8" type="hidden" value="">

                          <div class="form-group">
                            <textarea class="form-control border border-primary" required="required" maxlength="200" name="body" id="comment_body"></textarea>
                          </div>
                          <input type="hidden" name="added_by" id="comment_added_by">
                          <input type="hidden" name="page" id="comment_page_by" value="FinalNewApp">
                          <input type="hidden" value="${applicationDetails.id}" name="application_form_id" id="comment_application_form_id">

                            <input type="submit" name="commit" value="Add Comment" class="btn btn-primary" data-disable-with="Add Comment">
                      </form>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        

              




                        <div class="card text-white bg-fed mb-3">
                            <div class="card-body bg-white text-dark">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-auto mr-auto">
                                            <c:if test="${not empty  applicationDetails.applnFormCreatedAt}">
                                                <span class="badge badge-secondary">Added By :<c:if test="${not empty  applicationDetails.createdBy}">${applicationDetails.createdBy}
                                                    </c:if> </span>
                                                <span class="badge badge-primary">
                                                    <fmt:formatDate value="${applicationDetails.applnFormCreatedAt}" pattern="MMMM dd, YYYY hh:mm a" />
                                                </span>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-auto mr-auto">
                                            <c:if test="${not empty  applicationDetails.forwardedAt}">

                                                <span class="badge badge-secondary">Forwarded By :
                                                    ${applicationDetails.forwardedBy}</span>
                                                <span class="badge badge-primary">
                                                    <fmt:formatDate value="${applicationDetails.forwardedAt}" pattern="MMMM dd, YYYY hh:mm a" />
                                                </span>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-auto mr-auto">
                                            <c:if test="${not empty  applicationDetails.resubmittedAt}">

                                                <span class="badge badge-danger">Resubmitted By
                                                    :${applicationDetails.resubmittedBy} </span>
                                                <span class="badge badge-primary">
                                                    <fmt:formatDate value="${applicationDetails.resubmittedAt}" pattern="MMMM dd, YYYY hh:mm a" /></span>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-auto mr-auto">
                                            <c:if test="${not empty  applicationDetails.rejectedAt}">

                                                <span class="badge badge-secondary">Rejected By :
                                                    ${applicationDetails.rejectedBy} </span>
                                                <span class="badge badge-primary">
                                                    <fmt:formatDate value="${applicationDetails.rejectedAt}" pattern="MMMM dd, YYYY hh:mm a" /></span>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-auto mr-auto">
                                            <c:if test="${not empty  applicationDetails.approvedAt}">

                                                <span class="badge badge-success">Approved By
                                                    :${applicationDetails.approvedBy} </span>
                                                <span class="badge badge-primary">
                                                    <fmt:formatDate value="${applicationDetails.approvedAt}" pattern="MMMM dd, YYYY hh:mm a" /></span>
                                            </c:if>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                        <div class="card-body bg-white text-dark">
                        <div class="container">
                             <div class="row ">
                               <div class="col-sm">
                                 <a class="btn btn-warning btn-block font-weight-bold" data-toggle="modal"  data-target="#exampleModal" data-whatever="${applicationDetails.id}" id="resubmit" data-confirm="Are you sure?" data-remote="true"  data-method="post" href="">Resubmit</a>
                               </div>
                               <div class="col-sm">
                               <form action="applicationapprove" accept-charset="UTF-8" method="post">
                               <input type="hidden" name="appid" id="applnformid" value="${applicationDetails.id}">
                               <input type="hidden" name="custNo" id="cust_no" value="${applicationDetails.custNo}">
                               <input type="hidden" name="accNo" id="acc_no" value="${applicationDetails.accNo}"> 
                               <input type="hidden" name="userSession" id="loginname" value="${login_users.userSession}">
                               <input type="hidden" name="accName" id="acc_name" value="${applicationDetails.accName}">  
                               <input type="hidden" name="prefCorp" id="pref_corp" value="${applicationDetails.prefCorp}"> 
                               <input type="hidden" name="address" id="address" value="${applicationDetails.address}"> 
                               <input type="hidden" name="constitution" id="constitution" value="${applicationDetails.constitution}"> 
                               <input type="hidden" name="authFund" id="auth_fund" value="${applicationDetails.authFund}">
                               <input type="hidden" name="authBen" id="auth_ben" value="${applicationDetails.authBen}"> 
                               <input type="hidden" name="authExt" id="auth_ext" value="${applicationDetails.authExt}">                 
                               <input type="hidden" name="id" id="entid" value="${applicationDetails.applnEnterprisesId}">
                               <input type="hidden" name="dailyLimit" id="dailylimit" value="${applicationDetails.dailyLimit}">
                               <input type="hidden" name="monthlyLimit" id="monthlimit" value="${applicationDetails.monthlyLimit}">
                               <button type="submit" class="btn btn-primary btn-block font-weight-bold" data-confirm="Are you sure?" rel="nofollow" value="Submit">Approve</button>
                               </form>
                               </div>
                               <div class="col-sm">
                                 <a class="btn btn-danger btn-block font-weight-bold" data-toggle="modal"  data-target="#exampleModal" data-whatever="${applicationDetails.id}" id="delete1" data-confirm="Are you sure?" data-remote="true"  data-method="post" href="">Reject</a>
                               </div>
                             </div>
                        </div>
                    </div>

                        <a class="btn btn-lg btn btn-secondary" href="pendfinalappv">
                            <i class="fa fa-arrow-left"></i>&nbsp;&nbsp;Back
                        </a>
                    </div>
                </div>
            
            </main>
        </div>
        
    </div>
    <script>



     $(document).on('click','#delete1',function (e) {
            var vpaid = $('#applnformid').val();
           thisdata = $(this).attr('data-whatever');            
            if(vpaid){
                $.ajax({
                    type:'POST',
                    url:'rejectappln',
                    data:'appid='+thisdata,
                    success:function(html){
                        $('#modal-content').html(html); 
                        setTimeout(function(){  window.location.href = 'rejectedlist'; }, 3000);                                 
                    }
                }); 
            }else{            
            $('#modal-content').html('');
            setTimeout("window.open(self.location, '_self');", 3000);
            }
            
        });
        
        
        $(document).on('click','#resubmit',function (e) {   	
    	if (document.getElementById('comment_body').value=="" || document.getElementById('comment_body').value==undefined)
	    {
            alert ("Please Enter a Comment");
             $('#modal-content').html('');
             window.location.reload();
             return false;
        }
           var vpaid = $('#applnformid').val();    
           thisdata = $(this).attr('data-whatever');
            if(vpaid){
                $.ajax({
                    type:'POST',
                    url:'resubmitappln',
                    data:'appid='+thisdata,
                    success:function(html){  
                  $('#modal-content').html(html);  
                  setTimeout(function(){  window.location.href = 'homepage'; }, 3000);
                                        
                    }
                }); 
            }else{      
            $('#modal-content').html('');
            setTimeout("window.open(self.location, '_self');", 3000);
            }
            
        });
        
    </script>
</body>

</html>