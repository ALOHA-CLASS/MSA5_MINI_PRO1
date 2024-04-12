<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- 공통 적용 -->
	<jsp:include page="${ root }/layout/main/import/common.jsp" />
	<jsp:include page="${ root }/layout/main/import/meta.jsp" />
	<jsp:include page="${ root }/layout/main/import/link.jsp" />
</head>
<body>   
	<jsp:include page="${ root }/layout/main/UI/header.jsp" />
	<div class="px-4 py-5 mt-5 text-center">
		<h1 class="display-5 fw-bold text-body-emphasis">회원 가입</h1>
	</div>
	
	<!-- 회원 가입 영역 -->
	<div class="container shop p-5 mb-5" >
		<form action="join_pro.jsp" name="joinForm" method="post" onsubmit="return checkUser()">
			<input type="hidden" name="duplicaed" id="duplicaed" value="false" /> 
			<div class="input-group mb-3 row">
				<label for="username" class="input-group-text col-md-4" id="lb_username">아이디</label>
				<input type="text" class="form-control col-md-6" 
					   name="username" id="username" placeholder="아이디" required>
				<button type="button" onclick="clickIdCheck()" class="btn btn-success col-md-2">중복확인</button>
			</div>
			
			<div class="input-group mb-3 row">
				<label for="password" class="input-group-text col-md-4" id="lb_password">비밀번호</label>
				<input type="password" class="form-control col-md-8" 
					   name="password" id="password" placeholder="비밀번호" required>
			</div>
			
			<div class="input-group mb-3 row">
				<label for="password_confirm" class="input-group-text col-md-4" id="lb_password_confirm">비밀번호 확인</label>
				<input type="password" class="form-control col-md-8" 
					   name="password_confirm" id="password_confirm" placeholder="비밀번호 확인" required>
			</div>
			
			<div class="input-group mb-3 row">
				<label for="name" class="input-group-text col-md-4" id="lb_name">이름</label>
				<input type="text" class="form-control col-md-8" 
					   name="name" id="name" placeholder="이름" required>
			</div>
			
			<div class="input-group mb-3 row">
				<label for="email" class="input-group-text col-md-4" id="lb_email">이메일</label>
				<div class="row justify-content-between col-md-8 align-items-center p-0">
					<div class="col-sm-5 col-md-5 px-0">
						<input type="text" class="form-control" 
							   name="email" id="email" placeholder="이메일">
					</div>
				</div>
			</div>
			
			<div class="d-grid gap-2 mt-5 mb-5 d-md-flex justify-content-md-between">
				<a href="javascript: history.back()" class="btn btn-lg btn-secondary">취소</a>
				<input type="submit" class="btn btn-lg btn-primary" value="가입" />
			</div>	
		</form>
	</div>
	<jsp:include page="${ root }/layout/main/UI/footer.jsp" />
	
	<!-- script -->	
	<jsp:include page="${ root }/layout/main/import/script.jsp" />
	
	<script>
		function clickIdCheck() {
			
			idCheck().then(result => {
				let check = result 
				if( check ) {
					alert('중복된 아이디 입니다.')
				} else {
					alert('사용 가능한 아이디 입니다.')
				}
			})
			
		}
	</script>
</body>
</html>