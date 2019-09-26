package com.revature.charityapp.controller;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.model.Transaction;
import com.revature.services.AdminService;
import com.revature.services.UserService;

public class TransactionController {
	
	public  String donateFundController(int fundrequestId, int cateId, int donorId, double amount)
	{
		String json = null;
		String errorMessage = null;
		UserService userservice = new UserService();
		try {
			 Transaction transfer = new Transaction();
			 transfer.setFundrequestId(fundrequestId);
			 transfer.setCategoryId(cateId);
			 transfer.setDonorId(donorId);
			 transfer.setAmount(amount);
			 
			userservice.donateFundService(fundrequestId, cateId, donorId, amount);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		
		JsonObject obj = new JsonObject();
		if (errorMessage != null) {
			obj.addProperty("errorMessage", errorMessage);
		}
		else {
			obj.addProperty("message", "Transaction Successfully Completed");
		}
		
		json = obj.toString();
		
		return json;
	}
	public static void main(String[] args) {
		TransactionController controller = new TransactionController();
		//String json = controller.donateFundController(1,2,2,1000);
		String json=controller.viewResponse();
		System.out.println(json);
	}
	
public  String viewResponse(){
		
		String json = null;
		List<Transaction> viewResponse = null;
		String errorMessage = null;
		AdminService adminservice=new AdminService();
		viewResponse = adminservice.viewResponse();
		
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

}
