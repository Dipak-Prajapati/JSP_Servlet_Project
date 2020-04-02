
<%@ include file="header.jsp"%>
<%@ page import="com.dips.pojo.UserModel" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- validate session -->
<c:if test="${sessionScope.currentUser == null}">
	<c:redirect url="login.jsp"></c:redirect>
</c:if>

<main class="d-flex primary-background">
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-3">
				<div class="card reg-top">
					<div class="card-header login-bg text-white text-center">
						<br> <span class="fa fa-vcard fa-3x"></span> <br>
						<h3 class="display-5">TESTING PROFILE PAGE</h3>
					</div>
					<div class="card-body text-center">
						<c:set var="user" value="${sessionScope.currentUser}"/>
						<c:out value="${user.firstName}"></c:out><br/>
						<c:out value="${user.middleName}"></c:out><br/>
						<c:out value="${user.lastName}"></c:out><br/>
						<c:out value="${user.email}"></c:out><br/>
						<c:out value="${user.dob}"></c:out><br/>
						<c:out value="${user.gender}"></c:out><br/>
						<c:out value="${user.hiobbie}"></c:out><br/>
						<c:out value="${user.language}"></c:out><br/>
						<c:out value="${user.mobile_no}"></c:out><br/>
						<c:out value="${user.password}"></c:out><br/>
						<c:out value="${user.image}"></c:out><br/>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</main>


<%@ include file="footer.jsp"%>