<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!-- hashing: 사람이 볼 수 있는 형태로 바꾸는 복호화 기능 없음(까먹으면 알려주지 않고 새로 설정)
1) md5 : 중복 가능성 수십억분의 1. 속도 2) 보다 빠름. 우리는 이거 사용
2) sha128 : 중복 가능성 천문학적. 좀더 최신 방법


 -->
    
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
				<!-- 일반적으로 로그인과 회원가입만 엔터치고 화면 넘어가게, 그 외에는 버튼 클릭이 안정적  -->
				<!--방법2(삭제)  <form method="post" action="/user/sign_up" id="signupForm">-->
				<form id="signupForm">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">🚺</span>
						</div>
						<input type="text" placeholder="UserID" name="loginId" id="idInput" class="form-control">
					</div>
					
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">🔑</span>
						</div>
						<input type="password" placeholder="●●●●"  name="password"  id="passwordInput" class="form-control ">
					</div>
					
					<input type="text" placeholder="비밀번호 확인"  name="passwordConfirm"  id="passwordConfirmInput" class="form-control mb-3">
					<input type="text" placeholder="이름"  name="name"  id="nameInput" class="form-control mb-3">
					<input type="text" placeholder="이메일 주소"  name="email"  id="emailInput" class="form-control mb-3">
					
					<button type="submit" class="btn btn-success form-control">가입</button>
				</form>
				
				<!-- 방법2(type=button) <button type="button" class="btn btn-success form-control" id="addBtn">가입</button>-->	
				<!--방법2(삭제)  </form>-->
			</div>
		</section>
		
		
		<footer class="bg-secondary text-light text-center">
			Copyright 2018. memo all rights reserved.
		
		</footer>
		
	
	</div>
	<script>
		$(document).ready(function(){
			
			/* 방법2: 버튼 클릭 이벤트
			$("#addBtn").on("click",function(){
			*/
				/*
				방법1: submit + e.preventDefault를 통해 고유 가능 삭제
				*/
			$("#signupForm").on("submit",function(e){
				e.preventDefault();// a tag에 # 붙여 스크롤할 때 클릭이벤트 없을 때도 사용 가능
				
				var id = $("#idInput").val().trim();
				var password = $("#passwordInput").val().trim();
				var passwordConfirm = $("#passwordConfirmInput").val().trim();
				var name = $("#nameInput").val().trim();
				var email = $("#emailInput").val().trim();
				//alert(id);
				if(id == null || id == "") {
					alert("id를 입력하세요");
					return;
				}
				
				if(password == null || password == "") {
					alert("비밀번호를 입력하세요");
					return;
				}
				
				if(passwordConfirm == null || passwordConfirm == "") {
					alert("비밀번호 확인을 입력하세요");
					return;
				}
				
				if(password != passwordConfirm) {
					alert("비밀번호가 일치하지 않습니다");
					return;
				}
				
				if(name == null || name == "") {
					alert("이름을 입력하세요");
					return;
				}
				if(email == null || email == "") {
					alert("이메일을 입력하세요");
					return;
				}
				
				$.ajax({
					//alert("여기까지 OK");
					type: "post",
					url: "/user/sign_up",
					//loginId라는 서버에서 받을 파라미터(키, input의 name=""안의 값) 이름으로, 값은 id라는 변수(사용자가 입력해 놓은 var name 변수에 있는 값)에 들어있다
					//passwordConfirm은 확인용이지 server로 전달할 용도가 아니므로 4가지만 전달
					data: {"loginId":id,"password":password,"name":name,"email":email},
					success:function(data) {
						//alert(data);
						
						if(data.result == "success"){
							//alert("회원가입 성공");
							location.href="/user/signin_view";
						} else {
							alert("회원가입 실패");
						}
						
					},
					error:function(e) {
						alert("error");
					}
				
				
				});
			});
			
		});
	</script>
</body>
</html>