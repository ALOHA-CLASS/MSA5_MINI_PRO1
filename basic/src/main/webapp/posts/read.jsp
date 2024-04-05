<%@page import="files.dto.Files"%>
<%@page import="java.util.List"%>
<%@page import="files.service.FileServiceImpl"%>
<%@page import="files.service.FileService"%>
<%@page import="posts.model.Posts"%>
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
	// 게시글
	String id = request.getParameter("id");
	PostService postService = new PostServiceImpl();
	Posts post = postService.select(id);
	pageContext.setAttribute("post", post);
	
	// 파일 목록
	FileService fileService = new FileServiceImpl();
	
	Files file = new Files();
	file.setParentName("posts");
	file.setParentId(id);
	List<Files> fileList = fileService.listByParent(file);
	pageContext.setAttribute("fileList", fileList);
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
		        <div class="btn-box">
					<a href="${ root }/posts/list.jsp" class="btn">목록</a>
		        </div>
		    </div>
		    
		    <form action="${ root }/posts/delete.jsp" method="post">
				<div class="form-box m-auto">
					<div class="inner mb-3">
						<h3 class="txt-main txt-c">${ post.title }</h3>
						<div class="input-group flex d-column">
							<label for="username">작성자</label>
							<input class="form-style" type="text" name="username" id="username" 
									value="${ post.username }">
						</div>
						<div class="input-group flex d-column">
							<label for="content">내용</label>
							<textarea rows="10" cols="" name="content" id="content">${ post.content }</textarea>
						</div>
						<div class="input-group flex d-column">
							<label for="content">파일 목록</label>
							<c:forEach var="file" items="${ fileList }">
								<ul>
									<li>
										<a href="${ root }/file?id=${ file.id }">${ file.fileName } [다운로드]</a>
									</li>
								</ul>
								
							</c:forEach>
						</div>
					</div>
					<div class="btn-box flex d-column row-gap-1">
						<button type="submit" class="btn">가입하기</button>
						<a href="${ root }/" class="btn">메인화면</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<!-- 푸터 -->
	<jsp:include page="/layout/footer.jsp" />
	
	<!-- 스크립트 -->
	<jsp:include page="/layout/script.jsp" />
</body>
</html>