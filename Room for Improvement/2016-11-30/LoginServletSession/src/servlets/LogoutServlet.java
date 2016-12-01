package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LogoutServlet", urlPatterns = { "/logout" })

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 3072492946761177446L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		System.out.println(session.getId());
			
		if (session != null) {
			session.invalidate();
			response.sendRedirect("logout.html");
		}
		
	}
}