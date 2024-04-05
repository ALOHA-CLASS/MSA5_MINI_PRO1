package files.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import files.dto.Files;
import files.service.FileService;
import files.service.FileServiceImpl;

@WebServlet("/file")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 파일
	FileService fileService;
	
       
    public FileServlet() {
        super();
        this.fileService = new FileServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 파라미터에서 파일 ID 가져오기
        String fileId = request.getParameter("id");
        
        // 파일 서비스를 사용하여 해당 파일 정보를 가져오기
        Files files = fileService.select(fileId);
        
        // 파일이 존재하지 않는 경우 에러 처리
        if (files == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        // 파일 내용을 읽어와서 응답으로 전송하기
        try (InputStream inputStream = new FileInputStream(files.getFilePath())) {
            // 파일 이름 설정
            String fileName = files.getFileName();
            
            // 응답 헤더 설정
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            
            // 파일 내용을 읽어와 응답으로 전송
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            
            outputStream.close();
        } catch (FileNotFoundException e) {
            // 파일을 찾을 수 없는 경우 에러 처리
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } catch (IOException e) {
            // 다른 IO 에러가 발생한 경우 에러 처리
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}












