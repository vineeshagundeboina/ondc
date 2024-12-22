	<c:choose>
	<c:when test="${refNo ne ''}">
		<script>
		   var v ="${refNo}"; 
			 alert_box("danger", "Application Form Ref No ."+v+" Rejected Successfully.");
			 $('#errorclose').click(function(){
				 window.location.reload();
				   
		     })
		</script>
	</c:when>
	
	<c:otherwise>
		<script>	
		 alert_box("danger", "Something Went Wrong, try again later.");	
		 $('#errorclose').click(function(){
			 window.location.reload();
			   
	     })
		</script>
	</c:otherwise>
	</c:choose>
