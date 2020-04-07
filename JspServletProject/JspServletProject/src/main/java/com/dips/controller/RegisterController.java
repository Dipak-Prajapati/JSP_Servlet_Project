package com.dips.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dips.pojo.UserModel;
import com.dips.service.UserService;
import com.dips.service.UserServiceImpl;

@MultipartConfig
public class RegisterController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UserModel registerPojo;
	UserService serviceRegister;

	@SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession(true);
		if (session.getAttribute("currentUser") == null) {
			System.out.println("session.getAttribute(\"currentUser\") == null Registration profile");
			String fname = request.getParameter("fname");
			String mname = request.getParameter("mname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String dob = request.getParameter("dob");
			String mobileNo = request.getParameter("m_no");
			String gender = request.getParameter("gender");
			String language = request.getParameter("language");
			String hobbie = request.getParameter("hobbie"); // String address =
			request.getParameter("address");
			String password = request.getParameter("pwd");

			Part part = request.getPart("pic");
			String imageName = part.getSubmittedFileName();
			System.out.println("imageName :" + imageName);

			InputStream is = part.getInputStream();
			System.out.println("image InputStream :" + is);
			byte[] data = new byte[is.available()];
			is.read(data);
			System.out.println("image data:" + data);

			String path = "D:\\INEXTURE\\JspServletProject\\JspServletProject\\src\\main\\webapp\\image"
					+ File.separator + imageName;

			// String path = "D:\\Upload Image" + File.separator + imageName;
			String path1 = request.getRealPath("/") + "image" + File.separator + imageName;
			System.out.println("imagePath :" + path);
			System.out.println("Get Real Path imagePath :" + path1);

			FileOutputStream fos = new FileOutputStream(path1);

			fos.write(data);
			fos.close();

			fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();

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
			registerPojo.setImage(imageName);

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
			System.out.println("Controller in registerPojo : " + registerPojo);
			serviceRegister.insertData(registerPojo);

			response.sendRedirect("index.jsp");
		}
		if (session.getAttribute("currentUser") != null) {

			System.out.println("session.getAttribute(\"currentUser\") != null update Profile");
			String fname = request.getParameter("fname");
			String mname = request.getParameter("mname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String dob = request.getParameter("dob");
			String mobileNo = request.getParameter("m_no");
			String gender = request.getParameter("gender");
			String language = request.getParameter("language");
			String hobbie = request.getParameter("hobbie");
			// String address =request.getParameter("address");
			String password = request.getParameter("pwd");

			Part part = request.getPart("pic");
			String imageName = part.getSubmittedFileName();
			System.out.println("imageName :" + imageName);

			InputStream is = part.getInputStream();
			System.out.println("image InputStream :" + is);
			byte[] data = new byte[is.available()];
			is.read(data);
			System.out.println("image data:" + data);

			String path = "D:\\INEXTURE\\JspServletProject\\JspServletProject\\src\\main\\webapp\\image"
					+ File.separator + imageName;

			// String path = "D:\\Upload Image" + File.separator + imageName;
			String path1 = request.getRealPath("/") + "image" + File.separator + imageName;
			System.out.println("imagePath :" + path);
			System.out.println("Get Real Path imagePath :" + path1);

			FileOutputStream fos = new FileOutputStream(path1);

			fos.write(data);
			fos.close();

			fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();

			registerPojo = (UserModel) session.getAttribute("currentUser");
			// registerPojo = new UserModel();

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
			registerPojo.setImage(imageName);

			System.out.println("In Update Controller ");
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
			System.out.println("Controller in registerPojo update code: " + registerPojo);
			serviceRegister.updateData(registerPojo);
			
			response.sendRedirect("profile.jsp");

		}

	}
}
