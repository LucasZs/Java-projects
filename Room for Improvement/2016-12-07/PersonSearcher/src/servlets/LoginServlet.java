package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis.User;
import mybatis.UserBO;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -2797203905202591860L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doGet(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("id");
		String password = req.getParameter("pw");
		
		if (username == null || password == null || username.equals("") || password.equals("")) {
			resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
			LOGGER.info("Login failed.");
		}
		UserBO userBO = new UserBO();
		User userResult = userBO.selectUser(username, password);
		
		boolean authenticated = false;

		if ((userResult != null && username.equals(userResult.getUserName()) && password.equals(userResult.getPassword()))){
			authenticated = true;
			HttpSession session = req.getSession(true);
			resp.sendRedirect("search.html");
			session.setAttribute("userName", userResult.getUserName());
			LOGGER.info("{} is logged in.", session.getAttribute("userName"));
			
		}
		if (!authenticated) {
			resp.sendError(HttpServletResponse.SC_FORBIDDEN);
			LOGGER.info("Login failed.");
		}

	}
}
