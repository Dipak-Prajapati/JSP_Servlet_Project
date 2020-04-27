package com.dips.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dips.pojo.UserModel;
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

		if (request.getParameter("operation").contentEquals("forgotPassword")) {
			System.out.println("IN forgot Password");

			UserService serviceRegister = new UserServiceImpl();
			String password = serviceRegister.findPassword(request.getParameter("userEmail"));

			if (password != null) {
				response.getWriter().write("Your Password Is : " + password);
			} else {
				response.getWriter().write("Please Enter Valid Email Id.....!!!!!");
			}

		}
		else if(request.getParameter("operation").contentEquals("deleteUser"))
		{
			System.out.println("Delete User In Register Controller");
			int userId = Integer.parseInt(request.getParameter("userId"));
			
			UserService serviceRegister = new UserServiceImpl();
			boolean deleted = serviceRegister.deleteData(userId); 
			
			if(deleted)
			{
				UserModel registerPojo = new UserModel();
				List<UserModel> userData = new ArrayList<>();
				userData = serviceRegister.getUserData(registerPojo);
				HttpSession session = request.getSession();
				session.setAttribute("userData", userData);

				
				response.getWriter().write("Data Successfully Deleted.........!!!!!!!! ");
			}
			else
			{
				response.getWriter().write("Data Failed Deleted.........!!!!!!!! ");
			}
		}
	}
}
