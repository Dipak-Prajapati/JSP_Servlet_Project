<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.dips.pojo.UserModel" isELIgnored="false"%>
<%@ page import="com.dips.pojo.AddressModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="header.jsp"%>

<%
	//response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>

<c:if test="${sessionScope.role == null}">
	<c:redirect url="login.jsp"></c:redirect>
</c:if>

<!-- Admin-->
<c:if test="${sessionScope.role == 'admin'}">

	<c:set var="userData" value="${sessionScope.userData}" />

	<div class="app-body">
		<!-- Main content -->
		<main class="main">

			<div class="container-fluid m-0 p-0">
				<!-- <div class="animated fadeIn"> -->
				<div class="card">
					<div class="card-header p-0 m-0 admin-card-header">
						<div
							class="jumbotron primary-background text-white banner-background">
							<div class="container text-center mt-5 mb-5">
								<h3 class="display-3 mt-5">Welcome To Admin Panel</h3>
								<a href="LogoutController"
									class="btn btn-outline-light btn-lg mt-5 mb-5 btn-width"> <span
									class="fa fa-sign-out mr-2"></span>Logout
								</a>
							</div>
						</div>
						<!-- <p class="display-3 mt-5">Welcome To AdminPanel</p>
									<a class="btn btn-outline-light btn-lg login-bg"
										href="LogoutController"><span class="fa fa-sign-out"></span>Logout</a> -->
					</div>

					<div class="card-body">
						<!-- Table  -->
						<div class="row">
							<div class="col-lg-12">

								<table id="adminDataTable"
									class="table table-striped table-bordered" style="width: 100%">
									<thead>
										<tr>
											<th>UserId</th>
											<th>FirstName</th>
											<th>Email</th>
											<th>Date Of Birth</th>
											<th>Mobile No</th>
											<th>Gender</th>
											<th>Language</th>
											<th>ProfilePic</th>
											<th>Edit</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${userData}" var="displayData">
											<tr class="text-center">
												<td class="align-middle">${displayData.id}</td>
												<td class="align-middle">${displayData.firstName}</td>
												<td class="align-middle">${displayData.email}</td>
												<td class="align-middle">${displayData.dob}</td>
												<td class="align-middle">${displayData.mobile_no}</td>
												<td class="align-middle">${displayData.gender}</td>
												<td class="align-middle">${displayData.language}</td>
												<td class="align-middle"><div class="admin_image_outer_container">
														<div class="admin_image_inner_container">
															<img src="image/${displayData.image}" class="img-fluid">
														</div>
													</div></td>
												<td class="align-middle"><a class="btn btn-outline-light login-bg"
													href="RegisterController?role=admin&operation=Update&id=${displayData.id}"><span
														class="fa fa-edit mr-1"></span>Edit</a></td>
												<td class="align-middle"><a class="btn btn-outline-light btn-danger"
													href="#"<%-- ${displayData.id} --%>><span
														class="fa fa-trash mr-1"></span>Delete</a></td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<th>UserId</th>
											<th>FirstName</th>
											<th>Email</th>
											<th>Date Of Birth</th>
											<th>Mobile No</th>
											<th>Gender</th>
											<th>Language</th>
											<th>ProfilePic</th>
											<th>Edit</th>
											<th>Delete</th>
										</tr>
									</tfoot>
								</table>

							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>
</c:if>


<!-- User-->
<c:if test="${sessionScope.role == 'user' }">

	<!-- validate session -->
	<%-- <c:if test="${sessionScope.currentUser == null}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if> --%>
	<c:set var="user" value="${sessionScope.currentUser}" />
	<c:set var="userAddress" value="${sessionScope.currentAddress}" />

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
								class="fa fa-edit mr-1"></span>Edit</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</c:if>

<%@ include file="footer.jsp"%>