/**
 * 
 */
// Delete User address
/*
 * $("[id^=deleteAddress]").click(function() {
 * 
 * //event.preventDefault(); //getting button value //var id = $(this).val();
 * 
 * $.ajax({ type : "POST", url : "RegisterController", data : { operation :
 * 'deleteAddress', buttonId : $(this).val() }, success : function(data) {
 * alert(data); location.reload(); }, error : function(data) {
 * alert("ERROR!!!"); } }); return false; });
 */

// add new address
/*$("[id^=r-btnAdd]").click(function() {
	// getting button value 
	var id = $(this).val();

	$.ajax({
		type : "POST",
		url : "RegisterController",
		data : {

			operation : 'newAddress',
			Address : $(".address" + id).val(),
			City : $(".city" + id).val(),
			State : $(".state" + id).val(),
			Country : $(".country" + id).val(),
			userId : id
		},
		success : function(data) {
			alert(data);
			window.location.reload();
		},
		error : function(data) {
			//alert("Something went wrong Please try again");
		}
	});

});*/

// Delete user from admin
/* [id^=delete] */
/* $("#deleteButton").click(function() { */
$("[id^=delete]").click(function() {
	alert("Delete Button Clicked");
	var btnValue = $(this).val();

	// removing the row fromthe datatable
	var dataTable = $('#adminDataTable').DataTable();
	// var roww = dataTable.row($(this).closest("tr")).remove();
	// roww.remove();
	dataTable.row($(this).closest("tr")).remove();
	$(this).closest("tr").remove();

	$.ajax({
		url : "ForgotPassword",
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
