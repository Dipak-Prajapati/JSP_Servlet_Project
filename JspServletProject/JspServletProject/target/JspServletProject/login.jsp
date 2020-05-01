
<!-- Navigation bar -->
<%@ include file="header.jsp"%>
<%@ page import="com.dips.pojo.Message" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	if(session.getAttribute("role")!=null)
	    response.sendRedirect("profile.jsp");
%>

<main
	class="d-flex align-items-center login-height primary-background banner-background">
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header login-bg text-white text-center">
						<span class="fa fa-user-circle fa-spin fa-3x"></span> <br>
						<p>Login Here</p>
					</div>

					<!-- validate session -->
					<c:if test="${sessionScope.Msg != null}">
						<%-- <c:redirect url="login.jsp"></c:redirect> --%>
						<c:set var="msg" value="${sessionScope.Msg}" scope="session" />
						<div class="alert ${msg.cssClass} mb-0 " role="alert">
							<strong><c:out value="${msg.content}" /></strong>
						</div>
						<c:remove var="msg" scope="session" />
					</c:if>

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
									type="password" class="form-control" id="pwd" name="pwd"
									placeholder="Password">
							</div>

							<button type="submit"
								class="btn btn-outline-light btn-lg login-btn-width login-bg">Login</button>
							
							<div class="text-center mt-2 font-weight-bold">
								<a href="forgotPassword.jsp">Forgot Password ?</a> 
							</div>
							<div class="text-center mt-1 font-weight-bold">
								<span class="text-secondary">NO ACCOUNT ?</span> <a href="registration.jsp">SignUp</a> 
							</div>
									
								
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>

<%@ include file="footer.jsp"%>
