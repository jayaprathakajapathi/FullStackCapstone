package com.capstone.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
public boolean validateuser(String name,String password,String role) {
	
	return  name.equalsIgnoreCase("jaya") && password.equalsIgnoreCase("root")&& role.equalsIgnoreCase("admin");
	//return  name.equalsIgnoreCase("prasanna") && password.equalsIgnoreCase("pratha")&& role.equalsIgnoreCase("user");
	
}
}
