<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="light">
<head>
	<meta charset="UTF-8">
	<jsp:include page="<%= request.getContextPath() %>/layout/main/import/common.jsp" />
	<jsp:include page="${ root }/layout/main/import/meta.jsp" />
	<jsp:include page="${ root }/layout/main/import/link.jsp" />
</head>
<body>
	<jsp:include page="${ root }/layout/main/UI/header.jsp" />

	<div class="container">
		<div class="px-4 pt-5 my-5 text-center border-bottom">
			<h1 class="display-4 fw-bold">게시판 프로젝트</h1>
			<div class="col-lg-6 mx-auto">
				<p class="lead mb-4">JSP 게시판 프로젝트 입니다.</p>
				<div class="d-grid gap-2 d-sm-flex justify-content-sm-center mb-5">
					<button type="button" class="btn btn-primary btn-lg px-4 me-sm-3">게시글
						목록</button>
					<button type="button" class="btn btn-outline-secondary btn-lg px-4">로그인</button>
				</div>
			</div>
			<div class="overflow-hidden">
				<div class="container px-5">
					<img src="https://i.imgur.com/pPxobUQ.jpg" class="img-fluid border rounded-3 shadow-lg mb-4" alt="게시판 프로젝트" width="700" height="500" loading="lazy">
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="${ root }/layout/main/UI/footer.jsp" />
	<jsp:include page="${ root }/layout/main/import/script.jsp" />
</body>
</html>