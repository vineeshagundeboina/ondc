 <div class="menu-box content-application-form">
  <nav class="hidden-xs-down bg-faded sidebar">
    <div class="topmenu" id="v-pills-tab" aria-orientation="vertical">
      <ul class="nav flex-column">
          <li class="for-sm ">
              <a href="homepage">Pending With Branch</a>
          </li>       
          <c:if test="${login_users.officetype eq 'Branch' || (login_users.officetype eq 'Administrative Office' && login_users.depname ne 'OS')}">
          <li class="for-sm ">
            <a href="application-form" class="">Add New Application</a>
          </li>
          </c:if>
          
          <c:if test="${login_users.officetype ne 'Branch'}">

          <li class="for-sm ">
            <a href="pendfinalappv">Pending With Final Approval</a>
          </li>
          </c:if>
          <li class="for-sm ">
            <a href="approvelist">Approved List</a>
          </li>

          <li class="for-sm ">
            <a href="rejectedlist">Rejected List</a>
          </li>
          <c:if test="${login_users.officetype ne 'Branch'}">
          <li class="for-sm ">
            <a href="#" onclick="window.open('https://fedcorp.federalbank.co.in/fedgrievancereport/grievance/grievanceComplaintsAdmin?adname=${login_users.userName}')">Grievances</a>
          </li>
         
          </c:if>       
      </ul>
    </div>
</nav>
</div>

<script>
$(function() {
        var url = window.location.href;
        $(".topmenu a").each(function() {        
            if (url == (this.href)) {
                $(this).closest(".for-sm").addClass("active");
               $(this).closest(".for-sm").parent().parent().addClass("active");
            }
        });
    });
</script>