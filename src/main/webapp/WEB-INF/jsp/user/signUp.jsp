<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 게시판 - 회원 가입</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
		
		<!--  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	
		<link rel="stylesheet" href="/static/css/style.css" type="text/css">
		

</head>
<body>
	<div id="wrap" >
		<header class="bg-secondary text-light">
			<!-- 아래 memo 앞에 mt-3을 주면 Memo가 아닌 상단 header에 마진이 잡히는 마진 상쇄 발생  -->
			<h1 class="ml-3 pt-1">Memo</h1>
		
		</header>
		
		
		<section class="d-flex content justify-content-center align-items-center">
			<div class="login-box">
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">🚺</span>
					</div>
					<input type="text" placeholder="UserID" name="idInput" class="form-control">
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">🔑</span>
					</div>
					<input type="password" placeholder="●●●●"  name="passwordInput" class="form-control ">
				</div>
				
				<input type="text" placeholder="비밀번호 확인"  name="confirmPasswordInput" class="form-control mb-3">
				<input type="text" placeholder="이름"  name="nameInput" class="form-control mb-3">
				<input type="text" placeholder="이메일 주소"  name="emailInput" class="form-control mb-3">
				
				<button class="btn btn-success form-control" id="signUpBtn">가입</button>
			</div>
		</section>
		
		
		<footer class="bg-secondary text-light text-center">
			Copyright 2018. memo all rights reserved.
		
		</footer>
		
	
	</div>
</body>
</html>