
<div class="form-group row" id = "addressrow">
	<label class="col-md-2 form-control-label" for="text-input">Address:</label>  
	<div class="col-md-9">
		<input type="text" id="text-input" name="address" class="form-control" placeholder="Street"value="">
	</div> 
	<div class="pull-right repeater-remove-btn rmm">
		<button type = "button" class="btn btn-danger remove-btn">Remove</button> 
	</div>  <label class="col-md-2 form-control-label" for="text-input">Landmark:</label>
	<div class="col-md-9" id="add1">
		<input type="text" id="text-input" name="landmark" class="form-control" placeholder="LandMark" value=""/>
	</div>
	<div class="row" id="row">
		<div class="col-sm" id="fix"> 
			<div id="add2">
				<input type="text" id="text-input" name="city" class="form-control" placeholder="City" value=""/> 
			</div> 
			<div id="add2">
				<input type="text" id="text-input" name="postal" class="form-control" placeholder="PostalCode" value="">
			</div>
		</div> 
		<div class="col-sm" id="fix1"> <div id="add2">
			<input type="text" id="text-input" name="state" class="form-control" placeholder="State" value="" >
		</div> 
		<div id="add2">
			<input type="text" id="text-input" name="country" class="form-control" placeholder="Country"value="">
		</div>
	</div>
</div>
<input type="hidden" id="custId" name="addID" value="${empty address  ?  0 : list[6]}">
<hr>
</div>
