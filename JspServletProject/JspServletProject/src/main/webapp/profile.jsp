<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.dips.pojo.UserModel" isELIgnored="false"%>
<%@ page import="com.dips.pojo.AddressModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- validate session -->
<c:if test="${sessionScope.currentUser == null}">
	<c:redirect url="login.jsp"></c:redirect>
</c:if>
<c:set var="user" value="${sessionScope.currentUser}" />
<c:set var="userAddress" value="${sessionScope.currentAddress}" />

<%@ include file="header.jsp"%>

<%
	//response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>

<main class="d-flex primary-background">
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-3">
				<div class="card reg-top">
					<!-- <div class="card-header login-bg text-white text-center">
							<br> <span class="fa fa-vcard fa-3x"></span> <br>
							<h3 class="display-5">TESTING PROFILE PAGE</h3>
						</div> -->
					<div class="card-header login-bg ">
						<h3 class="display-5 text-white text-center">PROFILE PAGE</h3>
						<div class="d-flex justify-content-center h-100">
							<div class="image_outer_container">
								<div class="green_icon"></div>
								<div class="image_inner_container">
									<img src="image/${user.image}" class="img-fluid">


									<!-- https://bootsnipp.com/snippets/gN2b5 -->
								</div>
							</div>
						</div>
						<h3 class="display-5 text-white text-center">
							<c:out value="${user.firstName}"></c:out>
						</h3>
					</div>

					<div class="card-body text-center">

						<table class="table">
							<tbody>
								<tr>
									<th>MiddleName</th>
									<th>:</th>
									<td><c:out value="${user.middleName}" /></td>
								</tr>
								<tr>
									<th>LastName</th>
									<th>:</th>
									<td><c:out value="${user.lastName}"></c:out></td>
								</tr>
								<tr>
									<th>Email</th>
									<th>:</th>
									<td><c:out value="${user.email}"></c:out></td>
								</tr>
								<tr>
									<th>Date Of Birth</th>
									<th>:</th>
									<td><c:out value="${user.dob}"></c:out></td>
								</tr>
								<tr>
									<th>Mobile Number</th>
									<th>:</th>
									<td><c:out value="${user.mobile_no}"></c:out></td>
								</tr>
								<tr>
									<th>Gender</th>
									<th>:</th>
									<td><c:out value="${user.gender}"></c:out></td>
								</tr>
								<tr>
									<th>Language</th>
									<th>:</th>
									<td><c:out value="${user.language}"></c:out></td>
								</tr>
								<tr>
									<th>Hobby</th>
									<th>:</th>
									<td><c:out value="${user.hiobbie}"></c:out></td>
								</tr>

								<!-- Address -->
								<c:set var="count" value="1" scope="page" />
								<c:forEach var="list" items="${userAddress}">
									<tr>
										<th>Address ${count}</th>
										<th>:</th>
										<td><c:out value="${list[0]}"></c:out></td>
									</tr>
									<tr>
										<th>City ${count}</th>
										<th>:</th>
										<td><c:out value="${list[1]}"></c:out></td>
									</tr>
									<tr>
										<th>State ${count}</th>
										<th>:</th>
										<td><c:out value="${list[2]}"></c:out></td>
									</tr>
									<tr>
										<th>Country ${count}</th>
										<th>:</th>
										<td><c:out value="${list[3]}"></c:out></td>
									</tr>
									<input type="hidden" id="custId" name="addID"
										value="${list[4]}">
									<input type="hidden" name="id" value="${user.id}">

									<c:set var="count" value="${count+1}" scope="page" />
								</c:forEach>
							</tbody>
						</table>
						<a class="btn btn-outline-light btn-lg login-bg"
							href="LogoutController"><span class="fa fa-sign-out"></span>Logout</a>
						<a class="btn btn-outline-light btn-lg login-bg"
							href="registration.jsp?id=${user.id}"><span
							class="fa fa-sign-out"></span>Edit</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>


<%@ include file="footer.jsp"%>