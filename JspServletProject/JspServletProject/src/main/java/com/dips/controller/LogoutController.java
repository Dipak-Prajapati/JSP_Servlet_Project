package com.dips.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dips.pojo.Message;

@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException
	{
		doPost(request,response);
	}
	
	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException
	{
		
		
		  HttpSession session = request.getSession();
		  session.removeAttribute("currentUser"); Message msg = new
		  Message("Logout SuccessFully","success","alert-success");
		  session.setAttribute("Msg", msg);
		  
		  response.sendRedirect("login.jsp");
		 	
	
		
			/*
			 * HttpSession session = request.getSession();
			 * 
			 * if(session != null){ session.removeAttribute("role"); //session.invalidate();
			 * Message msg = new Message("Logout SuccessFully","success","alert-success");
			 * session.setAttribute("Msg", msg); }
			 * 
			 * //redirect to login page response.sendRedirect("login.jsp");
			 */
					
	}

	}

