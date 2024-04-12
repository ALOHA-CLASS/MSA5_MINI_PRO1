<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	String room = request.getParameter("room");
%>
<!DOCTYPE html>
<html>
<head>
    <title>WebSocket 채팅</title>
    <script>
    
    	
    	var room = "<%= room %>"
        var socket = new WebSocket("ws://127.0.0.1:8080/ChatRoom/chatting/" + room);

        socket.onopen = function() {
            console.log("WebSocket 연결 성공.");
        };

        socket.onmessage = function(event) {
            console.log("메시지 수신: " + event.data);
        };

        socket.onclose = function() {
            console.log("WebSocket 연결 종료.");
        };

    </script>
</head>
<body>
	<h1>채팅방 : <%= room %></h1>
	<a href="<%= request.getContextPath() %>/room/chat.jsp?room=<%= room %>">입장하기</a>
</body>
</html>





