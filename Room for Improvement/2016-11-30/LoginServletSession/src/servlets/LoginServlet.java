package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -2797203905202591860L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doGet(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("id");
		String password = req.getParameter("pw");
		if (username == null || password == null || username.equals("") || password.equals("")) {
			resp.sendError(HttpServletResponse.SC_FORBIDDEN);
		}

		boolean authenticated = false;

		if (username.equals("lucas") && password.equals("007")) {
			authenticated = true;
			HttpSession session = req.getSession(true);
			String data = "ID: " + username + " PW: " + password;
			session.setAttribute("sessionData", data);
			session.setMaxInactiveInterval(10);
			System.out.println(session.getId());
			resp.sendRedirect("profile.html");
		}
		if (!authenticated) {
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}
}