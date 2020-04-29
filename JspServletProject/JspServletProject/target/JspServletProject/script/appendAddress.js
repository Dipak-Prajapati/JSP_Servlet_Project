$(document).ready(function() {
	var max_fields = 15; 
	/*var wrapper = $(".dynamicAddingAddress"); */
	//var x = $('#count').val();
	var count = $('#count').val();
	var wrapper = $("#example1"); 
	var add_button = $("#r-btnAdd"); 
	var x = 1; 
	$("#r-btnAdd").click(function(e){ 
		e.preventDefault();
		if(x < max_fields){ 
			x++; 
			count++;
			/*$(wrapper).append('<div class="r-group" id="repeater"><label for="address_0_0" class="col-form-label text-md-left" data-pattern-text="Address +=1:">Address :</label><textarea id="user_0_address" class="form-control" data-pattern-id="user_++_address" name="address"></textarea><div class="row"><div class="col-md-6"><label for="city_0_0" class="col-form-label text-md-left" data-pattern-text="City +=1:">City :</label> <input type="text" id="user_0_city" class="form-control" data-pattern-id="user_++_city" name="city" /> </div><div class="col-md-6"><label for="address_0_0" class="col-form-label text-md-left" data-pattern-text="State +=1:">State :</label> <input type="text" id="user_0_state" class="form-control" data-pattern-id="user_++_state" name="state" /> </div></div><label for="address_0_0" class="col-form-label text-md-left" data-pattern-text="Coutnry +=1:">Country :</label> <input type="text" id="user_0_country" class="form-control" data-pattern-id="user_++_country" name="country" /> <br /><div class="text-center"><button type="button" class="r-btnRemove btn btn-danger" id="r-BTNREMOVE"><span class="fa fa-minus-circle" style="font-size: 30px;"></span></button><input type="hidden" id="custId" name="addID" value="555"></div></div>');*/
			$(wrapper).append('<div class="r-group" id="repeater"><label for="address_0_0" class="col-form-label text-md-left">Address :</label> <input type="text" id="user_'+count+'_address" class="form-control" name="address" ><br> <span class="error" id="saddress'+count+'"></span><div class="row"><div class="col-md-6"><label for="city_0_0" class="col-form-label text-md-left">City :</label> <input	type="text" id="user_'+count+'_city" class="form-control" name="city" /> <br><span class="error" id="scity'+count+'"></span></div><div class="col-md-6"><label for="state_0_0" class="col-form-label text-md-left">State :</label> <input type="text" id="user_'+count+'_state" class="form-control" name="state" /> <br><span class="error" id="sstate'+count+'"></span></div></div><label for="country_0_0" class="col-form-label text-md-left">Country :</label> <input type="text" id="user_'+count+'_country" class="form-control" name="country" /> <br><span class="error" id="scountry'+count+'"></span><br /><div class="text-center"><button type="button" class="r-btnRemove btn btn-danger" id="r-BTNREMOVE"><span class="fa fa-minus-circle" style="font-size: 30px;"></span></button></div><input type="hidden" id="custId" name="addID" value="555"><input type="hidden" name="id" value="${user.id}"><input type="hidden" id="count" value="'+count+'"></div>');
		}
	});

	$(document).on("click","#r-BTNREMOVE", function(e){
		e.preventDefault(); 
		//$(this).parent('div').remove();
		if(count == 1){
			alert("You Must Keep At Least 1 Address");
		}
		else{
			$(this).closest('#repeater').remove();
			x--;
			count--;
		}
			
	});
	
});

//<div id="example1" class="form-group"><div class="r-group"><label for="address_0_0" class="col-form-label text-md-left" data-pattern-text="Address +=1:">Address</label><textarea id="user_0_address" class="form-control" data-pattern-id="user_++_address" name="address"></textarea><div class="row"><div class="col-md-6"><label for="city_0_0" class="col-form-label text-md-left" data-pattern-text="City +=1:">City</label> <input type="text" id="user_0_city" class="form-control" data-pattern-id="user_++_city" name="city" /> </div><div class="col-md-6"><label for="address_0_0" class="col-form-label text-md-left" data-pattern-text="State +=1:">State</label> <input type="text" id="user_0_state" class="form-control" data-pattern-id="user_++_state" name="state" /> </div></div><label for="address_0_0" class="col-form-label text-md-left" data-pattern-text="Coutnry +=1:">Country:</label> <input type="text" id="user_0_country" class="form-control" data-pattern-id="user_++_country" name="country" /> <br /><div class="text-center"><button type="button" class="r-btnRemove btn btn-danger"><span class="fa fa-minus-circle" style="font-size: 30px;"></span></button></div><input type="hidden" id="custId" name="addID" value="${empty address  ?  0 : list[4]}"><input type="hidden" name="id" value="${user.id}"></div></div>

/*<div class="r-group" id="repeater"><label for="address_0_0" class="col-form-label text-md-left">Address :</label> <input type="text" id="user_${count}_address" class="form-control" name="address" value="${fn:escapeXml(param.address)}"><br> <span class="error" id="saddress${count}">${sessionScope.address}</span><div class="row"><div class="col-md-6"><label for="city_0_0" class="col-form-label text-md-left" data-pattern-text="City +=1:">City :</label> <input	type="text" id="user_${count}_city" class="form-control" name="city" value="${fn:escapeXml(param.city)}" /> <br><span class="error" id="scity${count}">${sessionScope.city}</span></div><div class="col-md-6"><label for="state_0_0" class="col-form-label text-md-left">State :</label> <input type="text" id="user_${count}_state" class="form-control" name="state" value="${fn:escapeXml(param.state)}" /> <br><span class="error" id="sstate${count}">${sessionScope.state}</span></div></div><label for="country_0_0" class="col-form-label text-md-left">Country :</label> <input type="text" id="user_${count}_country" class="form-control" name="country" value="${fn:escapeXml(param.country)}" /> <br><span class="error" id="scountry${count}">${sessionScope.country}</span><br /><div class="text-center"><button type="button" class="r-btnRemove btn btn-danger" id="r-BTNREMOVE"><span class="fa fa-minus-circle" style="font-size: 30px;"></span></button></div><input type="hidden" id="custId" name="addID" value="555"><input type="hidden" name="id" value="${user.id}"><c:set var="count" value="${count+1}" scope="page" /></div>*/



