package com.lytear.memo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lytear.memo.common.FileManagerService;

@Configuration

// 저장된 파일을 모든 사람들이 볼 수 있게 설정
public class WebMvcConfig implements WebMvcConfigurer{

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
	
}
