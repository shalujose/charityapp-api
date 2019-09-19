package com.revature.charityapp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charityapp.Controller.TransactionController;

public class ViewDonationResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		TransactionController controller=new TransactionController();
		String Json=controller.viewResponse();
		PrintWriter out=response.getWriter();
		out.write(Json);
		out.flush();

	}

}
