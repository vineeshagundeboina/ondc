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
    <%@ page isELIgnored="false"%>
</head>

<body class="bg-light">
<c:if test="${sessionScope.logindetails.userSession}">
<c:redirect url="login"/>
</c:if>
    <%@ include file="header.jsp" %>

    <div class="container-fluid">
        <div class="row">

            <%@ include file="slider.jsp" %>

            <main role="main" class="col-md-9 col-sm-9 col-xs-12">
                <div class="modal" id="alert-box" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header text-white">
                                <h5 class="modal-title"><i class="fa" aria-hidden="true"></i> &nbsp;Alert</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <p class="modal-data"></p>
                            </div>

                        </div>
                    </div>
                </div>



          
                <div class="">
                    <div class="content-application-form zero_padding">
                        <div class="search_box bg-light">
                            <span class="text-xl-right">
                                <a class="font-weight-bold" data-toggle="collapse" href="#collapseSearch" aria-expanded="false"
                                    aria-controls="collapseSearch">
                                    Filter
                                </a>
                            </span>
                            <div class="collapse" id="collapseSearch">
                                <%@ include file="searchview.jsp" %>
                            </div>
                        </div>

                    </div>

                    <div class="content-application-form">
                        <div class="data-container">
                            <div class="container">
                                <div class="elements">
                                    <div class="row header tr">
                                        <div class="col-4 col-md-2 col">Ref:</div>
                                        <div class="col-6 col-md-4 col">Name</div>
                                        <div class="col-4 col-md-2 col">Account No.</div>
                                    </div>
                                </div>
                                <c:forEach var="record" items="${rejectedApplication}">

                                    <div class="elements data-row row-23771">
                                        <div class="row tr">
                                            <div class="col-4 col-md-2 col ifo"> ${record.refNo}</div>

                                            <div class="col-6 col-md-4 col"> ${record.accName}</div>
                                            <div class="col-4 col-md-2 col"> ${record.accNo}</div>
                                            <div class="col-1 col-md-1 col">
                                                <form id="rejectedapplnviewform${record.id}" method="post" action="reject-application">
                                                    <input type="hidden" name="applnformid" value="${record.id}">
                                                    <button class="btn btn-info"   type="submit">View</button>
                                                </form>
                                               
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-auto mr-auto">
                                                <span class="badge badge-secondary">Added By : <c:if test="${not empty  record.createdBy}">${record.createdBy}</c:if></span>
                                                <c:if test="${not empty  record.forwardedBy}">
                                                    <span class="badge badge-secondary">Forwarded By :
                                                        ${record.forwardedBy}</span>
                                                </c:if>
                                                <c:if test="${not empty  record.rejectedBy}">
                                                    <span class="badge badge-danger">Rejected By : ${record.rejectedBy}</span>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>

                                </c:forEach>

                                <div class="row justify-content-md-center">


                                    <div class="pagination" style="margin-top:3%">
                                    </div>

                                </div>
                            </div>

                        </div>
                    </div>




                </div>
            </main>
        </div>
    </div>

    <script>

        function getPageList(totalPages, page, maxLength) {
            if (maxLength < 5) throw "maxLength must be at least 5";

            function range(start, end) {
                return Array.from(Array(end - start + 1), (_, i) => i + start);
            }

            var sideWidth = maxLength < 9 ? 1 : 2;
            var leftWidth = (maxLength - sideWidth * 2 - 3) >> 1;
            var rightWidth = (maxLength - sideWidth * 2 - 2) >> 1;
            if (totalPages <= maxLength) {
                // no breaks in list
                return range(1, totalPages);
            }
            if (page <= maxLength - sideWidth - 1 - rightWidth) {
                // no break on left of page
                return range(1, maxLength - sideWidth - 1)
                    .concat(0, range(totalPages - sideWidth + 1, totalPages));
            }
            if (page >= totalPages - sideWidth - 1 - rightWidth) {
                // no break on right of page
                return range(1, sideWidth)
                    .concat(0, range(totalPages - sideWidth - 1 - rightWidth - leftWidth, totalPages));
            }
            // Breaks on both sides
            return range(1, sideWidth)
                .concat(0, range(page - leftWidth, page + rightWidth),
                    0, range(totalPages - sideWidth + 1, totalPages));
        }

        // Below is an example use of the above function.
        $(function () {
            // Number of items and limits the number of items per page
            var numberOfItems = $(".row-23771").length;
            var limitPerPage = 10;
            // Total pages rounded upwards
            var totalPages = Math.ceil(numberOfItems / limitPerPage);
            // Number of buttons at the top, not counting prev/next,
            // but including the dotted buttons.
            // Must be at least 5:
            var paginationSize = 7;
            var currentPage;

            function showPage(whichPage) {
                if (whichPage < 1 || whichPage > totalPages) return false;
                currentPage = whichPage;
                $(".row-23771").hide()
                    .slice((currentPage - 1) * limitPerPage,
                        currentPage * limitPerPage).show();
                // Replace the navigation items (not prev/next):            
                $(".pagination li").slice(1, -1).remove();
                getPageList(totalPages, currentPage, paginationSize).forEach(item => {
                    $("<li>").addClass("page-item")
                        .addClass(item ? "current-page" : "disabled")
                        .toggleClass("active", item === currentPage).append(
                            $("<a>").addClass("page-link").attr({
                                href: "javascript:void(0)"
                            }).text(item || "...")
                        ).insertBefore("#next-page");
                });
                // Disable prev/next when at first/last page:
                $("#previous-page").toggleClass("disabled", currentPage === 1);
                $("#next-page").toggleClass("disabled", currentPage === totalPages);
                return true;
            }
            if (numberOfItems > 10) {
                // Include the prev/next buttons:
                $(".pagination").append(
                    $("<li>").addClass("page-item").attr({ id: "previous-page" }).append(
                        $("<a>").addClass("page-link").attr({
                            href: "javascript:void(0)"
                        }).text("Prev")
                    ),
                    $("<li>").addClass("page-item").attr({ id: "next-page" }).append(
                        $("<a>").addClass("page-link").attr({
                            href: "javascript:void(0)"
                        }).text("Next")
                    )
                );
            }
            // Show the page links
            $(".row-23771").show();
            showPage(1);

            // Use event delegation, as these items are recreated later    
            $(document).on("click", ".pagination li.current-page:not(.active)", function () {
                return showPage(+$(this).text());
            });
            $("#next-page").on("click", function () {
                return showPage(currentPage + 1);
            });

            $("#previous-page").on("click", function () {
                return showPage(currentPage - 1);
            });
        });

    </script>

    <script>
        jQuery(document).ready(function ($) {
            $('select').find('option[value=rejected]').attr('selected', 'selected');
        });
    </script>

</body>

</html>