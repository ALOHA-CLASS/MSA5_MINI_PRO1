package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.RequestUtil;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");

		
		response.setContentType("text/html");
		response.getWriter().append("id : ").append(id).append(", name : ").append(name);
		
		System.out.println("request - Content-Type : " + request.getContentType());
		System.out.println("response - Content-Type : " + response.getContentType());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// BufferedReader body = request.getReader();
		// String charset = request.getCharacterEncoding();
		// Map<String, String> requestMap = RequestUtil.bodyToMap(body, charset);
		Map<String, String> requestMap = RequestUtil.bodyToMap(request.getReader());
		
		String id = requestMap.get("id");
		String name = requestMap.get("name");
		
		// response.getWriter().append("id : ").append(id).append(", name : ").append(name);
		
		// json 형식으로
		response.setContentType("application/json");
		String pattern = "\"id\" : \"{0}\", \"name\": \"{1}\"";
		Object[] args = {id, name};
		String json = MessageFormat.format(pattern, args);
		json = "{ " + json + " }";
		response.getWriter().append(json);
		
		System.out.println("request - Content-Type : " + request.getContentType());
		System.out.println("response - Content-Type : " + response.getContentType());
	}

}







