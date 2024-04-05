<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/layout/common.jsp" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입</title>
	<jsp:include page="/layout/link.jsp" />
</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="/layout/header.jsp" />
	
	<!-- 컨텐츠 -->
	<div class="container">

		<form action="${ root }/users/join_pro.jsp" method="post">
			<div class="form-box m-auto">
				<div class="inner mb-3">
					<h3 class="txt-main txt-c">회원 가입</h3>
					<div class="input-group flex d-column">
						<label for="username">아이디</label>
						<input class="form-style" type="text" name="username" id="username" placeholder="아이디">
					</div>
					<div class="input-group flex d-column">
						<label for="password">비밀번호</label>
						<input class="form-style" type="password" name="password" id="password" placeholder="비밀번호">
					</div>
					<div class="input-group flex d-column">
						<label for="password-chk">비밀번호 확인</label>
						<input class="form-style" type="password" name="passwordChk" id="password-chk" placeholder="비밀번호 확인">
					</div>
					<div class="input-group flex d-column">
						<label for="name">이름</label>
						<input class="form-style" type="text" name="name" id="name" placeholder="이름">
					</div>
					<div class="input-group flex d-column">
						<label for="email">이메일</label>
						<input class="form-style" type="text" name="email" id="email" placeholder="이메일">
					</div>
				</div>
				<div class="btn-box flex d-column row-gap-1">
					<button type="submit" class="btn">가입하기</button>
					<a href="${ root }/" class="btn">메인화면</a>
				</div>
			</div>
		</form>
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="/layout/footer.jsp" />
	
	<!-- 스크립트 -->
	<jsp:include page="/layout/script.jsp" />
</body>
</html>