/*Forgot Password */

$("#forgotPassword").click(function(event) {
	event.preventDefault();
//	alert("hi");
	$.ajax({
		url : "TestingForgot",
		type : "POST",
		data : {
			operation : "forgotPassword",
			userEmail : $("#email").val()
		},
		success : function(data) {
	//		alert("........");
			$('#password').addClass('alert alert-success font-weight-bold mt-2 mb-0');
			$('#password').text(data);
		},
		error : function(data) {
			$('#password').addClass('alert alert-danger font-weight-bold mt-2 mb-0');
			$('#password').text("ERROR...!!");
		}
	});
	return false;
});
/* }); */