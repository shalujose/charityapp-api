package com.revature.charityapp.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.Model.User;
import com.revature.Services.AdminService;

public class AdminLoginController {

	public static String adminLogin(String name, String password) {

		String errorMessage = null;
		AdminService adminservice = new AdminService();
		User user = null;
		try {
			user = adminservice.findByAdminNameAndPassword(name, password);
			if (user == null) {
				throw new Exception("Invalid data");
			}
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}

		// Prepare JSON Object
		String json = null;
		Gson gson = new Gson();
		if (user != null) {
			json = gson.toJson(user);

		} else if (user == null) {
			JsonObject obj = new JsonObject();
			obj.addProperty("errorMessage", errorMessage);
			json = obj.toString();
		}

		return json;
	}

	public static void main(String[] args) {

		System.out.println("Test Case 1: Valid User");
		String validUserJson = AdminLoginController.adminLogin("admin", "admin@123");
		System.out.println(validUserJson);

		System.out.println("Test Case 2: Invalid User");
		String invalidUserJson = AdminLoginController.adminLogin("invaliduser@gmail.com", "password");
		System.out.println(invalidUserJson);

	}

}
