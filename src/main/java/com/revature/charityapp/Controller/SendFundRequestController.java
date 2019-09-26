package com.revature.charityapp.controller;


import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.model.Request;
import com.revature.services.AdminService;
import com.revature.services.UserService;

public class SendFundRequestController {
	
	public  String sendRequest(int category_Id, double amount)
	{
		String json = null;
		String errorMessage = null;
		AdminService adminservice = new AdminService();
		try {
			 Request admin = new Request();
			 admin.setCategory_id(category_Id);
			 admin.setAmount(amount);
			 
			adminservice.sendFundRequest(category_Id, amount);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		
		JsonObject obj = new JsonObject();
		if (errorMessage != null) {
			obj.addProperty("errorMessage", errorMessage);
		}
		else {
			obj.addProperty("message", "Successfully Updated");
		}
		
		json = obj.toString();
		
		return json;
	}

	public static void main(String[] args) {
		SendFundRequestController controller = new SendFundRequestController();
		//String json = controller.sendRequest(1,10000);
		//System.out.println(json);
		
		//SendFundRequestController controller = new SendFundRequestController();
		String json = controller.viewRequest();
		System.out.println(json);
	}
	
public  String viewRequest(){
		
		String json = null;
		List<Request> viewRequest = null;
		String errorMessage = null;
		UserService userservice=new UserService();
		viewRequest = userservice.viewRequest();
		
		//Convert list to json
		if ( viewRequest != null) {
			Gson gson = new Gson();
			json = gson.toJson(viewRequest);
		}
		if (errorMessage != null) {
			JsonObject obj = new JsonObject();
			obj.addProperty("errorMessage", errorMessage);
		}
		return json;
		
	}
	

}
