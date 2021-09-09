package com.lytear.memo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")

/*
 * 1. 
 * Thu Sep 09 17:59:48 KST 2021
There was an unexpected error (type=Method Not Allowed, status=405).
Request method 'GET' not supported
 *  : 
 * 
 * 
 * */


public class UserController {

	@GetMapping("/signin_view")
	public String signinView() {
		
		return "user/signIn";
	}
	
	
	@GetMapping("/signup_view")
	public String signupView() {
		
		return "user/signUp";
	}
	
	
	
	
	
	
	
	
}
