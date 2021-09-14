package com.lytear.memo.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lytear.memo.user.bo.UserBO;
import com.lytear.memo.user.model.User;

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
	
	@RequestMapping("/ex01")
	@ResponseBody
	public List<User> ex01() {
		return userBO.getUserList();
	}
	
	
	@RequestMapping("/ex02")
	@ResponseBody
	public String ex02() {
		User user = new User();
		user.setLoginId("tony");
		user.setPassword("2829");
		user.setName("yoon");
		user.setEmail("yoon@naver.com");
		
		int count = userBO.addUserAsObject(user);
		
		return "입력 결과 : " + count;
	}
	
	
	
	
	
	
	
}
