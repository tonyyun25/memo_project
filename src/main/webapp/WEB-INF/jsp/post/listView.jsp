<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
	<!--  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<link rel="stylesheet" href="/static/css/style.css" type="text/css">
	<title>메모 입력</title>
</head>
<body>
	<!-- id : sugar  pw: 111 -->


	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<section>
			<div class="d-flex justify-content-center">
				<div class="w-75 my-5">			
					<h1 class="text-center"> 메모 리스트 </h1>
				
					<table class="table text-center">
						<thead>
							<tr>
							<th>No.</th>
							<th>제목</th>
							<th>시간</th>
							<tr>
						</thead>
						
						<tbody>
							<c:forEach var="memo" items="${memoList }" >
							<tr>
								<td>${memo.id }</td>
								<td><a href="/post/detail_view?id=${memo.id }">${memo.subject } </a></td>
								<td><fmt:formatDate value="${memo.createdAt }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
							</c:forEach>
						</tbody>
					</div>
				</table>
				<!-- 글쓰기 버튼은 기능이 링크 이동이라 a tag -->
				<!-- div 없이 a tag 자체에는 text-right 안 먹힘. in-line(줄 바꿈 X) => text-right 먹힘 -->
				
				<div class="text-right">
					<a href="/post/create_view" class="btn btn-info">글쓰기</a>
				</div>
				
			</div>
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		
		
		
</body>
</html>