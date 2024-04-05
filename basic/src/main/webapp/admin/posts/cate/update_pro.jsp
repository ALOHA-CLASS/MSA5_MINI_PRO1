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
    String categoryId = request.getParameter("categoryId");
    String categoryName = request.getParameter("categoryName");
    String type = request.getParameter("type");
	
	Category category = new Category(categoryId, categoryName, type);
	category.setId(id);
	
	CateService cateService = new CateServiceImpl();
	int result = cateService.update(category);
	
	String root = request.getContextPath();
	
	if( result > 0 ) { 
		response.sendRedirect(root + "/admin/posts/cate/index.jsp");
	}
	else {
		response.sendRedirect(root + "/admin/posts/cate/update.jsp?id=" + id +"&error");
	}
	
	
%>