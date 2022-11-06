package com.company.urban.login.service;

import com.company.urban.login.entity.UserDetails;

public interface UserDetailsService {

	UserDetails saveUserDetails(UserDetails userDetails);
	
	String checkLogin(String email, String password);
	
	UserDetails updateUserDetails(UserDetails userDetails);
	
	String changePassword(String email,String oldPassword, String newPassword);
}
