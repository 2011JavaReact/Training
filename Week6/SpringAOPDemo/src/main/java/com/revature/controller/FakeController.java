package com.revature.controller;

import org.springframework.stereotype.Component;

import com.revature.annotations.LoggedInUsersOnly;

@Component
public class FakeController {

	// We want to restrict this "endpoint" for only admins
	@LoggedInUsersOnly
	public String getAllUsers() {
		return "Super secret user information";
	}
	
}
