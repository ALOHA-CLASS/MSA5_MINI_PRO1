<%@page import="java.util.ArrayList"%>
<%@page import="posts.model.CategoryType"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@page import="posts.service.CateServiceImpl"%>
<%@page import="posts.service.CateService"%>
<%@page import="posts.model.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/layout/admin/common.jsp" />
<%
	
	String id = request.getParameter("id");
	CateService cateService = new CateServiceImpl();
	Category category = cateService.select(id);
	pageContext.setAttribute("category", category);
	
	List<CategoryType> categoryTypeList = new ArrayList<CategoryType>();
	categoryTypeList.add( new CategoryType("board", "게시판") );
	categoryTypeList.add( new CategoryType("gallery", "갤러리") );
	pageContext.setAttribute("categoryTypeList", categoryTypeList);

%>
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
				<div class="inner p-2">
					<h1>
						<a href="${ root }/admin/posts/index.jsp">게시판 관리</a>
						&gt; 
						<a href="${ root }/admin/posts/cate/index.jsp">카테고리 관리</a>
						&gt; 
						<a href="${ root }/admin/posts/cate/insert.jsp">카테고리 등록</a>
					</h1>

					<div class="contents-box">
						<form action="${ root }/admin/posts/cate/update_pro.jsp" method="post">
							<input type="hidden" name="id" value="${ category.id }">
							<div class="form-box m-auto">
								<div class="inner mb-3">
									<h3 class="txt-main txt-c">카테고리</h3>
									<div class="input-group flex d-column">
										<label for="category-id">카테고리 아이디</label>
										<input class="form-style" type="text" name="categoryId" id="category-id" placeholder="카테고리 아이디"
												value="${ category.categoryId }">
									</div>
									<div class="input-group flex d-column">
										<label for="category-name">카테고리명</label>
										<input class="form-style" type="text" name="categoryName" id="category-name" placeholder="카테고리명"
												value="${ category.name }">
									</div>
									<div class="input-group flex d-column">
										<label for="type">타입</label>
										<select name="type" id="type" class="form-style">
											<c:forEach var="item" items="${ categoryTypeList }">
												<c:if test="${ item.typeCode eq category.type }">
													<option value="${ item.typeCode }" selected>${ item.typeName }</option>
												</c:if>
												<c:if test="${ item.typeCode ne category.type }">
													<option value="${ item.typeCode }" >${ item.typeName }</option>
												</c:if>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="btn-box flex d-column row-gap-1">
									<button type="submit" class="btn">수정하기</button>
									<a href="${ root }/admin/posts/cate/delete.jsp?id=${ category.id }" class="btn">삭제하기</a>
									<a href="javascript: history.back();" class="btn">뒤로가기</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			
			<!-- 푸터 -->
			<jsp:include page="/layout/admin/footer.jsp" />

		</section>
	</div>

	
	<!-- 스크립트 -->
	<jsp:include page="/layout/admin/script.jsp" />
</body>
</html>