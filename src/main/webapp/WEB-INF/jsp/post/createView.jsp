<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 입력</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
	<!--  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<link rel="stylesheet" href="/static/css/style.css" type="text/css">
		
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
	
		<section class="d-flex justify-content-center">
			<div class="w-75 my-4">
				<h1 class="text-center">메모 입력</h1>
				
				<div class="d-flex my-3">
					<label class="mr-3">제목 : </label>
					<input type="text" class="form-control col-11" id="titleInput">
				</div>
			
				<textarea class="form-control my-3" rows="5" id="contentInput"></textarea>
				<!-- form controller 하면 row만 정해주면 됨 -->
				<!-- MIME text/html image/jpeg. MIME: 네트워크 통신시 타입을 나타내는 표준 -->
				<input type="file" accept="image/*" id="fileInput"><!-- multiple:파일 여러개 선택 가능 -->
				<!-- <input type="file" accept="image/*" id="fileInput" multiple> -->
				<div class="d-flex justify-content-between my-3">
					<!--  
					<button type="button" class="btn btn-info">목록으로</button>-->
					<a href="/post/list_view" class="btn btn-info">목록으로</a>
					<button type="button" class="btn btn-success" id="saveBtn">저장</button>
				</div>
			</div>	
			
			
			
		</section>
	
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		
	</div>
	<script>
	$(document).ready(function(){
		$("#saveBtn").on("click", function(){
			
			//alert("확인");
			var title = $("#titleInput").val();
			var content = $("#contentInput").val().trim();
			
			if(title == null || title == "") {
				alert("제목을 입력하세요");
				return;
			}
			if(content == null || content == "") {
				alert("내용을 입력하세요");
				return;
			}
			
			var formData = new FormData();//FormData: JS 내부에 있는 클래스. 아래 ajax의 data:와 같은 역할. 객체 형태 사용
			formData.append("subject", title);
			formData.append("content", content);
			formData.append("file", $("#fileInput")[0].files[0]);//뒤 : 해당하는 input 파일 안에 들어있는 실제 파일을 꺼냄
			// 파일 여러개 가져올 경우 files 배열에 쭉 저장, 하나만 가져오므로 files[0] 번째 값
			
			$.ajax({
				enctype: "multipart/form-data", // 파일업로드 필수. 이 형태로 요청 던지겠다.
				processData: false, //파일업로드 필수. 우리가 전달할 것은 request parameter 형태가 
				//되어야 하는데 이것을 ajax가 기존 data 중괄호 안에서 키:밸류 값으로 만드는게 true이고 여기선 그 과정을 안 하겠다
				contentType: false,//파일업로드 필수
				//alert("확인"); // AJAX 첫쨰 줄에 끝에 세미콜론 들어가는 alert 붙이면 에러 발생
				type: "post",
				url:"/post/create",
				//data: {"subject":title,"content":content},//"파라미터":우리가 만든 변수. 파일의 이 형태로 전달 불가
				data: formData,
				success: function(data) {
					
					if(data.result == "success"){
						//alert("삽입 성공");
						//location.href="/user/signin_view";
						location.href="/post/list_view";
					} else {
						alert("삽입 실패");
					}
					
				},
				error: function(e) {
					alert("error");
				}
				
			});
		});
	
	});
	</script>


</body>
</html>