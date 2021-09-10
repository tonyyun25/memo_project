<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		
		
		<section class="d-flex content justify-content-center align-items-center">
			<div class="login-box">
				
				<form id="signupForm">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">🚺</span>
						</div>
						<input type="text" placeholder="Username"  name="id" id="idInput" class="form-control">
					</div>
					
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">🔑</span>
						</div>
						<input type="password" placeholder="●●●●"  name="password"  id="passwordInput" class="form-control ">
					</div>
					
					<input type="text" placeholder="비밀번호 확인"  name="confirmPassword"  id="confirmPasswordInput" class="form-control mb-3">
					<input type="text" placeholder="이름"  name="name"  id="nameInput" class="form-control mb-3">
					<input type="text" placeholder="이메일 주소"  name="email" id="emailInput" class="form-control mb-3">
					
					<button class="btn btn-success form-control" id="signUpBtn">가입</button>
				</form>
			</div>
		</section>
		
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		
	
	</div>
</body>
</html>