<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%= request.getContextPath() %>/TestServlet">테스트</a>
	<form action="<%= request.getContextPath() %>/TestServlet" method="post">
		<input type="text" name="id" id="id" />
		<input type="text" name="name" id="name" />
		<input type="submit" value="등록" />
	</form>
	<button type="button" id="btn" onclick="btnClick()">AJAX</button>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script>
		
		$(function() {
			
		})
		
		
		function btnClick() {
			
				let root = "<%= request.getContextPath() %>"
				let url = root + "/TestServlet" 

	            let id = $('#id').val()
	            let name = $('#name').val()

	            let data = {
	                'id' 	: id,
	                'name'	: name,
	            }

	            // jQuery 로 AJAX 요청
	            $.ajax({
	                type            : 'POST',                 // 요청 메소드
	                url             : url,                    // 요청 URL
// 	                data            : JSON.stringify(data),   // 요청 데이터
	                data            : data,   // 요청 데이터
	                contentType     : 'application/json; charset=UTF-8',     // 요청 데이터 타입
	                dataType        : 'html',                 // 응답 데이터 타입
	                // 요청 성공 
	                success         : function(response, status) {
	                    // response : 응답 데이터
	                    // status   : 응답 상태
	                    let json = JSON.parse(response)
	                    alert(response)
	                    alert(json.id)
	                    alert(json.name)
	                },
	                // 에러
	                error           : function(xhr, status) {
	                    // xhr      : XMLHttpRequest 객체
	                    // status   : 응답 상태
	                    alert('에러 발생')
	                }
	                
	            })
		}
	
	</script>
</body>
</html>