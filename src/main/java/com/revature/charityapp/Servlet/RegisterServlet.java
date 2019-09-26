package com.revature.charityapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.charityapp.controller.UserController;

/**
 * Servlet implementation class registerServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		long phone = Long.parseLong(request.getParameter("phone"));
		String password = request.getParameter("password");

		// 2. call controller
		String json = UserController.register(name, gender, age, email, phone, password);

		// 3 . write
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();

	}
}
