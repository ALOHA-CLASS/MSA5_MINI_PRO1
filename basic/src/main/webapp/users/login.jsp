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
	<title>로그인</title>
	<jsp:include page="/layout/link.jsp" />
</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="/layout/header.jsp" />
	
	<!-- 컨텐츠 -->
	<div class="container">

		<form action="${ root }/users/login_pro.jsp" method="post">
			<div class="form-box m-auto">
				<div class="inner mb-3">
					<h3 class="txt-main txt-c">로그인</h3>
					<div class="input-group flex d-column">
						<label for="username">아이디</label>
						<input class="form-style" type="text" name="username" id="username" placeholder="아이디">
					</div>
					<div class="input-group flex d-column">
						<label for="password">비밀번호</label>
						<input class="form-style" type="password" name="password" id="password" placeholder="비밀번호">
					</div>
					<div class="input-group flex j-space-around">
						<div class="item">
							<input type="checkbox" name="rememberId" id="remember-id" />
							<label for="remember-id">아이디 저장</label>
						</div>
						<div class="item">
							<input type="checkbox" name="rememberMe" id="remember-me" />
							<label for="remember-me">자동 로그인</label>
						</div>
					</div>
				</div>
				<div class="btn-box flex d-column row-gap-1">
					<button type="submit" class="btn">로그인</button>
					<a href="${ root }/users/join.jsp" class="btn">회원가입</a>
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