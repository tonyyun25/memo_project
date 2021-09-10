<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 게시판 - 로그인</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
		
		<!--  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
		<!-- 아래는 디렉토리 경로가 아니라 url 창에 적은 것 같은 접근 경로임
		webapp 경로는 src 바로 아래가 아니라 src 밑에 main 밑에 오도록 수정
		 -->
		<link rel="stylesheet" href="/static/css/style.css" type="text/css">
		
		
</head>
<body>
	<!-- 접속 테스트 : localhost:8080/css/style.css 
	다른 path와 겹칠수 있기 때문에 앞에 static 키워드 붙인다
	application.yml 에 설정 추가 후
	 localhost:8080/static/css/style.css 로 접속 
	-->
	<div id="wrap" >
		<header class="bg-secondary text-light">
			<!-- 아래 memo 앞에 mt-3을 주면 Memo가 아닌 상단 header에 마진이 잡히는 마진 상쇄 발생  -->
			<h1 class="ml-3 pt-1">Memo</h1>
		
		</header>
		
		<section class="content d-flex justify-content-center align-items-center">
			<!-- 전체 div가 400인데 위에 align 주면 안 먹히고 밑에 주어야 한다 1) section 자체 높이 준 뒤
			loginbox 높이 없이 여기에 가운데 정렬 -->
			<div class="login-box">
				<h2 class="text-center">로그인</h2>
				<form>
					<input type="text" class="form-control" placeholder="아이디를 입력하세요">
					<input type="password" class="form-control mt-3" placeholder="비밀번호를 입력하세요">
					<input type="submit" class="btn btn-info btn-block mt-3" value="로그인">
					
				</form>
				<div class="text-right mt-2"> <!-- inline 속성인 애를 클래스 주려고 div -->
					<a href="/user/signup_view">회원가입</a>
				</div>
				
			</div>
		</section>
		
		<footer class="bg-secondary text-light text-center">
			Copyright 2018. memo all rights reserved.
		
		</footer>
		
		
	</div>

</body>
</html>