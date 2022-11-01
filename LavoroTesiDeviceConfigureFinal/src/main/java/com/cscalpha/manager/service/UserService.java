package com.cscalpha.manager.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cscalpha.manager.dto.UserRegistrationDto;
import com.cscalpha.manager.entity.User;

public interface  UserService extends UserDetailsService {

	User save(UserRegistrationDto registrationDto);
	User verifyUsername(String username);
}
