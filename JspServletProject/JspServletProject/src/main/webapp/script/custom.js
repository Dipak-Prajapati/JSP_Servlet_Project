/**
 * 
 */
//Delete User address
	$("[id^=deleteAddress]").click(function() {

		//event.preventDefault();
		//getting button value
		//var id = $(this).val();
		
		$.ajax({
			type : "POST",
			url : "RegisterController",
			data : {
				operation : 'deleteAddress',
				buttonId : $(this).val()
			},
			success : function(data) {
				alert(data);
				location.reload();
			},
			error : function(data) {
				alert("ERROR!!!");
			}
		});
		return false;
	});
	