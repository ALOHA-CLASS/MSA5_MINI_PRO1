<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="sidebar">

    <div id="sidebar-control" onclick="sidebarControl(this)">
        <div class="inner">
            &LeftAngleBracket;
        </div>
    </div>

	<div class="top">
        <div class="inner p-1 border-y-1">
            <h3>관리자</h3>
            <div class="flex j-space-between">
                <div class="avatar">

                </div>
                <div class="user">
                    <a href="">사용자 아이디</a>
                </div>
            </div>
        </div>
    </div>

    <div class="snb">
        <ul class="top-menu">
            <li>
                <a href="">회원관리</a>
                <ul class="sub-menu">
                    <li><a href="">회원관리 1</a></li>
                    <li><a href="">회원관리 2</a></li>
                </ul>
            </li>
            <li>
                <a href="">게시판 관리</a>
                <ul class="sub-menu">
                    <li><a href="${ root }/admin/posts/cate/index.jsp">카테고리 관리</a></li>
                    <li><a href="${ root }/admin/posts/data/index.jsp">게시물 관리</a></li>
                    <li><a href="${ root }/admin/posts/comments/index.jsp">댓글 관리</a></li>
                </ul>
            </li>
            <li>
                <a href="">파일 관리</a>
                <ul class="sub-menu">
                    <li><a href="">파일 관리</a></li>
                </ul>
            </li>
        </ul>
    </div>

    <div class="bottom border-y-1">

    </div>
</div>