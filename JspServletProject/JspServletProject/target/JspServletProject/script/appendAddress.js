$(document).ready(function() {
	
var max_fields = 50; 
	var count = $('#count').val();
	var check = count;
	var wrapper = $("#example1"); 
	var add_button = $("#r-btnAdd"); 
	var x = 1; 
	$("#r-btnAdd").click(function(e){
		e.preventDefault(); 
		console.log(count,"COUNT in add")
		console.log(check,"check in add")
		e.preventDefault();
		if(x < max_fields){ 
			x++; 
			check++;
			count++;
			$(wrapper).append('<div class="r-group" id="repeater"><label for="address_0_0" class="col-form-label text-md-left">Address :</label> <input type="text" id="user_'+count+'_address" class="form-control" name="address" onblur="inputaddress('+count+')" onfocus="resetAddress('+count+')"><br> <span class="error" id="saddress'+count+'"></span><div class="row"><div class="col-md-6"><label for="city_0_0" class="col-form-label text-md-left">City :</label> <input type="text" id="user_'+count+'_city" class="form-control" name="city" onblur="inputcity('+count+')" onfocus="resetCity('+count+')"/> <br><span class="error" id="scity'+count+'"></span></div><div class="col-md-6"><label for="state_0_0" class="col-form-label text-md-left">State :</label> <input type="text" id="user_'+count+'_state" class="form-control" name="state" onblur="inputstate('+count+')" onfocus="resetState('+count+')"/> <br><span class="error" id="sstate'+count+'"></span></div></div><label for="country_0_0" class="col-form-label text-md-left">Country :</label> <input type="text" id="user_'+count+'_country" class="form-control" name="country" onblur="inputcountry('+count+')" onfocus="resetCountry('+count+')"/> <br><span class="error" id="scountry'+count+'"></span><br /><div class="text-center"><button type="button" class="r-btnRemove btn btn-danger" id="r-BTNREMOVE"><span class="fa fa-minus-circle" style="font-size: 30px;"></span></button></div><input type="hidden" id="custId" name="addID" value="555"><input type="hidden" name="id" value="${user.id}"><input type="hidden" id="count" value="'+count+'"></div>');
		}
	});

	$(document).on("click","#r-BTNREMOVE", function(e){
		e.preventDefault(); 		
		console.log(count,"COUNT in remove")
		console.log(check,"check in remove")
		if(check == 1){
			alert("You Must Keep At Least 1 Address");
		}
		else{
			$(this).closest('#repeater').remove();
			x--;
			check--;
		}
			
	});
	
});

