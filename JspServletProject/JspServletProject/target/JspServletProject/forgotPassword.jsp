
<!-- Navigation bar -->
<%@ include file="header.jsp"%>
<%@ page import="com.dips.pojo.Message" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main
	class="d-flex align-items-center login-height primary-background banner-background">
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header login-bg text-white text-center">
						<span class="fa fa-key fa-3x"></span> <br>
						<p>Forgot Password</p>
					</div>

					<!-- Display Password and Error -->
					<div id="password" class="" role="alert"></div>
					

					<div class="card-body">
						<form  method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="email" name="email"
									aria-describedby="emailHelp" placeholder="Enter email">
								<small id="emailHelp" class="form-text text-muted">We'll
									never share your email with anyone else.</small>
							</div>

							<button type="submit" id="forgotPassword" name="forgotPassword"
								class="btn btn-outline-light btn-lg login-btn-width login-bg">Find Out</button>
							
							<div class="text-center mt-3 font-weight-bold">
							<a href="login.jsp">Back To LogIn ?</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>

<%@ include file="footer.jsp"%>
