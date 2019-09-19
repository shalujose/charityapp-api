package com.revature.charityapp.Controller;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.Model.Category;
import com.revature.Services.AdminService;

public class CategoryController {

	public  String addCategory(String category_name)
	{
		String json = null;
		String errorMessage = null;
		AdminService adminservice = new AdminService();
		try {
			 Category admin = new Category();
			 admin.setCategory_name(category_name);
			 
			adminservice.addCategory(category_name);
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
		CategoryController controller = new CategoryController();
		//String json = controller.addCategory("Childrens food");
		//System.out.println(json);
		String json=controller.viewCategory();
		System.out.println(json);
	}
	
public  String viewCategory(){
		
		String json = null;
		List<Category> viewResponse = null;
		String errorMessage = null;
		AdminService adminservice=new AdminService();
		viewResponse = adminservice.viewCategory();
		
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
