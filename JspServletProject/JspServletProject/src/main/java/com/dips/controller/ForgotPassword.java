package com.dips.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dips.service.UserService;
import com.dips.service.UserServiceImpl;

@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OUT forgot Password");

		System.out.println("IN forgot Password");

		UserService serviceRegister = new UserServiceImpl();
		String password = serviceRegister.findPassword(request.getParameter("userEmail"));

		if (password != null) {
			response.getWriter().write("Your Password Is : " + password);
		} else {
			response.getWriter().write("Please Enter Valid Email Id.....!!!!!");
		}

	}
}
