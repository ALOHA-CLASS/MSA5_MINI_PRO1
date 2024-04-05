<%@page import="java.util.Base64"%>
<%@page import="posts.service.CateServiceImpl"%>
<%@page import="posts.service.CateService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="posts.model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/layout/admin/common.jsp" />
<%
	CateService cateService = new CateServiceImpl();
	List<Category> categoryList = cateService.list();
	pageContext.setAttribute("categoryList", categoryList);
	
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
					</h1>

					<div class="contents-box">
						<div class="btn-box">
							<a href="${ root }/admin/posts/cate/insert.jsp" class="btn">등록하기</a>
						</div>
						
						<table border="1" class="table-style">
							<thead>
								<tr>
									<th>✅</th>
									<th>ID</th>
									<th>카테고리아이디</th>
									<th>카테고리명</th>
									<th>*글번호</th>
									<th>종류</th>
									<th>등록일자</th>
									<th>수정일자</th>
									<th>🕹</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="cate" items="${ categoryList }">
									<tr>
										<td class="flex j-center a-center"><input type="checkbox" name="" id="${ cate.id }"></td>
										<td>${ cate.id }</td>
										<td>${ cate.categoryId }</td>
										<td>
											<a href="${ root }/admin/posts/cate/update.jsp?id=${ cate.id }"></a>
											${ cate.name }
										</td>
										<td>${ cate.postNo }</td>
										<td>${ cate.type }</td>
										<td>
											<fmt:formatDate value="${cate.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
											<fmt:formatDate value="${cate.updDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
											<div class="btn-box">
												<a href="${ root }/admin/posts/cate/update.jsp?id=${ cate.id }" class="btn">수정</a>
												<a href="${ root }/admin/posts/cate/delete.jsp?id=${ cate.id }" class="btn">삭제</a>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

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