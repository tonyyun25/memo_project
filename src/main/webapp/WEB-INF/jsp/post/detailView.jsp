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
				<h1 class="text-center">메모</h1>
				
				<div class="d-flex my-3">
					<label class="mr-3">제목 : </label>
					<input type="text" class="form-control col-11" id="titleInput" val="${memo.subject }">
					
				</div>
			
				<textarea class="form-control my-3" rows="5" id="contentInput">${memo.content }</textarea>
				
				<img src="${memo.imagePath }">
				
				<div class="d-flex justify-content-between my-3">
					<!--  
					<button type="button" class="btn btn-info">목록으로</button>-->
					<a href="/post/list_view" class="btn btn-info">목록으로</a>
					<button type="button" class="btn btn-success" id="updateBtn">수정</button>
				</div>
			</div>	
			
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>	
<body>

</body>
</html>