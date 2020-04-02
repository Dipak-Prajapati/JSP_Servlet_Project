

<!-- Footer -->
<footer class="page-footer font-small blue pt-4 ">

	<div class="footer-copyright text-center py-3">
		� 2020 Copyright: <a href="index.jsp">
			JSP Servlet Project</a>
	</div>
</footer>
<!-- Footer -->


<!-- javascript -->
<script src="script/jquery.js"></script>
<!-- <script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script> -->
<script	src="script/bootstrap.min.js"></script>
<script src="script/validation.js"></script>
<script src="script/fontawesome.min.js"></script>
<script src="script/style.js"></script>
<!-- <script src="script/materialize.min.js"></script> -->
<script>
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
				contentType : false,
			})
		})
	})
</script>


</body>
</html>