package com.revature.charityapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charityapp.controller.CloseRequestController;

public class CloseRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CloseRequestController controller=new CloseRequestController();
		String Json=controller.closeRequest();
		PrintWriter out=response.getWriter();
		out.write(Json);
		out.flush();
	}

}
