package com.lytear.memo.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lytear.memo.user.bo.UserBO;
import com.lytear.memo.user.model.User;
@RestController // API 형태만 돌려주므로 RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserBO userBO;
	
	//API는 이 클래스에서만 작성// API만 다루는 Controller 따로 만들겠다
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
	
	
	@PostMapping("/sign_in")
	public Map<String, String> singIn(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			// session이라는 공간에 값만 저장한다
			, HttpServletRequest request
			
			) {
		User user = userBO.getUser(loginId, password);
		// select 한 결과가 객체일 때 있다 없다 어떻게 판단?
		
		Map<String, String> result = new HashMap<>();
		
		if(user != null) { // 없으면 user가 null일 때 에러 발생
			HttpSession session = request.getSession();
			// session : 클라이언트와 서버와 id를 주고 받으면서 저장하는 공간
			
			session.setAttribute("userId", user.getId());//"userId"는 키로 어디와 일치해야 하는 것 아님
			
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userName", user.getName());
			// 이제 해당 클라이언트와 통신하는 세션 안에는 항상 위 정보가 들어있다
			result.put("result","success");
		} else {
			result.put("result","fail");
		}
		
		return result;
		
		
	}
	
}
