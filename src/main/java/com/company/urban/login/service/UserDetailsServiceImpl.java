package com.company.urban.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.urban.login.entity.UserDetails;
import com.company.urban.login.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsRepository repository;
	

	@Override
	public UserDetails saveUserDetails(UserDetails userDetails) {
		return repository.save(userDetails);
	}

	@Override
	public String checkLogin(String email, String password) {
		UserDetails currentUser = repository.findByEmail(email);
		if (currentUser == null) {
			return "fields can't be empty";
		}
		if (email.equalsIgnoreCase(currentUser.getEmail())) {
			if (password.equals(currentUser.getPassword())) {
				return "login success";
			} else {
				return "incorrect password";
			}
		} else {
			return "Invalid emial or password";
		}
	}

	@Override
	public UserDetails updateUserDetails(UserDetails userDetails) {
		return repository.save(userDetails);
	}

	@Override
	public String changePassword(String email, String oldPassword, String newPassword) {
		System.out.println(oldPassword);
		UserDetails currentUser = repository.findByEmail(email);
		System.out.println(currentUser.getPassword());
		if (currentUser.getPassword().equals(oldPassword)) {
			currentUser.setPassword(newPassword);
			repository.save(currentUser);
			return "password changed";
		} else {
			return "incorrect password";
		}
	}

}
