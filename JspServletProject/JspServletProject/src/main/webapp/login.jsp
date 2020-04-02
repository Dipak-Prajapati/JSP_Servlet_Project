	<!-- Navigation bar -->
	<%@ include file="header.jsp"%>

	<main
		class="d-flex align-items-center login-height primary-background banner-background">
		<div class="container"> 
			<div class="row">
				<div class="col-md-4 offset-md-4">
					<div class="card">
						<div class="card-header login-bg text-white text-center">
							<span class="fa fa-user-circle fa-spin fa-3x"></span>
							<br>
							<p>Login Here</p>
						</div>
						<div class="card-body">
							<form action="login" method="post">
								<div class="form-group">
									<label for="exampleInputEmail1">Email address</label> <input
										type="email" class="form-control" id="email" name="email"
										aria-describedby="emailHelp" placeholder="Enter email">
									<small id="emailHelp" class="form-text text-muted">We'll
										never share your email with anyone else.</small>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label> <input
										type="password" class="form-control"
										id="pwd" name="pwd" placeholder="Password">
								</div>
								
								<button type="submit" class="btn btn-outline-light btn-lg login-btn-width login-bg">Login</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

	<%@ include file="footer.jsp" %>
