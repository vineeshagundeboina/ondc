<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



    <link href="./resources/assets/stylesheets/main.css" rel="stylesheet" media="all">
    <script src="./resources/assets/javascripts/custom.js"></script>
    <link href="./resources/assets/stylesheets/font-awesome.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ page isELIgnored="false"%>

    <title>FedmobileSmeAdminWeb</title>
    <meta name="csrf-param" content="authenticity_token">
    <meta name="csrf-token" content="oODL2UUmGbNrRWHcIfMcxP+K1R+hP3AHr1jBIBGL0mj1xkUt69m6RBemwxi17EkKv93N3D3zqraXM3/KZ2HcBA==">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>

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

<body class="bg-light">

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

            	
                <c:if test="${not empty action && action eq 'gentkn'}">
                <script>
                 alert_box("success","A new Registration Token has been sent to user via SMS.");
                </script>
                </c:if>

                <c:if test="${not empty action && action eq 'forgot'}">
                <script>

                 alert_box("success","SMS sent successfully.");

                </script>
                </c:if>


                <c:if test="${not empty action && action eq 'unblock'}">
                <script>
                 alert_box("success","User is activated.");
                </script>
                </c:if>

                <c:if test="${not empty action && action eq 'failed'}">
                <script>
                 alert_box("danger","Something went Wrong.try again later");
                </script>
                </c:if>
                <c:if test="${not empty action && action eq 'web_unblock'}">
                <script>
                alert_box("success", "Web User is activated successfully.");
                </script>
                </c:if>

              
                <div class="">
                    <div class="col-sm-12">
                        <div class="card mb-3 text-left">
                            <div class="card-header border-dark bg-info font-weight-bold">
                                ${applnUsers.userName}
                            </div>
                            <div class="card-body">
                                <div class="container">
                                    <div class="row row-info">
                                        <div class="col-5 font-weight-bold">
                                            User ID :
                                        </div>
                                        <div>
                                            ${applnUsers.prefNo}
                                        </div>
                                    </div>
                                    <div class="row row-info">
                                        <div class="col-5 font-weight-bold">
                                            Customer ID :
                                        </div>
                                        <div>

                                            ${applnUsers.custNo}
                                        </div>
                                    </div>
                                    <div class="row row-info">
                                        <div class="col-5 font-weight-bold">
                                            Mobile :
                                        </div>
                                        <div>

                                            ${applnUsers.mobile}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card text-white bg-fed mb-3">
                        <div class="card-header font-weight-bold">Manage Account List for</div>
                        <div class="card-body bg-white text-dark">
                            <div class="container">
                                <div class="">
                                    <form action="accountList" accept-charset="UTF-8"
                                        method="post">
                                        <input name="utf8" type="hidden" value="">
                                        <input type="hidden" name="authenticity_token"  value="tO7sWrmnENqlBvHTdkV602Kgx+wHWb+4xJjs8Vn8Q7hhjLktvg0IZxxyBjxqd/XJn1VaOAmS+CdDxOJphHTClA==">
                                        <div class="form-group">
                                            <ul class="checkbox-grid">
                                           
                                                <c:forEach items="${result2}" var="results"  >


                                                    <c:if test="${not empty results}">
                                                    	<li>
                                                            <div class="checkbox">
                                                                <label class="checkbox inline">
                                                                <input type="checkbox"   name="account" value="${results}" checked="">
                                                                    ${results}<br>
                                                                </label>
                                                            </div>
                                                        </li>
                                                    </c:if>
                                                </c:forEach>
                                                <c:forEach items="${result}" var="res">
                                                <li>
                                                <div class="checkbox">
                                                    <label class="checkbox inline">
                                                    	<input type="checkbox" name="account" value="${res}" <c:if test="${res eq applicationEnterprises.accNo && result.size() ==1}">checked=""</c:if> >${res}<br>
                                                    </label>
                                                </div>
                                            </li>
                                        </c:forEach>
                                              

                                            </ul>
                                        </div>
                                        <input type="hidden" name="accNo" value="${applicationEnterprises.accNo}">
                                        <input type="hidden" name="custNo" value="${applnUsers.custNo}">
                                        <input type="hidden" name="applicationFormId" value="${appid}">
                                        <input type="hidden" name="user_id" value="${user.id}">
                                        <input type="hidden" name="prefCorp" value="${applicationEnterprises.prefCorp}">
                                        <input type="hidden" name="prefNo" value="${applnUsers.prefNo}">
                                        <div class="form-group">
                                            <button type="submit" class="btn btn-primary" value="Submit">Update</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container">
					<div class="row">
						<div class="col-sm">
							<form class="button_to" method="post"
								enctype="multipart/form-data"
								action="manageacctfunc">
								<input class="btn btn-sm btn-primary" type="submit"	value="Generate Activation Token">
								<input type="hidden"	name="authenticity_token" value="5IlzB1Q66CtIancErGSK10IQF+w9O7tIMqb4c2dOpB6Haslz2uHfn+Ej4xfern7hoklg5tZhQxKaFFYaADFm4A==">
								<input type="hidden" name="accNo" value="${applicationEnterprises.accNo}">
								<input type="hidden" name="custNo" value="${applnUsers.custNo}">
								<input type="hidden" name="prefCorp" value="${applicationEnterprises.prefCorp}">
								<input type="hidden" name="prefNo" value="${applnUsers.prefNo}">
								<input type="hidden" name="mobile" value="${applnUsers.mobile}">
								<input type="hidden" name="userid" value="${user.id}">
								<input type="hidden" name="action" value="gentkn">
								<input type="hidden" name="applicationFormId" value="${appid}">
							</form>
						</div>
						<div class="col-sm">
							<form class="button_to" method="post"
								action="manageacctfunc">
								<input class="btn btn-sm btn-primary" type="submit"
									value="Generate Forgot MPIN Token"><input type="hidden"
									name="authenticity_token"
									value="njScT1gJa8XTVoP/MrkLOUuQtd249HceSntB5uGTnAEQZRSH3zyW9BictLUSjg1ZSmQpZd7zhxrXr1cFxvUTNw==">
								<input type="hidden" name="accNo" value="${applicationEnterprises.accNo}">
								<input type="hidden" name="custNo" value="${applnUsers.custNo}">
								<input type="hidden" name="prefCorp" value="${applicationEnterprises.prefCorp}">
								<input type="hidden" name="prefNo" value="${applnUsers.prefNo}">
								<input type="hidden" name="mobile" value="${applnUsers.mobile}">
								<input type="hidden" name="userid" value="${user.id}">
								<input type="hidden" name="action" value="forgot">
								<input type="hidden" name="applicationFormId" value="${appid}">
							</form>
						</div>
						<div class="col-sm">
							<form class="button_to" method="post"
								action="manageacctfunc">
								<input class="btn btn-sm  btn-primary" type="submit"
									value="Unblock User(Mobile App)"><input type="hidden"
									name="authenticity_token"
									value="Fbua5gq5Tt8caSW1L1PPFoOB9Pvqa6144ap6wACzhE7SytIhvAMK7npPkoU7wcZm2FbyWrwgRX0YMrXGB7p/HA==">
								<input type="hidden" name="accNo" value="${applicationEnterprises.accNo}">
								<input type="hidden" name="custNo" value="${applnUsers.custNo}">
								<input type="hidden" name="prefCorp" value="${applicationEnterprises.prefCorp}">
								<input type="hidden" name="prefNo" value="${applnUsers.prefNo}">
								<input type="hidden" name="mobile" value="${applnUsers.mobile}">
								<input type="hidden" name="userid" value="${user.id}">
								<input type="hidden" name="action" value="unblock">
								<input type="hidden" name="applicationFormId" value="${appid}">
							</form>
						</div>

						<div class="col-sm">
							<form class="button_to" method="post" action="manageacctfunc">
								<input class="btn btn-sm  btn-primary" type="submit"	value="Unblock User(Web App)">
								<input type="hidden" name="authenticity_token"	value="Fbua5gq5Tt8caSW1L1PPFoOB9Pvqa6144ap6wACzhE7SytIhvAMK7npPkoU7wcZm2FbyWrwgRX0YMrXGB7p/HA==">
								<input type="hidden" name="accNo" value="${applicationEnterprises.accNo}">
								<input type="hidden" name="custNo" value="${applnUsers.custNo}">
								<input type="hidden" name="prefCorp" value="${applicationEnterprises.prefCorp}">
								<input type="hidden" name="prefNo" value="${applnUsers.prefNo}">
								<input type="hidden" name="mobile" value="${applnUsers.mobile}">
								<input type="hidden" name="userid" value="${user.id}">
								<input type="hidden" name="action" value="web_unblock">
								<input type="hidden" name="applicationFormId" value="${appid}">
							</form>
						</div>
					</div>
					<div class="row pt-3">
						<div class="col-sm">
							<form class="button_to">
								<input class="btn btn-sm px-3 btn-primary" name="updateClk" id="updateClick();" onclick="updateClick()" type="button" value="Update Mobile Number">
								<input type="hidden" name="authenticity_token"	value="Fbua5gq5Tt8caSW1L1PPFoOB9Pvqa6144ap6wACzhE7SytIhvAMK7npPkoU7wcZm2FbyWrwgRX0YMrXGB7p/HA==">
								<input type="hidden" name="accNo" id="acc_no" value="${applicationEnterprises.accNo}">
								 <input type="hidden" name="custNo" id="cust_no" value="${applnUsers.custNo}">
								<input type="hidden" name="prefCorp" value="${applicationEnterprises.prefCorp}">
								<input type="hidden" name="prefNo" value="${applnUsers.prefNo}">
								<input type="hidden" name="addedBy" id="addedBy" value="${login_users.userSession}">
								<input type="hidden" name="mobile" id="mobile_no" value="${applnUsers.mobile}">
							</form>
						</div>


					</div>
				</div>
                </div>
            </main>
        </div>
    </div>

    <script src="./resources/assets/javascripts/function.js"></script>

</body>

</html>