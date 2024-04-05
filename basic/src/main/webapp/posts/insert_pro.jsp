<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="files.dto.Files"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.UUID"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.io.File"%>
<%@page import="posts.service.PostServiceImpl"%>
<%@page import="posts.service.PostService"%>
<%@page import="posts.model.Posts"%>
<%@page import="users.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	// enctype="multipart/form-data" 으로 폼 요청 제출 시,
	// - request.getParameter() 로 받아올 수 없다.
// 	String usersId = request.getParameter("usersId");
// 	String username = request.getParameter("username");
// 	String cateId = request.getParameter("cateId");
// 	String title = request.getParameter("title");
// 	String content = request.getParameter("content");

	// [NEW] - 파일 업로드 추가 
	String path = "E:\\JOEUN\\UPLOAD";
// 	ServletContext context = getServletContext();
// 	String rootPath = context.getRealPath("/");
// 	String path = rootPath + "/UPLOAD";
// 	String path = "/UPLOAD";
	
	
	// DiskFileUpload upload = new DiskFileUpload();
	DiskFileItemFactory factory = new DiskFileItemFactory();
	 
	ServletFileUpload upload = new ServletFileUpload(factory);

	
	upload.setSizeMax(10*1000*1000); 		// 10MB - 파일 최대 크기
	
	// DiskFileUpload 의 @deprecated 관련
	// upload.setSizeThreshold( 4 * 1024 );	// 4MB	- 메모리상의 최대 크기
	// upload.setRepositoryPath(path);		// 임시 저장 경로
	
	List<FileItem> items = upload.parseRequest(request);
	Iterator params = items.iterator();
	
	Posts posts = new Posts();
	String filePath = "";
	List<Files> fileList = new ArrayList<Files>();
		
	while( params.hasNext() ) {
		FileItem item = (FileItem) params.next();
		
		// FileItem
		// .getFieldName()		: 요청 파라미터 이름 - 
		// .getString()			: 요청 파라미터 값   -
		
		String value = item.getString("utf-8");			// P1001
		// 일반 데이터
		if( item.isFormField() ) {
			switch(item.getFieldName()) {
				case "usersId" 		: posts.setUsersId( value );  break;
				case "username" 	: posts.setUsername( value );  break;
				case "cateId" 		: posts.setCateId( value );  break;
				case "title" 		: posts.setTitle( value );  break;
				case "content" 		: posts.setContent( value );  break;
			}
		}
		// 파일 데이터
		else {
			String fileName = item.getName();
			
			if( item == null || fileName == null || fileName == "" ) continue;	// 이미지 없이 업로드한 경우 null 체크
			
			// 파일 정보 객체 생성
			Files files = new Files();
			
			// 파일 중복 방지 - 파일명 : 5a3089e0-22_강아지.jpg
			fileName = UUID.randomUUID().toString().substring(0, 11) + "_" + fileName;
			// 파일 전체 경로 - 파일경로 : E:\\JOEUN\\UPLOAD\\5a3089e0-22_강아지.jpg
			File file = new File(path + "/" + fileName);
			filePath = file.getPath();
			long fileSize = item.getSize();
			
			byte[] fileData = item.getInputStream().readAllBytes();
			
			
			// 파일 정보 객체에 - file, fileItem 저장
			// files.setParentName("posts");	// service 에서 추가
			// files.setParentId();				// posts 가 insert 될 때 생성된다. posts 등록 후 적용
			if( item.getFieldName() != null && item.getFieldName().equals("thumbnail") ) {
				files.setType("thumbnail");
			}
			files.setFile(file);
			files.setFileItem(item);
			files.setFileName(fileName);
			files.setFilePath(filePath);
			files.setFileSize(fileSize);
			files.setFileData(fileData);
			fileList.add(files);
			
			// item.write(file);			// 파일 업로드 (저장)
		}
	}
	
	
	// TODO: 비회원 나중에 고려 (password 가 넘어온경우)
	
	
	// 파일 정보 객체를를 리스트로 담아서 posts 객체에 담고,
	// postService.insert() 안에 파일 업로드 로직 추가
	if( !fileList.isEmpty() ) {
		posts.setFileList(fileList);
	}
	
	// 게시글 쓰기 요청
	PostService postService = new PostServiceImpl();
	int result = postService.insert(posts);
	String root = request.getContextPath(); 
	if( result > 0 ) {
		response.sendRedirect(root + "/posts/list.jsp");
	}
	else {
		response.sendRedirect(root + "/posts/insert.jsp?error");
	}

%>






