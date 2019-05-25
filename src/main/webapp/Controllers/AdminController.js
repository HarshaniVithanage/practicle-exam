/*When adding a new user*/
$(document).on("click", '#btnAddUser', function() {
	
	var result = isAdminFormValidate();
	
	if( result == "true" ){
		$("#formAddUser").submit();
	}else{
		$("#divValidate").html(result);
	}
});

/*validate the admin submit form*/
function isAdminFormValidate(){
	
	if( $.trim($("#username").val() )==""){
		return "Enter Username ";
	}
	
	if( $.trim($("#password").val() )==""){
		return "Enter Password ";
	}
	
	if( $.trim($("#type").val() )==""){
		return "Select the type ";
	}
	
	return true;
}

/*when updating a new user*/
$(document).on("click", '#btnUpdate', function() {
	
	var result = isAdminFormValidate();
	
	if( result == "true" ){
		$("#formUpdateUser").submit();
	}else{
		$("#divValidate").html(result);
	}
});