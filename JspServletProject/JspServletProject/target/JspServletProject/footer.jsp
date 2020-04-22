

<!-- Footer -->
<footer class="page-footer font-small blue pt-4 ">

	<div class="footer-copyright text-center py-3">
		© 2020 Copyright: <a href="index.jsp"> JSP Servlet Project</a>
	</div>
</footer>
<!-- Footer -->


<!-- javascript -->
<script src="script/jquery.js"></script>
<script src="script/popper.min.js"></script>
<script src="script/bootstrap.min.js"></script>


<!-- Data Table -->
<script src="script/jquery.dataTables.min.js"></script>
<script src="script/dataTables.bootstrap4.min.js"></script>
<!-- End Of Data Table -->

<script src="script/validation.js"></script>
<script src="script/fontawesome.min.js"></script>
<script src="script/style.js"></script>
<script src="script/jquery.form-repeater.js"></script>
<!-- <script src="script/appendAddress.js"></script> -->
<script src="script/customDatatable.js"></script>
<script src="script/forgotPassword.js"></script>

<script type="text/javascript">
	$('#example1').repeater({
		btnAddClass : 'r-btnAdd',
		btnRemoveClass : 'r-btnRemove',
		groupClass : 'r-group',
		minItems : 1,
		maxItems : 0,
		startingIndex : 0,
		showMinItemsOnLoad : true,
		reindexOnDelete : true,
		repeatMode : 'append',
		animation : 'fade',
		animationSpeed : 400,
		animationEasing : 'swing',
		clearValues : true
	} /* [
	   {
	       "address":"",
	       "city":"",
	       "state":"",
	       "country":""
	   }
	]  */);
</script>
<!-- 
<script type="text/javascript">
	$('#example1').repeater({
		btnAddClass : 'r-btnAdd',
		btnRemoveClass : 'r-btnRemove',
		groupClass : 'r-group',
		minItems : 1,
		maxItems : 0,
		startingIndex : 0,
		showMinItemsOnLoad : true,
		reindexOnDelete : true,
		repeatMode : 'append',
		animation : 'fade',
		animationSpeed : 400,
		animationEasing : 'swing',
		clearValues : true
	}, [ {
		"address[0][name]" : "test"
	}/* , {
		"vehicle[1][name]" : "test2",
		"vehicle[1][type]" : "test2"
	} */ ]);
</script>

 -->


<!-- <script type="text/javascript">
	$('#example1').repeater({
		btnAddClass : 'r-btnAdd',
		btnRemoveClass : 'r-btnRemove',
		groupClass : 'r-group',
		minItems : 1,
		maxItems : 0,
		startingIndex : 0,
		showMinItemsOnLoad : true,
		reindexOnDelete : true,
		repeatMode : 'append',
		animation : 'fade',
		animationSpeed : 400,
		animationEasing : 'swing',
		clearValues : true
	}, [ {
		"address[0]" : "DIPAKKKKKKK"},
		{"address[1]" : "DIPAKKKKKKK11111111"
	} ]);

	$('#example').repeater({
		beforeAdd : function($doppleganger) {
			return $doppleganger;
		},
		afterAdd : function($doppleganger) {
		},
		beforeDelete : function($elem) {
		},
		afterDelete : function() {
		}
	});
</script>
 -->
<!-- <script src="script/materialize.min.js"></script> -->
<!-- <script>
	$(document).ready(function() {
		//alert("helllooo")

		$("#reg").on('submit', function(event) {
			event.preventDefault();

		//	var f = $(this).serialize();
			let f = new FormData(this);
			console.log(f);
			
			$.ajax({
				url : "Registration",
				data : f,
				type : 'POST',
				processData : false,
				success : function(data , textStatus , jqXHR){
					//console.log(data);	
					console.log("success...");
				},
				error : function(jqXHR , textStatus , errorThrown){
					//console.log(data);	
					console.log("Error...");
				} 
				//processData : false,
				//contentType : false,
			})
		})
	})
</script>
 -->

</body>
</html>