package com.cscalpha.manager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cscalpha.manager.dto.UserRegistrationDto;
import com.cscalpha.manager.entity.User;
import com.cscalpha.manager.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	@Lazy
	private UserService userservice;
	
	
	
	//add initbinder to convert trim input strings 
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor= new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/showMyRegistrationPage")
	public String showMyLoginPage(Model theModel) {
		
		theModel.addAttribute("user", new UserRegistrationDto());
		return "registration";
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("user") UserRegistrationDto theuser,HttpSession session) {
		
		//check empty fields 
		if(theuser.getFirstName()  == null || theuser.getLastName()  == null || theuser.getPassword()  == null || theuser.getUsername()  == null) 
		{
			session.setAttribute("message", "Fill in the left Empty spaces");
			return "registration";
		}
		//add verification for used username	
         User theUser=userservice.verifyUsername(theuser.getUsername());
		
		if(theUser != null) {
			session.setAttribute("message", "Username already used, change username.");
			return "registration";
		}
	
		//save new user if the are no empty spaces and if username isn't used
		userservice.save(theuser);
		
		session.setAttribute("message", "Successfully registered");
		
		return "redirect:showMyRegistrationPage";
	}
}
