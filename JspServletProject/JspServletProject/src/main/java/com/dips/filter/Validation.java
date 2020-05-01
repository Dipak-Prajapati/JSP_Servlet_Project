package com.dips.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dips.service.UserService;
import com.dips.service.UserServiceImpl;

public class Validation implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		if (request.getParameter("register").equals("SignUp") || request.getParameter("register").equals("Update")) {
			boolean fname = validateName(request.getParameter("fname"));
			boolean mname = validateName(request.getParameter("fname"));
			boolean lname = validateName(request.getParameter("lname"));
			boolean email = validateEmail(request.getParameter("email"));
			boolean dob = validateDate(request.getParameter("dob"));
			boolean number = validateNumber(request.getParameter("m_no"));
			boolean address = validateAddress(request.getParameter("address"));
			boolean city = validateName(request.getParameter("city"));
			boolean state = validateName(request.getParameter("state"));
			boolean country = validateName(request.getParameter("country"));
			boolean password = validatePassword(request.getParameter("pwd"));
			boolean cpassword = validateCpassword(request.getParameter("pwd"), request.getParameter("cpwd"));

			if (fname == false) {
				session.setAttribute("fname", "please enter the proper fisrt name");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			} else if (mname == false) {
				session.setAttribute("mname", "please enter the proper middle name ");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			} else if (lname == false) {
				session.setAttribute("lname", "please enter the proper last name ");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			} else if (email == false) {
				session.setAttribute("email", "please enter correct email id.");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			} else if (validateEmailExist(request.getParameter("email"), request.getParameter("register"))) {
				session.setAttribute("email", "Email Exists Please Try Another One..!!");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			} else if (dob == false) {
				session.setAttribute("dob", "please enter proper date.");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			} else if (number == false) {
				session.setAttribute("number", "please enter the proper number.. ");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			} else if (address == false) {
				session.setAttribute("address", "Please Enter the Address .. ");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			} else if (city == false) {
				session.setAttribute("city", "Please Enter the proper city name .. ");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			} else if (state == false) {
				session.setAttribute("state", "please Enter The proper state name...");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			} else if (country == false) {
				session.setAttribute("country", "please enter the proper country name...");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			} else if (password == false) {
				session.setAttribute("password", "Please enter minimum 8 character of password ");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			} else if (cpassword == false) {
				session.setAttribute("cpassword", "passsword does not match.");
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			} else {
				chain.doFilter(request, response);
			}
		} 
	}

	public static boolean validateName(String name) {
		if (name == null || name.contains(" ") || !Pattern.compile("^[a-zA-Z]+$").matcher(name).find()) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean validateEmail(String name) {
		if (name == null || name.contains(" ")
				|| !Pattern.compile("^[a-z0-9._][a-zA-Z0-9-_]+@[a-z0-9]+\\.[a-z]{2,4}").matcher(name).find()) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean validateDate(String strDate) {
		if (strDate == null || strDate.contains(" ") || strDate.length() != 10) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean validateNumber(String name) {
		if (name == null || name.contains(" ") || !Pattern.compile("^[0-9]{10,10}$").matcher(name).find()) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean validateAddress(String name) {
		if (name == null) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean validatePassword(String name) {
		/* "^([a-zA-Z0-9@*#]{8,15})$" */
		if (name == null || name.contains(" ") || !Pattern.compile("^[a-zA-Z0-9]{8,16}$").matcher(name).find()) {
			return false;
		} else {
			return true;
		}
	}

	public static Boolean validateCpassword(String old, String newpassword) {
		if (old.equals(newpassword)) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean validateEmailExist(String email, String Op) {

		UserService userService = new UserServiceImpl();

		if (userService.emailExist(email) && (!Op.equals("Update"))) {
			return true;
		}
		return false;

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
