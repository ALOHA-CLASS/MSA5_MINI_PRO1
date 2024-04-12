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
			<h1 class="display-4 fw-bold">로그인 화면</h1>
			<div class="col-lg-6 mx-auto">
				<p class="lead mb-4">로그인 화면입니다.</p>
				<div class="d-grid gap-2 d-sm-flex justify-content-sm-center mb-5">
					<button type="button" class="btn btn-primary btn-lg px-4 me-sm-3">게시글
						목록</button>
					<button type="button" class="btn btn-outline-secondary btn-lg px-4">로그인</button>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="${ root }/layout/main/UI/footer.jsp" />
	<jsp:include page="${ root }/layout/main/import/script.jsp" />
</body>
</html>