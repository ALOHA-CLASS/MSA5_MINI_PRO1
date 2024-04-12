<%--
	회원 가입 처리
--%> 
<%@page import="users.service.UserService"%>
<%@page import="users.service.UserServiceImpl"%>
<%@page import="users.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Users user = new Users();
	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	user.setUsername(username);
	user.setPassword(password);
	user.setName(name);
	user.setEmail(email);
	
	// 회원 정보 등록 요청
	UserService userService = new UserServiceImpl();
	int result = userService.join(user);
	
	String root = request.getContextPath();
	if( result > 0  ) {
		// 로그인 화면으로 이동
		response.sendRedirect(root + "/users/login.jsp");
	} else {
		// 회원가입 페이지로 이동
		response.sendRedirect(root + "/users/join.jsp?error");		
	}
	
%>






