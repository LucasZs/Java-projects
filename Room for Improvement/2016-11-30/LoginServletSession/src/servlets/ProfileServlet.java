package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProfileServlet", urlPatterns = { "/profile" })
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = -1464860029613084561L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		if (session != null) {
			if (session.getAttribute("sessionData") != null) {
				String name = (String) session.getAttribute("sessionData");
				out.print(name);

			}
		}
		else {
			response.sendRedirect("login.html");
		}
	}

}