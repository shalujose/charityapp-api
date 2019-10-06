package com.revature.charityapp.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.exception.ServiceException;
import com.revature.model.User;
import com.revature.services.UserService;

public class UserController {

	public static String login(String email, String password) {

		String errorMessage = null;
		UserService userservice = new UserService();
		User user = null;
		try {
			user = userservice.findByNameAndPassword(email, password);
			if (user == null) {
				throw new ServiceException("Invalid data");
			}
		} catch (ServiceException e) {
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
		String validUserJson = UserController.login("sha@gmail.com", "Shalu@123");
		System.out.println(validUserJson);

		System.out.println("Test Case 2: Invalid User");
		String invalidUserJson = UserController.login("invaliduser@gmail.com", "password");
		System.out.println(invalidUserJson);

		String json = UserController.register("shalu", "F", 24, "sha@gmail.com", 23658974,"Shalu@123");
		System.out.println(json);

	}

	public static String register(String name, String gender, int age, String email, long phone, String password) {

		String json = null;
		String errorMessage = null;
		UserService userservice = new UserService();
		try {
			User user = new User();
			user.setName(name);
			user.setGender(gender);
			user.setAge(age);
			user.setEmail(email);
			user.setPhone(phone);
			user.setPassword(password);
			userservice.registerNow(user);
			
		} catch (ServiceException e) {
			errorMessage = e.getMessage();
		}

		// Prepare JSON Object
		JsonObject obj = new JsonObject();
		if (errorMessage != null) {
			obj.addProperty("errorMessage", errorMessage);
		} else {
			obj.addProperty("message", "Successfully Inserted");
		}

		json = obj.toString();

		return json;
	}

}
