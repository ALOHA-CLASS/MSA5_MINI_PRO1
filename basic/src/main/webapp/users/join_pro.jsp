<%@page import="users.service.UserServiceImpl"%>
<%@page import="users.service.UserService"%>
<%@page import="users.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/layout/common.jsp" />
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	Users user = new Users();
	user.setUsername(username);
	user.setPassword(password);
	user.setName(name);
	user.setEmail(email);
	
	// 회원 정보 등록 요청
	UserService userService = new UserServiceImpl();
	int result = userService.join(user);
	
	String root = request.getContextPath(); 
	// 회원가입 성공
	if( result > 0 ) {
		response.sendRedirect(root + "/");
		
		// 회원가입 후 바로 로그인
		session.setAttribute("loginId", user.getId());
	}
	
	// 회원가입 실패
	else {
		response.sendRedirect("join.jsp?error");		// error 은 회원가입 실패
	}
%>






