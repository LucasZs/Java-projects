package login;

import java.io.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 8021647905721151594L;
	String username1 = "Lucas";
	String password1 = "Asdf1234";
	String username2 = "Peter";
	String password2 = "Qwert";
	HttpSession session;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		resp.setContentType("text/html");
		String username;
		session = req.getSession();
		try (PrintWriter out = resp.getWriter())
		{
			if(!req.getParameter("username").equals(session.getAttribute("name")))
			{
				if (req.getParameter("username").equals(username1) && req.getParameter("password").equals(password1))
					username = username1;
				else if (req.getParameter("username").equals(username2) && req.getParameter("password").equals(password2))
					username = username2;
				else
				{
					out.println("<HTML><BODY><H1>");
					out.println("Bad username or password! Permission denied.");
					out.println("<br><input type=\"button\" value=\"Retry\" onclick='window.location.href=\"/login/logout\"' style=\"width: 300px; margin: 8px\"><br>");
					out.println("</H1></BODY></HTML>");
					return;
				}
				out.println("<HTML><BODY><H1>");
				out.println("Welcome " + username + "! Have a nice day!");
				out.println("<br><input type=\"button\" value=\"Log out\" onclick='window.location.href=\"/login/logout\"' style=\"width: 300px; margin: 8px\"><br>");
				out.println("</H1></BODY></HTML>");
				session.setAttribute("name", username);
			}
			else
			{
				out.println("<HTML><BODY>");
				out.print("<h1>You already logged in!</h1><input type=\"button\" value=\"Log out\" onclick='window.location.href=\"/login/logout\"' style=\"width: 300px; margin: 8px\">");
				out.println("</BODY></HTML>");
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	{
		String username = req.getSession().getAttribute("name").toString();
		if(username.equals("")){
			username = "Nobody is logged in!";
		}
		try {
			resp.getWriter().println(username);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
