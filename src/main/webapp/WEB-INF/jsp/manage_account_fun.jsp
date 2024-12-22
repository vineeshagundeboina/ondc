
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ page isELIgnored="false"%>
<c:choose>
    <c:when test="${not empty managedAccounts}">
        <script>
            alert_box("success", "Account list updated successfully.");
        </script>
    </c:when>

    <c:otherwise>
        <script>
            alert_box("danger", "Atleast one account should be selected.");
        </script>

    </c:otherwise>
</c:choose>