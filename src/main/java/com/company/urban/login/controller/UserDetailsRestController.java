package com.company.urban.login.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.urban.login.entity.UserDetails;
import com.company.urban.login.service.UserDetailsService;

@RestController
public class UserDetailsRestController {

	@Autowired
	private UserDetailsService service;
	
	@PostMapping("/user/signup")
	public UserDetails registerUser(@RequestBody UserDetails userDetails, ModelMap modelMap){
		return service.saveUserDetails(userDetails);
	}
	
	@PostMapping("/user/login")
	public String loginUser(@RequestParam String email,@RequestParam String password) {
		return service.checkLogin(email, password);
	}
	
	@PutMapping("/user/updateDetails")
	public UserDetails updateDetails(@RequestBody UserDetails userDetails) {
		return service.updateUserDetails(userDetails);
	}
	
	@PatchMapping("/user/changePassword")
	public String changePassword(@RequestParam String email, @RequestParam String oldPassword, @RequestParam String newPassword) {
		return service.changePassword(email, oldPassword, newPassword);
	}
}
