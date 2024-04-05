<%@page import="posts.service.CateServiceImpl"%>
<%@page import="posts.service.CateService"%>
<%@page import="posts.model.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String id = request.getParameter("id");
	
	CateService cateService = new CateServiceImpl();
	int result = cateService.delete(id);
	
	String root = request.getContextPath();
	
	if( result > 0 ) { 
		response.sendRedirect(root + "/admin/posts/cate/index.jsp");
		return;
	}
	
	// 삭제 실패
	else {
		// 뒤로가기 (이전페이지로 돌아가기)
		String previousPageURL = request.getHeader("Referer");
		response.sendRedirect(previousPageURL);
	}
	
	
%>