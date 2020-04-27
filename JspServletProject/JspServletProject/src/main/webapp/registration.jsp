
<!-- Navigation bar -->
<%@ include file="header.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.dips.pojo.UserModel" isELIgnored="false"%>
<%@ page import="com.dips.pojo.AddressModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- <c:if test="${sessionScope.currentUser == null}">
	<c:redirect url="login.jsp"></c:redirect>
</c:if>
 --%>


<c:set var="user" value="${sessionScope.currentUser}" />
<c:set var="userAddress" value="${sessionScope.currentAddress}" />
<c:set var="role" value="${sessionScope.role}" />
<!-- prevent browser back button after session expires -->
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
						<p>${empty role ? 'Registration Here' : 'Update User Profile'}
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
									value="<c:out value="${empty sessionScope.firstName ? user.firstName : sessionScope.firstName}"/>"
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

							<!-- <div class="form-group">
								<label for="address">Address : </label>
								<textarea class="form-control"
									placeholder="10/4 mahashakti nagar society" name="address"
									id="address" onblur="inputaddress()" onfocus="resetAddress()"></textarea>
								<br> <span class="error" id="saddress"></span>
							</div> -->

							<!-- <div id="example1" class="form-group container">
								<div class="r-group">
									<p>
										<label for="address_0_0" data-pattern-text="Address +=1:">Address
											1:</label>
										<input type="text" name="address" id="address_0"
											class="form-control" data-pattern-name="address"
											data-pattern-id="address_++"/>
									</p>
									<br> <span class="error" id="saddress"></span>
									<p>
										Add a remove button for the item. If one didn't exist, it would be added to overall group
										<button type="button"
											class="r-btnRemove btn btn-outline-dark btn-danger btn-lg">
											Remove<span class="fa fa-minus-circle ml-2"></span>
										</button>
									</p>
								</div>
								<button type="button"
									class="btn btn-outline-dark btn-lg r-btnAdd btn-success">
									Add<span class="fa fa-plus-circle ml-2"></span>
								</button>
							</div> -->

							<c:if test="${sessionScope.currentUser == null}">


								<div id="example1" class="form-group">
									<div class="text-center">
										<button type="button" class="r-btnAdd btn btn-success"
											id="r-btnAdd">
											<span class="fa fa-plus-circle" style="font-size: 30px;"></span>
										</button>
									</div>

									<div class="r-group" id="repeater">
										<label for="address_0_0" class="col-form-label text-md-left"
											data-pattern-text="Address +=1:">Address :</label>

										<textarea id="user_0_address" class="form-control"
											data-pattern-id="user_++_address" name="address"></textarea>

										<div class="row">
											<div class="col-md-6">
												<label for="city_0_0" class="col-form-label text-md-left"
													data-pattern-text="City +=1:">City :</label> <input
													type="text" id="user_0_city" class="form-control"
													data-pattern-id="user_++_city" name="city" />
											</div>
											<div class="col-md-6">
												<label for="state_0_0" class="col-form-label text-md-left"
													data-pattern-text="State +=1:">State :</label> <input
													type="text" id="user_0_state" class="form-control"
													data-pattern-id="user_++_state" name="state" />
											</div>
										</div>
										<label for="country_0_0" class="col-form-label text-md-left"
											data-pattern-text="Country +=1:">Country :</label> <input
											type="text" id="user_0_country" class="form-control"
											data-pattern-id="user_++_country" name="country" /> <br />


										<div class="text-center">
											<button type="button" class="r-btnRemove btn btn-danger"
												id="r-BTNREMOVE">
												<span class="fa fa-minus-circle" style="font-size: 30px;"></span>
											</button>
										</div>


										<input type="hidden" id="custId" name="addID" value="555">
										<input type="hidden" name="id" value="${user.id}">

									</div>
									<div class="dynamicAddingAddress"></div>
								</div>
							</c:if>

							<c:if test="${sessionScope.currentUser != null}">


								<div id="example1" class="form-group">
									<div class="text-center">
										<button type="button" class="r-btnAdd btn btn-success"
											id="r-btnAdd" value="add">
											<span class="fa fa-plus-circle" style="font-size: 30px;"></span>
										</button>
									</div>


									<%-- 		<c:set var="count" value="0" scope="page" />
									${userAddress}
							 --%>
									<c:forEach var="list" items="${userAddress}">
										<%-- <c:if test="${fn:length(list) gt 0}"> --%>

										<div class="r-group" id="repeater">

											<label for="address_0_0" class="col-form-label text-md-left"
												data-pattern-text="Address +=1:">Address :</label> <input
												type="text" id="user_0_address" class="form-control"
												data-pattern-id="user_++_address" name="address"
												value="${empty list[0] ? 'address':list[0]}" />
											<!-- </textarea> -->

											<div class="row">
												<div class="col-md-6">
													<label for="city_0_0" class="col-form-label text-md-left"
														data-pattern-text="City +=1:">City :</label> <input
														type="text" id="user_0_city" class="form-control"
														data-pattern-id="user_++_city" name="city"
														value="${empty list[1] ? 'city' : list[1]}" />
												</div>
												<div class="col-md-6">
													<label for="state_0_0" class="col-form-label text-md-left"
														data-pattern-text="State +=1:">State :</label> <input
														type="text" id="user_0_state" class="form-control"
														data-pattern-id="user_++_state" name="state"
														value="${list[2]}" />
												</div>
											</div>
											<label for="country_0_0" class="col-form-label text-md-left"
												data-pattern-text="Country +=1:">Country :</label> <input
												type="text" id="user_0_country" class="form-control"
												data-pattern-id="user_++_country" name="country"
												value="${list[3]}" /> <br />

											<div class="text-center">
												<button type="button" class="r-btnRemove btn btn-danger"
													id="r-BTNREMOVE" name="deleteAddress" value="remove"
													id="deleteAddress">
													<span class="fa fa-minus-circle" style="font-size: 30px;"></span>
												</button>
											</div>

											<input type="hidden" id="addId_" data-pattern-id="addId_+=1"
												name="addID" value="${list[4]}" />

										</div>
										<%-- <c:set var="count" value="${count+1}" scope="page" /> --%>
										<%-- </c:if> --%>
									</c:forEach>
									<div class="dynamicAddingAddress"></div>
									<input type="hidden" name="id" id="id_"
										data-pattern-id="id_+=1" value="${user.id}" />
								</div>
							</c:if>



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
										id="pic" accept="image/*"
										onchange="inputFile() ; readURL(this)" onfocus="resetFile()">
									<img id="preview" class="rounded float-right"
										<c:if test="${user.image != null}">src="image/${user.image}"</c:if>><br>
								</div>
								<span class="error" id="spic"></span>
							</div>

							<button type="submit" name="register" id="register"
								value="${empty user ? 'SignUp' : 'Update'}"
								class="btn btn-outline-light btn-lg login-btn-width login-bg"
								disabled>${empty user ? 'SignUp' : 'Update'}</button>

							<br>

							<c:if test="${sessionScope.role != null}">
								<a class="btn btn-outline-light btn-lg login-btn-width login-bg"
									href="profile.jsp"><span class="fa fa-times-circle mr-1"></span>Cancel</a>
							</c:if>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>


<%@ include file="footer.jsp"%>
