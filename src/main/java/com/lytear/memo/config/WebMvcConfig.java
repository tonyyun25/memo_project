package com.lytear.memo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lytear.memo.common.FileManagerService;
import com.lytear.memo.common.PermissionInterceptor;

@Configuration

// 저장된 파일을 모든 사람들이 볼 수 있게 설정
public class WebMvcConfig implements WebMvcConfigurer{

	// permission 권한시 추가 ('21.10.01)
	@Autowired
	private PermissionInterceptor permissionInterceptor;
	
	@Override//WebMvcConfigurer 인터페이스에 포함된 메소드를 아래에 구현
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 서버(내 컴퓨터)의 특정 위치의 파일들을
		// 내가 정한 url path로 접근하게 하는 설정
		registry.addResourceHandler("/images/**") // /images/3_3253523452/test.png 이런형태로 접근 가능케 함
		// 위 내용 : /images/라는 경로 뒤에 해당 파일에 접근할 거야
		//.addResourceLocations("file:///C:\\Users\\01.Web개발\\upload\\images/");
		.addResourceLocations("file:///" + FileManagerService.FILE_UPLOAD_PATH);//FileManagerService가 객체생성
		// 없이 사용 가능하도록 static 세팅해 두었음
		// 위 내용 : 어떤 directory에 있는 것을 가져올 지 명확히 해 둠
	}
	
	
	/*
	 * filter는 스프링 포함 된 놈 아니라 spring 사용 제한적. Intercepter는 스프링 특징 사용할 수 있음
	 * preHandle : 들어올 때
	 * postHandle, afterCompletion : 내보낼 때
	 * addPathPatterns : 내가 원하는 주소만 받는 것. /** : 모든 주소
	 * excludePathPatterns : 이거는 interceptor 태우지 말고 controller로 바로 패스함. image나 css 등은 태울 필요 없잖아(/static, 웹페이지에 포함된 거기 때문에)
	 * 
	 * 
	 * */
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 사용법 기반 : 어떤 interceptor를 어느 경로에 저장할 거냐
		registry.addInterceptor(permissionInterceptor)
		.addPathPatterns("/**") // <= 어느 path의 접근을 낚아 챌지. interceptor로 낚아챌 경로들
		.excludePathPatterns("/static/**", "/user/sign_out");
		
		
		
	}
	
	
	
	
	
	
	
}
