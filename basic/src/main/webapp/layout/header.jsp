<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="container ">
        <!-- util -->
        <div class="util p-1">
        	<c:set var="loginId" value="${ sessionScope.loginId }" />
        	
        	<!-- 비 로그인시 -->
        	<c:if test="${ loginId == null ||  loginId.equals('') }">
	            <ul class="flex j-end gap-1">
	                <li><a href="${root}/users/login.jsp">로그인</a></li>
	                <li><a href="${root}/users/join.jsp">회원가입</a></li>
	            </ul>
        	</c:if>
        	<!-- 비 로그인시 -->
        	<c:if test="${ loginId != null && !loginId.equals('') }">
        		<ul class="flex j-end gap-1">
	                <li><a href="${root}/users/mypage.jsp">마이페이지</a></li>
	                <li><a href="${root}/users/logout.jsp">로그아웃</a></li>
	            </ul>
        	</c:if>
        </div>
        <!-- gnb -->
        <div class="gnb flex j-space-between a-center p-1 border-1">
            <div class="logo-box">
                <a href="">
                    <img src="${root}/static/img/logo.png" width="40" />
                </a>
            </div>
            <nav class="menu">
                <ul>
                    <li><a href="${root}/posts/list.jsp">게시판</a></li>
                    <li><a href="${root}/about.jsp">소개</a></li>
                </ul>
                <button class="menu-toggle">&#9776;</button> <!-- 햄버거 아이콘 -->
            </nav>
        </div>
</header>






