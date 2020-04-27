$(document).ready(function() {
	var max_fields = 15; // maximum input boxes allowed
	/*var wrapper = $(".dynamicAddingAddress"); */// Fields wrapper
	var wrapper = $("#example1"); 
	var add_button = $("#r-btnAdd"); // Add button ID
	var x = 1; // initlal text box count
	$("#r-btnAdd").click(function(e){ // on add input button click
		e.preventDefault();
		if(x < max_fields){ // max input box allowed
			x++; // text box increment
			$(wrapper).append('<div class="r-group" id="repeater"><label for="address_0_0" class="col-form-label text-md-left" data-pattern-text="Address +=1:">Address :</label><textarea id="user_0_address" class="form-control" data-pattern-id="user_++_address" name="address"></textarea><div class="row"><div class="col-md-6"><label for="city_0_0" class="col-form-label text-md-left" data-pattern-text="City +=1:">City :</label> <input type="text" id="user_0_city" class="form-control" data-pattern-id="user_++_city" name="city" /> </div><div class="col-md-6"><label for="address_0_0" class="col-form-label text-md-left" data-pattern-text="State +=1:">State :</label> <input type="text" id="user_0_state" class="form-control" data-pattern-id="user_++_state" name="state" /> </div></div><label for="address_0_0" class="col-form-label text-md-left" data-pattern-text="Coutnry +=1:">Country :</label> <input type="text" id="user_0_country" class="form-control" data-pattern-id="user_++_country" name="country" /> <br /><div class="text-center"><button type="button" class="r-btnRemove btn btn-danger" id="r-BTNREMOVE"><span class="fa fa-minus-circle" style="font-size: 30px;"></span></button><input type="hidden" id="custId" name="addID" value="555"></div></div>');                                            
		}
	});

	$(document).on("click","#r-BTNREMOVE", function(e){// user click on remove text
		e.preventDefault(); 
		//$(this).parent('div').remove();
		$(this).closest('#repeater').remove();
		x--;
	});

});

//<div id="example1" class="form-group"><div class="r-group"><label for="address_0_0" class="col-form-label text-md-left" data-pattern-text="Address +=1:">Address</label><textarea id="user_0_address" class="form-control" data-pattern-id="user_++_address" name="address"></textarea><div class="row"><div class="col-md-6"><label for="city_0_0" class="col-form-label text-md-left" data-pattern-text="City +=1:">City</label> <input type="text" id="user_0_city" class="form-control" data-pattern-id="user_++_city" name="city" /> </div><div class="col-md-6"><label for="address_0_0" class="col-form-label text-md-left" data-pattern-text="State +=1:">State</label> <input type="text" id="user_0_state" class="form-control" data-pattern-id="user_++_state" name="state" /> </div></div><label for="address_0_0" class="col-form-label text-md-left" data-pattern-text="Coutnry +=1:">Country:</label> <input type="text" id="user_0_country" class="form-control" data-pattern-id="user_++_country" name="country" /> <br /><div class="text-center"><button type="button" class="r-btnRemove btn btn-danger"><span class="fa fa-minus-circle" style="font-size: 30px;"></span></button></div><input type="hidden" id="custId" name="addID" value="${empty address  ?  0 : list[4]}"><input type="hidden" name="id" value="${user.id}"></div></div>




