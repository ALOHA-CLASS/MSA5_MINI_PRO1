<%@page import="posts.service.CateServiceImpl"%>
<%@page import="posts.model.Category"%>
<%@page import="posts.service.CateService"%>
<%@page import="posts.model.Posts"%>
<%@page import="java.util.List"%>
<%@page import="posts.service.PostServiceImpl"%>
<%@page import="posts.service.PostService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/layout/common.jsp" />
<%
	// 카테고리
	CateService cateService = new CateServiceImpl();
	List<Category> categoryList = cateService.list();
	pageContext.setAttribute("categoryList", categoryList);
	
	// 게시글 목록
	PostService postService = new PostServiceImpl();
	List<Posts> postList;
	
	String cateId = request.getParameter("cateId");

	// 게시글 목록 조회
	
	// 카테고리별 조회
	if( cateId != null && !cateId.equals("") ) {
		postList = postService.listByCateId(cateId);
		Category category = cateService.select(cateId);
		pageContext.setAttribute("category", category);
	}
	// 전체 조회
	else {
		postList = postService.list();
	}
	pageContext.setAttribute("postList", postList);
	
	// 카테고리 정보
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<jsp:include page="/layout/link.jsp" />
</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="/layout/header.jsp" />
	
	<!-- 컨텐츠 -->
	<div class="container">
		
		<div class="inner p-2">
		
		    <div class="contents-box">
		    	<div class="category-box">
					<ul class="flex d-column">
						<c:forEach var="cate" items="${ categoryList }">
							<li><a href="${ root }/posts/list.jsp?cateId=${ cate.id }">${ cate.name }</a></li>
						</c:forEach>
					</ul>
				</div>
		    
		        <div class="btn-box flex j-space-between">
					<div class="item"></div>
					<div class="item">
						<a href="${ root }/posts/insert.jsp" class="btn">글쓰기</a>
					</div>
		        </div>
		        
		        
		        
		        <table border="1" class="table-style">
		            <thead>
		                <tr>
		                    <th>NO</th>
		                    <th>썸네일</th>
		                    <th>제목</th>
		                    <th>작성자</th>
		                    <th>등록일자</th>
		                    <th>수정일자</th>
		                </tr>
		            </thead>
		            <tbody>
		            	<c:if test="${ postList.isEmpty() }">
		            		<tr>
		            			<td align="center" colspan="5">조회된 데이터가 없습니다.</td>
		            		</tr>
		            	</c:if>
		                <c:forEach var="post" items="${postList}">
		                    <tr>
		                        <td>${post.postNo}</td>
		                        <td>
		                        	<img src="${ root }/img?id=${post.thumbnailFileId}" width="100" />
		                        </td>
		                        <td>
		                        	<a href="${ root }/posts/read.jsp?id=${ post.id }">
			                        	${post.title}
		                        	</a>
		                        </td>
		                        <td>${post.username}</td>
		                        <td>
		                            <fmt:formatDate value="${post.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
		                        </td>
		                        <td>
		                            <fmt:formatDate value="${post.updDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
		                        </td>
		                    </tr>
		                </c:forEach>
		            </tbody>
		        </table>
		
		    </div>
		
		</div>
		
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="/layout/footer.jsp" />
	
	<!-- 스크립트 -->
	<jsp:include page="/layout/script.jsp" />
</body>
</html>