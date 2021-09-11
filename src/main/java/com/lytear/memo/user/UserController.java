package com.lytear.memo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lytear.memo.user.bo.UserBO;

@Controller
@RequestMapping("/user")

public class UserController {
	@Autowired
	private UserBO userBO;
	
	
	@GetMapping("/signin_view")
	public String signinView() {
		
		return "user/signIn";
	}
	
	@GetMapping("/signup_view")
	public String signupView() {
		return "user/signUp";
	}
	
	@PostMapping("/sign_up")
	@ResponseBody
	public String sign_up (
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, @RequestParam("name") String name
			, @RequestParam("email") String email
			
			) {
		int count = userBO.getMember(loginId, password, name, email); 
		
		return "입력 성공 : " + count;
	}
	
	
	
	
	
}
