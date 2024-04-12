package users.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.service.UserService;
import users.service.UserServiceImpl;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/users/idCheck")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserService userService;
	
    public IdCheckServlet() {
        super();
        userService = new UserServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		boolean check = userService.idCheck(username);
		
		if( check ) {
			response.getWriter().append("true");
		}
		else {
			response.getWriter().append("false");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);
	}

}





