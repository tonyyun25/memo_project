package com.lytear.memo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lytear.memo.user.bo.UserBO;
@RestController // API 형태만 돌려주므로 RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserBO userBO;
	
	//API는 이 클래스에서만 작성
	@PostMapping("/sign_up")
	//강의에서 String 거치지 않고 처음부터 Map 형태로 만듦
	public Map<String,String> signUp (
			@RequestParam("loginId") String loginId//Request로 받은 데이터를 뒤의 변수에 저장
			, @RequestParam("password") String password
			, @RequestParam("name") String name
			, @RequestParam("email") String email
			
			) {
		
		int count = userBO.addUser(loginId, password, name, email); 
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result","success");
		} else {
			result.put("result","fail");
		}
		
		//return "입력 성공 : " + count;
		return result;
		
	}
	// API만 다루는 Controller 따로 만들겠다
	
	
	
}
