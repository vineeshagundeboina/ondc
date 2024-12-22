function alertfunction(){ 
	alert_box("danger", "You are not authorized to access admin web portal.");
   
}

$('#errorclose').click(function(){
	window.history.back();
});