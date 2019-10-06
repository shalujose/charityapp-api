package com.revature.charityapp.controller;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.exception.ServiceException;
import com.revature.model.Amount;
import com.revature.services.AdminService;

public class CloseRequestController {
	
	AdminService adminservice=new AdminService();
public  String closeRequest(){
		
		String json = null;
		List<Amount> viewResponse = null;
		String errorMessage = null;
		AdminService adminservice=new AdminService();
		try {
			viewResponse = adminservice.closeRequest();
		} catch (ServiceException e) {
			errorMessage=e.getMessage();
		}
		
		//Convert list to json
		if ( viewResponse != null) {
			Gson gson = new Gson();
			json = gson.toJson(viewResponse);
		}
		if (errorMessage != null) {
			JsonObject obj = new JsonObject();
			obj.addProperty("errorMessage", errorMessage);
		}
		return json;
		
	}

	public static void main(String[] args) {
	CloseRequestController controller = new CloseRequestController();
	String json=controller.closeRequest();
	System.out.println(json);
}
	
}
