	<c:choose>
	<c:when test="${refNo ne ''}">
		<script>
		   var v ="${refNo}"; 
			 window.alert_box("warning", "Application Form Re-submitted successfully. <strong>Ref No ."+v+"</strong>");
			 $('#errorclose').click(function(){
				 window.location.href = 'homepage';
				   
		     })
		</script>
	</c:when>
	
	<c:otherwise>
		<script>	
		 alert_box("danger", "Something Went Wrong, try again later.");	
		 $('#errorclose').click(function(){
			 window.location.href = 'homepage';
			   
	     })
		</script>
	</c:otherwise>
	</c:choose>
