<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="container ">
        <!-- gnb -->
        <div class="gnb flex j-space-between a-center p-1 border-y-1">
            <div class="logo-box">
                <a href="">
                    <img src="${root}/static/img/logo.png" width="40" />
                </a>
            </div>
            <nav class="menu">
                <ul>
                    <li><a href="${root}/">Home</a></li>
                    <li><a href="${root}/board/list.jsp">Board</a></li>
                    <li><a href="${root}/gallery/list.jsp">Gallery</a></li>
                    <li><a href="${root}/about.jsp">About</a></li>
                </ul>
                <button class="menu-toggle">&#9776;</button> <!-- 햄버거 아이콘 -->
            </nav>
        </div>
</header>






