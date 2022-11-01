package com.cscalpha.manager.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cscalpha.manager.dto.UserRegistrationDto;
import com.cscalpha.manager.entity.Role;
import com.cscalpha.manager.entity.User;
import com.cscalpha.manager.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	@Lazy
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(UserRegistrationDto registrationDto) {
		
		User user = new User(registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getUsername(),passwordEncoder.encode(registrationDto.getPassword()),Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}
	

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or Password");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}


	@Override
	public User verifyUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

}
