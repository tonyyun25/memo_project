package com.lytear.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileManagerService {

	//private final String FILE_UPLOAD_PATH = "C:\\Users\\01.Web개발\\memo\\upload\\images/";
	public final static String FILE_UPLOAD_PATH = "C:\\Users\\01.Web개발\\memo\\upload\\images/";
	// 프로그램의 안(즉 sts-4.11.1.RELEASE 안)에 디렉토리 잡으면 안 됨에 유의
	
	
	// 멤버 변수가 있지만 static으로 씀 => 에러 발생 1) this.가 없으므로 2) 객체 생성 안 되면 멤버 변수 안 만들어지므로 File upload path 사용 불가
	// 단, 멤버 변수 자체도 static 하면 객체 생성 없이 메소드는 static 형태로 사용 가능
	
	
	// Logger를 사용하고자 public String saveFile으로 변경시에도 private final static 은 그대로 둔 상태에서
	// 다른 곳에서 FILE_UPLOAD_PATH 사용 가능. Static 메소드 안에서 다른 변수 못 씀. static 변수는 다른 곳에서 씀
	
	//public String saveFile(int userId, MultipartFile file) {//userID와 파일 객체 가져옴 => 파일 저장할 유일 디렉토리 위해 id 가져옴
	public static String saveFile(int userId, MultipartFile file) {	
		
		/*객체 생성 없이 메소드 사용 위해 static 씀 : public String saveFile -> public static String saveFile
		 * 1. Logger logger = LoggerFactory.getLogger(this.getClass()); : this.getClass() 에러
		 * 2. String filePath = FILE_UPLOAD_PATH + directoryName; : FILE_UPLOAD_PATH 에러
		 *    -> 객체 생성이 안 되면 위의 public final static String FILE_UPLOAD_PATH 멤버 변수 사용 안 됨
		 * 1번은 Logger 세 군데 주석 처리
		 * 2는 맨 위의 public final String FILE_UPLOAD_PATH 멤버 변수 자체를 static 처리 하면 됨 => static에서
		 *   static 변수 사용 가능
		 */
		/*
		 * 파일 경로
		 * 1. 올린 사람의 id로 구분해서 저장
		 * 2. 올린 시간을 기준으로 구분한다.
		 * /43_281281298129/test.png => 시간 표현 방식
		 * 1970년 1월 1일 을 기주으로 몇 밀리초(1/1000)가 지났는지
		 * 
		 * 
		 * 
		 * */
		
//		Logger logger = LoggerFactory.getLogger(this.getClass());
		
		
		//43_281281298129/
		String directoryName = userId + "_" + System.currentTimeMillis() + "/";//디렉토리라서 끝에 slash
		 
		//C:\\Users\\01.Web개발\\upload\\images/43_281281298129/
		//윈도우 사용 디렉토리는 \\ 프로그램에서 사용되는 디렉토리 구조는 / 구조로 잡힘. 이부분만 건들고 다른 부분 손대리 않을 수 있도록
		String filePath = FILE_UPLOAD_PATH + directoryName;// 문자열 형태
		
		//디렉토리 생성
		File directory = new File(filePath);//디렉토리도 결국 파일이라 파일 다루는 형태로 저장. 파일 객체	
		if(directory.mkdir() == false) { //mkdir 라는 메소드 통해 디렉토리 생성 => 실패할 수 있다 (경로 실수 등)
			// 디렉토리 생성 에러
			//logger.error("[FileManagerService saveFile] 디렉토리 생성 에러");
			return null;//return 이 null이 되면 리턴이 된 것을 표시
		}	
		//실제 파일 저장 과정 ==> byte 배열 형태 변수 있어야 함
		// byte[]
		try {
			byte[] bytes = file.getBytes();
			// 파일 경로를 path 객체로 만듦. 지금은 문자가 아닌 path 라고 하는 경로 관리 클래스 객체
			Path path = Paths.get(filePath + file.getOriginalFilename());//filePath: 디렉토리
			// 파일 저장
			Files.write(path, bytes);//어디에 뭘 저장(쓴다)한다.//path(경로) 에 bytes(파일) 저장
			
		} catch (IOException e) {
			//logger.error("[FileManagerService saveFile] 파일 생성 실패");
			e.printStackTrace();
			return null;
		}
		
		// 파일을 접근할 수 있는 경로를 리턴해서 이를 DB에 저장
		// <img src="/images/43_281281298129/test.png"> 이 안에 들어갈 경로
		// /images: static 접근하는 것과 같은 접근경로 설정, 43_281281298129: directoryName이라는 변수에 저장된 디렉토리
		return "/images/" + directoryName + file.getOriginalFilename();// => DB에 저장
		
		// 이제 BO에서 이 메소드 호출
	}
	
	
	
}
