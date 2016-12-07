package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import person.Person;

@WebServlet(name="SearchServlet", urlPatterns={"/search"})
public class SearchServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(SearchServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null){
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			LOGGER.info("Unauthorized access");
			return;
		}
		
		String searchCriteria = req.getParameter("search");
		PrintWriter out = resp.getWriter();
		
		ArrayList<Person> personList = person.Splitter.createPersonList("C:\\Workspace\\person_reader\\names.txt");
		ArrayList<Person> resultList = new ArrayList<>();
		for (Person p : personList) {
			if(p.getName().startsWith(searchCriteria)){
				resultList.add(p);
			}
		}
		
		for (Person p : resultList) {
			out.println(p + "<br>");
		}
	}
}
