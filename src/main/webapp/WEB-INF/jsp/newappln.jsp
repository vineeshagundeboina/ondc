  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page isELIgnored="false"%>

<c:if test="${not empty addUser}">
    	${addUser}
   </c:if>
   <c:if test="${not empty prefCorpValidate}">
   		${prefCorpValidate}
   </c:if>
   <c:if test="${not empty resp}">
		${resp}
</c:if>
