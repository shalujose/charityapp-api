package com.revature.charityapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charityapp.controller.SendFundRequestController;

/**
 * Servlet implementation class AddDonationRequestServlet
 */
public class AddDonationRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get inputs
				double amount = Double.parseDouble(request.getParameter("amount"));
				int categoryId = Integer.parseInt(request.getParameter("category_Id"));
				  
				
				
				//2. call controller
				SendFundRequestController controller = new SendFundRequestController();		
				String json = controller.sendRequest(categoryId, amount);
				
				//3 . write
				PrintWriter out = response.getWriter();
				out.write(json);
				out.flush();
	}
	
}
