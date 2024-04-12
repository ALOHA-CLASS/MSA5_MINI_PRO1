<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>파일 업로드</title>
</head>
<body>
	<h2>파일 업로드</h2>
    <form action="<%= request.getContextPath() %>/upload.jsp" method="post" enctype="multipart/form-data">
        <input type="file" name="file" id="file">
        <button type="submit">업로드</button>
    </form>
</body>
</html>