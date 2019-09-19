package com.revature.charityapp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charityapp.Controller.CategoryController;

public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get input
		String category_name = request.getParameter("category_name");
		  
		
		
		//2. call controller
		CategoryController controller = new CategoryController();		
		String json = controller.addCategory(category_name);
		
		//3 . write
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}
	
}
