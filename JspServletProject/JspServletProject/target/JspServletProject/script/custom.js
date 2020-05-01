
// Delete user from admin
$("[id^=delete]").click(function() {
	//alert("Delete Button Clicked");
	var btnValue = $(this).val();

	var dataTable = $('#adminDataTable').DataTable();
	dataTable.row($(this).closest("tr")).remove();
	$(this).closest("tr").remove();

	$.ajax({
		url : "DeleteUser",
		type : "POST",
		data : {
			operation : "deleteUser",
			userId : $(this).val()
		},
		success : function(data) {
			var dataTable = $('#adminDataTable').DataTable();
			dataTable.draw();
			alert(data);
		},
		error : function(data) {
			alert("error");
		}
	});
});
