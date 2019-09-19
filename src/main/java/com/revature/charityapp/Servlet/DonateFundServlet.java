package com.revature.charityapp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charityapp.Controller.TransactionController;

/**
 * Servlet implementation class DonateFundServlet
 */
public class DonateFundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double amount = Double.parseDouble(request.getParameter("amount"));
		int fundrequest_id = Integer.parseInt(request.getParameter("fundrequest_id"));
		int cate_id = Integer.parseInt(request.getParameter("cate_id"));
		int donor_id = Integer.parseInt(request.getParameter("donor_id"));
		  
		
		
		//2. call controller
		TransactionController controller = new TransactionController();		
		String json = controller.donateFundController(fundrequest_id, cate_id, donor_id, amount);
		
		//3 . write
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}
}
