package com.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.service.LoginService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	@Autowired
	LoginService service;
	 @RequestMapping(value = "login", method=RequestMethod.GET)
	public String login(Model map) {
                return "login";
	}
	
		@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String hello(@RequestParam(required=false,name="name") String name,@RequestParam(required=false,name="password") String password,
			@RequestParam(required=false,name="role") String role,Model map){
			try {
				boolean validuser=service.validateuser(name,password,role);
				}
				catch(Exception e) {
					System.out.println("Something went wrong.");				} 
			
     
		map.addAttribute("name",name);
		map.addAttribute("password",password);	
		map.addAttribute("role",role);
		return"hello";
		}
}
