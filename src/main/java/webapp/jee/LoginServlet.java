package webapp.jee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet{

	private UserValidationService service= new UserValidationService(); 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("p", request.getParameter("p"));

		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		boolean isUserValid = service.isUserValid(name, pass);
		
		request.setAttribute("name", name);
		request.setAttribute("password", pass);
		
		if(isUserValid) {
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		}else {
			request.setAttribute("errorMessage", "Invalid");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

		}
	}
	
}
