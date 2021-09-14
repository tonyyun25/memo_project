package com.lytear.memo.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * 암호화 포함 공통적으로 사용하는 클래스 저장을 위해 memo.common 패키지 생성
 * 
 * private static int tmp;   ==> 프로그램 실행과 동시에 실행. 클래스명으로 사용
 * */
public class EncryptUtils {
	// 객체 생성 가장 큰 목적 : 멤버 변수를 저장하기 위한 공간을 확보 목적. 객체 생성 순간 메모리에 올라감
	// 암호화 메소드 : 암호화된 결과 돌려줘야 하니 리턴 타입은 String
	// (String 암호)인데 좀더 포괄적 사용 위해 message 변수 사용
	
	public static String md5(String message) {//낭비되고 있는 객체 생성 없이 저장 => 단, 이 메소드는 멤버 변수는 사용 불가
	// static : 프로그램 실행됨과 동시에 바로 메모리에 올라가서 이용 가능
	//	public String md5(String message) {
		// 결과를 저장할 문자열
		String encData = "";
		
		try {
			// 아래는 자바 내부에 암호화를 위해 이미 만들어져 있는 것. 뒷부분은 암호화할 알고리즘
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 1byte = 8bit = 10101011
			// asdf -> byte로 하나하나씩 바꿈. a = 64 = 1000000 => 이런 숫자가 배열 안에 들어감
			// [1000000, 1010100, 1000101, 101011]
			byte[] bytes = message.getBytes();
			// 위는 배열. 완전 원초적인 형태로 되어야 암호화를 통한 hashing이 가능
			md.update(bytes);
			// [1000000, 1010100, 1000101, 101011]를 아래에서 하나하나씩 다 꺼내서 문자열로 변환
			byte[] digest = md.digest();
			// byte -> 16진수 -> 문자열
			for(int i = 0; i < digest.length; i++) {
				//아래는 논리연산 X 비트 연산 O
				// 16 진수로 암호화된 결과가 6 7 a b e 라면 아래 명령 통해 붙여서 문자열에 저장함 
				
				encData += Integer.toHexString(digest[i] & 0xff);
				//   10100011
				// & 01000101      ===> 16진수로 바꾸기 위한 비트 연산 (아직 알 필욘 X)
				//   00000001
				
			}
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		return encData;
		
	}
	
	
	
}

