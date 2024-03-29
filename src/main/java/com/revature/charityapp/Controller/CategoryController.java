package com.revature.charityapp.controller;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.exception.ServiceException;
import com.revature.model.Category;
import com.revature.services.AdminService;

public class CategoryController {

	private AdminService adminservice = new AdminService();

	public String addCategory(String category_name) {
		String json = null;
		String errorMessage = null;

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
		} else {
			obj.addProperty("message", "Successfully Updated");
		}

		json = obj.toString();

		return json;
	}

	public static void main(String[] args) {
		CategoryController controller = new CategoryController();
		String json = controller.addCategory("Childrens food");
		System.out.println(json);
		String json1 = controller.viewCategory();
		System.out.println(json1);
	}

	public String viewCategory() {

		String json = null;
		List<Category> viewResponse = null;
		String errorMessage = null;
		try {
			viewResponse = adminservice.viewCategory();
		} catch (ServiceException e) {
			errorMessage = e.getMessage();
		}

		// Convert list to json
		if (viewResponse != null) {
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
