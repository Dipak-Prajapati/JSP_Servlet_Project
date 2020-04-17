package com.dips.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dips.pojo.Message;
import com.dips.pojo.UserModel;
import com.dips.service.AddressService;
import com.dips.service.AddressServiceImpl;
import com.dips.service.UserService;
import com.dips.service.UserServiceImpl;

public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
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
		AddressService addressService = new AddressServiceImpl();
		UserModel userModel = userService.login(email,password);
		List<List<Object>> addressPojo = new ArrayList<List<Object>>();
		addressPojo =  addressService.login(userModel.getId());
		
		
		if(userModel == null)
		{
			Message msg = new Message("Invalid Details ! try with another", "error", "alert-danger");
			HttpSession session = request.getSession();
			session.setAttribute("Msg", msg);
			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			 * rd.forward(request, response);
			 */
			response.sendRedirect("login.jsp");
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", userModel);
			session.setAttribute("currentAddress", addressPojo);
			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			 * rd.forward(request, response);
			 */
			response.sendRedirect("profile.jsp");
		}
	}

}
