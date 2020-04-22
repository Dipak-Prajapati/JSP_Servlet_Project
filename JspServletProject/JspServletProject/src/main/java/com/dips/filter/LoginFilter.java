package com.dips.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		System.out.println("Before Login Filter");
		if (email != null && password != null && !email.isEmpty() && !password.isEmpty()) {
			System.out.println("Loggin SuccessFull");
			if(email.equals("admin@gmail.com") && password.equals("aaaaaaaa"))
			{
				System.out.println("Before Admin Filter");
				chain.doFilter(request, response);
				System.out.println("After Admin Filter");
			}
			else
			{
				System.out.println("Before User Filter");
				chain.doFilter(request, response);
				System.out.println("After User Filter");
			}
			
		}
		else
		{
			System.out.println("After Login Filter : Login UnSuccesfull");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
