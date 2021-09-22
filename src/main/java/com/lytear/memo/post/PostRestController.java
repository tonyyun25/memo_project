package com.lytear.memo.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lytear.memo.post.bo.PostBO;

@RestController
@RequestMapping("/post")
public class PostRestController {

	@Autowired
	private PostBO postBO;
	
	@PostMapping("/create")
	public Map<String, String> create(
			
			@RequestParam("subject") String subject
			,@RequestParam("content") String content
			,@RequestParam("file") MultipartFile file//처리하기 어려운 파일을 서브릿이 쓰기 편하도록 객체형태로 만듦(클래스)
			,HttpServletRequest request
			) {
		
		HttpSession session = request.getSession();
		int userId= (Integer)session.getAttribute("userId");
		//session.getAttribute("userId") 값은 object 형태라 값을 꺼내서 쓸떄는 위와 같이 캐스팅 필요
		
		//int count = postBO.addPost(userId, subject, content);
		int count = postBO.addPost(userId, subject, content, file);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	/*
	 * 1. 파일이 저장되는 경로
	 * 2. 파일 접근하는 경로 = Http 주소창에 적힘
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
}