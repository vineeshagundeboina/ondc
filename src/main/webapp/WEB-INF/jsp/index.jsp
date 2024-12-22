<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FedmobileSmeAdminWeb</title>
    <meta name="csrf-param" content="authenticity_token">
    <meta name="csrf-token" content="JJLPOKgrfKd8H9Szu9kE4pX7OHAirbJosCri+ZcTDn4DYY1PkWiH3slPZ3xy3JuxIXRz99l138zv2GtL1gJ0mw==">
    <link href="./resources/assets/stylesheets/main.css" rel="stylesheet" media="all">
    <script src="./resources/assets/javascripts/custom.js"></script>
    <link href="./resources/assets/stylesheets/font-awesome.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<c:if test="${not empty sessionScope.logindetails.userSession}">
    <c:redirect url="homepage" />
</c:if>

<body class="bg-light">

    <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse bg-blue">
        <a class="navbar-brand mr-0 mr-md-2 text-primary" href="#" aria-label="FedSME Admin Web">
            <img src="./resources/assets/images/logo.png">
        </a>
    </nav>


    <div class="container-fluid">

        <div class="row myRow" style="margin-top:8%;margin-left:38%;">

            <c:choose>
                <c:when test="${message eq 'Access Denied'}">
                    <div class="modal show" id="alert-box" tabindex="-1" role="dialog" style="display: block; padding-right: 17px;">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header text-white bg-danger">
                                    <h5 class="modal-title"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
                                        &nbsp;Alert</h5>
                                    <button type="button" class="close" data-dismiss="modal" id="errorclose"  aria-label="Close">
                                        <span aria-hidden="true">x</span>
                                    </button>
                                </div>
                                <div class="modal-body text-danger">
                                    <p class="modal-data">You are not authorized to access admin web portal.</p>
                                </div>

                            </div>
                        </div>
                    </div>

                    <script>
                        alert_box("danger", "You are not authorized to access admin web portal.");
                        $('#errorclose').click(function(){
                        	window.location.href = "${pageContext.request.contextPath}/";
                      
                        })
                    </script>
                </c:when>
                <c:when test="${message eq 'Session Exp'}">
                    <div class="modal show" id="alert-box" tabindex="-1" role="dialog" style="display: block;">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header text-white bg-danger">
                                    <h5 class="modal-title"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
                                        &nbsp;Alert</h5>
                                    <button type="button" class="close" id="errorclose" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">x</span>
                                    </button>
                                </div>
                                <div class="modal-body text-danger">
                                    <p class="modal-data">Please login to continue</p>
                                </div>

                            </div>
                        </div>
                    </div>
                    <script>
                        alert_box("danger", "Please login to continue");
                    </script>
                </c:when>
                </c:choose>
                <div class="">
                    <div class="content-application-form">
                        <div class="validate-fields">
                            <form id="needs-validation" class="new_application_form" action="logincheck" method="post"
                                novalidate="novalidate" name="auth_signup">
                                <div class="card text-white bg-fed mb-3">
                                    <div class="card-header font-weight-bold required">AD Username</div>
                                    <div class="card-body bg-white text-dark enterprise_form">
                                        <div class="form-group row">
                                            <div class="col-md-12">
                                                <input class="form-control input-lg required"
                                                    data-inputmask-placeholder="" required="required" placeholder="AD Name"
                                                    type="text" name="adusername" id="">

                                            </div>
                                        </div>
                                        <div class="actions">
                                            <input type="submit" name="Submit" value="Login" class="form-control btn btn-primary font-weight-bold">
                                        </div>
                                    </div>

                                </div>

                            </form>
                        </div>
                    </div>
                </div>


        </div>
    </div>
</body>

</html>