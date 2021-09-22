<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
	<header class="d-flex justify-content-between align-items-center bg-secondary text-light ">
		<!-- 아래 memo 앞에 mt-3을 주면 Memo가 아닌 상단 header에 마진이 잡히는 마진 상쇄 발생  -->
		<h1 class="ml-3 pt-1">Memo</h1>
		<c:if test="${not empty userName }" >
			
			<div class="text-white mr-3">
				<!-- ${userName } 님 [로그아웃] -->
				${userName } 님 <a href="/user/sign_out">[로그아웃]</a><!-- ajax로도 가능하나 좀더 단순한 링크로 작업 -->
				<!-- tomo / 123, sugar / 111로 새로 가입해서
				signin_view 로 전환해도, 로그인해도 아이유님[로그아웃]으로 안 바뀌고 토모님[로그아웃] 나옴-->
			</div>
		</c:if>
		
		
	</header>