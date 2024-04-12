<%@page import="java.io.File"%>
<%@page import="java.util.UUID"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	String path = "C:\\UPLOAD";
	String path = "E:\\JOEUN\\UPLOAD";

	DiskFileItemFactory factory = new DiskFileItemFactory();
	ServletFileUpload upload = new ServletFileUpload(factory);
	upload.setSizeMax(10*1000*1000); 		// 10MB - 파일 최대 크기
	
	List<FileItem> items = upload.parseRequest(request);
	Iterator params = items.iterator();
	
	while( params.hasNext() ) {
		FileItem item = (FileItem) params.next();
		String value = item.getString("utf-8");
		
		// 일반 데이터
		if( item.isFormField() ) {
			out.println(item.getFieldName() + " : " + value);
		}
		// 파일 데이터
		else {
			String fileName = item.getName();
			String filePath = "";
			
			// 파일 중복 방지 - 파일명 : 5a3089e0-22_강아지.jpg
			fileName = UUID.randomUUID().toString().substring(0, 11) + "_" + fileName;
			// 파일 전체 경로 - 파일경로 : C:\\UPLOAD\\5a3089e0-22_강아지.jpg
			File file = new File(path + "/" + fileName);
			filePath = file.getPath();
			long fileSize = item.getSize();
			
			// 파일 데이터
			byte[] fileData = item.getInputStream().readAllBytes();
			
			// 파일 업로드 (저장)
			item.write(file);			
			out.println("파일 : " + fileName + "<br>");
			out.println("업로드 완료!" + "<br>");
			out.println("---------------------------" + "<br>");
			
		}
	}
	
%>









