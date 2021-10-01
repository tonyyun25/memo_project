package com.lytear.memo.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
// controller, BO, dao는 autowired로 spring bin 기능 포함. 이거는 그게 아니므로 component 사용 
public class PermissionInterceptor implements HandlerInterceptor {//implement 했기 때문에 거기에 있는 메소드 override 하면 됨
	
	// 요청이 들어올 때
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException { // 여기를 거쳐서 request, response 확보가 가능
	
		// 로그인 상태에 따른 접근 권한 관리
		HttpSession session = request.getSession();
		
		
		// 현재 요청한 uri (path) 알아 오기 (path : localhost8080 : //...)
		String uri = request.getRequestURI(); // path를 가져와서 문자열 형태로 쓰게 해 줌
		
		
		
		//String userId = (String)session.getAttribute("userId") // 디버깅 방법
		
		// 비로그인
		if(session.getAttribute("userId") == null) {
			// 리스트화면, 디테일 화면, 글쓰기 화면
			// /post/** 접근 못하도록 -> 로그인 페이지로 이동
			if(uri.startsWith("/post")) {
				response.sendRedirect("/user/signin_view"); // dao로 파라미터를 받아냄
				return false;//★★ else 인 경우 : 그 순간 중단하고 아무 것도 없는 response 그대로 돌려준다
				// true : 컨트롤러로 이동 . false : 이동 안 하고 지금 현재 비어 있는 상태로 response. return false 없다면 제일 아래 -> return -> page로 이동 (에러 또는 문제 상황 발생)
				
			}
		} else { // 로그인
			// 로그인 화면, 회원가입
			// /user/**
			if(uri.startsWith("/user")) {
				response.sendRedirect("/post/list_view");
				return false;// exclude 설정을 안 했다면 로그아웃 과정을 못하고 list_view로 간다
			}
		}
		return true;
	}
	
	// response 처리할 때 : 컨트에서 jsp 경로, json api 리턴 하고 나서 들어옴. 낚아채오는 역할
	// 컨트롤러까지 다 태운다음에 response를 조작할 경우에 사용할 수 있다는 것으로 소개. 지금은 없어도 상관 X
	// 위의 preHandle도 response를 조작한 것임
	@Override
	public void postHandle(HttpServletRequest request // 나가는 요청을 낚아챔
			, HttpServletResponse response
			, Object handler
			, ModelAndView modelAndView) {// 모델로 세팅된 것까지 여기서 콘트롤
		
	}
	
	// 모든 것이 완료되었을 때
	@Override
	public void afterCompletion(HttpServletRequest request 
			, HttpServletResponse response
			, Object handler
			, Exception ex) {
		
	}		
	
	
}
