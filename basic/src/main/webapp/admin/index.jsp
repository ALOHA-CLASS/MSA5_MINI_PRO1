<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/layout/admin/common.jsp" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<jsp:include page="/layout/admin/link.jsp" />
</head>
<body>

	<div class="side-layout admin">
		<div class="side">
			<!-- 사이드바 -->
			<jsp:include page="/layout/admin/sidebar.jsp" />
		</div>

		<section class="main">
			<!-- 헤더 -->
			<jsp:include page="/layout/admin/header.jsp" />
			
			<!-- 컨텐츠 -->
			<div class="container">
				
			</div>
			
			<!-- 푸터 -->
			<jsp:include page="/layout/admin/footer.jsp" />

		</section>
	</div>

	
	<!-- 스크립트 -->
	<jsp:include page="/layout/admin/script.jsp" />
</body>
</html>