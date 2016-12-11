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

@WebServlet(name = "LogoutServlet", urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 3072492946761177446L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LogoutServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			LOGGER.error("Unauthorized access");
			return;
		}
			
		LOGGER.info("User '{}' is logged out", session.getAttribute("userName"), session.getAttribute("password"));
		session.invalidate();
		response.sendRedirect("index.html");
		}

	}