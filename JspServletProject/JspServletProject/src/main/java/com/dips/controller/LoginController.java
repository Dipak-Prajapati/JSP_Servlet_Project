package com.dips.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dips.pojo.UserModel;
import com.dips.service.UserService;
import com.dips.service.UserServiceImpl;

public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException
	{
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		
		/*
		 * UserModel userModel = new UserModel();
		 * 
		 * userModel.setEmail(email); userModel.setPassword(password);
		 */
		
		UserService userService = new UserServiceImpl();
		UserModel userModel = userService.login(email,password);
		
		if(userModel == null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", userModel);
			RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);			
		}
	}

}
