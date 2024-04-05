<%@page import="posts.model.Category"%>
<%@page import="java.util.List"%>
<%@page import="posts.service.CateServiceImpl"%>
<%@page import="posts.service.CateService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/layout/common.jsp" />
<%
	// 게시글 카테고리 가져오기
	CateService cateService = new CateServiceImpl();
	List<Category> categoryList = cateService.list();
	pageContext.setAttribute("categoryList", categoryList);
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글쓰기</title>
	<jsp:include page="/layout/link.jsp" />
</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="/layout/header.jsp" />
	
	<!-- 컨텐츠 -->
	<div class="container">
<%-- 		<form action="${ root }/posts/insert_pro.jsp" method="post" > --%>
		<form action="${ root }/posts/insert_pro.jsp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="usersId" id="users-id" value="${ sessionScope.usersId }" />
			<input type="hidden" name="username" id="username" value="${ sessionScope.loginId }"  />
			<div class="form-box m-auto">
				<div class="inner mb-3">
					<h3 class="txt-main txt-c">글쓰기</h3>
					<div class="input-group flex d-column">
						<select name="cateId" id="type" class="form-style">
							<c:forEach var="category" items="${ categoryList }">
								<option value="${ category.id }" >${ category.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="input-group flex d-column">
						<label for="title">제목</label>
						<input class="form-style" type="text" name="title" id="title" placeholder="제목">
					</div>
					<div class="input-group flex d-column">
						<label for="content">내용</label>
						<textarea class="form-style" rows="10" cols="" name="content" id="content" placeholder="내용"></textarea>
					</div>
					<div class="input-group flex d-column">
						<label for="thumbnail">썸네일</label>
						<input class="form-style" type="file" name="thumbnail" id="thumbnail" >
					</div>
					<div class="input-group flex d-column">
						<label for="file">파일</label>
						<input class="form-style" type="file" name="file" id="file" multiple>
					</div>
				</div>
				<div class="btn-box flex d-column row-gap-1">
					<button type="submit" class="btn">등록하기</button>
					<a href="javascript: history.back();"  class="btn">뒤로가기</a>
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