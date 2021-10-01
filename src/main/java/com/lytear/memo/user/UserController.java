package com.lytear.memo.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	// 개인 연습
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
	// 여기까지 개인 연습
	@GetMapping("/sign_out")
	public String signOut(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("userId");// '21.10.01 permission 부분 오류 확인해 보니 이 행이 없었으므로 추가함
		
//		session.removeAttribute("loginId");
		session.removeAttribute("userLoginId");
		
		session.removeAttribute("userName");
		
		
		return "redirect:/user/signin_view";
	}
	// https://chrome.google.com/webstore/detail/zenhub-for-github/ogcgkffhplmphkaahpmffcafajaocjbd?ctx=deblog20052011&hl=ko
	// 구글링 마크다운
	
	
	
}
