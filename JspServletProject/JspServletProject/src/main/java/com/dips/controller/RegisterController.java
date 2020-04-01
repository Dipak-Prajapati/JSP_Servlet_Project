package com.dips.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dips.pojo.UserModel;
import com.dips.service.UserService;
import com.dips.service.UserServiceImpl;

public class RegisterController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UserModel registerPojo;
	UserService serviceRegister;
	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException
	{
		String fname = request.getParameter("fname");
		String mname = request.getParameter("mname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		String mobileNo = request.getParameter("m_no");
		String gender = request.getParameter("gender");
		String language = request.getParameter("language");
		String hobbie = request.getParameter("hobbie");
		//String address = request.getParameter("address");
		String password = request.getParameter("pwd");

		registerPojo = new UserModel();
		
		registerPojo.setFirstName(fname);
		registerPojo.setMiddleName(mname);
		registerPojo.setLastName(lname);
		registerPojo.setEmail(email);
		registerPojo.setDob(dob);
		registerPojo.setMobile_no(mobileNo);
		registerPojo.setGender(gender);
		registerPojo.setLanguage(language);
		registerPojo.setHiobbie(hobbie);
		registerPojo.setPassword(password);
	
		
		System.out.println("In Controller");
		System.out.println(fname);
		System.out.println(mname);
		System.out.println(lname);
		System.out.println(email);
		System.out.println(dob);
		System.out.println(mobileNo);
		System.out.println(gender);
		System.out.println(language);
		System.out.println(hobbie);
		System.out.println(password);
		
		serviceRegister = new UserServiceImpl();
		System.out.println("Controller in registerPojo : "+registerPojo);
		serviceRegister.insertData(registerPojo);		
	}
}