package com.revature.charityapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charityapp.controller.TransactionController;

/**
 * Servlet implementation class DonateFundServlet
 */
public class DonateFundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double amount = Double.parseDouble(request.getParameter("amount"));
		int fundrequestId = Integer.parseInt(request.getParameter("fundrequest_id"));
		int donorId = Integer.parseInt(request.getParameter("donor_id"));
		  
		
		
		//2. call controller
		TransactionController controller = new TransactionController();		
		String json = controller.donateFundController(fundrequestId, donorId, amount);
		
		//3 . write
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}
}
