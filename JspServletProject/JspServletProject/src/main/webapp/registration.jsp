
<!-- Navigation bar -->
<%@ include file="header.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.dips.pojo.UserModel" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <c:if test="${sessionScope.currentUser == null}">
	<c:redirect url="login.jsp"></c:redirect>
</c:if> --%>
<c:set var="user" value="${sessionScope.currentUser}" />

<!-- prevent brouser back button after session expires -->
<%-- <%
	//response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>	 --%>
<script type="text/javascript">
	function preventBack() {
		window.history.forward();
	}
	setTimeout("preventBack()", 0);
	window.onunload = function() {
		null
	};
</script>

<main class="d-flex primary-background">
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-3">
				<div class="card reg-top">
					<div class="card-header login-bg text-white text-center">
						<br> <span class="fa fa-user-plus fa-3x"></span><br>
						<!-- <p>Register Here</p> -->
						<p>${empty user ? 'Registration Here' : 'Update User Profile'}
						</p>
					</div>
					<div class="card-body">
						<form name="reg" id="reg" method="post" action="Registration"
							onsubmit='return validate()' enctype='multipart/form-data'>
							<!-- <h1 class="h1-center">Registration</h1> -->
							<span class="error" id="shead"></span>

							<div class="form-group">
								<label for="fname">First Name : </label> <input type="text"
									class="form-control" name="fname" id="fname"
									value="<c:out value="${user.firstName}"/>"
									placeholder="Enter Your First Name" onblur="inputfname()"
									onfocus="resetFirstName()"><br> <span
									class="error" id="sfname"></span>
							</div>

							<div class="form-group">
								<label for="mname">Middle Name : </label> <input type="text"
									class="form-control" name="mname" id="mname"
									value="<c:out value="${user.middleName}"/>"
									placeholder="Enter Your Middle Name" onblur="inputmname()"
									onfocus="resetMiddleName()"><br> <span
									class="error" id="smname"></span>
							</div>


							<div class="form-group">
								<label for="lname">Last Name : </label> <input type="text"
									class="form-control" name="lname" id="lname"
									value="<c:out value="${user.lastName}"/>"
									placeholder="Enter Your Last Name" onblur="inputlname()"
									onfocus="resetLastName()"><br> <span class="error"
									id="slname"></span>
							</div>

							<div class="form-group">
								<label for="email">Email Id : </label> <input type="text"
									class="form-control" name="email" id="email"
									value="<c:out value="${user.email}"/>"
									placeholder="Enter Your Email" onblur="inputemail()"
									onfocus="resetEmail()"><br> <span class="error"
									id="semail"></span>
							</div>
							<fmt:parseDate value="${user.dob}" var="parseDate"
								pattern="MM/dd/yyyy" />
							<fmt:formatDate value="${parseDate}" var="sampleDate"
								pattern="yyyy-MM-dd" />
							<%-- <fmt:parseDate value="${user.dob}" var="parseDate" pattern="dd-MM-yyyy" /> --%>
							<div class="form-group">
								<label for="dob">Date Of Birth : </label> <input type="date"
									class="form-control" name="dob" id="dob" onblur="inputdob()"
									onfocus="resetDob()" value="<c:out value="${sampleDate}"/>">
								<br> <span class="error" id="sdob"></span>
							</div>

							<div class="form-group">
								<label for="m_no">Mobile No : </label> <input type="text"
									class="form-control" name="m_no" id="m_no" maxlength="10"
									value="<c:out value="${user.mobile_no}"/>"
									placeholder="Enter Your Mobile Number" onblur="inputmno()"
									onfocus="resetMno()"><br> <span class="error"
									id="sm_no"></span>
							</div>

							<div class="check">
								<div class="form-check form-check-inline">
									<label for="gender">Gender : </label>
									<div class="space">
										<input type="radio" class="form-check-input" name="gender"
											value="male" ${user.gender == 'male' ? 'checked' : '' }
											onblur="inputgender()" onfocus="resetGender()"><label
											for="form-check-label">: Male</label>
									</div>
								</div>
								<div class="form-check form-check-inline">
									<div class="space">
										<input type="radio" class="form-check-input" name="gender"
											value="female" ${user.gender == 'female' ? 'checked' : '' }
											onblur="inputgender()" onfocus="resetGender()"><label
											for="form-check-label">: Female</label>
									</div>
								</div>
								<br> <span class="error" id="sgender"></span>
							</div>

							<div class="check mb-4 mt-5">
								<div class="form-check form-check-inline">
									<label for="lang">Languages : </label>
									<div class="space">
										<input type="checkbox" class="form-check-input"
											name="language" value="gujarati"
											${user.language == 'gujarati' ? 'checked' : '' }
											onblur="inputlanguage()" onfocus="resetLanguage()"> <label
											for="form-check-label">: Gujarati </label>
									</div>
								</div>
								<div class="form-check form-check-inline">
									<div class="space">
										<input type="checkbox" class="form-check-input"
											name="language" value="hindi"
											${user.language == 'hindi' ? 'checked' : '' }
											onblur="inputlanguage()" onfocus="resetLanguage()"> <label
											for="form-check-label">: Hindi</label>
									</div>
								</div>
								<div class="form-check form-check-inline">
									<div class="space">
										<input type="checkbox" class="form-check-input"
											name="language" value="enghlish"
											${user.language == 'enghlish' ? 'checked' : '' }
											onblur="inputlanguage()" onfocus="resetLanguage()"> <label
											for="form-check-label">: Enghlish </label>
									</div>
								</div>
								<br> <span class="error" id="scheck"></span>
							</div>

							<div class="form-group">
								<label for="hobbie">Hobbies : </label> <select name="hobbie"
									class="form-control" id="hobbie" onblur="inputHobbie()"
									onfocus="resetHobbie()">
									<optgroup label="Game">
										<option value=""></option>
										<option value="CSGO"
											${user.hiobbie == 'CSGO' ? 'selected' : '' }>CSGO</option>
										<option value="PUBG"
											${user.hiobbie == 'PUBG' ? 'selected' : '' }>PUBG</option>
									</optgroup>
									<optgroup label="Movie">
										<option value="Bollywood"
											${user.hiobbie == 'Bollywood' ? 'selected' : '' }>Bollywood</option>
										<option value="Hollywood"
											${user.hiobbie == 'Hollywood' ? 'selected' : '' }>Hollywood</option>
									</optgroup>
								</select><br> <span class="error" id="shobbie"></span>
							</div>

							<div class="form-group">
								<label for="address">Address : </label>
								<textarea class="form-control"
									placeholder="10/4 mahashakti nagar society" name="address"
									id="address" onblur="inputaddress()" onfocus="resetAddress()"></textarea>
								<br> <span class="error" id="saddress"></span>
							</div>

							<div class="form-group">
								<label for="pwd">Password : </label> <input type="Password"
									class="form-control" name="pwd" id="pwd"
									value="<c:out value="${user.password}"/>"
									placeholder="Enter Password" onblur="inputpassword()"
									onfocus="resetPassword()"><br> <span class="error"
									id="spwd"></span>
							</div>

							<div class="form-group">
								<label for="cpwd">Confirm Password : </label> <input
									type="Password" class="form-control" name="cpwd" id="cpwd"
									value="<c:out value="${user.password}"/>"
									placeholder="Enter Confirm Password" onblur="inputcpassword()"
									onfocus="resetConfirmPassword()"><br> <span
									class="error" id="scpwd"></span>
							</div>

							<div class="form-group">
								<label for="img">Upload Profile : </label><br>
								<div class="d-flex">
									<input type="file" class="form-control-file" name="pic"
										id="pic" accept="image/png, image/jpeg"
										onchange="inputFile() ; readURL(this)" onfocus="resetFile()">

									<img id="preview" class="rounded float-right"
										<c:if test="${user.image != null}">src="image/${user.image}"</c:if>><br>
								</div>
								<span class="error" id="spic"></span>
							</div>

							<button type="submit" name="register" id="register"
								class="btn btn-outline-light btn-lg login-btn-width login-bg"
								disabled>${empty user ? 'SignUp' : 'Update'}</button>

							<br>

							<!-- <div class="loader from-group">
								<div class="preloader-wrapper big active">
									<div class="spinner-layer spinner-blue">
										<div class="circle-clipper left">
											<div class="circle"></div>
										</div>
										<div class="gap-patch">
											<div class="circle"></div>
										</div>
										<div class="circle-clipper right">
											<div class="circle"></div>
										</div>
									</div>

									<div class="spinner-layer spinner-red">
										<div class="circle-clipper left">
											<div class="circle"></div>
										</div>
										<div class="gap-patch">
											<div class="circle"></div>
										</div>
										<div class="circle-clipper right">
											<div class="circle"></div>
										</div>
									</div>

									<div class="spinner-layer spinner-yellow">
										<div class="circle-clipper left">
											<div class="circle"></div>
										</div>
										<div class="gap-patch">
											<div class="circle"></div>
										</div>
										<div class="circle-clipper right">
											<div class="circle"></div>
										</div>
									</div>

									<div class="spinner-layer spinner-green">
										<div class="circle-clipper left">
											<div class="circle"></div>
										</div>
										<div class="gap-patch">
											<div class="circle"></div>
										</div>
										<div class="circle-clipper right">
											<div class="circle"></div>
										</div>
									</div>
								</div>
							</div>
 -->
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>


<%@ include file="footer.jsp"%>
