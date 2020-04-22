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

public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		HttpSession session = request.getSession();
		
		/*
		 * UserModel userModel = new UserModel();
		 * 
		 * userModel.setEmail(email); userModel.setPassword(password);
		 */
		if (email.equals("admin@gmail.com") && password.equals("aaaaaaaa")) {
			
			UserModel userModel = new UserModel();
			UserService userService = new UserServiceImpl();
			List<UserModel> userData = new ArrayList<>();
			userData = userService.getUserData(userModel);
			
			session.setAttribute("role", "admin");
			System.out.println("Admin Role Set");
			session.setAttribute("userData", userData);
			response.sendRedirect("profile.jsp");
		} else {
			UserService userService = new UserServiceImpl();
			AddressService addressService = new AddressServiceImpl();
			UserModel userModel = userService.login(email, password);

			if (userModel == null) {
				Message msg = new Message("Invalid Details ! try with another", "error", "alert-danger");
				session.setAttribute("Msg", msg);
				/*
				 * RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				 * rd.forward(request, response);
				 */
				response.sendRedirect("login.jsp");
			} else {
				session.setAttribute("role", "user");
				System.out.println("User Role Set");
				session.setAttribute("currentUser", userModel);

				List<List<Object>> addressPojo = new ArrayList<List<Object>>();
				addressPojo = addressService.login(userModel.getId());

				session.setAttribute("currentAddress", addressPojo);
				/*
				 * RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				 * rd.forward(request, response);
				 */
				response.sendRedirect("profile.jsp");
			}
		}
	}

}
