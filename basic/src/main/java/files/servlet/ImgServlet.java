package files.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import files.dto.Files;
import files.service.FileService;
import files.service.FileServiceImpl;

@WebServlet("/img")
public class ImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 파일
	FileService fileService;
       
    public ImgServlet() {
        super();
        this.fileService = new FileServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 요청 파라미터에서 파일 ID 가져오기
        String fileId = request.getParameter("id");
        
        // 파일 서비스를 사용하여 해당 파일 정보를 가져오기
        Files files = fileService.select(fileId);

    	// 프로젝트 내 img 경로 가져오기
		ServletContext context = getServletContext();
		String imgPath = context.getRealPath("/static/img");

		String id = request.getParameter("id");
		System.out.println("id : " + id);
		
		// 파일 조회
		String file = files.getFilePath();	// 파일 경로
		
		// 파일 이미지가 없을 때, 기본 이미지로 응답
		if( file == null || file.equals("") ) {
			file = imgPath + "/no-image.jpg";
		}
		
		if( file.contains("static/img") ) {
			String rootPath = context.getRealPath("/");
			file = rootPath + "/" + file;
		}
		
		String ext = file.substring( file.lastIndexOf(".") + 1 ).toUpperCase();
		System.out.println("확장자 : " + ext);
		
		String mediaType = "image/jpeg";
		
		switch (ext) {
			case "JPG": 
			case "JPEG": mediaType = "image/jpeg"; break;
			case "PNG" : mediaType = "image/png"; break;
			case "GIF" : mediaType = "image/gif"; break;
			case "WEBP" : mediaType = "image/webp"; break;
		}
		
		response.setContentType( mediaType );		// 이미지 파일로 컨텐츠 타입 지정
		
        try (FileInputStream fis = new FileInputStream(file);
             OutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int data;
            
            while ((data = fis.read(buffer)) != -1) {
                out.write(buffer, 0, data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
